package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.drawable.BackgroundDrawable;
import com.facebook.react.uimanager.drawable.BorderDrawable;
import com.facebook.react.uimanager.drawable.CSSBackgroundDrawable;
import com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable;
import com.facebook.react.uimanager.drawable.InsetBoxShadowDrawable;
import com.facebook.react.uimanager.drawable.OutlineDrawable;
import com.facebook.react.uimanager.drawable.OutsetBoxShadowDrawable;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.BoxShadow;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.uimanager.style.OutlineStyle;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class BackgroundStyleApplicator {
    public static final void a(View view, Canvas canvas) {
        RectF rectFA;
        ComputedBorderRadius computedBorderRadiusD;
        CornerRadii cornerRadii;
        CornerRadii cornerRadii2;
        CornerRadii cornerRadii3;
        CornerRadii cornerRadii4;
        CornerRadii cornerRadii5;
        CornerRadii cornerRadii6;
        CornerRadii cornerRadii7;
        CornerRadii cornerRadii8;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Path path = null;
        if (!ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            Drawable background = view.getBackground();
            CompositeBackgroundDrawable compositeBackgroundDrawable = background instanceof CompositeBackgroundDrawable ? (CompositeBackgroundDrawable) background : null;
            CSSBackgroundDrawable cSSBackgroundDrawable = compositeBackgroundDrawable != null ? compositeBackgroundDrawable.f19669c : null;
            if (cSSBackgroundDrawable == null) {
                canvas.clipRect(rect);
                return;
            }
            if (cSSBackgroundDrawable.y.c()) {
                cSSBackgroundDrawable.k();
                Path path2 = cSSBackgroundDrawable.f19657e;
                path2.getClass();
                path = new Path(path2);
            }
            if (path != null) {
                path.offset(rect.left, rect.top);
                canvas.clipPath(path);
                return;
            }
            RectF rectFE = cSSBackgroundDrawable.e();
            RectF rectF = new RectF(rectFE.left, rectFE.top, cSSBackgroundDrawable.getBounds().width() - rectFE.right, cSSBackgroundDrawable.getBounds().height() - rectFE.bottom);
            Intrinsics.checkNotNullExpressionValue(rectF, "getPaddingBoxRect(...)");
            rectF.offset(rect.left, rect.top);
            canvas.clipRect(rectF);
            return;
        }
        view.getDrawingRect(new Rect());
        CompositeBackgroundDrawable compositeBackgroundDrawableE = e(view);
        RectF rectF2 = new RectF();
        BorderInsets borderInsets = compositeBackgroundDrawableE.f19676j;
        if (borderInsets != null) {
            int layoutDirection = compositeBackgroundDrawableE.getLayoutDirection();
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            rectFA = borderInsets.a(layoutDirection, context);
        } else {
            rectFA = null;
        }
        rectF2.left = compositeBackgroundDrawableE.getBounds().left + (rectFA != null ? PixelUtil.b(rectFA.left) : 0.0f);
        rectF2.top = compositeBackgroundDrawableE.getBounds().top + (rectFA != null ? PixelUtil.b(rectFA.top) : 0.0f);
        rectF2.right = compositeBackgroundDrawableE.getBounds().right - (rectFA != null ? PixelUtil.b(rectFA.right) : 0.0f);
        rectF2.bottom = compositeBackgroundDrawableE.getBounds().bottom - (rectFA != null ? PixelUtil.b(rectFA.bottom) : 0.0f);
        BorderRadiusStyle borderRadiusStyle = compositeBackgroundDrawableE.f19677k;
        if (borderRadiusStyle == null || !borderRadiusStyle.c()) {
            rectF2.offset(r1.left, r1.top);
            canvas.clipRect(rectF2);
            return;
        }
        BorderRadiusStyle borderRadiusStyle2 = compositeBackgroundDrawableE.f19677k;
        if (borderRadiusStyle2 != null) {
            int layoutDirection2 = compositeBackgroundDrawableE.getLayoutDirection();
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            computedBorderRadiusD = borderRadiusStyle2.d(layoutDirection2, context2, PixelUtil.a(compositeBackgroundDrawableE.getBounds().width()), PixelUtil.a(compositeBackgroundDrawableE.getBounds().height()));
        } else {
            computedBorderRadiusD = null;
        }
        Path path3 = new Path();
        path3.addRoundRect(rectF2, new float[]{h((computedBorderRadiusD == null || (cornerRadii8 = computedBorderRadiusD.f19873a) == null) ? null : Float.valueOf(PixelUtil.b(cornerRadii8.f19879a)), rectFA != null ? Float.valueOf(PixelUtil.b(rectFA.left)) : null), h((computedBorderRadiusD == null || (cornerRadii7 = computedBorderRadiusD.f19873a) == null) ? null : Float.valueOf(PixelUtil.b(cornerRadii7.f19880b)), rectFA != null ? Float.valueOf(PixelUtil.b(rectFA.top)) : null), h((computedBorderRadiusD == null || (cornerRadii6 = computedBorderRadiusD.f19874b) == null) ? null : Float.valueOf(PixelUtil.b(cornerRadii6.f19879a)), rectFA != null ? Float.valueOf(PixelUtil.b(rectFA.right)) : null), h((computedBorderRadiusD == null || (cornerRadii5 = computedBorderRadiusD.f19874b) == null) ? null : Float.valueOf(PixelUtil.b(cornerRadii5.f19880b)), rectFA != null ? Float.valueOf(PixelUtil.b(rectFA.top)) : null), h((computedBorderRadiusD == null || (cornerRadii4 = computedBorderRadiusD.f19876d) == null) ? null : Float.valueOf(PixelUtil.b(cornerRadii4.f19879a)), rectFA != null ? Float.valueOf(PixelUtil.b(rectFA.right)) : null), h((computedBorderRadiusD == null || (cornerRadii3 = computedBorderRadiusD.f19876d) == null) ? null : Float.valueOf(PixelUtil.b(cornerRadii3.f19880b)), rectFA != null ? Float.valueOf(PixelUtil.b(rectFA.bottom)) : null), h((computedBorderRadiusD == null || (cornerRadii2 = computedBorderRadiusD.f19875c) == null) ? null : Float.valueOf(PixelUtil.b(cornerRadii2.f19879a)), rectFA != null ? Float.valueOf(PixelUtil.b(rectFA.left)) : null), h((computedBorderRadiusD == null || (cornerRadii = computedBorderRadiusD.f19875c) == null) ? null : Float.valueOf(PixelUtil.b(cornerRadii.f19880b)), rectFA != null ? Float.valueOf(PixelUtil.b(rectFA.bottom)) : null)}, Path.Direction.CW);
        path3.offset(r1.left, r1.top);
        canvas.clipPath(path3);
    }

    public static BackgroundDrawable b(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableE = e(view);
        BackgroundDrawable backgroundDrawable = compositeBackgroundDrawableE.f19671e;
        if (backgroundDrawable != null) {
            return backgroundDrawable;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BackgroundDrawable backgroundDrawable2 = new BackgroundDrawable(context, compositeBackgroundDrawableE.f19677k, compositeBackgroundDrawableE.f19676j);
        view.setBackground(compositeBackgroundDrawableE.c(backgroundDrawable2));
        return backgroundDrawable2;
    }

    public static BorderDrawable c(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableE = e(view);
        BorderDrawable borderDrawable = compositeBackgroundDrawableE.f19672f;
        if (borderDrawable != null) {
            return borderDrawable;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        BorderRadiusStyle borderRadiusStyle = compositeBackgroundDrawableE.f19677k;
        Spacing spacing = new Spacing(0.0f);
        BorderStyle.Companion companion = BorderStyle.f19856a;
        BorderDrawable borderDrawable2 = new BorderDrawable(context, spacing, borderRadiusStyle, compositeBackgroundDrawableE.f19676j);
        view.setBackground(compositeBackgroundDrawableE.d(borderDrawable2));
        return borderDrawable2;
    }

    public static CSSBackgroundDrawable d(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableE = e(view);
        CSSBackgroundDrawable cSSBackgroundDrawable = compositeBackgroundDrawableE.f19669c;
        if (cSSBackgroundDrawable != null) {
            return cSSBackgroundDrawable;
        }
        CSSBackgroundDrawable cSSBackgroundDrawable2 = new CSSBackgroundDrawable(view.getContext());
        CompositeBackgroundDrawable compositeBackgroundDrawable = new CompositeBackgroundDrawable(compositeBackgroundDrawableE.f19667a, compositeBackgroundDrawableE.f19668b, compositeBackgroundDrawableE.f19670d, cSSBackgroundDrawable2, compositeBackgroundDrawableE.f19671e, compositeBackgroundDrawableE.f19672f, compositeBackgroundDrawableE.f19673g, compositeBackgroundDrawableE.f19674h, compositeBackgroundDrawableE.f19675i);
        compositeBackgroundDrawable.f19676j = compositeBackgroundDrawableE.f19676j;
        compositeBackgroundDrawable.f19677k = compositeBackgroundDrawableE.f19677k;
        view.setBackground(compositeBackgroundDrawable);
        return cSSBackgroundDrawable2;
    }

    public static CompositeBackgroundDrawable e(View view) {
        if (view.getBackground() instanceof CompositeBackgroundDrawable) {
            Drawable background = view.getBackground();
            Intrinsics.d(background, "null cannot be cast to non-null type com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable");
            return (CompositeBackgroundDrawable) background;
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        CompositeBackgroundDrawable compositeBackgroundDrawable = new CompositeBackgroundDrawable(context, view.getBackground(), null, null, null, null, null, null, null);
        view.setBackground(compositeBackgroundDrawable);
        return compositeBackgroundDrawable;
    }

    public static OutlineDrawable f(View view) {
        CompositeBackgroundDrawable compositeBackgroundDrawableE = e(view);
        OutlineDrawable outlineDrawable = compositeBackgroundDrawableE.f19675i;
        if (outlineDrawable != null) {
            return outlineDrawable;
        }
        BorderRadiusStyle borderRadiusStyle = ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables() ? compositeBackgroundDrawableE.f19677k : d(view).y;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        OutlineStyle.Companion companion = OutlineStyle.f19911a;
        OutlineDrawable outlineDrawable2 = new OutlineDrawable(context, borderRadiusStyle);
        view.setBackground(compositeBackgroundDrawableE.i(outlineDrawable2));
        return outlineDrawable2;
    }

    public static final Integer g(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            Drawable background = view.getBackground();
            CompositeBackgroundDrawable compositeBackgroundDrawable = background instanceof CompositeBackgroundDrawable ? (CompositeBackgroundDrawable) background : null;
            BackgroundDrawable backgroundDrawable = compositeBackgroundDrawable != null ? compositeBackgroundDrawable.f19671e : null;
            if (backgroundDrawable != null) {
                return Integer.valueOf(backgroundDrawable.a());
            }
        } else {
            Drawable background2 = view.getBackground();
            CompositeBackgroundDrawable compositeBackgroundDrawable2 = background2 instanceof CompositeBackgroundDrawable ? (CompositeBackgroundDrawable) background2 : null;
            CSSBackgroundDrawable cSSBackgroundDrawable = compositeBackgroundDrawable2 != null ? compositeBackgroundDrawable2.f19669c : null;
            if (cSSBackgroundDrawable != null) {
                return Integer.valueOf(cSSBackgroundDrawable.v);
            }
        }
        return null;
    }

    public static float h(Float f2, Float f3) {
        float fFloatValue = (f2 != null ? f2.floatValue() : 0.0f) - (f3 != null ? f3.floatValue() : 0.0f);
        if (fFloatValue < 0.0f) {
            return 0.0f;
        }
        return fFloatValue;
    }

    public static final void i(View view, Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (num.intValue() != 0 || (view.getBackground() instanceof CompositeBackgroundDrawable)) {
            if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
                b(view).b(num.intValue());
                return;
            }
            CSSBackgroundDrawable cSSBackgroundDrawableD = d(view);
            cSSBackgroundDrawableD.v = num.intValue();
            cSSBackgroundDrawableD.invalidateSelf();
        }
    }

    public static final void j(ReactViewGroup view, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            b(view).c(arrayList);
            return;
        }
        CSSBackgroundDrawable cSSBackgroundDrawableD = d(view);
        cSSBackgroundDrawableD.w = arrayList;
        cSSBackgroundDrawableD.invalidateSelf();
    }

    public static final void k(View view, LogicalEdge edge, Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            c(view).h(edge, num);
            return;
        }
        CSSBackgroundDrawable cSSBackgroundDrawableD = d(view);
        int iA = edge.a();
        float fIntValue = num == null ? Float.NaN : num.intValue() & 16777215;
        float fIntValue2 = num != null ? num.intValue() >>> 24 : Float.NaN;
        if (cSSBackgroundDrawableD.f19654b == null) {
            cSSBackgroundDrawableD.f19654b = new Spacing(0.0f);
        }
        if (!FloatUtil.a(cSSBackgroundDrawableD.f19654b.f19476b[iA], fIntValue)) {
            cSSBackgroundDrawableD.f19654b.b(fIntValue, iA);
            cSSBackgroundDrawableD.invalidateSelf();
        }
        if (cSSBackgroundDrawableD.f19655c == null) {
            cSSBackgroundDrawableD.f19655c = new Spacing(255.0f);
        }
        if (!FloatUtil.a(cSSBackgroundDrawableD.f19655c.f19476b[iA], fIntValue2)) {
            cSSBackgroundDrawableD.f19655c.b(fIntValue2, iA);
            cSSBackgroundDrawableD.invalidateSelf();
        }
        cSSBackgroundDrawableD.t = true;
    }

    public static final void l(View view, BorderRadiusProp corner, LengthPercentage lengthPercentage) {
        LayerDrawable layerDrawable;
        LayerDrawable layerDrawable2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(corner, "corner");
        CompositeBackgroundDrawable compositeBackgroundDrawableE = e(view);
        BorderRadiusStyle borderRadiusStyle = compositeBackgroundDrawableE.f19677k;
        if (borderRadiusStyle == null) {
            borderRadiusStyle = new BorderRadiusStyle(0);
        }
        compositeBackgroundDrawableE.f19677k = borderRadiusStyle;
        borderRadiusStyle.e(corner, lengthPercentage);
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            if (view instanceof ImageView) {
                b(view);
            }
            BackgroundDrawable backgroundDrawable = compositeBackgroundDrawableE.f19671e;
            if (backgroundDrawable != null) {
                backgroundDrawable.e(compositeBackgroundDrawableE.f19677k);
            }
            BorderDrawable borderDrawable = compositeBackgroundDrawableE.f19672f;
            if (borderDrawable != null) {
                borderDrawable.j(compositeBackgroundDrawableE.f19677k);
            }
            BackgroundDrawable backgroundDrawable2 = compositeBackgroundDrawableE.f19671e;
            if (backgroundDrawable2 != null) {
                backgroundDrawable2.invalidateSelf();
            }
            BorderDrawable borderDrawable2 = compositeBackgroundDrawableE.f19672f;
            if (borderDrawable2 != null) {
                borderDrawable2.invalidateSelf();
            }
        } else {
            CSSBackgroundDrawable cSSBackgroundDrawableD = d(view);
            BorderRadiusStyle borderRadiusStyle2 = cSSBackgroundDrawableD.y;
            if (!Objects.equals(lengthPercentage, borderRadiusStyle2.b(corner))) {
                borderRadiusStyle2.e(corner, lengthPercentage);
                cSSBackgroundDrawableD.t = true;
                cSSBackgroundDrawableD.invalidateSelf();
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && (layerDrawable2 = compositeBackgroundDrawableE.f19670d) != null) {
            int numberOfLayers = layerDrawable2.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                Drawable drawable = layerDrawable2.getDrawable(i2);
                if (drawable instanceof OutsetBoxShadowDrawable) {
                    OutsetBoxShadowDrawable outsetBoxShadowDrawable = (OutsetBoxShadowDrawable) drawable;
                    BorderRadiusStyle borderRadiusStyleA = outsetBoxShadowDrawable.a();
                    if (borderRadiusStyleA == null) {
                        borderRadiusStyleA = new BorderRadiusStyle(0);
                    }
                    outsetBoxShadowDrawable.b(borderRadiusStyleA);
                    BorderRadiusStyle borderRadiusStyleA2 = outsetBoxShadowDrawable.a();
                    if (borderRadiusStyleA2 != null) {
                        borderRadiusStyleA2.e(corner, lengthPercentage);
                    }
                    outsetBoxShadowDrawable.invalidateSelf();
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29 && (layerDrawable = compositeBackgroundDrawableE.f19674h) != null) {
            int numberOfLayers2 = layerDrawable.getNumberOfLayers();
            for (int i3 = 0; i3 < numberOfLayers2; i3++) {
                Drawable drawable2 = layerDrawable.getDrawable(i3);
                if (drawable2 instanceof InsetBoxShadowDrawable) {
                    InsetBoxShadowDrawable insetBoxShadowDrawable = (InsetBoxShadowDrawable) drawable2;
                    BorderRadiusStyle borderRadiusStyleA3 = insetBoxShadowDrawable.a();
                    if (borderRadiusStyleA3 == null) {
                        borderRadiusStyleA3 = new BorderRadiusStyle(0);
                    }
                    insetBoxShadowDrawable.d(borderRadiusStyleA3);
                    BorderRadiusStyle borderRadiusStyleA4 = insetBoxShadowDrawable.a();
                    if (borderRadiusStyleA4 != null) {
                        borderRadiusStyleA4.e(corner, lengthPercentage);
                    }
                    insetBoxShadowDrawable.invalidateSelf();
                }
            }
        }
        OutlineDrawable outlineDrawable = compositeBackgroundDrawableE.f19675i;
        if (outlineDrawable != null) {
            outlineDrawable.c(compositeBackgroundDrawableE.f19677k);
        }
        compositeBackgroundDrawableE.invalidateSelf();
    }

    public static final void m(View view, BorderStyle borderStyle) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            c(view).k(borderStyle);
            return;
        }
        CSSBackgroundDrawable cSSBackgroundDrawableD = d(view);
        if (cSSBackgroundDrawableD.f19656d != borderStyle) {
            cSSBackgroundDrawableD.f19656d = borderStyle;
            cSSBackgroundDrawableD.t = true;
            cSSBackgroundDrawableD.invalidateSelf();
        }
    }

    public static final void n(View view, LogicalEdge edge, Float f2) {
        LayerDrawable layerDrawable;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(edge, "edge");
        CompositeBackgroundDrawable compositeBackgroundDrawableE = e(view);
        BorderInsets borderInsets = compositeBackgroundDrawableE.f19676j;
        if (borderInsets == null) {
            borderInsets = new BorderInsets();
        }
        compositeBackgroundDrawableE.f19676j = borderInsets;
        borderInsets.b(edge, f2);
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            c(view).l(edge.a(), PixelUtil.b(f2.floatValue()));
            BackgroundDrawable backgroundDrawable = compositeBackgroundDrawableE.f19671e;
            if (backgroundDrawable != null) {
                backgroundDrawable.d(compositeBackgroundDrawableE.f19676j);
            }
            BorderDrawable borderDrawable = compositeBackgroundDrawableE.f19672f;
            if (borderDrawable != null) {
                borderDrawable.i(compositeBackgroundDrawableE.f19676j);
            }
            BackgroundDrawable backgroundDrawable2 = compositeBackgroundDrawableE.f19671e;
            if (backgroundDrawable2 != null) {
                backgroundDrawable2.invalidateSelf();
            }
            BorderDrawable borderDrawable2 = compositeBackgroundDrawableE.f19672f;
            if (borderDrawable2 != null) {
                borderDrawable2.invalidateSelf();
            }
        } else {
            CSSBackgroundDrawable cSSBackgroundDrawableD = d(view);
            int iA = edge.a();
            float fB = PixelUtil.b(f2.floatValue());
            if (cSSBackgroundDrawableD.f19653a == null) {
                cSSBackgroundDrawableD.f19653a = new Spacing();
            }
            if (!FloatUtil.a(cSSBackgroundDrawableD.f19653a.f19476b[iA], fB)) {
                cSSBackgroundDrawableD.f19653a.b(fB, iA);
                if (iA == 0 || iA == 1 || iA == 2 || iA == 3 || iA == 4 || iA == 5 || iA == 8) {
                    cSSBackgroundDrawableD.t = true;
                }
                cSSBackgroundDrawableD.invalidateSelf();
            }
        }
        BorderInsets borderInsets2 = compositeBackgroundDrawableE.f19676j;
        if (borderInsets2 == null) {
            borderInsets2 = new BorderInsets();
        }
        compositeBackgroundDrawableE.f19676j = borderInsets2;
        borderInsets2.b(edge, f2);
        if (Build.VERSION.SDK_INT < 29 || (layerDrawable = compositeBackgroundDrawableE.f19674h) == null) {
            return;
        }
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            Drawable drawable = layerDrawable.getDrawable(i2);
            Intrinsics.d(drawable, "null cannot be cast to non-null type com.facebook.react.uimanager.drawable.InsetBoxShadowDrawable");
            InsetBoxShadowDrawable insetBoxShadowDrawable = (InsetBoxShadowDrawable) drawable;
            insetBoxShadowDrawable.c(compositeBackgroundDrawableE.f19676j);
            insetBoxShadowDrawable.invalidateSelf();
        }
    }

    public static final void o(View view, List shadows) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(shadows, "shadows");
        if (ViewUtil.b(view) != 2) {
            return;
        }
        CompositeBackgroundDrawable compositeBackgroundDrawableE = e(view);
        BorderInsets borderInsets = compositeBackgroundDrawableE.f19676j;
        BorderRadiusStyle borderRadiusStyle = compositeBackgroundDrawableE.f19677k;
        LayerDrawable layerDrawable = null;
        LayerDrawable layerDrawable2 = null;
        for (BoxShadow boxShadow : CollectionsKt.l(shadows)) {
            float fD = boxShadow.d();
            float fE = boxShadow.e();
            Integer numB = boxShadow.b();
            int iIntValue = numB != null ? numB.intValue() : -16777216;
            Float fA = boxShadow.a();
            float fFloatValue = fA != null ? fA.floatValue() : 0.0f;
            Float f2 = boxShadow.f();
            float fFloatValue2 = f2 != null ? f2.floatValue() : 0.0f;
            Boolean boolC = boxShadow.c();
            boolean zBooleanValue = boolC != null ? boolC.booleanValue() : false;
            if (!zBooleanValue || Build.VERSION.SDK_INT < 29) {
                BorderRadiusStyle borderRadiusStyle2 = borderRadiusStyle;
                if (!zBooleanValue && Build.VERSION.SDK_INT >= 28) {
                    LayerDrawable layerDrawable3 = layerDrawable2 == null ? new LayerDrawable(new Drawable[0]) : layerDrawable2;
                    Context context = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    layerDrawable3.addLayer(new OutsetBoxShadowDrawable(context, iIntValue, fD, fE, fFloatValue, fFloatValue2, borderRadiusStyle2));
                    layerDrawable2 = layerDrawable3;
                }
                borderRadiusStyle = borderRadiusStyle2;
            } else {
                if (layerDrawable == null) {
                    layerDrawable = new LayerDrawable(new Drawable[0]);
                }
                LayerDrawable layerDrawable4 = layerDrawable;
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                layerDrawable4.addLayer(new InsetBoxShadowDrawable(context2, iIntValue, fD, fE, fFloatValue, fFloatValue2, borderInsets, borderRadiusStyle));
                layerDrawable = layerDrawable4;
            }
        }
        view.setBackground(e(view).h(layerDrawable2));
        view.setBackground(e(view).f(layerDrawable));
    }

    public static final void p(ReactViewGroup view, Drawable drawable) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            e(view).e(drawable);
        } else {
            view.setBackground(e(view).e(drawable));
        }
    }
}
