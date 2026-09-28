package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzhwt implements zzhaq {

    /* renamed from: a, reason: collision with root package name */
    public final RSAPublicKey f34437a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhwl f34438b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34439c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34440d;

    public /* synthetic */ zzhwt(RSAPublicKey rSAPublicKey, zzhwl zzhwlVar, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (zzhhc.a()) {
            throw new GeneralSecurityException("Conscrypt is not available, and we cannot use Java Implementation of RSA-PKCS1.5 in FIPS-mode.");
        }
        zzhxa.b(zzhwlVar);
        zzhxa.c(rSAPublicKey.getModulus().bitLength());
        zzhxa.d(rSAPublicKey.getPublicExponent());
        this.f34437a = rSAPublicKey;
        this.f34438b = zzhwlVar;
        this.f34439c = bArr;
        this.f34440d = bArr2;
    }

    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrA;
        int i2;
        RSAPublicKey rSAPublicKey = this.f34437a;
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int iBitLength = (modulus.bitLength() + 7) / 8;
        if (iBitLength != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        byte[] bArrB = zzhhe.b(bigInteger.modPow(publicExponent, modulus), iBitLength);
        zzhwl zzhwlVar = this.f34438b;
        zzhxa.b(zzhwlVar);
        MessageDigest messageDigest = (MessageDigest) zzhwc.f34417e.f34420a.a(zzhwz.a(zzhwlVar));
        messageDigest.update(bArr2);
        byte[] bArr3 = this.f34440d;
        if (bArr3.length != 0) {
            messageDigest.update(bArr3);
        }
        byte[] bArrDigest = messageDigest.digest();
        int iOrdinal = zzhwlVar.ordinal();
        int i3 = 2;
        if (iOrdinal == 2) {
            bArrA = zzhwm.a("3031300d060960864801650304020105000420");
        } else if (iOrdinal == 3) {
            bArrA = zzhwm.a("3041300d060960864801650304020205000430");
        } else {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unsupported hash ".concat(zzhwlVar.toString()));
            }
            bArrA = zzhwm.a("3051300d060960864801650304020305000440");
        }
        if (iBitLength < bArrA.length + bArrDigest.length + 11) {
            throw new GeneralSecurityException("intended encoded message length too short");
        }
        byte[] bArr4 = new byte[iBitLength];
        bArr4[0] = 0;
        bArr4[1] = 1;
        int i4 = 0;
        while (true) {
            i2 = i3 + 1;
            if (i4 >= (iBitLength - r5) - 3) {
                break;
            }
            bArr4[i3] = -1;
            i4++;
            i3 = i2;
        }
        bArr4[i3] = 0;
        int length = bArrA.length;
        System.arraycopy(bArrA, 0, bArr4, i2, length);
        System.arraycopy(bArrDigest, 0, bArr4, i2 + length, bArrDigest.length);
        if (!MessageDigest.isEqual(bArrB, bArr4)) {
            throw new GeneralSecurityException("invalid signature");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34439c;
        int length = bArr3.length;
        if (length == 0) {
            a(bArr, bArr2);
        } else {
            if (!zzhkl.c(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            a(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
    }
}
