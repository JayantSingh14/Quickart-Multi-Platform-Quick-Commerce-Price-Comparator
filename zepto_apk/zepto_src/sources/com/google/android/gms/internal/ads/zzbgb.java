package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class zzbgb {

    /* renamed from: a, reason: collision with root package name */
    public final int f24988a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24989b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f24990c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f24991d;

    public zzbgb(int i2, String str, Object obj, Object obj2) {
        this.f24988a = i2;
        this.f24989b = str;
        this.f24990c = obj;
        this.f24991d = obj2;
        com.google.android.gms.ads.internal.client.zzbd.f21150e.f21151a.f24992a.add(this);
    }

    public static zzbgb g(int i2, int i3, String str) {
        return new zzbfx(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzbgb h(long j2, long j3, String str) {
        return new zzbfy(1, str, Long.valueOf(j2), Long.valueOf(j3));
    }

    public static zzbgb i(String str, float f2, float f3) {
        return new zzbfz(1, str, Float.valueOf(f2), Float.valueOf(f3));
    }

    public static void j() {
        com.google.android.gms.ads.internal.client.zzbd.f21150e.f21151a.f24993b.add(new zzbga(1, "gads:sdk_core_constants:experiment_id", null, null));
    }

    public static void k() {
        com.google.android.gms.ads.internal.client.zzbd.f21150e.f21151a.f24994c.add(new zzbga(1, "gads:sdk_core_constants_service:experiment_id", null, null));
    }

    public abstract Object a(Bundle bundle);

    public abstract void b(SharedPreferences.Editor editor, Object obj);

    public abstract Object c(JSONObject jSONObject);

    public abstract Object d(SharedPreferences sharedPreferences);

    public final Object e() {
        return com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.f25008i ? this.f24991d : this.f24990c;
    }

    public final Object f() {
        return com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(this);
    }
}
