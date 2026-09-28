package com.google.android.gms.internal.pal;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzqj extends zzqu {

    /* renamed from: a, reason: collision with root package name */
    public final int f38028a;

    /* renamed from: b, reason: collision with root package name */
    public final zzqi f38029b;

    public zzqj(int i2, zzqi zzqiVar) {
        this.f38028a = i2;
        this.f38029b = zzqiVar;
    }

    public final int a() {
        zzqi zzqiVar = zzqi.f38026e;
        int i2 = this.f38028a;
        zzqi zzqiVar2 = this.f38029b;
        if (zzqiVar2 == zzqiVar) {
            return i2;
        }
        if (zzqiVar2 == zzqi.f38023b) {
            return i2 + 5;
        }
        if (zzqiVar2 == zzqi.f38024c) {
            return i2 + 5;
        }
        if (zzqiVar2 == zzqi.f38025d) {
            return i2 + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzqj)) {
            return false;
        }
        zzqj zzqjVar = (zzqj) obj;
        return zzqjVar.a() == a() && zzqjVar.f38029b == this.f38029b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f38028a), this.f38029b});
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + this.f38029b.toString() + ", " + this.f38028a + "-byte tags)";
    }
}
