package com.google.android.gms.internal.ads;

import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzav {

    /* renamed from: d, reason: collision with root package name */
    public static final zzav f24411d = new zzav(1.0f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public final float f24412a;

    /* renamed from: b, reason: collision with root package name */
    public final float f24413b;

    /* renamed from: c, reason: collision with root package name */
    public final int f24414c;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzav(float f2, float f3) {
        zzgqa.a(f2 > 0.0f);
        zzgqa.a(f3 > 0.0f);
        this.f24412a = f2;
        this.f24413b = f3;
        this.f24414c = Math.round(f2 * 1000.0f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzav.class == obj.getClass()) {
            zzav zzavVar = (zzav) obj;
            if (this.f24412a == zzavVar.f24412a && this.f24413b == zzavVar.f24413b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f24413b) + ((Float.floatToRawIntBits(this.f24412a) + 527) * 31);
    }

    public final String toString() {
        Object[] objArr = {Float.valueOf(this.f24412a), Float.valueOf(this.f24413b)};
        String str = zzfj.f31254a;
        return String.format(Locale.US, "PlaybackParameters(speed=%.2f, pitch=%.2f)", objArr);
    }
}
