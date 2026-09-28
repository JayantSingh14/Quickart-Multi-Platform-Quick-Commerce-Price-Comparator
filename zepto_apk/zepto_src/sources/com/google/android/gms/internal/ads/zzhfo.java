package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhfo implements zzgzq {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f33717d = zzhwm.a("7a806c");

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f33718e = zzhwm.a("46bb91c3c5");

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f33719f = zzhwm.a("36864200e0eaf5284d884a0e77d31646");

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f33720g = zzhwm.a("bae8e37fc83441b16034566b");

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f33721h = zzhwm.a("af60eb711bd85bc1e4d3e0a462e074eea428a8");

    /* renamed from: a, reason: collision with root package name */
    public final zzhfn f33722a;

    /* renamed from: b, reason: collision with root package name */
    public final SecretKeySpec f33723b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f33724c;

    public zzhfo(byte[] bArr, byte[] bArr2) throws InvalidAlgorithmParameterException {
        zzhgw zzhgwVar = zzhgw.f33778a;
        this.f33724c = bArr2;
        zzhxa.a(bArr.length);
        this.f33723b = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        this.f33722a = zzhgwVar;
    }

    public static boolean a(Cipher cipher) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            byte[] bArr = f33720g;
            cipher.init(2, new SecretKeySpec(f33719f, CLConstants.AES_KEY_VAULT_KEY), new GCMParameterSpec(128, bArr, 0, bArr.length));
            cipher.updateAAD(f33718e);
            byte[] bArr2 = f33721h;
            return MessageDigest.isEqual(cipher.doFinal(bArr2, 0, bArr2.length), f33717d);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        byte[] bArr3 = this.f33724c;
        int length2 = bArr3.length;
        if (length < length2 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzhkl.c(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        Cipher cipherA = ((zzhgw) this.f33722a).a();
        cipherA.init(2, this.f33723b, new GCMParameterSpec(128, bArr, length2, 12));
        if (bArr2 != null && bArr2.length != 0) {
            cipherA.updateAAD(bArr2);
        }
        return cipherA.doFinal(bArr, length2 + 12, (length - length2) - 12);
    }
}
