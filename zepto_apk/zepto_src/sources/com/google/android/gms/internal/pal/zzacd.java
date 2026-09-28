package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes4.dex */
final class zzacd implements zzaeq {

    /* renamed from: a, reason: collision with root package name */
    public final zzacc f37373a;

    /* renamed from: b, reason: collision with root package name */
    public int f37374b;

    /* renamed from: c, reason: collision with root package name */
    public int f37375c;

    /* renamed from: d, reason: collision with root package name */
    public int f37376d = 0;

    public zzacd(zzacc zzaccVar) {
        Charset charset = zzadg.f37410a;
        this.f37373a = zzaccVar;
        zzaccVar.f37372b = this;
    }

    public static final void s(int i2) throws zzadi {
        if ((i2 & 3) != 0) {
            throw zzadi.d();
        }
    }

    public static final void t(int i2) throws zzadi {
        if ((i2 & 7) != 0) {
            throw zzadi.d();
        }
    }

    public final int A() throws zzadh {
        r(5);
        return ((zzaca) this.f37373a).m();
    }

    public final int B() throws zzadh {
        r(0);
        return zzacc.k(((zzaca) this.f37373a).n());
    }

    public final int C() throws zzadh {
        r(0);
        return ((zzaca) this.f37373a).n();
    }

    public final long D() throws zzadh {
        r(1);
        return ((zzaca) this.f37373a).o();
    }

    public final long E() throws zzadh {
        r(0);
        return ((zzaca) this.f37373a).p();
    }

    public final long F() throws zzadh {
        r(1);
        return ((zzaca) this.f37373a).o();
    }

    public final long G() throws zzadh {
        r(0);
        return zzacc.l(((zzaca) this.f37373a).p());
    }

    public final long H() throws zzadh {
        r(0);
        return ((zzaca) this.f37373a).p();
    }

    public final zzaby I() throws zzadh {
        r(2);
        return this.f37373a.d();
    }

    public final Object J(zzaer zzaerVar, zzacm zzacmVar) throws zzadh {
        r(3);
        return o(zzaerVar, zzacmVar);
    }

    public final Object K(zzaer zzaerVar, zzacm zzacmVar) throws zzadh {
        r(2);
        return p(zzaerVar, zzacmVar);
    }

    public final String L() throws zzadh {
        r(2);
        return this.f37373a.e();
    }

    public final String M() throws zzadh {
        r(2);
        return this.f37373a.f();
    }

