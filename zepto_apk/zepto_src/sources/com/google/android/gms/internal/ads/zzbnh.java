package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* loaded from: classes4.dex */
final /* synthetic */ class zzbnh implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdir f25330a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcra f25331b;

    public /* synthetic */ zzbnh(zzdir zzdirVar, zzcra zzcraVar) {
        this.f25330a = zzdirVar;
        this.f25331b = zzcraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        zzcir zzcirVar = (zzcir) obj;
        zzbnm.b(map, this.f25330a);
        final String str = (String) map.get("u");
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URL missing from click GMSG.");
            return;
        }
        zzgye zzgyeVarS = zzgye.s(zzbnm.a(zzcirVar, str));
        final zzcra zzcraVar = this.f25331b;
        zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.internal.ads.zzbnk
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj2) {
                zzcra zzcraVar2;
                String str2 = (String) obj2;
                zzbnn zzbnnVar = zzbnm.f25337a;
                return (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.hb)).booleanValue() && (zzcraVar2 = zzcraVar) != null && zzcra.b(str)) ? zzcraVar2.a(str2, com.google.android.gms.ads.internal.client.zzbb.f21141g.f21146e) : zzgym.a(str2);
            }
        };
        zzgyw zzgywVar = zzcdo.f25982a;
        zzgye zzgyeVar = (zzgye) zzgym.h(zzgyeVarS, zzgxuVar, zzgywVar);
        zzgyeVar.q(new zzgyk(zzgyeVar, new zzbmr(zzcirVar)), zzgywVar);
    }
}
