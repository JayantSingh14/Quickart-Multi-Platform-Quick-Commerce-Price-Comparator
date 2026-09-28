package com.bumptech.glide.util;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public final class LogTime {

    /* renamed from: a, reason: collision with root package name */
    public static final double f16519a = 1.0d / Math.pow(10.0d, 6.0d);

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f16520b = 0;

    public static double a(long j2) {
        return (SystemClock.elapsedRealtimeNanos() - j2) * f16519a;
    }
}
