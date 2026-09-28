package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzezd implements zzezx {

    /* renamed from: k, reason: collision with root package name */
    public static final zzeze f30637k = new zzeze(new JSONArray().toString(), "", new Bundle());

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30638a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f30639b;

    /* renamed from: c, reason: collision with root package name */
    public final zzepk f30640c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f30641d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfik f30642e;

    /* renamed from: f, reason: collision with root package name */
    public final zzepf f30643f;

    /* renamed from: g, reason: collision with root package name */
    public final zzduu f30644g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdzr f30645h;

    /* renamed from: i, reason: collision with root package name */
    public final int f30646i;

    /* renamed from: j, reason: collision with root package name */
    public final String f30647j;

    public zzezd(zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService, String str, zzepk zzepkVar, Context context, zzfik zzfikVar, zzepf zzepfVar, zzduu zzduuVar, zzdzr zzdzrVar, int i2) {
        this.f30638a = zzgywVar;
        this.f30639b = scheduledExecutorService;
        this.f30647j = str;
        this.f30640c = zzepkVar;
        this.f30641d = context;
        this.f30642e = zzfikVar;
        this.f30643f = zzepfVar;
        this.f30644g = zzduuVar;
        this.f30645h = zzdzrVar;
        this.f30646i = i2;
    }

    public final void a(ArrayList arrayList, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzepo zzepoVar = (zzepo) ((Map.Entry) it.next()).getValue();
            String str = zzepoVar.f30046a;
            Bundle bundle = this.f30642e.f31216d.f21266m;
            arrayList.add(b(str, Collections.singletonList(zzepoVar.f30050e), bundle != null ? bundle.getBundle(str) : null, zzepoVar.f30047b, zzepoVar.f30048c));
        }
    }

    public final zzgye b(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzgxt zzgxtVar = new zzgxt() { // from class: com.google.android.gms.internal.ads.zzeyy
            /* JADX WARN: Removed duplicated region for block: B:69:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // com.google.android.gms.internal.ads.zzgxt
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final com.google.common.util.concurrent.ListenableFuture zza() {
                /*
                    Method dump skipped, instructions count: 348
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyy.zza():com.google.common.util.concurrent.ListenableFuture");
            }
        };
        zzgyw zzgywVar = this.f30638a;
        zzgye zzgyeVarS = zzgye.s(zzgym.d(zzgxtVar, zzgywVar));
        zzbgb zzbgbVar = zzbgk.U1;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzgyeVarS = (zzgye) zzgym.g(zzgyeVarS, ((Long) zzbdVar.f21153c.a(zzbgk.N1)).longValue(), TimeUnit.MILLISECONDS, this.f30639b);
        }
        return (zzgye) zzgym.e(zzgyeVarS, Throwable.class, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzeyz
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzeze zzezeVar = zzezd.f30637k;
                int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                String str2 = str;
                com.google.android.gms.ads.internal.util.client.zzo.c("Error calling adapter: ".concat(String.valueOf(str2)));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.ie)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.C.f21684h.e("rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)), th);
                    return null;
                }
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)), th);
                return null;
            }
        }, zzgywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        int i2 = this.f30646i;
        zzeze zzezeVar = f30637k;
        if (i2 == 2) {
            return zzgym.a(zzezeVar);
        }
        zzfik zzfikVar = this.f30642e;
        if (zzfikVar.s) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.a2)).split(",")).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.a(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.b(zzfikVar.f31216d)))) {
                return zzgym.a(zzezeVar);
            }
        }
        return zzgym.d(new zzgxt() { // from class: com.google.android.gms.internal.ads.zzezb
            @Override // com.google.android.gms.internal.ads.zzgxt
            public final ListenableFuture zza() {
                Bundle bundle;
                String str;
                HashMap map;
                zzgtg zzgtgVarA;
                zzezd zzezdVar = this.f30635a;
                zzezdVar.getClass();
                zzbgb zzbgbVar = zzbgk.ac;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                String lowerCase = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() ? zzezdVar.f30642e.f31219g.toLowerCase(Locale.ROOT) : zzezdVar.f30642e.f31219g;
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.Y1)).booleanValue()) {
                    zzdzr zzdzrVar = zzezdVar.f30645h;
                    synchronized (zzdzrVar) {
                        bundle = new Bundle(zzdzrVar.f28868a);
                    }
                } else {
                    bundle = new Bundle();
                }
                final Bundle bundle2 = bundle;
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.R4)).booleanValue()) {
                    zzccv zzccvVarI = com.google.android.gms.ads.internal.zzt.C.f21684h.g().i();
                    char c2 = (TextUtils.isEmpty(zzccvVarI.f25911e) || zzccvVarI.f25913g == null) ? (char) 3 : zzccvVarI.b() ? (char) 1 : (char) 2;
                    str = c2 != 1 ? c2 != 2 ? "EMPTY" : "INVALID" : "VALID";
                } else {
                    str = "";
                }
                final String str2 = str;
                final ArrayList arrayList = new ArrayList();
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.h2)).booleanValue()) {
                    zzepk zzepkVar = zzezdVar.f30640c;
                    String str3 = zzezdVar.f30647j;
                    synchronized (zzepkVar) {
                        try {
                            zzgtg zzgtgVarA2 = zzepkVar.a(str3, lowerCase);
                            zzgtg zzgtgVarI = zzepkVar.i(lowerCase);
                            map = new HashMap();
                            Iterator it = zzgtgVarA2.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                String str4 = (String) entry.getKey();
                                if (zzgtgVarI.containsKey(str4)) {
                                    zzepo zzepoVar = (zzepo) zzgtgVarI.get(str4);
                                    List list = (List) entry.getValue();
                                    map.put(str4, new zzepo(str4, zzepoVar.f30047b, zzepoVar.f30048c, zzepoVar.f30049d, (list == null || list.isEmpty()) ? new Bundle() : (Bundle) list.get(0)));
                                }
                            }
                            zzgtn zzgtnVarB = zzgtgVarI.f33190a;
                            if (zzgtnVarB == null) {
                                zzgtnVarB = zzgtgVarI.b();
                                zzgtgVarI.f33190a = zzgtnVarB;
                            }
                            zzgvr it2 = zzgtnVarB.iterator();
                            while (it2.hasNext()) {
                                Map.Entry entry2 = (Map.Entry) it2.next();
                                String str5 = (String) entry2.getKey();
                                if (!map.containsKey(str5) && ((zzepo) entry2.getValue()).f30049d) {
                                    map.put(str5, (zzepo) entry2.getValue());
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zzezdVar.a(arrayList, map);
                } else {
                    zzepk zzepkVar2 = zzezdVar.f30640c;
                    Iterator it3 = zzepkVar2.a(zzezdVar.f30647j, lowerCase).entrySet().iterator();
                    while (it3.hasNext()) {
                        Map.Entry entry3 = (Map.Entry) it3.next();
                        String str6 = (String) entry3.getKey();
                        List list2 = (List) entry3.getValue();
                        Bundle bundle3 = zzezdVar.f30642e.f31216d.f21266m;
                        arrayList.add(zzezdVar.b(str6, list2, bundle3 != null ? bundle3.getBundle(str6) : null, true, true));
                    }
                    synchronized (zzepkVar2) {
                        zzgtgVarA = TextUtils.isEmpty(com.google.android.gms.ads.internal.zzt.C.f21684h.g().i().f25911e) ? zzgvd.f33244g : zzgtg.a(zzepkVar2.f30032b);
                    }
                    zzezdVar.a(arrayList, zzgtgVarA);
                }
                return new zzgyl(zzgtd.r(arrayList), true).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyx
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        zzeze zzezeVar2 = zzezd.f30637k;
                        JSONArray jSONArray = new JSONArray();
                        Iterator it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            ListenableFuture listenableFuture = (ListenableFuture) it4.next();
                            if (((JSONObject) listenableFuture.get()) != null) {
                                jSONArray.put(listenableFuture.get());
                            }
                        }
                        int length = jSONArray.length();
                        String str7 = str2;
                        Bundle bundle4 = bundle2;
                        if (length != 0) {
                            return new zzeze(jSONArray.toString(), str7, bundle4);
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R4)).booleanValue()) {
                            return new zzeze(new JSONArray().toString(), str7, bundle4);
                        }
                        return null;
                    }
                }, zzezdVar.f30638a);
            }
        }, this.f30638a);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 32;
    }
}
