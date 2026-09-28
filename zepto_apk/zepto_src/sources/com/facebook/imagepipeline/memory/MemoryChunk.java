package com.facebook.imagepipeline.memory;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface MemoryChunk {
    long a();

    void b(MemoryChunk memoryChunk, int i2);

    int c(int i2, int i3, byte[] bArr, int i4);

    void close();

    int getSize();

    boolean isClosed();

    byte q(int i2);

    int u(int i2, int i3, byte[] bArr, int i4);
}
