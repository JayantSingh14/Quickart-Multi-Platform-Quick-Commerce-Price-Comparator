package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzmq {

    /* renamed from: c, reason: collision with root package name */
    public static final zzmq f35221c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzmq f35222d;

    /* renamed from: a, reason: collision with root package name */
    public final long f35223a;

    /* renamed from: b, reason: collision with root package name */
    public final long f35224b;

    static {
        zzmq zzmqVar = new zzmq(0L, 0L);
        new zzmq(Long.MAX_VALUE, Long.MAX_VALUE);
        f35221c = new zzmq(Long.MAX_VALUE, 0L);
        new zzmq(0L, Long.MAX_VALUE);
        f35222d = zzmqVar;
    }

    public zzmq(long j2, long j3) {
        zzgqa.a(j2 >= 0);
        zzgqa.a(j3 >= 0);
        this.f35223a = j2;
        this.f35224b = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmq.class == obj.getClass()) {
            zzmq zzmqVar = (zzmq) obj;
            if (this.f35223a == zzmqVar.f35223a && this.f35224b == zzmqVar.f35224b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f35223a) * 31) + ((int) this.f35224b);
    }
}
