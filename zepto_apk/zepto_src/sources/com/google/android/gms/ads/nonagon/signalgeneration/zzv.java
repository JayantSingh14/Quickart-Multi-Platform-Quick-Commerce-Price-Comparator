package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzdwy;
import com.google.android.gms.internal.ads.zzdxj;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzv {

    /* renamed from: a, reason: collision with root package name */
    public final int f21943a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21944b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21945c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21946d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f21947e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f21948f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f21949g = new ArrayDeque();

    /* renamed from: h, reason: collision with root package name */
    public final zzdxj f21950h;

    /* renamed from: i, reason: collision with root package name */
    public ConcurrentHashMap f21951i;

    public zzv(zzdxj zzdxjVar) {
        this.f21950h = zzdxjVar;
        zzbgb zzbgbVar = zzbgk.B7;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        this.f21943a = ((Integer) zzbdVar.f21153c.a(zzbgbVar)).intValue();
        zzbgb zzbgbVar2 = zzbgk.C7;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        this.f21944b = ((Long) zzbgiVar.a(zzbgbVar2)).longValue();
        this.f21945c = ((Boolean) zzbgiVar.a(zzbgk.G7)).booleanValue();
        this.f21946d = ((Boolean) zzbgiVar.a(zzbgk.F7)).booleanValue();
        this.f21947e = Collections.synchronizedMap(new zzs(this));
    }

    public final synchronized void a(String str, String str2, zzdwy zzdwyVar) {
        this.f21947e.put(str, new zzt(Long.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis()), str2, new HashSet()));
        c();
        d(zzdwyVar);
    }

    public final synchronized String b(String str, zzdwy zzdwyVar) {
        zzt zztVar = (zzt) this.f21947e.get(str);
        zzdwyVar.f28712a.put("request_id", str);
        if (zztVar == null) {
            zzdwyVar.f28712a.put("mhit", "false");
            return null;
        }
        zzdwyVar.f28712a.put("mhit", "true");
        return zztVar.f21937b;
    }

    public final synchronized void c() {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
        try {
            Iterator it = this.f21947e.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (jCurrentTimeMillis - ((zzt) entry.getValue()).f21936a.longValue() <= this.f21944b) {
                    break;
                }
                this.f21949g.add(new Pair((String) entry.getKey(), ((zzt) entry.getValue()).f21937b));
                it.remove();
            }
        } catch (ConcurrentModificationException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("QueryJsonMap.removeExpiredEntries", e2);
        }
    }

    public final synchronized void d(final zzdwy zzdwyVar) {
        if (this.f21945c) {
            ArrayDeque arrayDeque = this.f21949g;
            final ArrayDeque arrayDequeClone = arrayDeque.clone();
            arrayDeque.clear();
            ArrayDeque arrayDeque2 = this.f21948f;
            final ArrayDeque arrayDequeClone2 = arrayDeque2.clone();
            arrayDeque2.clear();
            zzcdo.f25982a.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzu
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() throws JSONException {
                    zzv zzvVar = this.f21939a;
                    zzdwy zzdwyVar2 = zzdwyVar;
                    zzvVar.e(zzdwyVar2, arrayDequeClone, "to");
                    zzvVar.e(zzdwyVar2, arrayDequeClone2, "of");
                }
            });
        }
    }

    public final void e(zzdwy zzdwyVar, ArrayDeque arrayDeque, String str) throws JSONException {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdwyVar.f28712a);
            this.f21951i = concurrentHashMap;
            concurrentHashMap.put("action", "ev");
            this.f21951i.put("e_r", str);
            this.f21951i.put("e_id", (String) pair2.first);
            if (this.f21946d) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzaa.a(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                ConcurrentHashMap concurrentHashMap2 = this.f21951i;
                String str2 = (String) pair.first;
                if (!TextUtils.isEmpty(str2)) {
                    concurrentHashMap2.put("e_type", str2);
                }
                ConcurrentHashMap concurrentHashMap3 = this.f21951i;
                String str3 = (String) pair.second;
                if (!TextUtils.isEmpty(str3)) {
                    concurrentHashMap3.put("e_agent", str3);
                }
            }
            this.f21950h.a(this.f21951i, false);
        }
    }
}
