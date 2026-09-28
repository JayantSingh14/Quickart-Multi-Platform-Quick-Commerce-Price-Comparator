package com.facebook.common.memory;

import com.facebook.common.internal.Throwables;
import com.facebook.imagepipeline.memory.MemoryPooledByteBuffer;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.OutputStream;

@Nullsafe
/* loaded from: classes3.dex */
public abstract class PooledByteBufferOutputStream extends OutputStream implements AutoCloseable {
    public abstract MemoryPooledByteBuffer a();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        try {
            super.close();
        } catch (IOException e2) {
            Throwables.b(e2);
            throw new RuntimeException(e2);
        }
    }

    public abstract int size();
}
