package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzrf implements zzre {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37308a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzkl f37309b;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        f37308a = zzkfVarB.d("measurement.tcf.consent_fix", false);
        zzkfVarB.d("measurement.tcf.client", true);
        f37309b = zzkfVarB.d("measurement.tcf.empty_pref_fix", true);
        zzkfVarB.c(0L, "measurement.id.tcf");
    }

    @Override // com.google.android.gms.internal.measurement.zzre
    public final boolean zza() {
        return ((Boolean) f37308a.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzre
    public final boolean zzb() {
        return ((Boolean) f37309b.c()).booleanValue();
    }
}
