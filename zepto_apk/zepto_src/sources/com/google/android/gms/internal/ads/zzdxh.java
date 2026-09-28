package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzdxh implements zzfmv {

    /* renamed from: b, reason: collision with root package name */
    public final zzdwy f28736b;

    /* renamed from: c, reason: collision with root package name */
    public final Clock f28737c;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f28735a = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f28738d = new HashMap();

    public zzdxh(zzdwy zzdwyVar, Set set, Clock clock) {
        this.f28736b = zzdwyVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdxg zzdxgVar = (zzdxg) it.next();
            HashMap map = this.f28738d;
            zzdxgVar.getClass();
            map.put(zzfmo.RENDERER, zzdxgVar);
        }
        this.f28737c = clock;
    }

    public final void a(zzfmo zzfmoVar, boolean z) {
        zzdxg zzdxgVar = (zzdxg) this.f28738d.get(zzfmoVar);
        if (zzdxgVar == null) {
            return;
        }
        String str = true != z ? "f." : "s.";
        HashMap map = this.f28735a;
        zzfmo zzfmoVar2 = zzdxgVar.f28734b;
        if (map.containsKey(zzfmoVar2)) {
            long jElapsedRealtime = this.f28737c.elapsedRealtime() - ((Long) map.get(zzfmoVar2)).longValue();
            ConcurrentHashMap concurrentHashMap = this.f28736b.f28712a;
            StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime).length() + 2);
            sb.append(str);
            sb.append(jElapsedRealtime);
            concurrentHashMap.put("label.".concat(zzdxgVar.f28733a), sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void c(zzfmo zzfmoVar, String str) {
        this.f28735a.put(zzfmoVar, Long.valueOf(this.f28737c.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void j(zzfmo zzfmoVar, String str, Throwable th) {
        HashMap map = this.f28735a;
        if (map.containsKey(zzfmoVar)) {
            long jElapsedRealtime = this.f28737c.elapsedRealtime() - ((Long) map.get(zzfmoVar)).longValue();
            this.f28736b.f28712a.put("task.".concat(String.valueOf(str)), "f.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.f28738d.containsKey(zzfmoVar)) {
            a(zzfmoVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void t(zzfmo zzfmoVar, String str) {
        HashMap map = this.f28735a;
        if (map.containsKey(zzfmoVar)) {
            long jElapsedRealtime = this.f28737c.elapsedRealtime() - ((Long) map.get(zzfmoVar)).longValue();
            this.f28736b.f28712a.put("task.".concat(String.valueOf(str)), "s.".concat(String.valueOf(Long.toString(jElapsedRealtime))));
        }
        if (this.f28738d.containsKey(zzfmoVar)) {
            a(zzfmoVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfmv
    public final void m(String str) {
    }
}
