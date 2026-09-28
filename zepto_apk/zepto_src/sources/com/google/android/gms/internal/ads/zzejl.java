package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzejl {

    /* renamed from: c, reason: collision with root package name */
    public final String f29468c;

    /* renamed from: d, reason: collision with root package name */
    public zzfhu f29469d = null;

    /* renamed from: e, reason: collision with root package name */
    public zzfhr f29470e = null;

    /* renamed from: f, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzv f29471f = null;

    /* renamed from: b, reason: collision with root package name */
    public final Map f29467b = Collections.synchronizedMap(new HashMap());

    /* renamed from: a, reason: collision with root package name */
    public final List f29466a = Collections.synchronizedList(new ArrayList());

    public zzejl(String str) {
        this.f29468c = str;
    }

    public static String d(zzfhr zzfhrVar) {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.k4)).booleanValue() ? zzfhrVar.p0 : zzfhrVar.w;
    }

    public final void a(zzfhr zzfhrVar) {
        String strD = d(zzfhrVar);
        Map map = this.f29467b;
        Object obj = map.get(strD);
        List list = this.f29466a;
        int iIndexOf = list.indexOf(obj);
        if (iIndexOf < 0 || iIndexOf >= map.size()) {
            iIndexOf = list.indexOf(this.f29471f);
        }
        if (iIndexOf < 0 || iIndexOf >= map.size()) {
            return;
        }
        this.f29471f = (com.google.android.gms.ads.internal.client.zzv) list.get(iIndexOf);
        while (true) {
            iIndexOf++;
            if (iIndexOf >= list.size()) {
                return;
            }
            com.google.android.gms.ads.internal.client.zzv zzvVar = (com.google.android.gms.ads.internal.client.zzv) list.get(iIndexOf);
            zzvVar.f21299b = 0L;
            zzvVar.f21300c = null;
        }
    }

    public final synchronized void b(zzfhr zzfhrVar, int i2) {
        Map map = this.f29467b;
        String strD = d(zzfhrVar);
        if (map.containsKey(strD)) {
            return;
        }
        Bundle bundle = new Bundle();
        JSONObject jSONObject = zzfhrVar.v;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                bundle.putString(next, jSONObject.getString(next));
            } catch (JSONException unused) {
            }
        }
        com.google.android.gms.ads.internal.client.zzv zzvVar = new com.google.android.gms.ads.internal.client.zzv(zzfhrVar.E, 0L, null, bundle, zzfhrVar.F, zzfhrVar.G, zzfhrVar.H, zzfhrVar.I);
        try {
            this.f29466a.add(i2, zzvVar);
        } catch (IndexOutOfBoundsException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdapterResponseInfoCollector.addAdapterResponseInfoEntryAtLocation", e2);
        }
        this.f29467b.put(strD, zzvVar);
    }

    public final void c(zzfhr zzfhrVar, long j2, com.google.android.gms.ads.internal.client.zze zzeVar, boolean z) {
        String strD = d(zzfhrVar);
        Map map = this.f29467b;
        if (map.containsKey(strD)) {
            if (this.f29470e == null) {
                this.f29470e = zzfhrVar;
            }
            com.google.android.gms.ads.internal.client.zzv zzvVar = (com.google.android.gms.ads.internal.client.zzv) map.get(strD);
            zzvVar.f21299b = j2;
            zzvVar.f21300c = zzeVar;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.t7)).booleanValue() && z) {
                this.f29471f = zzvVar;
            }
        }
    }
}
