package com.facebook.common.memory;

import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;

@Nullsafe
/* loaded from: classes3.dex */
public interface PooledByteBuffer extends Closeable, AutoCloseable {

    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    boolean isClosed();

    byte q(int i2);

    int size();

    int u(int i2, int i3, byte[] bArr, int i4);
}
