package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzft implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final int f31819a;

    public zzft(int i2) {
        this.f31819a = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzft) && this.f31819a == ((zzft) obj).f31819a;
    }

    public final int hashCode() {
        return this.f31819a;
    }

    public final String toString() {
        int i2 = this.f31819a;
        return androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 19), i2, "Mp4AlternateGroup: ");
    }
}
