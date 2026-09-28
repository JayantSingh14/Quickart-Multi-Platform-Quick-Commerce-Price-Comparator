package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhvl implements zzgzq {

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f34390a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f34391b;

    public zzhvl(byte[] bArr, zzhxc zzhxcVar) throws GeneralSecurityException {
        if (!zzhhb.a(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        ThreadLocal threadLocal = zzhfh.f33708a;
        zzhxa.a(bArr.length);
        this.f34390a = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        this.f34391b = zzhxcVar.b();
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.f34391b;
        int length2 = bArr3.length;
        if (length < length2 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzhkl.c(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        ThreadLocal threadLocal = zzhfh.f33708a;
        Objects.equals(System.getProperty("java.vendor"), "The Android Project");
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, length2, 12);
        SecretKeySpec secretKeySpec = this.f34390a;
        Cipher cipher = (Cipher) zzhfh.f33708a.get();
        cipher.init(2, secretKeySpec, gCMParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        return cipher.doFinal(bArr, 12 + length2, (length - length2) - 12);
    }
}
