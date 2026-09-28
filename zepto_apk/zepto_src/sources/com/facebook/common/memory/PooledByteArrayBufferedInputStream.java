package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class PooledByteArrayBufferedInputStream extends InputStream implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f17096a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f17097b;

    /* renamed from: c, reason: collision with root package name */
    public final ResourceReleaser f17098c;

    /* renamed from: d, reason: collision with root package name */
    public int f17099d;

    /* renamed from: e, reason: collision with root package name */
    public int f17100e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17101f;

    public PooledByteArrayBufferedInputStream(InputStream inputStream, byte[] bArr, ResourceReleaser resourceReleaser) {
        this.f17096a = inputStream;
        bArr.getClass();
        this.f17097b = bArr;
        resourceReleaser.getClass();
        this.f17098c = resourceReleaser;
        this.f17099d = 0;
        this.f17100e = 0;
        this.f17101f = false;
    }

    public final void a() throws IOException {
        if (this.f17101f) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        Preconditions.e(this.f17100e <= this.f17099d);
        a();
        return this.f17096a.available() + (this.f17099d - this.f17100e);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f17101f) {
            return;
        }
        this.f17101f = true;
        this.f17098c.a(this.f17097b);
        super.close();
    }

    public final void finalize() throws Throwable {
        if (!this.f17101f) {
            FLog.g("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        Preconditions.e(this.f17100e <= this.f17099d);
        a();
        int i2 = this.f17100e;
        int i3 = this.f17099d;
        byte[] bArr = this.f17097b;
        if (i2 >= i3) {
            int i4 = this.f17096a.read(bArr);
            if (i4 <= 0) {
                return -1;
            }
            this.f17099d = i4;
            this.f17100e = 0;
        }
        int i5 = this.f17100e;
        this.f17100e = i5 + 1;
        return bArr[i5] & 255;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) throws IOException {
        Preconditions.e(this.f17100e <= this.f17099d);
        a();
        int i2 = this.f17099d;
        int i3 = this.f17100e;
        long j3 = i2 - i3;
        if (j3 >= j2) {
            this.f17100e = (int) (i3 + j2);
            return j2;
        }
        this.f17100e = i2;
        return this.f17096a.skip(j2 - j3) + j3;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        Preconditions.e(this.f17100e <= this.f17099d);
        a();
        int i4 = this.f17100e;
        int i5 = this.f17099d;
        byte[] bArr2 = this.f17097b;
        if (i4 >= i5) {
            int i6 = this.f17096a.read(bArr2);
            if (i6 <= 0) {
                return -1;
            }
            this.f17099d = i6;
            this.f17100e = 0;
        }
        int iMin = Math.min(this.f17099d - this.f17100e, i3);
        System.arraycopy(bArr2, this.f17100e, bArr, i2, iMin);
        this.f17100e += iMin;
        return iMin;
    }
}
