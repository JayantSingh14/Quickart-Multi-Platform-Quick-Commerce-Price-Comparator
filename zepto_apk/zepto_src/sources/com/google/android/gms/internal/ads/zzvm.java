package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzvm implements zzwr, zztg {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f35717a;

    /* renamed from: b, reason: collision with root package name */
    public zzwq f35718b;

    /* renamed from: c, reason: collision with root package name */
    public zztf f35719c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzvo f35720d;

    public zzvm(zzvo zzvoVar, Integer num) {
        Objects.requireNonNull(zzvoVar);
        this.f35720d = zzvoVar;
        this.f35718b = new zzwq(zzvoVar.f35698c.f35785b, null);
        this.f35719c = new zztf(zzvoVar.f35699d.f35585b, null);
        this.f35717a = num;
    }

    public final boolean a(zzwg zzwgVar) {
        zzwg zzwgVarW;
        Integer num = this.f35717a;
        zzvo zzvoVar = this.f35720d;
        if (zzwgVar != null) {
            zzwgVarW = zzvoVar.w(num, zzwgVar);
            if (zzwgVarW == null) {
                return false;
            }
        } else {
            zzwgVarW = null;
        }
        zzvoVar.v(num);
        zzwq zzwqVar = this.f35718b;
        zzwqVar.getClass();
        if (!Objects.equals(zzwqVar.f35784a, zzwgVarW)) {
            this.f35718b = new zzwq(zzvoVar.f35698c.f35785b, zzwgVarW);
        }
        zztf zztfVar = this.f35719c;
        zztfVar.getClass();
        if (Objects.equals(zztfVar.f35584a, zzwgVarW)) {
            return true;
        }
        this.f35719c = new zztf(zzvoVar.f35699d.f35585b, zzwgVarW);
        return true;
    }

    public final void b(zzwc zzwcVar, zzwg zzwgVar) {
        zzvo zzvoVar = this.f35720d;
        Integer num = this.f35717a;
        zzvoVar.x(num, zzwcVar.f35756c);
        zzvoVar.x(num, zzwcVar.f35757d);
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void d(int i2, zzwg zzwgVar, zzvx zzvxVar, zzwc zzwcVar, int i3) {
        if (a(zzwgVar)) {
            zzwq zzwqVar = this.f35718b;
            b(zzwcVar, zzwgVar);
            zzwqVar.getClass();
            zzwqVar.a(new zzwp(zzwqVar, zzvxVar, zzwcVar, i3));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void e(int i2, zzwg zzwgVar, zzwc zzwcVar) {
        if (a(zzwgVar)) {
            zzwq zzwqVar = this.f35718b;
            b(zzwcVar, zzwgVar);
            zzwqVar.getClass();
            zzwqVar.a(new zzwn(zzwqVar, zzwcVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void g(int i2, zzwg zzwgVar, zzvx zzvxVar, zzwc zzwcVar, IOException iOException, boolean z) {
        if (a(zzwgVar)) {
            zzwq zzwqVar = this.f35718b;
            b(zzwcVar, zzwgVar);
            zzwqVar.getClass();
            zzwqVar.a(new zzwm(zzwqVar, zzvxVar, zzwcVar, iOException, z));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void i(int i2, zzwg zzwgVar, zzvx zzvxVar, zzwc zzwcVar) {
        if (a(zzwgVar)) {
            zzwq zzwqVar = this.f35718b;
            b(zzwcVar, zzwgVar);
            zzwqVar.getClass();
            zzwqVar.a(new zzwl(zzwqVar, zzvxVar, zzwcVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwr
    public final void j(int i2, zzwg zzwgVar, zzvx zzvxVar, zzwc zzwcVar) {
        if (a(zzwgVar)) {
            zzwq zzwqVar = this.f35718b;
            b(zzwcVar, zzwgVar);
            zzwqVar.getClass();
            zzwqVar.a(new zzwk(zzwqVar, zzvxVar, zzwcVar));
        }
    }
}
