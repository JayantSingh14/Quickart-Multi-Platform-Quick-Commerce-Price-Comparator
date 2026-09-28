package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzxk implements zzjw {

    /* renamed from: c, reason: collision with root package name */
    public static final List f38117c = Arrays.asList(64);

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f38118d = new byte[16];

    /* renamed from: a, reason: collision with root package name */
    public final zzyl f38119a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f38120b;

    public zzxk(byte[] bArr) throws GeneralSecurityException {
        if (!zzna.a(1)) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        int length = bArr.length;
        if (!f38117c.contains(Integer.valueOf(length))) {
            throw new InvalidKeyException(android.support.v4.media.b.g(length, "invalid key size: ", " bytes; key must have 64 bytes"));
        }
        int i2 = length >> 1;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i2);
        this.f38120b = Arrays.copyOfRange(bArr, i2, length);
        this.f38119a = new zzyl(bArrCopyOfRange);
    }

    @Override // com.google.android.gms.internal.pal.zzjw
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArrD;
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = (Cipher) zzxz.f38141e.a("AES/CTR/NoPadding");
        byte[][] bArr3 = {bArr2, bArr};
        zzyl zzylVar = this.f38119a;
        byte[] bArrA = zzylVar.a(16, f38118d);
        for (int i2 = 0; i2 <= 0; i2++) {
            byte[] bArr4 = bArr3[i2];
            if (bArr4 == null) {
                bArr4 = new byte[0];
            }
            bArrA = zzxo.d(zzqy.a(bArrA), zzylVar.a(16, bArr4));
        }
        byte[] bArr5 = bArr3[1];
        int length = bArr5.length;
        if (length >= 16) {
            int length2 = bArrA.length;
            if (length < length2) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int i3 = length - length2;
            bArrD = Arrays.copyOf(bArr5, length);
            for (int i4 = 0; i4 < bArrA.length; i4++) {
                int i5 = i3 + i4;
                bArrD[i5] = (byte) (bArrD[i5] ^ bArrA[i4]);
            }
        } else {
            int length3 = bArr5.length;
            if (length3 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr5, 16);
            bArrCopyOf[length3] = -128;
            bArrD = zzxo.d(bArrCopyOf, zzqy.a(bArrA));
        }
        byte[] bArrA2 = zzylVar.a(16, bArrD);
        byte[] bArr6 = (byte[]) bArrA2.clone();
        bArr6[8] = (byte) (bArr6[8] & 127);
        bArr6[12] = (byte) (bArr6[12] & 127);
        cipher.init(1, new SecretKeySpec(this.f38120b, CLConstants.AES_KEY_VAULT_KEY), new IvParameterSpec(bArr6));
        return zzxo.c(bArrA2, cipher.doFinal(bArr));
    }
}
