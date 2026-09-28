package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final class zzatw {

    /* renamed from: b, reason: collision with root package name */
    public static final zzatw f24365b = new zzatw(new byte[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final Comparator f24366c = new zzatv();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f24367a;

    public zzatw(byte[] bArr) {
        this.f24367a = bArr;
    }

    public static zzatw e(byte[] bArr) {
        byte[] bArr2;
        int length = bArr.length;
        if (length == 0) {
            bArr2 = new byte[0];
        } else {
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, 0, bArr3, 0, length);
            bArr2 = bArr3;
        }
        return new zzatw(bArr2);
    }

    public static int f(byte b2) {
        int[] iArr = {2107654819, 15074090, 1957914693, -2142502098, -1902504939, -100121615, 100669, 1835342733, 837626799};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        return b2 & (android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, iArr[5], iArr[6]) ^ (iArr[7] % 837626799));
    }

    public final byte[] a() {
        byte[] bArr = this.f24367a;
        int length = bArr.length;
        if (length == 0) {
            return new byte[0];
        }
        if (length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final byte b(int i2) {
        int i3 = ((((~2106914653) & 587408197) | 1537377410) + ((2106914653 & 536945509) | 443419704)) - 2137956065;
        int i4 = 2013725218 % 1633938701;
        int i5 = ((((~1287859999) & 62941354) | 437464817) + ((1287859999 & 1639989262) | 1644309956)) - 2060977796;
        int i6 = 1442767057 % 63299708;
        byte[] bArr = this.f24367a;
        int length = bArr.length;
        if (((length - (i2 + 1)) | i2) >= 0) {
            return bArr[i2];
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(androidx.fragment.app.e.a(i2, i3 ^ i4));
            sb.append(zzatu.a("Akelqh1fajntGgo="));
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(androidx.fragment.app.e.a(length, androidx.fragment.app.e.a(i2, i5 ^ i6)));
        sb2.append(zzatu.a("Akelqh1faDmxRUSK1T9GeQ=="));
        sb2.append(i2);
        sb2.append(zzatu.a("Zwk="));
        sb2.append(length);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    public final String c() {
        Charset charsetForName = Charset.forName(zzatu.a("Hn2H4l0="));
        byte[] bArr = this.f24367a;
        return new String(bArr, 0, bArr.length, charsetForName);
    }

    public final zzatw d(zzatw zzatwVar) {
        byte[] bArr = zzatwVar.f24367a;
        int length = bArr.length;
        byte[] bArr2 = this.f24367a;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2 + length];
        System.arraycopy(bArr2, 0, bArr3, 0, length2);
        System.arraycopy(bArr, 0, bArr3, length2, length);
        return e(bArr3);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzatw) {
            return Arrays.equals(this.f24367a, ((zzatw) obj).f24367a);
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(Arrays.hashCode(this.f24367a));
    }

    public final String toString() {
        int[] iArr = {936621968, 262671172, 1099388327, 506341952, 1363551406, -1491858486, 110389885, 989492335, 981766422};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int iA = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8);
        String string = Arrays.toString(this.f24367a);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + ((i9 % 981766422) ^ iA));
        sb.append(zzatu.a("CVC1qiQNJHikW0iU1TIPZA=="));
        sb.append(string);
        sb.append(zzatu.a("Ng=="));
        return sb.toString();
    }
}
