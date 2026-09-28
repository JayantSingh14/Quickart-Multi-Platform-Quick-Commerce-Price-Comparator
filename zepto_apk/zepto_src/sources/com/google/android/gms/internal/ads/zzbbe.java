package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzbbe extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final View f24661h;

    public zzbbe(zzazt zzaztVar, zzavs zzavsVar, int i2, View view) {
        super(zzaztVar, "UGogIgDf9q+IGA3QKHqW/91b9ZzRTVJqtfmUoLBkD310fwrDg1hJZvDQk8/WK1MH", "sEqRe1gPhw/PwjhUj/qVAEUjKSVJDrXHsmrE44pcjTE=", zzavsVar, i2, 57);
        this.f24661h = view;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        View view = this.f24661h;
        if (view != null) {
            zzbgb zzbgbVar = zzbgk.a4;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            Boolean bool = (Boolean) zzbdVar.f21153c.a(zzbgbVar);
            Boolean bool2 = (Boolean) zzbdVar.f21153c.a(zzbgk.dc);
            String str = (String) this.f24673e.invoke(null, view, this.f24669a.f24558a.getResources().getDisplayMetrics(), bool, bool2);
            zzazx zzazxVar = new zzazx();
            HashMap mapB = zzaxi.b(str);
            if (mapB != null) {
                zzazxVar.f24591a = (Long) mapB.get(0);
                zzazxVar.f24592b = (Long) mapB.get(1);
                zzazxVar.f24593c = (Long) mapB.get(2);
                zzazxVar.f24594d = (Long) mapB.get(3);
                zzazxVar.f24595e = (Long) mapB.get(4);
            }
            zzawn zzawnVarC = zzawo.C();
            long jLongValue = zzazxVar.f24591a.longValue();
            zzawnVarC.j();
            ((zzawo) zzawnVarC.f34638b).E(jLongValue);
            long jLongValue2 = zzazxVar.f24592b.longValue();
            zzawnVarC.j();
            ((zzawo) zzawnVarC.f34638b).F(jLongValue2);
            long jLongValue3 = zzazxVar.f24593c.longValue();
            zzawnVarC.j();
            ((zzawo) zzawnVarC.f34638b).G(jLongValue3);
            if (bool2.booleanValue()) {
                long jLongValue4 = zzazxVar.f24595e.longValue();
                zzawnVarC.j();
                ((zzawo) zzawnVarC.f34638b).D(jLongValue4);
            }
            if (bool.booleanValue()) {
                long jLongValue5 = zzazxVar.f24594d.longValue();
                zzawnVarC.j();
                ((zzawo) zzawnVarC.f34638b).H(jLongValue5);
            }
            zzawo zzawoVar = (zzawo) zzawnVarC.l();
            zzavs zzavsVar = this.f24672d;
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).Y(zzawoVar);
        }
    }
}
