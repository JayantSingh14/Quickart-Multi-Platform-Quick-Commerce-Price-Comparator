package com.google.android.gms.measurement.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes.dex */
public final class zzfx {
    public static final zzfw A;
    public static final zzfw A0;
    public static final zzfw B;
    public static final zzfw B0;
    public static final zzfw C;
    public static final zzfw C0;
    public static final zzfw D;
    public static final zzfw D0;
    public static final zzfw E;
    public static final zzfw E0;
    public static final zzfw F;
    public static final zzfw F0;
    public static final zzfw G;
    public static final zzfw G0;
    public static final zzfw H;
    public static final zzfw H0;
    public static final zzfw I;
    public static final zzfw I0;
    public static final zzfw J;
    public static final zzfw J0;
    public static final zzfw K;
    public static final zzfw K0;
    public static final zzfw L;
    public static final zzfw L0;
    public static final zzfw M;
    public static final zzfw M0;
    public static final zzfw N;
    public static final zzfw N0;
    public static final zzfw O;
    public static final zzfw O0;
    public static final zzfw P;
    public static final zzfw P0;
    public static final zzfw Q;
    public static final zzfw Q0;
    public static final zzfw R;
    public static final zzfw R0;
    public static final zzfw S;
    public static final zzfw S0;
    public static final zzfw T;
    public static final zzfw T0;
    public static final zzfw U;
    public static final zzfw U0;
    public static final zzfw V;
    public static final zzfw V0;
    public static final zzfw W;
    public static final zzfw W0;
    public static final zzfw X;
    public static final zzfw X0;
    public static final zzfw Y;
    public static final zzfw Y0;
    public static final zzfw Z;
    public static final zzfw Z0;

    /* renamed from: a, reason: collision with root package name */
    public static final List f38902a = Collections.synchronizedList(new ArrayList());
    public static final zzfw a0;
    public static final zzfw a1;

    /* renamed from: b, reason: collision with root package name */
    public static final zzfw f38903b;
    public static final zzfw b0;
    public static final zzfw b1;

    /* renamed from: c, reason: collision with root package name */
    public static final zzfw f38904c;
    public static final zzfw c0;
    public static final zzfw c1;

    /* renamed from: d, reason: collision with root package name */
    public static final zzfw f38905d;
    public static final zzfw d0;
    public static final zzfw d1;

    /* renamed from: e, reason: collision with root package name */
    public static final zzfw f38906e;
    public static final zzfw e0;
    public static final zzfw e1;

    /* renamed from: f, reason: collision with root package name */
    public static final zzfw f38907f;
    public static final zzfw f0;
    public static final zzfw f1;

    /* renamed from: g, reason: collision with root package name */
    public static final zzfw f38908g;
    public static final zzfw g0;
    public static final zzfw g1;

    /* renamed from: h, reason: collision with root package name */
    public static final zzfw f38909h;
    public static final zzfw h0;
    public static final zzfw h1;

    /* renamed from: i, reason: collision with root package name */
    public static final zzfw f38910i;
    public static final zzfw i0;
    public static final zzfw i1;

    /* renamed from: j, reason: collision with root package name */
    public static final zzfw f38911j;
    public static final zzfw j0;
    public static final zzfw j1;

    /* renamed from: k, reason: collision with root package name */
    public static final zzfw f38912k;
    public static final zzfw k0;

    /* renamed from: l, reason: collision with root package name */
    public static final zzfw f38913l;
    public static final zzfw l0;

    /* renamed from: m, reason: collision with root package name */
    public static final zzfw f38914m;
    public static final zzfw m0;
    public static final zzfw n;
    public static final zzfw n0;
    public static final zzfw o;
    public static final zzfw o0;
    public static final zzfw p;
    public static final zzfw p0;
    public static final zzfw q;
    public static final zzfw q0;
    public static final zzfw r;
    public static final zzfw r0;
    public static final zzfw s;
    public static final zzfw s0;
    public static final zzfw t;
    public static final zzfw t0;
    public static final zzfw u;
    public static final zzfw u0;
    public static final zzfw v;
    public static final zzfw v0;
    public static final zzfw w;
    public static final zzfw w0;
    public static final zzfw x;
    public static final zzfw x0;
    public static final zzfw y;
    public static final zzfw y0;
    public static final zzfw z;
    public static final zzfw z0;

