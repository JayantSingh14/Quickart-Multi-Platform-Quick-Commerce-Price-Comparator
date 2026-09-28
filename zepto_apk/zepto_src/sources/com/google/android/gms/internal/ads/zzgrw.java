package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class zzgrw<K, V> implements zzgul<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public transient Set f33130a;

    /* renamed from: b, reason: collision with root package name */
    public transient Collection f33131b;

    /* renamed from: c, reason: collision with root package name */
    public transient Map f33132c;

    public abstract Map a();

    public boolean b(Object obj) {
        Iterator<V> it = c().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgul
    public Map c() {
        Map map = this.f33132c;
        if (map != null) {
            return map;
        }
        Map mapA = a();
        this.f33132c = mapA;
        return mapA;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgul) {
            return c().equals(((zzgul) obj).c());
        }
        return false;
    }

    public final int hashCode() {
        return c().hashCode();
    }

    public final String toString() {
        return c().toString();
    }
}
