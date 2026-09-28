package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzye implements zzwe, zzwd {

    /* renamed from: a, reason: collision with root package name */
    public final zzwe f35899a;

    /* renamed from: b, reason: collision with root package name */
    public final long f35900b;

    /* renamed from: c, reason: collision with root package name */
    public zzwd f35901c;

    public zzye(zzwe zzweVar, long j2) {
        this.f35899a = zzweVar;
        this.f35900b = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long a(long j2) {
        zzwe zzweVar = this.f35899a;
        long j3 = this.f35900b;
        return zzweVar.a(j2 - j3) + j3;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean b(zzli zzliVar) {
        zzlh zzlhVar = new zzlh();
        zzlhVar.f35091b = zzliVar.f35094b;
        zzlhVar.f35092c = zzliVar.f35095c;
        zzlhVar.f35090a = zzliVar.f35093a - this.f35900b;
        return this.f35899a.b(new zzli(zzlhVar));
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void c(long j2) {
        this.f35899a.c(j2 - this.f35900b);
    }

    @Override // com.google.android.gms.internal.ads.zzwd
    public final void d(zzwe zzweVar) {
        zzwd zzwdVar = this.f35901c;
        zzwdVar.getClass();
        zzwdVar.d(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final /* bridge */ /* synthetic */ void e(zzxy zzxyVar) {
        zzwd zzwdVar = this.f35901c;
        zzwdVar.getClass();
        zzwdVar.e(this);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long f(zzzw[] zzzwVarArr, boolean[] zArr, zzxw[] zzxwVarArr, boolean[] zArr2, long j2) {
        zzxw[] zzxwVarArr2 = new zzxw[zzxwVarArr.length];
        int i2 = 0;
        while (true) {
            zzxw zzxwVar = null;
            if (i2 >= zzxwVarArr.length) {
                break;
            }
            zzyd zzydVar = (zzyd) zzxwVarArr[i2];
            if (zzydVar != null) {
                zzxwVar = zzydVar.f35897a;
            }
            zzxwVarArr2[i2] = zzxwVar;
            i2++;
        }
        long j3 = this.f35900b;
        long jF = this.f35899a.f(zzzwVarArr, zArr, zzxwVarArr2, zArr2, j2 - j3);
        for (int i3 = 0; i3 < zzxwVarArr.length; i3++) {
            zzxw zzxwVar2 = zzxwVarArr2[i3];
            if (zzxwVar2 == null) {
                zzxwVarArr[i3] = null;
            } else {
                zzxw zzxwVar3 = zzxwVarArr[i3];
                if (zzxwVar3 == null || ((zzyd) zzxwVar3).f35897a != zzxwVar2) {
                    zzxwVarArr[i3] = new zzyd(zzxwVar2, j3);
                }
            }
        }
        return jF + j3;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final void g(long j2) {
        this.f35899a.g(j2 - this.f35900b);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long i(long j2, zzmq zzmqVar) {
        zzwe zzweVar = this.f35899a;
        long j3 = this.f35900b;
        return zzweVar.i(j2 - j3, zzmqVar) + j3;
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void j(zzwd zzwdVar, long j2) {
        this.f35901c = zzwdVar;
        this.f35899a.j(this, j2 - this.f35900b);
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final void zzc() {
        this.f35899a.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final zzyh zzd() {
        return this.f35899a.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzwe
    public final long zzh() {
        long jZzh = this.f35899a.zzh();
        if (jZzh == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzh + this.f35900b;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzi() {
        long jZzi = this.f35899a.zzi();
        if (jZzi == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzi + this.f35900b;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final long zzl() {
        long jZzl = this.f35899a.zzl();
        if (jZzl == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzl + this.f35900b;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final boolean zzn() {
        return this.f35899a.zzn();
    }
}
