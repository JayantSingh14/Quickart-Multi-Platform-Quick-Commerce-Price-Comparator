package com.facebook.drawee.debug;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.infer.annotation.Nullsafe;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Nullsafe
/* loaded from: classes3.dex */
public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {

    /* renamed from: a, reason: collision with root package name */
    public String f17281a;

    /* renamed from: b, reason: collision with root package name */
    public int f17282b;

    /* renamed from: c, reason: collision with root package name */
    public int f17283c;

    /* renamed from: d, reason: collision with root package name */
    public int f17284d;

    /* renamed from: e, reason: collision with root package name */
    public ScalingUtils.ScaleType f17285e;

    /* renamed from: g, reason: collision with root package name */
    public int f17287g;

    /* renamed from: h, reason: collision with root package name */
    public int f17288h;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public long s;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f17286f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public final int f17289i = 80;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f17290j = new Paint(1);

    /* renamed from: k, reason: collision with root package name */
    public final Matrix f17291k = new Matrix();

    /* renamed from: l, reason: collision with root package name */
    public final Rect f17292l = new Rect();

    /* renamed from: m, reason: collision with root package name */
    public final RectF f17293m = new RectF();

    public DebugControllerOverlayDrawable() {
        b();
    }

    public final void a(Canvas canvas, String str, String str2, int i2) {
        String strK = b.k(str, ": ");
        Paint paint = this.f17290j;
        float fMeasureText = paint.measureText(strK);
        float fMeasureText2 = paint.measureText(str2);
        paint.setColor(1711276032);
        int i3 = this.q;
        int i4 = this.r;
        canvas.drawRect(i3 - 4, i4 + 8, i3 + fMeasureText + fMeasureText2 + 4.0f, i4 + this.p + 8, paint);
        paint.setColor(-1);
        canvas.drawText(strK, this.q, this.r, paint);
        paint.setColor(i2);
        canvas.drawText(str2, this.q + fMeasureText, this.r, paint);
        this.r += this.p;
    }

    public final void b() {
        this.f17282b = -1;
        this.f17283c = -1;
        this.f17284d = -1;
        this.f17286f = new HashMap();
        this.f17287g = -1;
        this.f17288h = -1;
        this.f17281a = "none";
        invalidateSelf();
        this.s = -1L;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        Paint paint = this.f17290j;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(-26624);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, paint);
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setColor(0);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, paint);
        paint.setStyle(style);
        paint.setStrokeWidth(0.0f);
        paint.setColor(-1);
        this.q = this.n;
        this.r = this.o;
        a(canvas, "ID", this.f17281a, -1);
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        Locale locale = Locale.US;
        a(canvas, "D", iWidth + "x" + iHeight, -1);
        if (bounds.height() > 0) {
            a(canvas, "DAR", String.valueOf(Float.valueOf(bounds.width() / bounds.height())), -1);
        }
        int i2 = this.f17282b;
        int i3 = this.f17283c;
        ScalingUtils.ScaleType scaleType = this.f17285e;
        int iWidth2 = getBounds().width();
        int iHeight2 = getBounds().height();
        int i4 = -65536;
        if (iWidth2 > 0 && iHeight2 > 0 && i2 > 0 && i3 > 0) {
            if (scaleType != null) {
                Rect rect = this.f17292l;
                rect.top = 0;
                rect.left = 0;
                rect.right = iWidth2;
                rect.bottom = iHeight2;
                Matrix matrix = this.f17291k;
                matrix.reset();
                scaleType.a(matrix, this.f17292l, i2, i3, 0.0f, 0.0f);
                RectF rectF = this.f17293m;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = i2;
                rectF.bottom = i3;
                matrix.mapRect(rectF);
                int iWidth3 = (int) rectF.width();
                int iHeight3 = (int) rectF.height();
                iWidth2 = Math.min(iWidth2, iWidth3);
                iHeight2 = Math.min(iHeight2, iHeight3);
            }
            float f2 = iWidth2;
            float f3 = f2 * 0.1f;
            float f4 = f2 * 0.5f;
            float f5 = iHeight2;
            float f6 = 0.1f * f5;
            float f7 = f5 * 0.5f;
            int iAbs = Math.abs(i2 - iWidth2);
            int iAbs2 = Math.abs(i3 - iHeight2);
            float f8 = iAbs;
            if (f8 < f3 && iAbs2 < f6) {
                i4 = -16711936;
            } else if (f8 < f4 && iAbs2 < f7) {
                i4 = -256;
            }
        }
        a(canvas, "I", this.f17282b + "x" + this.f17283c, i4);
        int i5 = this.f17283c;
        if (i5 > 0) {
            a(canvas, "IAR", String.valueOf(Float.valueOf(this.f17282b / i5)), -1);
        }
        a(canvas, "I", (this.f17284d / 1024) + " KiB", -1);
        int i6 = this.f17287g;
        if (i6 > 0) {
            a(canvas, "anim", b.d(i6, this.f17288h, "f ", ", l "), -1);
        }
        ScalingUtils.ScaleType scaleType2 = this.f17285e;
        if (scaleType2 != null) {
            a(canvas, "scale", String.valueOf(scaleType2), -1);
        }
        long j2 = this.s;
        if (j2 >= 0) {
            a(canvas, "t", j2 + " ms", -1);
        }
        for (Map.Entry entry : this.f17286f.entrySet()) {
            a(canvas, (String) entry.getKey(), (String) entry.getValue(), -1);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int iMin = Math.min(40, Math.max(10, Math.min(rect.width() / 8, rect.height() / 9)));
        this.f17290j.setTextSize(iMin);
        int i2 = iMin + 8;
        this.p = i2;
        int i3 = this.f17289i;
        if (i3 == 80) {
            this.p = i2 * (-1);
        }
        this.n = rect.left + 10;
        this.o = i3 == 80 ? rect.bottom - 10 : rect.top + 20;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
