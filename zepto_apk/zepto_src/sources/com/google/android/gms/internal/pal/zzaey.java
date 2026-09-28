package com.google.android.gms.internal.pal;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzaey implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f37473a;

    /* renamed from: b, reason: collision with root package name */
    public Object f37474b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzafe f37475c;

    public zzaey(zzafe zzafeVar, Comparable comparable, Object obj) {
        this.f37475c = zzafeVar;
        this.f37473a = comparable;
        this.f37474b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f37473a.compareTo(((zzaey) obj).f37473a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f37473a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f37474b;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f37473a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f37474b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f37473a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f37474b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        int i2 = zzafe.f37481g;
        this.f37475c.f();
        Object obj2 = this.f37474b;
        this.f37474b = obj;
        return obj2;
    }

    public final String toString() {
        return android.support.v4.media.b.l(String.valueOf(this.f37473a), "=", String.valueOf(this.f37474b));
    }
}
