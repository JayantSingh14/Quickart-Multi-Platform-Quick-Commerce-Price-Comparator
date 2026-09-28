package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcrg implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26952a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcrm f26953b;

    public zzcrg(zzcrm zzcrmVar, String str) {
        this.f26952a = str;
        Objects.requireNonNull(zzcrmVar);
        this.f26953b = zzcrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzcrm zzcrmVar = this.f26953b;
        zzfpe zzfpeVar = zzcrmVar.f26969g;
        List listA = zzcrmVar.a();
        zzcdb zzcdbVar = zzcrmVar.s;
        zzcrmVar.f26970h.a(zzfpeVar.b(zzcrmVar.f26967e, zzcrmVar.f26968f, false, this.f26952a, null, listA, zzcrmVar.o, zzcdbVar), null);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        zzcrm zzcrmVar = this.f26953b;
        List listA = zzcrmVar.a();
        zzcdb zzcdbVar = zzcrmVar.s;
        zzcrmVar.f26970h.a(zzcrmVar.f26969g.b(zzcrmVar.f26967e, zzcrmVar.f26968f, false, this.f26952a, str, listA, zzcrmVar.o, zzcdbVar), zzcrmVar.n);
    }
}
