package com.google.android.gms.internal.pal;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzbk extends zzbi {

    /* renamed from: a, reason: collision with root package name */
    public String f37542a;

    /* renamed from: b, reason: collision with root package name */
    public final long f37543b;

    /* renamed from: c, reason: collision with root package name */
    public final String f37544c;

    /* renamed from: d, reason: collision with root package name */
    public final String f37545d;

    /* renamed from: e, reason: collision with root package name */
    public final String f37546e;

    public zzbk() {
        this.f37542a = "E";
        this.f37543b = -1L;
        this.f37544c = "E";
        this.f37545d = "E";
        this.f37546e = "E";
    }

    @Override // com.google.android.gms.internal.pal.zzbi
    public final HashMap b() {
        HashMap map = new HashMap();
        map.put(0, this.f37542a);
        map.put(4, this.f37546e);
        map.put(3, this.f37545d);
        map.put(2, this.f37544c);
        map.put(1, Long.valueOf(this.f37543b));
        return map;
    }

    public zzbk(String str) {
        this.f37542a = "E";
        this.f37543b = -1L;
        this.f37544c = "E";
        this.f37545d = "E";
        this.f37546e = "E";
        HashMap mapA = zzbi.a(str);
        if (mapA != null) {
            this.f37542a = mapA.get(0) == null ? "E" : (String) mapA.get(0);
            this.f37543b = mapA.get(1) != null ? ((Long) mapA.get(1)).longValue() : -1L;
            this.f37544c = mapA.get(2) == null ? "E" : (String) mapA.get(2);
            this.f37545d = mapA.get(3) == null ? "E" : (String) mapA.get(3);
            this.f37546e = mapA.get(4) != null ? (String) mapA.get(4) : "E";
        }
    }
}
