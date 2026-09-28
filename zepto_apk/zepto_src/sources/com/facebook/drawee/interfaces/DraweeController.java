package com.facebook.drawee.interfaces;

import android.view.MotionEvent;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes3.dex */
public interface DraweeController {
    boolean a(MotionEvent motionEvent);

    void b();

    void c(DraweeHierarchy draweeHierarchy);

    void d();

    SettableDraweeHierarchy e();
}
