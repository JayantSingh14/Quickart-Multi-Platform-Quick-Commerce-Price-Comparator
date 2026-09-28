package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes4.dex */
abstract class zzguj extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    public transient Set f33225a;

    /* renamed from: b, reason: collision with root package name */
    public transient Set f33226b;

    /* renamed from: c, reason: collision with root package name */
    public transient Collection f33227c;

    public abstract Set a();

    public Set b() {
        return new zzguh(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f33225a;
        if (set != null) {
            return set;
        }
        Set setA = a();
        this.f33225a = setA;
        return setA;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f33226b;
        if (set != null) {
            return set;
        }
        Set setB = b();
        this.f33226b = setB;
        return setB;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f33227c;
        if (collection != null) {
            return collection;
        }
        zzgui zzguiVar = new zzgui(this);
        this.f33227c = zzguiVar;
        return zzguiVar;
    }
}
