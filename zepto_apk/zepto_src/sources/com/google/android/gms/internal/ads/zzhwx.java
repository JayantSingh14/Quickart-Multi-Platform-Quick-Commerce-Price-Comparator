package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzhwx implements zzhaq {

    /* renamed from: a, reason: collision with root package name */
    public final RSAPublicKey f34444a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhwl f34445b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhwl f34446c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34447d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f34448e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f34449f;

    public /* synthetic */ zzhwx(RSAPublicKey rSAPublicKey, zzhwl zzhwlVar, zzhwl zzhwlVar2, int i2, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (zzhhc.a()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhxa.b(zzhwlVar);
        if (!zzhwlVar.equals(zzhwlVar2)) {
            throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
        }
        zzhxa.c(rSAPublicKey.getModulus().bitLength());
        zzhxa.d(rSAPublicKey.getPublicExponent());
        this.f34444a = rSAPublicKey;
        this.f34445b = zzhwlVar;
        this.f34446c = zzhwlVar2;
        this.f34447d = i2;
        this.f34448e = bArr;
        this.f34449f = bArr2;
    }

    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        RSAPublicKey rSAPublicKey = this.f34444a;
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int iBitLength = modulus.bitLength() + 7;
        int iBitLength2 = modulus.bitLength() + 6;
        if (iBitLength / 8 != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        byte[] bArrB = zzhhe.b(bigInteger.modPow(publicExponent, modulus), iBitLength2 / 8);
        int iBitLength3 = modulus.bitLength() - 1;
        zzhwl zzhwlVar = this.f34445b;
        zzhxa.b(zzhwlVar);
        zzhwc zzhwcVar = zzhwc.f34417e;
        MessageDigest messageDigest = (MessageDigest) zzhwcVar.f34420a.a(zzhwz.a(zzhwlVar));
        messageDigest.update(bArr2);
        byte[] bArr3 = this.f34449f;
        if (bArr3.length != 0) {
            messageDigest.update(bArr3);
        }
        byte[] bArrDigest = messageDigest.digest();
        int digestLength = messageDigest.getDigestLength();
        int length = bArrB.length;
        int i2 = this.f34447d;
        if (length < digestLength + i2 + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        if (bArrB[length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i3 = length - digestLength;
        int i4 = i3 - 1;
        byte[] bArrCopyOf = Arrays.copyOf(bArrB, i4);
        int length2 = bArrCopyOf.length;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrB, length2, length2 + digestLength);
        int i5 = 0;
        while (true) {
            long j2 = (length * 8) - iBitLength3;
            if (i5 < j2) {
                if (((bArrCopyOf[i5 / 8] >> (7 - (i5 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i5++;
            } else {
                MessageDigest messageDigest2 = (MessageDigest) zzhwcVar.f34420a.a(zzhwz.a(this.f34446c));
                int digestLength2 = messageDigest2.getDigestLength();
                byte[] bArr4 = new byte[i4];
                int i6 = 0;
                int i7 = 0;
                while (i6 <= (i3 - 2) / digestLength2) {
                    messageDigest2.reset();
                    messageDigest2.update(bArrCopyOfRange);
                    int i8 = i2;
                    messageDigest2.update(zzhhe.b(BigInteger.valueOf(i6), 4));
                    byte[] bArrDigest2 = messageDigest2.digest();
                    int length3 = bArrDigest2.length;
                    System.arraycopy(bArrDigest2, 0, bArr4, i7, Math.min(length3, i4 - i7));
                    i7 += length3;
                    i6++;
                    i2 = i8;
                    messageDigest2 = messageDigest2;
                }
                int i9 = i2;
                byte[] bArr5 = new byte[i4];
                for (int i10 = 0; i10 < i4; i10++) {
                    bArr5[i10] = (byte) (bArr4[i10] ^ bArrCopyOf[i10]);
                }
                for (int i11 = 0; i11 <= j2; i11++) {
                    int i12 = i11 / 8;
                    bArr5[i12] = (byte) ((~(1 << (7 - (i11 % 8)))) & bArr5[i12]);
                }
                int i13 = 0;
                while (true) {
                    int i14 = (i3 - i9) - 2;
                    if (i13 >= i14) {
                        if (bArr5[i14] != 1) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr5, i4 - i9, i4);
                        int i15 = digestLength + 8;
                        byte[] bArr6 = new byte[i15 + i9];
                        System.arraycopy(bArrDigest, 0, bArr6, 8, bArrDigest.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr6, i15, bArrCopyOfRange2.length);
                        if (!MessageDigest.isEqual(messageDigest.digest(bArr6), bArrCopyOfRange)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                    if (bArr5[i13] != 0) {
                        throw new GeneralSecurityException("inconsistent");
                    }
                    i13++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34448e;
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
