package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzcbn {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzg f25840a;

    public zzcbn(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.f25840a = zzgVar;
    }

    public final void a(int i2, long j2) {
        zzbgb zzbgbVar = zzbgk.P0;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.f25840a;
        if (j2 - zzgVar.w() < 0) {
            com.google.android.gms.ads.internal.util.zze.k("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.Q0)).booleanValue()) {
            zzgVar.Q(i2);
            zzgVar.R0(j2);
        } else {
            zzgVar.Q(-1);
            zzgVar.R0(j2);
        }
    }
}
