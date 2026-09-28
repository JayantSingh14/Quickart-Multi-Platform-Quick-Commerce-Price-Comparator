package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class ForwardingDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f17320a;

    /* renamed from: b, reason: collision with root package name */
    public final DrawableProperties f17321b = new DrawableProperties();

    /* renamed from: c, reason: collision with root package name */
    public Drawable f17322c;

    static {
        new Matrix();
    }

    public ForwardingDrawable(Drawable drawable) {
        this.f17320a = drawable;
        DrawableUtils.c(drawable, this, this);
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void d(Matrix matrix) {
        t(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f17320a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public final Drawable g(Drawable drawable) {
        return u(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f17320a;
        return drawable == null ? super.getConstantState() : drawable.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f17320a;
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public final Drawable getDrawable() {
        return this.f17320a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f17320a;
        return drawable == null ? super.getIntrinsicHeight() : drawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f17320a;
        return drawable == null ? super.getIntrinsicWidth() : drawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f17320a;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Drawable drawable = this.f17320a;
        return drawable == null ? super.getPadding(rect) : drawable.getPadding(rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public final void i(TransformCallback transformCallback) {
        this.f17322c = (Drawable) transformCallback;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f17320a;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f17320a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f17320a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f17320a;
        return drawable == null ? super.onLevelChange(i2) : drawable.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f17320a;
        return drawable == null ? super.onStateChange(iArr) : drawable.setState(iArr);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    @Override // com.facebook.drawee.drawable.TransformCallback
    public final void p(RectF rectF) {
        ?? r0 = this.f17322c;
        if (r0 != 0) {
            r0.p(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f17321b.f17310a = i2;
        Drawable drawable = this.f17320a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        DrawableProperties drawableProperties = this.f17321b;
        drawableProperties.f17312c = colorFilter;
        drawableProperties.f17311b = colorFilter != null;
        Drawable drawable = this.f17320a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.f17321b.f17313d = z ? 1 : 0;
        Drawable drawable = this.f17320a;
        if (drawable != null) {
            drawable.setDither(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.f17321b.f17314e = z ? 1 : 0;
        Drawable drawable = this.f17320a;
        if (drawable != null) {
            drawable.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f2, float f3) {
        Drawable drawable = this.f17320a;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f17320a;
        return drawable == null ? visible : drawable.setVisible(z, z2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    public final void t(Matrix matrix) {
        ?? r0 = this.f17322c;
        if (r0 != 0) {
            r0.d(matrix);
        } else {
            matrix.reset();
        }
    }

    public Drawable u(Drawable drawable) {
        Drawable drawable2 = this.f17320a;
        DrawableUtils.c(drawable2, null, null);
        DrawableUtils.c(drawable, null, null);
        DrawableUtils.d(drawable, this.f17321b);
        DrawableUtils.a(drawable, this);
        DrawableUtils.c(drawable, this, this);
        this.f17320a = drawable;
        invalidateSelf();
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
