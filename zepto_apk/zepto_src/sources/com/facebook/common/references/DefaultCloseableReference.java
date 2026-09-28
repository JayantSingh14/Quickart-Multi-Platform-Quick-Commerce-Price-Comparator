package com.facebook.common.references;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class DefaultCloseableReference<T> extends CloseableReference<T> {
    @Override // com.facebook.common.references.CloseableReference
    /* renamed from: a */
    public final CloseableReference clone() {
        Preconditions.e(x());
        return new DefaultCloseableReference(this.f17110b, this.f17111c, this.f17112d != null ? new Throwable() : null);
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (this.f17109a) {
                    super.finalize();
                    return;
                }
                Object objB = this.f17110b.b();
                FLog.s("DefaultCloseableReference", "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f17110b)), objB == null ? null : objB.getClass().getName());
                CloseableReference.LeakHandler leakHandler = this.f17111c;
                if (leakHandler != null) {
                    leakHandler.a(this.f17110b, this.f17112d);
                }
                close();
                super.finalize();
            }
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }
}
