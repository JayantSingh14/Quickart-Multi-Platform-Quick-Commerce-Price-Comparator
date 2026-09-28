package com.google.android.gms.internal.ads;

import android.os.Looper;

/* loaded from: classes4.dex */
public final class zzxo extends zzvf implements zzxc {

    /* renamed from: h, reason: collision with root package name */
    public final zzha f35849h;

    /* renamed from: i, reason: collision with root package name */
    public final zzwy f35850i;

    /* renamed from: j, reason: collision with root package name */
    public final zztk f35851j;

    /* renamed from: k, reason: collision with root package name */
    public final int f35852k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f35853l;

    /* renamed from: m, reason: collision with root package name */
    public long f35854m;
    public boolean n;
    public boolean o;
    public zzhz p;
    public zzak q;

    public /* synthetic */ zzxo(zzak zzakVar, zzha zzhaVar, zzwy zzwyVar, zzaaq zzaaqVar, int i2) {
        zztk zztkVar = zztk.f35588a;
        this.q = zzakVar;
        this.f35849h = zzhaVar;
        this.f35850i = zzwyVar;
        this.f35851j = zztkVar;
        this.f35852k = i2;
        this.f35853l = true;
        this.f35854m = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final synchronized zzak a() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void f() {
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final synchronized void g(zzak zzakVar) {
        this.q = zzakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void k(zzwe zzweVar) {
        zzxk zzxkVar = (zzxk) zzweVar;
        if (zzxkVar.u) {
            for (zzxv zzxvVar : zzxkVar.r) {
                zzxvVar.n();
                if (zzxvVar.f35877g != null) {
                    zzxvVar.f35877g = null;
                    zzxvVar.f35876f = null;
                }
            }
        }
        zzaaz zzaazVar = zzxkVar.f35840j;
        zzaau zzaauVar = zzaazVar.f22625b;
        if (zzaauVar != null) {
            zzaauVar.a(true);
        }
        zzabe zzabeVar = (zzabe) zzaazVar.f22624a;
        zzabeVar.execute(new zzaax(zzxkVar));
        zzabeVar.f22640a.shutdown();
        zzxkVar.o.removeCallbacksAndMessages(null);
        zzxkVar.p = null;
        zzxkVar.M = true;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final zzwe l(zzwg zzwgVar, zzaah zzaahVar, long j2) {
        zzhb zzhbVarZza = this.f35849h.zza();
        zzhz zzhzVar = this.p;
        if (zzhzVar != null) {
            zzhbVarZza.c(zzhzVar);
        }
        zzag zzagVar = a().f23332b;
        zzagVar.getClass();
        this.f35702g.getClass();
        zzvi zzviVar = new zzvi(((zzxm) this.f35850i).f35844a);
        zztf zztfVar = new zztf(this.f35699d.f35585b, zzwgVar);
        zzwq zzwqVar = new zzwq(this.f35698c.f35785b, zzwgVar);
        long jS = zzfj.s(-9223372036854775807L);
        return new zzxk(zzagVar.f22978a, zzhbVarZza, zzviVar, this.f35851j, zztfVar, zzwqVar, this, zzaahVar, this.f35852k, jS);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void p(zzhz zzhzVar) {
        this.p = zzhzVar;
        Looper.myLooper().getClass();
        this.f35702g.getClass();
        u();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void r() {
    }

    public final void t(long j2, zzafr zzafrVar, boolean z) {
        if (j2 == -9223372036854775807L) {
            j2 = this.f35854m;
        }
        boolean zZzb = zzafrVar.zzb();
        if (!this.f35853l && this.f35854m == j2 && this.n == zZzb && this.o == z) {
            return;
        }
        this.f35854m = j2;
        this.n = zZzb;
        this.o = z;
        this.f35853l = false;
        u();
    }

    public final void u() {
        long j2 = this.f35854m;
        boolean z = this.n;
        boolean z2 = this.o;
        zzak zzakVarA = a();
        zzbf zzyaVar = new zzya(j2, j2, z, zzakVarA, z2 ? zzakVarA.f23333c : null);
        if (this.f35853l) {
            zzyaVar = new zzxl(zzyaVar);
        }
        s(zzyaVar);
    }
}
