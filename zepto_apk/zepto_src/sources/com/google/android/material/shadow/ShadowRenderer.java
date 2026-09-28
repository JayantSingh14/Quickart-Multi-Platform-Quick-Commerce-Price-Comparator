package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo
/* loaded from: classes4.dex */
public class ShadowRenderer {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f40956i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f40957j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f40958k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f40959l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f40960a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f40961b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f40962c;

    /* renamed from: d, reason: collision with root package name */
    public int f40963d;

    /* renamed from: e, reason: collision with root package name */
    public int f40964e;

    /* renamed from: f, reason: collision with root package name */
    public int f40965f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f40966g = new Path();

    /* renamed from: h, reason: collision with root package name */
    public final Paint f40967h;

    public ShadowRenderer() {
        Paint paint = new Paint();
        this.f40967h = paint;
        this.f40960a = new Paint();
        c(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f40961b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f40962c = new Paint(paint2);
    }

    public final void a(Canvas canvas, Matrix matrix, RectF rectF, int i2, float f2, float f3) {
        boolean z = f3 < 0.0f;
        Path path = this.f40966g;
        int[] iArr = f40958k;
        if (z) {
            iArr[0] = 0;
            iArr[1] = this.f40965f;
            iArr[2] = this.f40964e;
            iArr[3] = this.f40963d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i2;
            rectF.inset(f4, f4);
            iArr[0] = 0;
            iArr[1] = this.f40963d;
            iArr[2] = this.f40964e;
            iArr[3] = this.f40965f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f5 = 1.0f - (i2 / fWidth);
        float[] fArr = f40959l;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
        boolean z2 = z;
        Paint paint = this.f40961b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z2) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f40967h);
        }
        canvas.drawArc(rectF, f2, f3, true, paint);
        canvas.restore();
    }

    public final void b(Canvas canvas, Matrix matrix, RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = f40956i;
        iArr[0] = this.f40965f;
        iArr[1] = this.f40964e;
        iArr[2] = this.f40963d;
        Paint paint = this.f40962c;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f40957j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final void c(int i2) {
        this.f40963d = ColorUtils.k(i2, 68);
        this.f40964e = ColorUtils.k(i2, 20);
        this.f40965f = ColorUtils.k(i2, 0);
        this.f40960a.setColor(this.f40963d);
    }
}
