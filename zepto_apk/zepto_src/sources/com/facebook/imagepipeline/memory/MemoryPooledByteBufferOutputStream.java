package com.facebook.imagepipeline.memory;

import android.support.v4.media.b;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.DefaultCloseableReference;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@NotThreadSafe
@Metadata
/* loaded from: classes3.dex */
public final class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final MemoryChunkPool f18031a;

    /* renamed from: b, reason: collision with root package name */
    public DefaultCloseableReference f18032b;

    /* renamed from: c, reason: collision with root package name */
    public int f18033c;

    @Metadata
    public static final class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool pool, int i2) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        if (i2 <= 0) {
            throw new IllegalStateException("Check failed.");
        }
        this.f18031a = pool;
        this.f18033c = 0;
        this.f18032b = CloseableReference.T(pool.get(i2), pool, CloseableReference.f17108f);
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final MemoryPooledByteBuffer a() {
        if (!CloseableReference.A(this.f18032b)) {
            throw new InvalidStreamException();
        }
        DefaultCloseableReference defaultCloseableReference = this.f18032b;
        if (defaultCloseableReference != null) {
            return new MemoryPooledByteBuffer(defaultCloseableReference, this.f18033c);
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        CloseableReference.e(this.f18032b);
        this.f18032b = null;
        this.f18033c = -1;
        super.close();
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public final int size() {
        return this.f18033c;
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    @Override // java.io.OutputStream
    public final void write(byte[] buffer, int i2, int i3) throws Throwable {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= buffer.length) {
            if (CloseableReference.A(this.f18032b)) {
                int i4 = this.f18033c + i3;
                if (CloseableReference.A(this.f18032b)) {
                    DefaultCloseableReference defaultCloseableReference = this.f18032b;
                    if (defaultCloseableReference != null) {
                        if (i4 > ((MemoryChunk) defaultCloseableReference.l()).getSize()) {
                            MemoryChunkPool memoryChunkPool = this.f18031a;
                            Object obj = memoryChunkPool.get(i4);
                            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                            MemoryChunk memoryChunk = (MemoryChunk) obj;
                            DefaultCloseableReference defaultCloseableReference2 = this.f18032b;
                            if (defaultCloseableReference2 != null) {
                                ((MemoryChunk) defaultCloseableReference2.l()).b(memoryChunk, this.f18033c);
                                DefaultCloseableReference defaultCloseableReference3 = this.f18032b;
                                Intrinsics.c(defaultCloseableReference3);
                                defaultCloseableReference3.close();
                                this.f18032b = CloseableReference.T(memoryChunk, memoryChunkPool, CloseableReference.f17108f);
                            } else {
                                throw new IllegalStateException("Required value was null.");
                            }
                        }
                        DefaultCloseableReference defaultCloseableReference4 = this.f18032b;
                        if (defaultCloseableReference4 != null) {
                            ((MemoryChunk) defaultCloseableReference4.l()).c(this.f18033c, i2, buffer, i3);
                            this.f18033c += i3;
                            return;
                        }
                        throw new IllegalStateException("Required value was null.");
                    }
                    throw new IllegalStateException("Required value was null.");
                }
                throw new InvalidStreamException();
            }
            throw new InvalidStreamException();
        }
        StringBuilder sbT = b.t(buffer.length, i2, "length=", "; regionStart=", "; regionLength=");
        sbT.append(i3);
        throw new ArrayIndexOutOfBoundsException(sbT.toString());
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool) {
        this(memoryChunkPool, memoryChunkPool.f18026j[0]);
    }
}
