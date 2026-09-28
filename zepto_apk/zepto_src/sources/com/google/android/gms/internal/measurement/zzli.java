package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public class zzli {
    public static int a(int i2) {
        return (i2 >>> 1) ^ (-(i2 & 1));
    }

    public static long b(long j2) {
        return (j2 >>> 1) ^ (-(1 & j2));
    }
}
