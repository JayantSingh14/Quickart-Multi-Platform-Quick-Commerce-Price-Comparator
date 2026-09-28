package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzdyg extends zzdyk {

    /* renamed from: a, reason: collision with root package name */
    public final long f28789a;

    /* renamed from: b, reason: collision with root package name */
    public final int f28790b;

    public /* synthetic */ zzdyg(long j2, int i2) {
        this.f28789a = j2;
        this.f28790b = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdyk
    public final long a() {
        return this.f28789a;
    }

    @Override // com.google.android.gms.internal.ads.zzdyk
    public final int b() {
        return this.f28790b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdyk)) {
            return false;
        }
        zzdyk zzdykVar = (zzdyk) obj;
        return this.f28789a == zzdykVar.a() && this.f28790b == zzdykVar.b();
    }

    public final int hashCode() {
        long j2 = this.f28789a;
        return ((((int) ((j2 >>> 32) ^ j2)) ^ 1000003) * 1000003) ^ this.f28790b;
    }

    public final String toString() {
        long j2 = this.f28789a;
        int length = String.valueOf(j2).length();
        int i2 = this.f28790b;
        StringBuilder sb = new StringBuilder(length + 34 + String.valueOf(i2).length() + 1);
        androidx.fragment.app.e.A(sb, "OnDeviceStorageKey{id=", j2, ", eventType=");
        return android.support.v4.media.b.o(sb, i2, "}");
    }
}
