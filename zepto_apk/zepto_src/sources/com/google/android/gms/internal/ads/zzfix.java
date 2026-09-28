package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzfix {

    /* renamed from: a, reason: collision with root package name */
    public final zzfhr f31242a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfhu f31243b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfpi f31244c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfpa f31245d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfno f31246e;

    /* renamed from: f, reason: collision with root package name */
    public final zzcra f31247f;

    public zzfix(zzfpi zzfpiVar, zzfpa zzfpaVar, zzfhr zzfhrVar, zzfhu zzfhuVar, zzcra zzcraVar, zzfno zzfnoVar) {
        this.f31242a = zzfhrVar;
        this.f31243b = zzfhuVar;
        this.f31244c = zzfpiVar;
        this.f31245d = zzfpaVar;
        this.f31247f = zzcraVar;
        this.f31246e = zzfnoVar;
    }

    public final void a(ArrayList arrayList, zzdcz zzdczVar) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzfhr zzfhrVar = this.f31242a;
            if (zzfhrVar.i0) {
                String str2 = this.f31243b.f31167b;
                zzfpa zzfpaVar = this.f31245d;
                zzfpaVar.getClass();
                zzehw zzehwVar = new zzehw(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis(), str2, str, 2);
                zzehu zzehuVar = zzfpaVar.f31533a;
                zzehuVar.getClass();
                zzehuVar.a(new zzehr(zzehuVar, zzehwVar));
            } else {
                this.f31244c.b(str, zzfhrVar.x0, this.f31246e, zzdczVar);
            }
        }
    }

    public final void b(int i2, ArrayList arrayList) {
        ListenableFuture listenableFutureA;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.hb)).booleanValue() && zzcra.b(str)) {
                listenableFutureA = this.f31247f.a(str, com.google.android.gms.ads.internal.client.zzbb.f21141g.f21146e);
            } else {
                listenableFutureA = zzgym.a(str);
            }
            zzfiw zzfiwVar = new zzfiw(this, i2);
            listenableFutureA.q(new zzgyk(listenableFutureA, zzfiwVar), zzcdo.f25982a);
        }
    }
}
