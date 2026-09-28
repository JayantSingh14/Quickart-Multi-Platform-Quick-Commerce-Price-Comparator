package io.ktor.utils.io.pool;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class NoPoolImpl<T> implements ObjectPool<T> {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public void G1(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
    }
}
