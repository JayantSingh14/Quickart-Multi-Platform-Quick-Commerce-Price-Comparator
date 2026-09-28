package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzegp implements zzdby, zzdan {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f29290c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static int f29291d;

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f29292a;

    /* renamed from: b, reason: collision with root package name */
    public final zzegz f29293b;

    public zzegp(zzegz zzegzVar, com.google.android.gms.ads.internal.util.zzj zzjVar) {
        this.f29293b = zzegzVar;
        this.f29292a = zzjVar;
    }

    public final void a(boolean z) {
        int i2;
        int iIntValue;
        zzbgb zzbgbVar = zzbgk.R6;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && !this.f29292a.q()) {
            Object obj = f29290c;
            synchronized (obj) {
                i2 = f29291d;
                iIntValue = ((Integer) zzbdVar.f21153c.a(zzbgk.S6)).intValue();
            }
            if (i2 < iIntValue) {
                zzegz zzegzVar = this.f29293b;
                zzfmb zzfmbVarA = zzegzVar.f29320d.a(new Bundle());
                zzfmbVarA.q(new zzgyk(zzfmbVarA, new zzegy(zzegzVar, z)), zzcdo.f25988g);
                synchronized (obj) {
                    f29291d++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdan
    public final void m0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        a(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final void zzg() {
        a(true);
    }
}
