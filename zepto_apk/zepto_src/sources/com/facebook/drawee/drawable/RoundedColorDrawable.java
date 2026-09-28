package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe
/* loaded from: classes3.dex */
public class RoundedColorDrawable extends Drawable implements Rounded {

    /* renamed from: k, reason: collision with root package name */
    public final int f17348k;

    /* renamed from: a, reason: collision with root package name */
    public final float[] f17338a = new float[8];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f17339b = new float[8];

    /* renamed from: c, reason: collision with root package name */
    public final Paint f17340c = new Paint(1);

    /* renamed from: d, reason: collision with root package name */
    public boolean f17341d = false;

    /* renamed from: e, reason: collision with root package name */
    public float f17342e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f17343f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public int f17344g = 0;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17345h = false;

    /* renamed from: i, reason: collision with root package name */
    public final Path f17346i = new Path();

    /* renamed from: j, reason: collision with root package name */
    public final Path f17347j = new Path();

    /* renamed from: l, reason: collision with root package name */
    public final RectF f17349l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    public int f17350m = 255;

    public RoundedColorDrawable(int i2) {
        this.f17348k = 0;
        if (this.f17348k != i2) {
            this.f17348k = i2;
            invalidateSelf();
        }
    }

    public final void a() {
        float[] fArr;
        Path path = this.f17346i;
        path.reset();
        Path path2 = this.f17347j;
        path2.reset();
        RectF rectF = this.f17349l;
        rectF.set(getBounds());
        float f2 = this.f17342e / 2.0f;
        rectF.inset(f2, f2);
        boolean z = this.f17341d;
        float[] fArr2 = this.f17338a;
        if (z) {
            path2.addCircle(rectF.centerX(), rectF.centerY(), Math.min(rectF.width(), rectF.height()) / 2.0f, Path.Direction.CW);
        } else {
            int i2 = 0;
            while (true) {
                fArr = this.f17339b;
                if (i2 >= fArr.length) {
                    break;
                }
                fArr[i2] = (fArr2[i2] + this.f17343f) - (this.f17342e / 2.0f);
                i2++;
            }
            path2.addRoundRect(rectF, fArr, Path.Direction.CW);
        }
        float f3 = (-this.f17342e) / 2.0f;
        rectF.inset(f3, f3);
        float f4 = this.f17343f + 0.0f;
        rectF.inset(f4, f4);
        if (this.f17341d) {
            path.addCircle(rectF.centerX(), rectF.centerY(), Math.min(rectF.width(), rectF.height()) / 2.0f, Path.Direction.CW);
        } else {
            path.addRoundRect(rectF, fArr2, Path.Direction.CW);
        }
        float f5 = -f4;
        rectF.inset(f5, f5);
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void b(boolean z) {
        this.f17341d = z;
        a();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void c(float f2, int i2) {
        if (this.f17344g != i2) {
            this.f17344g = i2;
            invalidateSelf();
        }
        if (this.f17342e != f2) {
            this.f17342e = f2;
            a();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint = this.f17340c;
        paint.setColor(DrawableUtils.b(this.f17348k, this.f17350m));
        paint.setStyle(Paint.Style.FILL);
        paint.setFilterBitmap(this.f17345h);
        canvas.drawPath(this.f17346i, paint);
        if (this.f17342e != 0.0f) {
            paint.setColor(DrawableUtils.b(this.f17344g, this.f17350m));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f17342e);
            canvas.drawPath(this.f17347j, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f17350m;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        int iB = DrawableUtils.b(this.f17348k, this.f17350m) >>> 24;
        if (iB != 0) {
            return iB != 255 ? -3 : -1;
        }
        return -2;
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void h(float f2) {
        if (this.f17343f != f2) {
            this.f17343f = f2;
            a();
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void k() {
        Arrays.fill(this.f17338a, 0.0f);
        a();
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void m(boolean z) {
        if (this.f17345h != z) {
            this.f17345h = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a();
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void s(float[] fArr) {
        float[] fArr2 = this.f17338a;
        if (fArr == null) {
            Arrays.fill(fArr2, 0.0f);
        } else {
            Preconditions.b(fArr.length == 8, "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, fArr2, 0, 8);
        }
        a();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (i2 != this.f17350m) {
            this.f17350m = i2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void o() {
    }

    @Override // com.facebook.drawee.drawable.Rounded
    public final void r() {
    }
}
