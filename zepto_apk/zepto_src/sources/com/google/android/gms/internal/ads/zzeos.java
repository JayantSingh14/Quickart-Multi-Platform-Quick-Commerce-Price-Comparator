package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeos implements com.google.android.gms.ads.internal.zzg {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdt f29996a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfic f29997b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfhr f29998c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzeoz f29999d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzeou f30000e;

    public zzeos(zzeou zzeouVar, zzcdt zzcdtVar, zzfic zzficVar, zzfhr zzfhrVar, zzeoz zzeozVar) {
        this.f29996a = zzcdtVar;
        this.f29997b = zzficVar;
        this.f29998c = zzfhrVar;
        this.f29999d = zzeozVar;
        Objects.requireNonNull(zzeouVar);
        this.f30000e = zzeouVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
        zzepd zzepdVar = this.f30000e.f30006d;
        zzfhr zzfhrVar = this.f29998c;
        zzepb zzepbVar = new zzepb(new zzepa(zzepdVar, zzfhrVar), null);
        zzdjt zzdjtVarD = zzepdVar.f30023a.d(new zzcwa(this.f29997b, zzfhrVar, null), zzepbVar);
        zzepc zzepcVar = new zzepc(zzepdVar, zzdjtVarD);
        zzeoz zzeozVar = this.f29999d;
        synchronized (zzeozVar) {
            zzeozVar.f30014a = zzepcVar;
        }
        this.f29996a.b(zzdjtVarD.g());
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
    }
}
