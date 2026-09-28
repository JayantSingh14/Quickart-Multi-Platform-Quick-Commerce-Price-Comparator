package io.ktor.utils.io.core;

import android.support.v4.media.b;
import io.ktor.utils.io.bits.Allocator;
import io.ktor.utils.io.bits.DefaultAllocator;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.DefaultPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DefaultBufferPool extends DefaultPool<ChunkBuffer> {

    /* renamed from: f, reason: collision with root package name */
    public final int f51192f;

    /* renamed from: g, reason: collision with root package name */
    public final Allocator f51193g;

    public DefaultBufferPool() {
        this(0);
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object c(Object obj) {
        ChunkBuffer instance = (ChunkBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(instance, "instance");
        instance.n();
        instance.l();
        return instance;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void e(Object obj) {
        ChunkBuffer instance = (ChunkBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        this.f51193g.a(instance.f51180a);
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (!ChunkBuffer.f51214j.compareAndSet(instance, 0, -1)) {
            throw new IllegalStateException("Unable to unlink: buffer is in use.");
        }
        instance.g();
        instance.f51218h = null;
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final Object l() {
        return new ChunkBuffer(this.f51193g.b(this.f51192f), null, this);
    }

    @Override // io.ktor.utils.io.pool.DefaultPool
    public final void s(Object obj) {
        ChunkBuffer instance = (ChunkBuffer) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        super.s(instance);
        long jLimit = instance.f51180a.limit();
        int i2 = this.f51192f;
        if (jLimit != i2) {
            StringBuilder sbU = b.u(i2, "Buffer size mismatch. Expected: ", ", actual: ");
            sbU.append(r0.limit());
            throw new IllegalStateException(sbU.toString().toString());
        }
        ChunkBuffer chunkBuffer = ChunkBuffer.f51216l;
        if (instance == chunkBuffer) {
            throw new IllegalStateException("ChunkBuffer.Empty couldn't be recycled");
        }
        if (instance == chunkBuffer) {
            throw new IllegalStateException("Empty instance couldn't be recycled");
        }
        if (instance.j() != 0) {
            throw new IllegalStateException("Unable to clear buffer: it is still in use.");
        }
        if (instance.i() != null) {
            throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.");
        }
        if (instance.f51218h != null) {
            throw new IllegalStateException("Recycled instance shouldn't be a view or another buffer.");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultBufferPool(int i2) {
        super(1000);
        DefaultAllocator allocator = DefaultAllocator.f51174a;
        Intrinsics.checkNotNullParameter(allocator, "allocator");
        this.f51192f = 4096;
        this.f51193g = allocator;
    }
}