    static {
        Collections.synchronizedSet(new HashSet());
        f38903b = a("measurement.ad_id_cache_time", 10000L, zzfq.f38890a, false);
        Long lValueOf = Long.valueOf(DateUtils.MILLIS_PER_HOUR);
        f38904c = a("measurement.app_uninstalled_additional_ad_id_cache_time", lValueOf, zzbo.f38778a, false);
        Long lValueOf2 = Long.valueOf(DateUtils.MILLIS_PER_DAY);
        f38905d = a("measurement.monitoring.sample_period_millis", lValueOf2, zzcf.f38797a, false);
        f38906e = a("measurement.config.cache_time", lValueOf2, zzcq.f38808a, false);
        f38907f = a("measurement.config.url_scheme", "https", zzdb.f38822a, false);
        f38908g = a("measurement.config.url_authority", "app-measurement.com", zzdm.f38833a, false);
        f38909h = a("measurement.upload.max_bundles", 100, zzdx.f38844a, false);
        f38910i = a("measurement.upload.max_batch_size", 65536, zzei.f38856a, false);
        f38911j = a("measurement.upload.max_bundle_size", 65536, zzet.f38867a, false);
        f38912k = a("measurement.upload.max_events_per_bundle", 1000, zzfe.f38878a, false);
        f38913l = a("measurement.upload.max_events_per_day", 100000, zzfp.f38889a, false);
        f38914m = a("measurement.upload.max_error_events_per_day", 1000, zzbv.f38785a, false);
        n = a("measurement.upload.max_public_events_per_day", 50000, zzbw.f38786a, false);
        o = a("measurement.upload.max_conversions_per_day", 10000, zzbx.f38787a, false);
        p = a("measurement.upload.max_realtime_events_per_day", 10, zzby.f38788a, false);
        q = a("measurement.store.max_stored_events_per_app", 100000, zzbz.f38789a, false);
        r = a("measurement.upload.url", "https://app-measurement.com/a", zzca.f38792a, false);
        s = a("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d", zzcb.f38793a, false);
        t = a("measurement.sgtm.service_upload_apps_list", "", zzcc.f38794a, false);
        u = a("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504", zzcd.f38795a, false);
        v = a("measurement.sgtm.upload.retry_interval", 600000L, zzce.f38796a, false);
        w = a("measurement.sgtm.upload.retry_max_wait", 21600000L, zzcg.f38798a, false);
        x = a("measurement.sgtm.batch.retry_interval", 1800000L, zzch.f38799a, false);
        y = a("measurement.sgtm.batch.retry_max_wait", 21600000L, zzci.f38800a, false);
        z = a("measurement.sgtm.batch.retry_max_count", 10, zzcj.f38801a, false);
        A = a("measurement.sgtm.upload.max_queued_batches", 5000, zzck.f38802a, false);
        B = a("measurement.sgtm.upload.batches_retrieval_limit", 5, zzcl.f38803a, false);
        C = a("measurement.sgtm.upload.min_delay_after_startup", 5000L, zzcm.f38804a, false);
        D = a("measurement.sgtm.upload.min_delay_after_broadcast", 1000L, zzcn.f38805a, false);
        E = a("measurement.sgtm.upload.min_delay_after_background", 600000L, zzco.f38806a, false);
        F = a("measurement.sgtm.batch.long_queuing_threshold", 14400000L, zzcp.f38807a, false);
        G = a("measurement.upload.backoff_period", 43200000L, zzcr.f38809a, false);
        a("measurement.upload.window_interval", lValueOf, zzcs.f38810a, false);
        H = a("measurement.upload.interval", lValueOf, zzct.f38811a, false);
        I = a("measurement.upload.realtime_upload_interval", 10000L, zzcu.f38812a, false);
        J = a("measurement.upload.debug_upload_interval", 1000L, zzcv.f38813a, false);
        K = a("measurement.upload.minimum_delay", 500L, zzcw.f38814a, false);
        L = a("measurement.alarm_manager.minimum_interval", Long.valueOf(DateUtils.MILLIS_PER_MINUTE), zzcx.f38815a, false);
        M = a("measurement.upload.stale_data_deletion_interval", lValueOf2, zzcy.f38816a, false);
        N = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, zzcz.f38817a, false);
        O = a("measurement.upload.initial_upload_delay_time", 15000L, zzda.f38821a, false);
        P = a("measurement.upload.retry_time", 1800000L, zzdc.f38823a, false);
        Q = a("measurement.upload.retry_count", 6, zzdd.f38824a, false);
        R = a("measurement.upload.max_queue_time", 518400000L, zzde.f38825a, false);
        S = a("measurement.upload.google_signal_max_queue_time", 300000L, zzdf.f38826a, false);
        T = a("measurement.lifetimevalue.max_currency_tracked", 4, zzdg.f38827a, false);
        U = a("measurement.audience.filter_result_max_count", 200, zzdh.f38828a, false);
        V = a("measurement.upload.max_public_user_properties", 100, null, false);
        W = a("measurement.upload.max_event_name_cardinality", 2000, null, false);
        X = a("measurement.upload.max_public_event_params", 100, null, false);
        Y = a("measurement.service_client.idle_disconnect_millis", 5000L, zzdi.f38829a, false);
        Z = a("measurement.service_client.reconnect_millis", 1000L, zzdj.f38830a, false);
        Boolean bool = Boolean.FALSE;
        a0 = a("measurement.test.boolean_flag", bool, zzdk.f38831a, false);
        b0 = a("measurement.test.string_flag", "---", zzdl.f38832a, false);
        c0 = a("measurement.test.long_flag", -1L, zzdn.f38834a, false);
        a("measurement.test.cached_long_flag", -1L, zzdo.f38835a, true);
        d0 = a("measurement.test.int_flag", -2, zzdp.f38836a, false);
        e0 = a("measurement.test.double_flag", Double.valueOf(-3.0d), zzdq.f38837a, false);
        f0 = a("measurement.experiment.max_ids", 50, zzdr.f38838a, false);
        g0 = a("measurement.upload.max_item_scoped_custom_parameters", 27, zzds.f38839a, false);
        h0 = a("measurement.upload.max_event_parameter_value_length", 500, zzdt.f38840a, true);
        i0 = a("measurement.max_bundles_per_iteration", 100, zzdu.f38841a, false);
        j0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, zzdv.f38842a, false);
        k0 = a("measurement.redaction.app_instance_id.ttl", 7200000L, zzdw.f38843a, false);
        l0 = a("measurement.rb.attribution.client.min_ad_services_version", 7, zzdy.f38845a, false);
        m0 = a("measurement.dma_consent.max_daily_dcu_realtime_events", 1, zzdz.f38846a, false);
        n0 = a("measurement.rb.attribution.uri_scheme", "https", zzea.f38848a, false);
        o0 = a("measurement.rb.attribution.uri_authority", "google-analytics.com", zzeb.f38849a, false);
        p0 = a("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", zzec.f38850a, false);
        q0 = a("measurement.session.engagement_interval", lValueOf, zzed.f38851a, false);
        r0 = a("measurement.rb.attribution.app_allowlist", "com.labpixies.flood", zzee.f38852a, false);
        s0 = a("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot", zzef.f38853a, false);
        t0 = a("measurement.rb.attribution.event_params", "value|currency", zzeg.f38854a, false);
        u0 = a("measurement.rb.attribution.query_parameters_to_remove", "", zzeh.f38855a, false);
        v0 = a("measurement.rb.attribution.max_queue_time", 864000000L, zzej.f38857a, false);
        w0 = a("measurement.rb.attribution.max_retry_delay_seconds", 16, zzek.f38858a, false);
        x0 = a("measurement.rb.attribution.client.min_time_after_boot_seconds", 90, zzel.f38859a, false);
        a("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0, zzem.f38860a, false);
        y0 = a("measurement.rb.max_trigger_registrations_per_day", 1000, zzen.f38861a, false);
        Boolean bool2 = Boolean.TRUE;
        z0 = a("measurement.config.bundle_for_all_apps_on_backgrounded", bool2, zzeo.f38862a, false);
        A0 = a("measurement.config.notify_trigger_uris_on_backgrounded", bool2, zzep.f38863a, false);
        B0 = a("measurement.rb.attribution.notify_app_delay_millis", 3000, zzeq.f38864a, false);
        C0 = a("measurement.quality.checksum", bool, null, false);
        D0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, zzer.f38865a, false);
        E0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, zzes.f38866a, false);
        F0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, zzeu.f38868a, true);
        G0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, zzev.f38869a, false);
        H0 = a("measurement.integration.disable_firebase_instance_id", bool, zzew.f38870a, false);
        I0 = a("measurement.collection.service.update_with_analytics_fix", bool, zzex.f38871a, false);
        J0 = a("measurement.service.storage_consent_support_version", 203600, zzey.f38872a, false);
        K0 = a("measurement.service.store_null_safelist", bool2, zzez.f38873a, false);
        L0 = a("measurement.service.store_safelist", bool2, zzfa.f38874a, false);
        M0 = a("measurement.session_stitching_token_enabled", bool, zzfb.f38875a, false);
        N0 = a("measurement.sgtm.client.upload_on_backgrounded.dev", bool, zzfc.f38876a, true);
        O0 = a("measurement.gmscore_client_telemetry", bool, zzft.f38893a, false);
        P0 = a("measurement.rb.attribution.service", bool2, zzfd.f38877a, true);
        Q0 = a("measurement.rb.attribution.client2", bool2, zzff.f38879a, true);
        R0 = a("measurement.rb.attribution.uuid_generation", bool2, zzfg.f38880a, false);
        S0 = a("measurement.rb.attribution.enable_trigger_redaction", bool2, zzfh.f38881a, false);
        a("measurement.rb.attribution.followup1.service", bool, zzfi.f38882a, false);
        T0 = a("measurement.rb.attribution.retry_disposition", bool, zzfj.f38883a, false);
        U0 = a("measurement.client.sessions.enable_fix_background_engagement", bool, zzfv.f38895a, false);
        V0 = a("measurement.set_default_event_parameters_propagate_clear.service.dev", bool2, zzfk.f38884a, false);
        W0 = a("measurement.set_default_event_parameters_propagate_clear.client.dev", bool2, zzfl.f38885a, false);
        X0 = a("measurement.service.ad_impression.convert_value_to_double", bool2, zzfm.f38886a, false);
        a("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", bool2, zzfn.f38887a, false);
        a("measurement.remove_conflicting_first_party_apis.dev", bool, zzfo.f38888a, false);
        Y0 = a("measurement.rb.attribution.service.trigger_uris_high_priority", bool2, zzbp.f38779a, false);
        Z0 = a("measurement.tcf.consent_fix", bool, zzbq.f38780a, false);
        a1 = a("measurement.tcf.empty_pref_fix", bool2, zzbr.f38781a, false);
        b1 = a("measurement.experiment.enable_phenotype_experiment_reporting", bool2, zzbs.f38782a, false);
        c1 = a("measurement.set_default_event_parameters.fix_service_request_ordering", bool, zzbj.f38774a, false);
        d1 = a("measurement.set_default_event_parameters.fix_app_update_logging", bool2, zzbi.f38773a, false);
        e1 = a("measurement.service.fix_stop_bundling_bug", bool2, zzbm.f38777a, false);
        f1 = a("measurement.fix_params_logcat_spam", bool2, zzbl.f38776a, false);
        g1 = a("measurement.gbraid_campaign.stop_lgclid", bool, zzfs.f38892a, false);
        h1 = a("measurement.gbraid_compaign.compaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid", zzbt.f38783a, false);
        i1 = a("measurement.edpb.service", bool, zzbk.f38775a, false);
        j1 = a("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp", zzbu.f38784a, false);
    }

    public static zzfw a(String str, Object obj, zzbn zzbnVar, boolean z2) {
        zzfw zzfwVar = new zzfw(str, obj, zzbnVar);
        if (z2) {
            f38902a.add(zzfwVar);
        }
        return zzfwVar;
    }
}
