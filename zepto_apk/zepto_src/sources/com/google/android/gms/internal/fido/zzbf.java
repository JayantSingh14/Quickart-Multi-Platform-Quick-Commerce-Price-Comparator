package com.google.android.gms.internal.fido;

import java.io.IOException;

/* loaded from: classes4.dex */
public abstract class zzbf {

    /* renamed from: a, reason: collision with root package name */
    public static final zzbf f36609a;

    static {
        new zzbd("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        new zzbd("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
        new zzbe("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new zzbe("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        f36609a = new zzbc();
    }

    public abstract void a(StringBuilder sb, byte[] bArr, int i2);

    public abstract int b(int i2);

    public final String c(int i2, byte[] bArr) {
        zzam.b(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(b(i2));
        try {
            a(sb, bArr, i2);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
