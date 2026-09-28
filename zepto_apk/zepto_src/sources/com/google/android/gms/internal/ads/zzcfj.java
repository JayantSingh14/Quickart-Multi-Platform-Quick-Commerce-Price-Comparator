package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcfj {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f26085a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26086b;

    /* renamed from: c, reason: collision with root package name */
    public final int f26087c;

    /* renamed from: d, reason: collision with root package name */
    public final int f26088d;

    /* renamed from: e, reason: collision with root package name */
    public final int f26089e;

    /* renamed from: f, reason: collision with root package name */
    public final int f26090f;

    /* renamed from: g, reason: collision with root package name */
    public final int f26091g;

    /* renamed from: h, reason: collision with root package name */
    public final int f26092h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f26093i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f26094j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f26095k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f26096l;

    /* renamed from: m, reason: collision with root package name */
    public final long f26097m;
    public final long n;

    public zzcfj(String str) throws JSONException {
        long jLongValue;
        long jLongValue2;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.f26085a = a(jSONObject, "aggressive_media_codec_release", zzbgk.h0);
        this.f26086b = b(jSONObject, "byte_buffer_precache_limit", zzbgk.f25023m);
        this.f26087c = b(jSONObject, "exo_cache_buffer_size", zzbgk.w);
        this.f26088d = b(jSONObject, "exo_connect_timeout_millis", zzbgk.f25019i);
        zzbgb zzbgbVar = zzbgk.f25018h;
        if (jSONObject != null) {
            try {
                jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
        }
        this.f26089e = b(jSONObject, "exo_read_timeout_millis", zzbgk.f25020j);
        this.f26090f = b(jSONObject, "load_check_interval_bytes", zzbgk.f25021k);
        this.f26091g = b(jSONObject, "player_precache_limit", zzbgk.f25022l);
        this.f26092h = b(jSONObject, "socket_receive_buffer_size", zzbgk.n);
        this.f26093i = a(jSONObject, "use_cache_data_source", zzbgk.X4);
        b(jSONObject, "min_retry_count", zzbgk.o);
        this.f26094j = a(jSONObject, "treat_load_exception_as_non_fatal", zzbgk.q);
        this.f26095k = a(jSONObject, "enable_multiple_video_playback", zzbgk.m2);
        this.f26096l = a(jSONObject, "use_range_http_data_source", zzbgk.o2);
        zzbgb zzbgbVar2 = zzbgk.p2;
        if (jSONObject != null) {
            try {
                jLongValue = jSONObject.getLong("range_http_data_source_high_water_mark");
            } catch (JSONException unused3) {
            }
        } else {
            jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgbVar2)).longValue();
        }
        this.f26097m = jLongValue;
        zzbgb zzbgbVar3 = zzbgk.q2;
        if (jSONObject != null) {
            try {
                jLongValue2 = jSONObject.getLong("range_http_data_source_low_water_mark");
            } catch (JSONException unused4) {
            }
        } else {
            jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgbVar3)).longValue();
        }
        this.n = jLongValue2;
    }

    public static final boolean a(JSONObject jSONObject, String str, zzbgb zzbgbVar) {
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgbVar)).booleanValue();
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return zBooleanValue;
    }

    public static final int b(JSONObject jSONObject, String str, zzbgb zzbgbVar) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgbVar)).intValue();
    }
}
