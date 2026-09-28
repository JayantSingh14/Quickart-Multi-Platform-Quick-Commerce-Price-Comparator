package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzea {

    /* renamed from: a, reason: collision with root package name */
    public final Object f28903a;

    /* renamed from: b, reason: collision with root package name */
    public zzr f28904b = new zzr();

    /* renamed from: c, reason: collision with root package name */
    public boolean f28905c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f28906d;

    public zzea(Object obj) {
        this.f28903a = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzea.class != obj.getClass()) {
            return false;
        }
        return this.f28903a.equals(((zzea) obj).f28903a);
    }

    public final int hashCode() {
        return this.f28903a.hashCode();
    }
}
