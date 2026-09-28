package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable, CloneableDrawable {

    /* renamed from: d, reason: collision with root package name */
    public final int f17306d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f17307e;

    /* renamed from: f, reason: collision with root package name */
    public float f17308f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f17309g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoRotateDrawable(Drawable drawable, int i2) {
        super(drawable);
        drawable.getClass();
        this.f17308f = 0.0f;
        this.f17309g = false;
        this.f17306d = i2;
        this.f17307e = true;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int iSave = canvas.save();
        Rect bounds = getBounds();
        int i2 = bounds.right - bounds.left;
        int i3 = bounds.bottom - bounds.top;
        float f2 = this.f17308f;
        if (!this.f17307e) {
            f2 = 360.0f - f2;
        }
        canvas.rotate(f2, (i2 / 2) + r3, (i3 / 2) + r1);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
        if (this.f17309g) {
            return;
        }
        this.f17309g = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17309g = false;
        this.f17308f += (int) ((20.0f / this.f17306d) * 360.0f);
        invalidateSelf();
    }
}
