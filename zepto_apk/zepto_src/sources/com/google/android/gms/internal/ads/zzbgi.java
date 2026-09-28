package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbgi implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: g, reason: collision with root package name */
    public Context f25006g;

    /* renamed from: a, reason: collision with root package name */
    public final Object f25000a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ConditionVariable f25001b = new ConditionVariable();

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f25002c = false;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f25003d = false;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences f25004e = null;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f25005f = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    public JSONObject f25007h = new JSONObject();

    /* renamed from: i, reason: collision with root package name */
    public boolean f25008i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f25009j = false;

    public final Object a(final zzbgb zzbgbVar) {
        if (!this.f25001b.block(5000L)) {
            synchronized (this.f25000a) {
                try {
                    if (!this.f25003d) {
                        throw new IllegalStateException("Flags.initialize() was not called!");
                    }
                } finally {
                }
            }
        }
        if (!this.f25002c || this.f25004e == null || this.f25009j) {
            synchronized (this.f25000a) {
                if (this.f25002c && this.f25004e != null && !this.f25009j) {
                }
                return zzbgbVar.e();
            }
        }
        int i2 = zzbgbVar.f24988a;
        if (i2 != 2) {
            return (i2 == 1 && this.f25007h.has(zzbgbVar.f24989b)) ? zzbgbVar.c(this.f25007h) : zzbgm.a(new zzgqs() { // from class: com.google.android.gms.internal.ads.zzbgh
                @Override // com.google.android.gms.internal.ads.zzgqs
                public final /* synthetic */ Object zza() {
                    return zzbgbVar.d(this.f24998a.f25004e);
                }
            });
        }
        Bundle bundle = this.f25005f;
        return bundle == null ? zzbgbVar.e() : zzbgbVar.a(bundle);
    }

    public final Object b(zzbgb zzbgbVar) {
        return (this.f25002c || this.f25003d) ? a(zzbgbVar) : zzbgbVar.e();
    }

    public final void c(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.f25007h = new JSONObject((String) zzbgm.a(new zzgqs() { // from class: com.google.android.gms.internal.ads.zzbgf
                    @Override // com.google.android.gms.internal.ads.zzgqs
                    public final /* synthetic */ Object zza() {
                        return sharedPreferences.getString("flag_configuration", "{}");
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            c(sharedPreferences);
        }
    }
}
