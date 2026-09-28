package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzaxk extends zzaxi {

    /* renamed from: a, reason: collision with root package name */
    public String f24431a;

    /* renamed from: b, reason: collision with root package name */
    public final long f24432b;

    /* renamed from: c, reason: collision with root package name */
    public final String f24433c;

    /* renamed from: d, reason: collision with root package name */
    public final String f24434d;

    /* renamed from: e, reason: collision with root package name */
    public final String f24435e;

    public zzaxk() {
        this.f24431a = "E";
        this.f24432b = -1L;
        this.f24433c = "E";
        this.f24434d = "E";
        this.f24435e = "E";
    }

    @Override // com.google.android.gms.internal.ads.zzaxi
    public final HashMap a() {
        HashMap map = new HashMap();
        map.put(0, this.f24431a);
        map.put(4, this.f24435e);
        map.put(3, this.f24434d);
        map.put(2, this.f24433c);
        map.put(1, Long.valueOf(this.f24432b));
        return map;
    }

    public zzaxk(String str) {
        this.f24431a = "E";
        this.f24432b = -1L;
        this.f24433c = "E";
        this.f24434d = "E";
        this.f24435e = "E";
        HashMap mapB = zzaxi.b(str);
        if (mapB != null) {
            this.f24431a = mapB.get(0) == null ? "E" : (String) mapB.get(0);
            this.f24432b = mapB.get(1) != null ? ((Long) mapB.get(1)).longValue() : -1L;
            this.f24433c = mapB.get(2) == null ? "E" : (String) mapB.get(2);
            this.f24434d = mapB.get(3) == null ? "E" : (String) mapB.get(3);
            this.f24435e = mapB.get(4) != null ? (String) mapB.get(4) : "E";
        }
    }
}
