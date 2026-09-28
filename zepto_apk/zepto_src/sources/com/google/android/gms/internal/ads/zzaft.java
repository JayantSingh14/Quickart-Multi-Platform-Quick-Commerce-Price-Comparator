package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaft implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final int f22962a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22963b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22964c;

    /* renamed from: d, reason: collision with root package name */
    public int f22965d;

    /* renamed from: e, reason: collision with root package name */
    public int f22966e;

    /* renamed from: f, reason: collision with root package name */
    public zzaer f22967f;

    /* renamed from: g, reason: collision with root package name */
    public zzaga f22968g;

    public zzaft(int i2, int i3, String str) {
        this.f22962a = i2;
        this.f22963b = i3;
        this.f22964c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        if (j2 == 0 || this.f22966e == 1) {
            this.f22966e = 1;
            this.f22965d = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f22967f = zzaerVar;
        zzaga zzagaVarE = ((zzxk) zzaerVar).e(1024, 4);
        this.f22968g = zzagaVarE;
        zzt zztVar = new zzt();
        String str = this.f22964c;
        zztVar.d(str);
        zztVar.e(str);
        zzagaVarE.c(new zzv(zztVar));
        ((zzxk) this.f22967f).h();
        ((zzxk) this.f22967f).d(new zzafu());
        this.f22966e = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) {
        int i2 = this.f22963b;
        int i3 = this.f22962a;
        zzgqa.f((i3 == -1 || i2 == -1) ? false : true);
        zzer zzerVar = new zzer(i2);
        ((zzaef) zzaepVar).t(zzerVar.f30144a, 0, i2, false);
        return zzerVar.L() == i3;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final int d(zzaep zzaepVar, zzafo zzafoVar) {
        int i2 = this.f22966e;
        if (i2 != 1) {
            if (i2 == 2) {
                return -1;
            }
            throw new IllegalStateException();
        }
        zzaga zzagaVar = this.f22968g;
        zzagaVar.getClass();
        int iF = zzagaVar.f(zzaepVar, 1024, true);
        if (iF != -1) {
            this.f22965d += iF;
            return 0;
        }
        this.f22966e = 2;
        this.f22968g.e(0L, 1, this.f22965d, 0, null);
        this.f22965d = 0;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
