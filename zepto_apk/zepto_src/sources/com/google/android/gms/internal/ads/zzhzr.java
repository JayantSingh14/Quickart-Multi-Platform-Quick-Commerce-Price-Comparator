package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
final class zzhzr implements zzicp {

    /* renamed from: a, reason: collision with root package name */
    public final zzhzq f34592a;

    /* renamed from: b, reason: collision with root package name */
    public int f34593b;

    /* renamed from: c, reason: collision with root package name */
    public int f34594c;

    /* renamed from: d, reason: collision with root package name */
    public int f34595d = 0;

    public zzhzr(zzhzq zzhzqVar) {
        Charset charset = zzibe.f34660a;
        if (zzhzqVar == null) {
            throw new NullPointerException("input");
        }
        this.f34592a = zzhzqVar;
        zzhzqVar.f34591c = this;
    }

    public static final void v(int i2) throws zzibg {
        if ((i2 & 3) != 0) {
            throw new zzibg("Failed to parse the message.");
        }
    }

    public static final void w(int i2) throws zzibg {
        if ((i2 & 7) != 0) {
            throw new zzibg("Failed to parse the message.");
        }
    }

    public static zzhzr x(zzhzq zzhzqVar) {
        Object obj = zzhzqVar.f34591c;
        return obj != null ? (zzhzr) obj : new zzhzr(zzhzqVar);
    }

    public final float A() throws zzibf {
        q(5);
        return this.f34592a.l();
    }

    public final long B() throws zzibf {
        q(0);
        return this.f34592a.m();
    }

    public final long C() throws zzibf {
        q(0);
        return this.f34592a.n();
    }

    public final int D() throws zzibf {
        q(0);
        return this.f34592a.o();
    }

    public final long E() throws zzibf {
        q(1);
        return this.f34592a.p();
    }

    public final int F() throws zzibf {
        q(5);
        return this.f34592a.q();
    }

    public final boolean G() throws zzibf {
        q(0);
        return this.f34592a.r();
    }

    public final String H() throws zzibf {
        q(2);
        return this.f34592a.s();
    }

    public final String I() throws zzibf {
        q(2);
        return this.f34592a.t();
    }

    public final void J(zzicc zziccVar, zzicu zzicuVar, zziab zziabVar) throws zzibg {
        q(2);
        r(zziccVar, zzicuVar, zziabVar);
    }

    public final void K(zzicc zziccVar, zzicu zzicuVar, zziab zziabVar) throws zzibf {
        q(3);
        s(zziccVar, zzicuVar, zziabVar);
    }

    public final zzhzl L() throws zzibf {
        q(2);
        return this.f34592a.u();
    }

    public final int M() throws zzibf {
        q(0);
        return this.f34592a.v();
    }

    public final int N() throws zzibf {
        q(0);
        return this.f34592a.w();
    }

    public final int O() throws zzibf {
        q(5);
        return this.f34592a.x();
    }

    public final long P() throws zzibf {
        q(1);
        return this.f34592a.y();
    }

    public final int Q() throws zzibf {
        q(0);
        return this.f34592a.z();
    }

    public final long R() throws zzibf {
        q(0);
        return this.f34592a.A();
    }

