package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ScaleTypeDrawable extends ForwardingDrawable {

    /* renamed from: d, reason: collision with root package name */
    public ScalingUtils.ScaleType f17377d;

    /* renamed from: e, reason: collision with root package name */
    public Object f17378e;

    /* renamed from: f, reason: collision with root package name */
    public int f17379f;

    /* renamed from: g, reason: collision with root package name */
    public int f17380g;

    /* renamed from: h, reason: collision with root package name */
    public Matrix f17381h;

    /* renamed from: i, reason: collision with root package name */
    public final Matrix f17382i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleTypeDrawable(Drawable drawable, ScalingUtils.AbstractScaleType scaleType) {
        super(drawable);
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.f17382i = new Matrix();
        this.f17377d = scaleType;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public final void d(Matrix transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        t(transform);
        w();
        Matrix matrix = this.f17381h;
        if (matrix != null) {
            transform.preConcat(matrix);
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        w();
        if (this.f17381h == null) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipRect(getBounds());
        canvas.concat(this.f17381h);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
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
            this.f17380g = 0;
            this.f17379f = 0;
            this.f17381h = null;
            return;
        }
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        this.f17379f = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f17380g = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(bounds);
            this.f17381h = null;
            return;
        }
        if (intrinsicWidth == iWidth && intrinsicHeight == iHeight) {
            drawable.setBounds(bounds);
            this.f17381h = null;
        } else {
            if (this.f17377d == ScalingUtils.ScaleType.f17384a) {
                drawable.setBounds(bounds);
                this.f17381h = null;
                return;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            Matrix matrix = this.f17382i;
            matrix.reset();
            this.f17377d.a(matrix, bounds, intrinsicWidth, intrinsicHeight, 0.5f, 0.5f);
            this.f17381h = matrix;
        }
    }

    public final void w() {
        boolean z;
        ScalingUtils.ScaleType scaleType = this.f17377d;
        if (scaleType instanceof ScalingUtils.StatefulScaleType) {
            Intrinsics.d(scaleType, "null cannot be cast to non-null type com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType");
            Float state = ((ScalingUtils.StatefulScaleType) scaleType).getState();
            Intrinsics.checkNotNullExpressionValue(state, "getState(...)");
            z = !state.equals(this.f17378e);
            this.f17378e = state;
        } else {
            z = false;
        }
        Drawable drawable = this.f17320a;
        if (drawable == null) {
            return;
        }
        if (this.f17379f == drawable.getIntrinsicWidth() && this.f17380g == drawable.getIntrinsicHeight() && !z) {
            return;
        }
        v();
    }
}
