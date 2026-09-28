package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
public abstract class zzij implements zzmi, zzmk {

    /* renamed from: b, reason: collision with root package name */
    public final int f34880b;

    /* renamed from: d, reason: collision with root package name */
    public zzml f34882d;

    /* renamed from: e, reason: collision with root package name */
    public int f34883e;

    /* renamed from: f, reason: collision with root package name */
    public zzpn f34884f;

    /* renamed from: g, reason: collision with root package name */
    public zzfc f34885g;

    /* renamed from: h, reason: collision with root package name */
    public int f34886h;

    /* renamed from: i, reason: collision with root package name */
    public zzxw f34887i;

    /* renamed from: j, reason: collision with root package name */
    public zzv[] f34888j;

    /* renamed from: k, reason: collision with root package name */
    public long f34889k;

    /* renamed from: l, reason: collision with root package name */
    public long f34890l;
    public boolean n;
    public boolean o;
    public zzwg q;
    public zzmj r;

    /* renamed from: a, reason: collision with root package name */
    public final Object f34879a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final zzle f34881c = new zzle();

    /* renamed from: m, reason: collision with root package name */
    public long f34891m = Long.MIN_VALUE;
    public zzbf p = zzbf.f24868a;

    public zzij(int i2) {
        this.f34880b = i2;
    }

    public void B() {
        throw null;
    }

    public void C() {
    }

    public final void E() {
        this.f34882d.getClass();
    }

    public final zzit F(Exception exc, zzv zzvVar, boolean z, int i2) {
        int iB;
        if (zzvVar == null || this.o) {
            iB = 4;
        } else {
            this.o = true;
            try {
                iB = ((zzuq) this).b(zzvVar) & 7;
            } catch (zzit unused) {
            } finally {
                this.o = false;
            }
        }
        return new zzit(1, exc, i2, d(), this.f34883e, zzvVar, zzvVar == null ? 4 : iB, this.q, z);
    }

    public final int G(zzle zzleVar, zzih zzihVar, int i2) {
        zzxw zzxwVar = this.f34887i;
        zzxwVar.getClass();
        int iB = zzxwVar.b(zzleVar, zzihVar, i2);
        if (iB == -4) {
            if (zzihVar.b(4)) {
                this.f34891m = Long.MIN_VALUE;
                return this.n ? -4 : -3;
            }
            long j2 = zzihVar.f34831f + this.f34889k;
            zzihVar.f34831f = j2;
            this.f34891m = Math.max(this.f34891m, j2);
            return iB;
        }
        if (iB == -5) {
            zzv zzvVar = zzleVar.f35082b;
            zzvVar.getClass();
            long j3 = zzvVar.r;
            if (j3 != Long.MAX_VALUE) {
                zzt zztVar = new zzt(zzvVar);
                zztVar.q = j3 + this.f34889k;
                zzleVar.f35082b = new zzv(zztVar);
                return -5;
            }
        }
        return iB;
    }

    public void H(boolean z, boolean z2) {
    }

    public void I(zzv[] zzvVarArr, long j2, long j3, zzwg zzwgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmk
    public int c() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void f() {
        zzgqa.f(this.f34886h == 0);
        D();
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void h(long j2, boolean z) {
        this.n = false;
        this.f34890l = j2;
        this.f34891m = j2;
        if (!z) {
            zzxw zzxwVar = this.f34887i;
            zzxwVar.getClass();
            z = zzxwVar.a(j2 - this.f34889k) != 0;
        }
        y(j2, false, z);
    }

    @Override // com.google.android.gms.internal.ads.zzmk
    public final void j() {
        synchronized (this.f34879a) {
            this.r = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void k(zzbf zzbfVar) {
        if (Objects.equals(this.p, zzbfVar)) {
            return;
        }
        this.p = zzbfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void l(zzml zzmlVar, zzv[] zzvVarArr, zzxw zzxwVar, boolean z, boolean z2, long j2, long j3, zzwg zzwgVar) {
        zzgqa.f(this.f34886h == 0);
        this.f34882d = zzmlVar;
        this.q = zzwgVar;
        this.f34886h = 1;
        H(z, z2);
        v(zzvVarArr, zzxwVar, j2, j3, zzwgVar);
        this.n = false;
        this.f34890l = j2;
        this.f34891m = j2;
        y(j2, z, true);
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void n(int i2, zzpn zzpnVar, zzfc zzfcVar) {
        this.f34883e = i2;
        this.f34884f = zzpnVar;
        this.f34885g = zzfcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void p() {
        zzgqa.f(this.f34886h == 1);
        this.f34886h = 2;
        z();
    }

    @Override // com.google.android.gms.internal.ads.zzmk
    public final void q(zzmj zzmjVar) {
        synchronized (this.f34879a) {
            this.r = zzmjVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public void u(int i2, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void v(zzv[] zzvVarArr, zzxw zzxwVar, long j2, long j3, zzwg zzwgVar) {
        zzgqa.f(!this.n);
        this.f34887i = zzxwVar;
        this.q = zzwgVar;
        if (this.f34891m == Long.MIN_VALUE) {
            this.f34891m = j2;
        }
        this.f34888j = zzvVarArr;
        this.f34889k = j3;
        I(zzvVarArr, j2, j3, zzwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final zzxw w() {
        return this.f34887i;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final boolean x() {
        return this.f34891m == Long.MIN_VALUE;
    }

    public void y(long j2, boolean z, boolean z2) {
        throw null;
    }

    public void z() {
    }

    @Override // com.google.android.gms.internal.ads.zzmi, com.google.android.gms.internal.ads.zzmk
    public final int zza() {
        return this.f34880b;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public zzlj zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final int zze() {
        return this.f34886h;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final long zzk() {
        return this.f34891m;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void zzl() {
        this.n = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final boolean zzm() {
        return this.n;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void zzn() {
        zzxw zzxwVar = this.f34887i;
        zzxwVar.getClass();
        zzxwVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void zzq() {
        zzgqa.f(this.f34886h == 2);
        this.f34886h = 1;
        A();
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void zzr() {
        zzgqa.f(this.f34886h == 1);
        zzle zzleVar = this.f34881c;
        zzleVar.f35081a = null;
        zzleVar.f35082b = null;
        this.f34886h = 0;
        this.f34887i = null;
        this.f34888j = null;
        this.n = false;
        B();
        this.q = null;
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final void zzs() {
        zzgqa.f(this.f34886h == 0);
        zzle zzleVar = this.f34881c;
        zzleVar.f35081a = null;
        zzleVar.f35082b = null;
        C();
    }

    public void A() {
    }

    public void D() {
    }

    @Override // com.google.android.gms.internal.ads.zzmi
    public final zzij zzb() {
        return this;
    }
}
