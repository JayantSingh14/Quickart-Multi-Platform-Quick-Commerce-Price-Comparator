package com.facebook.common.references;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class FinalizerCloseableReference<T> extends CloseableReference<T> {
    @Override // com.facebook.common.references.CloseableReference
    /* renamed from: a */
    public final CloseableReference clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference
    public final Object clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.f17109a) {
                    return;
                }
                Object objB = this.f17110b.b();
                FLog.s("FinalizerCloseableReference", "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f17110b)), objB == null ? null : objB.getClass().getName());
                this.f17110b.a();
            }
        } finally {
            super.finalize();
        }
    }
}
