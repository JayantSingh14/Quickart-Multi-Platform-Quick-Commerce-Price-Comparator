package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public class FadeThroughDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f40570a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f40571b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f40572c;

    /* renamed from: d, reason: collision with root package name */
    public float f40573d;

    public FadeThroughDrawable(Drawable drawable, Drawable drawable2) {
        this.f40570a = drawable.getConstantState().newDrawable().mutate();
        Drawable drawableMutate = drawable2.getConstantState().newDrawable().mutate();
        this.f40571b = drawableMutate;
        drawableMutate.setAlpha(0);
        this.f40572c = new float[2];
    }

    public final void a(float f2) {
        if (this.f40573d != f2) {
            this.f40573d = f2;
            float[] fArr = this.f40572c;
            FadeThroughUtils.a(fArr, f2);
            this.f40570a.setAlpha((int) (fArr[0] * 255.0f));
            this.f40571b.setAlpha((int) (fArr[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.f40570a.draw(canvas);
        this.f40571b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f40570a.getIntrinsicHeight(), this.f40571b.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f40570a.getIntrinsicWidth(), this.f40571b.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return Math.max(this.f40570a.getMinimumHeight(), this.f40571b.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return Math.max(this.f40570a.getMinimumWidth(), this.f40571b.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f40570a.isStateful() || this.f40571b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        float f2 = this.f40573d;
        Drawable drawable = this.f40571b;
        Drawable drawable2 = this.f40570a;
        if (f2 <= 0.5f) {
            drawable2.setAlpha(i2);
            drawable.setAlpha(0);
        } else {
            drawable2.setAlpha(0);
            drawable.setAlpha(i2);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.f40570a.setBounds(i2, i3, i4, i5);
        this.f40571b.setBounds(i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f40570a.setColorFilter(colorFilter);
        this.f40571b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        return this.f40570a.setState(iArr) || this.f40571b.setState(iArr);
    }
}
