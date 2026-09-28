package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaot implements zzaog {

    /* renamed from: e, reason: collision with root package name */
    public String f24001e;

    /* renamed from: f, reason: collision with root package name */
    public zzaga f24002f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f24005i;

    /* renamed from: k, reason: collision with root package name */
    public int f24007k;

    /* renamed from: l, reason: collision with root package name */
    public int f24008l;
    public int n;
    public int o;
    public int s;
    public boolean u;

    /* renamed from: d, reason: collision with root package name */
    public int f24000d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23997a = new zzer(new byte[15], 2);

    /* renamed from: b, reason: collision with root package name */
    public final zzeq f23998b = new zzeq();

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23999c = new zzer();
    public final zzaou p = new zzaou();
    public int q = -2147483647;
    public int r = -1;
    public long t = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f24006j = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f24009m = true;

    /* renamed from: g, reason: collision with root package name */
    public double f24003g = -9.223372036854776E18d;

    /* renamed from: h, reason: collision with root package name */
    public double f24004h = -9.223372036854776E18d;

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.f24007k = i2;
        if (!this.f24006j && (this.o != 0 || !this.f24009m)) {
            this.f24005i = true;
        }
        if (j2 != -9223372036854775807L) {
            double d2 = j2;
            if (this.f24005i) {
                this.f24004h = d2;
            } else {
                this.f24003g = d2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x04c9 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzaog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.android.gms.internal.ads.zzer r25) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instructions count: 1414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaot.d(com.google.android.gms.internal.ads.zzer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f24001e = zzapuVar.f24112e;
        zzapuVar.b();
        this.f24002f = zzaerVar.e(zzapuVar.f24111d, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f24000d = 0;
        this.f24008l = 0;
        this.f23997a.y(2);
        this.n = 0;
        this.o = 0;
        this.q = -2147483647;
        this.r = -1;
        this.s = 0;
        this.t = -1L;
        this.u = false;
        this.f24005i = false;
        this.f24009m = true;
        this.f24006j = true;
        this.f24003g = -9.223372036854776E18d;
        this.f24004h = -9.223372036854776E18d;
    }
}
