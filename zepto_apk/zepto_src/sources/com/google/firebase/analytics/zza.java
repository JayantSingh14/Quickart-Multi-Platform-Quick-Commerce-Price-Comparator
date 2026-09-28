package com.google.firebase.analytics;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zza extends ThreadPoolExecutor {
    /* JADX WARN: Illegal instructions before constructor call */
    public zza(FirebaseAnalytics firebaseAnalytics, ArrayBlockingQueue arrayBlockingQueue) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Objects.requireNonNull(firebaseAnalytics);
        super(0, 1, 30L, timeUnit, arrayBlockingQueue);
    }
}
