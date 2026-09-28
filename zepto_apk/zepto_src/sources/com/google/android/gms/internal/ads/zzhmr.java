package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhmr implements zzhmn {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f34037d = new zzhmq();

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f34038a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f34039b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34040c;

    public zzhmr(byte[] bArr) throws GeneralSecurityException {
        zzhxa.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        this.f34038a = secretKeySpec;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) f34037d.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrA = zzhmb.a(cipher.doFinal(new byte[16]));
        this.f34039b = bArrA;
        this.f34040c = zzhmb.a(bArrA);
    }

    @Override // com.google.android.gms.internal.ads.zzhmn
    public final byte[] a(int i2, byte[] bArr) throws GeneralSecurityException {
        byte[] bArrB;
        if (i2 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        SecretKeySpec secretKeySpec = this.f34038a;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) f34037d.get();
        cipher.init(1, secretKeySpec);
        int length = bArr.length;
        int i3 = length != 0 ? 1 + ((length - 1) >> 4) : 1;
        int i4 = i3 - 1;
        int i5 = i4 * 16;
        if (i3 * 16 == length) {
            bArrB = zzhvp.b(i5, bArr, this.f34039b);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5, length);
            int length2 = bArrCopyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[length2] = -128;
            if (bArrCopyOf.length != 16) {
                throw new IllegalArgumentException("The lengths of x and y should match.");
            }
            bArrB = zzhvp.b(0, bArrCopyOf, this.f34040c);
        }
        byte[] bArr2 = new byte[16];
        byte[] bArr3 = new byte[16];
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = i6 * 16;
            for (int i8 = 0; i8 < 16; i8++) {
                bArr3[i8] = (byte) (bArr2[i8] ^ bArr[i8 + i7]);
            }
            if (cipher.doFinal(bArr3, 0, 16, bArr2) != 16) {
                throw new IllegalStateException("Cipher didn't write full block");
            }
        }
        for (int i9 = 0; i9 < 16; i9++) {
            bArr3[i9] = (byte) (bArr2[i9] ^ bArrB[i9]);
        }
        if (cipher.doFinal(bArr3, 0, 16, bArr2) == 16) {
            return i2 == 16 ? bArr2 : Arrays.copyOf(bArr2, i2);
        }
        throw new IllegalStateException("Cipher didn't write full block");
    }
}
