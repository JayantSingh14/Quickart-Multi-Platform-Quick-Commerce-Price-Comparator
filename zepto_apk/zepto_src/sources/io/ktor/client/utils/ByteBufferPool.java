package io.ktor.client.utils;

import io.ktor.util.InternalAPI;
import io.ktor.utils.io.pool.DefaultPool;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Deprecated
@InternalAPI
@Metadata
/* loaded from: classes3.dex */
public final class ByteBufferPool extends DefaultPool<ByteBuffer> {
    public ByteBufferPool() {
        super(1000);
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object c(Object obj) {
        ByteBuffer instance = (ByteBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        instance.clear();
        instance.order(ByteOrder.BIG_ENDIAN);
        return instance;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object l() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4096);
        Intrinsics.c(byteBufferAllocate);
        return byteBufferAllocate;
    }
}
