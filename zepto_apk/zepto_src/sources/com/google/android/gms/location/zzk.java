package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzk implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        DetectedActivity detectedActivity2 = (DetectedActivity) obj2;
        Preconditions.checkNotNull(detectedActivity);
        Preconditions.checkNotNull(detectedActivity2);
        int iCompareTo = Integer.valueOf(detectedActivity2.f38296b).compareTo(Integer.valueOf(detectedActivity.f38296b));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i2 = detectedActivity.f38295a;
        int i3 = 4;
        if (i2 > 22 || i2 < 0) {
            i2 = 4;
        }
        Integer numValueOf = Integer.valueOf(i2);
        int i4 = detectedActivity2.f38295a;
        if (i4 <= 22 && i4 >= 0) {
            i3 = i4;
        }
        return numValueOf.compareTo(Integer.valueOf(i3));
    }
}
