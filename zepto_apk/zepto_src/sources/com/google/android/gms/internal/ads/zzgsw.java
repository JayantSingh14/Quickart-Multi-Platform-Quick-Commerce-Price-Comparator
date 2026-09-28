package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgsw {
    public static int a(int i2) {
        return (int) (Integer.rotateLeft((int) (i2 * (-862048943)), 15) * 461845907);
    }

    public static int b(Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
