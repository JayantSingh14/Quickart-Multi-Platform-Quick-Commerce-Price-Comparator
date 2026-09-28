package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public enum zzvn implements zzadb {
    UNKNOWN_KEYMATERIAL(0),
    SYMMETRIC(1),
    ASYMMETRIC_PRIVATE(2),
    ASYMMETRIC_PUBLIC(3),
    REMOTE(4),
    UNRECOGNIZED(-1);


    /* renamed from: a, reason: collision with root package name */
    public final int f38092a;

    zzvn(int i2) {
        this.f38092a = i2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        if (this != UNRECOGNIZED) {
            return Integer.toString(this.f38092a);
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
