package com.google.android.gms.internal.pal;

import java.util.Map;

/* loaded from: classes4.dex */
final class zzzq implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public zzzq f38176a;

    /* renamed from: b, reason: collision with root package name */
    public zzzq f38177b;

    /* renamed from: c, reason: collision with root package name */
    public zzzq f38178c;

    /* renamed from: d, reason: collision with root package name */
    public zzzq f38179d;

    /* renamed from: e, reason: collision with root package name */
    public zzzq f38180e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f38181f;

    /* renamed from: g, reason: collision with root package name */
    public Object f38182g;

    /* renamed from: h, reason: collision with root package name */
    public int f38183h;

    public zzzq() {
        this.f38181f = null;
        this.f38180e = this;
        this.f38179d = this;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f38181f;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.f38182g;
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
        return this.f38181f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f38182g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object obj = this.f38181f;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f38182g;
        return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f38182g;
        this.f38182g = obj;
        return obj2;
    }

    public final String toString() {
        return this.f38181f + "=" + this.f38182g;
    }

    public zzzq(zzzq zzzqVar, Object obj, zzzq zzzqVar2, zzzq zzzqVar3) {
        this.f38176a = zzzqVar;
        this.f38181f = obj;
        this.f38183h = 1;
        this.f38179d = zzzqVar2;
        this.f38180e = zzzqVar3;
        zzzqVar3.f38179d = this;
        zzzqVar2.f38180e = this;
    }
}
