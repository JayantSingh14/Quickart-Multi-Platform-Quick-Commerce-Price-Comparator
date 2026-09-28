package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class zzqn implements zzqm {

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37283a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzkl f37284b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzkl f37285c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzkl f37286d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzkl f37287e;

    /* renamed from: f, reason: collision with root package name */
    public static final zzkl f37288f;

    /* renamed from: g, reason: collision with root package name */
    public static final zzkl f37289g;

    /* renamed from: h, reason: collision with root package name */
    public static final zzkl f37290h;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        zzkfVarB.d("measurement.rb.attribution.ad_campaign_info", true);
        zzkfVarB.d("measurement.rb.attribution.service.bundle_on_backgrounded", true);
        f37283a = zzkfVarB.d("measurement.rb.attribution.client2", true);
        f37284b = zzkfVarB.d("measurement.rb.attribution.followup1.service", false);
        zzkfVarB.d("measurement.rb.attribution.client.get_trigger_uris_async", true);
        f37285c = zzkfVarB.d("measurement.rb.attribution.service.trigger_uris_high_priority", true);
        zzkfVarB.d("measurement.rb.attribution.index_out_of_bounds_fix", true);
        f37286d = zzkfVarB.d("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", true);
        f37287e = zzkfVarB.d("measurement.rb.attribution.retry_disposition", false);
        f37288f = zzkfVarB.d("measurement.rb.attribution.service", true);
        f37289g = zzkfVarB.d("measurement.rb.attribution.enable_trigger_redaction", true);
        f37290h = zzkfVarB.d("measurement.rb.attribution.uuid_generation", true);
        zzkfVarB.c(0L, "measurement.id.rb.attribution.retry_disposition");
        zzkfVarB.d("measurement.rb.attribution.improved_retry", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzb() {
        return ((Boolean) f37283a.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzc() {
        return ((Boolean) f37284b.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzd() {
        return ((Boolean) f37285c.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zze() {
        return ((Boolean) f37286d.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzf() {
        return ((Boolean) f37287e.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzg() {
        return ((Boolean) f37288f.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzh() {
        return ((Boolean) f37289g.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzqm
    public final boolean zzi() {
        return ((Boolean) f37290h.c()).booleanValue();
    }
}
