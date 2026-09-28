package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzf {

    /* renamed from: a, reason: collision with root package name */
    public final zzaw f36938a;

    /* renamed from: b, reason: collision with root package name */
    public final zzg f36939b;

    /* renamed from: c, reason: collision with root package name */
    public final zzg f36940c;

    /* renamed from: d, reason: collision with root package name */
    public final zzj f36941d;

    public zzf() {
        zzaw zzawVar = new zzaw();
        this.f36938a = zzawVar;
        zzg zzgVar = new zzg(null, zzawVar);
        this.f36940c = zzgVar;
        this.f36939b = zzgVar.c();
        zzj zzjVar = new zzj();
        this.f36941d = zzjVar;
        zzgVar.e("require", new zzw(zzjVar));
        zzjVar.a("internal.platform", zze.f36885a);
        zzgVar.e("runtime.counter", new zzah(Double.valueOf(0.0d)));
    }

    public final zzao a(zzg zzgVar, zzje... zzjeVarArr) {
        zzao zzaoVarB = zzao.o0;
        for (zzje zzjeVar : zzjeVarArr) {
            zzaoVarB = zzi.b(zzjeVar);
            zzh.k(this.f36940c);
            if ((zzaoVarB instanceof zzap) || (zzaoVarB instanceof zzan)) {
                zzaoVarB = this.f36938a.b(zzgVar, zzaoVarB);
            }
        }
        return zzaoVarB;
    }
}
