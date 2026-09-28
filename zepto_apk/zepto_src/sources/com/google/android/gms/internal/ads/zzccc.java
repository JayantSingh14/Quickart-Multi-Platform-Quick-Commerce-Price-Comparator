package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzccc {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f25877a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f25878b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Context f25879c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcbp f25880d;

    public zzccc(Context context, zzcbp zzcbpVar) {
        this.f25879c = context;
        this.f25880d = zzcbpVar;
    }

    public final synchronized void a(String str) {
        try {
            HashMap map = this.f25877a;
            if (map.containsKey(str)) {
                return;
            }
            SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.f25879c) : this.f25879c.getSharedPreferences(str, 0);
            zzcbz zzcbzVar = new zzcbz(this, str);
            map.put(str, zzcbzVar);
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzcbzVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
