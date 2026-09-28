package com.google.android.gms.internal.ads;

@Deprecated
/* loaded from: classes4.dex */
public class zzain implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final long f23200a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23201b;

    /* renamed from: c, reason: collision with root package name */
    public final long f23202c;

    /* renamed from: d, reason: collision with root package name */
    public final long f23203d;

    /* renamed from: e, reason: collision with root package name */
    public final long f23204e;

    public zzain(long j2, long j3, long j4, long j5, long j6) {
        this.f23200a = j2;
        this.f23201b = j3;
        this.f23202c = j4;
        this.f23203d = j5;
        this.f23204e = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzain zzainVar = (zzain) obj;
            if (this.f23200a == zzainVar.f23200a && this.f23201b == zzainVar.f23201b && this.f23202c == zzainVar.f23202c && this.f23203d == zzainVar.f23203d && this.f23204e == zzainVar.f23204e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.f23204e) + ((Long.hashCode(this.f23203d) + ((Long.hashCode(this.f23202c) + ((Long.hashCode(this.f23201b) + ((Long.hashCode(this.f23200a) + 527) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        long j2 = this.f23200a;
        int length = String.valueOf(j2).length();
        long j3 = this.f23201b;
        int length2 = String.valueOf(j3).length();
        long j4 = this.f23202c;
        int length3 = String.valueOf(j4).length();
        long j5 = this.f23203d;
        int length4 = String.valueOf(j5).length();
        long j6 = this.f23204e;
        StringBuilder sb = new StringBuilder(length + 54 + length2 + 31 + length3 + 21 + length4 + 12 + String.valueOf(j6).length());
        androidx.fragment.app.e.A(sb, "Motion photo metadata: photoStartPosition=", j2, ", photoSize=");
        sb.append(j3);
        androidx.fragment.app.e.A(sb, ", photoPresentationTimestampUs=", j4, ", videoStartPosition=");
        sb.append(j5);
        sb.append(", videoSize=");
        sb.append(j6);
        return sb.toString();
    }
}
