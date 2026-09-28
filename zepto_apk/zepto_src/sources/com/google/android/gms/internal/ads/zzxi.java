package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzxi {

    /* renamed from: a, reason: collision with root package name */
    public final int f35825a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f35826b;

    public zzxi(int i2, boolean z) {
        this.f35825a = i2;
        this.f35826b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzxi.class != obj.getClass()) {
            return false;
        }
        zzxi zzxiVar = (zzxi) obj;
        return this.f35825a == zzxiVar.f35825a && this.f35826b == zzxiVar.f35826b;
    }

    public final int hashCode() {
        return (this.f35825a * 31) + (this.f35826b ? 1 : 0);
    }
}
