package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.RequiresApi;
import com.facebook.react.uimanager.FilterHelper;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderInsets;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;

@RequiresApi
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InsetBoxShadowDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19678a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19679b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19680c;

    /* renamed from: d, reason: collision with root package name */
    public final float f19681d;

    /* renamed from: e, reason: collision with root package name */
    public final float f19682e;

    /* renamed from: f, reason: collision with root package name */
    public final float f19683f;

    /* renamed from: g, reason: collision with root package name */
    public BorderInsets f19684g;

    /* renamed from: h, reason: collision with root package name */
    public BorderRadiusStyle f19685h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f19686i;

    public InsetBoxShadowDrawable(Context context, int i2, float f2, float f3, float f4, float f5, BorderInsets borderInsets, BorderRadiusStyle borderRadiusStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f19678a = context;
        this.f19679b = i2;
        this.f19680c = f2;
        this.f19681d = f3;
        this.f19682e = f4;
        this.f19683f = f5;
        this.f19684g = borderInsets;
        this.f19685h = borderRadiusStyle;
        Paint paint = new Paint();
        paint.setColor(i2);
        if (f4 > 0.0f) {
            paint.setMaskFilter(new BlurMaskFilter(FilterHelper.j(f4 * 0.5f), BlurMaskFilter.Blur.NORMAL));
        }
        this.f19686i = paint;
    }

    public static float b(float f2, Float f3) {
        float fFloatValue = f2 - (f3 != null ? f3.floatValue() : 0.0f);
        if (fFloatValue < 0.0f) {
            return 0.0f;
        }
        return fFloatValue;
    }

    public final BorderRadiusStyle a() {
        return this.f19685h;
    }

    public final void c(BorderInsets borderInsets) {
        this.f19684g = borderInsets;
    }

    public final void d(BorderRadiusStyle borderRadiusStyle) {
        this.f19685h = borderRadiusStyle;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ComputedBorderRadius computedBorderRadius;
        RectF rectF;
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        BorderRadiusStyle borderRadiusStyle = this.f19685h;
        Context context = this.f19678a;
        float[] fArr = null;
        ComputedBorderRadius computedBorderRadiusD = borderRadiusStyle != null ? borderRadiusStyle.d(getLayoutDirection(), context, PixelUtil.a(getBounds().width()), PixelUtil.a(getBounds().height())) : null;
        if (computedBorderRadiusD == null || !computedBorderRadiusD.a()) {
            computedBorderRadius = null;
        } else {
            CornerRadii cornerRadii = computedBorderRadiusD.f19873a;
            CornerRadii cornerRadii2 = new CornerRadii(PixelUtil.b(cornerRadii.f19879a), PixelUtil.b(cornerRadii.f19880b));
            CornerRadii cornerRadii3 = computedBorderRadiusD.f19874b;
            CornerRadii cornerRadii4 = new CornerRadii(PixelUtil.b(cornerRadii3.f19879a), PixelUtil.b(cornerRadii3.f19880b));
            CornerRadii cornerRadii5 = computedBorderRadiusD.f19875c;
            CornerRadii cornerRadii6 = new CornerRadii(PixelUtil.b(cornerRadii5.f19879a), PixelUtil.b(cornerRadii5.f19880b));
            CornerRadii cornerRadii7 = computedBorderRadiusD.f19876d;
            computedBorderRadius = new ComputedBorderRadius(cornerRadii2, cornerRadii4, cornerRadii6, new CornerRadii(PixelUtil.b(cornerRadii7.f19879a), PixelUtil.b(cornerRadii7.f19880b)));
        }
        BorderInsets borderInsets = this.f19684g;
        if (borderInsets != null) {
            RectF rectFA = borderInsets.a(getLayoutDirection(), context);
            rectF = new RectF(PixelUtil.b(rectFA.left), PixelUtil.b(rectFA.top), PixelUtil.b(rectFA.right), PixelUtil.b(rectFA.bottom));
        } else {
            rectF = null;
        }
        RectF rectF2 = new RectF(getBounds().left + (rectF != null ? rectF.left : 0.0f), getBounds().top + (rectF != null ? rectF.top : 0.0f), getBounds().right - (rectF != null ? rectF.right : 0.0f), getBounds().bottom - (rectF != null ? rectF.bottom : 0.0f));
        if (computedBorderRadius != null) {
            CornerRadii cornerRadii8 = computedBorderRadius.f19873a;
            float fB = b(cornerRadii8.f19879a, rectF != null ? Float.valueOf(rectF.left) : null);
            float fB2 = b(cornerRadii8.f19880b, rectF != null ? Float.valueOf(rectF.top) : null);
            CornerRadii cornerRadii9 = computedBorderRadius.f19874b;
            float fB3 = b(cornerRadii9.f19879a, rectF != null ? Float.valueOf(rectF.right) : null);
            float fB4 = b(cornerRadii9.f19880b, rectF != null ? Float.valueOf(rectF.top) : null);
            CornerRadii cornerRadii10 = computedBorderRadius.f19876d;
            float fB5 = b(cornerRadii10.f19879a, rectF != null ? Float.valueOf(rectF.right) : null);
            float fB6 = b(cornerRadii10.f19880b, rectF != null ? Float.valueOf(rectF.bottom) : null);
            CornerRadii cornerRadii11 = computedBorderRadius.f19875c;
            i2 = 0;
            fArr = new float[]{fB, fB2, fB3, fB4, fB5, fB6, b(cornerRadii11.f19879a, rectF != null ? Float.valueOf(rectF.left) : null), b(cornerRadii11.f19880b, rectF != null ? Float.valueOf(rectF.bottom) : null)};
        } else {
            i2 = 0;
        }
        float fB7 = PixelUtil.b(this.f19680c);
        float fB8 = PixelUtil.b(this.f19681d);
        float fB9 = PixelUtil.b(this.f19683f);
        RectF rectF3 = new RectF(rectF2);
        rectF3.inset(fB9, fB9);
        rectF3.offset(fB7, fB8);
        float fJ = FilterHelper.j(this.f19682e);
        RectF rectF4 = new RectF(rectF3);
        float f2 = -fJ;
        rectF4.inset(f2, f2);
        if (fB9 < 0.0f) {
            rectF4.inset(fB9, fB9);
        }
        RectF rectF5 = new RectF(rectF4);
        rectF5.offset(-fB7, -fB8);
        rectF4.union(rectF5);
        int iSave = canvas.save();
        Paint paint = this.f19686i;
        float[] fArr2 = InsetBoxShadowDrawableKt.f19687a;
        if (fArr != null) {
            Path path = new Path();
            path.addRoundRect(rectF2, fArr, Path.Direction.CW);
            canvas.clipPath(path);
            ArrayList arrayList = new ArrayList(fArr.length);
            int length = fArr.length;
            for (int i3 = i2; i3 < length; i3++) {
                arrayList.add(Float.valueOf(BoxShadowBorderRadiusKt.a(fArr[i3], -fB9)));
            }
            canvas.drawDoubleRoundRect(rectF4, fArr2, rectF3, CollectionsKt.c0(arrayList), paint);
        } else {
            canvas.clipRect(rectF2);
            canvas.drawDoubleRoundRect(rectF4, fArr2, rectF3, fArr2, paint);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int alpha = this.f19686i.getAlpha();
        if (alpha == 255) {
            return -1;
        }
        return (1 > alpha || alpha >= 255) ? -2 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f19686i.setAlpha(MathKt.b((Color.alpha(this.f19679b) / 255.0f) * (i2 / 255.0f) * 255.0f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f19686i.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
