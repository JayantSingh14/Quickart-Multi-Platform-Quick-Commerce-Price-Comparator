package io.sentry.android.core;

import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class ActivityFramesTracker {

    /* renamed from: a, reason: collision with root package name */
    public final FrameMetricsAggregator f51996a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryAndroidOptions f51997b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f51998c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap f51999d;

    /* renamed from: e, reason: collision with root package name */
    public final MainLooperHandler f52000e;

    /* loaded from: classes3.dex */
    public static final class FrameCounts {

        /* renamed from: a, reason: collision with root package name */
        public final int f52001a;

        /* renamed from: b, reason: collision with root package name */
        public final int f52002b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52003c;

        public FrameCounts(int i2, int i3, int i4) {
            this.f52001a = i2;
            this.f52002b = i3;
            this.f52003c = i4;
        }
    }

    public ActivityFramesTracker(SentryAndroidOptions sentryAndroidOptions) {
        MainLooperHandler mainLooperHandler = new MainLooperHandler();
        this.f51996a = null;
        this.f51998c = new ConcurrentHashMap();
        this.f51999d = new WeakHashMap();
        if (LoadClass.b("androidx.core.app.FrameMetricsAggregator", sentryAndroidOptions.getLogger()) != null) {
            this.f51996a = new FrameMetricsAggregator();
        }
        this.f51997b = sentryAndroidOptions;
        this.f52000e = mainLooperHandler;
    }

    public final FrameCounts a() {
        FrameMetricsAggregator frameMetricsAggregator;
        int i2;
        int i3;
        SparseIntArray sparseIntArray;
        if (!b() || (frameMetricsAggregator = this.f51996a) == null) {
            return null;
        }
        SparseIntArray[] sparseIntArrayArrB = frameMetricsAggregator.b();
        int i4 = 0;
        if (sparseIntArrayArrB.length <= 0 || (sparseIntArray = sparseIntArrayArrB[0]) == null) {
            i2 = 0;
            i3 = 0;
        } else {
            int i5 = 0;
            i2 = 0;
            i3 = 0;
            while (i4 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i4);
                int iValueAt = sparseIntArray.valueAt(i4);
                i5 += iValueAt;
                if (iKeyAt > 700) {
                    i3 += iValueAt;
                } else if (iKeyAt > 16) {
                    i2 += iValueAt;
                }
                i4++;
            }
            i4 = i5;
        }
        return new FrameCounts(i4, i2, i3);
    }

    public final boolean b() {
        if (this.f51996a == null) {
            return false;
        }
        SentryAndroidOptions sentryAndroidOptions = this.f51997b;
        return sentryAndroidOptions.isEnableFramesTracking() && !sentryAndroidOptions.isEnablePerformanceV2();
    }

    public final void c(Runnable runnable, String str) {
        try {
            if (AndroidMainThreadChecker.f52307a.a()) {
                runnable.run();
                return;
            }
            MainLooperHandler mainLooperHandler = this.f52000e;
            mainLooperHandler.f52154a.post(new androidx.media3.common.util.e(this, runnable, str, 22));
        } catch (Throwable unused) {
            if (str != null) {
                this.f51997b.getLogger().c(SentryLevel.WARNING, "Failed to execute ".concat(str), new Object[0]);
            }
        }
    }
}
