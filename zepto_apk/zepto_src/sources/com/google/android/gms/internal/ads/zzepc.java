package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes4.dex */
final class zzepc implements com.google.android.gms.ads.internal.zzg {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdjt f30022a;

    public zzepc(zzepd zzepdVar, zzdjt zzdjtVar) {
        this.f30022a = zzdjtVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        this.f30022a.b().h();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        zzdjt zzdjtVar = this.f30022a;
        zzdjtVar.c().g();
        zzdit zzditVarD = zzdjtVar.d();
        synchronized (zzditVarD) {
            zzditVarD.v0(zzdis.f27796a);
        }
    }
}
