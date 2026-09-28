package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzqw implements zzkq {

    /* renamed from: a, reason: collision with root package name */
    public final zzlb f38034a;

    /* renamed from: b, reason: collision with root package name */
    public final zzrc f38035b;

    /* renamed from: c, reason: collision with root package name */
    public final zzrc f38036c;

    public zzqw(zzlb zzlbVar) {
        this.f38034a = zzlbVar;
        boolean zIsEmpty = zzlbVar.f37910c.f38040a.isEmpty();
        zzrc zzrcVar = zzpf.f37995a;
        if (zIsEmpty) {
            this.f38035b = zzrcVar;
        } else {
            Object obj = (zzrd) zzpi.f37996b.f37998a.get();
            obj = obj == null ? zzpi.f37997c : obj;
            zzpf.a(zzlbVar);
            obj.getClass();
            this.f38035b = zzrcVar;
        }
        this.f38036c = zzrcVar;
    }

    @Override // com.google.android.gms.internal.pal.zzkq
    public final byte[] a(byte[] bArr) throws GeneralSecurityException {
        zzkv zzkvVar = this.f38034a.f37909b;
        if (zzkvVar.f37904f == 4) {
            bArr = zzxo.c(bArr, zzqx.f38037a);
        }
        byte[] bArr2 = zzkvVar.f37900b;
        byte[] bArrC = zzxo.c(bArr2 == null ? null : Arrays.copyOf(bArr2, bArr2.length), ((zzkq) zzkvVar.f37899a).a(bArr));
        zzkvVar.getClass();
        return bArrC;
    }
}
