package com.google.android.play.core.install;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
final class zza extends InstallState {

    /* renamed from: a, reason: collision with root package name */
    public final int f41757a;

    /* renamed from: b, reason: collision with root package name */
    public final long f41758b;

    /* renamed from: c, reason: collision with root package name */
    public final long f41759c;

    /* renamed from: d, reason: collision with root package name */
    public final int f41760d;

    /* renamed from: e, reason: collision with root package name */
    public final String f41761e;

    public zza(int i2, long j2, long j3, int i3, String str) {
        this.f41757a = i2;
        this.f41758b = j2;
        this.f41759c = j3;
        this.f41760d = i3;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.f41761e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long a() {
        return this.f41758b;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int b() {
        return this.f41760d;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int c() {
        return this.f41757a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String d() {
        return this.f41761e;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long e() {
        return this.f41759c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallState)) {
            return false;
        }
        InstallState installState = (InstallState) obj;
        return this.f41757a == installState.c() && this.f41758b == installState.a() && this.f41759c == installState.e() && this.f41760d == installState.b() && this.f41761e.equals(installState.d());
    }

    public final int hashCode() {
        int i2 = this.f41757a ^ 1000003;
        long j2 = this.f41758b;
        long j3 = this.f41759c;
        return (((((((i2 * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f41760d) * 1000003) ^ this.f41761e.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallState{installStatus=");
        sb.append(this.f41757a);
        sb.append(", bytesDownloaded=");
        sb.append(this.f41758b);
        sb.append(", totalBytesToDownload=");
        sb.append(this.f41759c);
        sb.append(", installErrorCode=");
        sb.append(this.f41760d);
        sb.append(", packageName=");
        return b.r(sb, this.f41761e, "}");
    }
}
