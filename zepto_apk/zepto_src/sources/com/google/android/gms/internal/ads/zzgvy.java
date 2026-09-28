package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class zzgvy {

    /* renamed from: a, reason: collision with root package name */
    public static final zzgvy f33275a = new zzgvv("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /* renamed from: b, reason: collision with root package name */
    public static final zzgvy f33276b = new zzgvv("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");

    /* renamed from: c, reason: collision with root package name */
    public static final zzgvy f33277c;

    static {
        new zzgvx("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new zzgvx("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        f33277c = new zzgvu(new zzgvt("base16()", "0123456789ABCDEF".toCharArray()));
    }

    public abstract void a(StringBuilder sb, byte[] bArr, int i2);

    public abstract int b(byte[] bArr, CharSequence charSequence);

    public abstract int c(int i2);

    public abstract int d(int i2);

    public CharSequence e(CharSequence charSequence) {
        throw null;
    }

    public abstract zzgvy f();

    public final String g(int i2, byte[] bArr) {
        zzgqa.k(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(c(i2));
        try {
            a(sb, bArr, i2);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final byte[] h(String str) {
        try {
            CharSequence charSequenceE = e(str);
            int iD = d(charSequenceE.length());
            byte[] bArr = new byte[iD];
            int iB = b(bArr, charSequenceE);
            if (iB == iD) {
                return bArr;
            }
            byte[] bArr2 = new byte[iB];
            System.arraycopy(bArr, 0, bArr2, 0, iB);
            return bArr2;
        } catch (zzgvw e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
