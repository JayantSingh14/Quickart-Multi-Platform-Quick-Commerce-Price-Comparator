package com.google.android.gms.internal.pal;

import android.view.View;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzfd extends zzfg {

    /* renamed from: h, reason: collision with root package name */
    public final View f37715h;

    public zzfd(zzdu zzduVar, zzr zzrVar, int i2, View view) {
        super(zzduVar, "xcWDoPM3ZfO4P10VSUmZKRTMvsXPXnglJL31bwAJBgJGdSUy2IQG17s4MILOncV2", "9rXsTdb/WXYONX554dN5CJ2eqpcy9gFPMPi8uAjaHTA=", zzrVar, i2, 57);
        this.f37715h = view;
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        View view = this.f37715h;
        if (view != null) {
            zzgc zzgcVar = zzgk.u;
            zzfv zzfvVar = zzfv.f37741d;
            Boolean bool = (Boolean) zzfvVar.f37744c.a(zzgcVar);
            Boolean bool2 = (Boolean) zzfvVar.f37744c.a(zzgk.w);
            String str = (String) this.f37727e.invoke(null, view, this.f37723a.f37634a.getResources().getDisplayMetrics(), bool, bool2);
            zzdy zzdyVar = new zzdy();
            HashMap mapA = zzbi.a(str);
            if (mapA != null) {
                zzdyVar.f37660a = (Long) mapA.get(0);
                zzdyVar.f37661b = (Long) mapA.get(1);
                zzdyVar.f37662c = (Long) mapA.get(2);
                zzdyVar.f37663d = (Long) mapA.get(3);
                zzdyVar.f37664e = (Long) mapA.get(4);
            }
            zzad zzadVarP = zzae.p();
            long jLongValue = zzdyVar.f37660a.longValue();
            if (zzadVarP.f37406c) {
                zzadVarP.k();
                zzadVarP.f37406c = false;
            }
            zzae.r((zzae) zzadVarP.f37405b, jLongValue);
            long jLongValue2 = zzdyVar.f37661b.longValue();
            if (zzadVarP.f37406c) {
                zzadVarP.k();
                zzadVarP.f37406c = false;
            }
            zzae.s((zzae) zzadVarP.f37405b, jLongValue2);
            long jLongValue3 = zzdyVar.f37662c.longValue();
            if (zzadVarP.f37406c) {
                zzadVarP.k();
                zzadVarP.f37406c = false;
            }
            zzae.t((zzae) zzadVarP.f37405b, jLongValue3);
            if (bool2.booleanValue()) {
                long jLongValue4 = zzdyVar.f37664e.longValue();
                if (zzadVarP.f37406c) {
                    zzadVarP.k();
                    zzadVarP.f37406c = false;
                }
                zzae.q((zzae) zzadVarP.f37405b, jLongValue4);
            }
            if (bool.booleanValue()) {
                long jLongValue5 = zzdyVar.f37663d.longValue();
                if (zzadVarP.f37406c) {
                    zzadVarP.k();
                    zzadVarP.f37406c = false;
                }
                zzae.u((zzae) zzadVarP.f37405b, jLongValue5);
            }
            zzae zzaeVar = (zzae) zzadVarP.h();
            zzr zzrVar = this.f37726d;
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.I((zzaf) zzrVar.f37405b, zzaeVar);
        }
    }
}
