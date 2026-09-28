package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzxj implements zzjt {

    /* renamed from: a, reason: collision with root package name */
    public final zzmq f38116a;

    public zzxj(byte[] bArr) throws GeneralSecurityException {
        if (!zzna.a(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.f38116a = new zzmq(bArr, true);
    }

    @Override // com.google.android.gms.internal.pal.zzjt
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        return this.f38116a.a(zzyq.a(12), bArr);
    }
}
