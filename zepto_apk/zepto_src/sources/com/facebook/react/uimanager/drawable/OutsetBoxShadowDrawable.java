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
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;

@RequiresApi
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class OutsetBoxShadowDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19699a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19700b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19701c;

    /* renamed from: d, reason: collision with root package name */
    public final float f19702d;

    /* renamed from: e, reason: collision with root package name */
    public final float f19703e;

    /* renamed from: f, reason: collision with root package name */
    public BorderRadiusStyle f19704f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f19705g;

    public OutsetBoxShadowDrawable(Context context, int i2, float f2, float f3, float f4, float f5, BorderRadiusStyle borderRadiusStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f19699a = context;
        this.f19700b = i2;
        this.f19701c = f2;
        this.f19702d = f3;
        this.f19703e = f5;
        this.f19704f = borderRadiusStyle;
        Paint paint = new Paint();
        paint.setColor(i2);
        if (f4 > 0.0f) {
            paint.setMaskFilter(new BlurMaskFilter(FilterHelper.j(f4 * 0.5f), BlurMaskFilter.Blur.NORMAL));
        }
        this.f19705g = paint;
    }

    public final BorderRadiusStyle a() {
        return this.f19704f;
    }

    public final void b(BorderRadiusStyle borderRadiusStyle) {
        this.f19704f = borderRadiusStyle;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        char c2;
        char c3;
        ComputedBorderRadius computedBorderRadius;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float fA = PixelUtil.a(getBounds().width());
        float fA2 = PixelUtil.a(getBounds().height());
        BorderRadiusStyle borderRadiusStyle = this.f19704f;
        if (borderRadiusStyle != null) {
            ComputedBorderRadius computedBorderRadiusD = borderRadiusStyle.d(getLayoutDirection(), this.f19699a, fA, fA2);
            CornerRadii cornerRadii = computedBorderRadiusD.f19873a;
            CornerRadii cornerRadii2 = new CornerRadii(PixelUtil.b(cornerRadii.f19879a), PixelUtil.b(cornerRadii.f19880b));
            CornerRadii cornerRadii3 = computedBorderRadiusD.f19874b;
            c2 = 7;
            CornerRadii cornerRadii4 = new CornerRadii(PixelUtil.b(cornerRadii3.f19879a), PixelUtil.b(cornerRadii3.f19880b));
            CornerRadii cornerRadii5 = computedBorderRadiusD.f19875c;
            c3 = 6;
            CornerRadii cornerRadii6 = new CornerRadii(PixelUtil.b(cornerRadii5.f19879a), PixelUtil.b(cornerRadii5.f19880b));
            CornerRadii cornerRadii7 = computedBorderRadiusD.f19876d;
            computedBorderRadius = new ComputedBorderRadius(cornerRadii2, cornerRadii4, cornerRadii6, new CornerRadii(PixelUtil.b(cornerRadii7.f19879a), PixelUtil.b(cornerRadii7.f19880b)));
        } else {
            c2 = 7;
            c3 = 6;
            computedBorderRadius = null;
        }
        float fB = PixelUtil.b(this.f19703e);
        RectF rectF = new RectF(getBounds());
        float f2 = -fB;
        rectF.inset(f2, f2);
        rectF.offset(PixelUtil.b(this.f19701c), PixelUtil.b(this.f19702d));
        int iSave = canvas.save();
        Paint paint = this.f19705g;
        if (computedBorderRadius == null || !computedBorderRadius.a()) {
            canvas.clipOutRect(getBounds());
            canvas.drawRect(rectF, paint);
        } else {
            RectF rectF2 = new RectF(getBounds());
            rectF2.inset(0.4f, 0.4f);
            Path path = new Path();
            CornerRadii cornerRadii8 = computedBorderRadius.f19873a;
            float f3 = cornerRadii8.f19879a;
            CornerRadii cornerRadii9 = computedBorderRadius.f19874b;
            float f4 = cornerRadii9.f19879a;
            CornerRadii cornerRadii10 = computedBorderRadius.f19876d;
            float f5 = cornerRadii10.f19879a;
            CornerRadii cornerRadii11 = computedBorderRadius.f19875c;
            float f6 = cornerRadii11.f19879a;
            float f7 = cornerRadii10.f19880b;
            float f8 = cornerRadii11.f19880b;
            float f9 = cornerRadii8.f19880b;
            float f10 = cornerRadii9.f19880b;
            float[] fArr = new float[8];
            fArr[0] = f3;
            fArr[1] = f9;
            fArr[2] = f4;
            fArr[3] = f10;
            fArr[4] = f5;
            fArr[5] = f7;
            fArr[c3] = f6;
            fArr[c2] = f8;
            Path.Direction direction = Path.Direction.CW;
            path.addRoundRect(rectF2, fArr, direction);
            canvas.clipOutPath(path);
            Path path2 = new Path();
            float fA3 = BoxShadowBorderRadiusKt.a(cornerRadii8.f19879a, fB);
            float fA4 = BoxShadowBorderRadiusKt.a(cornerRadii8.f19880b, fB);
            float fA5 = BoxShadowBorderRadiusKt.a(cornerRadii9.f19879a, fB);
            float fA6 = BoxShadowBorderRadiusKt.a(cornerRadii9.f19880b, fB);
            float fA7 = BoxShadowBorderRadiusKt.a(cornerRadii10.f19879a, fB);
            float fA8 = BoxShadowBorderRadiusKt.a(cornerRadii10.f19880b, fB);
            float fA9 = BoxShadowBorderRadiusKt.a(cornerRadii11.f19879a, fB);
            float fA10 = BoxShadowBorderRadiusKt.a(cornerRadii11.f19880b, fB);
            float[] fArr2 = new float[8];
            fArr2[0] = fA3;
            fArr2[1] = fA4;
            fArr2[2] = fA5;
            fArr2[3] = fA6;
            fArr2[4] = fA7;
            fArr2[5] = fA8;
            fArr2[c3] = fA9;
            fArr2[c2] = fA10;
            path2.addRoundRect(rectF, fArr2, direction);
            canvas.drawPath(path2, paint);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int alpha = this.f19705g.getAlpha();
        if (alpha == 255) {
            return -1;
        }
        return (1 > alpha || alpha >= 255) ? -2 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f19705g.setAlpha(MathKt.b((Color.alpha(this.f19700b) / 255.0f) * (i2 / 255.0f) * 255.0f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f19705g.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
