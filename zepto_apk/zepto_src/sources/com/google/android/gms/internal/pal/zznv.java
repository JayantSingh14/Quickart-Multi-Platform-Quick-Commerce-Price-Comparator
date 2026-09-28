package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* loaded from: classes4.dex */
final class zznv implements zzny {

    /* renamed from: a, reason: collision with root package name */
    public final int f37953a;

    public zznv(int i2) throws InvalidAlgorithmParameterException {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(android.support.v4.media.b.f(i2, "Unsupported key length: "));
        }
        this.f37953a = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzny
    public final byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws InvalidAlgorithmParameterException {
        int length = bArr.length;
        if (length == this.f37953a) {
            return new zzmq(bArr, false).a(bArr2, bArr3);
        }
        throw new InvalidAlgorithmParameterException(android.support.v4.media.b.f(length, "Unexpected key length: "));
    }

    @Override // com.google.android.gms.internal.pal.zzny
    public final int zza() {
        return this.f37953a;
    }

    @Override // com.google.android.gms.internal.pal.zzny
    public final byte[] zzb() throws GeneralSecurityException {
        int i2 = this.f37953a;
        if (i2 == 16) {
            return zzol.f37977i;
        }
        if (i2 == 32) {
            return zzol.f37978j;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }
}
