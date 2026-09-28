package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzcc implements SharedPreferences.Editor {

    /* renamed from: a, reason: collision with root package name */
    public boolean f36818a = false;

    /* renamed from: b, reason: collision with root package name */
    public final HashSet f36819b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f36820c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzcd f36821d;

    public final void a(Object obj, String str) {
        if (obj != null) {
            this.f36820c.put(str, obj);
        } else {
            remove(str);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.f36818a = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        boolean z = this.f36818a;
        zzcd zzcdVar = this.f36821d;
        if (z) {
            zzcdVar.f36822a.clear();
        }
        HashSet hashSet = this.f36819b;
        zzcdVar.f36822a.keySet().removeAll(hashSet);
        HashMap map = this.f36820c;
        for (Map.Entry entry : map.entrySet()) {
            zzcdVar.f36822a.put((String) entry.getKey(), entry.getValue());
        }
        Iterator it = zzcdVar.f36823b.iterator();
        while (it.hasNext()) {
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) it.next();
            UnmodifiableIterator it2 = Sets.i(hashSet, map.keySet()).iterator();
            while (it2.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(zzcdVar, (String) it2.next());
            }
        }
        return (!this.f36818a && hashSet.isEmpty() && map.isEmpty()) ? false : true;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        a(Boolean.valueOf(z), str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f2) {
        a(Float.valueOf(f2), str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i2) {
        a(Integer.valueOf(i2), str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j2) {
        a(Long.valueOf(j2), str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        a(str2, str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        a(set, str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        this.f36819b.add(str);
        return this;
    }
}
