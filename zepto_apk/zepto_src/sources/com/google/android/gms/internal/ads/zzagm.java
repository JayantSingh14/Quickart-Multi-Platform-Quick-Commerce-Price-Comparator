package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzagm implements zzaeo {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23018a;

    /* renamed from: b, reason: collision with root package name */
    public final zzagl f23019b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23020c;

    /* renamed from: d, reason: collision with root package name */
    public final zzalw f23021d;

    /* renamed from: e, reason: collision with root package name */
    public int f23022e;

    /* renamed from: f, reason: collision with root package name */
    public zzaer f23023f;

    /* renamed from: g, reason: collision with root package name */
    public zzagn f23024g;

    /* renamed from: h, reason: collision with root package name */
    public long f23025h;

    /* renamed from: i, reason: collision with root package name */
    public zzagp[] f23026i;

    /* renamed from: j, reason: collision with root package name */
    public long f23027j;

    /* renamed from: k, reason: collision with root package name */
    public zzagp f23028k;

    /* renamed from: l, reason: collision with root package name */
    public int f23029l;

    /* renamed from: m, reason: collision with root package name */
    public long f23030m;
    public long n;
    public int o;
    public boolean p;

    @Deprecated
    public zzagm() {
        this(1, zzalw.f23510a);
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f23027j = -1L;
        this.f23028k = null;
        for (zzagp zzagpVar : this.f23026i) {
            if (zzagpVar.f23050k == 0) {
                zzagpVar.f23048i = 0;
            } else {
                zzagpVar.f23048i = zzagpVar.n[zzfj.q(zzagpVar.f23052m, j2, true)];
            }
        }
        if (j2 == 0) {
            this.f23022e = this.f23026i.length != 0 ? 3 : 0;
        } else {
            this.f23022e = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23022e = 0;
        if (this.f23020c) {
            zzaerVar = new zzalz(zzaerVar, this.f23021d);
        }
        this.f23023f = zzaerVar;
        this.f23027j = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) {
        zzer zzerVar = this.f23018a;
        ((zzaef) zzaepVar).t(zzerVar.f30144a, 0, 12, false);
        zzerVar.E(0);
        if (zzerVar.c() == 1179011410) {
            zzerVar.G(4);
            if (zzerVar.c() == 541677121) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:190:0x03c4  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r31, com.google.android.gms.internal.ads.zzafo r32) throws com.google.android.gms.internal.ads.zzat, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 1163
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagm.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzagm(int i2, zzalw zzalwVar) {
        this.f23021d = zzalwVar;
        this.f23020c = 1 == (i2 ^ 1);
        this.f23018a = new zzer(12);
        this.f23019b = new zzagl();
        this.f23023f = new zzafm();
        this.f23026i = new zzagp[0];
        this.f23030m = -1L;
        this.n = -1L;
        this.f23029l = -1;
        this.f23025h = -9223372036854775807L;
    }
}
