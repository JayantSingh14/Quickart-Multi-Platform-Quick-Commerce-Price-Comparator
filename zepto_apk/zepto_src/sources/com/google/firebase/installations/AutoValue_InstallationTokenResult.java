package com.google.firebase.installations;

import com.google.firebase.installations.InstallationTokenResult;

/* loaded from: classes.dex */
final class AutoValue_InstallationTokenResult extends InstallationTokenResult {

    /* renamed from: a, reason: collision with root package name */
    public final String f44560a;

    /* renamed from: b, reason: collision with root package name */
    public final long f44561b;

    /* renamed from: c, reason: collision with root package name */
    public final long f44562c;

    public static final class Builder extends InstallationTokenResult.Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f44563a;

        /* renamed from: b, reason: collision with root package name */
        public Long f44564b;

        /* renamed from: c, reason: collision with root package name */
        public Long f44565c;
    }

    public AutoValue_InstallationTokenResult(long j2, long j3, String str) {
        this.f44560a = str;
        this.f44561b = j2;
        this.f44562c = j3;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final String a() {
        return this.f44560a;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final long b() {
        return this.f44562c;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final long c() {
        return this.f44561b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        return this.f44560a.equals(installationTokenResult.a()) && this.f44561b == installationTokenResult.c() && this.f44562c == installationTokenResult.b();
    }

    public final int hashCode() {
        int iHashCode = (this.f44560a.hashCode() ^ 1000003) * 1000003;
        long j2 = this.f44561b;
        long j3 = this.f44562c;
        return ((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallationTokenResult{token=");
        sb.append(this.f44560a);
        sb.append(", tokenExpirationTimestamp=");
        sb.append(this.f44561b);
        sb.append(", tokenCreationTimestamp=");
        return android.support.v4.media.b.p(sb, this.f44562c, "}");
    }
}
