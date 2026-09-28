package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbft implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final Object f24980a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f24981b = null;

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f24982c = new JSONObject();

    public final void a(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        synchronized (this.f24980a) {
            try {
                if (this.f24981b != null) {
                    return;
                }
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzbgd zzbgdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e.f21152b;
                try {
                    sharedPreferences = context.getSharedPreferences("google_adapter_flags", 0);
                } catch (IllegalStateException e2) {
                    com.google.android.gms.ads.internal.util.client.zzo.g("", e2);
                    sharedPreferences = null;
                }
                this.f24981b = sharedPreferences;
                b(sharedPreferences);
                if (!((Boolean) zzbik.f25176b.c()).booleanValue() && (sharedPreferences2 = this.f24981b) != null) {
                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.f24982c = new JSONObject((String) zzbgm.a(new zzgqs() { // from class: com.google.android.gms.internal.ads.zzbfs
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
            b(sharedPreferences);
        }
    }
}
