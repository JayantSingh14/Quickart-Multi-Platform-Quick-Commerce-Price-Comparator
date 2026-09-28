package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzoa implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f37173a;

    /* renamed from: b, reason: collision with root package name */
    public Object f37174b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzod f37175c;

    public zzoa(zzod zzodVar, Comparable comparable, Object obj) {
        Objects.requireNonNull(zzodVar);
        this.f37175c = zzodVar;
        this.f37173a = comparable;
        this.f37174b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f37173a.compareTo(((zzoa) obj).f37173a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f37173a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f37174b;
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
        return this.f37173a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f37174b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f37173a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f37174b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f37175c.g();
        Object obj2 = this.f37174b;
        this.f37174b = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f37173a);
        String strValueOf2 = String.valueOf(this.f37174b);
        return b.s(new StringBuilder(strValueOf.length() + 1 + strValueOf2.length()), strValueOf, "=", strValueOf2);
    }
}
