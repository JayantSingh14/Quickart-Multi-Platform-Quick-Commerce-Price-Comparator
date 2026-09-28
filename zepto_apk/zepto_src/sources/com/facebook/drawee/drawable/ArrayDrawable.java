package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class ArrayDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f17296a;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable[] f17298c;

    /* renamed from: d, reason: collision with root package name */
    public final DrawableParent[] f17299d;

    /* renamed from: b, reason: collision with root package name */
    public final DrawableProperties f17297b = new DrawableProperties();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f17300e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public boolean f17301f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17302g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17303h = false;

    public ArrayDrawable(Drawable[] drawableArr) {
        int i2 = 0;
        this.f17298c = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.f17298c;
            if (i2 >= drawableArr2.length) {
                this.f17299d = new DrawableParent[drawableArr2.length];
                return;
            } else {
                DrawableUtils.c(drawableArr2[i2], this, this);
                i2++;
            }
        }
    }

    public final Drawable a(int i2) {
        Preconditions.a(Boolean.valueOf(i2 >= 0));
        Drawable[] drawableArr = this.f17298c;
        Preconditions.a(Boolean.valueOf(i2 < drawableArr.length));
        return drawableArr[i2];
    }

    public final DrawableParent b(final int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException();
        }
        DrawableParent[] drawableParentArr = this.f17299d;
        if (!(i2 < drawableParentArr.length)) {
            throw new IllegalArgumentException();
        }
        if (drawableParentArr[i2] == null) {
            drawableParentArr[i2] = new DrawableParent() { // from class: com.facebook.drawee.drawable.ArrayDrawable.1
                @Override // com.facebook.drawee.drawable.DrawableParent
                public final Drawable g(Drawable drawable) {
                    return ArrayDrawable.this.c(drawable, i2);
                }

                @Override // com.facebook.drawee.drawable.DrawableParent
                public final Drawable getDrawable() {
                    return ArrayDrawable.this.a(i2);
                }
            };
        }
        return drawableParentArr[i2];
    }

    public final Drawable c(Drawable drawable, int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException();
        }
        Drawable[] drawableArr = this.f17298c;
        if (!(i2 < drawableArr.length)) {
            throw new IllegalArgumentException();
        }
        Drawable drawable2 = drawableArr[i2];
        if (drawable != drawable2) {
            if (drawable != null && this.f17303h) {
                drawable.mutate();
            }
            DrawableUtils.c(drawableArr[i2], null, null);
            DrawableUtils.c(drawable, null, null);
            DrawableUtils.d(drawable, this.f17297b);
            DrawableUtils.a(drawable, this);
            DrawableUtils.c(drawable, this, this);
            this.f17302g = false;
            drawableArr[i2] = drawable;
            invalidateSelf();
        }
        return drawable2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    @Override // com.facebook.drawee.drawable.TransformCallback
    public final void d(Matrix matrix) {
        ?? r0 = this.f17296a;
        if (r0 != 0) {
            r0.d(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.draw(canvas);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        int i2 = 0;
        int iMax = -1;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                iMax = Math.max(iMax, drawable.getIntrinsicHeight());
            }
            i2++;
        }
        if (iMax > 0) {
            return iMax;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        int i2 = 0;
        int iMax = -1;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                iMax = Math.max(iMax, drawable.getIntrinsicWidth());
            }
            i2++;
        }
        if (iMax > 0) {
            return iMax;
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable[] drawableArr = this.f17298c;
        if (drawableArr.length == 0) {
            return -2;
        }
        int iResolveOpacity = -1;
        for (int i2 = 1; i2 < drawableArr.length; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                iResolveOpacity = Drawable.resolveOpacity(iResolveOpacity, drawable.getOpacity());
            }
        }
        return iResolveOpacity;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        int i2 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                Rect rect2 = this.f17300e;
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i2++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public final void i(TransformCallback transformCallback) {
        this.f17296a = (Drawable) transformCallback;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        if (!this.f17302g) {
            this.f17301f = false;
            int i2 = 0;
            while (true) {
                Drawable[] drawableArr = this.f17298c;
                boolean z = true;
                if (i2 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i2];
                boolean z2 = this.f17301f;
                if (drawable == null || !drawable.isStateful()) {
                    z = false;
                }
                this.f17301f = z2 | z;
                i2++;
            }
            this.f17302g = true;
        }
        return this.f17301f;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                this.f17303h = true;
                return this;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.mutate();
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setBounds(rect);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        int i3 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i3 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null && drawable.setLevel(i2)) {
                z = true;
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int i2 = 0;
        boolean z = false;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return z;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setState(iArr)) {
                z = true;
            }
            i2++;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.drawable.Drawable, com.facebook.drawee.drawable.TransformCallback] */
    @Override // com.facebook.drawee.drawable.TransformCallback
    public final void p(RectF rectF) {
        ?? r0 = this.f17296a;
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
    public void setAlpha(int i2) {
        this.f17297b.f17310a = i2;
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i3 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                drawable.setAlpha(i2);
            }
            i3++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        DrawableProperties drawableProperties = this.f17297b;
        drawableProperties.f17312c = colorFilter;
        int i2 = 0;
        drawableProperties.f17311b = colorFilter != null;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.f17297b.f17313d = z ? 1 : 0;
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setDither(z);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.f17297b.f17314e = z ? 1 : 0;
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setFilterBitmap(z);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f2, float f3) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setHotspot(f2, f3);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f17298c;
            if (i2 >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setVisible(z, z2);
            }
            i2++;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
