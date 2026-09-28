package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhvk implements zzgzq {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f34385e = new zzhvj();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f34386a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhmn f34387b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f34388c;

    /* renamed from: d, reason: collision with root package name */
    public final int f34389d;

    public zzhvk(int i2, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i2 != 12 && i2 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.f34389d = i2;
        int length = bArr.length;
        zzhxa.a(length);
        this.f34388c = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        this.f34387b = zzhwp.b(zzhml.c(zzhmm.b(length), new zzhxe(zzhxc.a(bArr))));
        this.f34386a = bArr2;
    }

    public static zzhvk a(zzhbv zzhbvVar) throws GeneralSecurityException {
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        zzhbvVar.getClass();
        return new zzhvk(zzhbvVar.f33492a.f33511b, zzhbvVar.f33493b.f34463a.b(), zzhbvVar.f33494c.b());
    }

    public final byte[] b(int i2, int i3, byte[] bArr, int i4) {
        byte[] bArr2 = new byte[i4 + 16];
        bArr2[15] = (byte) i2;
        System.arraycopy(bArr, i3, bArr2, 16, i4);
        return this.f34387b.a(16, bArr2);
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.f34386a;
        int length2 = bArr3.length;
        int i2 = this.f34389d;
        int i3 = ((length - length2) - i2) - 16;
        if (i3 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzhkl.c(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrB = b(0, length2, bArr, i2);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrB2 = b(1, 0, bArr2, bArr2.length);
        byte[] bArrB3 = b(2, length2 + i2, bArr, i3);
        int i4 = length - 16;
        byte b2 = 0;
        for (int i5 = 0; i5 < 16; i5++) {
            b2 = (byte) (b2 | (((bArr[i4 + i5] ^ bArrB2[i5]) ^ bArrB[i5]) ^ bArrB3[i5]));
        }
        if (b2 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher = (Cipher) f34385e.get();
        cipher.init(1, this.f34388c, new IvParameterSpec(bArrB));
        return cipher.doFinal(bArr, bArr3.length + i2, i3);
    }
}
