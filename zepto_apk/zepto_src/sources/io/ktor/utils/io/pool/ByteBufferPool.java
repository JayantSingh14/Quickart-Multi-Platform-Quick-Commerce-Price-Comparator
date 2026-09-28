package io.ktor.utils.io.pool;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ByteBufferPool extends DefaultPool<ByteBuffer> {

    /* renamed from: f, reason: collision with root package name */
    public final int f51368f;

    public ByteBufferPool() {
        this(0);
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
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f51368f);
        Intrinsics.c(byteBufferAllocate);
        return byteBufferAllocate;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void s(Object obj) {
        ByteBuffer instance = (ByteBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance.capacity() != this.f51368f) {
            throw new IllegalStateException("Check failed.");
        }
        if (instance.isDirect()) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public /* synthetic */ ByteBufferPool(int i2) {
        this(2000, 4096);
    }

    public ByteBufferPool(int i2, int i3) {
        super(i2);
        this.f51368f = i3;
    }
}