    public final void S(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzhzy;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzhzy zzhzyVar = (zzhzy) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iV = zzhzqVar.v();
                w(iV);
                int iC = zzhzqVar.c() + iV;
                do {
                    zzhzyVar.d(zzhzqVar.k());
                } while (zzhzqVar.c() < iC);
                return;
            }
            do {
                zzhzyVar.d(zzhzqVar.k());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iV2 = zzhzqVar.v();
                w(iV2);
                int iC2 = zzhzqVar.c() + iV2;
                do {
                    zzibdVar.add(Double.valueOf(zzhzqVar.k()));
                } while (zzhzqVar.c() < iC2);
                return;
            }
            do {
                zzibdVar.add(Double.valueOf(zzhzqVar.k()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void T(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zziai;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zziai zziaiVar = (zziai) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 == 2) {
                int iV = zzhzqVar.v();
                v(iV);
                int iC = zzhzqVar.c() + iV;
                do {
                    zziaiVar.d(zzhzqVar.l());
                } while (zzhzqVar.c() < iC);
                return;
            }
            if (i2 != 5) {
                throw new zzibf();
            }
            do {
                zziaiVar.d(zzhzqVar.l());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 == 2) {
                int iV2 = zzhzqVar.v();
                v(iV2);
                int iC2 = zzhzqVar.c() + iV2;
                do {
                    zzibdVar.add(Float.valueOf(zzhzqVar.l()));
                } while (zzhzqVar.c() < iC2);
                return;
            }
            if (i3 != 5) {
                throw new zzibf();
            }
            do {
                zzibdVar.add(Float.valueOf(zzhzqVar.l()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void U(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzibq;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzibq zzibqVar = (zzibq) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iC = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibqVar.h(zzhzqVar.m());
                } while (zzhzqVar.c() < iC);
                u(iC);
                return;
            }
            do {
                zzibqVar.h(zzhzqVar.m());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iC2 = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibdVar.add(Long.valueOf(zzhzqVar.m()));
                } while (zzhzqVar.c() < iC2);
                u(iC2);
                return;
            }
            do {
                zzibdVar.add(Long.valueOf(zzhzqVar.m()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void a(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzibq;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzibq zzibqVar = (zzibq) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iC = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibqVar.h(zzhzqVar.n());
                } while (zzhzqVar.c() < iC);
                u(iC);
                return;
            }
            do {
                zzibqVar.h(zzhzqVar.n());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iC2 = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibdVar.add(Long.valueOf(zzhzqVar.n()));
                } while (zzhzqVar.c() < iC2);
                u(iC2);
                return;
            }
            do {
                zzibdVar.add(Long.valueOf(zzhzqVar.n()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void b(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzias;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzias zziasVar = (zzias) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iC = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zziasVar.zzi(zzhzqVar.o());
                } while (zzhzqVar.c() < iC);
                u(iC);
                return;
            }
            do {
                zziasVar.zzi(zzhzqVar.o());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iC2 = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibdVar.add(Integer.valueOf(zzhzqVar.o()));
                } while (zzhzqVar.c() < iC2);
                u(iC2);
                return;
            }
            do {
                zzibdVar.add(Integer.valueOf(zzhzqVar.o()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void c(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzibq;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzibq zzibqVar = (zzibq) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iV = zzhzqVar.v();
                w(iV);
                int iC = zzhzqVar.c() + iV;
                do {
                    zzibqVar.h(zzhzqVar.p());
                } while (zzhzqVar.c() < iC);
                return;
            }
            do {
                zzibqVar.h(zzhzqVar.p());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iV2 = zzhzqVar.v();
                w(iV2);
                int iC2 = zzhzqVar.c() + iV2;
                do {
                    zzibdVar.add(Long.valueOf(zzhzqVar.p()));
                } while (zzhzqVar.c() < iC2);
                return;
            }
            do {
                zzibdVar.add(Long.valueOf(zzhzqVar.p()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void d(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzias;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzias zziasVar = (zzias) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 == 2) {
                int iV = zzhzqVar.v();
                v(iV);
                int iC = zzhzqVar.c() + iV;
                do {
                    zziasVar.zzi(zzhzqVar.q());
                } while (zzhzqVar.c() < iC);
                return;
            }
            if (i2 != 5) {
                throw new zzibf();
            }
            do {
                zziasVar.zzi(zzhzqVar.q());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 == 2) {
                int iV2 = zzhzqVar.v();
                v(iV2);
                int iC2 = zzhzqVar.c() + iV2;
                do {
                    zzibdVar.add(Integer.valueOf(zzhzqVar.q()));
                } while (zzhzqVar.c() < iC2);
                return;
            }
            if (i3 != 5) {
                throw new zzibf();
            }
            do {
                zzibdVar.add(Integer.valueOf(zzhzqVar.q()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void e(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzhzb;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzhzb zzhzbVar = (zzhzb) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iC = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzhzbVar.d(zzhzqVar.r());
                } while (zzhzqVar.c() < iC);
                u(iC);
                return;
            }
            do {
                zzhzbVar.d(zzhzqVar.r());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iC2 = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibdVar.add(Boolean.valueOf(zzhzqVar.r()));
                } while (zzhzqVar.c() < iC2);
                u(iC2);
                return;
            }
            do {
                zzibdVar.add(Boolean.valueOf(zzhzqVar.r()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void f(zzibd zzibdVar, boolean z) throws zzibf {
        int iH;
        int iH2;
        if ((this.f34593b & 7) != 2) {
            throw new zzibf();
        }
        boolean z2 = zzibdVar instanceof zzibn;
        zzhzq zzhzqVar = this.f34592a;
        if (z2 && !z) {
            zzibn zzibnVar = (zzibn) zzibdVar;
            do {
                L();
                zzibnVar.zzb();
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            do {
                zzibdVar.add(z ? I() : H());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void g(zzibd zzibdVar, zzicu zzicuVar, zziab zziabVar) throws zzibg {
        int iH;
        int i2 = this.f34593b;
        if ((i2 & 7) != 2) {
            throw new zzibf();
        }
        do {
            Object objZza = zzicuVar.zza();
            r(objZza, zzicuVar, zziabVar);
            zzicuVar.b(objZza);
            zzibdVar.add(objZza);
            zzhzq zzhzqVar = this.f34592a;
            if (zzhzqVar.b() || this.f34595d != 0) {
                return;
            } else {
                iH = zzhzqVar.h();
            }
        } while (iH == i2);
        this.f34595d = iH;
    }

    public final void h(zzibd zzibdVar, zzicu zzicuVar, zziab zziabVar) throws zzibf {
        int iH;
        int i2 = this.f34593b;
        if ((i2 & 7) != 3) {
            throw new zzibf();
        }
        do {
            Object objZza = zzicuVar.zza();
            s(objZza, zzicuVar, zziabVar);
            zzicuVar.b(objZza);
            zzibdVar.add(objZza);
            zzhzq zzhzqVar = this.f34592a;
            if (zzhzqVar.b() || this.f34595d != 0) {
                return;
            } else {
                iH = zzhzqVar.h();
            }
        } while (iH == i2);
        this.f34595d = iH;
    }

    public final void i(zzibd zzibdVar) throws zzibf {
        int iH;
        if ((this.f34593b & 7) != 2) {
            throw new zzibf();
        }
        do {
            zzibdVar.add(L());
            zzhzq zzhzqVar = this.f34592a;
            if (zzhzqVar.b()) {
                return;
            } else {
                iH = zzhzqVar.h();
            }
        } while (iH == this.f34593b);
        this.f34595d = iH;
    }

    public final void j(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzias;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzias zziasVar = (zzias) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iC = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zziasVar.zzi(zzhzqVar.v());
                } while (zzhzqVar.c() < iC);
                u(iC);
                return;
            }
            do {
                zziasVar.zzi(zzhzqVar.v());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iC2 = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibdVar.add(Integer.valueOf(zzhzqVar.v()));
                } while (zzhzqVar.c() < iC2);
                u(iC2);
                return;
            }
            do {
                zzibdVar.add(Integer.valueOf(zzhzqVar.v()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void k(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzias;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzias zziasVar = (zzias) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iC = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zziasVar.zzi(zzhzqVar.w());
                } while (zzhzqVar.c() < iC);
                u(iC);
                return;
            }
            do {
                zziasVar.zzi(zzhzqVar.w());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iC2 = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibdVar.add(Integer.valueOf(zzhzqVar.w()));
                } while (zzhzqVar.c() < iC2);
                u(iC2);
                return;
            }
            do {
                zzibdVar.add(Integer.valueOf(zzhzqVar.w()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void l(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzias;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzias zziasVar = (zzias) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 == 2) {
                int iV = zzhzqVar.v();
                v(iV);
                int iC = zzhzqVar.c() + iV;
                do {
                    zziasVar.zzi(zzhzqVar.x());
                } while (zzhzqVar.c() < iC);
                return;
            }
            if (i2 != 5) {
                throw new zzibf();
            }
            do {
                zziasVar.zzi(zzhzqVar.x());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 == 2) {
                int iV2 = zzhzqVar.v();
                v(iV2);
                int iC2 = zzhzqVar.c() + iV2;
                do {
                    zzibdVar.add(Integer.valueOf(zzhzqVar.x()));
                } while (zzhzqVar.c() < iC2);
                return;
            }
            if (i3 != 5) {
                throw new zzibf();
            }
            do {
                zzibdVar.add(Integer.valueOf(zzhzqVar.x()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void m(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzibq;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzibq zzibqVar = (zzibq) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iV = zzhzqVar.v();
                w(iV);
                int iC = zzhzqVar.c() + iV;
                do {
                    zzibqVar.h(zzhzqVar.y());
                } while (zzhzqVar.c() < iC);
                return;
            }
            do {
                zzibqVar.h(zzhzqVar.y());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iV2 = zzhzqVar.v();
                w(iV2);
                int iC2 = zzhzqVar.c() + iV2;
                do {
                    zzibdVar.add(Long.valueOf(zzhzqVar.y()));
                } while (zzhzqVar.c() < iC2);
                return;
            }
            do {
                zzibdVar.add(Long.valueOf(zzhzqVar.y()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void n(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzias;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzias zziasVar = (zzias) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iC = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zziasVar.zzi(zzhzqVar.z());
                } while (zzhzqVar.c() < iC);
                u(iC);
                return;
            }
            do {
                zziasVar.zzi(zzhzqVar.z());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iC2 = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibdVar.add(Integer.valueOf(zzhzqVar.z()));
                } while (zzhzqVar.c() < iC2);
                u(iC2);
                return;
            }
            do {
                zzibdVar.add(Integer.valueOf(zzhzqVar.z()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    public final void o(zzibd zzibdVar) throws zzibg {
        int iH;
        int iH2;
        boolean z = zzibdVar instanceof zzibq;
        zzhzq zzhzqVar = this.f34592a;
        if (z) {
            zzibq zzibqVar = (zzibq) zzibdVar;
            int i2 = this.f34593b & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new zzibf();
                }
                int iC = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibqVar.h(zzhzqVar.A());
                } while (zzhzqVar.c() < iC);
                u(iC);
                return;
            }
            do {
                zzibqVar.h(zzhzqVar.A());
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH2 = zzhzqVar.h();
                }
            } while (iH2 == this.f34593b);
        } else {
            int i3 = this.f34593b & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new zzibf();
                }
                int iC2 = zzhzqVar.c() + zzhzqVar.v();
                do {
                    zzibdVar.add(Long.valueOf(zzhzqVar.A()));
                } while (zzhzqVar.c() < iC2);
                u(iC2);
                return;
            }
            do {
                zzibdVar.add(Long.valueOf(zzhzqVar.A()));
                if (zzhzqVar.b()) {
                    return;
                } else {
                    iH = zzhzqVar.h();
                }
            } while (iH == this.f34593b);
            iH2 = iH;
        }
        this.f34595d = iH2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0078, code lost:
    
        r12.put(r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
    
        r1.a(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(com.google.android.gms.internal.ads.zzibw r12, com.google.android.gms.internal.ads.zzibu r13, com.google.android.gms.internal.ads.zziab r14) throws com.google.android.gms.internal.ads.zzibf {
        /*
            r11 = this;
            r0 = 2
            r11.q(r0)
            com.google.android.gms.internal.ads.zzhzq r1 = r11.f34592a
            int r2 = r1.v()
            int r2 = r1.B(r2)
            com.google.android.gms.internal.ads.zzfxs r3 = r13.f34698c
            java.lang.String r4 = ""
            r5 = r3
        L13:
            int r6 = r11.y()     // Catch: java.lang.Throwable -> L47
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r7) goto L78
            boolean r7 = r1.b()     // Catch: java.lang.Throwable -> L47
            if (r7 == 0) goto L23
            goto L78
        L23:
            r7 = 0
            r8 = 1
            java.lang.String r9 = "Unable to parse map entry."
            if (r6 == r8) goto L56
            if (r6 == r0) goto L4b
            boolean r6 = r1.b()     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            if (r6 != 0) goto L3d
            int r6 = r11.f34593b     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            int r8 = r11.f34594c     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            if (r6 != r8) goto L38
            goto L3d
        L38:
            boolean r6 = r1.j(r6)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            goto L3e
        L3d:
            r6 = r7
        L3e:
            if (r6 == 0) goto L41
            goto L13
        L41:
            com.google.android.gms.internal.ads.zzibg r6 = new com.google.android.gms.internal.ads.zzibg     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            throw r6     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
        L47:
            r12 = move-exception
            goto L7f
        L49:
            r6 = move-exception
            goto L5e
        L4b:
            com.google.android.gms.internal.ads.zzids r6 = r13.f34697b     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            java.lang.Class r8 = r3.getClass()     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            java.lang.Object r5 = r11.t(r6, r8, r14)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            goto L13
        L56:
            com.google.android.gms.internal.ads.zzids r6 = r13.f34696a     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            r8 = 0
            java.lang.Object r4 = r11.t(r6, r8, r8)     // Catch: java.lang.Throwable -> L47 com.google.android.gms.internal.ads.zzibf -> L49
            goto L13
        L5e:
            boolean r8 = r1.b()     // Catch: java.lang.Throwable -> L47
            if (r8 != 0) goto L6f
            int r8 = r11.f34593b     // Catch: java.lang.Throwable -> L47
            int r10 = r11.f34594c     // Catch: java.lang.Throwable -> L47
            if (r8 != r10) goto L6b
            goto L6f
        L6b:
            boolean r7 = r1.j(r8)     // Catch: java.lang.Throwable -> L47
        L6f:
            if (r7 == 0) goto L72
            goto L13
        L72:
            com.google.android.gms.internal.ads.zzibg r12 = new com.google.android.gms.internal.ads.zzibg     // Catch: java.lang.Throwable -> L47
            r12.<init>(r9, r6)     // Catch: java.lang.Throwable -> L47
            throw r12     // Catch: java.lang.Throwable -> L47
        L78:
            r12.put(r4, r5)     // Catch: java.lang.Throwable -> L47
            r1.a(r2)
            return
        L7f:
            r1.a(r2)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhzr.p(com.google.android.gms.internal.ads.zzibw, com.google.android.gms.internal.ads.zzibu, com.google.android.gms.internal.ads.zziab):void");
    }

    public final void q(int i2) throws zzibf {
        if ((this.f34593b & 7) != i2) {
            throw new zzibf();
        }
    }

    public final void r(Object obj, zzicu zzicuVar, zziab zziabVar) throws zzibg {
        zzhzq zzhzqVar = this.f34592a;
        int iV = zzhzqVar.v();
        if (zzhzqVar.f34589a + zzhzqVar.f34590b >= 100) {
            throw new zzibg("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iB = zzhzqVar.B(iV);
        zzhzqVar.f34589a++;
        zzicuVar.d(obj, this, zziabVar);
        zzhzqVar.i(0);
        zzhzqVar.f34589a--;
        zzhzqVar.a(iB);
    }

    public final void s(Object obj, zzicu zzicuVar, zziab zziabVar) {
        int i2 = this.f34594c;
        this.f34594c = ((this.f34593b >>> 3) << 3) | 4;
        try {
            zzicuVar.d(obj, this, zziabVar);
            if (this.f34593b == this.f34594c) {
            } else {
                throw new zzibg("Failed to parse the message.");
            }
        } finally {
            this.f34594c = i2;
        }
    }

    public final Object t(zzids zzidsVar, Class cls, zziab zziabVar) throws zzibg {
        zzids zzidsVar2 = zzids.f34776c;
        switch (zzidsVar.ordinal()) {
            case 0:
                return Double.valueOf(z());
            case 1:
                return Float.valueOf(A());
            case 2:
                return Long.valueOf(C());
            case 3:
                return Long.valueOf(B());
            case 4:
                return Integer.valueOf(D());
            case 5:
                return Long.valueOf(E());
            case 6:
                return Integer.valueOf(F());
            case 7:
                return Boolean.valueOf(G());
            case 8:
                return I();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                q(2);
                zzicu zzicuVarA = zzicm.f34722c.a(cls);
                Object objZza = zzicuVarA.zza();
                r(objZza, zzicuVarA, zziabVar);
                zzicuVarA.b(objZza);
                return objZza;
            case 11:
                return L();
            case 12:
                return Integer.valueOf(M());
            case 13:
                return Integer.valueOf(N());
            case 14:
                return Integer.valueOf(O());
            case 15:
                return Long.valueOf(P());
            case 16:
                return Integer.valueOf(Q());
            case 17:
                return Long.valueOf(R());
        }
    }

    public final void u(int i2) throws zzibg {
        if (this.f34592a.c() != i2) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public final int y() {
        int iH = this.f34595d;
        if (iH != 0) {
            this.f34593b = iH;
            this.f34595d = 0;
        } else {
            iH = this.f34592a.h();
            this.f34593b = iH;
        }
        return (iH == 0 || iH == this.f34594c) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iH >>> 3;
    }

    public final double z() throws zzibf {
        q(1);
        return this.f34592a.k();
    }
}
