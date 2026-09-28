package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzd extends zzf {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f38818b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayMap f38819c;

    /* renamed from: d, reason: collision with root package name */
    public long f38820d;

    public zzd(zzib zzibVar) {
        super(zzibVar);
        this.f38819c = new ArrayMap();
        this.f38818b = new ArrayMap();
    }

    public final void h(long j2, String str) {
        zzib zzibVar = this.f39180a;
        if (str == null || str.length() == 0) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Ad unit id must be a non-empty string");
        } else {
            zzhy zzhyVar = zzibVar.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.p(new zza(this, str, j2));
        }
    }

    public final void i(long j2, String str) {
        zzib zzibVar = this.f39180a;
        if (str == null || str.length() == 0) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Ad unit id must be a non-empty string");
        } else {
            zzhy zzhyVar = zzibVar.f39090g;
            zzib.l(zzhyVar);
            zzhyVar.p(new zzb(this, str, j2));
        }
    }

    public final void j(long j2) {
        zzma zzmaVar = this.f39180a.f39095l;
        zzib.k(zzmaVar);
        zzlt zzltVarM = zzmaVar.m(false);
        ArrayMap arrayMap = this.f38818b;
        for (String str : arrayMap.keySet()) {
            l(str, j2 - ((Long) arrayMap.get(str)).longValue(), zzltVarM);
        }
        if (!arrayMap.isEmpty()) {
            k(j2 - this.f38820d, zzltVarM);
        }
        m(j2);
    }

    public final void k(long j2, zzlt zzltVar) {
        zzib zzibVar = this.f39180a;
        if (zzltVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.a("Not logging ad exposure. No active activity");
        } else {
            if (j2 < 1000) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.n.b(Long.valueOf(j2), "Not logging ad exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j2);
            zzpo.W(zzltVar, bundle, true);
            zzli zzliVar = zzibVar.f39096m;
            zzib.k(zzliVar);
            zzliVar.o("am", "_xa", bundle);
        }
    }

    public final void l(String str, long j2, zzlt zzltVar) {
        zzib zzibVar = this.f39180a;
        if (zzltVar == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.a("Not logging ad unit exposure. No active activity");
        } else {
            if (j2 < 1000) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.n.b(Long.valueOf(j2), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j2);
            zzpo.W(zzltVar, bundle, true);
            zzli zzliVar = zzibVar.f39096m;
            zzib.k(zzliVar);
            zzliVar.o("am", "_xu", bundle);
        }
    }

    public final void m(long j2) {
        ArrayMap arrayMap = this.f38818b;
        Iterator it = arrayMap.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put((String) it.next(), Long.valueOf(j2));
        }
        if (arrayMap.isEmpty()) {
            return;
        }
        this.f38820d = j2;
    }
}
