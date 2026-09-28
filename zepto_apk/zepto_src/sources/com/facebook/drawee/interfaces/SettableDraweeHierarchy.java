package com.facebook.drawee.interfaces;

import android.graphics.drawable.Drawable;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes3.dex */
public interface SettableDraweeHierarchy extends DraweeHierarchy {
    void a(DebugControllerOverlayDrawable debugControllerOverlayDrawable);

    void b(float f2, boolean z);

    void d(Drawable drawable, float f2, boolean z);

    void e();

    void reset();
}
