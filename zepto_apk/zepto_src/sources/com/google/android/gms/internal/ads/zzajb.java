package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzajb {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23254a = new zzer(8);

    /* renamed from: b, reason: collision with root package name */
    public int f23255b;

    public final long a(zzaef zzaefVar) {
        int i2;
        zzer zzerVar = this.f23254a;
        int i3 = 0;
        zzaefVar.t(zzerVar.f30144a, 0, 1, false);
        int i4 = zzerVar.f30144a[0] & 255;
        if (i4 == 0) {
            return Long.MIN_VALUE;
        }
        int i5 = 128;
        int i6 = 0;
        while (true) {
            i2 = i6 + 1;
            if ((i4 & i5) != 0) {
                break;
            }
            i5 >>= 1;
            i6 = i2;
        }
        int i7 = i4 & (~i5);
        zzaefVar.t(zzerVar.f30144a, 1, i6, false);
        while (i3 < i6) {
            i3++;
            i7 = (zzerVar.f30144a[i3] & 255) + (i7 << 8);
        }
        this.f23255b += i2;
        return i7;
    }
}
