package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {

    /* renamed from: a, reason: collision with root package name */
    public final CrashlyticsOriginAnalyticsEventLogger f43711a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f43712b;

    /* renamed from: c, reason: collision with root package name */
    public CountDownLatch f43713c;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f43712b = new Object();
        this.f43711a = crashlyticsOriginAnalyticsEventLogger;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public final void b(Bundle bundle, String str) {
        CountDownLatch countDownLatch = this.f43713c;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public final void d(Bundle bundle) {
        synchronized (this.f43712b) {
            try {
                Logger logger = Logger.f43705a;
                logger.e("Logging event _ae to Firebase Analytics with params " + bundle);
                this.f43713c = new CountDownLatch(1);
                this.f43711a.d(bundle);
                logger.e("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f43713c.await(500, TimeUnit.MILLISECONDS)) {
                        logger.e("App exception callback received from Analytics listener.");
                    } else {
                        logger.f("Timeout exceeded while awaiting app exception callback from Analytics listener.", null);
                    }
                } catch (InterruptedException unused) {
                    Logger.f43705a.c("Interrupted while awaiting app exception callback from Analytics listener.", null);
                }
                this.f43713c = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
