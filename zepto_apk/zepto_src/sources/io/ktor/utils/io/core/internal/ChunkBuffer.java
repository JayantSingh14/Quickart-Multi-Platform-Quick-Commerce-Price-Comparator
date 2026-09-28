package io.ktor.utils.io.core.internal;

import com.google.android.gms.internal.pal.a;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Deprecated
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ChunkBuffer extends Buffer {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51213i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f51214j;

    /* renamed from: k, reason: collision with root package name */
    public static final ChunkBuffer$Companion$EmptyPool$1 f51215k;

    /* renamed from: l, reason: collision with root package name */
    public static final ChunkBuffer f51216l;

    /* renamed from: g, reason: collision with root package name */
    public final ObjectPool f51217g;

    /* renamed from: h, reason: collision with root package name */
    public ChunkBuffer f51218h;

    @NotNull
    private volatile /* synthetic */ Object nextRef;

    @NotNull
    private volatile /* synthetic */ int refCount;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    static {
        ChunkBuffer$Companion$EmptyPool$1 chunkBuffer$Companion$EmptyPool$1 = new ChunkBuffer$Companion$EmptyPool$1();
        f51215k = chunkBuffer$Companion$EmptyPool$1;
        f51216l = new ChunkBuffer(Memory.f51175b, null, chunkBuffer$Companion$EmptyPool$1);
        new ChunkBuffer$Companion$NoPool$1();
        new ChunkBuffer$Companion$NoPoolManuallyManaged$1();
        f51213i = AtomicReferenceFieldUpdater.newUpdater(ChunkBuffer.class, Object.class, "nextRef");
        f51214j = AtomicIntegerFieldUpdater.newUpdater(ChunkBuffer.class, "refCount");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChunkBuffer(ByteBuffer memory, ChunkBuffer chunkBuffer, ObjectPool objectPool) {
        super(memory);
        Intrinsics.checkNotNullParameter(memory, "memory");
        this.f51217g = objectPool;
        if (chunkBuffer == this) {
            throw new IllegalArgumentException("A chunk couldn't be a view of itself.");
        }
        this.nextRef = null;
        this.refCount = 1;
        this.f51218h = chunkBuffer;
    }

    public final ChunkBuffer g() {
        return (ChunkBuffer) f51213i.getAndSet(this, null);
    }

    public final ChunkBuffer h() {
        int i2;
        ChunkBuffer chunkBuffer = this.f51218h;
        if (chunkBuffer == null) {
            chunkBuffer = this;
        }
        do {
            i2 = chunkBuffer.refCount;
            if (i2 <= 0) {
                throw new IllegalStateException("Unable to acquire chunk: it is already released.");
            }
        } while (!f51214j.compareAndSet(chunkBuffer, i2, i2 + 1));
        ChunkBuffer copy = new ChunkBuffer(this.f51180a, chunkBuffer, this.f51217g);
        Intrinsics.checkNotNullParameter(copy, "copy");
        copy.f51184e = this.f51184e;
        copy.f51183d = this.f51183d;
        copy.f51181b = this.f51181b;
        copy.f51182c = this.f51182c;
        return copy;
    }

    public final ChunkBuffer i() {
        return (ChunkBuffer) this.nextRef;
    }

    public final int j() {
        return this.refCount;
    }

    public final void k(ObjectPool pool) {
        int i2;
        int i3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        Intrinsics.checkNotNullParameter(pool, "pool");
        do {
            i2 = this.refCount;
            if (i2 <= 0) {
                throw new IllegalStateException("Unable to release: it is already released.");
            }
            i3 = i2 - 1;
            atomicIntegerFieldUpdater = f51214j;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, i3));
        if (i3 == 0) {
            ChunkBuffer chunkBuffer = this.f51218h;
            if (chunkBuffer == null) {
                ObjectPool objectPool = this.f51217g;
                if (objectPool != null) {
                    pool = objectPool;
                }
                pool.G1(this);
                return;
            }
            if (!atomicIntegerFieldUpdater.compareAndSet(this, 0, -1)) {
                throw new IllegalStateException("Unable to unlink: buffer is in use.");
            }
            g();
            this.f51218h = null;
            chunkBuffer.k(pool);
        }
    }

    public final void l() {
        if (this.f51218h != null) {
            throw new IllegalArgumentException("Unable to reset buffer with origin");
        }
        d(0);
        int i2 = this.f51185f;
        this.f51184e = i2;
        f(i2 - this.f51183d);
        this.nextRef = null;
    }

    public final void m(ChunkBuffer chunkBuffer) {
        if (chunkBuffer == null) {
            g();
        } else if (!a.n(f51213i, this, chunkBuffer)) {
            throw new IllegalStateException("This chunk has already a next chunk.");
        }
    }

    public final void n() {
        int i2;
        do {
            i2 = this.refCount;
            if (i2 < 0) {
                throw new IllegalStateException("This instance is already disposed and couldn't be borrowed.");
            }
            if (i2 > 0) {
                throw new IllegalStateException("This instance is already in use but somehow appeared in the pool.");
            }
        } while (!f51214j.compareAndSet(this, i2, 1));
    }
}
