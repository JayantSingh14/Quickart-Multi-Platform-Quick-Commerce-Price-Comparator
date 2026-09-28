package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzmz implements zzjt {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f37936b = new zzmy();

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f37937a;

    public zzmz(byte[] bArr) throws InvalidAlgorithmParameterException {
        zzys.a(bArr.length);
        this.f37937a = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
    }

    @Override // com.google.android.gms.internal.pal.zzjt
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException, ClassNotFoundException {
        AlgorithmParameterSpec ivParameterSpec;
        int length = bArr.length;
        if (length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[length + 28];
        byte[] bArrA = zzyq.a(12);
        System.arraycopy(bArrA, 0, bArr3, 0, 12);
        int length2 = bArrA.length;
        try {
            Class.forName("javax.crypto.spec.GCMParameterSpec");
            ivParameterSpec = new GCMParameterSpec(128, bArrA, 0, length2);
        } catch (ClassNotFoundException unused) {
            if (!"The Android Project".equals(System.getProperty("java.vendor"))) {
                throw new GeneralSecurityException("cannot use AES-GCM: javax.crypto.spec.GCMParameterSpec not found");
            }
            ivParameterSpec = new IvParameterSpec(bArrA, 0, length2);
        }
        ThreadLocal threadLocal = f37936b;
        ((Cipher) threadLocal.get()).init(1, this.f37937a, ivParameterSpec);
        int iDoFinal = ((Cipher) threadLocal.get()).doFinal(bArr, 0, length, bArr3, 12);
        if (iDoFinal == length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(android.support.v4.media.b.g(iDoFinal - length, "encryption failed; GCM tag must be 16 bytes, but got only ", " bytes"));
    }
}
