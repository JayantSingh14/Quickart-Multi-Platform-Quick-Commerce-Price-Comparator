package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhxc {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f34461a;

    public zzhxc(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f34461a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public static zzhxc a(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        int length = bArr.length;
        int length2 = bArr.length;
        if (length > length2) {
            length = length2;
        }
        return new zzhxc(bArr, length);
    }

    public final byte[] b() {
        byte[] bArr = this.f34461a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzhxc) {
            return Arrays.equals(((zzhxc) obj).f34461a, this.f34461a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f34461a);
    }

    public final String toString() {
        byte[] bArr = this.f34461a;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b2 : bArr) {
            sb.append("0123456789abcdef".charAt((b2 & 255) >> 4));
            sb.append("0123456789abcdef".charAt(b2 & 15));
        }
        String string = sb.toString();
        return android.support.v4.media.b.s(new StringBuilder(string.length() + 7), "Bytes(", string, ")");
    }
}
