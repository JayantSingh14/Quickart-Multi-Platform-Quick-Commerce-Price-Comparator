package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbdk;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbib;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzccv;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzgxi;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzj implements zzg {

    /* renamed from: b, reason: collision with root package name */
    public boolean f21581b;

    /* renamed from: d, reason: collision with root package name */
    public ListenableFuture f21583d;

    /* renamed from: f, reason: collision with root package name */
    public SharedPreferences f21585f;

    /* renamed from: g, reason: collision with root package name */
    public SharedPreferences.Editor f21586g;

    /* renamed from: i, reason: collision with root package name */
    public String f21588i;

    /* renamed from: j, reason: collision with root package name */
    public String f21589j;

    /* renamed from: a, reason: collision with root package name */
    public final Object f21580a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f21582c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public zzbdk f21584e = null;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21587h = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f21590k = true;

    /* renamed from: l, reason: collision with root package name */
    public String f21591l = "-1";

    /* renamed from: m, reason: collision with root package name */
    public int f21592m = -1;
    public zzccv n = new zzccv("", 0);
    public long o = 0;
    public long p = 0;
    public int q = -1;
    public int r = 0;
    public Set s = Collections.EMPTY_SET;
    public JSONObject t = new JSONObject();
    public boolean u = true;
    public boolean v = true;
    public String w = null;
    public String x = "";
    public boolean y = false;
    public String z = "";
    public String A = "{}";
    public int B = -1;
    public int C = -1;
    public long D = 0;

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void P(boolean z) {
        d();
        synchronized (this.f21580a) {
            try {
                if (z == this.f21590k) {
                    return;
                }
                this.f21590k = z;
                SharedPreferences.Editor editor = this.f21586g;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z);
                    this.f21586g.apply();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void P0(String str) {
        d();
        synchronized (this.f21580a) {
            try {
                this.f21591l = str;
                if (this.f21586g != null) {
                    if (str.equals("-1")) {
                        this.f21586g.remove("IABTCF_TCString");
                    } else {
                        this.f21586g.putString("IABTCF_TCString", str);
                    }
                    this.f21586g.apply();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void Q(int i2) {
        d();
        synchronized (this.f21580a) {
            try {
                if (this.C == i2) {
                    return;
                }
                this.C = i2;
                SharedPreferences.Editor editor = this.f21586g;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i2);
                    this.f21586g.apply();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void Q0(int i2) {
        d();
        synchronized (this.f21580a) {
            try {
                this.f21592m = i2;
                SharedPreferences.Editor editor = this.f21586g;
                if (editor != null) {
                    if (i2 == -1) {
                        editor.remove("gad_has_consent_for_cookies");
                    } else {
                        editor.putInt("gad_has_consent_for_cookies", i2);
                    }
                    this.f21586g.apply();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void R0(long j2) {
        d();
        synchronized (this.f21580a) {
            try {
                if (this.D == j2) {
                    return;
                }
                this.D = j2;
                SharedPreferences.Editor editor = this.f21586g;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j2);
                    this.f21586g.apply();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.pa)).booleanValue()) {
            d();
            synchronized (this.f21580a) {
                try {
                    if (this.y == z) {
                        return;
                    }
                    this.y = z;
                    SharedPreferences.Editor editor = this.f21586g;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z);
                        this.f21586g.apply();
                    }
                    e();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void b(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.pa)).booleanValue()) {
            d();
            synchronized (this.f21580a) {
                try {
                    if (this.z.equals(str)) {
                        return;
                    }
                    this.z = str;
                    SharedPreferences.Editor editor = this.f21586g;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.f21586g.apply();
                    }
                    e();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void c(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Da)).booleanValue()) {
            d();
            synchronized (this.f21580a) {
                try {
                    if (this.A.equals(str)) {
                        return;
                    }
                    this.A = str;
                    SharedPreferences.Editor editor = this.f21586g;
                    if (editor != null) {
                        editor.putString("inspector_ui_storage", str);
                        this.f21586g.apply();
                    }
                    e();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void d() {
        ListenableFuture listenableFuture = this.f21583d;
        if (listenableFuture == null || listenableFuture.isDone()) {
            return;
        }
        try {
            this.f21583d.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.g("Interrupted while waiting for preferences loaded.", e2);
        } catch (CancellationException e3) {
            e = e3;
            int i3 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e4) {
            e = e4;
            int i32 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e5) {
            e = e5;
            int i322 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    public final void e() {
        zzcdo.f25982a.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzh
            @Override // java.lang.Runnable
            public final void run() {
                zzj zzjVar = this.f21577a;
                if (zzjVar.f21581b) {
                    if (!(zzjVar.g() && zzjVar.h()) && ((Boolean) zzbib.f25116b.c()).booleanValue()) {
                        synchronized (zzjVar.f21580a) {
                            try {
                                if (Looper.getMainLooper() == null) {
                                    return;
                                }
                                if (zzjVar.f21584e == null) {
                                    zzjVar.f21584e = new zzbdk();
                                }
                                zzbdk zzbdkVar = zzjVar.f21584e;
                                synchronized (zzbdkVar.f24786c) {
                                    try {
                                        if (zzbdkVar.f24784a) {
                                            int i2 = zze.f21576b;
                                            com.google.android.gms.ads.internal.util.client.zzo.a("Content hash thread already started, quitting...");
                                        } else {
                                            zzbdkVar.f24784a = true;
                                            zzbdkVar.start();
                                        }
                                    } finally {
                                    }
                                }
                                int i3 = zze.f21576b;
                                com.google.android.gms.ads.internal.util.client.zzo.e("start fetching content...");
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
            }
        });
    }

    public final void f(final Context context) {
        synchronized (this.f21580a) {
            try {
                if (this.f21585f != null) {
                    return;
                }
                this.f21583d = ((zzgxi) zzcdo.f25982a).submit(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzi
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzj zzjVar = this.f21578a;
                        Context context2 = context;
                        zzjVar.getClass();
                        SharedPreferences sharedPreferences = context2.getSharedPreferences("admob", 0);
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        try {
                            synchronized (zzjVar.f21580a) {
                                try {
                                    zzjVar.f21585f = sharedPreferences;
                                    zzjVar.f21586g = editorEdit;
                                    NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                                    zzjVar.f21587h = zzjVar.f21585f.getBoolean("use_https", zzjVar.f21587h);
                                    zzjVar.u = zzjVar.f21585f.getBoolean("content_url_opted_out", zzjVar.u);
                                    zzjVar.f21588i = zzjVar.f21585f.getString("content_url_hashes", zzjVar.f21588i);
                                    zzjVar.f21590k = zzjVar.f21585f.getBoolean("gad_idless", zzjVar.f21590k);
                                    zzjVar.v = zzjVar.f21585f.getBoolean("content_vertical_opted_out", zzjVar.v);
                                    zzjVar.f21589j = zzjVar.f21585f.getString("content_vertical_hashes", zzjVar.f21589j);
                                    zzjVar.r = zzjVar.f21585f.getInt("version_code", zzjVar.r);
                                    if (((Boolean) zzbic.f25127g.c()).booleanValue() && com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.f25009j) {
                                        zzjVar.n = new zzccv("", 0L);
                                    } else {
                                        zzjVar.n = new zzccv(zzjVar.f21585f.getString("app_settings_json", zzjVar.n.f25911e), zzjVar.f21585f.getLong("app_settings_last_update_ms", zzjVar.n.f25912f));
                                    }
                                    zzjVar.o = zzjVar.f21585f.getLong("app_last_background_time_ms", zzjVar.o);
                                    zzjVar.q = zzjVar.f21585f.getInt("request_in_session_count", zzjVar.q);
                                    zzjVar.p = zzjVar.f21585f.getLong("first_ad_req_time_ms", zzjVar.p);
                                    zzjVar.s = zzjVar.f21585f.getStringSet("never_pool_slots", zzjVar.s);
                                    zzjVar.w = zzjVar.f21585f.getString("display_cutout", zzjVar.w);
                                    zzjVar.B = zzjVar.f21585f.getInt("app_measurement_npa", zzjVar.B);
                                    zzjVar.C = zzjVar.f21585f.getInt("sd_app_measure_npa", zzjVar.C);
                                    zzjVar.D = zzjVar.f21585f.getLong("sd_app_measure_npa_ts", zzjVar.D);
                                    zzjVar.x = zzjVar.f21585f.getString("inspector_info", zzjVar.x);
                                    zzjVar.y = zzjVar.f21585f.getBoolean("linked_device", zzjVar.y);
                                    zzjVar.z = zzjVar.f21585f.getString("linked_ad_unit", zzjVar.z);
                                    zzjVar.A = zzjVar.f21585f.getString("inspector_ui_storage", zzjVar.A);
                                    zzjVar.f21591l = zzjVar.f21585f.getString("IABTCF_TCString", zzjVar.f21591l);
                                    zzjVar.f21592m = zzjVar.f21585f.getInt("gad_has_consent_for_cookies", zzjVar.f21592m);
                                    try {
                                        zzjVar.t = new JSONObject(zzjVar.f21585f.getString("native_advanced_settings", "{}"));
                                    } catch (JSONException e2) {
                                        int i2 = zze.f21576b;
                                        com.google.android.gms.ads.internal.util.client.zzo.g("Could not convert native advanced settings to json object", e2);
                                    }
                                    zzjVar.e();
                                } finally {
                                }
                            }
                        } catch (Throwable th) {
                            com.google.android.gms.ads.internal.zzt.C.f21684h.d("AdSharedPreferenceManagerImpl.initializeOnBackgroundThread", th);
                            zze.l("AdSharedPreferenceManagerImpl.initializeOnBackgroundThread, errorMessage = ", th);
                        }
                    }
                });
                this.f21581b = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean g() {
        boolean z;
        d();
        synchronized (this.f21580a) {
            z = this.u;
        }
        return z;
    }

    public final boolean h() {
        boolean z;
        d();
        synchronized (this.f21580a) {
            z = this.v;
        }
        return z;
    }

    public final zzccv i() {
        zzccv zzccvVar;
        d();
        synchronized (this.f21580a) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Nc)).booleanValue() && this.n.a()) {
                    Iterator it = this.f21582c.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                }
                zzccvVar = this.n;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzccvVar;
    }

    public final long j() {
        long j2;
        d();
        synchronized (this.f21580a) {
            j2 = this.o;
        }
        return j2;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int k() {
        d();
        return this.f21592m;
    }

    public final int l() {
        int i2;
        d();
        synchronized (this.f21580a) {
            i2 = this.q;
        }
        return i2;
    }

    public final void m(long j2) {
        d();
        synchronized (this.f21580a) {
            try {
                if (this.p == j2) {
                    return;
                }
                this.p = j2;
                SharedPreferences.Editor editor = this.f21586g;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j2);
                    this.f21586g.apply();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        r3 = new org.json.JSONObject();
        r3.put("template_id", r9);
        r3.put("uses_media_view", r10);
        r3.put("timestamp_ms", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        r1.put(r2, r3);
        r7.t.put(r8, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006d, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006e, code lost:
    
        r10 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.g("Could not update native advanced settings", r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r7 = this;
            r7.d()
            java.lang.Object r0 = r7.f21580a
            monitor-enter(r0)
            org.json.JSONObject r1 = r7.t     // Catch: java.lang.Throwable -> L14
            org.json.JSONArray r1 = r1.optJSONArray(r8)     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L17
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L14
            r1.<init>()     // Catch: java.lang.Throwable -> L14
            goto L17
        L14:
            r8 = move-exception
            goto L8e
        L17:
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L14
            r3 = 0
            r4 = r3
        L1d:
            int r5 = r1.length()     // Catch: java.lang.Throwable -> L14
            if (r4 >= r5) goto L48
            org.json.JSONObject r5 = r1.optJSONObject(r4)     // Catch: java.lang.Throwable -> L14
            if (r5 != 0) goto L2b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L2b:
            java.lang.String r6 = "template_id"
            java.lang.String r6 = r5.optString(r6)     // Catch: java.lang.Throwable -> L14
            boolean r6 = r9.equals(r6)     // Catch: java.lang.Throwable -> L14
            if (r6 == 0) goto L45
            if (r10 == 0) goto L43
            java.lang.String r2 = "uses_media_view"
            boolean r2 = r5.optBoolean(r2, r3)     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L43
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L43:
            r2 = r4
            goto L48
        L45:
            int r4 = r4 + 1
            goto L1d
        L48:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            r3.<init>()     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            java.lang.String r4 = "template_id"
            r3.put(r4, r9)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            java.lang.String r9 = "uses_media_view"
            r3.put(r9, r10)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            java.lang.String r9 = "timestamp_ms"
            com.google.android.gms.ads.internal.zzt r10 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            com.google.android.gms.common.util.Clock r10 = r10.f21687k     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            long r4 = r10.currentTimeMillis()     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            r3.put(r9, r4)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            org.json.JSONObject r9 = r7.t     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            r9.put(r8, r1)     // Catch: java.lang.Throwable -> L14 org.json.JSONException -> L6d
            goto L75
        L6d:
            r8 = move-exception
            java.lang.String r9 = "Could not update native advanced settings"
            int r10 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> L14
            com.google.android.gms.ads.internal.util.client.zzo.g(r9, r8)     // Catch: java.lang.Throwable -> L14
        L75:
            android.content.SharedPreferences$Editor r8 = r7.f21586g     // Catch: java.lang.Throwable -> L14
            if (r8 == 0) goto L89
            java.lang.String r9 = "native_advanced_settings"
            org.json.JSONObject r10 = r7.t     // Catch: java.lang.Throwable -> L14
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L14
            r8.putString(r9, r10)     // Catch: java.lang.Throwable -> L14
            android.content.SharedPreferences$Editor r8 = r7.f21586g     // Catch: java.lang.Throwable -> L14
            r8.apply()     // Catch: java.lang.Throwable -> L14
        L89:
            r7.e()     // Catch: java.lang.Throwable -> L14
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            return
        L8e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzj.n(java.lang.String, java.lang.String, boolean):void");
    }

    public final String o() {
        String str;
        d();
        synchronized (this.f21580a) {
            str = this.w;
        }
        return str;
    }

    public final void p(String str) {
        d();
        synchronized (this.f21580a) {
            try {
                if (TextUtils.equals(this.w, str)) {
                    return;
                }
                this.w = str;
                SharedPreferences.Editor editor = this.f21586g;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.f21586g.apply();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean q() {
        boolean z;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.S0)).booleanValue()) {
            return false;
        }
        d();
        synchronized (this.f21580a) {
            z = this.f21590k;
        }
        return z;
    }

    public final void r(boolean z) {
        d();
        synchronized (this.f21580a) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() + ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Db)).longValue();
                SharedPreferences.Editor editor = this.f21586g;
                if (editor != null) {
                    editor.putBoolean("is_topics_ad_personalization_allowed", z);
                    this.f21586g.putLong("topics_consent_expiry_time_ms", jCurrentTimeMillis);
                    this.f21586g.apply();
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String t() {
        d();
        return this.f21591l;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long w() {
        long j2;
        d();
        synchronized (this.f21580a) {
            j2 = this.D;
        }
        return j2;
    }
}
