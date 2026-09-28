package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzelj implements zzejm {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29643a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdkz f29644b;

    public zzelj(Context context, zzdkz zzdkzVar) {
        this.f29643a = context;
        this.f29644b = zzdkzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final Object a(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) {
        zzele zzeleVar = new zzele(zzfhrVar, (zzbuy) zzejjVar.f29463b, AdFormat.INTERSTITIAL);
        zzdjt zzdjtVarD = this.f29644b.d(new zzcwa(zzficVar, zzfhrVar, zzejjVar.f29462a), new zzdjw(zzeleVar, null));
        zzeleVar.f29631d = zzdjtVarD.c();
        ((zzekv) zzejjVar.f29464c).Yb(zzdjtVarD.f());
        return zzdjtVarD.g();
    }

    @Override // com.google.android.gms.internal.ads.zzejm
    public final void b(zzfic zzficVar, zzfhr zzfhrVar, zzejj zzejjVar) throws zzfir {
        try {
            zzbuy zzbuyVar = (zzbuy) zzejjVar.f29463b;
            zzbuyVar.zzo(zzfhrVar.Z);
            zzbuyVar.f3(zzfhrVar.U, zzfhrVar.v.toString(), zzficVar.f31193a.f31185a.f31216d, new ObjectWrapper(this.f29643a), new zzeli(this, zzejjVar), (zzbtf) zzejjVar.f29464c);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zze.l("Remote exception loading a interstitial RTB ad", e2);
            throw new zzfir(e2);
        }
    }
}
