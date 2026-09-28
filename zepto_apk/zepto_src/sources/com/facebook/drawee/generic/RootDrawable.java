package com.facebook.drawee.generic;

import android.graphics.Canvas;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {

    /* renamed from: d, reason: collision with root package name */
    public DebugControllerOverlayDrawable f17425d;

    /* renamed from: e, reason: collision with root package name */
    public DraweeHolder f17426e;

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (isVisible()) {
            DraweeHolder draweeHolder = this.f17426e;
            if (draweeHolder != null && !draweeHolder.f17447a) {
                FLog.p(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(draweeHolder)), Integer.valueOf(System.identityHashCode(draweeHolder.f17451e)), draweeHolder.toString());
                draweeHolder.f17448b = true;
                draweeHolder.f17449c = true;
                draweeHolder.b();
            }
            super.draw(canvas);
            DebugControllerOverlayDrawable debugControllerOverlayDrawable = this.f17425d;
            if (debugControllerOverlayDrawable != null) {
                debugControllerOverlayDrawable.setBounds(getBounds());
                this.f17425d.draw(canvas);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.VisibilityAwareDrawable
    public final void j(DraweeHolder draweeHolder) {
        this.f17426e = draweeHolder;
    }

    @Override // com.facebook.drawee.drawable.ForwardingDrawable, android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        DraweeHolder draweeHolder = this.f17426e;
        if (draweeHolder != null) {
            draweeHolder.k(z);
        }
        return super.setVisible(z, z2);
    }
}
