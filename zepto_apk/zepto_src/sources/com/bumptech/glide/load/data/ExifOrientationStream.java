package com.bumptech.glide.load.data;

import android.support.v4.media.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class ExifOrientationStream extends FilterInputStream {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f15831c = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: d, reason: collision with root package name */
    public static final int f15832d = 31;

    /* renamed from: a, reason: collision with root package name */
    public final byte f15833a;

    /* renamed from: b, reason: collision with root package name */
    public int f15834b;

    public ExifOrientationStream(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 < -1 || i2 > 8) {
            throw new IllegalArgumentException(b.f(i2, "Cannot add invalid orientation: "));
        }
        this.f15833a = (byte) i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int i2;
        int i3 = this.f15834b;
        int i4 = (i3 < 2 || i3 > (i2 = f15832d)) ? super.read() : i3 == i2 ? this.f15833a : f15831c[i3 - 2] & 255;
        if (i4 != -1) {
            this.f15834b++;
        }
        return i4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long jSkip = super.skip(j2);
        if (jSkip > 0) {
            this.f15834b = (int) (this.f15834b + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.f15834b;
        int i6 = f15832d;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f15833a;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int iMin = Math.min(i6 - i5, i3);
            System.arraycopy(f15831c, this.f15834b - 2, bArr, i2, iMin);
            i4 = iMin;
        }
        if (i4 > 0) {
            this.f15834b += i4;
        }
        return i4;
    }
}
