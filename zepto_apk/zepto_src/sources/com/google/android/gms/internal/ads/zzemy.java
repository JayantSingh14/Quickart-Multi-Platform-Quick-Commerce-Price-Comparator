package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzemy implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public final zzfmu f29821a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdam f29822b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfpe f29823c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfpi f29824d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgyw f29825e;

    /* renamed from: f, reason: collision with root package name */
    public final ScheduledExecutorService f29826f;

    /* renamed from: g, reason: collision with root package name */
    public final zzcvn f29827g;

    /* renamed from: h, reason: collision with root package name */
    public final zzemr f29828h;

    /* renamed from: i, reason: collision with root package name */
    public final zzejl f29829i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f29830j;

    /* renamed from: k, reason: collision with root package name */
    public final zzfno f29831k;

    /* renamed from: l, reason: collision with root package name */
    public final zzemb f29832l;

    /* renamed from: m, reason: collision with root package name */
    public final zzdwy f29833m;

    public zzemy(Context context, zzfmu zzfmuVar, zzemr zzemrVar, zzdam zzdamVar, zzfpe zzfpeVar, zzfpi zzfpiVar, zzcvn zzcvnVar, zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService, zzejl zzejlVar, zzfno zzfnoVar, zzemb zzembVar, zzdwy zzdwyVar) {
        this.f29830j = context;
        this.f29821a = zzfmuVar;
        this.f29828h = zzemrVar;
        this.f29822b = zzdamVar;
        this.f29823c = zzfpeVar;
        this.f29824d = zzfpiVar;
        this.f29827g = zzcvnVar;
        this.f29825e = zzgywVar;
        this.f29826f = scheduledExecutorService;
        this.f29829i = zzejlVar;
        this.f29831k = zzfnoVar;
        this.f29832l = zzembVar;
        this.f29833m = zzdwyVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(com.google.android.gms.internal.ads.zzfic r6) {
        /*
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.m6
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r2 = r1.f21153c
            java.lang.Object r0 = r2.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r2 = "No fill."
            r3 = 1
            if (r3 == r0) goto L18
            java.lang.String r0 = "No ad config."
            goto L19
        L18:
            r0 = r2
        L19:
            com.google.android.gms.internal.ads.zzfib r6 = r6.f31194b
            com.google.android.gms.internal.ads.zzfhu r6 = r6.f31190b
            int r3 = r6.f31171f
            if (r3 == 0) goto L59
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 300(0x12c, float:4.2E-43)
            if (r3 < r4) goto L3a
            if (r3 >= r5) goto L3a
            com.google.android.gms.internal.ads.zzbgb r3 = com.google.android.gms.internal.ads.zzbgk.l6
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c
            java.lang.Object r1 = r1.a(r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L59
            goto L5a
        L3a:
            if (r3 < r5) goto L43
            r0 = 400(0x190, float:5.6E-43)
            if (r3 >= r0) goto L43
            java.lang.String r2 = "No location header to follow redirect or too many redirects."
            goto L5a
        L43:
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r0 = r0.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 35
            r1.<init>(r0)
            java.lang.String r0 = "Received error HTTP response code: "
            java.lang.String r2 = androidx.fragment.app.e.r(r1, r3, r0)
            goto L5a
        L59:
            r2 = r0
        L5a:
            com.google.android.gms.internal.ads.zzfht r6 = r6.f31175j
            if (r6 == 0) goto L61
            java.lang.String r6 = r6.f31165a
            return r6
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemy.a(com.google.android.gms.internal.ads.zzfic):java.lang.String");
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        ListenableFuture listenableFutureD;
        int i2;
        Bundle bundle;
        final zzfic zzficVar = (zzfic) obj;
        zzbgb zzbgbVar = zzbgk.z2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && (bundle = zzficVar.f31194b.f31192d) != null) {
            this.f29833m.f28716e.putAll(bundle);
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.A2)).booleanValue()) {
            this.f29833m.f28716e.putLong("rendering-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        String strA = a(zzficVar);
        zzejl zzejlVar = this.f29829i;
        zzfib zzfibVar = zzficVar.f31194b;
        zzfhu zzfhuVar = zzfibVar.f31190b;
        zzejlVar.f29469d = zzfhuVar;
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.o9)).booleanValue() && (i2 = zzfhuVar.f31171f) != 0 && (i2 < 200 || i2 >= 300)) {
            return zzgym.b(new zzemv(3, strA));
        }
        String str = zzfhuVar.q;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgk.k4)).booleanValue() || TextUtils.isEmpty(str)) {
            for (zzfhr zzfhrVar : zzfibVar.f31189a) {
                zzejlVar.b(zzfhrVar, zzejlVar.f29466a.size());
                Iterator it = zzfhrVar.f31149a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzejlVar.c(zzfhrVar, 0L, zzfjm.d(1, null, null), false);
                        break;
                    }
                    zzejg zzejgVarA = this.f29827g.a(zzfhrVar.f31150b, (String) it.next());
                    if (zzejgVarA == null || !zzejgVarA.b(zzficVar, zzfhrVar)) {
                    }
                }
            }
        } else {
            List list = zzfibVar.f31189a;
            synchronized (zzejlVar) {
                Map map = zzejlVar.f29467b;
                if (map.containsKey(str)) {
                    com.google.android.gms.ads.internal.client.zzv zzvVar = (com.google.android.gms.ads.internal.client.zzv) map.get(str);
                    List list2 = zzejlVar.f29466a;
                    int iIndexOf = list2.indexOf(zzvVar);
                    try {
                        list2.remove(iIndexOf);
                    } catch (IndexOutOfBoundsException e2) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdapterResponseInfoCollector.replaceAdapterResponseInfoEntry", e2);
                    }
                    zzejlVar.f29467b.remove(str);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzejlVar.b((zzfhr) it2.next(), iIndexOf);
                        iIndexOf++;
                    }
                }
            }
        }
        zzdam zzdamVar = this.f29822b;
        zzcre zzcreVar = new zzcre(zzficVar, this.f29824d, this.f29823c);
        zzgyw zzgywVar = this.f29825e;
        zzdamVar.t0(zzcreVar, zzgywVar);
        if (zzfhuVar.r > 1) {
            zzemb zzembVar = this.f29832l;
            synchronized (zzembVar) {
                try {
                    if (!zzembVar.f29704g.getAndSet(true)) {
                        List list3 = zzficVar.f31194b.f31189a;
                        if (list3.isEmpty()) {
                            zzembVar.f29703f.d(new zzemv(3, a(zzficVar)));
                        } else {
                            zzembVar.f29706i = zzficVar;
                            zzemr zzemrVar = zzembVar.f29701d;
                            zzembVar.f29705h = new zzemc(zzficVar, zzemrVar, zzembVar.f29703f);
                            zzemrVar.a(list3);
                            for (zzfhr zzfhrVarA = zzembVar.f29705h.a(); zzfhrVarA != null; zzfhrVarA = zzembVar.f29705h.a()) {
                                zzembVar.a(zzfhrVarA);
                            }
                        }
                    }
                    listenableFutureD = zzembVar.f29703f;
                } finally {
                }
            }
        } else {
            String strA2 = a(zzficVar);
            zzfmu zzfmuVar = this.f29821a;
            zzfmo zzfmoVar = zzfmo.RENDER_CONFIG_INIT;
            Objects.requireNonNull(zzfmuVar);
            listenableFutureD = new zzfml(zzfmuVar, zzfmoVar, null, zzfmm.f31404d, Collections.EMPTY_LIST, zzgym.b(new zzemv(3, strA2))).d();
            final zzemr zzemrVar2 = this.f29828h;
            synchronized (zzemrVar2) {
                zzemrVar2.f29809i = zzemrVar2.f29801a.elapsedRealtime();
            }
            int i3 = 0;
            for (final zzfhr zzfhrVar2 : zzfibVar.f31189a) {
                Iterator it3 = zzfhrVar2.f31149a.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    String str2 = (String) it3.next();
                    final zzejg zzejgVarA2 = this.f29827g.a(zzfhrVar2.f31150b, str2);
                    if (zzejgVarA2 != null && zzejgVarA2.b(zzficVar, zzfhrVar2)) {
                        zzfml zzfmlVarA = zzfmuVar.a(listenableFutureD, zzfmo.RENDER_CONFIG_WATERFALL);
                        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 15 + String.valueOf(str2).length());
                        sb.append("render-config-");
                        sb.append(i3);
                        sb.append("-");
                        sb.append(str2);
                        zzfml zzfmlVar = new zzfml(zzfmlVarA.f31403f, zzfmlVarA.f31398a, sb.toString(), zzfmlVarA.f31400c, zzfmlVarA.f31401d, zzfmlVarA.f31402e);
                        zzgxu zzgxuVar = new zzgxu() { // from class: com.google.android.gms.internal.ads.zzemx
                            @Override // com.google.android.gms.internal.ads.zzgxu
                            public final ListenableFuture zza(Object obj2) {
                                zzemy zzemyVar = this.f29817a;
                                zzfne zzfneVarF = zzfne.f(12, zzemyVar.f29830j);
                                zzfhr zzfhrVar3 = zzfhrVar2;
                                zzfneVarF.zzi(zzfhrVar3.E);
                                zzfneVarF.zza();
                                zzejg zzejgVar = zzejgVarA2;
                                zzfic zzficVar2 = zzficVar;
                                ListenableFuture listenableFutureG = zzgym.g(zzejgVar.a(zzficVar2, zzfhrVar3), zzfhrVar3.R, TimeUnit.MILLISECONDS, zzemyVar.f29826f);
                                zzemyVar.f29828h.b(zzficVar2, zzfhrVar3, listenableFutureG, zzemyVar.f29823c);
                                zzfnn.c(listenableFutureG, zzemyVar.f29831k, zzfneVarF, false);
                                return listenableFutureG;
                            }
                        };
                        zzfmm zzfmmVar = zzfmlVar.f31403f;
                        listenableFutureD = new zzfml(zzfmmVar, zzfmlVar.f31398a, zzfmlVar.f31399b, zzfmlVar.f31400c, zzfmlVar.f31401d, zzgym.f(zzfmlVar.f31402e, Throwable.class, zzgxuVar, zzfmmVar.f31405a)).d();
                        break;
                    }
                }
                i3++;
            }
            listenableFutureD.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzemw
                @Override // java.lang.Runnable
                public final void run() {
                    zzemr zzemrVar3 = zzemrVar2;
                    synchronized (zzemrVar3) {
                        zzemrVar3.f29808h = zzemrVar3.f29801a.elapsedRealtime() - zzemrVar3.f29809i;
                    }
                }
            }, zzgywVar);
        }
        return listenableFutureD;
    }
}
