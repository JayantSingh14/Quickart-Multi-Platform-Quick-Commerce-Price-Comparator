package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzctr implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcuv f27129a;

    public zzctr(zzcuv zzcuvVar) {
        this.f27129a = zzcuvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Object zzgvoVar;
        zzcuv zzcuvVar = this.f27129a;
        zzctj zzctjVar = zzcuvVar.f27182a.f27154a;
        zzcuu zzcuuVar = new zzcuu(zzctjVar.f27120d, (Executor) zzcuvVar.f27183b.zzb());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Kd)).booleanValue()) {
            zzdij zzdijVar = new zzdij(zzcuuVar, zzcdo.f25982a);
            int i2 = zzgtn.f33203c;
            zzgvoVar = new zzgvo(zzdijVar);
        } else {
            int i3 = zzgtn.f33203c;
            zzgvoVar = zzgve.f33249j;
        }
        zzijo.a(zzgvoVar);
        return zzgvoVar;
    }
}
