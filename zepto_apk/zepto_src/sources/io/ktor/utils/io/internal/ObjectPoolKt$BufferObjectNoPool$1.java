package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.pool.NoPoolImpl;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ObjectPoolKt$BufferObjectNoPool$1 extends NoPoolImpl<ReadWriteBufferState.Initial> {
    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object S0() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(ObjectPoolKt.f51246a);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocateDirect, "allocateDirect(BUFFER_SIZE)");
        return new ReadWriteBufferState.Initial(byteBufferAllocateDirect);
    }
}
