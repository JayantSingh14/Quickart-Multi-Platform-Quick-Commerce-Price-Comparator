package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.soloader.nativeloader.NativeLoader;
import java.io.Closeable;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public class NativeMemoryChunk implements MemoryChunk, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final long f18034a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18035b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18036c;

    static {
        NativeLoader.b("imagepipeline");
    }

    public NativeMemoryChunk(int i2) {
        if (!(i2 > 0)) {
            throw new IllegalArgumentException();
        }
        this.f18035b = i2;
        this.f18034a = nativeAllocate(i2);
        this.f18036c = false;
    }

    @DoNotStrip
    private static native long nativeAllocate(int i2);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j2, byte[] bArr, int i2, int i3);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j2, byte[] bArr, int i2, int i3);

    @DoNotStrip
    private static native void nativeFree(long j2);

    @DoNotStrip
    private static native void nativeMemcpy(long j2, long j3, int i2);

    @DoNotStrip
    private static native byte nativeReadByte(long j2);

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final long a() {
        return this.f18034a;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final void b(MemoryChunk memoryChunk, int i2) {
        memoryChunk.getClass();
        if (memoryChunk.a() == this.f18034a) {
            Log.w("NativeMemoryChunk", "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(memoryChunk)) + " which share the same address " + Long.toHexString(this.f18034a));
            Preconditions.a(Boolean.FALSE);
        }
        if (memoryChunk.a() < this.f18034a) {
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
        iA = MemoryChunkUtil.a(i2, i4, this.f18035b);
        MemoryChunkUtil.b(i2, bArr.length, i3, iA, this.f18035b);
        nativeCopyFromByteArray(this.f18034a + i2, bArr, i3, iA);
        return iA;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (!this.f18036c) {
            this.f18036c = true;
            nativeFree(this.f18034a);
        }
    }

    public final void e(MemoryChunk memoryChunk, int i2) {
        if (!(memoryChunk instanceof NativeMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        Preconditions.e(!isClosed());
        NativeMemoryChunk nativeMemoryChunk = (NativeMemoryChunk) memoryChunk;
        Preconditions.e(!nativeMemoryChunk.isClosed());
        MemoryChunkUtil.b(0, nativeMemoryChunk.f18035b, 0, i2, this.f18035b);
        long j2 = 0;
        nativeMemcpy(nativeMemoryChunk.f18034a + j2, this.f18034a + j2, i2);
    }

    public final void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final int getSize() {
        return this.f18035b;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized boolean isClosed() {
        return this.f18036c;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized byte q(int i2) {
        boolean z = true;
        Preconditions.e(!isClosed());
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException();
        }
        if (i2 >= this.f18035b) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException();
        }
        return nativeReadByte(this.f18034a + i2);
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public final synchronized int u(int i2, int i3, byte[] bArr, int i4) {
        int iA;
        Preconditions.e(!isClosed());
        iA = MemoryChunkUtil.a(i2, i4, this.f18035b);
        MemoryChunkUtil.b(i2, bArr.length, i3, iA, this.f18035b);
        nativeCopyToByteArray(this.f18034a + i2, bArr, i3, iA);
        return iA;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.f18035b = 0;
        this.f18034a = 0L;
        this.f18036c = true;
    }
}
