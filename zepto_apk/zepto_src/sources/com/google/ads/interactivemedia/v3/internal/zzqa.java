package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.common.api.Api;

/* loaded from: classes3.dex */
public final class zzqa {
    public static int zza(int i2, int i3) {
        if (i3 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int i4 = i2 + (i2 >> 1) + 1;
        if (i4 < i3) {
            int iHighestOneBit = Integer.highestOneBit(i3 - 1);
            i4 = iHighestOneBit + iHighestOneBit;
        }
        return i4 < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i4;
    }
}
