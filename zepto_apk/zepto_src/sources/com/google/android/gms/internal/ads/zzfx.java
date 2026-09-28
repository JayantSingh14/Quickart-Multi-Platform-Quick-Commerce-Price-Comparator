package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfx implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final float f31982a;

    /* renamed from: b, reason: collision with root package name */
    public final float f31983b;

    public zzfx(float f2, float f3) {
        boolean z = false;
        if (f2 >= -90.0f && f2 <= 90.0f && f3 >= -180.0f && f3 <= 180.0f) {
            z = true;
        }
        zzgqa.b("Invalid latitude or longitude", z);
        this.f31982a = f2;
        this.f31983b = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzfx.class == obj.getClass()) {
            zzfx zzfxVar = (zzfx) obj;
            if (this.f31982a == zzfxVar.f31982a && this.f31983b == zzfxVar.f31983b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.f31983b) + ((Float.hashCode(this.f31982a) + 527) * 31);
    }

    public final String toString() {
        float f2 = this.f31982a;
        int length = String.valueOf(f2).length();
        float f3 = this.f31983b;
        StringBuilder sb = new StringBuilder(length + 26 + String.valueOf(f3).length());
        sb.append("xyz: latitude=");
        sb.append(f2);
        sb.append(", longitude=");
        sb.append(f3);
        return sb.toString();
    }
}
