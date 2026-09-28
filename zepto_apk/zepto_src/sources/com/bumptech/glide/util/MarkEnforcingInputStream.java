package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f16524a;

    public MarkEnforcingInputStream(ExceptionCatchingInputStream exceptionCatchingInputStream) {
        super(exceptionCatchingInputStream);
        this.f16524a = Integer.MIN_VALUE;
    }

    public final long a(long j2) {
        int i2 = this.f16524a;
        if (i2 == 0) {
            return -1L;
        }
        return (i2 == Integer.MIN_VALUE || j2 <= ((long) i2)) ? j2 : i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i2 = this.f16524a;
        return i2 == Integer.MIN_VALUE ? super.available() : Math.min(i2, super.available());
    }

    public final void b(long j2) {
        int i2 = this.f16524a;
        if (i2 == Integer.MIN_VALUE || j2 == -1) {
            return;
        }
        this.f16524a = (int) (i2 - j2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        super.mark(i2);
        this.f16524a = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (a(1L) == -1) {
            return -1;
        }
        int i2 = super.read();
        b(1L);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f16524a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long jA = a(j2);
        if (jA == -1) {
            return 0L;
        }
        long jSkip = super.skip(jA);
        b(jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int iA = (int) a(i3);
        if (iA == -1) {
            return -1;
        }
        int i4 = super.read(bArr, i2, iA);
        b(i4);
        return i4;
    }
}
