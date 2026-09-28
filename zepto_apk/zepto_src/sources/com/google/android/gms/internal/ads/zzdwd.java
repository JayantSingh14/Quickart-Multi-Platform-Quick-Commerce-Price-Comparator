package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbfp;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzdwd implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzfch f28651a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclp f28652b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijk f28653c;

    public zzdwd(zzfch zzfchVar, zzclp zzclpVar, zzijk zzijkVar) {
        this.f28651a = zzfchVar;
        this.f28652b = zzclpVar;
        this.f28653c = zzijkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Set setSingleton;
        final String str = this.f28651a.f30838a.f30832a.f25727h;
        zzijo.a(str);
        Context contextA = this.f28652b.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        Map mapZzb = this.f28653c.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.P5)).booleanValue()) {
            zzbfj zzbfjVar = new zzbfj(new zzbfo(contextA));
            zzbfjVar.a(new zzbfi() { // from class: com.google.android.gms.internal.ads.zzdwe
                @Override // com.google.android.gms.internal.ads.zzbfi
                public final void a(zzbfp.zzt.zza zzaVar) {
                    String str2 = str;
                    zzaVar.j();
                    ((zzbfp.zzt) zzaVar.f34638b).D(str2);
                }
            });
            setSingleton = Collections.singleton(new zzdij(new zzdwg(zzbfjVar, mapZzb), zzgywVar));
        } else {
            setSingleton = Collections.EMPTY_SET;
        }
        zzijo.a(setSingleton);
        return setSingleton;
    }
}
