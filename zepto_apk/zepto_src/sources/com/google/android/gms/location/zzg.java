package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzg implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ActivityTransition activityTransition = (ActivityTransition) obj;
        ActivityTransition activityTransition2 = (ActivityTransition) obj2;
        Preconditions.checkNotNull(activityTransition);
        Preconditions.checkNotNull(activityTransition2);
        int i2 = activityTransition.f38274a;
        int i3 = activityTransition2.f38274a;
        if (i2 != i3) {
            return i2 >= i3 ? 1 : -1;
        }
        int i4 = activityTransition.f38275b;
        int i5 = activityTransition2.f38275b;
        if (i4 == i5) {
            return 0;
        }
        return i4 < i5 ? -1 : 1;
    }
}
