package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public class FixedSizeDrawable extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f16489a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f16490b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f16491c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f16492d;

    /* renamed from: e, reason: collision with root package name */
    public State f16493e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16494f;

    public static final class State extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f16495a;

        public State(Drawable.ConstantState constantState) {
            this.f16495a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.f16495a.newDrawable());
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.f16495a.newDrawable(resources));
        }
    }

    public FixedSizeDrawable(State state, Drawable drawable) {
        this.f16493e = state;
        Preconditions.c(drawable, "Argument must not be null");
        this.f16492d = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f16489a = new Matrix();
        this.f16490b = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f16491c = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    public final void clearColorFilter() {
        this.f16492d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f16489a);
        this.f16492d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f16492d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.Callback getCallback() {
        return this.f16492d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return this.f16492d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f16493e;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f16492d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        this.f16493e.getClass();
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        this.f16493e.getClass();
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f16492d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f16492d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f16492d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.f16492d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        super.invalidateSelf();
        this.f16492d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f16494f && super.mutate() == this) {
            this.f16492d = this.f16492d.mutate();
            this.f16493e = new State(this.f16493e.f16495a);
            this.f16494f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j2) {
        super.scheduleSelf(runnable, j2);
        this.f16492d.scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f16492d.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        RectF rectF = this.f16491c;
        rectF.set(i2, i3, i4, i5);
        this.f16489a.setRectToRect(this.f16490b, rectF, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i2) {
        this.f16492d.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(int i2, PorterDuff.Mode mode) {
        this.f16492d.setColorFilter(i2, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.f16492d.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.f16492d.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return this.f16492d.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f16492d.unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f16492d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect rect) {
        super.setBounds(rect);
        RectF rectF = this.f16491c;
        rectF.set(rect);
        this.f16489a.setRectToRect(this.f16490b, rectF, Matrix.ScaleToFit.CENTER);
    }
}
