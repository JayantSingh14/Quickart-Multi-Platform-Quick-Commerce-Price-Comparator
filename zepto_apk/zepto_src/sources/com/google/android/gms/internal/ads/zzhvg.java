package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzhvg implements zzhaq {

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f34373g = new byte[0];

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f34374h = {0};

    /* renamed from: a, reason: collision with root package name */
    public final RSAPublicKey f34375a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34376b;

    /* renamed from: c, reason: collision with root package name */
    public final PSSParameterSpec f34377c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34378d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f34379e;

    /* renamed from: f, reason: collision with root package name */
    public final Provider f34380f;

    public zzhvg(RSAPublicKey rSAPublicKey, zzhtg zzhtgVar, zzhtg zzhtgVar2, int i2, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhhb.a(2)) {
            throw new GeneralSecurityException("Cannot use RSA SSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        if (!zzhtgVar.equals(zzhtgVar2)) {
            throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
        }
        zzhxa.c(rSAPublicKey.getModulus().bitLength());
        zzhxa.d(rSAPublicKey.getPublicExponent());
        this.f34375a = rSAPublicKey;
        this.f34376b = a(zzhtgVar);
        this.f34377c = b(zzhtgVar, zzhtgVar2, i2);
        this.f34378d = bArr;
        this.f34379e = bArr2;
        this.f34380f = provider;
    }

    public static String a(zzhtg zzhtgVar) {
        if (zzhtgVar == zzhtg.f34236b) {
            return "SHA256withRSA/PSS";
        }
        if (zzhtgVar == zzhtg.f34237c) {
            return "SHA384withRSA/PSS";
        }
        if (zzhtgVar == zzhtg.f34238d) {
            return "SHA512withRSA/PSS";
        }
        throw new IllegalArgumentException("Unsupported hash: ".concat(String.valueOf(zzhtgVar)));
    }

    public static PSSParameterSpec b(zzhtg zzhtgVar, zzhtg zzhtgVar2, int i2) {
        String str;
        MGF1ParameterSpec mGF1ParameterSpec;
        zzhtg zzhtgVar3 = zzhtg.f34236b;
        zzhtg zzhtgVar4 = zzhtg.f34238d;
        zzhtg zzhtgVar5 = zzhtg.f34237c;
        if (zzhtgVar == zzhtgVar3) {
            str = MessageDigestAlgorithms.SHA_256;
        } else if (zzhtgVar == zzhtgVar5) {
            str = MessageDigestAlgorithms.SHA_384;
        } else {
            if (zzhtgVar != zzhtgVar4) {
                throw new IllegalArgumentException("Unsupported MD hash: ".concat(String.valueOf(zzhtgVar)));
            }
            str = MessageDigestAlgorithms.SHA_512;
        }
        if (zzhtgVar2 == zzhtgVar3) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
        } else if (zzhtgVar2 == zzhtgVar5) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA384;
        } else {
            if (zzhtgVar2 != zzhtgVar4) {
                throw new IllegalArgumentException("Unsupported MGF1 hash: ".concat(String.valueOf(zzhtgVar2)));
            }
            mGF1ParameterSpec = MGF1ParameterSpec.SHA512;
        }
        return new PSSParameterSpec(str, "MGF1", mGF1ParameterSpec, i2, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzhvg c(com.google.android.gms.internal.ads.zzhtm r10) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException {
        /*
            int r0 = com.google.android.gms.internal.ads.zzhkl.f33932a
            java.lang.String r0 = "java.vendor"
            java.lang.String r1 = java.lang.System.getProperty(r0)
            java.lang.String r2 = "The Android Project"
            boolean r1 = java.util.Objects.equals(r1, r2)
            if (r1 == 0) goto L2d
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
            if (r0 > r2) goto L2d
        L2b:
            r9 = r1
            goto L32
        L2d:
            java.security.Provider r1 = com.google.android.gms.internal.ads.zzhhf.a()
            goto L2b
        L32:
            if (r9 == 0) goto L6f
            java.lang.String r0 = "RSA"
            java.security.KeyFactory r0 = java.security.KeyFactory.getInstance(r0, r9)
            java.security.spec.RSAPublicKeySpec r1 = new java.security.spec.RSAPublicKeySpec
            java.math.BigInteger r2 = r10.f34270b
            com.google.android.gms.internal.ads.zzhti r3 = r10.f34269a
            java.math.BigInteger r4 = r3.f34247b
            r1.<init>(r2, r4)
            java.security.PublicKey r0 = r0.generatePublic(r1)
            java.security.interfaces.RSAPublicKey r0 = (java.security.interfaces.RSAPublicKey) r0
            com.google.android.gms.internal.ads.zzhvg r2 = new com.google.android.gms.internal.ads.zzhvg
            com.google.android.gms.internal.ads.zzhxc r10 = r10.f34271c
            byte[] r7 = r10.b()
            com.google.android.gms.internal.ads.zzhth r10 = com.google.android.gms.internal.ads.zzhth.f34242d
            com.google.android.gms.internal.ads.zzhth r1 = r3.f34248c
            boolean r10 = r1.equals(r10)
            if (r10 == 0) goto L61
            byte[] r10 = com.google.android.gms.internal.ads.zzhvg.f34374h
        L5f:
            r8 = r10
            goto L64
        L61:
            byte[] r10 = com.google.android.gms.internal.ads.zzhvg.f34373g
            goto L5f
        L64:
            com.google.android.gms.internal.ads.zzhtg r5 = r3.f34250e
            int r6 = r3.f34251f
            com.google.android.gms.internal.ads.zzhtg r4 = r3.f34249d
            r3 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r2
        L6f:
            java.security.NoSuchProviderException r10 = new java.security.NoSuchProviderException
            java.lang.String r0 = "RSA SSA PSS using Conscrypt is not supported."
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhvg.c(com.google.android.gms.internal.ads.zzhtm):com.google.android.gms.internal.ads.zzhvg");
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34378d;
        if (!zzhkl.c(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        Signature signature = Signature.getInstance(this.f34376b, this.f34380f);
        signature.initVerify(this.f34375a);
        signature.setParameter(this.f34377c);
        signature.update(bArr2);
        byte[] bArr4 = this.f34379e;
        if (bArr4.length > 0) {
            signature.update(bArr4);
        }
        int length = bArr.length;
        int length2 = bArr3.length;
        if (!signature.verify(bArr, length2, length - length2)) {
            throw new GeneralSecurityException("signature verification failed");
        }
    }
}
