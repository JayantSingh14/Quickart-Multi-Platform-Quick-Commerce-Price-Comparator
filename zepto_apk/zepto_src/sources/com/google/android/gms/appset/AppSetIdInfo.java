package com.google.android.gms.appset;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class AppSetIdInfo {

    /* renamed from: a, reason: collision with root package name */
    public final String f21994a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21995b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scope {
    }

    public AppSetIdInfo(String str, int i2) {
        this.f21994a = str;
        this.f21995b = i2;
    }

    public final String a() {
        return this.f21994a;
    }

    public final int b() {
        return this.f21995b;
    }
}
