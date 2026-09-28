package com.google.android.gms.internal.measurement;

import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes.dex */
public final class zzpa implements zzoz {
    public static final zzkl A;
    public static final zzkl B;
    public static final zzkl C;
    public static final zzkl D;
    public static final zzkl E;
    public static final zzkl F;
    public static final zzkl G;
    public static final zzkl H;
    public static final zzkl I;
    public static final zzkl J;
    public static final zzkl K;
    public static final zzkl L;
    public static final zzkl M;
    public static final zzkl N;
    public static final zzkl O;
    public static final zzkl P;
    public static final zzkl Q;
    public static final zzkl R;
    public static final zzkl S;
    public static final zzkl T;
    public static final zzkl U;
    public static final zzkl V;
    public static final zzkl W;
    public static final zzkl X;
    public static final zzkl Y;
    public static final zzkl Z;

    /* renamed from: a, reason: collision with root package name */
    public static final zzkl f37222a;
    public static final zzkl a0;

    /* renamed from: b, reason: collision with root package name */
    public static final zzkl f37223b;
    public static final zzkl b0;

    /* renamed from: c, reason: collision with root package name */
    public static final zzkl f37224c;
    public static final zzkl c0;

    /* renamed from: d, reason: collision with root package name */
    public static final zzkl f37225d;
    public static final zzkl d0;

    /* renamed from: e, reason: collision with root package name */
    public static final zzkl f37226e;
    public static final zzkl e0;

    /* renamed from: f, reason: collision with root package name */
    public static final zzkl f37227f;
    public static final zzkl f0;

    /* renamed from: g, reason: collision with root package name */
    public static final zzkl f37228g;
    public static final zzkl g0;

    /* renamed from: h, reason: collision with root package name */
    public static final zzkl f37229h;
    public static final zzkl h0;

    /* renamed from: i, reason: collision with root package name */
    public static final zzkl f37230i;
    public static final zzkl i0;

    /* renamed from: j, reason: collision with root package name */
    public static final zzkl f37231j;
    public static final zzkl j0;

    /* renamed from: k, reason: collision with root package name */
    public static final zzkl f37232k;
    public static final zzkl k0;

    /* renamed from: l, reason: collision with root package name */
    public static final zzkl f37233l;
    public static final zzkl l0;

    /* renamed from: m, reason: collision with root package name */
    public static final zzkl f37234m;
    public static final zzkl m0;
    public static final zzkl n;
    public static final zzkl n0;
    public static final zzkl o;
    public static final zzkl o0;
    public static final zzkl p;
    public static final zzkl p0;
    public static final zzkl q;
    public static final zzkl q0;
    public static final zzkl r;
    public static final zzkl r0;
    public static final zzkl s;
    public static final zzkl s0;
    public static final zzkl t;
    public static final zzkl t0;
    public static final zzkl u;
    public static final zzkl u0;
    public static final zzkl v;
    public static final zzkl v0;
    public static final zzkl w;
    public static final zzkl w0;
    public static final zzkl x;
    public static final zzkl y;
    public static final zzkl z;

