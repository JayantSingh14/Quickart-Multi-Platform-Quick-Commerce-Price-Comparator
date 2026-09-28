package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class OrientedDrawable extends ForwardingDrawable {

    /* renamed from: d, reason: collision with root package name */
    public final Matrix f17325d;

    /* renamed from: e, reason: collision with root package name */
    public final int f17326e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17327f;

    /* renamed from: g, reason: collision with root package name */
    public final Matrix f17328g;

    /* renamed from: h, reason: collision with root package name */
    public final RectF f17329h;

    public OrientedDrawable(BitmapDrawable bitmapDrawable, int i2, int i3) {
        super(bitmapDrawable);
        this.f17325d = new Matrix();
        this.f17326e = i2 - (i2 % 90);
        this.f17327f = (i3 < 0 || i3 > 8) ? 0 : i3;
        this.f17328g = new Matrix();
        this.f17329h = new RectF();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, com.facebook.drawee.drawable.TransformCallback
    public final void d(Matrix transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        t(transform);
        Matrix matrix = this.f17325d;
        if (matrix.isIdentity()) {
            return;
        }
        transform.preConcat(matrix);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.f17326e <= 0 && ((i2 = this.f17327f) == 0 || i2 == 1)) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.concat(this.f17325d);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        int i2 = this.f17327f;
        return (i2 == 5 || i2 == 7 || this.f17326e % 180 != 0) ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        int i2 = this.f17327f;
        return (i2 == 5 || i2 == 7 || this.f17326e % 180 != 0) ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Drawable drawable = this.f17320a;
        if (drawable == null) {
            return;
        }
        int i2 = this.f17327f;
        int i3 = this.f17326e;
        if (i3 <= 0 && (i2 == 0 || i2 == 1)) {
            drawable.setBounds(bounds);
            return;
        }
        Matrix matrix = this.f17325d;
        if (i2 == 2) {
            matrix.setScale(-1.0f, 1.0f);
        } else if (i2 == 7) {
            matrix.setRotate(270.0f, bounds.centerX(), bounds.centerY());
            matrix.postScale(-1.0f, 1.0f);
        } else if (i2 == 4) {
            matrix.setScale(1.0f, -1.0f);
        } else if (i2 != 5) {
            matrix.setRotate(i3, bounds.centerX(), bounds.centerY());
        } else {
            matrix.setRotate(270.0f, bounds.centerX(), bounds.centerY());
            matrix.postScale(1.0f, -1.0f);
        }
        Matrix matrix2 = this.f17328g;
        matrix2.reset();
        matrix.invert(matrix2);
        RectF rectF = this.f17329h;
        rectF.set(bounds);
        matrix2.mapRect(rectF);
        drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }
}
