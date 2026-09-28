package com.facebook.common.streams;

import com.facebook.infer.annotation.Nullsafe;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe
/* loaded from: classes3.dex */
public class LimitedInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f17132a;

    /* renamed from: b, reason: collision with root package name */
    public int f17133b;

    public LimitedInputStream(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < 0) {
            throw new IllegalArgumentException("limit must be >= 0");
        }
        this.f17132a = i2;
        this.f17133b = -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return Math.min(((FilterInputStream) this).in.available(), this.f17132a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i2) {
        if (((FilterInputStream) this).in.markSupported()) {
            ((FilterInputStream) this).in.mark(i2);
            this.f17133b = this.f17132a;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f17132a == 0) {
            return -1;
        }
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 != -1) {
            this.f17132a--;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("mark is not supported");
        }
        if (this.f17133b == -1) {
            throw new IOException("mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f17132a = this.f17133b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j2, this.f17132a));
        this.f17132a = (int) (this.f17132a - jSkip);
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f17132a;
        if (i4 == 0) {
            return -1;
        }
        int i5 = ((FilterInputStream) this).in.read(bArr, i2, Math.min(i3, i4));
        if (i5 > 0) {
            this.f17132a -= i5;
        }
        return i5;
    }
}
