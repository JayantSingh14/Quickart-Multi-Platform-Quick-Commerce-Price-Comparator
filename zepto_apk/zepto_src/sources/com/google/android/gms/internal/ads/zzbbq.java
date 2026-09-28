package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public enum zzbbq implements zziav {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    RISCV64(7),
    UNKNOWN(999);


    /* renamed from: a, reason: collision with root package name */
    public final int f24687a;

    zzbbq(int i2) {
        this.f24687a = i2;
    }

    public static zzbbq a(int i2) {
        if (i2 == 0) {
            return UNSUPPORTED;
        }
        if (i2 == 2) {
            return ARM7;
        }
        if (i2 == 999) {
            return UNKNOWN;
        }
        if (i2 == 4) {
            return X86;
        }
        if (i2 == 5) {
            return ARM64;
        }
        if (i2 == 6) {
            return X86_64;
        }
        if (i2 != 7) {
            return null;
        }
        return RISCV64;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f24687a);
    }

    @Override // com.google.android.gms.internal.ads.zziav
    public final int zza() {
        return this.f24687a;
    }
}
