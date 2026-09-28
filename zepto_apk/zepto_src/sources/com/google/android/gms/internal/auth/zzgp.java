package com.google.android.gms.internal.auth;

import android.support.v4.media.b;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgp implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f36400a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36401b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzgv f36402c;

    public zzgp(zzgv zzgvVar, Comparable comparable, Object obj) {
        this.f36402c = zzgvVar;
        this.f36400a = comparable;
        this.f36401b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f36400a.compareTo(((zzgp) obj).f36400a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f36400a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f36401b;
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
        return this.f36400a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f36401b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f36400a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f36401b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        int i2 = zzgv.f36408g;
        this.f36402c.f();
        Object obj2 = this.f36401b;
        this.f36401b = obj;
        return obj2;
    }

    public final String toString() {
        return b.l(String.valueOf(this.f36400a), "=", String.valueOf(this.f36401b));
    }
}
