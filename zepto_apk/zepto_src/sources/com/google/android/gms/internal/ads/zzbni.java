package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbni implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzbni f25332a = new zzbni();

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzckd zzckdVar = (zzckd) obj;
        zzbnn zzbnnVar = zzbnm.f25337a;
        String str = (String) map.get("u");
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URL missing from httpTrack GMSG.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f25017g)).booleanValue() && str.isEmpty()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URL is empty from httpTrack GMSG.");
        } else {
            zzcii zzciiVar = (zzcii) zzckdVar;
            new com.google.android.gms.ads.internal.util.zzbt(zzckdVar.getContext(), ((zzckl) zzckdVar).zzs().f21400a, str, zzciiVar.v() != null ? zzciiVar.v().x0 : null).b();
        }
    }
}
