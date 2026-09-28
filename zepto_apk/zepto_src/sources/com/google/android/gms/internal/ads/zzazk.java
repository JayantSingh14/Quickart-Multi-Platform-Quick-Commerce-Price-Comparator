package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzazk extends zzaxi {

    /* renamed from: a, reason: collision with root package name */
    public final Long f24537a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f24538b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f24539c;

    public zzazk() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxi
    public final HashMap a() {
        HashMap map = new HashMap();
        map.put(0, this.f24537a);
        map.put(1, this.f24538b);
        map.put(2, this.f24539c);
        return map;
    }

    public zzazk(String str) {
        HashMap mapB = zzaxi.b(str);
        if (mapB != null) {
            this.f24537a = (Long) mapB.get(0);
            this.f24538b = (Boolean) mapB.get(1);
            this.f24539c = (Boolean) mapB.get(2);
        }
    }
}
