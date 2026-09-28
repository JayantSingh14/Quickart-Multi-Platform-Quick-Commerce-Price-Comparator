package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.nio.ByteBuffer;

@Nullsafe
/* loaded from: classes3.dex */
public class BufferMemoryChunk implements MemoryChunk, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f18013a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18014b;

    /* renamed from: c, reason: collision with root package name */
    public final long f18015c = System.identityHashCode(this);

    public BufferMemoryChunk(int i2) {
        this.f18013a = ByteBuffer.allocateDirect(i2);
        this.f18014b = i2;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final long a() {
        return this.f18015c;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final void b(MemoryChunk memoryChunk, int i2) {
        memoryChunk.getClass();
        if (memoryChunk.a() == this.f18015c) {
            Log.w("BufferMemoryChunk", "Copying from BufferMemoryChunk " + Long.toHexString(this.f18015c) + " to BufferMemoryChunk " + Long.toHexString(memoryChunk.a()) + " which are the same ");
            Preconditions.a(Boolean.FALSE);
        }
        if (memoryChunk.a() < this.f18015c) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    e(memoryChunk, i2);
                }
            }
        } else {
            synchronized (this) {
                synchronized (memoryChunk) {
                    e(memoryChunk, i2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized int c(int i2, int i3, byte[] bArr, int i4) {
        int iA;
        Preconditions.e(!isClosed());
        this.f18013a.getClass();
        iA = MemoryChunkUtil.a(i2, i4, this.f18014b);
        MemoryChunkUtil.b(i2, bArr.length, i3, iA, this.f18014b);
        this.f18013a.position(i2);
        this.f18013a.put(bArr, i3, iA);
        return iA;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f18013a = null;
    }

    public final void e(MemoryChunk memoryChunk, int i2) {
        ByteBuffer byteBuffer;
        if (!(memoryChunk instanceof BufferMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        Preconditions.e(!isClosed());
        BufferMemoryChunk bufferMemoryChunk = (BufferMemoryChunk) memoryChunk;
        Preconditions.e(!bufferMemoryChunk.isClosed());
        this.f18013a.getClass();
        MemoryChunkUtil.b(0, bufferMemoryChunk.f18014b, 0, i2, this.f18014b);
        this.f18013a.position(0);
        synchronized (bufferMemoryChunk) {
            byteBuffer = bufferMemoryChunk.f18013a;
        }
        byteBuffer.getClass();
        byteBuffer.position(0);
        byte[] bArr = new byte[i2];
        this.f18013a.get(bArr, 0, i2);
        byteBuffer.put(bArr, 0, i2);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final int getSize() {
        return this.f18014b;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized boolean isClosed() {
        return this.f18013a == null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized byte q(int i2) {
        Preconditions.e(!isClosed());
        Preconditions.a(Boolean.valueOf(i2 >= 0));
        Preconditions.a(Boolean.valueOf(i2 < this.f18014b));
        this.f18013a.getClass();
        return this.f18013a.get(i2);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized int u(int i2, int i3, byte[] bArr, int i4) {
        int iA;
        Preconditions.e(!isClosed());
        this.f18013a.getClass();
        iA = MemoryChunkUtil.a(i2, i4, this.f18014b);
        MemoryChunkUtil.b(i2, bArr.length, i3, iA, this.f18014b);
        this.f18013a.position(i2);
        this.f18013a.get(bArr, i3, iA);
        return iA;
    }
}
