package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzvk implements zzwe, zzwd {

    /* renamed from: a, reason: collision with root package name */
    public final zzvy f35710a;

    /* renamed from: b, reason: collision with root package name */
    public zzwd f35711b;

    /* renamed from: c, reason: collision with root package name */
    public zzvj[] f35712c = new zzvj[0];

    /* renamed from: d, reason: collision with root package name */
    public long f35713d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f35714e;

    public zzvk(zzvy zzvyVar, long j2) {
        this.f35710a = zzvyVar;
        this.f35714e = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long a(long j2) {
        this.f35713d = -9223372036854775807L;
        for (zzvj zzvjVar : this.f35712c) {
            if (zzvjVar != null) {
                zzvjVar.f35708b = false;
            }
        }
        long jA = this.f35710a.a(j2);
        long j3 = this.f35714e;
        long jMax = Math.max(jA, 0L);
        return j3 != Long.MIN_VALUE ? Math.min(jMax, j3) : jMax;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean b(zzli zzliVar) {
        return this.f35710a.b(zzliVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void c(long j2) {
        this.f35710a.c(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final void d(zzwe zzweVar) {
        zzwd zzwdVar = this.f35711b;
        zzwdVar.getClass();
        zzwdVar.d(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final /* bridge */ /* synthetic */ void e(zzxy zzxyVar) {
        zzwd zzwdVar = this.f35711b;
        zzwdVar.getClass();
        zzwdVar.e(this);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long f(zzzw[] zzzwVarArr, boolean[] zArr, zzxw[] zzxwVarArr, boolean[] zArr2, long j2) {
        int length = zzxwVarArr.length;
        this.f35712c = new zzvj[length];
        zzxw[] zzxwVarArr2 = new zzxw[length];
        for (int i2 = 0; i2 < zzxwVarArr.length; i2++) {
            zzvj[] zzvjVarArr = this.f35712c;
            zzvj zzvjVar = (zzvj) zzxwVarArr[i2];
            zzvjVarArr[i2] = zzvjVar;
            zzxwVarArr2[i2] = zzvjVar != null ? zzvjVar.f35707a : null;
        }
        long jF = this.f35710a.f(zzzwVarArr, zArr, zzxwVarArr2, zArr2, j2);
        long j3 = this.f35714e;
        long jMax = Math.max(jF, j2);
        if (j3 != Long.MIN_VALUE) {
            jMax = Math.min(jMax, j3);
        }
        long j4 = -9223372036854775807L;
        if (h()) {
            if (jF < j2) {
                j4 = jMax;
                break;
            }
            if (jF != 0) {
                for (zzzw zzzwVar : zzzwVarArr) {
                    if (zzzwVar != null) {
                        zzv zzvVarZzc = zzzwVar.zzc();
                        if (!zzas.d(zzvVarZzc.f35691m, zzvVarZzc.f35688j)) {
                            j4 = jMax;
                            break;
                        }
                    }
                }
            }
        }
        this.f35713d = j4;
        for (int i3 = 0; i3 < zzxwVarArr.length; i3++) {
            zzxw zzxwVar = zzxwVarArr2[i3];
            if (zzxwVar == null) {
                this.f35712c[i3] = null;
            } else {
                zzvj[] zzvjVarArr2 = this.f35712c;
                zzvj zzvjVar2 = zzvjVarArr2[i3];
                if (zzvjVar2 == null || zzvjVar2.f35707a != zzxwVar) {
                    zzvjVarArr2[i3] = new zzvj(this, zzxwVar);
                }
            }
            zzxwVarArr[i3] = this.f35712c[i3];
        }
        return jMax;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void g(long j2) {
        this.f35710a.g(j2);
    }

    public final boolean h() {
        return this.f35713d != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long i(long j2, zzmq zzmqVar) {
        if (j2 == 0) {
            return 0L;
        }
        long j3 = zzmqVar.f35223a;
        String str = zzfj.f31254a;
        long jMax = Math.max(0L, Math.min(j3, j2));
        long j4 = this.f35714e;
        long j5 = j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j2;
        long j6 = zzmqVar.f35224b;
        long jMax2 = Math.max(0L, Math.min(j6, j5));
        if (jMax != j3 || jMax2 != j6) {
            zzmqVar = new zzmq(jMax, jMax2);
        }
        return this.f35710a.i(j2, zzmqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void j(zzwd zzwdVar, long j2) {
        this.f35711b = zzwdVar;
        this.f35710a.j(this, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void zzc() {
        this.f35710a.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final zzyh zzd() {
        return this.f35710a.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long zzh() {
        if (h()) {
            long j2 = this.f35713d;
            this.f35713d = -9223372036854775807L;
            long jZzh = zzh();
            return jZzh != -9223372036854775807L ? jZzh : j2;
        }
        long jZzh2 = this.f35710a.zzh();
        if (jZzh2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = this.f35714e;
        long jMax = Math.max(jZzh2, 0L);
        return j3 != Long.MIN_VALUE ? Math.min(jMax, j3) : jMax;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzi() {
        long jZzi = this.f35710a.zzi();
        if (jZzi != Long.MIN_VALUE) {
            long j2 = this.f35714e;
            if (j2 == Long.MIN_VALUE || jZzi < j2) {
                return jZzi;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzl() {
        long jZzl = this.f35710a.zzl();
        if (jZzl != Long.MIN_VALUE) {
            long j2 = this.f35714e;
            if (j2 == Long.MIN_VALUE || jZzl < j2) {
                return jZzl;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean zzn() {
        return this.f35710a.zzn();
    }
}
