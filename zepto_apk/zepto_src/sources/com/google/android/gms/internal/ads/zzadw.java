package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzadw {

    /* renamed from: a, reason: collision with root package name */
    public final long f22840a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22841b;

    /* renamed from: c, reason: collision with root package name */
    public final long f22842c;

    /* renamed from: d, reason: collision with root package name */
    public long f22843d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f22844e;

    /* renamed from: f, reason: collision with root package name */
    public long f22845f;

    /* renamed from: g, reason: collision with root package name */
    public long f22846g;

    /* renamed from: h, reason: collision with root package name */
    public long f22847h;

    public zzadw(long j2, long j3, long j4, long j5, long j6, long j7) {
        this.f22840a = j2;
        this.f22841b = j3;
        this.f22844e = j4;
        this.f22845f = j5;
        this.f22846g = j6;
        this.f22842c = j7;
        this.f22847h = a(j3, 0L, j4, j5, j6, j7);
    }

    public static long a(long j2, long j3, long j4, long j5, long j6, long j7) {
        if (j5 + 1 >= j6 || 1 + j3 >= j4) {
            return j5;
        }
        long j8 = (long) (((j6 - j5) / (j4 - j3)) * (j2 - j3));
        String str = zzfj.f31254a;
        return Math.max(j5, Math.min(((j5 + j8) - j7) - (j8 / 20), j6 - 1));
    }
}
