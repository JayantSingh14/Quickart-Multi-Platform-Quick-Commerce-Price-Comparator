package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzpp implements zzpo {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37251a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzkl f37252b;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        zzkfVarB.d("measurement.collection.event_safelist", true);
        f37251a = zzkfVarB.d("measurement.service.store_null_safelist", true);
        f37252b = zzkfVarB.d("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzb() {
        return ((Boolean) f37251a.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpo
    public final boolean zzc() {
        return ((Boolean) f37252b.c()).booleanValue();
    }
}
