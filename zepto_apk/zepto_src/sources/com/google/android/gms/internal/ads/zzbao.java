package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzbao extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f24642h;

    /* renamed from: i, reason: collision with root package name */
    public final View f24643i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f24644j;

    public zzbao(zzazt zzaztVar, zzavs zzavsVar, int i2, HashMap map, View view, Context context) {
        super(zzaztVar, "ykIQv59ak7YBU+e791IU15tGonhZPUUBXST76bDGm7zXSjUSNn9qtHdf61t20THy", "l48tDWlMY/G/BSkitRUvd80RiFbNrk8nR5qlkOsZWs8=", zzavsVar, i2, 85);
        this.f24642h = map;
        this.f24643i = view;
        this.f24644j = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        HashMap map = this.f24642h;
        long jLongValue = map.containsKey(1) ? ((Long) map.get(1)).longValue() : Long.MIN_VALUE;
        HashMap map2 = this.f24642h;
        long[] jArr = {jLongValue, map2.containsKey(2) ? ((Long) map2.get(2)).longValue() : Long.MIN_VALUE};
        Context context = this.f24644j;
        if (context == null) {
            context = this.f24669a.f24558a;
        }
        long[] jArr2 = (long[]) this.f24673e.invoke(null, jArr, context, this.f24643i);
        long j2 = jArr2[0];
        HashMap map3 = this.f24642h;
        map3.put(1, Long.valueOf(jArr2[1]));
        long j3 = jArr2[2];
        map3.put(2, Long.valueOf(jArr2[3]));
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).l0(j2);
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).m0(j3);
        }
    }
}
