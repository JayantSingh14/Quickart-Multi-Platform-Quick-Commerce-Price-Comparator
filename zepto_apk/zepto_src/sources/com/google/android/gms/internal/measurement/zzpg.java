package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzpg implements zzpf {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37240a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzkl f37241b;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        zzkfVarB.d("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        zzkfVarB.d("measurement.set_default_event_parameters_with_backfill.service", true);
        zzkfVarB.c(0L, "measurement.id.set_default_event_parameters.fix_service_request_ordering");
        f37240a = zzkfVarB.d("measurement.set_default_event_parameters.fix_app_update_logging", true);
        f37241b = zzkfVarB.d("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        zzkfVarB.d("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpf
    public final boolean zza() {
        return ((Boolean) f37240a.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpf
    public final boolean zzb() {
        return ((Boolean) f37241b.c()).booleanValue();
    }
}
