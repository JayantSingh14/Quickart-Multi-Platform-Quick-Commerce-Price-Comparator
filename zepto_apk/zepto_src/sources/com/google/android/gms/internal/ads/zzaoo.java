package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzaoo {

    /* renamed from: a, reason: collision with root package name */
    public final zzaga f23939a;

    /* renamed from: b, reason: collision with root package name */
    public long f23940b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23941c;

    /* renamed from: d, reason: collision with root package name */
    public int f23942d;

    /* renamed from: e, reason: collision with root package name */
    public long f23943e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f23944f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f23945g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f23946h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23947i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23948j;

    /* renamed from: k, reason: collision with root package name */
    public long f23949k;

    /* renamed from: l, reason: collision with root package name */
    public long f23950l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f23951m;

    public zzaoo(zzaga zzagaVar) {
        this.f23939a = zzagaVar;
    }

    public final void a(int i2) {
        long j2 = this.f23950l;
        if (j2 != -9223372036854775807L) {
            long j3 = this.f23940b;
            long j4 = this.f23949k;
            if (j3 == j4) {
                return;
            }
            int i3 = (int) (j3 - j4);
            this.f23939a.e(j2, this.f23951m ? 1 : 0, i3, i2, null);
        }
    }
}
