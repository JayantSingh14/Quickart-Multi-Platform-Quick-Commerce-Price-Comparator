package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzcd implements SharedPreferences {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f36822a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f36823b = new HashSet();

    public final Object a(Object obj, String str) {
        Object obj2 = this.f36822a.get(str);
        return obj2 != null ? obj2 : obj;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return this.f36822a.containsKey(str);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new zzcc(this);
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        return this.f36822a;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        return ((Boolean) a(Boolean.valueOf(z), str)).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f2) {
        return ((Float) a(Float.valueOf(f2), str)).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i2) {
        return ((Integer) a(Integer.valueOf(i2), str)).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j2) {
        return ((Long) a(Long.valueOf(j2), str)).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        return (String) a(str2, str);
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        return (Set) a(set, str);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f36823b.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f36823b.remove(onSharedPreferenceChangeListener);
    }
}
