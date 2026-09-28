package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class BufferedOutputStream extends OutputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final FileOutputStream f15824a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f15825b;

    /* renamed from: c, reason: collision with root package name */
    public final LruArrayPool f15826c;

    /* renamed from: d, reason: collision with root package name */
    public int f15827d;

    public BufferedOutputStream(FileOutputStream fileOutputStream, LruArrayPool lruArrayPool) {
        this.f15824a = fileOutputStream;
        this.f15826c = lruArrayPool;
        this.f15825b = (byte[]) lruArrayPool.d(byte[].class, 65536);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        FileOutputStream fileOutputStream = this.f15824a;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.f15825b;
            if (bArr != null) {
                this.f15826c.i(bArr);
                this.f15825b = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        int i2 = this.f15827d;
        FileOutputStream fileOutputStream = this.f15824a;
        if (i2 > 0) {
            fileOutputStream.write(this.f15825b, 0, i2);
            this.f15827d = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        byte[] bArr = this.f15825b;
        int i3 = this.f15827d;
        int i4 = i3 + 1;
        this.f15827d = i4;
        bArr[i3] = (byte) i2;
        if (i4 != bArr.length || i4 <= 0) {
            return;
        }
        this.f15824a.write(bArr, 0, i4);
        this.f15827d = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            int i7 = this.f15827d;
            FileOutputStream fileOutputStream = this.f15824a;
            if (i7 == 0 && i5 >= this.f15825b.length) {
                fileOutputStream.write(bArr, i6, i5);
                return;
            }
            int iMin = Math.min(i5, this.f15825b.length - i7);
            System.arraycopy(bArr, i6, this.f15825b, this.f15827d, iMin);
            int i8 = this.f15827d + iMin;
            this.f15827d = i8;
            i4 += iMin;
            byte[] bArr2 = this.f15825b;
            if (i8 == bArr2.length && i8 > 0) {
                fileOutputStream.write(bArr2, 0, i8);
                this.f15827d = 0;
            }
        } while (i4 < i3);
    }
}
