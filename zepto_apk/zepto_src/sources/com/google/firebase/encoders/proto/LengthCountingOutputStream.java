package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* loaded from: classes4.dex */
final class LengthCountingOutputStream extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public long f44517a;

    @Override // java.io.OutputStream
    public final void write(int i2) {
        this.f44517a++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f44517a += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 >= 0 && i2 <= bArr.length && i3 >= 0 && (i4 = i2 + i3) <= bArr.length && i4 >= 0) {
            this.f44517a += i3;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
