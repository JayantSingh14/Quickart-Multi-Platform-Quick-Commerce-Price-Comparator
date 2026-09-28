package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzbmu implements zzbnn {
    @Override // com.google.android.gms.internal.ads.zzbnn
    public final /* bridge */ /* synthetic */ void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        if (zzcirVar.I() != null) {
            zzcirVar.I().g();
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZ = zzcirVar.z();
        if (zzmVarZ != null) {
            zzmVarZ.zzb();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarA = zzcirVar.A();
        if (zzmVarA != null) {
            zzmVarA.zzb();
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
