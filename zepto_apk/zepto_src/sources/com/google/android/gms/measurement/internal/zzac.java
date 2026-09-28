package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpq;
import java.math.BigDecimal;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzac extends zzab {

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzfn f38666g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzad f38667h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzad zzadVar, String str, int i2, com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        super(str, i2);
        Objects.requireNonNull(zzadVar);
        this.f38667h = zzadVar;
        this.f38666g = zzfnVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    public final int a() {
        return this.f38666g.t();
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean c() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h(Long l2, Long l3, com.google.android.gms.internal.measurement.zziu zziuVar, boolean z) {
        zzpq.a();
        zzib zzibVar = this.f38667h.f39180a;
        boolean zQ = zzibVar.f39087d.q(this.f38660a, zzfx.D0);
        com.google.android.gms.internal.measurement.zzfn zzfnVar = this.f38666g;
        boolean zW = zzfnVar.w();
        boolean zX = zzfnVar.x();
        boolean z2 = zzfnVar.z();
        Object[] objArr = zW || zX || z2;
        Boolean boolD = null;
        boolG = null;
        Boolean boolG = null;
        boolD = null;
        boolD = null;
        boolD = null;
        Boolean boolG2 = null;
        boolD = null;
        zzgt zzgtVar = zzibVar.f39089f;
        if (z && objArr != true) {
            zzib.l(zzgtVar);
            zzgtVar.n.c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f38661b), zzfnVar.s() ? Integer.valueOf(zzfnVar.t()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzfh zzfhVarV = zzfnVar.v();
        boolean zX2 = zzfhVarV.x();
        boolean zX3 = zziuVar.x();
        zzgm zzgmVar = zzibVar.f39093j;
        if (zX3) {
            if (zzfhVarV.u()) {
                boolD = zzab.d(zzab.f(zziuVar.y(), zzfhVarV.v()), zX2);
            } else {
                zzib.l(zzgtVar);
                zzgtVar.f38961i.b(zzgmVar.c(zziuVar.u()), "No number filter for long property. property");
            }
        } else if (zziuVar.B()) {
            if (zzfhVarV.u()) {
                double dC = zziuVar.C();
                try {
                    boolG = zzab.g(new BigDecimal(dC), zzfhVarV.v(), Math.ulp(dC));
                } catch (NumberFormatException unused) {
                }
                boolD = zzab.d(boolG, zX2);
            } else {
                zzib.l(zzgtVar);
                zzgtVar.f38961i.b(zzgmVar.c(zziuVar.u()), "No number filter for double property. property");
            }
        } else if (!zziuVar.v()) {
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(zzgmVar.c(zziuVar.u()), "User property has no value, property");
        } else if (zzfhVarV.s()) {
            String strW = zziuVar.w();
            com.google.android.gms.internal.measurement.zzfr zzfrVarT = zzfhVarV.t();
            zzib.l(zzgtVar);
            boolD = zzab.d(zzab.e(strW, zzfrVarT, zzgtVar), zX2);
        } else if (!zzfhVarV.u()) {
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(zzgmVar.c(zziuVar.u()), "No string or number filter defined. property");
        } else if (zzpj.H(zziuVar.w())) {
            String strW2 = zziuVar.w();
            com.google.android.gms.internal.measurement.zzfl zzflVarV = zzfhVarV.v();
            if (zzpj.H(strW2)) {
                try {
                    boolG2 = zzab.g(new BigDecimal(strW2), zzflVarV, 0.0d);
                } catch (NumberFormatException unused2) {
                }
            }
            boolD = zzab.d(boolG2, zX2);
        } else {
            zzib.l(zzgtVar);
            zzgtVar.f38961i.c("Invalid user property value for Numeric number filter. property, value", zzgmVar.c(zziuVar.u()), zziuVar.w());
        }
        zzib.l(zzgtVar);
        zzgtVar.n.b(boolD == null ? "null" : boolD, "Property filter result");
        if (boolD == null) {
            return false;
        }
        this.f38662c = Boolean.TRUE;
        if (!z2 || boolD.booleanValue()) {
            if (!z || zzfnVar.w()) {
                this.f38663d = boolD;
            }
            if (boolD.booleanValue() && objArr != false && zziuVar.s()) {
                long jT = zziuVar.t();
                if (l2 != null) {
                    jT = l2.longValue();
                }
                if (zQ && zzfnVar.w() && !zzfnVar.x() && l3 != null) {
                    jT = l3.longValue();
                }
                if (zzfnVar.x()) {
                    this.f38665f = Long.valueOf(jT);
                } else {
                    this.f38664e = Long.valueOf(jT);
                }
            }
        }
        return true;
    }
}
