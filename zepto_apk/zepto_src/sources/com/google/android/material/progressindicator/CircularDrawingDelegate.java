package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes4.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {

    /* renamed from: b, reason: collision with root package name */
    public float f40784b;

    /* renamed from: c, reason: collision with root package name */
    public float f40785c;

    /* renamed from: d, reason: collision with root package name */
    public float f40786d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f40787e;

    /* renamed from: f, reason: collision with root package name */
    public float f40788f;

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final void a(Canvas canvas, Rect rect, float f2, boolean z, boolean z2) {
        float fWidth = rect.width() / i();
        float fHeight = rect.height() / i();
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f40821a;
        float f3 = (circularProgressIndicatorSpec.f40803h / 2.0f) + circularProgressIndicatorSpec.f40804i;
        canvas.translate((f3 * fWidth) + rect.left, (f3 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (circularProgressIndicatorSpec.f40805j != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        int i2 = circularProgressIndicatorSpec.f40777a;
        this.f40787e = i2 / 2 <= circularProgressIndicatorSpec.f40778b;
        this.f40784b = i2 * f2;
        this.f40785c = Math.min(i2 / 2, r1) * f2;
        int i3 = circularProgressIndicatorSpec.f40803h;
        int i4 = circularProgressIndicatorSpec.f40777a;
        float f5 = (i3 - i4) / 2.0f;
        this.f40786d = f5;
        if (z || z2) {
            if ((z && circularProgressIndicatorSpec.f40781e == 2) || (z2 && circularProgressIndicatorSpec.f40782f == 1)) {
                this.f40786d = (((1.0f - f2) * i4) / 2.0f) + f5;
            } else if ((z && circularProgressIndicatorSpec.f40781e == 1) || (z2 && circularProgressIndicatorSpec.f40782f == 2)) {
                this.f40786d = f5 - (((1.0f - f2) * i4) / 2.0f);
            }
        }
        if (z2 && circularProgressIndicatorSpec.f40782f == 3) {
            this.f40788f = f2;
        } else {
            this.f40788f = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final void b(Canvas canvas, Paint paint, int i2, int i3) {
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final void c(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int i2) {
        int iA = MaterialColors.a(activeIndicator.f40824c, i2);
        float f2 = activeIndicator.f40822a;
        float f3 = activeIndicator.f40823b;
        int i3 = activeIndicator.f40825d;
        g(canvas, paint, f2, f3, iA, i3, i3);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final void d(Canvas canvas, Paint paint, float f2, float f3, int i2, int i3, int i4) {
        g(canvas, paint, f2, f3, MaterialColors.a(i2, i3), i4, i4);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final int e() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final int f() {
        return i();
    }

    public final void g(Canvas canvas, Paint paint, float f2, float f3, int i2, int i3, int i4) {
        float f4 = f3 >= f2 ? f3 - f2 : (f3 + 1.0f) - f2;
        float f5 = f2 % 1.0f;
        if (this.f40788f < 1.0f) {
            float f6 = f5 + f4;
            if (f6 > 1.0f) {
                g(canvas, paint, f5, 1.0f, i2, i3, 0);
                g(canvas, paint, 1.0f, f6, i2, 0, i4);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.f40785c / this.f40786d);
        if (f5 == 0.0f && f4 >= 0.99f) {
            f4 += (((degrees * 2.0f) / 360.0f) * (f4 - 0.99f)) / 0.01f;
        }
        float fC = MathUtils.c(1.0f - this.f40788f, 1.0f, f5);
        float fC2 = MathUtils.c(0.0f, this.f40788f, f4);
        float degrees2 = (float) Math.toDegrees(i3 / this.f40786d);
        float degrees3 = ((fC2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i4 / this.f40786d));
        float f7 = (fC * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStrokeWidth(this.f40784b);
        float f8 = degrees * 2.0f;
        if (degrees3 < f8) {
            float f9 = degrees3 / f8;
            paint.setStyle(Paint.Style.FILL);
            h(canvas, paint, (degrees * f9) + f7, this.f40785c * 2.0f, this.f40784b, f9);
            return;
        }
        float f10 = this.f40786d;
        float f11 = -f10;
        RectF rectF = new RectF(f11, f11, f10, f10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.f40787e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f12 = f7 + degrees;
        canvas.drawArc(rectF, f12, degrees3 - f8, false, paint);
        if (this.f40787e || this.f40785c <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        h(canvas, paint, f12, this.f40785c * 2.0f, this.f40784b, 1.0f);
        h(canvas, paint, (f7 + degrees3) - degrees, this.f40785c * 2.0f, this.f40784b, 1.0f);
    }

    public final void h(Canvas canvas, Paint paint, float f2, float f3, float f4, float f5) {
        float fMin = (int) Math.min(f4, this.f40784b);
        float f6 = f3 / 2.0f;
        float fMin2 = Math.min(f6, (this.f40785c * fMin) / this.f40784b);
        RectF rectF = new RectF((-fMin) / 2.0f, (-f3) / 2.0f, fMin / 2.0f, f6);
        canvas.save();
        double d2 = f2;
        canvas.translate((float) (Math.cos(Math.toRadians(d2)) * this.f40786d), (float) (Math.sin(Math.toRadians(d2)) * this.f40786d));
        canvas.rotate(f2);
        canvas.scale(f5, f5);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    public final int i() {
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.f40821a;
        return (((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f40804i * 2) + ((CircularProgressIndicatorSpec) baseProgressIndicatorSpec).f40803h;
    }
}
