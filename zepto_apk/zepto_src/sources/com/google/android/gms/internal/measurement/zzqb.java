package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzqb implements zzqa {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37266a;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        zzkfVarB.d("measurement.gbraid_campaign.gbraid.client", true);
        f37266a = zzkfVarB.d("measurement.gbraid_campaign.stop_lgclid", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzqa
    public final boolean zza() {
        return ((Boolean) f37266a.c()).booleanValue();
    }
}
