package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzpd implements zzpc {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37237a;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        zzkfVarB.d("measurement.client.3p_consent_state_v1", true);
        f37237a = zzkfVarB.c(203600L, "measurement.service.storage_consent_support_version");
    }

    @Override // com.google.android.gms.internal.measurement.zzpc
    public final long zza() {
        return ((Long) f37237a.c()).longValue();
    }
}
