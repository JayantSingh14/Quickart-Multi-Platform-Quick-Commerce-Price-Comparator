package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzwb extends zzyj {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f35752l;

    /* renamed from: m, reason: collision with root package name */
    public final zzbe f35753m;
    public final zzbd n;
    public zzvz o;
    public zzvy p;
    public boolean q;
    public boolean r;
    public boolean s;

    public zzwb(zzwi zzwiVar, boolean z) {
        boolean z2;
        super(zzwiVar);
        if (z) {
            zzwiVar.U();
            z2 = true;
        } else {
            z2 = false;
        }
        this.f35752l = z2;
        this.f35753m = new zzbe();
        this.n = new zzbd();
        zzwiVar.m();
        this.o = new zzvz(new zzwa(zzwiVar.a()), zzbe.f24822m, zzvz.f35748e);
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final zzwg A(zzwg zzwgVar) {
        Object obj = this.o.f35750d;
        Object obj2 = zzwgVar.f35758a;
        if (obj != null && obj.equals(obj2)) {
            obj2 = zzvz.f35748e;
        }
        return zzwgVar.a(obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzyj, com.google.android.gms.internal.ads.zzwi
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final zzvy l(zzwg zzwgVar, zzaah zzaahVar, long j2) {
        zzvy zzvyVar = new zzvy(zzwgVar, zzaahVar, j2);
        zzgqa.f(zzvyVar.f35744d == null);
        zzwi zzwiVar = this.f35909k;
        zzvyVar.f35744d = zzwiVar;
        if (!this.r) {
            this.p = zzvyVar;
            if (!this.q) {
                this.q = true;
                u(null, zzwiVar);
            }
            return zzvyVar;
        }
        Object obj = this.o.f35750d;
        Object obj2 = zzwgVar.f35758a;
        if (obj != null && obj2.equals(zzvz.f35748e)) {
            obj2 = this.o.f35750d;
        }
        zzvyVar.h(zzwgVar.a(obj2));
        return zzvyVar;
    }

    public final boolean C(long j2) {
        zzvy zzvyVar = this.p;
        int iE = this.o.e(zzvyVar.f35741a.f35758a);
        if (iE == -1) {
            return false;
        }
        zzvz zzvzVar = this.o;
        zzbd zzbdVar = this.n;
        zzvzVar.d(iE, zzbdVar, false);
        long j3 = zzbdVar.f24740d;
        if (j3 != -9223372036854775807L && j2 >= j3) {
            j2 = Math.max(0L, j3 - 1);
        }
        zzvyVar.f35747g = j2;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void g(zzak zzakVar) {
        if (this.s) {
            zzvz zzvzVar = this.o;
            this.o = new zzvz(new zzyf(this.o.f35734b, zzakVar), zzvzVar.f35749c, zzvzVar.f35750d);
        } else {
            this.o = new zzvz(new zzwa(zzakVar), zzbe.f24822m, zzvz.f35748e);
        }
        this.f35909k.g(zzakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyj, com.google.android.gms.internal.ads.zzwi
    public final void k(zzwe zzweVar) {
        zzvy zzvyVar = (zzvy) zzweVar;
        zzwe zzweVar2 = zzvyVar.f35745e;
        if (zzweVar2 != null) {
            zzwi zzwiVar = zzvyVar.f35744d;
            zzwiVar.getClass();
            zzwiVar.k(zzweVar2);
        }
        if (zzweVar == this.p) {
            this.p = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvo, com.google.android.gms.internal.ads.zzvf
    public final void r() {
        this.r = false;
        this.q = false;
        super.r();
    }

    @Override // com.google.android.gms.internal.ads.zzyj
    public final void y() {
        if (this.f35752l) {
            return;
        }
        this.q = true;
        u(null, this.f35909k);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    @Override // com.google.android.gms.internal.ads.zzyj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(com.google.android.gms.internal.ads.zzbf r11) {
        /*
            r10 = this;
            boolean r0 = r10.r
            r1 = 0
            if (r0 == 0) goto L1d
            com.google.android.gms.internal.ads.zzvz r0 = r10.o
            com.google.android.gms.internal.ads.zzvz r2 = new com.google.android.gms.internal.ads.zzvz
            java.lang.Object r3 = r0.f35749c
            java.lang.Object r0 = r0.f35750d
            r2.<init>(r11, r3, r0)
            r10.o = r2
            com.google.android.gms.internal.ads.zzvy r11 = r10.p
            if (r11 == 0) goto Lb5
            long r2 = r11.f35747g
            r10.C(r2)
            goto Lb5
        L1d:
            boolean r0 = r11.g()
            if (r0 == 0) goto L41
            boolean r0 = r10.s
            if (r0 == 0) goto L33
            com.google.android.gms.internal.ads.zzvz r0 = r10.o
            com.google.android.gms.internal.ads.zzvz r2 = new com.google.android.gms.internal.ads.zzvz
            java.lang.Object r3 = r0.f35749c
            java.lang.Object r0 = r0.f35750d
            r2.<init>(r11, r3, r0)
            goto L3d
        L33:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbe.f24822m
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzvz.f35748e
            com.google.android.gms.internal.ads.zzvz r3 = new com.google.android.gms.internal.ads.zzvz
            r3.<init>(r11, r0, r2)
            r2 = r3
        L3d:
            r10.o = r2
            goto Lb5
        L41:
            r0 = 0
            com.google.android.gms.internal.ads.zzbe r3 = r10.f35753m
            r4 = 0
            r11.b(r0, r3, r4)
            java.lang.Object r8 = r3.f24823a
            com.google.android.gms.internal.ads.zzvy r2 = r10.p
            if (r2 == 0) goto L66
            com.google.android.gms.internal.ads.zzvz r6 = r10.o
            com.google.android.gms.internal.ads.zzwg r7 = r2.f35741a
            java.lang.Object r7 = r7.f35758a
            com.google.android.gms.internal.ads.zzbd r9 = r10.n
            r6.o(r7, r9)
            com.google.android.gms.internal.ads.zzvz r6 = r10.o
            r6.b(r0, r3, r4)
            long r6 = r2.f35742b
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L66
            goto L67
        L66:
            r6 = r4
        L67:
            com.google.android.gms.internal.ads.zzbd r4 = r10.n
            r5 = 0
            r2 = r11
            android.util.Pair r11 = r2.m(r3, r4, r5, r6)
            java.lang.Object r0 = r11.first
            java.lang.Object r11 = r11.second
            java.lang.Long r11 = (java.lang.Long) r11
            long r3 = r11.longValue()
            boolean r11 = r10.s
            if (r11 == 0) goto L89
            com.google.android.gms.internal.ads.zzvz r11 = r10.o
            com.google.android.gms.internal.ads.zzvz r0 = new com.google.android.gms.internal.ads.zzvz
            java.lang.Object r5 = r11.f35749c
            java.lang.Object r11 = r11.f35750d
            r0.<init>(r2, r5, r11)
            goto L8f
        L89:
            com.google.android.gms.internal.ads.zzvz r11 = new com.google.android.gms.internal.ads.zzvz
            r11.<init>(r2, r8, r0)
            r0 = r11
        L8f:
            r10.o = r0
            com.google.android.gms.internal.ads.zzvy r11 = r10.p
            if (r11 == 0) goto Lb5
            boolean r0 = r10.C(r3)
            if (r0 == 0) goto Lb5
            com.google.android.gms.internal.ads.zzwg r11 = r11.f35741a
            com.google.android.gms.internal.ads.zzvz r0 = r10.o
            java.lang.Object r0 = r0.f35750d
            java.lang.Object r1 = r11.f35758a
            if (r0 == 0) goto Lb1
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzvz.f35748e
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto Lb1
            com.google.android.gms.internal.ads.zzvz r0 = r10.o
            java.lang.Object r1 = r0.f35750d
        Lb1:
            com.google.android.gms.internal.ads.zzwg r1 = r11.a(r1)
        Lb5:
            r11 = 1
            r10.s = r11
            r10.r = r11
            com.google.android.gms.internal.ads.zzvz r11 = r10.o
            r10.s(r11)
            if (r1 == 0) goto Lc9
            com.google.android.gms.internal.ads.zzvy r11 = r10.p
            r11.getClass()
            r11.h(r1)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwb.z(com.google.android.gms.internal.ads.zzbf):void");
    }
}
