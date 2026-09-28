package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhgj implements zzgzq {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f33756a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33757b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhmn f33758c;

    public zzhgj(byte[] bArr, zzhxc zzhxcVar, int i2) {
        this.f33758c = zzhwp.b(zzhml.c(zzhmm.b(bArr.length), new zzhxe(zzhxc.a(bArr))));
        this.f33756a = zzhxcVar.b();
        this.f33757b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        int length = bArr.length;
        byte[] bArr3 = this.f33756a;
        int length2 = bArr3.length;
        int i2 = this.f33757b + length2;
        int i3 = i2 + 28;
        if (length < i3) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzhkl.c(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i2);
        byte[] bArr4 = {0, 1, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr5 = {0, 2, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int length3 = bArrCopyOfRange.length;
        if (length3 > 12 || length3 < 8) {
            throw new GeneralSecurityException("invalid salt size");
        }
        System.arraycopy(bArrCopyOfRange, 0, bArr4, 4, length3);
        System.arraycopy(bArrCopyOfRange, 0, bArr5, 4, length3);
        byte[] bArr6 = new byte[32];
        zzhmn zzhmnVar = this.f33758c;
        System.arraycopy(zzhmnVar.a(16, bArr4), 0, bArr6, 0, 16);
        System.arraycopy(zzhmnVar.a(16, bArr5), 0, bArr6, 16, 16);
        if (!zzhhb.a(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        ThreadLocal threadLocal = zzhfh.f33708a;
        zzhxa.a(32);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr6, CLConstants.AES_KEY_VAULT_KEY);
        int i4 = i2 + 12;
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i2, i4);
        if (bArrCopyOfRange2.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        if (length < i3) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Objects.equals(System.getProperty("java.vendor"), "The Android Project");
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArrCopyOfRange2, 0, 12);
        Cipher cipher = (Cipher) zzhfh.f33708a.get();
        cipher.init(2, secretKeySpec, gCMParameterSpec);
        if (bArr2 != null && bArr2.length != 0) {
            cipher.updateAAD(bArr2);
        }
        return cipher.doFinal(bArr, i4, length - i4);
    }
}
