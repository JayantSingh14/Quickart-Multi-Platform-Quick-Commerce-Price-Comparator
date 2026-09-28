package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class MatrixDrawable extends ForwardingDrawable {

    /* renamed from: d, reason: collision with root package name */
    public int f17323d;

    /* renamed from: e, reason: collision with root package name */
    public int f17324e;

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public final void d(Matrix matrix) {
        t(matrix);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f17320a;
        if (drawable != null && (this.f17323d != drawable.getIntrinsicWidth() || this.f17324e != drawable.getIntrinsicHeight())) {
            v();
        }
        super.draw(canvas);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        v();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable
    public final Drawable u(Drawable drawable) {
        Drawable drawableU = super.u(drawable);
        v();
        return drawableU;
    }

    public final void v() {
        Drawable drawable = this.f17320a;
        if (drawable == null) {
            return;
        }
        Rect bounds = getBounds();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.f17323d = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f17324e = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(bounds);
        } else {
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
    }
}
