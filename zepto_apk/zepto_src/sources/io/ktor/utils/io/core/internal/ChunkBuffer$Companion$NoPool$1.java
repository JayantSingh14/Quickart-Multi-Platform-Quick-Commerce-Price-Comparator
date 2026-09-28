package io.ktor.utils.io.core.internal;

import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.pool.NoPoolImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ChunkBuffer$Companion$NoPool$1 extends NoPoolImpl<ChunkBuffer> {
    @Override // io.ktor.utils.io.pool.NoPoolImpl, io.ktor.utils.io.pool.ObjectPool
    public final void G1(Object obj) {
        ChunkBuffer instance = (ChunkBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        DefaultAllocator.f51174a.a(instance.f51180a);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object S0() {
        return new ChunkBuffer(DefaultAllocator.f51174a.b(4096), null, this);
    }
}
