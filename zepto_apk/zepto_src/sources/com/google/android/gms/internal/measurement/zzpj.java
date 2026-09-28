package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzpj implements zzpi {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37244a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzkl f37245b;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        f37244a = zzkfVarB.d("measurement.set_default_event_parameters_propagate_clear.client.dev", true);
        f37245b = zzkfVarB.d("measurement.set_default_event_parameters_propagate_clear.service", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpi
    public final boolean zza() {
        return ((Boolean) f37244a.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpi
    public final boolean zzb() {
        return ((Boolean) f37245b.c()).booleanValue();
    }
}
