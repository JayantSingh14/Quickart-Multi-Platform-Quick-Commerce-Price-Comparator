package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbv {

    /* renamed from: d, reason: collision with root package name */
    public static final zzbv f25577d = new zzbv(1.0f, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f25578a;

    /* renamed from: b, reason: collision with root package name */
    public final int f25579b;

    /* renamed from: c, reason: collision with root package name */
    public final float f25580c;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(3, 36);
    }

    public zzbv(float f2, int i2, int i3) {
        this.f25578a = i2;
        this.f25579b = i3;
        this.f25580c = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbv) {
            zzbv zzbvVar = (zzbv) obj;
            if (this.f25578a == zzbvVar.f25578a && this.f25579b == zzbvVar.f25579b && this.f25580c == zzbvVar.f25580c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f25580c) + ((((this.f25578a + 217) * 31) + this.f25579b) * 31);
    }
}
