package com.bumptech.glide.util;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* loaded from: classes3.dex */
public class ExceptionCatchingInputStream extends InputStream implements AutoCloseable {

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayDeque f16513c;

    /* renamed from: a, reason: collision with root package name */
    public RecyclableBufferedInputStream f16514a;

    /* renamed from: b, reason: collision with root package name */
    public IOException f16515b;

    static {
        char[] cArr = Util.f16528a;
        f16513c = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f16514a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f16514a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        this.f16514a.mark(i2);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f16514a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.f16514a.read(bArr);
        } catch (IOException e2) {
            this.f16515b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f16514a.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        try {
            return this.f16514a.skip(j2);
        } catch (IOException e2) {
            this.f16515b = e2;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        try {
            return this.f16514a.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.f16515b = e2;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f16514a.read();
        } catch (IOException e2) {
            this.f16515b = e2;
            return -1;
        }
    }
}
