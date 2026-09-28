package com.google.ads.interactivemedia.v3.internal;

import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzpz {
    public static int zza(int i2, double d2) {
        int iMax = Math.max(i2, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= iHighestOneBit) {
            return iHighestOneBit;
        }
        int i3 = iHighestOneBit + iHighestOneBit;
        if (i3 > 0) {
            return i3;
        }
        return 1073741824;
    }

    public static int zzb(int i2) {
        return (int) (Integer.rotateLeft((int) (i2 * (-862048943)), 15) * 461845907);
    }

    public static int zzc(@CheckForNull Object obj) {
        return zzb(obj == null ? 0 : obj.hashCode());
    }
}
