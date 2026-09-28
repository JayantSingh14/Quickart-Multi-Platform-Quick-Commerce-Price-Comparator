package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzase extends FilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    public final long f24269a;

    /* renamed from: b, reason: collision with root package name */
    public long f24270b;

    public zzase(BufferedInputStream bufferedInputStream, long j2) {
        super(bufferedInputStream);
        this.f24269a = j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i2 = super.read();
        if (i2 != -1) {
            this.f24270b++;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = super.read(bArr, i2, i3);
        if (i4 != -1) {
            this.f24270b += i4;
        }
        return i4;
    }
}
