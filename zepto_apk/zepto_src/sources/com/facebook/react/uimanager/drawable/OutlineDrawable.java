package com.facebook.react.uimanager.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.style.BorderRadiusStyle;
import com.facebook.react.uimanager.style.ComputedBorderRadius;
import com.facebook.react.uimanager.style.CornerRadii;
import com.facebook.react.uimanager.style.OutlineStyle;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata
/* loaded from: classes3.dex */
public final class OutlineDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19688a;

    /* renamed from: b, reason: collision with root package name */
    public BorderRadiusStyle f19689b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19690c;

    /* renamed from: d, reason: collision with root package name */
    public float f19691d;

    /* renamed from: e, reason: collision with root package name */
    public OutlineStyle f19692e;

    /* renamed from: f, reason: collision with root package name */
    public int f19693f;

    /* renamed from: g, reason: collision with root package name */
    public float f19694g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f19695h;

    /* renamed from: i, reason: collision with root package name */
    public ComputedBorderRadius f19696i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f19697j;

    /* renamed from: k, reason: collision with root package name */
    public final Path f19698k;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[OutlineStyle.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OutlineStyle.Companion companion = OutlineStyle.f19911a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                OutlineStyle.Companion companion2 = OutlineStyle.f19911a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public OutlineDrawable(Context context, BorderRadiusStyle borderRadiusStyle) {
        OutlineStyle outlineStyle = OutlineStyle.f19912b;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outlineStyle, "outlineStyle");
        this.f19688a = context;
        this.f19689b = borderRadiusStyle;
        this.f19690c = 0.8f;
        this.f19691d = 0.0f;
        this.f19692e = outlineStyle;
        this.f19693f = -16777216;
        this.f19694g = 0.0f;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16777216);
        paint.setStrokeWidth(0.0f);
        paint.setPathEffect(b(outlineStyle, 0.0f));
        this.f19695h = paint;
        this.f19697j = new RectF();
        this.f19698k = new Path();
    }

    public static float a(float f2, float f3) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return (f3 * 0.5f) + f2;
    }

    public static DashPathEffect b(OutlineStyle outlineStyle, float f2) {
        int iOrdinal = outlineStyle.ordinal();
        if (iOrdinal == 0) {
            return null;
        }
        if (iOrdinal == 1) {
            float f3 = f2 * 3;
            return new DashPathEffect(new float[]{f3, f3, f3, f3}, 0.0f);
        }
        if (iOrdinal == 2) {
            return new DashPathEffect(new float[]{f2, f2, f2, f2}, 0.0f);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void c(BorderRadiusStyle borderRadiusStyle) {
        this.f19689b = borderRadiusStyle;
    }

    public final void d(int i2) {
        if (i2 != this.f19693f) {
            this.f19693f = i2;
            this.f19695h.setColor(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        CornerRadii cornerRadii;
        CornerRadii cornerRadii2;
        CornerRadii cornerRadii3;
        CornerRadii cornerRadii4;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.f19694g == 0.0f) {
            return;
        }
        Path path = this.f19698k;
        path.reset();
        BorderRadiusStyle borderRadiusStyle = this.f19689b;
        this.f19696i = borderRadiusStyle != null ? borderRadiusStyle.d(getLayoutDirection(), this.f19688a, PixelUtil.a(getBounds().width()), PixelUtil.a(getBounds().height())) : null;
        RectF rectF = this.f19697j;
        rectF.set(getBounds());
        float f2 = rectF.top;
        float f3 = ((this.f19694g * 0.5f) + this.f19691d) - this.f19690c;
        rectF.top = f2 - f3;
        rectF.bottom += f3;
        rectF.left -= f3;
        rectF.right = f3 + rectF.right;
        ComputedBorderRadius computedBorderRadius = this.f19696i;
        Paint paint = this.f19695h;
        if (computedBorderRadius == null || !computedBorderRadius.a()) {
            path.addRect(rectF, Path.Direction.CW);
            canvas.drawPath(path, paint);
            return;
        }
        ComputedBorderRadius computedBorderRadius2 = this.f19696i;
        CornerRadii cornerRadii5 = (computedBorderRadius2 == null || (cornerRadii4 = computedBorderRadius2.f19873a) == null) ? new CornerRadii(0.0f, 0.0f) : cornerRadii4.a();
        ComputedBorderRadius computedBorderRadius3 = this.f19696i;
        CornerRadii cornerRadii6 = (computedBorderRadius3 == null || (cornerRadii3 = computedBorderRadius3.f19874b) == null) ? new CornerRadii(0.0f, 0.0f) : cornerRadii3.a();
        ComputedBorderRadius computedBorderRadius4 = this.f19696i;
        CornerRadii cornerRadii7 = (computedBorderRadius4 == null || (cornerRadii2 = computedBorderRadius4.f19875c) == null) ? new CornerRadii(0.0f, 0.0f) : cornerRadii2.a();
        ComputedBorderRadius computedBorderRadius5 = this.f19696i;
        CornerRadii cornerRadii8 = (computedBorderRadius5 == null || (cornerRadii = computedBorderRadius5.f19876d) == null) ? new CornerRadii(0.0f, 0.0f) : cornerRadii.a();
        path.addRoundRect(rectF, new float[]{a(cornerRadii5.f19879a, this.f19694g), a(cornerRadii5.f19880b, this.f19694g), a(cornerRadii6.f19879a, this.f19694g), a(cornerRadii6.f19880b, this.f19694g), a(cornerRadii8.f19879a, this.f19694g), a(cornerRadii8.f19880b, this.f19694g), a(cornerRadii7.f19879a, this.f19694g), a(cornerRadii7.f19880b, this.f19694g)}, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    public final void e(float f2) {
        if (f2 == this.f19691d) {
            return;
        }
        this.f19691d = f2;
        invalidateSelf();
    }

    public final void f(OutlineStyle value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.f19692e) {
            this.f19692e = value;
            this.f19695h.setPathEffect(b(value, this.f19694g));
            invalidateSelf();
        }
    }

    public final void g(float f2) {
        if (f2 == this.f19694g) {
            return;
        }
        this.f19694g = f2;
        Paint paint = this.f19695h;
        paint.setStrokeWidth(f2);
        paint.setPathEffect(b(this.f19692e, f2));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int alpha = this.f19695h.getAlpha();
        if (alpha == 255) {
            return -1;
        }
        return (1 > alpha || alpha >= 255) ? -2 : -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f19695h.setAlpha(MathKt.b((Color.alpha(this.f19693f) / 255.0f) * (i2 / 255.0f) * 255.0f));
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f19695h.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
