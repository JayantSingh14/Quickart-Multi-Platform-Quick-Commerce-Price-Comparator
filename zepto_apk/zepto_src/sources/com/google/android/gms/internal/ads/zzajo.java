package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzajo implements zzafv {

    /* renamed from: a, reason: collision with root package name */
    public final int f23296a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23297b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23298c;

    public zzajo(int i2, int i3, long j2) {
        this.f23296a = i2;
        this.f23297b = j2;
        this.f23298c = i3;
    }

    public final String toString() {
        String strX = zzfj.x(this.f23296a);
        int length = strX.length();
        long j2 = this.f23297b;
        int length2 = String.valueOf(j2).length();
        int i2 = this.f23298c;
        StringBuilder sb = new StringBuilder(length + 29 + length2 + 16 + String.valueOf(i2).length() + 1);
        android.support.v4.media.a.u(sb, "AtomSizeTooSmall{type=", strX, ", size=");
        sb.append(j2);
        sb.append(", minHeaderSize=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