    static {
        zzkf zzkfVarB = new zzkf(zzka.a(), false, false).a().b();
        f37222a = zzkfVarB.c(10000L, "measurement.ad_id_cache_time");
        f37223b = zzkfVarB.c(DateUtils.MILLIS_PER_HOUR, "measurement.app_uninstalled_additional_ad_id_cache_time");
        f37224c = zzkfVarB.d("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        f37225d = zzkfVarB.c(100L, "measurement.max_bundles_per_iteration");
        f37226e = zzkfVarB.e("measurement.gbraid_campaign.campaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid");
        f37227f = zzkfVarB.c(DateUtils.MILLIS_PER_DAY, "measurement.config.cache_time");
        zzkfVarB.e("measurement.log_tag", "FA");
        f37228g = zzkfVarB.e("measurement.config.url_authority", "app-measurement.com");
        f37229h = zzkfVarB.e("measurement.config.url_scheme", "https");
        f37230i = zzkfVarB.c(1000L, "measurement.upload.debug_upload_interval");
        zzkfVarB.d("measurement.config.default_flag_values", true);
        f37231j = zzkfVarB.c(DateUtils.MILLIS_PER_HOUR, "measurement.session.engagement_interval");
        f37232k = zzkfVarB.e("measurement.rb.attribution.event_params", "value|currency");
        f37233l = zzkfVarB.e("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp");
        f37234m = zzkfVarB.c(605000L, "measurement.upload.google_signal_max_queue_time");
        n = zzkfVarB.e("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        o = zzkfVarB.c(4L, "measurement.lifetimevalue.max_currency_tracked");
        p = zzkfVarB.c(1L, "measurement.dma_consent.max_daily_dcu_realtime_events");
        q = zzkfVarB.c(500L, "measurement.upload.max_event_parameter_value_length");
        r = zzkfVarB.c(100000L, "measurement.store.max_stored_events_per_app");
        s = zzkfVarB.c(50L, "measurement.experiment.max_ids");
        t = zzkfVarB.c(200L, "measurement.audience.filter_result_max_count");
        u = zzkfVarB.c(27L, "measurement.upload.max_item_scoped_custom_parameters");
        v = zzkfVarB.c(1000L, "measurement.rb.max_trigger_registrations_per_day");
        w = zzkfVarB.c(0L, "measurement.rb.attribution.max_trigger_uris_queried_at_once");
        x = zzkfVarB.c(7L, "measurement.rb.attribution.client.min_ad_services_version");
        y = zzkfVarB.c(DateUtils.MILLIS_PER_MINUTE, "measurement.alarm_manager.minimum_interval");
        z = zzkfVarB.c(500L, "measurement.upload.minimum_delay");
        A = zzkfVarB.c(DateUtils.MILLIS_PER_DAY, "measurement.monitoring.sample_period_millis");
        B = zzkfVarB.c(3000L, "measurement.rb.attribution.notify_app_delay_millis");
        C = zzkfVarB.d("measurement.config.notify_trigger_uris_on_backgrounded", true);
        zzkfVarB.c(0L, "measurement.id.rb.attribution.app_allowlist");
        D = zzkfVarB.e("measurement.rb.attribution.app_allowlist", "com.labpixies.flood");
        E = zzkfVarB.c(10000L, "measurement.upload.realtime_upload_interval");
        F = zzkfVarB.c(604800000L, "measurement.upload.refresh_blacklisted_config_interval");
        zzkfVarB.c(DateUtils.MILLIS_PER_HOUR, "measurement.config.cache_time.service");
        G = zzkfVarB.c(5000L, "measurement.service_client.idle_disconnect_millis");
        zzkfVarB.e("measurement.log_tag.service", "FA-SVC");
        H = zzkfVarB.c(1000L, "measurement.service_client.reconnect_millis");
        zzkfVarB.e("measurement.sgtm.app_allowlist", "*");
        I = zzkfVarB.c(240000L, "measurement.sgtm.batch.long_queuing_threshold");
        J = zzkfVarB.c(1800000L, "measurement.sgtm.batch.retry_interval");
        K = zzkfVarB.c(10L, "measurement.sgtm.batch.retry_max_count");
        L = zzkfVarB.c(21600000L, "measurement.sgtm.batch.retry_max_wait");
        M = zzkfVarB.e("measurement.sgtm.service_upload_apps_list", "");
        N = zzkfVarB.e("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        O = zzkfVarB.c(5L, "measurement.sgtm.upload.batches_retrieval_limit");
        P = zzkfVarB.c(5000L, "measurement.sgtm.upload.max_queued_batches");
        Q = zzkfVarB.c(600000L, "measurement.sgtm.upload.min_delay_after_background");
        R = zzkfVarB.c(1000L, "measurement.sgtm.upload.min_delay_after_broadcast");
        S = zzkfVarB.c(5000L, "measurement.sgtm.upload.min_delay_after_startup");
        T = zzkfVarB.c(600000L, "measurement.sgtm.upload.retry_interval");
        U = zzkfVarB.c(21600000L, "measurement.sgtm.upload.retry_max_wait");
        V = zzkfVarB.c(DateUtils.MILLIS_PER_DAY, "measurement.upload.stale_data_deletion_interval");
        W = zzkfVarB.c(16L, "measurement.rb.attribution.max_retry_delay_seconds");
        X = zzkfVarB.c(90L, "measurement.rb.attribution.client.min_time_after_boot_seconds");
        Y = zzkfVarB.e("measurement.rb.attribution.uri_authority", "google-analytics.com");
        Z = zzkfVarB.c(864000000L, "measurement.rb.attribution.max_queue_time");
        a0 = zzkfVarB.e("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        b0 = zzkfVarB.e("measurement.rb.attribution.query_parameters_to_remove", "");
        c0 = zzkfVarB.e("measurement.rb.attribution.uri_scheme", "https");
        d0 = zzkfVarB.c(604800000L, "measurement.sdk.attribution.cache.ttl");
        e0 = zzkfVarB.c(7200000L, "measurement.redaction.app_instance_id.ttl");
        f0 = zzkfVarB.c(43200000L, "measurement.upload.backoff_period");
        g0 = zzkfVarB.c(15000L, "measurement.upload.initial_upload_delay_time");
        h0 = zzkfVarB.c(DateUtils.MILLIS_PER_HOUR, "measurement.upload.interval");
        i0 = zzkfVarB.c(65536L, "measurement.upload.max_bundle_size");
        j0 = zzkfVarB.c(100L, "measurement.upload.max_bundles");
        k0 = zzkfVarB.c(500L, "measurement.upload.max_conversions_per_day");
        l0 = zzkfVarB.c(1000L, "measurement.upload.max_error_events_per_day");
        m0 = zzkfVarB.c(1000L, "measurement.upload.max_events_per_bundle");
        n0 = zzkfVarB.c(100000L, "measurement.upload.max_events_per_day");
        o0 = zzkfVarB.c(50000L, "measurement.upload.max_public_events_per_day");
        p0 = zzkfVarB.c(518400000L, "measurement.upload.max_queue_time");
        q0 = zzkfVarB.c(10L, "measurement.upload.max_realtime_events_per_day");
        r0 = zzkfVarB.c(65536L, "measurement.upload.max_batch_size");
        s0 = zzkfVarB.c(6L, "measurement.upload.retry_count");
        t0 = zzkfVarB.c(1800000L, "measurement.upload.retry_time");
        u0 = zzkfVarB.e("measurement.upload.url", "https://app-measurement.com/a");
        v0 = zzkfVarB.c(DateUtils.MILLIS_PER_HOUR, "measurement.upload.window_interval");
        w0 = zzkfVarB.e("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String A() {
        return (String) M.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long C() {
        return ((Long) T.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String D() {
        return (String) a0.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long E() {
        return ((Long) r0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long F() {
        return ((Long) s0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long G() {
        return ((Long) R.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long H() {
        return ((Long) A.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long I() {
        return ((Long) z.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long J() {
        return ((Long) W.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long K() {
        return ((Long) g0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long L() {
        return ((Long) U.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long M() {
        return ((Long) e0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long N() {
        return ((Long) f0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long O() {
        return ((Long) K.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String P() {
        return (String) w0.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long Q() {
        return ((Long) l0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long R() {
        return ((Long) m0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long S() {
        return ((Long) j0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long T() {
        return ((Long) i0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long U() {
        return ((Long) I.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long V() {
        return ((Long) k0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String W() {
        return (String) c0.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long X() {
        return ((Long) d0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long Y() {
        return ((Long) Q.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String Z() {
        return (String) b0.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long a() {
        return ((Long) J.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long b() {
        return ((Long) y.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long c() {
        return ((Long) u.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long d() {
        return ((Long) S.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String e() {
        return (String) Y.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long e0() {
        return ((Long) P.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long f() {
        return ((Long) t.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long g() {
        return ((Long) q0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long h() {
        return ((Long) v.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long i() {
        return ((Long) t0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long j() {
        return ((Long) w.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String k() {
        return (String) D.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long l() {
        return ((Long) G.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long m() {
        return ((Long) H.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long n() {
        return ((Long) X.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long o() {
        return ((Long) h0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long p() {
        return ((Long) v0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long q() {
        return ((Long) V.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long s() {
        return ((Long) Z.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long t() {
        return ((Long) B.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long u() {
        return ((Long) p0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final boolean v() {
        return ((Boolean) C.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long w() {
        return ((Long) F.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long x() {
        return ((Long) E.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long y() {
        return ((Long) x.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long z() {
        return ((Long) L.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzN() {
        return (String) N.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzO() {
        return ((Long) O.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zza() {
        return ((Long) f37222a.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzan() {
        return ((Long) n0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzao() {
        return ((Long) o0.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzau() {
        return (String) u0.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzb() {
        return ((Long) f37223b.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final boolean zzc() {
        return ((Boolean) f37224c.c()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzd() {
        return ((Long) f37225d.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zze() {
        return (String) f37226e.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzf() {
        return ((Long) f37227f.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzg() {
        return (String) f37228g.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzh() {
        return (String) f37229h.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzi() {
        return ((Long) f37230i.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzj() {
        return ((Long) f37231j.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzk() {
        return (String) f37232k.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzl() {
        return (String) f37233l.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzm() {
        return ((Long) f37234m.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final String zzn() {
        return (String) n.c();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzo() {
        return ((Long) o.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzp() {
        return ((Long) p.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzq() {
        return ((Long) q.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzr() {
        return ((Long) r.c()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoz
    public final long zzs() {
        return ((Long) s.c()).longValue();
    }
}
