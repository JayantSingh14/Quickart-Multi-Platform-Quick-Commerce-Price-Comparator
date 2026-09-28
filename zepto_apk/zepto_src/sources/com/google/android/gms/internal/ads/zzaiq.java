package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaiq implements zzao {

    /* renamed from: a, reason: collision with root package name */
    public final float f23209a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23210b;

    public zzaiq(float f2, int i2) {
        this.f23209a = f2;
        this.f23210b = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaiq.class == obj.getClass()) {
            zzaiq zzaiqVar = (zzaiq) obj;
            if (this.f23209a == zzaiqVar.f23209a && this.f23210b == zzaiqVar.f23210b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.hashCode(this.f23209a) + 527) * 31) + this.f23210b;
    }

    public final String toString() {
        float f2 = this.f23209a;
        int length = String.valueOf(f2).length();
        int i2 = this.f23210b;
        StringBuilder sb = new StringBuilder(length + 47 + String.valueOf(i2).length());
        sb.append("smta: captureFrameRate=");
        sb.append(f2);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i2);
        return sb.toString();
    }
}
