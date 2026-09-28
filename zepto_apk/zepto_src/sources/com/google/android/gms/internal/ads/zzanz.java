package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzanz implements zzaog {

    /* renamed from: a, reason: collision with root package name */
    public final zzeq f23815a;

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23816b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23817c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23818d;

    /* renamed from: e, reason: collision with root package name */
    public final String f23819e;

    /* renamed from: f, reason: collision with root package name */
    public String f23820f;

    /* renamed from: g, reason: collision with root package name */
    public zzaga f23821g;

    /* renamed from: h, reason: collision with root package name */
    public int f23822h;

    /* renamed from: i, reason: collision with root package name */
    public int f23823i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23824j;

    /* renamed from: k, reason: collision with root package name */
    public long f23825k;

    /* renamed from: l, reason: collision with root package name */
    public zzv f23826l;

    /* renamed from: m, reason: collision with root package name */
    public int f23827m;
    public long n;

    public zzanz(String str, int i2, String str2) {
        zzeq zzeqVar = new zzeq(new byte[16], 16);
        this.f23815a = zzeqVar;
        this.f23816b = new zzer(zzeqVar.f30084a);
        this.f23822h = 0;
        this.f23823i = 0;
        this.f23824j = false;
        this.n = -9223372036854775807L;
        this.f23817c = str;
        this.f23818d = i2;
        this.f23819e = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.n = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void d(zzer zzerVar) {
        this.f23821g.getClass();
        while (zzerVar.B() > 0) {
            int i2 = this.f23822h;
            zzer zzerVar2 = this.f23816b;
            if (i2 == 0) {
                while (zzerVar.B() > 0) {
                    if (this.f23824j) {
                        int iK = zzerVar.K();
                        this.f23824j = iK == 172;
                        if (iK != 64) {
                            if (iK == 65) {
                                iK = 65;
                            }
                        }
                        this.f23822h = 1;
                        byte[] bArr = zzerVar2.f30144a;
                        bArr[0] = -84;
                        bArr[1] = iK == 65 ? (byte) 65 : (byte) 64;
                        this.f23823i = 2;
                    } else {
                        this.f23824j = zzerVar.K() == 172;
                    }
                }
            } else if (i2 != 1) {
                int iMin = Math.min(zzerVar.B(), this.f23827m - this.f23823i);
                this.f23821g.b(iMin, zzerVar);
                int i3 = this.f23823i + iMin;
                this.f23823i = i3;
                if (i3 == this.f23827m) {
                    zzgqa.f(this.n != -9223372036854775807L);
                    this.f23821g.e(this.n, 1, this.f23827m, 0, null);
                    this.n += this.f23825k;
                    this.f23822h = 0;
                }
            } else {
                byte[] bArr2 = zzerVar2.f30144a;
                int iMin2 = Math.min(zzerVar.B(), 16 - this.f23823i);
                zzerVar.H(this.f23823i, bArr2, iMin2);
                int i4 = this.f23823i + iMin2;
                this.f23823i = i4;
                if (i4 == 16) {
                    zzeq zzeqVar = this.f23815a;
                    zzeqVar.d(0);
                    zzadr zzadrVarA = zzads.a(zzeqVar);
                    zzv zzvVar = this.f23826l;
                    int i5 = zzadrVarA.f22818a;
                    if (zzvVar == null || zzvVar.E != 2 || i5 != zzvVar.F || !"audio/ac4".equals(zzvVar.f35691m)) {
                        zzt zztVar = new zzt();
                        zztVar.f35564a = this.f23820f;
                        zztVar.d(this.f23819e);
                        zztVar.e("audio/ac4");
                        zztVar.D = 2;
                        zztVar.E = i5;
                        zztVar.f35567d = this.f23817c;
                        zztVar.f35569f = this.f23818d;
                        zzv zzvVar2 = new zzv(zztVar);
                        this.f23826l = zzvVar2;
                        this.f23821g.c(zzvVar2);
                    }
                    this.f23827m = zzadrVarA.f22819b;
                    this.f23825k = (zzadrVarA.f22820c * 1000000) / this.f23826l.F;
                    zzerVar2.E(0);
                    this.f23821g.b(16, zzerVar2);
                    this.f23822h = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23820f = zzapuVar.f24112e;
        zzapuVar.b();
        this.f23821g = zzaerVar.e(zzapuVar.f24111d, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f23822h = 0;
        this.f23823i = 0;
        this.f23824j = false;
        this.n = -9223372036854775807L;
    }
}
