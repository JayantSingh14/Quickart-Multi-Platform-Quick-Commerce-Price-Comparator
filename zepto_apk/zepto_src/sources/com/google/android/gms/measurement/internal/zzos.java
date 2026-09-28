package com.google.android.gms.measurement.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzos {

    /* renamed from: a, reason: collision with root package name */
    public final String f39562a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f39563b;

    /* renamed from: c, reason: collision with root package name */
    public final zzlr f39564c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzis f39565d;

    public zzos(String str, Map map, zzlr zzlrVar, com.google.android.gms.internal.measurement.zzis zzisVar) {
        this.f39562a = str;
        this.f39563b = map;
        this.f39564c = zzlrVar;
        this.f39565d = zzisVar;
    }

    public final String a() {
        return this.f39562a;
    }

    public final Map b() {
        Map map = this.f39563b;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public final zzlr c() {
        return this.f39564c;
    }

    public final com.google.android.gms.internal.measurement.zzis d() {
        return this.f39565d;
    }
}
