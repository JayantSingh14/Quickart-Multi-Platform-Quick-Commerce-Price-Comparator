package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class zzgrt extends zzgrw implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public final transient Map f33127d;

    /* renamed from: e, reason: collision with root package name */
    public transient int f33128e;

    public zzgrt(Map map) {
        zzgqa.a(map.isEmpty());
        this.f33127d = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgrw
    public Map a() {
        throw null;
    }

    public final void d() {
        Map map = this.f33127d;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.f33128e = 0;
    }
}
