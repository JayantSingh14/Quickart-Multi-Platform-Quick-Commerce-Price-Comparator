package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzhn implements com.google.android.gms.internal.measurement.zzo {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39041a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzhs f39042b;

    public zzhn(zzhs zzhsVar, String str) {
        this.f39041a = str;
        Objects.requireNonNull(zzhsVar);
        this.f39042b = zzhsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String a(String str) {
        Map map = (Map) this.f39042b.f39050d.get(this.f39041a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
