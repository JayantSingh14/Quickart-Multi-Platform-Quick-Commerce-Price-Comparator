package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class DefaultCloseableImage extends BaseCloseableImage {
    public final void finalize() throws Throwable {
        if (((DefaultCloseableXml) this).f17955e) {
            return;
        }
        FLog.s("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
