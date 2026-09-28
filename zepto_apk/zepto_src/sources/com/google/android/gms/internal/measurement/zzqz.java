package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzqz implements zzqy {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37302a;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        f37302a = zzkfVarB.d("measurement.client.sessions.enable_fix_background_engagement", false);
        zzkfVarB.d("measurement.client.sessions.enable_pause_engagement_in_background", true);
        zzkfVarB.c(0L, "measurement.id.client.sessions.enable_fix_background_engagement");
    }

    @Override // com.google.android.gms.internal.measurement.zzqy
    public final boolean zza() {
        return ((Boolean) f37302a.c()).booleanValue();
    }
}
