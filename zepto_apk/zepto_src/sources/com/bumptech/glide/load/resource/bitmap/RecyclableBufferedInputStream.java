package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class RecyclableBufferedInputStream extends FilterInputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public volatile byte[] f16308a;

    /* renamed from: b, reason: collision with root package name */
    public int f16309b;

    /* renamed from: c, reason: collision with root package name */
    public int f16310c;

    /* renamed from: d, reason: collision with root package name */
    public int f16311d;

    /* renamed from: e, reason: collision with root package name */
    public int f16312e;

    /* renamed from: f, reason: collision with root package name */
    public final LruArrayPool f16313f;

    public static class InvalidMarkException extends IOException {
    }

    public RecyclableBufferedInputStream(InputStream inputStream, LruArrayPool lruArrayPool) {
        super(inputStream);
        this.f16311d = -1;
        this.f16313f = lruArrayPool;
        this.f16308a = (byte[]) lruArrayPool.d(byte[].class, 65536);
    }

    public static void b() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(byte[] bArr, InputStream inputStream) throws IOException {
        int i2 = this.f16311d;
        if (i2 != -1) {
            int i3 = this.f16312e - i2;
            int i4 = this.f16310c;
            if (i3 < i4) {
                if (i2 == 0 && i4 > bArr.length && this.f16309b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i4) {
                        i4 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f16313f.d(byte[].class, i4);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f16308a = bArr2;
                    this.f16313f.i(bArr);
                    bArr = bArr2;
                } else if (i2 > 0) {
                    System.arraycopy(bArr, i2, bArr, 0, bArr.length - i2);
                }
                int i5 = this.f16312e - this.f16311d;
                this.f16312e = i5;
                this.f16311d = 0;
                this.f16309b = 0;
                int i6 = inputStream.read(bArr, i5, bArr.length - i5);
                int i7 = this.f16312e;
                if (i6 > 0) {
                    i7 += i6;
                }
                this.f16309b = i7;
                return i6;
            }
        }
        int i8 = inputStream.read(bArr);
        if (i8 > 0) {
            this.f16311d = -1;
            this.f16312e = 0;
            this.f16309b = i8;
        }
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f16308a == null || inputStream == null) {
            b();
            throw null;
        }
        return (this.f16309b - this.f16312e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f16308a != null) {
            this.f16313f.i(this.f16308a);
            this.f16308a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
        this.f16310c = Math.max(this.f16310c, i2);
        this.f16311d = this.f16312e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f16308a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            b();
            throw null;
        }
        if (this.f16312e >= this.f16309b && a(bArr, inputStream) == -1) {
            return -1;
        }
        if (bArr != this.f16308a && (bArr = this.f16308a) == null) {
            b();
            throw null;
        }
        int i2 = this.f16309b;
        int i3 = this.f16312e;
        if (i2 - i3 <= 0) {
            return -1;
        }
        this.f16312e = i3 + 1;
        return bArr[i3] & 255;
    }

    public final synchronized void release() {
        if (this.f16308a != null) {
            this.f16313f.i(this.f16308a);
            this.f16308a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f16308a == null) {
            throw new IOException("Stream is closed");
        }
        int i2 = this.f16311d;
        if (-1 == i2) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f16312e + " markLimit: " + this.f16310c);
        }
        this.f16312e = i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j2) {
        if (j2 < 1) {
            return 0L;
        }
        byte[] bArr = this.f16308a;
        if (bArr == null) {
            b();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            b();
            throw null;
        }
        int i2 = this.f16309b;
        int i3 = this.f16312e;
        if (i2 - i3 >= j2) {
            this.f16312e = (int) (i3 + j2);
            return j2;
        }
        long j3 = i2 - i3;
        this.f16312e = i2;
        if (this.f16311d == -1 || j2 > this.f16310c) {
            return j3 + inputStream.skip(j2 - j3);
        }
        if (a(bArr, inputStream) == -1) {
            return j3;
        }
        int i4 = this.f16309b;
        int i5 = this.f16312e;
        if (i4 - i5 >= j2 - j3) {
            this.f16312e = (int) ((i5 + j2) - j3);
            return j2;
        }
        long j4 = (j3 + i4) - i5;
        this.f16312e = i4;
        return j4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        byte[] bArr2 = this.f16308a;
        if (bArr2 == null) {
            b();
            throw null;
        }
        if (i3 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i6 = this.f16312e;
            int i7 = this.f16309b;
            if (i6 < i7) {
                int i8 = i7 - i6;
                if (i8 >= i3) {
                    i8 = i3;
                }
                System.arraycopy(bArr2, i6, bArr, i2, i8);
                this.f16312e += i8;
                if (i8 == i3 || inputStream.available() == 0) {
                    return i8;
                }
                i2 += i8;
                i4 = i3 - i8;
            } else {
                i4 = i3;
            }
            while (true) {
                if (this.f16311d == -1 && i4 >= bArr2.length) {
                    i5 = inputStream.read(bArr, i2, i4);
                    if (i5 == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                } else {
                    if (a(bArr2, inputStream) == -1) {
                        return i4 != i3 ? i3 - i4 : -1;
                    }
                    if (bArr2 != this.f16308a && (bArr2 = this.f16308a) == null) {
                        b();
                        throw null;
                    }
                    int i9 = this.f16309b;
                    int i10 = this.f16312e;
                    i5 = i9 - i10;
                    if (i5 >= i4) {
                        i5 = i4;
                    }
                    System.arraycopy(bArr2, i10, bArr, i2, i5);
                    this.f16312e += i5;
                }
                i4 -= i5;
                if (i4 == 0) {
                    return i3;
                }
                if (inputStream.available() == 0) {
                    return i3 - i4;
                }
                i2 += i5;
            }
        } else {
            b();
            throw null;
        }
    }
}
