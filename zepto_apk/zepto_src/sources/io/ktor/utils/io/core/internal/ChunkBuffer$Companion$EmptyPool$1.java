package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ChunkBuffer$Companion$EmptyPool$1 implements ObjectPool<ChunkBuffer> {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void G1(Object obj) {
        ChunkBuffer instance = (ChunkBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance != ChunkBuffer.f51216l) {
            throw new IllegalArgumentException("Only ChunkBuffer.Empty instance could be recycled.");
        }
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object S0() {
        return ChunkBuffer.f51216l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
    }
}
