package com.facebook.common.references;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class NoOpCloseableReference<T> extends CloseableReference<T> {
    @Override // com.facebook.common.references.CloseableReference
    /* renamed from: a */
    public final CloseableReference clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference
    public final CloseableReference b() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference
    public final Object clone() {
        return this;
    }

    @Override // com.facebook.common.references.CloseableReference, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.facebook.common.references.CloseableReference
    public final boolean x() {
        return true;
    }
}
