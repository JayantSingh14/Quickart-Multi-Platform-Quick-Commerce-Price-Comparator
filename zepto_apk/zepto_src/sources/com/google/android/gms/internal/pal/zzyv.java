package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzyv {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f38163a;

    public zzyv(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f38163a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public static zzyv a(byte[] bArr) {
        if (bArr != null) {
            return new zzyv(bArr, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzyv) {
            return Arrays.equals(((zzyv) obj).f38163a, this.f38163a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f38163a);
    }

    public final String toString() {
        return android.support.v4.media.b.D("Bytes(", zzyj.a(this.f38163a), ")");
    }
}
