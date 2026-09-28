package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
final class zzajc {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f23256d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23257a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public int f23258b;

    /* renamed from: c, reason: collision with root package name */
    public int f23259c;

    public static long b(byte[] bArr, int i2, boolean z) {
        long j2 = bArr[0] & 255;
        if (z) {
            j2 &= ~f23256d[i2 - 1];
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (bArr[i3] & 255);
        }
        return j2;
    }

    public final long a(zzaef zzaefVar, boolean z, boolean z2, int i2) throws EOFException, InterruptedIOException {
        int i3;
        int i4 = this.f23258b;
        byte[] bArr = this.f23257a;
        if (i4 == 0) {
            if (!zzaefVar.v(bArr, 0, 1, z)) {
                return -1L;
            }
            int i5 = bArr[0] & 255;
            int i6 = 0;
            while (true) {
                if (i6 >= 8) {
                    i3 = -1;
                    break;
                }
                i3 = i6 + 1;
                if ((f23256d[i6] & i5) != 0) {
                    break;
                }
                i6 = i3;
            }
            this.f23259c = i3;
            if (i3 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f23258b = 1;
        }
        int i7 = this.f23259c;
        if (i7 > i2) {
            this.f23258b = 0;
            return -2L;
        }
        if (i7 != 1) {
            zzaefVar.v(bArr, 1, i7 - 1, false);
        }
        this.f23258b = 0;
        return b(bArr, this.f23259c, z2);
    }
}
