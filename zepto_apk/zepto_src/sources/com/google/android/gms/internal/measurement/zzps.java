package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzps implements zzpr {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37255a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzkl f37256b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzkl f37257c;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        zzkfVarB.d("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f37255a = zzkfVarB.d("measurement.audience.refresh_event_count_filters_timestamp", false);
        f37256b = zzkfVarB.d("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f37257c = zzkfVarB.d("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzpr
    public final boolean zzb() {
        return ((Boolean) f37255a.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpr
    public final boolean zzc() {
        return ((Boolean) f37256b.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpr
    public final boolean zzd() {
        return ((Boolean) f37257c.c()).booleanValue();
    }
}
