package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaoi implements zzaog {
    public static final double[] r = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    public String f23876a;

    /* renamed from: b, reason: collision with root package name */
    public zzaga f23877b;

    /* renamed from: c, reason: collision with root package name */
    public final zzapy f23878c;

    /* renamed from: d, reason: collision with root package name */
    public final String f23879d;

    /* renamed from: e, reason: collision with root package name */
    public final zzer f23880e;

    /* renamed from: f, reason: collision with root package name */
    public final zzaox f23881f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean[] f23882g = new boolean[4];

    /* renamed from: h, reason: collision with root package name */
    public final zzaoh f23883h;

    /* renamed from: i, reason: collision with root package name */
    public long f23884i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23885j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f23886k;

    /* renamed from: l, reason: collision with root package name */
    public long f23887l;

    /* renamed from: m, reason: collision with root package name */
    public long f23888m;
    public long n;
    public long o;
    public boolean p;
    public boolean q;

    public zzaoi(zzapy zzapyVar, String str) {
        zzer zzerVar;
        this.f23878c = zzapyVar;
        this.f23879d = str;
        zzaoh zzaohVar = new zzaoh();
        zzaohVar.f23875d = new byte[128];
        this.f23883h = zzaohVar;
        if (zzapyVar != null) {
            this.f23881f = new zzaox(178);
            zzerVar = new zzer();
        } else {
            zzerVar = null;
            this.f23881f = null;
        }
        this.f23880e = zzerVar;
        this.f23888m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.f23888m = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
        zzaga zzagaVar = this.f23877b;
        zzagaVar.getClass();
        if (z) {
            boolean z2 = this.p;
            long j2 = this.f23884i - this.n;
            zzagaVar.e(this.o, z2 ? 1 : 0, (int) j2, 0, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0198  */
    @Override // com.google.android.gms.internal.ads.zzaog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.android.gms.internal.ads.zzer r29) {
        /*
            Method dump skipped, instructions count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoi.d(com.google.android.gms.internal.ads.zzer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23876a = zzapuVar.f24112e;
        zzapuVar.b();
        this.f23877b = zzaerVar.e(zzapuVar.f24111d, 2);
        zzapy zzapyVar = this.f23878c;
        if (zzapyVar != null) {
            zzapyVar.a(zzaerVar, zzapuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        zzgm.h(this.f23882g);
        zzaoh zzaohVar = this.f23883h;
        zzaohVar.f23872a = false;
        zzaohVar.f23873b = 0;
        zzaohVar.f23874c = 0;
        zzaox zzaoxVar = this.f23881f;
        if (zzaoxVar != null) {
            zzaoxVar.a();
        }
        this.f23884i = 0L;
        this.f23885j = false;
        this.f23888m = -9223372036854775807L;
        this.o = -9223372036854775807L;
    }
}
