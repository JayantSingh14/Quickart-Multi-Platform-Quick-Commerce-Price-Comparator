package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class MemoryPooledByteBuffer implements PooledByteBuffer {

    /* renamed from: a, reason: collision with root package name */
    public final int f18027a;

    /* renamed from: b, reason: collision with root package name */
    public CloseableReference f18028b;

    public MemoryPooledByteBuffer(DefaultCloseableReference defaultCloseableReference, int i2) {
        defaultCloseableReference.getClass();
        if (!(i2 >= 0 && i2 <= ((MemoryChunk) defaultCloseableReference.l()).getSize())) {
            throw new IllegalArgumentException();
        }
        this.f18028b = defaultCloseableReference.clone();
        this.f18027a = i2;
    }

    public final synchronized void a() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        CloseableReference.e(this.f18028b);
        this.f18028b = null;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public final synchronized boolean isClosed() {
        return !CloseableReference.A(this.f18028b);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public final synchronized byte q(int i2) {
        a();
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException();
        }
        if (!(i2 < this.f18027a)) {
            throw new IllegalArgumentException();
        }
        this.f18028b.getClass();
        return ((MemoryChunk) this.f18028b.l()).q(i2);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public final synchronized int size() {
        a();
        return this.f18027a;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public final synchronized int u(int i2, int i3, byte[] bArr, int i4) {
        a();
        if (!(i2 + i4 <= this.f18027a)) {
            throw new IllegalArgumentException();
        }
        this.f18028b.getClass();
        return ((MemoryChunk) this.f18028b.l()).u(i2, i3, bArr, i4);
    }
}
