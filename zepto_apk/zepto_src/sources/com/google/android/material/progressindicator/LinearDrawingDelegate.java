package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes4.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {

    /* renamed from: b, reason: collision with root package name */
    public float f40830b;

    /* renamed from: c, reason: collision with root package name */
    public float f40831c;

    /* renamed from: d, reason: collision with root package name */
    public float f40832d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f40833e;

    /* renamed from: f, reason: collision with root package name */
    public float f40834f;

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final void a(Canvas canvas, Rect rect, float f2, boolean z, boolean z2) {
        this.f40830b = rect.width();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f40821a;
        float f3 = linearProgressIndicatorSpec.f40777a;
        canvas.translate((rect.width() / 2.0f) + rect.left, Math.max(0.0f, (rect.height() - f3) / 2.0f) + (rect.height() / 2.0f) + rect.top);
        if (linearProgressIndicatorSpec.f40859j) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f4 = this.f40830b / 2.0f;
        float f5 = f3 / 2.0f;
        canvas.clipRect(-f4, -f5, f4, f5);
        int i2 = linearProgressIndicatorSpec.f40777a;
        this.f40833e = i2 / 2 == linearProgressIndicatorSpec.f40778b;
        this.f40831c = i2 * f2;
        this.f40832d = Math.min(i2 / 2, r6) * f2;
        if (z || z2) {
            if ((z && linearProgressIndicatorSpec.f40781e == 2) || (z2 && linearProgressIndicatorSpec.f40782f == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && linearProgressIndicatorSpec.f40782f != 3)) {
                canvas.translate(0.0f, ((1.0f - f2) * linearProgressIndicatorSpec.f40777a) / 2.0f);
            }
        }
        if (z2 && linearProgressIndicatorSpec.f40782f == 3) {
            this.f40834f = f2;
        } else {
            this.f40834f = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final void b(Canvas canvas, Paint paint, int i2, int i3) {
        int iA = MaterialColors.a(i2, i3);
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f40821a;
        if (linearProgressIndicatorSpec.f40860k <= 0 || iA == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iA);
        PointF pointF = new PointF((this.f40830b / 2.0f) - (this.f40831c / 2.0f), 0.0f);
        int i4 = linearProgressIndicatorSpec.f40860k;
        h(canvas, paint, pointF, null, i4, i4);
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
        return ((LinearProgressIndicatorSpec) this.f40821a).f40777a;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public final int f() {
        return -1;
    }

    public final void g(Canvas canvas, Paint paint, float f2, float f3, int i2, int i3, int i4) {
        float f4;
        float fA = MathUtils.a(f2, 0.0f, 1.0f);
        float fA2 = MathUtils.a(f3, 0.0f, 1.0f);
        float fC = com.google.android.material.math.MathUtils.c(1.0f - this.f40834f, 1.0f, fA);
        float fC2 = com.google.android.material.math.MathUtils.c(1.0f - this.f40834f, 1.0f, fA2);
        int iA = (int) ((MathUtils.a(fC, 0.0f, 0.01f) * i3) / 0.01f);
        float fA3 = 1.0f - MathUtils.a(fC2, 0.99f, 1.0f);
        float f5 = this.f40830b;
        int i5 = (int) ((fC * f5) + iA);
        int i6 = (int) ((fC2 * f5) - ((int) ((fA3 * i4) / 0.01f)));
        float f6 = (-f5) / 2.0f;
        if (i5 <= i6) {
            float f7 = this.f40832d;
            float f8 = i5 + f7;
            float f9 = i6 - f7;
            float f10 = f7 * 2.0f;
            paint.setColor(i2);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.f40831c);
            if (f8 >= f9) {
                h(canvas, paint, new PointF(f8 + f6, 0.0f), new PointF(f9 + f6, 0.0f), f10, this.f40831c);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.f40833e ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f11 = f8 + f6;
            float f12 = f9 + f6;
            canvas.drawLine(f11, 0.0f, f12, 0.0f, paint);
            if (this.f40833e || this.f40832d <= 0.0f) {
                return;
            }
            paint.setStyle(Paint.Style.FILL);
            if (f8 > 0.0f) {
                f4 = f10;
                h(canvas, paint, new PointF(f11, 0.0f), null, f4, this.f40831c);
            } else {
                f4 = f10;
            }
            if (f9 < this.f40830b) {
                h(canvas, paint, new PointF(f12, 0.0f), null, f4, this.f40831c);
            }
        }
    }

    public final void h(Canvas canvas, Paint paint, PointF pointF, PointF pointF2, float f2, float f3) {
        float fMin = Math.min(f3, this.f40831c);
        float f4 = f2 / 2.0f;
        float fMin2 = Math.min(f4, (this.f40832d * fMin) / this.f40831c);
        RectF rectF = new RectF((-f2) / 2.0f, (-fMin) / 2.0f, f4, fMin / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, fMin2, fMin2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }
}
