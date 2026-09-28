package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzmm {

    /* renamed from: a, reason: collision with root package name */
    public final zzmi f35212a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35213b;

    /* renamed from: c, reason: collision with root package name */
    public final zzmi f35214c;

    /* renamed from: d, reason: collision with root package name */
    public int f35215d = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f35216e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f35217f = false;

    public zzmm(zzmi zzmiVar, zzmi zzmiVar2, int i2) {
        this.f35212a = zzmiVar;
        this.f35213b = i2;
        this.f35214c = zzmiVar2;
    }

    public static boolean l(zzmi zzmiVar) {
        return zzmiVar.zze() != 0;
    }

    public final boolean A(zzlk zzlkVar) {
        zzmi zzmiVarM = m(zzlkVar);
        return zzmiVarM == null || zzmiVarM.x() || zzmiVarM.e() || zzmiVarM.t();
    }

    public final void B() {
        zzmi zzmiVar = this.f35212a;
        if (zzmiVar.zze() == 1 && this.f35215d != 4) {
            zzmiVar.p();
            return;
        }
        zzmi zzmiVar2 = this.f35214c;
        if (zzmiVar2 == null || zzmiVar2.zze() != 1 || this.f35215d == 3) {
            return;
        }
        zzmiVar2.p();
    }

    public final void a() {
        int i2 = this.f35215d;
        if (i2 != 3 && i2 != 4) {
            if (i2 == 2) {
                this.f35215d = 0;
                return;
            }
            return;
        }
        boolean z = i2 == 4;
        zzmi zzmiVar = this.f35212a;
        zzmi zzmiVar2 = this.f35214c;
        if (z) {
            zzmiVar2.getClass();
            zzmiVar2.u(17, zzmiVar);
        } else {
            zzmiVar2.getClass();
            zzmiVar.u(17, zzmiVar2);
        }
        this.f35215d = this.f35215d != 4 ? 1 : 0;
    }

    public final void b() {
        if (!l(this.f35212a)) {
            j(true);
        }
        zzmi zzmiVar = this.f35214c;
        if (zzmiVar == null || zzmiVar.zze() != 0) {
            return;
        }
        j(false);
    }

    public final int c(zzlk zzlkVar, zzaae zzaaeVar, zzir zzirVar) {
        int iK = k(this.f35212a, zzlkVar, zzaaeVar, zzirVar);
        return iK == 1 ? k(this.f35214c, zzlkVar, zzaaeVar, zzirVar) : iK;
    }

    public final void d() {
        this.f35212a.f();
        this.f35216e = false;
        zzmi zzmiVar = this.f35214c;
        if (zzmiVar != null) {
            zzmiVar.f();
            this.f35217f = false;
        }
    }

    public final void e(Object obj) {
        zzmi zzmiVar = this.f35212a;
        if (zzmiVar.zza() != 2) {
            return;
        }
        int i2 = this.f35215d;
        if (i2 != 4 && i2 != 1) {
            zzmiVar.u(1, obj);
            return;
        }
        zzmi zzmiVar2 = this.f35214c;
        zzmiVar2.getClass();
        zzmiVar2.u(1, obj);
    }

    public final void f(zzacj zzacjVar) {
        zzmi zzmiVar = this.f35212a;
        if (zzmiVar.zza() != 2) {
            zzmiVar.getClass();
            return;
        }
        zzmiVar.u(7, zzacjVar);
        zzmi zzmiVar2 = this.f35214c;
        if (zzmiVar2 != null) {
            zzmiVar2.u(7, zzacjVar);
        }
    }

    public final boolean g() {
        int i2 = this.f35215d;
        if (i2 == 0 || i2 == 2 || i2 == 4) {
            return l(this.f35212a);
        }
        zzmi zzmiVar = this.f35214c;
        zzmiVar.getClass();
        return zzmiVar.zze() != 0;
    }

    public final boolean h(zzlk zzlkVar, zzmi zzmiVar) {
        if (zzmiVar == null) {
            return true;
        }
        zzxw[] zzxwVarArr = zzlkVar.f35098c;
        int i2 = this.f35213b;
        zzxw zzxwVar = zzxwVarArr[i2];
        if (zzmiVar.w() == null) {
            return true;
        }
        if (zzmiVar.w() == zzxwVar && (zzxwVar == null || zzmiVar.x())) {
            return true;
        }
        zzlk zzlkVar2 = zzlkVar.f35108m;
        return zzlkVar2 != null && zzlkVar2.f35098c[i2] == zzmiVar.w();
    }

    public final void i(zzmi zzmiVar, zzir zzirVar) {
        zzgqa.f(this.f35212a == zzmiVar || this.f35214c == zzmiVar);
        if (l(zzmiVar)) {
            if (zzmiVar == zzirVar.f34962c) {
                zzirVar.f34963d = null;
                zzirVar.f34962c = null;
                zzirVar.f34964e = true;
            }
            if (zzmiVar.zze() == 2) {
                zzmiVar.zzq();
            }
            zzmiVar.zzr();
        }
    }

    public final void j(boolean z) {
        if (z) {
            if (this.f35216e) {
                this.f35212a.zzs();
                this.f35216e = false;
                return;
            }
            return;
        }
        if (this.f35217f) {
            zzmi zzmiVar = this.f35214c;
            zzmiVar.getClass();
            zzmiVar.zzs();
            this.f35217f = false;
        }
    }

    public final int k(zzmi zzmiVar, zzlk zzlkVar, zzaae zzaaeVar, zzir zzirVar) {
        int i2;
        if (zzmiVar != null && zzmiVar.zze() != 0) {
            zzmi zzmiVar2 = this.f35212a;
            boolean z = zzmiVar != zzmiVar2;
            if (zzmiVar == zzmiVar2 && ((i2 = this.f35215d) == 2 || i2 == 4)) {
                return 1;
            }
            if (zzmiVar == this.f35214c && this.f35215d == 3) {
                return 1;
            }
            zzxw zzxwVarW = zzmiVar.w();
            zzxw[] zzxwVarArr = zzlkVar.f35098c;
            int i3 = this.f35213b;
            zzxw zzxwVar = zzxwVarArr[i3];
            boolean zA = zzaaeVar.a(i3);
            if (!zA || zzxwVarW != zzxwVar) {
                if (!zzmiVar.zzm()) {
                    zzzw zzzwVar = zzaaeVar.f22580c[i3];
                    int iZze = zzzwVar != null ? zzzwVar.zze() : 0;
                    zzv[] zzvVarArr = new zzv[iZze];
                    for (int i4 = 0; i4 < iZze; i4++) {
                        zzzwVar.getClass();
                        zzvVarArr[i4] = zzzwVar.zzb(i4);
                    }
                    zzxw zzxwVar2 = zzxwVarArr[i3];
                    zzxwVar2.getClass();
                    zzmiVar.v(zzvVarArr, zzxwVar2, zzlkVar.a(), zzlkVar.p, zzlkVar.f35102g.f35109a);
                    return 3;
                }
                if (!zzmiVar.t()) {
                    return 0;
                }
                i(zzmiVar, zzirVar);
                if (!zA || p()) {
                    j(!z);
                    return 1;
                }
            }
        }
        return 1;
    }

    public final zzmi m(zzlk zzlkVar) {
        if (zzlkVar == null) {
            return null;
        }
        zzxw[] zzxwVarArr = zzlkVar.f35098c;
        int i2 = this.f35213b;
        if (zzxwVarArr[i2] == null) {
            return null;
        }
        zzmi zzmiVar = this.f35212a;
        zzxw zzxwVarW = zzmiVar.w();
        zzxw zzxwVar = zzxwVarArr[i2];
        if (zzxwVarW == zzxwVar) {
            return zzmiVar;
        }
        zzmi zzmiVar2 = this.f35214c;
        if (zzmiVar2 == null || zzmiVar2.w() != zzxwVar) {
            return null;
        }
        return zzmiVar2;
    }

    public final boolean n() {
        return this.f35214c != null;
    }

    public final void o() {
        int i2;
        zzgqa.f(!p());
        if (l(this.f35212a)) {
            i2 = 3;
        } else {
            i2 = 2;
            zzmi zzmiVar = this.f35214c;
            if (zzmiVar != null && zzmiVar.zze() != 0) {
                i2 = 4;
            }
        }
        this.f35215d = i2;
    }

    public final boolean p() {
        int i2 = this.f35215d;
        return i2 == 2 || i2 == 4 || i2 == 3;
    }

    public final int q() {
        boolean zL = l(this.f35212a);
        int i2 = 0;
        zzmi zzmiVar = this.f35214c;
        if (zzmiVar != null && zzmiVar.zze() != 0) {
            i2 = 1;
        }
        return (zL ? 1 : 0) + i2;
    }

    public final boolean r(zzlk zzlkVar) {
        zzmi zzmiVarM = m(zzlkVar);
        zzmiVarM.getClass();
        return zzmiVarM.x();
    }

    public final void s(zzlk zzlkVar) {
        zzmi zzmiVarM = m(zzlkVar);
        zzmiVarM.getClass();
        zzmiVarM.zzl();
        if (zzmiVarM instanceof zzyl) {
            throw null;
        }
    }

    public final void t(zzaae zzaaeVar, zzaae zzaaeVar2) {
        int i2;
        int i3 = this.f35213b;
        boolean zA = zzaaeVar.a(i3);
        boolean zA2 = zzaaeVar2.a(i3);
        zzmi zzmiVar = this.f35212a;
        zzmi zzmiVar2 = this.f35214c;
        if (zzmiVar2 == null || (i2 = this.f35215d) == 3 || (i2 == 0 && l(zzmiVar))) {
            zzmiVar2 = zzmiVar;
        }
        if (!zA || zzmiVar2.zzm()) {
            return;
        }
        zzmiVar.getClass();
        zzml zzmlVar = zzaaeVar.f22579b[i3];
        zzml zzmlVar2 = zzaaeVar2.f22579b[i3];
        if (zA2 && Objects.equals(zzmlVar2, zzmlVar) && !p()) {
            return;
        }
        zzmiVar2.zzl();
        if (zzmiVar2 instanceof zzyl) {
            throw null;
        }
    }

    public final void u() {
        int i2;
        zzmi zzmiVar = this.f35212a;
        if (l(zzmiVar) && (i2 = this.f35215d) != 4 && i2 != 2) {
            zzmiVar.zzl();
            if (zzmiVar instanceof zzyl) {
                throw null;
            }
        }
        zzmi zzmiVar2 = this.f35214c;
        if (zzmiVar2 == null || zzmiVar2.zze() == 0 || this.f35215d == 3) {
            return;
        }
        zzmiVar2.zzl();
        if (zzmiVar2 instanceof zzyl) {
            throw null;
        }
    }

    public final void v() {
        zzmi zzmiVar = this.f35212a;
        if (l(zzmiVar)) {
            zzmiVar.r();
            return;
        }
        zzmi zzmiVar2 = this.f35214c;
        if (zzmiVar2 == null || zzmiVar2.zze() == 0) {
            return;
        }
        zzmiVar2.r();
    }

    public final boolean w() {
        zzmi zzmiVar = this.f35212a;
        boolean zT = l(zzmiVar) ? zzmiVar.t() : true;
        zzmi zzmiVar2 = this.f35214c;
        return (zzmiVar2 == null || zzmiVar2.zze() == 0) ? zT : zT & zzmiVar2.t();
    }

    public final boolean x(zzlk zzlkVar) {
        int i2 = this.f35215d;
        return ((i2 == 2 || i2 == 4) && m(zzlkVar) == this.f35212a) || (this.f35215d == 3 && m(zzlkVar) == this.f35214c);
    }

    public final boolean y(zzlk zzlkVar) {
        return h(zzlkVar, this.f35212a) && h(zzlkVar, this.f35214c);
    }

    public final void z(long j2, long j3) {
        zzmi zzmiVar = this.f35212a;
        if (l(zzmiVar)) {
            zzmiVar.o(j2, j3);
        }
        zzmi zzmiVar2 = this.f35214c;
        if (zzmiVar2 == null || zzmiVar2.zze() == 0) {
            return;
        }
        zzmiVar2.o(j2, j3);
    }
}
