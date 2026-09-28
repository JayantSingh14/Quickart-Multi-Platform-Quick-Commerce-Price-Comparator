package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzlk implements zzjt {

    /* renamed from: a, reason: collision with root package name */
    public final zzlb f37921a;

    /* renamed from: b, reason: collision with root package name */
    public final zzrc f37922b;

    /* renamed from: c, reason: collision with root package name */
    public final zzrc f37923c;

    public zzlk(zzlb zzlbVar) {
        this.f37921a = zzlbVar;
        boolean zIsEmpty = zzlbVar.f37910c.f38040a.isEmpty();
        zzrc zzrcVar = zzpf.f37995a;
        if (zIsEmpty) {
            this.f37922b = zzrcVar;
        } else {
            Object obj = (zzrd) zzpi.f37996b.f37998a.get();
            obj = obj == null ? zzpi.f37997c : obj;
            zzpf.a(zzlbVar);
            obj.getClass();
            this.f37922b = zzrcVar;
        }
        this.f37923c = zzrcVar;
    }

    @Override // com.google.android.gms.internal.pal.zzjt
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        zzkv zzkvVar = this.f37921a.f37909b;
        byte[] bArr3 = zzkvVar.f37900b;
        byte[] bArrC = zzxo.c(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((zzjt) zzkvVar.f37899a).zza(bArr, bArr2));
        zzkvVar.getClass();
        int length = bArr.length;
        return bArrC;
    }
}
