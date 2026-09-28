package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzqw implements zzqv {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37299a;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        f37299a = zzkfVarB.d("measurement.session_stitching_token_enabled", false);
        zzkfVarB.d("measurement.link_sst_to_sid", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqv
    public final boolean zzb() {
        return ((Boolean) f37299a.c()).booleanValue();
    }
}
