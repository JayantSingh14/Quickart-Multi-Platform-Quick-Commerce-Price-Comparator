package com.google.android.play.core.splitinstall.testing;

import java.util.Map;

/* loaded from: classes4.dex */
final class zza extends zzu {

    /* renamed from: a, reason: collision with root package name */
    public Integer f42023a;

    /* renamed from: b, reason: collision with root package name */
    public Map f42024b;

    public final zza a(Map map) {
        if (map == null) {
            throw new NullPointerException("Null splitInstallErrorCodeByModule");
        }
        this.f42024b = map;
        return this;
    }

    public final Map b() {
        Map map = this.f42024b;
        if (map != null) {
            return map;
        }
        throw new IllegalStateException("Property \"splitInstallErrorCodeByModule\" has not been set");
    }
}
