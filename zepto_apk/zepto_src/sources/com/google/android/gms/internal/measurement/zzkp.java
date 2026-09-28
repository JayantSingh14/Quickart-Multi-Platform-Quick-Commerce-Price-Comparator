package com.google.android.gms.internal.measurement;

/* loaded from: classes4.dex */
public enum zzkp implements zzmi {
    PURPOSE_RESTRICTION_NOT_ALLOWED(0),
    PURPOSE_RESTRICTION_REQUIRE_CONSENT(1),
    PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST(2),
    PURPOSE_RESTRICTION_UNDEFINED(3),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f37056a;

    zzkp(int i2) {
        this.f37056a = i2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f37056a);
    }

    @Override // com.google.android.gms.internal.measurement.zzmi
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.f37056a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
