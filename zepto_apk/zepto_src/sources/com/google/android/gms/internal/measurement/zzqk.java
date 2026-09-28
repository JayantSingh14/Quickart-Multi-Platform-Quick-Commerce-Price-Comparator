package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzqk implements zzqj {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37275a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzkl f37276b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzkl f37277c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzkl f37278d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzkl f37279e;

    /* renamed from: f, reason: collision with root package name */
    public static final zzkl f37280f;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        f37275a = zzkfVarB.d("measurement.test.boolean_flag", false);
        f37276b = zzkfVarB.c(-1L, "measurement.test.cached_long_flag");
        Double dValueOf = Double.valueOf(-3.0d);
        Object obj = zzkl.f37031f;
        f37277c = new zzkd(zzkfVarB, "measurement.test.double_flag", dValueOf);
        f37278d = zzkfVarB.c(-2L, "measurement.test.int_flag");
        f37279e = zzkfVarB.c(-1L, "measurement.test.long_flag");
        f37280f = zzkfVarB.e("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final boolean zza() {
        return ((Boolean) f37275a.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final long zzb() {
        return ((Long) f37276b.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final double zzc() {
        return ((Double) f37277c.c()).doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final long zzd() {
        return ((Long) f37278d.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final long zze() {
        return ((Long) f37279e.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqj
    public final String zzf() {
        return (String) f37280f.c();
    }
}
