package com.facebook.common.memory;

import android.support.v4.media.a;
import com.facebook.common.internal.Preconditions;
import com.facebook.infer.annotation.Nullsafe;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class PooledByteBufferInputStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final PooledByteBuffer f17102a;

    /* renamed from: b, reason: collision with root package name */
    public int f17103b;

    /* renamed from: c, reason: collision with root package name */
    public int f17104c;

    public PooledByteBufferInputStream(PooledByteBuffer pooledByteBuffer) {
        Preconditions.a(Boolean.valueOf(!pooledByteBuffer.isClosed()));
        this.f17102a = pooledByteBuffer;
        this.f17103b = 0;
        this.f17104c = 0;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f17102a.size() - this.f17103b;
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        this.f17104c = this.f17103b;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (available() <= 0) {
            return -1;
        }
        int i2 = this.f17103b;
        this.f17103b = i2 + 1;
        return this.f17102a.q(i2) & 255;
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f17103b = this.f17104c;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        Preconditions.a(Boolean.valueOf(j2 >= 0));
        int iMin = Math.min((int) j2, available());
        this.f17103b += iMin;
        return iMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        if (i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length) {
            int iAvailable = available();
            if (iAvailable <= 0) {
                return -1;
            }
            if (i3 <= 0) {
                return 0;
            }
            int iMin = Math.min(iAvailable, i3);
            this.f17102a.u(this.f17103b, i2, bArr, iMin);
            this.f17103b += iMin;
            return iMin;
        }
        StringBuilder sb = new StringBuilder("length=");
        a.q(bArr.length, i2, "; regionStart=", "; regionLength=", sb);
        sb.append(i3);
        throw new ArrayIndexOutOfBoundsException(sb.toString());
    }
}
