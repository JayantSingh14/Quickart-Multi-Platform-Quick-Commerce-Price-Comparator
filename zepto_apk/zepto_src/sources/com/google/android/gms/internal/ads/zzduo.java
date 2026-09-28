package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzduo {

    /* renamed from: a, reason: collision with root package name */
    public final zzdxe f28600a;

    public zzduo(zzdxe zzdxeVar) {
        this.f28600a = zzdxeVar;
    }

    public final boolean a(zzfxs zzfxsVar) {
        boolean zN = zzfxsVar.N();
        com.google.android.gms.ads.internal.util.client.zzt zztVar = com.google.android.gms.ads.internal.util.client.zzt.f21443a;
        zzdxe zzdxeVar = this.f28600a;
        if (zN) {
            zzdxd zzdxdVarA = zzdxeVar.a();
            zzdxdVarA.b("action", "aq_ad_closed");
            zzdxdVarA.b("gqi", zzfxsVar.F());
            zzdxdVarA.b("aq_ad_duration", String.valueOf(zzfxsVar.G()));
            zzdxdVarA.b("aq_ad_bounce_cnt", String.valueOf(zzfxsVar.H()));
            zzdxdVarA.b("aq_time_away", String.valueOf(zzfxsVar.K()));
            return zzdxdVarA.d().equals(zztVar);
        }
        zzdxd zzdxdVarA2 = zzdxeVar.a();
        zzdxdVarA2.b("action", "aq_ad_kill");
        zzdxdVarA2.b("gqi", zzfxsVar.F());
        zzdxdVarA2.b("aq_ad_duration", String.valueOf(zzfxsVar.G()));
        zzdxdVarA2.b("aq_ad_bounce_cnt", String.valueOf(zzfxsVar.H()));
        zzdxdVarA2.b("aq_time_away", String.valueOf(zzfxsVar.K()));
        zzdxdVarA2.b("aq_is_os_kill", String.valueOf(zzfxsVar.J()));
        return zzdxdVarA2.d().equals(zztVar);
    }
}
