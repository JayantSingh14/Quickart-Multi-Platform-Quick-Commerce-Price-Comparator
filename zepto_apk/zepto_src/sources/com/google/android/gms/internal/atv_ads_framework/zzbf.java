package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import androidx.fragment.app.e;

/* loaded from: classes4.dex */
final class zzbf {

    /* renamed from: a, reason: collision with root package name */
    public final Object f36046a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f36047b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f36048c;

    public zzbf(Object obj, Object obj2, Object obj3) {
        this.f36046a = obj;
        this.f36047b = obj2;
        this.f36048c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f36046a;
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(this.f36047b);
        return new IllegalArgumentException(b.s(e.v("Multiple entries with same key: ", strValueOf, "=", strValueOf2, " and "), String.valueOf(obj), "=", String.valueOf(this.f36048c)));
    }
}
