package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;

/* loaded from: classes.dex */
final class zzhg extends zzje {
    public static final Pair z = new Pair("", 0L);

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f39022c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences f39023d;

    /* renamed from: e, reason: collision with root package name */
    public zzhe f39024e;

    /* renamed from: f, reason: collision with root package name */
    public final zzhd f39025f;

    /* renamed from: g, reason: collision with root package name */
    public final zzhf f39026g;

    /* renamed from: h, reason: collision with root package name */
    public String f39027h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39028i;

    /* renamed from: j, reason: collision with root package name */
    public long f39029j;

    /* renamed from: k, reason: collision with root package name */
    public final zzhd f39030k;

    /* renamed from: l, reason: collision with root package name */
    public final zzhb f39031l;

    /* renamed from: m, reason: collision with root package name */
    public final zzhf f39032m;
    public final zzhc n;
    public final zzhb o;
    public final zzhd p;
    public final zzhd q;
    public boolean r;
    public final zzhb s;
    public final zzhb t;
    public final zzhd u;
    public final zzhf v;
    public final zzhf w;
    public final zzhd x;
    public final zzhc y;

    public zzhg(zzib zzibVar) {
        super(zzibVar);
        this.f39030k = new zzhd(this, "session_timeout", 1800000L);
        this.f39031l = new zzhb(this, "start_new_session", true);
        this.p = new zzhd(this, "last_pause_time", 0L);
        this.q = new zzhd(this, "session_id", 0L);
        this.f39032m = new zzhf(this, "non_personalized_ads");
        this.n = new zzhc(this, "last_received_uri_timestamps_by_source");
        this.o = new zzhb(this, "allow_remote_dynamite", false);
        this.f39025f = new zzhd(this, "first_open_time", 0L);
        new zzhd(this, "app_install_time", 0L);
        this.f39026g = new zzhf(this, "app_instance_id");
        this.s = new zzhb(this, "app_backgrounded", false);
        this.t = new zzhb(this, "deep_link_retrieval_complete", false);
        this.u = new zzhd(this, "deep_link_retrieval_attempts", 0L);
        this.v = new zzhf(this, "firebase_feature_rollouts");
        this.w = new zzhf(this, "deferred_attribution_cache");
        this.x = new zzhd(this, "deferred_attribution_cache_timestamp", 0L);
        this.y = new zzhc(this, "default_event_parameters");
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    public final boolean h() {
        return true;
    }

    public final SharedPreferences k() {
        g();
        i();
        Preconditions.checkNotNull(this.f39022c);
        return this.f39022c;
    }

    public final SharedPreferences l() {
        g();
        i();
        if (this.f39023d == null) {
            zzib zzibVar = this.f39180a;
            String strValueOf = String.valueOf(zzibVar.f39084a.getPackageName());
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            String strConcat = strValueOf.concat("_preferences");
            zzgtVar.n.b(strConcat, "Default prefs file");
            this.f39023d = zzibVar.f39084a.getSharedPreferences(strConcat, 0);
        }
        return this.f39023d;
    }

    public final SparseArray m() throws JSONException, NumberFormatException {
        Bundle bundleA = this.n.a();
        int[] intArray = bundleA.getIntArray("uriSources");
        long[] longArray = bundleA.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i2 = 0; i2 < intArray.length; i2++) {
            sparseArray.put(intArray[i2], Long.valueOf(longArray[i2]));
        }
        return sparseArray;
    }

    public final zzjk n() {
        g();
        return zzjk.c(k().getInt("consent_source", 100), k().getString("consent_settings", "G1"));
    }

    public final boolean o(zzoc zzocVar) {
        g();
        String string = k().getString("stored_tcf_param", "");
        String strA = zzocVar.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = k().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }

    public final void p(boolean z2) {
        g();
        zzgt zzgtVar = this.f39180a.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.n.b(Boolean.valueOf(z2), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = k().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z2);
        editorEdit.apply();
    }

    public final boolean q(long j2) {
        return j2 - this.f39030k.a() > this.p.a();
    }
}
