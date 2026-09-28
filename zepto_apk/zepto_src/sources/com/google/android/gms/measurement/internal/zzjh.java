package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
public enum zzjh {
    UNINITIALIZED("uninitialized"),
    POLICY("eu_consent_policy"),
    DENIED("denied"),
    GRANTED("granted");


    /* renamed from: a, reason: collision with root package name */
    public final String f39187a;

    zzjh(String str) {
        this.f39187a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f39187a;
    }
}
