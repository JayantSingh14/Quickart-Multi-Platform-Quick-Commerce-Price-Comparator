package com.facebook.imagepipeline.memory;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class NoOpPoolStatsTracker implements PoolStatsTracker {

    /* renamed from: a, reason: collision with root package name */
    public static NoOpPoolStatsTracker f18037a;

    public static synchronized NoOpPoolStatsTracker a() {
        try {
            if (f18037a == null) {
                f18037a = new NoOpPoolStatsTracker();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f18037a;
    }
}
