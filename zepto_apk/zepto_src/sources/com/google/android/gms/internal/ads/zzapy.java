package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes4.dex */
final class zzapy {

    /* renamed from: a, reason: collision with root package name */
    public final List f24114a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaga[] f24115b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgq f24116c;

    public zzapy(List list) {
        this.f24114a = list;
        this.f24115b = new zzaga[list.size()];
        zzgq zzgqVar = new zzgq(new zzgp() { // from class: com.google.android.gms.internal.ads.zzapx
            @Override // com.google.android.gms.internal.ads.zzgp
            public final /* synthetic */ void a(long j2, zzer zzerVar) {
                zzaeb.b(j2, zzerVar, this.f24113a.f24115b);
            }
        });
        this.f24116c = zzgqVar;
        zzgqVar.a(3);
    }

    public final void a(zzaer zzaerVar, zzapu zzapuVar) {
        int i2 = 0;
        while (true) {
            zzaga[] zzagaVarArr = this.f24115b;
            if (i2 >= zzagaVarArr.length) {
                return;
            }
            zzapuVar.a();
            zzapuVar.b();
            zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 3);
            zzv zzvVar = (zzv) this.f24114a.get(i2);
            String str = zzvVar.f35691m;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            zzgqa.e(z, "Invalid closed caption MIME type provided: %s", str);
            zzt zztVar = new zzt();
            zzapuVar.b();
            zztVar.f35564a = zzapuVar.f24112e;
            zztVar.d("video/mp2t");
            zztVar.e(str);
            zztVar.f35568e = zzvVar.f35683e;
            zztVar.f35567d = zzvVar.f35682d;
            zztVar.I = zzvVar.J;
            zztVar.o = zzvVar.p;
            zzagaVarE.c(new zzv(zztVar));
            zzagaVarArr[i2] = zzagaVarE;
            i2++;
        }
    }

    public final void b(long j2, zzer zzerVar) {
        if (zzerVar.B() < 9) {
            return;
        }
        int iB = zzerVar.b();
        int iB2 = zzerVar.b();
        int iK = zzerVar.K();
        if (iB == 434 && iB2 == 1195456820 && iK == 3) {
            this.f24116c.b(j2, zzerVar);
        }
    }
}
