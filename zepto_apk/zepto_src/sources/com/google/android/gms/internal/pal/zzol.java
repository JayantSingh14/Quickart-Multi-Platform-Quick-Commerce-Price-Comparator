package com.google.android.gms.internal.pal;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzol {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f37969a = b(1, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f37970b = b(2, 32);

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f37971c = b(2, 16);

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f37972d = b(2, 17);

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f37973e = b(2, 18);

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f37974f = b(2, 1);

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f37975g = b(2, 2);

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f37976h = b(2, 3);

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f37977i = b(2, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f37978j = b(2, 2);

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f37979k = b(2, 3);

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f37980l = new byte[0];

    /* renamed from: m, reason: collision with root package name */
    public static final byte[] f37981m;
    public static final byte[] n;
    public static final byte[] o;

    static {
        Charset charset = StandardCharsets.UTF_8;
        f37981m = "KEM".getBytes(charset);
        n = "HPKE".getBytes(charset);
        o = "HPKE-v1".getBytes(charset);
    }

    public static void a(zzvd zzvdVar) throws GeneralSecurityException {
        if (zzvdVar.t() == 2 || zzvdVar.t() == 1) {
            throw new GeneralSecurityException("Invalid KEM param: ".concat(zzux.a(zzvdVar.t())));
        }
        String str = "UNRECOGNIZED";
        if (zzvdVar.s() == 2 || zzvdVar.s() == 1) {
            int iS = zzvdVar.s();
            if (iS == 2) {
                str = "KDF_UNKNOWN";
            } else if (iS == 3) {
                str = "HKDF_SHA256";
            } else if (iS == 4) {
                str = "HKDF_SHA384";
            } else if (iS == 5) {
                str = "HKDF_SHA512";
            }
            throw new GeneralSecurityException("Invalid KDF param: ".concat(str));
        }
        if (zzvdVar.r() == 2 || zzvdVar.r() == 1) {
            int iR = zzvdVar.r();
            if (iR == 2) {
                str = "AEAD_UNKNOWN";
            } else if (iR == 3) {
                str = "AES_128_GCM";
            } else if (iR == 4) {
                str = "AES_256_GCM";
            } else if (iR == 5) {
                str = "CHACHA20_POLY1305";
            }
            throw new GeneralSecurityException("Invalid AEAD param: ".concat(str));
        }
    }

    public static byte[] b(int i2, int i3) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((i3 >> (((i2 - i4) - 1) * 8)) & 255);
        }
        return bArr;
    }
}
