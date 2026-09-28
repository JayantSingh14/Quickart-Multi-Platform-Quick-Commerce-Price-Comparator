package io.ktor.utils.io.pool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class DirectByteBufferPool extends DefaultPool<ByteBuffer> {

    /* renamed from: f, reason: collision with root package name */
    public final int f51375f;

    public DirectByteBufferPool() {
        this(2000, 4096);
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
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.f51375f);
        Intrinsics.c(byteBufferAllocateDirect);
        return byteBufferAllocateDirect;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void s(Object obj) {
        ByteBuffer instance = (ByteBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance.capacity() != this.f51375f) {
            throw new IllegalStateException("Check failed.");
        }
        if (!instance.isDirect()) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public DirectByteBufferPool(int i2, int i3) {
        super(i2);
        this.f51375f = i3;
    }
}
