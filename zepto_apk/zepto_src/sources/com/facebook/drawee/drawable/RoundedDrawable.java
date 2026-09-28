package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class RoundedDrawable extends Drawable implements Rounded, TransformAwareDrawable {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f17364a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17365b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17366c = false;

    /* renamed from: d, reason: collision with root package name */
    public float f17367d = 0.0f;

    /* renamed from: e, reason: collision with root package name */
    public final Path f17368e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public boolean f17369f = true;

    /* renamed from: g, reason: collision with root package name */
    public int f17370g = 0;

    /* renamed from: h, reason: collision with root package name */
    public final Path f17371h = new Path();

    /* renamed from: i, reason: collision with root package name */
    public final float[] f17372i = new float[8];

    /* renamed from: j, reason: collision with root package name */
    public final float[] f17373j = new float[8];

    /* renamed from: k, reason: collision with root package name */
    public final RectF f17374k = new RectF();

    /* renamed from: l, reason: collision with root package name */
    public final RectF f17375l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public final RectF f17376m = new RectF();
    public final RectF n = new RectF();
    public final Matrix o = new Matrix();
    public final Matrix p = new Matrix();
    public final Matrix q = new Matrix();
    public final Matrix r = new Matrix();
    public final Matrix s = new Matrix();
    public final Matrix t = new Matrix();
    public float u = 0.0f;
    public boolean v = false;
    public boolean w = true;
    public Drawable x;

    public RoundedDrawable(Drawable drawable) {
        this.f17364a = drawable;
    }

    public final void a() {
        float[] fArr;
        if (this.w) {
            Path path = this.f17371h;
            path.reset();
            RectF rectF = this.f17374k;
            float f2 = this.f17367d / 2.0f;
            rectF.inset(f2, f2);
            boolean z = this.f17365b;
            float[] fArr2 = this.f17372i;
            if (z) {
                path.addCircle(rectF.centerX(), rectF.centerY(), Math.min(rectF.width(), rectF.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i2 = 0;
                while (true) {
                    fArr = this.f17373j;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = (fArr2[i2] + this.u) - (this.f17367d / 2.0f);
                    i2++;
                }
                path.addRoundRect(rectF, fArr, Path.Direction.CW);
            }
            float f3 = (-this.f17367d) / 2.0f;
            rectF.inset(f3, f3);
            Path path2 = this.f17368e;
            path2.reset();
            float f4 = this.u + 0.0f;
            rectF.inset(f4, f4);
            if (this.f17365b) {
                path2.addCircle(rectF.centerX(), rectF.centerY(), Math.min(rectF.width(), rectF.height()) / 2.0f, Path.Direction.CW);
            } else {
                path2.addRoundRect(rectF, fArr2, Path.Direction.CW);
            }
            float f5 = -f4;
            rectF.inset(f5, f5);
            path2.setFillType(Path.FillType.WINDING);
            this.w = false;
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void b(boolean z) {
        this.f17365b = z;
        this.w = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void c(float f2, int i2) {
        if (this.f17370g == i2 && this.f17367d == f2) {
            return;
        }
        this.f17370g = i2;
        this.f17367d = f2;
        this.w = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void clearColorFilter() {
        this.f17364a.clearColorFilter();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    public void d() {
        ?? r0 = this.x;
        Matrix matrix = this.q;
        RectF rectF = this.f17374k;
        if (r0 != 0) {
            r0.d(matrix);
            this.x.p(rectF);
        } else {
            matrix.reset();
            rectF.set(getBounds());
        }
        RectF rectF2 = this.f17376m;
        Drawable drawable = this.f17364a;
        rectF2.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        RectF rectF3 = this.n;
        rectF3.set(drawable.getBounds());
        Matrix matrix2 = this.o;
        matrix2.setRectToRect(rectF2, rectF3, Matrix.ScaleToFit.FILL);
        Matrix matrix3 = this.r;
        boolean zEquals = matrix.equals(matrix3);
        Matrix matrix4 = this.p;
        if (!zEquals || !matrix2.equals(matrix4)) {
            this.f17369f = true;
            matrix.invert(this.s);
            Matrix matrix5 = this.t;
            matrix5.set(matrix);
            matrix5.preConcat(matrix2);
            matrix3.set(matrix);
            matrix4.set(matrix2);
        }
        RectF rectF4 = this.f17375l;
        if (rectF.equals(rectF4)) {
            return;
        }
        this.w = true;
        rectF4.set(rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        FrescoSystrace.a();
        this.f17364a.draw(canvas);
        FrescoSystrace.a();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f17364a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f17364a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f17364a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f17364a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f17364a.getOpacity();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void h(float f2) {
        if (this.u != f2) {
            this.u = f2;
            this.w = true;
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public final void i(TransformCallback transformCallback) {
        this.x = (Drawable) transformCallback;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void k() {
        Arrays.fill(this.f17372i, 0.0f);
        this.f17366c = false;
        this.w = true;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void m(boolean z) {
        if (this.v != z) {
            this.v = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f17364a.setBounds(rect);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void s(float[] fArr) {
        float[] fArr2 = this.f17372i;
        if (fArr == null) {
            Arrays.fill(fArr2, 0.0f);
            this.f17366c = false;
        } else {
            Preconditions.b(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, fArr2, 0, 8);
            this.f17366c = false;
            for (int i2 = 0; i2 < 8; i2++) {
                this.f17366c |= fArr[i2] > 0.0f;
            }
        }
        this.w = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f17364a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(int i2, PorterDuff.Mode mode) {
        this.f17364a.setColorFilter(i2, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17364a.setColorFilter(colorFilter);
    }

    public void o() {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void r() {
    }
}
