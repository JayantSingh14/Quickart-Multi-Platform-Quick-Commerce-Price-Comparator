package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {

    /* renamed from: g, reason: collision with root package name */
    public static final PorterDuff.Mode f2853g = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f2854a;

    /* renamed from: b, reason: collision with root package name */
    public PorterDuff.Mode f2855b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2856c;

    /* renamed from: d, reason: collision with root package name */
    public WrappedDrawableState f2857d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2858e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f2859f;

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final Drawable a() {
        return this.f2859f;
    }

    @Override // androidx.core.graphics.drawable.WrappedDrawable
    public final void b(Drawable drawable) {
        Drawable drawable2 = this.f2859f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2859f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.f2857d;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.f2862b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final boolean c(int[] iArr) {
        if (this instanceof WrappedDrawableApi21) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.f2857d;
        ColorStateList colorStateList = wrappedDrawableState.f2863c;
        PorterDuff.Mode mode = wrappedDrawableState.f2864d;
        if (colorStateList == null || mode == null) {
            this.f2856c = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f2856c && colorForState == this.f2854a && mode == this.f2855b) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f2854a = colorForState;
        this.f2855b = mode;
        this.f2856c = true;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.f2859f.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.f2857d;
        return changingConfigurations | (wrappedDrawableState != null ? wrappedDrawableState.getChangingConfigurations() : 0) | this.f2859f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.f2857d;
        if (wrappedDrawableState == null || wrappedDrawableState.f2862b == null) {
            return null;
        }
        wrappedDrawableState.f2861a = getChangingConfigurations();
        return this.f2857d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f2859f.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f2859f.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f2859f.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getLayoutDirection() {
        return this.f2859f.getLayoutDirection();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f2859f.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f2859f.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f2859f.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.f2859f.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.f2859f.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.f2859f.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f2859f.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        WrappedDrawableState wrappedDrawableState;
        ColorStateList colorStateList = ((this instanceof WrappedDrawableApi21) || (wrappedDrawableState = this.f2857d) == null) ? null : wrappedDrawableState.f2863c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f2859f.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.f2859f.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f2858e && super.mutate() == this) {
            WrappedDrawableState wrappedDrawableState = this.f2857d;
            WrappedDrawableState wrappedDrawableState2 = new WrappedDrawableState();
            wrappedDrawableState2.f2863c = null;
            wrappedDrawableState2.f2864d = f2853g;
            if (wrappedDrawableState != null) {
                wrappedDrawableState2.f2861a = wrappedDrawableState.f2861a;
                wrappedDrawableState2.f2862b = wrappedDrawableState.f2862b;
                wrappedDrawableState2.f2863c = wrappedDrawableState.f2863c;
                wrappedDrawableState2.f2864d = wrappedDrawableState.f2864d;
            }
            this.f2857d = wrappedDrawableState2;
            Drawable drawable = this.f2859f;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState3 = this.f2857d;
            if (wrappedDrawableState3 != null) {
                Drawable drawable2 = this.f2859f;
                wrappedDrawableState3.f2862b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f2858e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2859f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i2) {
        return this.f2859f.setLayoutDirection(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        return this.f2859f.setLevel(i2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        this.f2859f.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        this.f2859f.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i2) {
        this.f2859f.setChangingConfigurations(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2859f.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.f2859f.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.f2859f.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return c(iArr) || this.f2859f.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2857d.f2863c = colorStateList;
        c(this.f2859f.getState());
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2857d.f2864d = mode;
        c(this.f2859f.getState());
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f2859f.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
