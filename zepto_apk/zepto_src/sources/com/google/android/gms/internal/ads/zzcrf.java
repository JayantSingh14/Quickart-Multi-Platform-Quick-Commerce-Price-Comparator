package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcrf implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcrm f26951a;

    public zzcrf(zzcrm zzcrmVar) {
        Objects.requireNonNull(zzcrmVar);
        this.f26951a = zzcrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzcrm zzcrmVar = this.f26951a;
        zzfhr zzfhrVar = zzcrmVar.f26968f;
        zzcrmVar.f26970h.b(true == com.google.android.gms.ads.internal.zzt.C.f21684h.i(zzcrmVar.f26963a) ? 2 : 1, zzcrmVar.f26969g.b(zzcrmVar.f26967e, zzfhrVar, false, "", (String) obj, zzfhrVar.f31151c, null, null));
    }
}
