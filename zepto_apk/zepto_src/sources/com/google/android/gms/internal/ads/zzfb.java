package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfb extends IllegalStateException {

    /* renamed from: a, reason: collision with root package name */
    public final int f30794a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30795b;

    public zzfb(int i2, int i3) {
        super(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i3).length() + 31), "Player stuck suppressed for ", i3, " ms") : androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i3).length() + 43), "Player stuck playing without ending for ", i3, " ms") : androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i3).length() + 45), "Player stuck playing with no progress for ", i3, " ms") : androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i3).length() + 47), "Player stuck buffering with no progress for ", i3, " ms") : androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i3).length() + 46), "Player stuck buffering and not loading for ", i3, " ms"));
        this.f30794a = i2;
        this.f30795b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzfb.class != obj.getClass()) {
            return false;
        }
        zzfb zzfbVar = (zzfb) obj;
        return this.f30794a == zzfbVar.f30794a && this.f30795b == zzfbVar.f30795b;
    }

    public final int hashCode() {
        return ((this.f30794a + 527) * 31) + this.f30795b;
    }
}
