package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public final class AdValue {

    /* renamed from: a, reason: collision with root package name */
    public final int f21011a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21012b;

    /* renamed from: c, reason: collision with root package name */
    public final long f21013c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PrecisionType {
    }

    public AdValue(int i2, long j2, String str) {
        this.f21011a = i2;
        this.f21012b = str;
        this.f21013c = j2;
    }
}
