package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

@Metadata
/* loaded from: classes.dex */
public final class CompositeBackgroundDrawable extends LayerDrawable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19667a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f19668b;

    /* renamed from: c, reason: collision with root package name */
    public final CSSBackgroundDrawable f19669c;

    /* renamed from: d, reason: collision with root package name */
    public LayerDrawable f19670d;

    /* renamed from: e, reason: collision with root package name */
    public BackgroundDrawable f19671e;

    /* renamed from: f, reason: collision with root package name */
    public BorderDrawable f19672f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f19673g;

    /* renamed from: h, reason: collision with root package name */
    public LayerDrawable f19674h;

    /* renamed from: i, reason: collision with root package name */
    public OutlineDrawable f19675i;

    /* renamed from: j, reason: collision with root package name */
    public BorderInsets f19676j;

    /* renamed from: k, reason: collision with root package name */
    public BorderRadiusStyle f19677k;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompositeBackgroundDrawable(Context context, Drawable drawable, LayerDrawable layerDrawable, CSSBackgroundDrawable cSSBackgroundDrawable, BackgroundDrawable backgroundDrawable, BorderDrawable borderDrawable, Drawable drawable2, LayerDrawable layerDrawable2, OutlineDrawable outlineDrawable) {
        super(new Drawable[0]);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f19667a = context;
        this.f19668b = drawable;
        this.f19669c = cSSBackgroundDrawable;
        this.f19670d = layerDrawable;
        this.f19671e = backgroundDrawable;
        this.f19672f = borderDrawable;
        this.f19673g = drawable2;
        this.f19674h = layerDrawable2;
        this.f19675i = outlineDrawable;
        setPaddingMode(1);
        a(drawable, 0);
        a(layerDrawable, 1);
        a(cSSBackgroundDrawable, 2);
        a(backgroundDrawable, 3);
        a(borderDrawable, 4);
        a(drawable2, 5);
        a(layerDrawable2, 6);
        a(outlineDrawable, 7);
    }

    public final void a(Drawable drawable, int i2) {
        if (drawable == null) {
            return;
        }
        addLayer(drawable);
        drawable.setCallback(this);
        setId(getNumberOfLayers() - 1, i2);
        invalidateSelf();
    }

    public final void b(Drawable drawable, int i2) {
        if (drawable == null) {
            return;
        }
        if (getNumberOfLayers() == 0) {
            a(drawable, i2);
            return;
        }
        int numberOfLayers = getNumberOfLayers();
        for (int i3 = 0; i3 < numberOfLayers; i3++) {
            if (i2 < getId(i3)) {
                Drawable drawable2 = getDrawable(i3);
                Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(...)");
                int id = getId(i3);
                setDrawable(i3, drawable);
                setId(i3, i2);
                b(drawable2, id);
                return;
            }
            if (i3 == getNumberOfLayers() - 1) {
                a(drawable, i2);
                return;
            }
        }
    }

    public final CompositeBackgroundDrawable c(BackgroundDrawable backgroundDrawable) {
        return g(backgroundDrawable, 3, new CompositeBackgroundDrawable$withNewBackground$1(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewBackground$2
            {
                super(this, CompositeBackgroundDrawable.class, AppStateModule.APP_STATE_BACKGROUND, "getBackground()Lcom/facebook/react/uimanager/drawable/BackgroundDrawable;", 0);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).f19671e;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public final void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).f19671e = (BackgroundDrawable) obj;
            }
        }));
    }

    public final CompositeBackgroundDrawable d(BorderDrawable borderDrawable) {
        return g(borderDrawable, 4, new CompositeBackgroundDrawable$withNewBorder$1(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewBorder$2
            {
                super(this, CompositeBackgroundDrawable.class, "border", "getBorder()Lcom/facebook/react/uimanager/drawable/BorderDrawable;", 0);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).f19672f;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public final void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).f19672f = (BorderDrawable) obj;
            }
        }));
    }

    public final CompositeBackgroundDrawable e(Drawable drawable) {
        return g(drawable, 5, new CompositeBackgroundDrawable$withNewFeedbackUnderlay$1(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewFeedbackUnderlay$2
            {
                super(this, CompositeBackgroundDrawable.class, "feedbackUnderlay", "getFeedbackUnderlay()Landroid/graphics/drawable/Drawable;", 0);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).f19673g;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public final void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).f19673g = (Drawable) obj;
            }
        }));
    }

    public final CompositeBackgroundDrawable f(LayerDrawable layerDrawable) {
        return g(layerDrawable, 6, new CompositeBackgroundDrawable$withNewInnerShadow$1(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewInnerShadow$2
            {
                super(this, CompositeBackgroundDrawable.class, "innerShadows", "getInnerShadows()Landroid/graphics/drawable/LayerDrawable;", 0);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).f19674h;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public final void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).f19674h = (LayerDrawable) obj;
            }
        }));
    }

    public final CompositeBackgroundDrawable g(Drawable drawable, int i2, Function1 function1) {
        function1.invoke(drawable);
        if (ReactNativeFeatureFlags.f18968a.enableNewBackgroundAndBorderDrawables()) {
            if (drawable != null) {
                if (findDrawableByLayerId(i2) == null) {
                    b(drawable, i2);
                } else {
                    setDrawableByLayerId(i2, drawable);
                }
                invalidateSelf();
                return this;
            }
            if (findDrawableByLayerId(i2) == null) {
                return this;
            }
        }
        LayerDrawable layerDrawable = this.f19670d;
        BackgroundDrawable backgroundDrawable = this.f19671e;
        BorderDrawable borderDrawable = this.f19672f;
        Drawable drawable2 = this.f19673g;
        LayerDrawable layerDrawable2 = this.f19674h;
        OutlineDrawable outlineDrawable = this.f19675i;
        CompositeBackgroundDrawable compositeBackgroundDrawable = new CompositeBackgroundDrawable(this.f19667a, this.f19668b, layerDrawable, this.f19669c, backgroundDrawable, borderDrawable, drawable2, layerDrawable2, outlineDrawable);
        compositeBackgroundDrawable.f19676j = this.f19676j;
        compositeBackgroundDrawable.f19677k = this.f19677k;
        return compositeBackgroundDrawable;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Intrinsics.checkNotNullParameter(outline, "outline");
        BorderRadiusStyle borderRadiusStyle = this.f19677k;
        if (borderRadiusStyle == null || !borderRadiusStyle.c()) {
            outline.setRect(getBounds());
            return;
        }
        Path path = new Path();
        BorderRadiusStyle borderRadiusStyle2 = this.f19677k;
        Context context = this.f19667a;
        ComputedBorderRadius computedBorderRadiusD = borderRadiusStyle2 != null ? borderRadiusStyle2.d(getLayoutDirection(), context, getBounds().width(), getBounds().height()) : null;
        BorderInsets borderInsets = this.f19676j;
        RectF rectFA = borderInsets != null ? borderInsets.a(getLayoutDirection(), context) : null;
        if (computedBorderRadiusD != null) {
            RectF rectF = new RectF(getBounds());
            CornerRadii cornerRadii = computedBorderRadiusD.f19873a;
            float fB = PixelUtil.b(cornerRadii.f19879a + (rectFA != null ? rectFA.left : 0.0f));
            float fB2 = PixelUtil.b(cornerRadii.f19880b + (rectFA != null ? rectFA.top : 0.0f));
            CornerRadii cornerRadii2 = computedBorderRadiusD.f19874b;
            float fB3 = PixelUtil.b(cornerRadii2.f19879a + (rectFA != null ? rectFA.right : 0.0f));
            float fB4 = PixelUtil.b(cornerRadii2.f19880b + (rectFA != null ? rectFA.top : 0.0f));
            CornerRadii cornerRadii3 = computedBorderRadiusD.f19876d;
            float fB5 = PixelUtil.b(cornerRadii3.f19879a + (rectFA != null ? rectFA.right : 0.0f));
            float fB6 = PixelUtil.b(cornerRadii3.f19880b + (rectFA != null ? rectFA.bottom : 0.0f));
            CornerRadii cornerRadii4 = computedBorderRadiusD.f19875c;
            path.addRoundRect(rectF, new float[]{fB, fB2, fB3, fB4, fB5, fB6, PixelUtil.b(cornerRadii4.f19879a + (rectFA != null ? rectFA.left : 0.0f)), PixelUtil.b(cornerRadii4.f19880b + (rectFA != null ? rectFA.bottom : 0.0f))}, Path.Direction.CW);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            outline.setPath(path);
        } else {
            outline.setConvexPath(path);
        }
    }

    public final CompositeBackgroundDrawable h(LayerDrawable layerDrawable) {
        return g(layerDrawable, 1, new CompositeBackgroundDrawable$withNewOuterShadow$1(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewOuterShadow$2
            {
                super(this, CompositeBackgroundDrawable.class, "outerShadows", "getOuterShadows()Landroid/graphics/drawable/LayerDrawable;", 0);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).f19670d;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public final void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).f19670d = (LayerDrawable) obj;
            }
        }));
    }

    public final CompositeBackgroundDrawable i(OutlineDrawable outlineDrawable) {
        return g(outlineDrawable, 7, new CompositeBackgroundDrawable$withNewOutline$1(new MutablePropertyReference0Impl(this) { // from class: com.facebook.react.uimanager.drawable.CompositeBackgroundDrawable$withNewOutline$2
            {
                super(this, CompositeBackgroundDrawable.class, "outline", "getOutline()Lcom/facebook/react/uimanager/drawable/OutlineDrawable;", 0);
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return ((CompositeBackgroundDrawable) this.receiver).f19675i;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public final void set(Object obj) {
                ((CompositeBackgroundDrawable) this.receiver).f19675i = (OutlineDrawable) obj;
            }
        }));
    }
}
