package com.google.android.gms.internal.pal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzgi implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: g, reason: collision with root package name */
    public Context f37761g;

    /* renamed from: a, reason: collision with root package name */
    public final Object f37755a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ConditionVariable f37756b = new ConditionVariable();

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f37757c = false;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f37758d = false;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences f37759e = null;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f37760f = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    public JSONObject f37762h = new JSONObject();

    public final Object a(final zzgc zzgcVar) {
        if (!this.f37756b.block(5000L)) {
            synchronized (this.f37755a) {
                try {
                    if (!this.f37758d) {
                        throw new IllegalStateException("Flags.initialize() was not called!");
                    }
                } finally {
                }
            }
        }
        if (!this.f37757c || this.f37759e == null) {
            synchronized (this.f37755a) {
                if (this.f37757c && this.f37759e != null) {
                }
                return zzgcVar.f37748c;
            }
        }
        int i2 = zzgcVar.f37746a;
        if (i2 != 2) {
            return (i2 == 1 && this.f37762h.has(zzgcVar.f37747b)) ? zzgcVar.a(this.f37762h) : zzgl.a(new zzis() { // from class: com.google.android.gms.internal.pal.zzgf
                @Override // com.google.android.gms.internal.pal.zzis
                public final Object zza() {
                    return zzgcVar.c(this.f37751a.f37759e);
                }
            });
        }
        Bundle bundle = this.f37760f;
        return bundle == null ? zzgcVar.f37748c : zzgcVar.b(bundle);
    }

    public final void b() {
        if (this.f37759e == null) {
            return;
        }
        try {
            this.f37762h = new JSONObject((String) zzgl.a(new zzis() { // from class: com.google.android.gms.internal.pal.zzgg
                @Override // com.google.android.gms.internal.pal.zzis
                public final Object zza() {
                    return this.f37753a.f37759e.getString("flag_configuration", "{}");
                }
            }));
        } catch (JSONException unused) {
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            b();
        }
    }
}
