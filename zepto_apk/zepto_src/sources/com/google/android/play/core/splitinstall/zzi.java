package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzi {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f42119a = new HashMap();

    public final void a(String str, String str2, String str3) {
        HashMap map = this.f42119a;
        if (!map.containsKey(str2)) {
            map.put(str2, new HashMap());
        }
        ((Map) map.get(str2)).put(str, str3);
    }

    public final zzk b() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f42119a.entrySet()) {
            map.put((String) entry.getKey(), Collections.unmodifiableMap(new HashMap((Map) entry.getValue())));
        }
        return new zzk(Collections.unmodifiableMap(map));
    }
}
