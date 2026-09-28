package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzvy implements zzwe, zzwd {

    /* renamed from: a, reason: collision with root package name */
    public final zzwg f35741a;

    /* renamed from: b, reason: collision with root package name */
    public final long f35742b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaah f35743c;

    /* renamed from: d, reason: collision with root package name */
    public zzwi f35744d;

    /* renamed from: e, reason: collision with root package name */
    public zzwe f35745e;

    /* renamed from: f, reason: collision with root package name */
    public zzwd f35746f;

    /* renamed from: g, reason: collision with root package name */
    public long f35747g = -9223372036854775807L;

    public zzvy(zzwg zzwgVar, zzaah zzaahVar, long j2) {
        this.f35741a = zzwgVar;
        this.f35743c = zzaahVar;
        this.f35742b = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long a(long j2) {
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        return zzweVar.a(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean b(zzli zzliVar) {
        zzwe zzweVar = this.f35745e;
        return zzweVar != null && zzweVar.b(zzliVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void c(long j2) {
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        zzweVar.c(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final void d(zzwe zzweVar) {
        zzwd zzwdVar = this.f35746f;
        String str = zzfj.f31254a;
        zzwdVar.d(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final /* bridge */ /* synthetic */ void e(zzxy zzxyVar) {
        zzwd zzwdVar = this.f35746f;
        String str = zzfj.f31254a;
        zzwdVar.e(this);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long f(zzzw[] zzzwVarArr, boolean[] zArr, zzxw[] zzxwVarArr, boolean[] zArr2, long j2) {
        long j3 = this.f35747g;
        long j4 = (j3 == -9223372036854775807L || j2 != this.f35742b) ? j2 : j3;
        this.f35747g = -9223372036854775807L;
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        return zzweVar.f(zzzwVarArr, zArr, zzxwVarArr, zArr2, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void g(long j2) {
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        zzweVar.g(j2);
    }

    public final void h(zzwg zzwgVar) {
        long j2 = this.f35747g;
        if (j2 == -9223372036854775807L) {
            j2 = this.f35742b;
        }
        zzwi zzwiVar = this.f35744d;
        zzwiVar.getClass();
        zzwe zzweVarL = zzwiVar.l(zzwgVar, this.f35743c, j2);
        this.f35745e = zzweVarL;
        if (this.f35746f != null) {
            zzweVarL.j(this, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long i(long j2, zzmq zzmqVar) {
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        return zzweVar.i(j2, zzmqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void j(zzwd zzwdVar, long j2) {
        this.f35746f = zzwdVar;
        zzwe zzweVar = this.f35745e;
        if (zzweVar != null) {
            long j3 = this.f35747g;
            if (j3 == -9223372036854775807L) {
                j3 = this.f35742b;
            }
            zzweVar.j(this, j3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void zzc() {
        zzwe zzweVar = this.f35745e;
        if (zzweVar != null) {
            zzweVar.zzc();
            return;
        }
        zzwi zzwiVar = this.f35744d;
        if (zzwiVar != null) {
            zzwiVar.f();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final zzyh zzd() {
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        return zzweVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long zzh() {
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        return zzweVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzi() {
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        return zzweVar.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzl() {
        zzwe zzweVar = this.f35745e;
        String str = zzfj.f31254a;
        return zzweVar.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean zzn() {
        zzwe zzweVar = this.f35745e;
        return zzweVar != null && zzweVar.zzn();
    }
}
