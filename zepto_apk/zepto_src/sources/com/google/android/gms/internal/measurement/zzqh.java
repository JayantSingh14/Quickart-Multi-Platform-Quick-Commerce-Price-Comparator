package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public final class zzqh implements zzqg {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37272a;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        zzkfVarB.d("measurement.sdk.collection.enable_extend_user_property_size", true);
        f37272a = zzkfVarB.d("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzkfVarB.c(0L, "measurement.id.sdk.collection.last_deep_link_referrer2");
    }

    @Override // com.google.android.gms.internal.measurement.zzqg
    public final boolean zza() {
        return ((Boolean) f37272a.c()).booleanValue();
    }
}
