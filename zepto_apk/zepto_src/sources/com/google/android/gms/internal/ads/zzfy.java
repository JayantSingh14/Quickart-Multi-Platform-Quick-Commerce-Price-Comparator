package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfy implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final long f31994a;

    /* renamed from: b, reason: collision with root package name */
    public final long f31995b;

    /* renamed from: c, reason: collision with root package name */
    public final long f31996c;

    public zzfy(long j2, long j3, long j4) {
        this.f31994a = j2;
        this.f31995b = j3;
        this.f31996c = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfy)) {
            return false;
        }
        zzfy zzfyVar = (zzfy) obj;
        return this.f31994a == zzfyVar.f31994a && this.f31995b == zzfyVar.f31995b && this.f31996c == zzfyVar.f31996c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f31996c) + ((Long.hashCode(this.f31995b) + ((Long.hashCode(this.f31994a) + 527) * 31)) * 31);
    }

    public final String toString() {
        long j2 = this.f31994a;
        int length = String.valueOf(j2).length();
        long j3 = this.f31995b;
        int length2 = String.valueOf(j3).length();
        long j4 = this.f31996c;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 12 + String.valueOf(j4).length());
        androidx.fragment.app.e.A(sb, "Mp4Timestamp: creation time=", j2, ", modification time=");
        sb.append(j3);
        sb.append(", timescale=");
        sb.append(j4);
        return sb.toString();
    }
}
