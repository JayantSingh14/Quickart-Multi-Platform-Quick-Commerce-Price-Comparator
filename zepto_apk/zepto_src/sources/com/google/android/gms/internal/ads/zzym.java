package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzym {

    /* renamed from: a, reason: collision with root package name */
    public final long f35910a;

    /* renamed from: b, reason: collision with root package name */
    public final long f35911b;

    public zzym(long j2, long j3) {
        this.f35910a = j2;
        this.f35911b = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzym)) {
            return false;
        }
        zzym zzymVar = (zzym) obj;
        return this.f35910a == zzymVar.f35910a && this.f35911b == zzymVar.f35911b;
    }

    public final int hashCode() {
        return (((int) this.f35910a) * 31) + ((int) this.f35911b);
    }
}
