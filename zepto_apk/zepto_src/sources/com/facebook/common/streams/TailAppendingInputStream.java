package com.facebook.common.streams;

import com.facebook.infer.annotation.Nullsafe;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe
/* loaded from: classes3.dex */
public class TailAppendingInputStream extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f17134a;

    /* renamed from: b, reason: collision with root package name */
    public int f17135b;

    /* renamed from: c, reason: collision with root package name */
    public int f17136c;

    public TailAppendingInputStream(byte[] bArr, InputStream inputStream) {
        super(inputStream);
        this.f17134a = bArr;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i2) {
        if (((FilterInputStream) this).in.markSupported()) {
            super.mark(i2);
            this.f17136c = this.f17135b;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i2 = ((FilterInputStream) this).in.read();
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.f17135b;
        byte[] bArr = this.f17134a;
        if (i3 >= bArr.length) {
            return -1;
        }
        this.f17135b = i3 + 1;
        return bArr[i3] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("mark is not supported");
        }
        ((FilterInputStream) this).in.reset();
        this.f17135b = this.f17136c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = ((FilterInputStream) this).in.read(bArr, i2, i3);
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        if (i3 == 0) {
            return 0;
        }
        while (i6 < i3) {
            int i7 = this.f17135b;
            byte[] bArr2 = this.f17134a;
            if (i7 >= bArr2.length) {
                i4 = -1;
            } else {
                this.f17135b = i7 + 1;
                i4 = bArr2[i7] & 255;
            }
            if (i4 == -1) {
                break;
            }
            bArr[i2 + i6] = (byte) i4;
            i6++;
        }
        if (i6 > 0) {
            return i6;
        }
        return -1;
    }
}
