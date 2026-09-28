package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzxi implements zzjt {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f38110e = new zzxg();

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadLocal f38111f = new zzxh();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f38112a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f38113b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f38114c;

    /* renamed from: d, reason: collision with root package name */
    public final int f38115d;

    public zzxi(byte[] bArr, int i2) throws GeneralSecurityException {
        if (!zzna.a(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i2 != 12 && i2 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.f38115d = i2;
        zzys.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        this.f38114c = secretKeySpec;
        Cipher cipher = (Cipher) f38110e.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrA = a(cipher.doFinal(new byte[16]));
        this.f38112a = bArrA;
        this.f38113b = a(bArrA);
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 < 15) {
            byte b2 = bArr[i2];
            int i3 = i2 + 1;
            bArr2[i2] = (byte) (((b2 + b2) ^ ((bArr[i3] & 255) >>> 7)) & 255);
            i2 = i3;
        }
        byte b3 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & WKSRecord.Service.LOC_SRV) ^ (b3 + b3));
        return bArr2;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    public final byte[] b(Cipher cipher, int i2, byte[] bArr, int i3, int i4) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrCopyOf;
        int length;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i2;
        byte[] bArr3 = this.f38112a;
        if (i4 == 0) {
            return cipher.doFinal(c(bArr2, bArr3));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i5 = 0;
        int i6 = 0;
        while (i4 - i6 > 16) {
            for (int i7 = 0; i7 < 16; i7++) {
                bArrDoFinal[i7] = (byte) (bArrDoFinal[i7] ^ bArr[(i3 + i6) + i7]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i6 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i6 + i3, i3 + i4);
        if (bArrCopyOfRange.length == 16) {
            bArrCopyOf = c(bArrCopyOfRange, bArr3);
        } else {
            bArrCopyOf = Arrays.copyOf(this.f38113b, 16);
            while (true) {
                length = bArrCopyOfRange.length;
                if (i5 >= length) {
                    break;
                }
                bArrCopyOf[i5] = (byte) (bArrCopyOf[i5] ^ bArrCopyOfRange[i5]);
                i5++;
            }
            bArrCopyOf[length] = (byte) (bArrCopyOf[length] ^ 128);
        }
        return cipher.doFinal(c(bArrDoFinal, bArrCopyOf));
    }

    @Override // com.google.android.gms.internal.pal.zzjt
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.f38115d;
        if (length > 2147483631 - i2) {
            throw new GeneralSecurityException("plaintext too long");
        }
        int i3 = i2 + length;
        byte[] bArr3 = new byte[i3 + 16];
        byte[] bArrA = zzyq.a(i2);
        System.arraycopy(bArrA, 0, bArr3, 0, i2);
        Cipher cipher = (Cipher) f38110e.get();
        SecretKeySpec secretKeySpec = this.f38114c;
        cipher.init(1, secretKeySpec);
        byte[] bArrB = b(cipher, 0, bArrA, 0, bArrA.length);
        byte[] bArrB2 = b(cipher, 1, bArr2, 0, 0);
        Cipher cipher2 = (Cipher) f38111f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrB));
        cipher2.doFinal(bArr, 0, length, bArr3, this.f38115d);
        byte[] bArrB3 = b(cipher, 2, bArr3, this.f38115d, length);
        for (int i4 = 0; i4 < 16; i4++) {
            bArr3[i3 + i4] = (byte) ((bArrB2[i4] ^ bArrB[i4]) ^ bArrB3[i4]);
        }
        return bArr3;
    }
}
