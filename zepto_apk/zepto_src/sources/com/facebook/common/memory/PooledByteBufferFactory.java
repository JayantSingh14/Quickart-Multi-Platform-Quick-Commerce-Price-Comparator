package com.facebook.common.memory;

import com.facebook.imagepipeline.memory.MemoryPooledByteBuffer;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface PooledByteBufferFactory {
    MemoryPooledByteBuffer a(InputStream inputStream);

    MemoryPooledByteBuffer b(InputStream inputStream, int i2);

    MemoryPooledByteBufferOutputStream c();

    MemoryPooledByteBuffer d(byte[] bArr);

    MemoryPooledByteBufferOutputStream e(int i2);
}
