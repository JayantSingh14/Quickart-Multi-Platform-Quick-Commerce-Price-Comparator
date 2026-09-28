package com.google.firebase.crashlytics.internal.metadata;

/* loaded from: classes4.dex */
final class AutoValue_RolloutAssignment extends RolloutAssignment {

    /* renamed from: b, reason: collision with root package name */
    public final String f43889b;

    /* renamed from: c, reason: collision with root package name */
    public final String f43890c;

    /* renamed from: d, reason: collision with root package name */
    public final String f43891d;

    /* renamed from: e, reason: collision with root package name */
    public final String f43892e;

    /* renamed from: f, reason: collision with root package name */
    public final long f43893f;

    public AutoValue_RolloutAssignment(String str, String str2, String str3, String str4, long j2) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f43889b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f43890c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f43891d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f43892e = str4;
        this.f43893f = j2;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public final String b() {
        return this.f43890c;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public final String c() {
        return this.f43891d;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public final String d() {
        return this.f43889b;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public final long e() {
        return this.f43893f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RolloutAssignment)) {
            return false;
        }
        RolloutAssignment rolloutAssignment = (RolloutAssignment) obj;
        return this.f43889b.equals(rolloutAssignment.d()) && this.f43890c.equals(rolloutAssignment.b()) && this.f43891d.equals(rolloutAssignment.c()) && this.f43892e.equals(rolloutAssignment.f()) && this.f43893f == rolloutAssignment.e();
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public final String f() {
        return this.f43892e;
    }

    public final int hashCode() {
        int iHashCode = (((((((this.f43889b.hashCode() ^ 1000003) * 1000003) ^ this.f43890c.hashCode()) * 1000003) ^ this.f43891d.hashCode()) * 1000003) ^ this.f43892e.hashCode()) * 1000003;
        long j2 = this.f43893f;
        return iHashCode ^ ((int) ((j2 >>> 32) ^ j2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RolloutAssignment{rolloutId=");
        sb.append(this.f43889b);
        sb.append(", parameterKey=");
        sb.append(this.f43890c);
        sb.append(", parameterValue=");
        sb.append(this.f43891d);
        sb.append(", variantId=");
        sb.append(this.f43892e);
        sb.append(", templateVersion=");
        return android.support.v4.media.b.p(sb, this.f43893f, "}");
    }
}
