package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
@Metadata
/* loaded from: classes.dex */
public final class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {

    /* renamed from: a, reason: collision with root package name */
    public final MemoryChunkPool f18029a;

    /* renamed from: b, reason: collision with root package name */
    public final PooledByteStreams f18030b;

    public MemoryPooledByteBufferFactory(MemoryChunkPool pool, PooledByteStreams pooledByteStreams) {
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(pooledByteStreams, "pooledByteStreams");
        this.f18029a = pool;
        this.f18030b = pooledByteStreams;
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public final MemoryPooledByteBuffer a(InputStream inputStream) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        MemoryPooledByteBufferOutputStream outputStream = new MemoryPooledByteBufferOutputStream(this.f18029a);
        try {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(outputStream, "outputStream");
            this.f18030b.a(inputStream, outputStream);
            return outputStream.a();
        } finally {
            outputStream.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public final MemoryPooledByteBuffer b(InputStream inputStream, int i2) throws Throwable {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        MemoryPooledByteBufferOutputStream outputStream = new MemoryPooledByteBufferOutputStream(this.f18029a, i2);
        try {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Intrinsics.checkNotNullParameter(outputStream, "outputStream");
            this.f18030b.a(inputStream, outputStream);
            return outputStream.a();
        } finally {
            outputStream.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public final MemoryPooledByteBufferOutputStream c() {
        return new MemoryPooledByteBufferOutputStream(this.f18029a);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public final MemoryPooledByteBuffer d(byte[] bytes) throws Throwable {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f18029a, bytes.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bytes, 0, bytes.length);
                return memoryPooledByteBufferOutputStream.a();
            } catch (IOException e2) {
                Throwables.a(e2);
                throw null;
            }
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public final MemoryPooledByteBufferOutputStream e(int i2) {
        return new MemoryPooledByteBufferOutputStream(this.f18029a, i2);
    }
}
