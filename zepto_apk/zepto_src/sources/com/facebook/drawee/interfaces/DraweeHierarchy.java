package com.facebook.drawee.interfaces;

import android.graphics.Rect;
import com.facebook.drawee.generic.RootDrawable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes3.dex */
public interface DraweeHierarchy {
    RootDrawable c();

    Rect getBounds();
}
