package com.google.android.gms.location;

/* loaded from: classes4.dex */
public final class zzo {
    public static String a(int i2) {
        if (i2 == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i2 == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i2 == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }
}
