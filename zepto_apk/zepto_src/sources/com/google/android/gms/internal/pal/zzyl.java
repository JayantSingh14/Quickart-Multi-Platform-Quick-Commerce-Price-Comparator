package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzyl implements zzrj {

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f38151a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f38152b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f38153c;

    public zzyl(byte[] bArr) throws GeneralSecurityException {
        zzys.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        this.f38151a = secretKeySpec;
        if (!zzna.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) zzxz.f38141e.a("AES/ECB/NoPadding");
        cipher.init(1, secretKeySpec);
        byte[] bArrA = zzqy.a(cipher.doFinal(new byte[16]));
        this.f38152b = bArrA;
        this.f38153c = zzqy.a(bArrA);
    }

    @Override // com.google.android.gms.internal.pal.zzrj
    public final byte[] a(int i2, byte[] bArr) throws GeneralSecurityException {
        byte[] bArrD;
        if (i2 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        if (!zzna.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) zzxz.f38141e.a("AES/ECB/NoPadding");
        cipher.init(1, this.f38151a);
        int length = bArr.length;
        int iMax = Math.max(1, (int) Math.ceil(length / 16.0d));
        if (iMax * 16 == length) {
            bArrD = zzxo.e(bArr, (iMax - 1) * 16, 0, this.f38152b, 16);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, (iMax - 1) * 16, length);
            int length2 = bArrCopyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[length2] = -128;
            bArrD = zzxo.d(bArrCopyOf, this.f38153c);
        }
        byte[] bArrDoFinal = new byte[16];
        for (int i3 = 0; i3 < iMax - 1; i3++) {
            bArrDoFinal = cipher.doFinal(zzxo.e(bArrDoFinal, 0, i3 * 16, bArr, 16));
        }
        return Arrays.copyOf(cipher.doFinal(zzxo.d(bArrD, bArrDoFinal)), i2);
    }
}
