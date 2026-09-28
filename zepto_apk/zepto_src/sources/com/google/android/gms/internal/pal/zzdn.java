package com.google.android.gms.internal.pal;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzdn extends zzbi {

    /* renamed from: a, reason: collision with root package name */
    public final Long f37622a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f37623b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f37624c;

    public zzdn() {
    }

    @Override // com.google.android.gms.internal.pal.zzbi
    public final HashMap b() {
        HashMap map = new HashMap();
        map.put(0, this.f37622a);
        map.put(1, this.f37623b);
        map.put(2, this.f37624c);
        return map;
    }

    public zzdn(String str) {
        HashMap mapA = zzbi.a(str);
        if (mapA != null) {
            this.f37622a = (Long) mapA.get(0);
            this.f37623b = (Boolean) mapA.get(1);
            this.f37624c = (Boolean) mapA.get(2);
        }
    }
}
