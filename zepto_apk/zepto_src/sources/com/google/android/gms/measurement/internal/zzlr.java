package com.google.android.gms.measurement.internal;

/* loaded from: classes4.dex */
public enum zzlr {
    GOOGLE_ANALYTICS(0),
    GOOGLE_SIGNAL(1),
    SGTM(2),
    SGTM_CLIENT(3),
    GOOGLE_SIGNAL_PENDING(4),
    UNKNOWN(99);


    /* renamed from: a, reason: collision with root package name */
    public final int f39351a;

    zzlr(int i2) {
        this.f39351a = i2;
    }

    public static zzlr a(int i2) {
        for (zzlr zzlrVar : values()) {
            if (zzlrVar.f39351a == i2) {
                return zzlrVar;
            }
        }
        return UNKNOWN;
    }

    public final int zza() {
        return this.f39351a;
    }
}
