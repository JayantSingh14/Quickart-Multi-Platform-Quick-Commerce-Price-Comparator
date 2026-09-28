package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;

@Nullsafe
/* loaded from: classes3.dex */
public class FadeDrawable extends ArrayDrawable {

    /* renamed from: i, reason: collision with root package name */
    public final Drawable[] f17315i;

    /* renamed from: j, reason: collision with root package name */
    public final int f17316j;

    /* renamed from: k, reason: collision with root package name */
    public int f17317k;

    /* renamed from: l, reason: collision with root package name */
    public int f17318l;

    /* renamed from: m, reason: collision with root package name */
    public long f17319m;
    public final int[] n;
    public final int[] o;
    public int p;
    public final boolean[] q;
    public int r;
    public boolean s;
    public final boolean t;

    public FadeDrawable(Drawable[] drawableArr) {
        super(drawableArr);
        this.t = true;
        if (!(drawableArr.length >= 1)) {
            throw new IllegalStateException("At least one layer required!");
        }
        this.f17315i = drawableArr;
        int[] iArr = new int[drawableArr.length];
        this.n = iArr;
        int[] iArr2 = new int[drawableArr.length];
        this.o = iArr2;
        this.p = 255;
        boolean[] zArr = new boolean[drawableArr.length];
        this.q = zArr;
        this.r = 0;
        this.f17316j = 2;
        this.f17317k = 2;
        Arrays.fill(iArr, 0);
        iArr[0] = 255;
        Arrays.fill(iArr2, 0);
        iArr2[0] = 255;
        Arrays.fill(zArr, false);
        zArr[0] = true;
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean zG;
        int i2;
        int i3 = this.f17317k;
        int[] iArr = this.o;
        Drawable[] drawableArr = this.f17315i;
        if (i3 == 0) {
            System.arraycopy(iArr, 0, this.n, 0, drawableArr.length);
            this.f17319m = SystemClock.uptimeMillis();
            zG = g(this.f17318l == 0 ? 1.0f : 0.0f);
            if (!this.s && (i2 = this.f17316j) >= 0) {
                boolean[] zArr = this.q;
                if (i2 < zArr.length && zArr[i2]) {
                    this.s = true;
                }
            }
            this.f17317k = zG ? 2 : 1;
        } else if (i3 != 1) {
            zG = true;
        } else {
            Preconditions.e(this.f17318l > 0);
            zG = g((SystemClock.uptimeMillis() - this.f17319m) / this.f17318l);
            this.f17317k = zG ? 2 : 1;
        }
        for (int i4 = 0; i4 < drawableArr.length; i4++) {
            Drawable drawable = drawableArr[i4];
            int iCeil = (int) Math.ceil((iArr[i4] * this.p) / 255.0d);
            if (drawable != null && iCeil > 0) {
                this.r++;
                if (this.t) {
                    drawable.mutate();
                }
                drawable.setAlpha(iCeil);
                this.r--;
                drawable.draw(canvas);
            }
        }
        if (!zG) {
            invalidateSelf();
        } else if (this.s) {
            this.s = false;
        }
    }

    public final void e() {
        this.r--;
        invalidateSelf();
    }

    public final void f() {
        this.f17317k = 2;
        for (int i2 = 0; i2 < this.f17315i.length; i2++) {
            this.o[i2] = this.q[i2] ? 255 : 0;
        }
        invalidateSelf();
    }

    public final boolean g(float f2) {
        boolean z = true;
        for (int i2 = 0; i2 < this.f17315i.length; i2++) {
            boolean z2 = this.q[i2];
            int i3 = (int) (((z2 ? 1 : -1) * 255 * f2) + this.n[i2]);
            int[] iArr = this.o;
            iArr[i2] = i3;
            if (i3 < 0) {
                iArr[i2] = 0;
            }
            if (iArr[i2] > 255) {
                iArr[i2] = 255;
            }
            if (z2 && iArr[i2] < 255) {
                z = false;
            }
            if (!z2 && iArr[i2] > 0) {
                z = false;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        if (this.r == 0) {
            super.invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.ArrayDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.p != i2) {
            this.p = i2;
            invalidateSelf();
        }
    }
}
