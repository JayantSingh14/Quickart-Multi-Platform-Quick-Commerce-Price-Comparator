package com.bumptech.glide.util;

import android.support.v4.media.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final long f16511a;

    /* renamed from: b, reason: collision with root package name */
    public int f16512b;

    public ContentLengthInputStream(InputStream inputStream, long j2) {
        super(inputStream);
        this.f16511a = j2;
    }

    public final void a(int i2) throws IOException {
        if (i2 >= 0) {
            this.f16512b += i2;
            return;
        }
        long j2 = this.f16512b;
        long j3 = this.f16511a;
        if (j3 - j2 <= 0) {
            return;
        }
        StringBuilder sbV = b.v(j3, "Failed to read all expected data, expected: ", ", but read: ");
        sbV.append(this.f16512b);
        throw new IOException(sbV.toString());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f16511a - this.f16512b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int i2;
        i2 = super.read();
        a(i2 >= 0 ? 1 : -1);
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i3) {
        int i4;
        i4 = super.read(bArr, i2, i3);
        a(i4);
        return i4;
    }
}
