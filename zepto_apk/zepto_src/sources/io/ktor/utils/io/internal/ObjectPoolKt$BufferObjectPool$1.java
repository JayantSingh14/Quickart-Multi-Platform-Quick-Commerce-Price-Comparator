package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.pool.DefaultPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ObjectPoolKt$BufferObjectPool$1 extends DefaultPool<ReadWriteBufferState.Initial> {
    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void e(Object obj) {
        ReadWriteBufferState.Initial instance = (ReadWriteBufferState.Initial) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        ObjectPoolKt.f51247b.G1(instance.f51253a);
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object l() {
        return new ReadWriteBufferState.Initial((ByteBuffer) ObjectPoolKt.f51247b.S0());
    }
}
