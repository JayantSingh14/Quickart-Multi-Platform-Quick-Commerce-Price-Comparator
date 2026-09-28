package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzenh implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29863a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdtj f29864b;

    public zzenh(Context context, zzdtj zzdtjVar) {
        this.f29863a = context;
        this.f29864b = zzdtjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final Object a(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        zzele zzeleVar = new zzele(zzfhrVar, (zzbuy) zzejjVar.f29463b, AdFormat.REWARDED);
        zzdtf zzdtfVarA = this.f29864b.a(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzdtg(zzeleVar, null));
        zzeleVar.f29631d = zzdtfVarA.c();
        zzekv zzekvVar = (zzekv) zzejjVar.f29464c;
        zzcnx zzcnxVar = (zzcnx) zzdtfVarA;
        zzekvVar.Yb(new zzeod((zzdai) zzcnxVar.B.zzb(), (zzdip) zzcnxVar.D.zzb(), (zzdbc) zzcnxVar.w.zzb(), (zzdbr) zzcnxVar.z.zzb(), (zzdbw) zzcnxVar.E.zzb(), (zzdax) zzcnxVar.L.zzb(), (zzdfo) zzcnxVar.f26753d.k1.zzb(), (zzdjn) zzcnxVar.I.zzb(), (zzdcv) zzcnxVar.H.zzb(), (zzdja) zzcnxVar.N.zzb(), (zzdfk) zzcnxVar.J.zzb()));
        return zzdtfVarA.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        try {
            zzbuy zzbuyVar = (zzbuy) zzejjVar.f29463b;
            zzbuyVar.zzo(zzfhrVar.Z);
            zzfik zzfikVar = zzficVar.f31193a.f31185a;
            int i2 = zzfikVar.p.f31184a;
            IInterface iInterface = zzejjVar.f29464c;
            Context context = this.f29863a;
            JSONObject jSONObject = zzfhrVar.v;
            if (i2 == 3) {
                zzbuyVar.Pa(zzfhrVar.U, jSONObject.toString(), zzfikVar.f31216d, new ObjectWrapper(context), new zzeng(this, zzejjVar), (zzbtf) iInterface);
            } else {
                zzbuyVar.n3(zzfhrVar.U, jSONObject.toString(), zzfikVar.f31216d, new ObjectWrapper(context), new zzeng(this, zzejjVar), (zzbtf) iInterface);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Remote exception loading a rewarded RTB ad", e2);
        }
    }
}
