package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public class ElfFileChannel implements ElfByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public File f20257a;

    /* renamed from: b, reason: collision with root package name */
    public FileInputStream f20258b;

    /* renamed from: c, reason: collision with root package name */
    public FileChannel f20259c;

    @Override // com.facebook.soloader.ElfByteChannel
    public final int R(ByteBuffer byteBuffer, long j2) {
        return this.f20259c.read(byteBuffer, j2);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f20258b.close();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.f20259c.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        return this.f20259c.read(byteBuffer);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        return this.f20259c.write(byteBuffer);
    }
}
