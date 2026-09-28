package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaoy implements zzapg {

    /* renamed from: a, reason: collision with root package name */
    public zzv f24018a;

    /* renamed from: b, reason: collision with root package name */
    public zzfg f24019b;

    /* renamed from: c, reason: collision with root package name */
    public zzaga f24020c;

    public zzaoy(String str) {
        zzt zztVar = new zzt();
        zztVar.d("video/mp2t");
        zztVar.e(str);
        this.f24018a = new zzv(zztVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final void a(zzfg zzfgVar, zzaer zzaerVar, zzapu zzapuVar) {
        this.f24019b = zzfgVar;
        zzapuVar.a();
        zzapuVar.b();
        zzaga zzagaVarE = zzaerVar.e(zzapuVar.f24111d, 5);
        this.f24020c = zzagaVarE;
        zzagaVarE.c(this.f24018a);
    }

    @Override // com.google.android.gms.internal.ads.zzapg
    public final void b(zzer zzerVar) {
        long jA;
        long j2;
        this.f24019b.getClass();
        String str = zzfj.f31254a;
        zzfg zzfgVar = this.f24019b;
        synchronized (zzfgVar) {
            try {
                long j3 = zzfgVar.f31049c;
                jA = j3 != -9223372036854775807L ? j3 + zzfgVar.f31048b : zzfgVar.a();
            } finally {
            }
        }
        zzfg zzfgVar2 = this.f24019b;
        synchronized (zzfgVar2) {
            j2 = zzfgVar2.f31048b;
        }
        if (jA == -9223372036854775807L || j2 == -9223372036854775807L) {
            return;
        }
        zzv zzvVar = this.f24018a;
        if (j2 != zzvVar.r) {
            zzt zztVar = new zzt(zzvVar);
            zztVar.q = j2;
            zzv zzvVar2 = new zzv(zztVar);
            this.f24018a = zzvVar2;
            this.f24020c.c(zzvVar2);
        }
        int iB = zzerVar.B();
        this.f24020c.b(iB, zzerVar);
        this.f24020c.e(jA, 1, iB, 0, null);
    }
}
