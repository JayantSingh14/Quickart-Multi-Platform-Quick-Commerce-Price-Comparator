package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzicy implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f34744a;

    /* renamed from: b, reason: collision with root package name */
    public Object f34745b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzidb f34746c;

    public zzicy(zzidb zzidbVar, Comparable comparable, Object obj) {
        Objects.requireNonNull(zzidbVar);
        this.f34746c = zzidbVar;
        this.f34744a = comparable;
        this.f34745b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f34744a.compareTo(((zzicy) obj).f34744a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f34744a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f34745b;
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
        return this.f34744a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f34745b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f34744a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f34745b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f34746c.g();
        Object obj2 = this.f34745b;
        this.f34745b = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f34744a);
        String strValueOf2 = String.valueOf(this.f34745b);
        return android.support.v4.media.b.s(new StringBuilder(strValueOf.length() + 1 + strValueOf2.length()), strValueOf, "=", strValueOf2);
    }
}
