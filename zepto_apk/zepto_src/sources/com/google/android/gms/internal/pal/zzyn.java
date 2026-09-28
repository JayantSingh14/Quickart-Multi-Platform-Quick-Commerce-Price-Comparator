package com.google.android.gms.internal.pal;

import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public final class zzyn implements zzrj {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f38155a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38156b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f38157c;

    /* renamed from: d, reason: collision with root package name */
    public final int f38158d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzyn(java.lang.String r6, javax.crypto.spec.SecretKeySpec r7) throws java.security.GeneralSecurityException {
        /*
            r5 = this;
            r5.<init>()
            com.google.android.gms.internal.pal.zzym r0 = new com.google.android.gms.internal.pal.zzym
            r0.<init>(r5)
            r5.f38155a = r0
            r1 = 2
            boolean r2 = com.google.android.gms.internal.pal.zzna.a(r1)
            if (r2 == 0) goto L90
            r5.f38156b = r6
            r5.f38157c = r7
            byte[] r7 = r7.getEncoded()
            int r7 = r7.length
            r2 = 16
            if (r7 < r2) goto L88
            int r7 = r6.hashCode()
            r2 = 1
            r3 = 3
            r4 = 4
            switch(r7) {
                case -1823053428: goto L51;
                case 392315023: goto L47;
                case 392315118: goto L3d;
                case 392316170: goto L33;
                case 392317873: goto L29;
                default: goto L28;
            }
        L28:
            goto L5b
        L29:
            java.lang.String r7 = "HMACSHA512"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5b
            r7 = r4
            goto L5c
        L33:
            java.lang.String r7 = "HMACSHA384"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5b
            r7 = r3
            goto L5c
        L3d:
            java.lang.String r7 = "HMACSHA256"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5b
            r7 = r1
            goto L5c
        L47:
            java.lang.String r7 = "HMACSHA224"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5b
            r7 = r2
            goto L5c
        L51:
            java.lang.String r7 = "HMACSHA1"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L5b
            r7 = 0
            goto L5c
        L5b:
            r7 = -1
        L5c:
            if (r7 == 0) goto L80
            if (r7 == r2) goto L7d
            if (r7 == r1) goto L7a
            if (r7 == r3) goto L77
            if (r7 != r4) goto L6b
            r6 = 64
        L68:
            r5.f38158d = r6
            goto L84
        L6b:
            java.security.NoSuchAlgorithmException r7 = new java.security.NoSuchAlgorithmException
            java.lang.String r0 = "unknown Hmac algorithm: "
            java.lang.String r6 = r0.concat(r6)
            r7.<init>(r6)
            throw r7
        L77:
            r6 = 48
            goto L68
        L7a:
            r6 = 32
            goto L68
        L7d:
            r6 = 28
            goto L68
        L80:
            r6 = 20
            r5.f38158d = r6
        L84:
            r0.get()
            return
        L88:
            java.security.InvalidAlgorithmParameterException r6 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r7 = "key size too small, need at least 16 bytes"
            r6.<init>(r7)
            throw r6
        L90:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException
            java.lang.String r7 = "Can not use HMAC in FIPS-mode, as BoringCrypto module is not available."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzyn.<init>(java.lang.String, javax.crypto.spec.SecretKeySpec):void");
    }

    @Override // com.google.android.gms.internal.pal.zzrj
    public final byte[] a(int i2, byte[] bArr) throws IllegalStateException, InvalidAlgorithmParameterException {
        if (i2 > this.f38158d) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ThreadLocal threadLocal = this.f38155a;
        ((Mac) threadLocal.get()).update(bArr);
        return Arrays.copyOf(((Mac) threadLocal.get()).doFinal(), i2);
    }
}
