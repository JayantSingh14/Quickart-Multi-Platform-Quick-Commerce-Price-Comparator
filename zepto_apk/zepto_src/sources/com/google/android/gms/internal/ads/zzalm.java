package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
abstract class zzalm {

    /* renamed from: b, reason: collision with root package name */
    public zzaga f23489b;

    /* renamed from: c, reason: collision with root package name */
    public zzaer f23490c;

    /* renamed from: d, reason: collision with root package name */
    public zzali f23491d;

    /* renamed from: e, reason: collision with root package name */
    public long f23492e;

    /* renamed from: f, reason: collision with root package name */
    public long f23493f;

    /* renamed from: g, reason: collision with root package name */
    public long f23494g;

    /* renamed from: h, reason: collision with root package name */
    public int f23495h;

    /* renamed from: i, reason: collision with root package name */
    public int f23496i;

    /* renamed from: k, reason: collision with root package name */
    public long f23498k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f23499l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f23500m;

    /* renamed from: a, reason: collision with root package name */
    public final zzalg f23488a = new zzalg();

    /* renamed from: j, reason: collision with root package name */
    public zzalk f23497j = new zzalk();

    public void a(boolean z) {
        int i2;
        if (z) {
            this.f23497j = new zzalk();
            this.f23493f = 0L;
            i2 = 0;
        } else {
            i2 = 1;
        }
        this.f23495h = i2;
        this.f23492e = -1L;
        this.f23494g = 0L;
    }

    public abstract long b(zzer zzerVar);

    public abstract boolean c(zzer zzerVar, long j2, zzalk zzalkVar);

    public void d(long j2) {
        this.f23494g = j2;
    }
}
