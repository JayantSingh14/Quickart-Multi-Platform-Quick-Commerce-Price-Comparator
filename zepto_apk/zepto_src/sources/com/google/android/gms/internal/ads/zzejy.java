package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzejy implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29515a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcsq f29516b;

    public zzejy(Context context, zzcsq zzcsqVar) {
        this.f29515a = context;
        this.f29516b = zzcsqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final Object a(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        zzele zzeleVar = new zzele(zzfhrVar, (zzbuy) zzejjVar.f29463b, AdFormat.APP_OPEN_AD);
        zzcsn zzcsnVarA = this.f29516b.a(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzdjw(zzeleVar, null), new zzcso(zzfhrVar.a0));
        zzeleVar.f29631d = zzcsnVarA.c();
        ((zzekv) zzejjVar.f29464c).Yb(zzcsnVarA.f());
        return zzcsnVarA.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws zzfir {
        try {
            zzbuy zzbuyVar = (zzbuy) zzejjVar.f29463b;
            zzbuyVar.zzo(zzfhrVar.Z);
            zzbuyVar.z4(zzfhrVar.U, zzfhrVar.v.toString(), zzficVar.f31193a.f31185a.f31216d, new ObjectWrapper(this.f29515a), new zzejx(zzejjVar), (zzbtf) zzejjVar.f29464c);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Remote exception loading an app open RTB ad", e2);
            throw new zzfir(e2);
        }
    }
}
