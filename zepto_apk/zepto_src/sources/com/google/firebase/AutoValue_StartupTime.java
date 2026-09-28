package com.google.firebase;

/* loaded from: classes.dex */
final class AutoValue_StartupTime extends StartupTime {

    /* renamed from: a, reason: collision with root package name */
    public final long f43482a;

    /* renamed from: b, reason: collision with root package name */
    public final long f43483b;

    /* renamed from: c, reason: collision with root package name */
    public final long f43484c;

    public AutoValue_StartupTime(long j2, long j3, long j4) {
        this.f43482a = j2;
        this.f43483b = j3;
        this.f43484c = j4;
    }

    @Override // com.google.firebase.StartupTime
    public final long a() {
        return this.f43483b;
    }

    @Override // com.google.firebase.StartupTime
    public final long b() {
        return this.f43482a;
    }

    @Override // com.google.firebase.StartupTime
    public final long c() {
        return this.f43484c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StartupTime)) {
            return false;
        }
        StartupTime startupTime = (StartupTime) obj;
        return this.f43482a == startupTime.b() && this.f43483b == startupTime.a() && this.f43484c == startupTime.c();
    }

    public final int hashCode() {
        long j2 = this.f43482a;
        long j3 = this.f43483b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f43484c;
        return i2 ^ ((int) ((j4 >>> 32) ^ j4));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StartupTime{epochMillis=");
        sb.append(this.f43482a);
        sb.append(", elapsedRealtime=");
        sb.append(this.f43483b);
        sb.append(", uptimeMillis=");
        return android.support.v4.media.b.p(sb, this.f43484c, "}");
    }
}
