package com.google.android.gms.internal.pal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class zzgc {

    /* renamed from: a, reason: collision with root package name */
    public final int f37746a;

    /* renamed from: b, reason: collision with root package name */
    public final String f37747b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f37748c;

    public zzgc(String str, int i2, Object obj) {
        this.f37746a = i2;
        this.f37747b = str;
        this.f37748c = obj;
        zzfv.f37741d.f37742a.f37749a.add(this);
    }

    public static void d(int i2, String str) {
        new zzfx(str, 1, Integer.valueOf(i2));
    }

    public static zzgc e(long j2, String str) {
        return new zzfy(str, 1, Long.valueOf(j2));
    }

    public static zzgc f(int i2, String str, Boolean bool) {
        return new zzfw(str, i2, bool);
    }

    public static zzgc g(String str, String str2) {
        return new zzga(str, 1, str2);
    }

    public abstract Object a(JSONObject jSONObject);

    public abstract Object b(Bundle bundle);

    public abstract Object c(SharedPreferences sharedPreferences);
}
