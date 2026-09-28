package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzfaa {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30714a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f30715b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f30716c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfno f30717d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdxe f30718e;

    /* renamed from: f, reason: collision with root package name */
    public long f30719f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f30720g = 0;

    public zzfaa(Context context, zzgyw zzgywVar, Set set, zzfno zzfnoVar, zzdxe zzdxeVar) {
        this.f30714a = context;
        this.f30716c = zzgywVar;
        this.f30715b = set;
        this.f30717d = zzfnoVar;
        this.f30718e = zzdxeVar;
    }

    public final ListenableFuture a(final Object obj, final Bundle bundle, final boolean z) {
        zzfne zzfneVarF = zzfne.f(8, this.f30714a);
        zzfneVarF.zza();
        Set<zzezx> set = this.f30715b;
        final ArrayList arrayList = new ArrayList(set.size());
        List arrayList2 = new ArrayList();
        zzbgb zzbgbVar = zzbgk.Qc;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean zIsEmpty = ((String) zzbdVar.f21153c.a(zzbgbVar)).isEmpty();
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (!zIsEmpty) {
            arrayList2 = Arrays.asList(((String) zzbgiVar.a(zzbgbVar)).split(","));
        }
        List list = arrayList2;
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        this.f30719f = zztVar.f21687k.elapsedRealtime();
        final Bundle bundle2 = new Bundle();
        if (((Boolean) zzbgiVar.a(zzbgk.z2)).booleanValue() && bundle != null) {
            long jCurrentTimeMillis = zztVar.f21687k.currentTimeMillis();
            if (obj instanceof zzczm) {
                bundle.putLong("client-signals-start", jCurrentTimeMillis);
            } else {
                bundle.putLong("gms-signals-start", jCurrentTimeMillis);
            }
        }
        for (final zzezx zzezxVar : set) {
            if (!list.contains(String.valueOf(zzezxVar.zzb()))) {
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime();
                ListenableFuture listenableFutureZza = zzezxVar.zza();
                listenableFutureZza.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezy
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str;
                        zzfaa zzfaaVar = this.f30695a;
                        long j2 = jElapsedRealtime;
                        zzezx zzezxVar2 = zzezxVar;
                        Bundle bundle3 = bundle2;
                        zzfaaVar.getClass();
                        com.google.android.gms.ads.internal.zzt zztVar2 = com.google.android.gms.ads.internal.zzt.C;
                        long jElapsedRealtime2 = zztVar2.f21687k.elapsedRealtime() - j2;
                        if (((Boolean) zzbim.f25191a.c()).booleanValue()) {
                            String canonicalName = zzezxVar2.getClass().getCanonicalName();
                            if (canonicalName == null) {
                                canonicalName = "";
                            }
                            StringBuilder sb = new StringBuilder(canonicalName.length() + 25 + String.valueOf(jElapsedRealtime2).length());
                            android.support.v4.media.a.u(sb, "Signal runtime (ms) : ", canonicalName, " = ");
                            sb.append(jElapsedRealtime2);
                            com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                        }
                        zzbgb zzbgbVar2 = zzbgk.z2;
                        com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                        if (((Boolean) zzbdVar2.f21153c.a(zzbgbVar2)).booleanValue()) {
                            if (((Boolean) zzbdVar2.f21153c.a(zzbgk.F2)).booleanValue()) {
                                synchronized (zzfaaVar) {
                                    int iZzb = zzezxVar2.zzb();
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzb).length() + 3);
                                    sb2.append("sig");
                                    sb2.append(iZzb);
                                    bundle3.putLong(sb2.toString(), jElapsedRealtime2);
                                }
                            }
                        }
                        if (((Boolean) zzbdVar2.f21153c.a(zzbgk.x2)).booleanValue()) {
                            final zzdxd zzdxdVarA = zzfaaVar.f30718e.a();
                            zzdxdVarA.b("action", "lat_ms");
                            zzdxdVarA.b("lat_grp", "sig_lat_grp");
                            zzdxdVarA.b("lat_id", String.valueOf(zzezxVar2.zzb()));
                            zzdxdVarA.b("clat_ms", String.valueOf(jElapsedRealtime2));
                            if (((Boolean) zzbdVar2.f21153c.a(zzbgk.y2)).booleanValue()) {
                                synchronized (zzfaaVar) {
                                    zzfaaVar.f30720g++;
                                }
                                zzcdd zzcddVar = zztVar2.f21684h.f25933c.f25964c;
                                synchronized (zzcddVar) {
                                    str = zzcddVar.f25961b;
                                }
                                zzdxdVarA.b("seq_num", str);
                                synchronized (zzfaaVar) {
                                    try {
                                        if (zzfaaVar.f30720g == zzfaaVar.f30715b.size() && zzfaaVar.f30719f != 0) {
                                            zzfaaVar.f30720g = 0;
                                            String strValueOf = String.valueOf(zztVar2.f21687k.elapsedRealtime() - zzfaaVar.f30719f);
                                            if (zzezxVar2.zzb() <= 39 || zzezxVar2.zzb() >= 52) {
                                                zzdxdVarA.b("lat_clsg", strValueOf);
                                            } else {
                                                zzdxdVarA.b("lat_gmssg", strValueOf);
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            }
                            zzdxdVarA.f28728b.f28730b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdxb
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzdxd zzdxdVar = zzdxdVarA;
                                    zzdxdVar.f28728b.f28729a.a(zzdxdVar.f28727a, true);
                                }
                            });
                        }
                    }
                }, zzcdo.f25988g);
                arrayList.add(listenableFutureZza);
            }
        }
        ListenableFuture listenableFutureA = new zzgyl(zzgtd.r(arrayList), true).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzezz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object obj2;
                Bundle bundle3;
                Iterator it = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    obj2 = obj;
                    if (!zHasNext) {
                        break;
                    }
                    zzezv zzezvVar = (zzezv) ((ListenableFuture) it.next()).get();
                    if (zzezvVar != null) {
                        zzezvVar.zza(obj2);
                        if (z) {
                            zzezvVar.zzb(obj2);
                        }
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z2)).booleanValue() && (bundle3 = bundle) != null) {
                    long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
                    boolean z2 = obj2 instanceof zzczm;
                    Bundle bundle4 = bundle2;
                    if (z2) {
                        bundle3.putLong("client-signals-end", jCurrentTimeMillis2);
                        bundle3.putBundle("client_sig_latency_key", bundle4);
                        return obj2;
                    }
                    bundle3.putLong("gms-signals-end", jCurrentTimeMillis2);
                    bundle3.putBundle("gms_sig_latency_key", bundle4);
                }
                return obj2;
            }
        }, this.f30716c);
        if (zzfnr.a()) {
            zzfnn.c(listenableFutureA, this.f30717d, zzfneVarF, false);
        }
        return listenableFutureA;
    }
}
