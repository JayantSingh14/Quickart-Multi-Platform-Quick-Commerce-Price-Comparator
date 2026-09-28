package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzafk extends zzafi {
    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* synthetic */ int a(Object obj) {
        return ((zzafj) obj).a();
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final int b(Object obj) {
        zzafj zzafjVar = (zzafj) obj;
        int i2 = zzafjVar.f37492d;
        if (i2 != -1) {
            return i2;
        }
        int iA = 0;
        for (int i3 = 0; i3 < zzafjVar.f37489a; i3++) {
            int i4 = zzafjVar.f37490b[i3];
            zzaby zzabyVar = (zzaby) zzafjVar.f37491c[i3];
            int iA2 = zzach.a(8);
            int iF = zzabyVar.f();
            iA += zzach.a(iF) + iF + zzach.a(24) + a.d(i4 >>> 3, zzach.a(16), iA2 + iA2);
        }
        zzafjVar.f37492d = iA;
        return iA;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* bridge */ /* synthetic */ zzafj c(Object obj) {
        zzacz zzaczVar = (zzacz) obj;
        zzafj zzafjVar = zzaczVar.zzc;
        if (zzafjVar != zzafj.f37488f) {
            return zzafjVar;
        }
        zzafj zzafjVarB = zzafj.b();
        zzaczVar.zzc = zzafjVarB;
        return zzafjVarB;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* synthetic */ zzafj d(Object obj) {
        return ((zzacz) obj).zzc;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final Object e(Object obj, Object obj2) {
        zzafj zzafjVar = (zzafj) obj2;
        if (zzafjVar.equals(zzafj.f37488f)) {
            return obj;
        }
        zzafj zzafjVar2 = (zzafj) obj;
        int i2 = zzafjVar2.f37489a + zzafjVar.f37489a;
        int[] iArrCopyOf = Arrays.copyOf(zzafjVar2.f37490b, i2);
        System.arraycopy(zzafjVar.f37490b, 0, iArrCopyOf, zzafjVar2.f37489a, zzafjVar.f37489a);
        Object[] objArrCopyOf = Arrays.copyOf(zzafjVar2.f37491c, i2);
        System.arraycopy(zzafjVar.f37491c, 0, objArrCopyOf, zzafjVar2.f37489a, zzafjVar.f37489a);
        return new zzafj(i2, iArrCopyOf, objArrCopyOf, true);
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* synthetic */ zzafj f() {
        return zzafj.b();
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final Object g(Object obj) {
        ((zzafj) obj).f37493e = false;
        return obj;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* bridge */ /* synthetic */ void h(Object obj, int i2, int i3) {
        ((zzafj) obj).c((i2 << 3) | 5, Integer.valueOf(i3));
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* bridge */ /* synthetic */ void i(Object obj, int i2, long j2) {
        ((zzafj) obj).c((i2 << 3) | 1, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* bridge */ /* synthetic */ void j(Object obj, int i2, Object obj2) {
        ((zzafj) obj).c((i2 << 3) | 3, obj2);
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* bridge */ /* synthetic */ void k(Object obj, int i2, zzaby zzabyVar) {
        ((zzafj) obj).c((i2 << 3) | 2, zzabyVar);
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* bridge */ /* synthetic */ void l(Object obj, int i2, long j2) {
        ((zzafj) obj).c(i2 << 3, Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final void m(Object obj) {
        ((zzacz) obj).zzc.f37493e = false;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* synthetic */ void n(Object obj, Object obj2) {
        ((zzacz) obj).zzc = (zzafj) obj2;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* synthetic */ void o(zzacz zzaczVar, Object obj) {
        zzaczVar.zzc = (zzafj) obj;
    }

    @Override // com.google.android.gms.internal.pal.zzafi
    public final /* synthetic */ void p(Object obj, zzaga zzagaVar) {
        ((zzafj) obj).d(zzagaVar);
    }
}
