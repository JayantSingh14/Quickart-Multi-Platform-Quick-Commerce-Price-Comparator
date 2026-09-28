package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhvf implements zzhap {
    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzhvf a(com.google.android.gms.internal.ads.zzhtk r12) throws java.security.GeneralSecurityException {
        /*
            int r0 = com.google.android.gms.internal.ads.zzhkl.f33932a
            java.lang.String r0 = "java.vendor"
            java.lang.String r1 = java.lang.System.getProperty(r0)
            java.lang.String r2 = "The Android Project"
            boolean r1 = java.util.Objects.equals(r1, r2)
            if (r1 == 0) goto L2c
            java.lang.String r0 = java.lang.System.getProperty(r0)
            boolean r0 = java.util.Objects.equals(r0, r2)
            r1 = 0
            if (r0 != 0) goto L1d
            r0 = r1
            goto L23
        L1d:
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
        L23:
            int r0 = r0.intValue()
            r2 = 23
            if (r0 > r2) goto L2c
            goto L30
        L2c:
            java.security.Provider r1 = com.google.android.gms.internal.ads.zzhhf.a()
        L30:
            if (r1 == 0) goto La2
            java.lang.String r0 = "RSA"
            java.security.KeyFactory r0 = java.security.KeyFactory.getInstance(r0, r1)
            com.google.android.gms.internal.ads.zzhtm r1 = r12.f34259a
            com.google.android.gms.internal.ads.zzhti r1 = r1.f34269a
            java.security.spec.RSAPrivateCrtKeySpec r2 = new java.security.spec.RSAPrivateCrtKeySpec
            com.google.android.gms.internal.ads.zzhtm r11 = r12.f34259a
            java.math.BigInteger r3 = r11.f34270b
            java.math.BigInteger r4 = r1.f34247b
            com.google.android.gms.internal.ads.zzhxd r5 = r12.f34260b
            java.math.BigInteger r5 = r5.f34462a
            com.google.android.gms.internal.ads.zzhxd r6 = r12.f34261c
            java.math.BigInteger r6 = r6.f34462a
            com.google.android.gms.internal.ads.zzhxd r7 = r12.f34262d
            java.math.BigInteger r7 = r7.f34462a
            com.google.android.gms.internal.ads.zzhxd r8 = r12.f34263e
            java.math.BigInteger r8 = r8.f34462a
            com.google.android.gms.internal.ads.zzhxd r9 = r12.f34264f
            java.math.BigInteger r9 = r9.f34462a
            com.google.android.gms.internal.ads.zzhxd r12 = r12.f34265g
            java.math.BigInteger r10 = r12.f34462a
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            java.security.PrivateKey r12 = r0.generatePrivate(r2)
            java.security.interfaces.RSAPrivateCrtKey r12 = (java.security.interfaces.RSAPrivateCrtKey) r12
            com.google.android.gms.internal.ads.zzhvf r0 = new com.google.android.gms.internal.ads.zzhvf
            com.google.android.gms.internal.ads.zzhxc r2 = r11.f34271c
            r2.b()
            com.google.android.gms.internal.ads.zzhth r2 = r1.f34248c
            r2.getClass()
            r0.<init>()
            r2 = 2
            boolean r2 = com.google.android.gms.internal.ads.zzhhb.a(r2)
            if (r2 == 0) goto L9a
            java.math.BigInteger r2 = r12.getModulus()
            int r2 = r2.bitLength()
            com.google.android.gms.internal.ads.zzhxa.c(r2)
            java.math.BigInteger r12 = r12.getPublicExponent()
            com.google.android.gms.internal.ads.zzhxa.d(r12)
            com.google.android.gms.internal.ads.zzhtg r12 = r1.f34249d
            com.google.android.gms.internal.ads.zzhvg.a(r12)
            com.google.android.gms.internal.ads.zzhtg r2 = r1.f34250e
            int r1 = r1.f34251f
            com.google.android.gms.internal.ads.zzhvg.b(r12, r2, r1)
            return r0
        L9a:
            java.security.GeneralSecurityException r12 = new java.security.GeneralSecurityException
            java.lang.String r0 = "Cannot use RSA PSS in FIPS-mode, as BoringCrypto module is not available."
            r12.<init>(r0)
            throw r12
        La2:
            java.security.NoSuchProviderException r12 = new java.security.NoSuchProviderException
            java.lang.String r0 = "RSA SSA PSS using Conscrypt is not supported."
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhvf.a(com.google.android.gms.internal.ads.zzhtk):com.google.android.gms.internal.ads.zzhvf");
    }
}
