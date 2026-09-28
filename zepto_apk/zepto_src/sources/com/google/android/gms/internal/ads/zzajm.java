package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzajm {

    /* renamed from: a, reason: collision with root package name */
    public final zzafk f23287a;

    /* renamed from: b, reason: collision with root package name */
    public final long f23288b;

    public zzajm(zzafk zzafkVar, long j2, long j3, long[] jArr, int i2, int i3) {
        zzafk zzafkVar2 = new zzafk();
        zzafkVar2.f22940a = zzafkVar.f22940a;
        zzafkVar2.f22941b = zzafkVar.f22941b;
        zzafkVar2.f22942c = zzafkVar.f22942c;
        zzafkVar2.f22943d = zzafkVar.f22943d;
        zzafkVar2.f22944e = zzafkVar.f22944e;
        zzafkVar2.f22945f = zzafkVar.f22945f;
        zzafkVar2.f22946g = zzafkVar.f22946g;
        this.f23287a = zzafkVar2;
        this.f23288b = j2;
    }

    public final long a() {
        long j2 = this.f23288b;
        if (j2 == -1 || j2 == 0) {
            return -9223372036854775807L;
        }
        return zzfj.t(this.f23287a.f22943d, (j2 * r4.f22946g) - 1);
    }
}
