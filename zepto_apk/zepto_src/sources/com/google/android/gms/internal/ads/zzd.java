package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.os.Build;

/* loaded from: classes4.dex */
public final class zzd {

    /* renamed from: b, reason: collision with root package name */
    public static final zzd f27533b = new zzd();

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f27534a;

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    public final AudioAttributes a() {
        if (this.f27534a == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                usage.setAllowedCapturePolicy(1);
            }
            if (i2 >= 32) {
                usage.setSpatializationBehavior(0);
                usage.setIsContentSpatialized(false);
            }
            this.f27534a = usage.build();
        }
        return this.f27534a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzd.class != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return -2092275855;
    }
}