    public final void N(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzabn;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(zzaccVar.j()));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iA = zzaccVar.a() + ((zzaca) zzaccVar).n();
            do {
                list.add(Boolean.valueOf(zzaccVar.j()));
            } while (zzaccVar.a() < iA);
            q(iA);
            return;
        }
        zzabn zzabnVar = (zzabn) list;
        int i3 = this.f37374b & 7;
        if (i3 == 0) {
            do {
                zzabnVar.d(zzaccVar.j());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iA2 = zzaccVar.a() + ((zzaca) zzaccVar).n();
        do {
            zzabnVar.d(zzaccVar.j());
        } while (zzaccVar.a() < iA2);
        q(iA2);
    }

    public final void O(List list) throws zzadh {
        int iC;
        if ((this.f37374b & 7) != 2) {
            throw zzadi.a();
        }
        do {
            list.add(I());
            zzacc zzaccVar = this.f37373a;
            if (zzaccVar.i()) {
                return;
            } else {
                iC = zzaccVar.c();
            }
        } while (iC == this.f37374b);
        this.f37376d = iC;
    }

    public final void P(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzacj;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(Double.longBitsToDouble(((zzaca) zzaccVar).o())));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iN = ((zzaca) zzaccVar).n();
            t(iN);
            int iA = zzaccVar.a() + iN;
            do {
                list.add(Double.valueOf(Double.longBitsToDouble(((zzaca) zzaccVar).o())));
            } while (zzaccVar.a() < iA);
            return;
        }
        zzacj zzacjVar = (zzacj) list;
        int i3 = this.f37374b & 7;
        if (i3 == 1) {
            do {
                zzacjVar.d(Double.longBitsToDouble(((zzaca) zzaccVar).o()));
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iN2 = ((zzaca) zzaccVar).n();
        t(iN2);
        int iA2 = zzaccVar.a() + iN2;
        do {
            zzacjVar.d(Double.longBitsToDouble(((zzaca) zzaccVar).o()));
        } while (zzaccVar.a() < iA2);
    }

    public final void Q(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzada;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzaca) zzaccVar).n()));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iA = zzaccVar.a() + ((zzaca) zzaccVar).n();
            do {
                list.add(Integer.valueOf(((zzaca) zzaccVar).n()));
            } while (zzaccVar.a() < iA);
            q(iA);
            return;
        }
        zzada zzadaVar = (zzada) list;
        int i3 = this.f37374b & 7;
        if (i3 == 0) {
            do {
                zzadaVar.d(((zzaca) zzaccVar).n());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iA2 = zzaccVar.a() + ((zzaca) zzaccVar).n();
        do {
            zzadaVar.d(((zzaca) zzaccVar).n());
        } while (zzaccVar.a() < iA2);
        q(iA2);
    }

    public final void R(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzada;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 2) {
                int iN = ((zzaca) zzaccVar).n();
                s(iN);
                int iA = zzaccVar.a() + iN;
                do {
                    list.add(Integer.valueOf(((zzaca) zzaccVar).m()));
                } while (zzaccVar.a() < iA);
                return;
            }
            if (i2 != 5) {
                throw zzadi.a();
            }
            do {
                list.add(Integer.valueOf(((zzaca) zzaccVar).m()));
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC = zzaccVar.c();
                }
            } while (iC == this.f37374b);
            this.f37376d = iC;
            return;
        }
        zzada zzadaVar = (zzada) list;
        int i3 = this.f37374b & 7;
        if (i3 == 2) {
            int iN2 = ((zzaca) zzaccVar).n();
            s(iN2);
            int iA2 = zzaccVar.a() + iN2;
            do {
                zzadaVar.d(((zzaca) zzaccVar).m());
            } while (zzaccVar.a() < iA2);
            return;
        }
        if (i3 != 5) {
            throw zzadi.a();
        }
        do {
            zzadaVar.d(((zzaca) zzaccVar).m());
            if (zzaccVar.i()) {
                return;
            } else {
                iC2 = zzaccVar.c();
            }
        } while (iC2 == this.f37374b);
        this.f37376d = iC2;
    }

    public final void a(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzadu;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((zzaca) zzaccVar).o()));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iN = ((zzaca) zzaccVar).n();
            t(iN);
            int iA = zzaccVar.a() + iN;
            do {
                list.add(Long.valueOf(((zzaca) zzaccVar).o()));
            } while (zzaccVar.a() < iA);
            return;
        }
        zzadu zzaduVar = (zzadu) list;
        int i3 = this.f37374b & 7;
        if (i3 == 1) {
            do {
                zzaduVar.d(((zzaca) zzaccVar).o());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iN2 = ((zzaca) zzaccVar).n();
        t(iN2);
        int iA2 = zzaccVar.a() + iN2;
        do {
            zzaduVar.d(((zzaca) zzaccVar).o());
        } while (zzaccVar.a() < iA2);
    }

    public final void b(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzact;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 2) {
                int iN = ((zzaca) zzaccVar).n();
                s(iN);
                int iA = zzaccVar.a() + iN;
                do {
                    list.add(Float.valueOf(Float.intBitsToFloat(((zzaca) zzaccVar).m())));
                } while (zzaccVar.a() < iA);
                return;
            }
            if (i2 != 5) {
                throw zzadi.a();
            }
            do {
                list.add(Float.valueOf(Float.intBitsToFloat(((zzaca) zzaccVar).m())));
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC = zzaccVar.c();
                }
            } while (iC == this.f37374b);
            this.f37376d = iC;
            return;
        }
        zzact zzactVar = (zzact) list;
        int i3 = this.f37374b & 7;
        if (i3 == 2) {
            int iN2 = ((zzaca) zzaccVar).n();
            s(iN2);
            int iA2 = zzaccVar.a() + iN2;
            do {
                zzactVar.d(Float.intBitsToFloat(((zzaca) zzaccVar).m()));
            } while (zzaccVar.a() < iA2);
            return;
        }
        if (i3 != 5) {
            throw zzadi.a();
        }
        do {
            zzactVar.d(Float.intBitsToFloat(((zzaca) zzaccVar).m()));
            if (zzaccVar.i()) {
                return;
            } else {
                iC2 = zzaccVar.c();
            }
        } while (iC2 == this.f37374b);
        this.f37376d = iC2;
    }

    public final void c(List list, zzaer zzaerVar, zzacm zzacmVar) throws zzadh {
        int iC;
        int i2 = this.f37374b;
        if ((i2 & 7) != 3) {
            throw zzadi.a();
        }
        do {
            list.add(o(zzaerVar, zzacmVar));
            zzacc zzaccVar = this.f37373a;
            if (zzaccVar.i() || this.f37376d != 0) {
                return;
            } else {
                iC = zzaccVar.c();
            }
        } while (iC == i2);
        this.f37376d = iC;
    }

    public final void d(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzada;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzaca) zzaccVar).n()));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iA = zzaccVar.a() + ((zzaca) zzaccVar).n();
            do {
                list.add(Integer.valueOf(((zzaca) zzaccVar).n()));
            } while (zzaccVar.a() < iA);
            q(iA);
            return;
        }
        zzada zzadaVar = (zzada) list;
        int i3 = this.f37374b & 7;
        if (i3 == 0) {
            do {
                zzadaVar.d(((zzaca) zzaccVar).n());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iA2 = zzaccVar.a() + ((zzaca) zzaccVar).n();
        do {
            zzadaVar.d(((zzaca) zzaccVar).n());
        } while (zzaccVar.a() < iA2);
        q(iA2);
    }

    public final void e(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzadu;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((zzaca) zzaccVar).p()));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iA = zzaccVar.a() + ((zzaca) zzaccVar).n();
            do {
                list.add(Long.valueOf(((zzaca) zzaccVar).p()));
            } while (zzaccVar.a() < iA);
            q(iA);
            return;
        }
        zzadu zzaduVar = (zzadu) list;
        int i3 = this.f37374b & 7;
        if (i3 == 0) {
            do {
                zzaduVar.d(((zzaca) zzaccVar).p());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iA2 = zzaccVar.a() + ((zzaca) zzaccVar).n();
        do {
            zzaduVar.d(((zzaca) zzaccVar).p());
        } while (zzaccVar.a() < iA2);
        q(iA2);
    }

    public final void f(List list, zzaer zzaerVar, zzacm zzacmVar) throws zzadh {
        int iC;
        int i2 = this.f37374b;
        if ((i2 & 7) != 2) {
            throw zzadi.a();
        }
        do {
            list.add(p(zzaerVar, zzacmVar));
            zzacc zzaccVar = this.f37373a;
            if (zzaccVar.i() || this.f37376d != 0) {
                return;
            } else {
                iC = zzaccVar.c();
            }
        } while (iC == i2);
        this.f37376d = iC;
    }

    public final void g(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzada;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 2) {
                int iN = ((zzaca) zzaccVar).n();
                s(iN);
                int iA = zzaccVar.a() + iN;
                do {
                    list.add(Integer.valueOf(((zzaca) zzaccVar).m()));
                } while (zzaccVar.a() < iA);
                return;
            }
            if (i2 != 5) {
                throw zzadi.a();
            }
            do {
                list.add(Integer.valueOf(((zzaca) zzaccVar).m()));
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC = zzaccVar.c();
                }
            } while (iC == this.f37374b);
            this.f37376d = iC;
            return;
        }
        zzada zzadaVar = (zzada) list;
        int i3 = this.f37374b & 7;
        if (i3 == 2) {
            int iN2 = ((zzaca) zzaccVar).n();
            s(iN2);
            int iA2 = zzaccVar.a() + iN2;
            do {
                zzadaVar.d(((zzaca) zzaccVar).m());
            } while (zzaccVar.a() < iA2);
            return;
        }
        if (i3 != 5) {
            throw zzadi.a();
        }
        do {
            zzadaVar.d(((zzaca) zzaccVar).m());
            if (zzaccVar.i()) {
                return;
            } else {
                iC2 = zzaccVar.c();
            }
        } while (iC2 == this.f37374b);
        this.f37376d = iC2;
    }

    public final void h(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzadu;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(((zzaca) zzaccVar).o()));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iN = ((zzaca) zzaccVar).n();
            t(iN);
            int iA = zzaccVar.a() + iN;
            do {
                list.add(Long.valueOf(((zzaca) zzaccVar).o()));
            } while (zzaccVar.a() < iA);
            return;
        }
        zzadu zzaduVar = (zzadu) list;
        int i3 = this.f37374b & 7;
        if (i3 == 1) {
            do {
                zzaduVar.d(((zzaca) zzaccVar).o());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iN2 = ((zzaca) zzaccVar).n();
        t(iN2);
        int iA2 = zzaccVar.a() + iN2;
        do {
            zzaduVar.d(((zzaca) zzaccVar).o());
        } while (zzaccVar.a() < iA2);
    }

    public final void i(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzada;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(zzacc.k(((zzaca) zzaccVar).n())));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iA = zzaccVar.a() + ((zzaca) zzaccVar).n();
            do {
                list.add(Integer.valueOf(zzacc.k(((zzaca) zzaccVar).n())));
            } while (zzaccVar.a() < iA);
            q(iA);
            return;
        }
        zzada zzadaVar = (zzada) list;
        int i3 = this.f37374b & 7;
        if (i3 == 0) {
            do {
                zzadaVar.d(zzacc.k(((zzaca) zzaccVar).n()));
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iA2 = zzaccVar.a() + ((zzaca) zzaccVar).n();
        do {
            zzadaVar.d(zzacc.k(((zzaca) zzaccVar).n()));
        } while (zzaccVar.a() < iA2);
        q(iA2);
    }

    public final void j(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzadu;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(zzacc.l(((zzaca) zzaccVar).p())));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iA = zzaccVar.a() + ((zzaca) zzaccVar).n();
            do {
                list.add(Long.valueOf(zzacc.l(((zzaca) zzaccVar).p())));
            } while (zzaccVar.a() < iA);
            q(iA);
            return;
        }
        zzadu zzaduVar = (zzadu) list;
        int i3 = this.f37374b & 7;
        if (i3 == 0) {
            do {
                zzaduVar.d(zzacc.l(((zzaca) zzaccVar).p()));
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iA2 = zzaccVar.a() + ((zzaca) zzaccVar).n();
        do {
            zzaduVar.d(zzacc.l(((zzaca) zzaccVar).p()));
        } while (zzaccVar.a() < iA2);
        q(iA2);
    }

    public final void k(List list, boolean z) throws zzadh {
        int iC;
        int iC2;
        if ((this.f37374b & 7) != 2) {
            throw zzadi.a();
        }
        boolean z2 = list instanceof zzadn;
        zzacc zzaccVar = this.f37373a;
        if (!z2 || z) {
            do {
                list.add(z ? M() : L());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC = zzaccVar.c();
                }
            } while (iC == this.f37374b);
            this.f37376d = iC;
            return;
        }
        zzadn zzadnVar = (zzadn) list;
        do {
            zzadnVar.V(I());
            if (zzaccVar.i()) {
                return;
            } else {
                iC2 = zzaccVar.c();
            }
        } while (iC2 == this.f37374b);
        this.f37376d = iC2;
    }

    public final void l(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzada;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(((zzaca) zzaccVar).n()));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iA = zzaccVar.a() + ((zzaca) zzaccVar).n();
            do {
                list.add(Integer.valueOf(((zzaca) zzaccVar).n()));
            } while (zzaccVar.a() < iA);
            q(iA);
            return;
        }
        zzada zzadaVar = (zzada) list;
        int i3 = this.f37374b & 7;
        if (i3 == 0) {
            do {
                zzadaVar.d(((zzaca) zzaccVar).n());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iA2 = zzaccVar.a() + ((zzaca) zzaccVar).n();
        do {
            zzadaVar.d(((zzaca) zzaccVar).n());
        } while (zzaccVar.a() < iA2);
        q(iA2);
    }

    public final void m(List list) throws zzadi {
        int iC;
        int iC2;
        boolean z = list instanceof zzadu;
        zzacc zzaccVar = this.f37373a;
        if (!z) {
            int i2 = this.f37374b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(((zzaca) zzaccVar).p()));
                    if (zzaccVar.i()) {
                        return;
                    } else {
                        iC = zzaccVar.c();
                    }
                } while (iC == this.f37374b);
                this.f37376d = iC;
                return;
            }
            if (i2 != 2) {
                throw zzadi.a();
            }
            int iA = zzaccVar.a() + ((zzaca) zzaccVar).n();
            do {
                list.add(Long.valueOf(((zzaca) zzaccVar).p()));
            } while (zzaccVar.a() < iA);
            q(iA);
            return;
        }
        zzadu zzaduVar = (zzadu) list;
        int i3 = this.f37374b & 7;
        if (i3 == 0) {
            do {
                zzaduVar.d(((zzaca) zzaccVar).p());
                if (zzaccVar.i()) {
                    return;
                } else {
                    iC2 = zzaccVar.c();
                }
            } while (iC2 == this.f37374b);
            this.f37376d = iC2;
            return;
        }
        if (i3 != 2) {
            throw zzadi.a();
        }
        int iA2 = zzaccVar.a() + ((zzaca) zzaccVar).n();
        do {
            zzaduVar.d(((zzaca) zzaccVar).p());
        } while (zzaccVar.a() < iA2);
        q(iA2);
    }

    public final boolean n() throws zzadh {
        r(0);
        return this.f37373a.j();
    }

    public final Object o(zzaer zzaerVar, zzacm zzacmVar) {
        int i2 = this.f37375c;
        this.f37375c = ((this.f37374b >>> 3) << 3) | 4;
        try {
            Object objZze = zzaerVar.zze();
            zzaerVar.e(objZze, this, zzacmVar);
            zzaerVar.zzf(objZze);
            if (this.f37374b == this.f37375c) {
                return objZze;
            }
            throw zzadi.d();
        } finally {
            this.f37375c = i2;
        }
    }

    public final Object p(zzaer zzaerVar, zzacm zzacmVar) throws zzadi {
        zzacc zzaccVar = this.f37373a;
        int iN = ((zzaca) zzaccVar).n();
        if (zzaccVar.f37371a >= 100) {
            throw new zzadi("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iB = zzaccVar.b(iN);
        Object objZze = zzaerVar.zze();
        zzaccVar.f37371a++;
        zzaerVar.e(objZze, this, zzacmVar);
        zzaerVar.zzf(objZze);
        zzaccVar.g(0);
        zzaccVar.f37371a--;
        zzaccVar.h(iB);
        return objZze;
    }

    public final void q(int i2) throws zzadi {
        if (this.f37373a.a() != i2) {
            throw zzadi.e();
        }
    }

    public final void r(int i2) throws zzadh {
        if ((this.f37374b & 7) != i2) {
            throw zzadi.a();
        }
    }

    public final double u() throws zzadh {
        r(1);
        return Double.longBitsToDouble(((zzaca) this.f37373a).o());
    }

    public final float v() throws zzadh {
        r(5);
        return Float.intBitsToFloat(((zzaca) this.f37373a).m());
    }

    public final int w() {
        int iC = this.f37376d;
        if (iC != 0) {
            this.f37374b = iC;
            this.f37376d = 0;
        } else {
            iC = this.f37373a.c();
            this.f37374b = iC;
        }
        return (iC == 0 || iC == this.f37375c) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iC >>> 3;
    }

    public final int x() throws zzadh {
        r(0);
        return ((zzaca) this.f37373a).n();
    }

    public final int y() throws zzadh {
        r(5);
        return ((zzaca) this.f37373a).m();
    }

    public final int z() throws zzadh {
        r(0);
        return ((zzaca) this.f37373a).n();
    }
}
