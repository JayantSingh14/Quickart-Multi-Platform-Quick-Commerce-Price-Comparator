package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
final class zzbc implements zzbe {

    /* renamed from: a, reason: collision with root package name */
    public final zzg f36782a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36783b;

    public zzbc(zzg zzgVar, String str) {
        this.f36782a = zzgVar;
        this.f36783b = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzbe
    public final zzg a(zzao zzaoVar) {
        zzg zzgVarC = this.f36782a.c();
        String str = this.f36783b;
        zzgVarC.f(str, zzaoVar);
        zzgVarC.f36958d.put(str, Boolean.TRUE);
        return zzgVarC;
    }
}
