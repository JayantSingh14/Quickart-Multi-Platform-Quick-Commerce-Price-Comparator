package io.ktor.util.cio;

import io.ktor.util.InternalAPI;
import io.ktor.utils.io.pool.DefaultPool;
import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@Deprecated
@InternalAPI
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ByteBufferPool extends DefaultPool<ByteBuffer> {
    public ByteBufferPool() {
        super(2048);
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object c(Object obj) {
        ByteBuffer instance = (ByteBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        instance.clear();
        return instance;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object l() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4098);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(DEFAULT_BUFFER_SIZE)");
        return byteBufferAllocate;
    }
}
