package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public enum zzhoz implements zziav {
    UNKNOWN_KEYMATERIAL(0),
    SYMMETRIC(1),
    ASYMMETRIC_PRIVATE(2),
    ASYMMETRIC_PUBLIC(3),
    REMOTE(4),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f34063a;

    zzhoz(int i2) {
        this.f34063a = i2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f34063a);
    }

    @Override // com.google.android.gms.internal.ads.zziav
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.f34063a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
