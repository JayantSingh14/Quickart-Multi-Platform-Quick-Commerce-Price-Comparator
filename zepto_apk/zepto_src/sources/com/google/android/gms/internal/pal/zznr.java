package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zznr implements zzjy {

    /* renamed from: a, reason: collision with root package name */
    public final zzlb f37946a;

    public zznr(zzlb zzlbVar) {
        this.f37946a = zzlbVar;
    }

    @Override // com.google.android.gms.internal.pal.zzjy
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzkv zzkvVar = this.f37946a.f37909b;
        if (zzkvVar == null) {
            throw new GeneralSecurityException("keyset without primary key");
        }
        byte[] bArr3 = zzkvVar.f37900b;
        return zzxo.c(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((zzjy) zzkvVar.f37899a).zza(bArr, bArr2));
    }
}
