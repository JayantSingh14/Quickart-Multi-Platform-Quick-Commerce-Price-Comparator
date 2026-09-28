package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;

/* loaded from: classes4.dex */
public abstract class zzgsy {
    public static int b(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i3 <= i2) {
            return i2;
        }
        int i4 = i2 + (i2 >> 1) + 1;
        if (i4 < i3) {
            int iHighestOneBit = Integer.highestOneBit(i3 - 1);
            i4 = iHighestOneBit + iHighestOneBit;
        }
        return i4 < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i4;
    }

    public abstract zzgsy a(Object obj);
}
