package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzqe implements zzqd {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37269a;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        zzkfVarB.d("measurement.gmscore_feature_tracking", true);
        f37269a = zzkfVarB.d("measurement.gmscore_client_telemetry", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zza() {
        return ((Boolean) f37269a.c()).booleanValue();
    }
}
