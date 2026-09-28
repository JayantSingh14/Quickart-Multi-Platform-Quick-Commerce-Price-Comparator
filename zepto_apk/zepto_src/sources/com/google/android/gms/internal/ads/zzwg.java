package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzwg {

    /* renamed from: a, reason: collision with root package name */
    public final Object f35758a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35759b;

    /* renamed from: c, reason: collision with root package name */
    public final int f35760c;

    /* renamed from: d, reason: collision with root package name */
    public final long f35761d;

    /* renamed from: e, reason: collision with root package name */
    public final int f35762e;

    public zzwg(Object obj, int i2, int i3, long j2, int i4) {
        this.f35758a = obj;
        this.f35759b = i2;
        this.f35760c = i3;
        this.f35761d = j2;
        this.f35762e = i4;
    }

    public final zzwg a(Object obj) {
        return this.f35758a.equals(obj) ? this : new zzwg(obj, this.f35759b, this.f35760c, this.f35761d, this.f35762e);
    }

    public final boolean b() {
        return this.f35759b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzwg)) {
            return false;
        }
        zzwg zzwgVar = (zzwg) obj;
        return this.f35758a.equals(zzwgVar.f35758a) && this.f35759b == zzwgVar.f35759b && this.f35760c == zzwgVar.f35760c && this.f35761d == zzwgVar.f35761d && this.f35762e == zzwgVar.f35762e;
    }

    public final int hashCode() {
        return ((((((((this.f35758a.hashCode() + 527) * 31) + this.f35759b) * 31) + this.f35760c) * 31) + ((int) this.f35761d)) * 31) + this.f35762e;
    }

    public zzwg(long j2, Object obj) {
        this(obj, -1, -1, j2, -1);
    }

    public zzwg(Object obj, int i2, long j2) {
        this(obj, -1, -1, j2, i2);
    }
}
