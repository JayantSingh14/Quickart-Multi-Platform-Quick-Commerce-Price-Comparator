package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzff implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f36186a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36187b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfl f36188c;

    public zzff(zzfl zzflVar, Comparable comparable, Object obj) {
        this.f36188c = zzflVar;
        this.f36186a = comparable;
        this.f36187b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f36186a.compareTo(((zzff) obj).f36186a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f36186a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f36187b;
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
        return this.f36186a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f36187b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f36186a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f36187b;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        int i2 = zzfl.f36194g;
        this.f36188c.f();
        Object obj2 = this.f36187b;
        this.f36187b = obj;
        return obj2;
    }

    public final String toString() {
        return b.l(String.valueOf(this.f36186a), "=", String.valueOf(this.f36187b));
    }
}
