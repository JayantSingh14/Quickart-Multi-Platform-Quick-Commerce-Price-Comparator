package com.google.android.gms.ads.internal.util.client;

import androidx.fragment.app.e;

/* loaded from: classes4.dex */
final class zzn extends zzx {

    /* renamed from: a, reason: collision with root package name */
    public final int f21438a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21439b;

    /* renamed from: c, reason: collision with root package name */
    public final double f21440c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21441d;

    public zzn(int i2, int i3, double d2, boolean z) {
        this.f21438a = i2;
        this.f21439b = i3;
        this.f21440c = d2;
        this.f21441d = z;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final int a() {
        return this.f21438a;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final int b() {
        return this.f21439b;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final double c() {
        return this.f21440c;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzx
    public final boolean d() {
        return this.f21441d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzx)) {
            return false;
        }
        zzx zzxVar = (zzx) obj;
        return this.f21438a == zzxVar.a() && this.f21439b == zzxVar.b() && Double.doubleToLongBits(this.f21440c) == Double.doubleToLongBits(zzxVar.c()) && this.f21441d == zzxVar.d();
    }

    public final int hashCode() {
        double d2 = this.f21440c;
        return ((((int) (Double.doubleToLongBits(d2) ^ (Double.doubleToLongBits(d2) >>> 32))) ^ ((((this.f21438a ^ 1000003) * 1000003) ^ this.f21439b) * 1000003)) * 1000003) ^ (true != this.f21441d ? 1237 : 1231);
    }

    public final String toString() {
        int i2 = this.f21438a;
        int length = String.valueOf(i2).length();
        int i3 = this.f21439b;
        int length2 = String.valueOf(i3).length();
        double d2 = this.f21440c;
        int length3 = String.valueOf(d2).length();
        boolean z = this.f21441d;
        StringBuilder sb = new StringBuilder(length + 44 + length2 + 20 + length3 + 25 + String.valueOf(z).length() + 1);
        e.w(i2, i3, "PingStrategy{maxAttempts=", ", initialBackoffMs=", sb);
        sb.append(", backoffMultiplier=");
        sb.append(d2);
        sb.append(", bufferAfterMaxAttempts=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}
