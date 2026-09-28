package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
final class zzhys extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f34534a;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return Math.min(super.available(), this.f34534a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f34534a <= 0) {
            return -1;
        }
        int i2 = super.read();
        if (i2 >= 0) {
            this.f34534a--;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) {
        int iSkip = (int) super.skip(Math.min(j2, this.f34534a));
        if (iSkip >= 0) {
            this.f34534a -= iSkip;
        }
        return iSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f34534a;
        if (i4 <= 0) {
            return -1;
        }
        int i5 = super.read(bArr, i2, Math.min(i3, i4));
        if (i5 >= 0) {
            this.f34534a -= i5;
        }
        return i5;
    }
}
