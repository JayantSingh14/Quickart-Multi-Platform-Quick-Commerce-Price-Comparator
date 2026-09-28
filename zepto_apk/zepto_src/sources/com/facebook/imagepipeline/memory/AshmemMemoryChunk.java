package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.nio.ByteBuffer;

@TargetApi(27)
@Nullsafe
/* loaded from: classes3.dex */
public class AshmemMemoryChunk implements MemoryChunk, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public SharedMemory f17979a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f17980b;

    /* renamed from: c, reason: collision with root package name */
    public final long f17981c;

    public AshmemMemoryChunk(int i2) throws ErrnoException {
        if (!(i2 > 0)) {
            throw new IllegalArgumentException();
        }
        try {
            SharedMemory sharedMemoryCreate = SharedMemory.create("AshmemMemoryChunk", i2);
            this.f17979a = sharedMemoryCreate;
            this.f17980b = sharedMemoryCreate.mapReadWrite();
            this.f17981c = System.identityHashCode(this);
        } catch (ErrnoException e2) {
            throw new RuntimeException("Fail to create AshmemMemory", e2);
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final long a() {
        return this.f17981c;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final void b(MemoryChunk memoryChunk, int i2) {
        memoryChunk.getClass();
        if (memoryChunk.a() == this.f17981c) {
            Log.w("AshmemMemoryChunk", "Copying from AshmemMemoryChunk " + Long.toHexString(this.f17981c) + " to AshmemMemoryChunk " + Long.toHexString(memoryChunk.a()) + " which are the same ");
            Preconditions.a(Boolean.FALSE);
        }
        if (memoryChunk.a() < this.f17981c) {
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
        this.f17980b.getClass();
        iA = MemoryChunkUtil.a(i2, i4, getSize());
        MemoryChunkUtil.b(i2, bArr.length, i3, iA, getSize());
        this.f17980b.position(i2);
        this.f17980b.put(bArr, i3, iA);
        return iA;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (!isClosed()) {
                SharedMemory sharedMemory = this.f17979a;
                if (sharedMemory != null) {
                    sharedMemory.close();
                }
                ByteBuffer byteBuffer = this.f17980b;
                if (byteBuffer != null) {
                    SharedMemory.unmap(byteBuffer);
                }
                this.f17980b = null;
                this.f17979a = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void e(MemoryChunk memoryChunk, int i2) {
        if (!(memoryChunk instanceof AshmemMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        Preconditions.e(!isClosed());
        AshmemMemoryChunk ashmemMemoryChunk = (AshmemMemoryChunk) memoryChunk;
        Preconditions.e(!ashmemMemoryChunk.isClosed());
        this.f17980b.getClass();
        ashmemMemoryChunk.f17980b.getClass();
        MemoryChunkUtil.b(0, ashmemMemoryChunk.getSize(), 0, i2, getSize());
        this.f17980b.position(0);
        ashmemMemoryChunk.f17980b.position(0);
        byte[] bArr = new byte[i2];
        this.f17980b.get(bArr, 0, i2);
        ashmemMemoryChunk.f17980b.put(bArr, 0, i2);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final int getSize() {
        this.f17979a.getClass();
        return this.f17979a.getSize();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x000e  */
    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean isClosed() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.nio.ByteBuffer r0 = r1.f17980b     // Catch: java.lang.Throwable -> Lc
            if (r0 == 0) goto Le
            android.os.SharedMemory r0 = r1.f17979a     // Catch: java.lang.Throwable -> Lc
            if (r0 != 0) goto La
            goto Le
        La:
            r0 = 0
            goto Lf
        Lc:
            r0 = move-exception
            goto L11
        Le:
            r0 = 1
        Lf:
            monitor-exit(r1)
            return r0
        L11:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lc
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.AshmemMemoryChunk.isClosed():boolean");
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized byte q(int i2) {
        Preconditions.e(!isClosed());
        Preconditions.a(Boolean.valueOf(i2 >= 0));
        Preconditions.a(Boolean.valueOf(i2 < getSize()));
        this.f17980b.getClass();
        return this.f17980b.get(i2);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized int u(int i2, int i3, byte[] bArr, int i4) {
        int iA;
        this.f17980b.getClass();
        iA = MemoryChunkUtil.a(i2, i4, getSize());
        MemoryChunkUtil.b(i2, bArr.length, i3, iA, getSize());
        this.f17980b.position(i2);
        this.f17980b.get(bArr, i3, iA);
        return iA;
    }

    @VisibleForTesting
    public AshmemMemoryChunk() {
        this.f17979a = null;
        this.f17980b = null;
        this.f17981c = System.identityHashCode(this);
    }
}
