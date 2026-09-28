package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzox implements zzow {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37219a;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        f37219a = zzkfVarB.d("measurement.service.ad_impression.convert_value_to_double", true);
        zzkfVarB.d("measurement.service.separate_public_internal_event_blacklisting", true);
        zzkfVarB.d("measurement.service.ad_impression", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzow
    public final boolean zza() {
        return ((Boolean) f37219a.c()).booleanValue();
    }
}
