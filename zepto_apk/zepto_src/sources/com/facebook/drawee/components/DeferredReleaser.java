package com.facebook.drawee.components;

import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public abstract class DeferredReleaser {

    /* renamed from: a, reason: collision with root package name */
    public static DeferredReleaser f17223a;

    /* loaded from: classes3.dex */
    public interface Releasable {
        void release();
    }

    public static synchronized DeferredReleaser b() {
        try {
            if (f17223a == null) {
                f17223a = new DeferredReleaserConcurrentImpl();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f17223a;
    }

    public abstract void a(AbstractDraweeController abstractDraweeController);

    public abstract void c(AbstractDraweeController abstractDraweeController);
}
