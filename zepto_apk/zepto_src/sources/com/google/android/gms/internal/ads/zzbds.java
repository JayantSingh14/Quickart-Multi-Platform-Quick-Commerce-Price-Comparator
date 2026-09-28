package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbds {

    /* renamed from: a, reason: collision with root package name */
    public final long f24809a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24810b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24811c;

    public zzbds(int i2, long j2, String str) {
        this.f24809a = j2;
        this.f24810b = str;
        this.f24811c = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbds)) {
            return false;
        }
        zzbds zzbdsVar = (zzbds) obj;
        return zzbdsVar.f24809a == this.f24809a && zzbdsVar.f24811c == this.f24811c;
    }

    public final int hashCode() {
        return (int) this.f24809a;
    }
}
