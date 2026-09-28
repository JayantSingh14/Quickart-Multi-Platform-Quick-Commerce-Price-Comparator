package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhvi implements zzhwn {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f34381d = new zzhvh();

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f34382a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34383b;

    /* renamed from: c, reason: collision with root package name */
    public final int f34384c;

    public zzhvi(byte[] bArr, int i2) throws GeneralSecurityException {
        if (!zzhhb.a(2)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhxa.a(bArr.length);
        this.f34382a = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        int blockSize = ((Cipher) f34381d.get()).getBlockSize();
        this.f34384c = blockSize;
        if (i2 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f34383b = i2;
    }
}
