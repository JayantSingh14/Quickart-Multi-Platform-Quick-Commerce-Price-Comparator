package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzhxz implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public zzhxz f34483a;

    /* renamed from: b, reason: collision with root package name */
    public zzhxz f34484b;

    /* renamed from: c, reason: collision with root package name */
    public zzhxz f34485c;

    /* renamed from: d, reason: collision with root package name */
    public zzhxz f34486d;

    /* renamed from: e, reason: collision with root package name */
    public zzhxz f34487e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f34488f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f34489g;

    /* renamed from: h, reason: collision with root package name */
    public Object f34490h;

    /* renamed from: i, reason: collision with root package name */
    public int f34491i;

    public zzhxz(boolean z) {
        this.f34488f = null;
        this.f34489g = z;
        this.f34487e = this;
        this.f34486d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f34488f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f34490h;
                if (obj3 == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (obj3.equals(entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f34488f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f34490h;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f34488f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f34490h;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj == null && !this.f34489g) {
            throw new NullPointerException("value == null");
        }
        Object obj2 = this.f34490h;
        this.f34490h = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f34488f);
        String strValueOf2 = String.valueOf(this.f34490h);
        return android.support.v4.media.b.s(new StringBuilder(strValueOf.length() + 1 + strValueOf2.length()), strValueOf, "=", strValueOf2);
    }

    public zzhxz(boolean z, zzhxz zzhxzVar, Object obj, zzhxz zzhxzVar2, zzhxz zzhxzVar3) {
        this.f34483a = zzhxzVar;
        this.f34488f = obj;
        this.f34489g = z;
        this.f34491i = 1;
        this.f34486d = zzhxzVar2;
        this.f34487e = zzhxzVar3;
        zzhxzVar3.f34486d = this;
        zzhxzVar2.f34487e = this;
    }
}
