package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaol implements zzaog {

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f23903l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final zzapy f23904a;

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23905b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean[] f23906c = new boolean[4];

    /* renamed from: d, reason: collision with root package name */
    public final zzaoj f23907d;

    /* renamed from: e, reason: collision with root package name */
    public final zzaox f23908e;

    /* renamed from: f, reason: collision with root package name */
    public zzaok f23909f;

    /* renamed from: g, reason: collision with root package name */
    public long f23910g;

    /* renamed from: h, reason: collision with root package name */
    public String f23911h;

    /* renamed from: i, reason: collision with root package name */
    public zzaga f23912i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23913j;

    /* renamed from: k, reason: collision with root package name */
    public long f23914k;

    public zzaol(zzapy zzapyVar) {
        this.f23904a = zzapyVar;
        zzaoj zzaojVar = new zzaoj();
        zzaojVar.f23894e = new byte[128];
        this.f23907d = zzaojVar;
        this.f23914k = -9223372036854775807L;
        this.f23908e = new zzaox(178);
        this.f23905b = new zzer();
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.f23914k = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
        zzaok zzaokVar = this.f23909f;
        zzaokVar.getClass();
        if (z) {
            zzaokVar.b(0, this.f23910g, this.f23913j);
            zzaok zzaokVar2 = this.f23909f;
            zzaokVar2.f23896b = false;
            zzaokVar2.f23897c = false;
            zzaokVar2.f23898d = false;
            zzaokVar2.f23899e = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0247 A[PHI: r13
      0x0247: PHI (r13v2 int) = (r13v1 int), (r13v4 int) binds: [B:93:0x0240, B:96:0x0246] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzaog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(com.google.android.gms.internal.ads.zzer r22) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaol.d(com.google.android.gms.internal.ads.zzer):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23911h = zzapuVar.f24112e;
        zzapuVar.b();
        zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 2);
        this.f23912i = zzagaVarE;
        this.f23909f = new zzaok(zzagaVarE);
        this.f23904a.a(zzaerVar, zzapuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        zzgm.h(this.f23906c);
        zzaoj zzaojVar = this.f23907d;
        zzaojVar.f23890a = false;
        zzaojVar.f23892c = 0;
        zzaojVar.f23891b = 0;
        zzaok zzaokVar = this.f23909f;
        if (zzaokVar != null) {
            zzaokVar.f23896b = false;
            zzaokVar.f23897c = false;
            zzaokVar.f23898d = false;
            zzaokVar.f23899e = -1;
        }
        this.f23908e.a();
        this.f23910g = 0L;
        this.f23914k = -9223372036854775807L;
    }
}
