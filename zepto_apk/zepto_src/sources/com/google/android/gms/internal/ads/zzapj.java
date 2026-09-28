package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes4.dex */
public final class zzapj {

    /* renamed from: a, reason: collision with root package name */
    public final List f24068a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaga[] f24069b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgq f24070c = new zzgq(new zzgp() { // from class: com.google.android.gms.internal.ads.zzapi
        @Override // com.google.android.gms.internal.ads.zzgp
        public final /* synthetic */ void a(long j2, zzer zzerVar) {
            zzaeb.a(j2, zzerVar, this.f24067a.f24069b);
        }
    });

    public zzapj(List list) {
        this.f24068a = list;
        this.f24069b = new zzaga[list.size()];
    }

    public final void a(zzaer zzaerVar, zzapu zzapuVar) {
        int i2 = 0;
        while (true) {
            zzaga[] zzagaVarArr = this.f24069b;
            if (i2 >= zzagaVarArr.length) {
                return;
            }
            zzapuVar.a();
            zzapuVar.b();
            zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 3);
            zzv zzvVar = (zzv) this.f24068a.get(i2);
            String str = zzvVar.f35691m;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            zzgqa.e(z, "Invalid closed caption MIME type provided: %s", str);
            String str2 = zzvVar.f35679a;
            if (str2 == null) {
                zzapuVar.b();
                str2 = zzapuVar.f24112e;
            }
            zzt zztVar = new zzt();
            zztVar.f35564a = str2;
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
}
