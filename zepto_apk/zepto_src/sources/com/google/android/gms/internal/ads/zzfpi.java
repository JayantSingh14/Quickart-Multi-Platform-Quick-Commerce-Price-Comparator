package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzfpi {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31561a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f31562b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyx f31563c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.client.zzu f31564d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfpa f31565e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfnr f31566f;

    /* renamed from: g, reason: collision with root package name */
    public final zzcld f31567g;

    public zzfpi(Context context, zzgyw zzgywVar, zzgyx zzgyxVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzfpa zzfpaVar, zzfnr zzfnrVar, zzcld zzcldVar) {
        this.f31561a = context;
        this.f31562b = zzgywVar;
        this.f31563c = zzgyxVar;
        this.f31564d = zzuVar;
        this.f31565e = zzfpaVar;
        this.f31566f = zzfnrVar;
        this.f31567g = zzcldVar;
    }

    public final void a(List list, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            b((String) it.next(), zzvVar, null, null);
        }
    }

    public final void b(final String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzfno zzfnoVar, zzdcz zzdczVar) {
        ListenableFuture listenableFutureSubmit;
        zzfne zzfneVarF = null;
        if (zzfnr.a() && ((Boolean) zzbid.f25134d.c()).booleanValue()) {
            zzfneVarF = zzfne.f(14, this.f31561a);
            zzfneVarF.zza();
        }
        if (zzvVar != null) {
            listenableFutureSubmit = new zzfoz(zzvVar.f21451a, this.f31564d, this.f31563c, this.f31565e, this.f31567g).a(str);
        } else {
            listenableFutureSubmit = this.f31563c.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfph
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzfpi zzfpiVar = this.f31559a;
                    zzfpiVar.getClass();
                    zzbgb zzbgbVar = zzbgk.U9;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                    boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
                    String str2 = str;
                    com.google.android.gms.ads.internal.util.client.zzu zzuVar = zzfpiVar.f31564d;
                    if (zBooleanValue) {
                        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                        if (zztVar.f21679c.H(str2) || zztVar.f21679c.I(str2)) {
                            zziic zziicVar = zzfpiVar.f31567g.f26497c;
                            String strEncodeToString = zziicVar != null ? Base64.encodeToString(zziicVar.g(), 10) : null;
                            HashMap map = new HashMap();
                            if (strEncodeToString != null) {
                                map.put((String) zzbdVar.f21153c.a(zzbgk.V9), strEncodeToString);
                            }
                            return zzuVar.b(str2, map);
                        }
                    }
                    return zzuVar.b(str2, null);
                }
            });
        }
        listenableFutureSubmit.q(new zzgyk(listenableFutureSubmit, new zzfpg(this, zzfneVarF, zzfnoVar, zzdczVar)), this.f31562b);
    }
}
