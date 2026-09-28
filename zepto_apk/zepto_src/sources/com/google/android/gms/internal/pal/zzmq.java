package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzmq {

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadLocal f37929c = new zzmp();

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f37930a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f37931b;

    public zzmq(byte[] bArr, boolean z) throws GeneralSecurityException {
        if (!zzna.a(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzys.a(bArr.length);
        this.f37930a = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        this.f37931b = z;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        int length = bArr2.length;
        if (length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        boolean z = this.f37931b;
        byte[] bArr3 = new byte[z ? length + 28 : length + 16];
        if (z) {
            System.arraycopy(bArr, 0, bArr3, 0, 12);
        }
        "The Android Project".equals(System.getProperty("java.vendor"));
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, bArr, 0, 12);
        ThreadLocal threadLocal = f37929c;
        ((Cipher) threadLocal.get()).init(1, this.f37930a, gCMParameterSpec);
        int iDoFinal = ((Cipher) threadLocal.get()).doFinal(bArr2, 0, length, bArr3, true != z ? 0 : 12);
        if (iDoFinal == length + 16) {
            return bArr3;
        }
        throw new GeneralSecurityException(android.support.v4.media.b.g(iDoFinal - length, "encryption failed; GCM tag must be 16 bytes, but got only ", " bytes"));
    }
}
