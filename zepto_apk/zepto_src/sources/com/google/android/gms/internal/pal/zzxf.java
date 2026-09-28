package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzxf implements zzyk {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f38106d = new zzxe();

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f38107a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38108b;

    /* renamed from: c, reason: collision with root package name */
    public final int f38109c;

    public zzxf(byte[] bArr, int i2) throws GeneralSecurityException {
        if (!zzna.a(2)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzys.a(bArr.length);
        this.f38107a = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        int blockSize = ((Cipher) f38106d.get()).getBlockSize();
        this.f38109c = blockSize;
        if (i2 < 12 || i2 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f38108b = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzyk
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.f38108b;
        if (length > Api.BaseClientBuilder.API_PRIORITY_OTHER - i2) {
            throw new GeneralSecurityException("plaintext length can not exceed " + (Api.BaseClientBuilder.API_PRIORITY_OTHER - i2));
        }
        byte[] bArr2 = new byte[i2 + length];
        byte[] bArrA = zzyq.a(i2);
        System.arraycopy(bArrA, 0, bArr2, 0, i2);
        Cipher cipher = (Cipher) f38106d.get();
        byte[] bArr3 = new byte[this.f38109c];
        System.arraycopy(bArrA, 0, bArr3, 0, i2);
        cipher.init(1, this.f38107a, new IvParameterSpec(bArr3));
        if (cipher.doFinal(bArr, 0, length, bArr2, this.f38108b) == length) {
            return bArr2;
        }
        throw new GeneralSecurityException("stored output's length does not match input's length");
    }
}
