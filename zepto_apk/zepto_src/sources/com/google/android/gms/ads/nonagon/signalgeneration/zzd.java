package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzd {

    /* renamed from: a, reason: collision with root package name */
    public SharedPreferences f21887a;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences.Editor f21888b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f21889c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f21890d = new Object();

    public zzd(Context context) {
        this.f21889c = context;
    }

    public final String a(String str) {
        String string;
        e();
        synchronized (this.f21890d) {
            string = this.f21887a.getString(str, null);
            this.f21888b.remove(str).commit();
        }
        return string;
    }

    public final void b(int i2, int i3, String str) {
        String str2 = Build.MODEL;
        e();
        synchronized (this.f21890d) {
            this.f21888b.putString("pn", str).putInt("vc", i2).putString("dm", str2).putInt("aav", i3).commit();
        }
    }

    public final void c() {
        e();
        synchronized (this.f21890d) {
            this.f21888b.clear().commit();
        }
    }

    public final HashMap d() {
        HashMap map;
        e();
        synchronized (this.f21890d) {
            try {
                Map<String, ?> all = this.f21887a.getAll();
                map = new HashMap();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    if ((entry.getValue() instanceof String) && !Objects.equals(entry.getKey(), "pn") && !Objects.equals(entry.getKey(), "vc") && !Objects.equals(entry.getKey(), "dm") && !Objects.equals(entry.getKey(), "aav")) {
                        map.put(entry.getKey(), (String) entry.getValue());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return map;
    }

    public final void e() {
        synchronized (this.f21890d) {
            try {
                if (this.f21887a != null) {
                    return;
                }
                SharedPreferences sharedPreferences = this.f21889c.getSharedPreferences("query_info_shared_prefs", 0);
                this.f21887a = sharedPreferences;
                this.f21888b = sharedPreferences.edit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
