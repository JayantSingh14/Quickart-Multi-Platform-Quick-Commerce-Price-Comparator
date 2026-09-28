package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
abstract class zzafi {
    public abstract int a(Object obj);

    public abstract int b(Object obj);

    public abstract zzafj c(Object obj);

    public abstract zzafj d(Object obj);

    public abstract Object e(Object obj, Object obj2);

    public abstract zzafj f();

    public abstract Object g(Object obj);

    public abstract void h(Object obj, int i2, int i3);

    public abstract void i(Object obj, int i2, long j2);

    public abstract void j(Object obj, int i2, Object obj2);

    public abstract void k(Object obj, int i2, zzaby zzabyVar);

    public abstract void l(Object obj, int i2, long j2);

    public abstract void m(Object obj);

    public abstract void n(Object obj, Object obj2);

    public abstract void o(zzacz zzaczVar, Object obj);

    public abstract void p(Object obj, zzaga zzagaVar);

    public final boolean q(Object obj, zzacd zzacdVar) throws zzadi {
        int i2 = zzacdVar.f37374b;
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            l(obj, i3, zzacdVar.E());
            return true;
        }
        if (i4 == 1) {
            i(obj, i3, zzacdVar.D());
            return true;
        }
        if (i4 == 2) {
            k(obj, i3, zzacdVar.I());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw zzadi.a();
            }
            h(obj, i3, zzacdVar.y());
            return true;
        }
        zzafj zzafjVarF = f();
        int i5 = (i3 << 3) | 4;
        while (zzacdVar.w() != Integer.MAX_VALUE && q(zzafjVarF, zzacdVar)) {
        }
        if (i5 != zzacdVar.f37374b) {
            throw new zzadi("Protocol message end-group tag did not match expected tag.");
        }
        g(zzafjVarF);
        j(obj, i3, zzafjVarF);
        return true;
    }
}
