package com.google.android.play.integrity.internal;

/* loaded from: classes4.dex */
final class e extends f {

    /* renamed from: a, reason: collision with root package name */
    public final int f42190a;

    /* renamed from: b, reason: collision with root package name */
    public final long f42191b;

    public e(int i2, long j2) {
        this.f42190a = i2;
        this.f42191b = j2;
    }

    @Override // com.google.android.play.integrity.internal.f
    public final int a() {
        return this.f42190a;
    }

    @Override // com.google.android.play.integrity.internal.f
    public final long b() {
        return this.f42191b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f42190a == fVar.a() && this.f42191b == fVar.b();
    }

    public final int hashCode() {
        long j2 = this.f42191b;
        return ((int) (j2 ^ (j2 >>> 32))) ^ ((this.f42190a ^ 1000003) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventRecord{eventType=");
        sb.append(this.f42190a);
        sb.append(", eventTimestamp=");
        return android.support.v4.media.b.p(sb, this.f42191b, "}");
    }
}
