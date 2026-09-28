package io.sentry.android.core;

import android.app.Activity;
import io.sentry.ITransaction;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.TransactionFinishedCallback;
import io.sentry.android.core.ActivityFramesTracker;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements TransactionFinishedCallback, Sentry.OptionsConfiguration {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f52248a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f52249b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f52250c;

    public /* synthetic */ d(Object obj, Object obj2, Object obj3) {
        this.f52248a = obj;
        this.f52249b = obj2;
        this.f52250c = obj3;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // io.sentry.Sentry.OptionsConfiguration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(io.sentry.SentryOptions r24) {
        /*
            Method dump skipped, instructions count: 1373
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.d.a(io.sentry.SentryOptions):void");
    }

    public void b(ITransaction iTransaction) {
        ActivityFramesTracker.FrameCounts frameCountsA;
        ActivityLifecycleIntegration activityLifecycleIntegration = (ActivityLifecycleIntegration) this.f52248a;
        WeakReference weakReference = (WeakReference) this.f52249b;
        String str = (String) this.f52250c;
        activityLifecycleIntegration.getClass();
        Activity activity = (Activity) weakReference.get();
        if (activity == null) {
            SentryAndroidOptions sentryAndroidOptions = activityLifecycleIntegration.f52007d;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "Unable to track activity frames as the Activity %s has been destroyed.", str);
                return;
            }
            return;
        }
        ActivityFramesTracker activityFramesTracker = activityLifecycleIntegration.r;
        SentryId sentryIdE = iTransaction.e();
        synchronized (activityFramesTracker) {
            try {
                if (activityFramesTracker.b()) {
                    ActivityFramesTracker.FrameCounts frameCounts = null;
                    activityFramesTracker.c(new b(activityFramesTracker, activity, 1), null);
                    ActivityFramesTracker.FrameCounts frameCounts2 = (ActivityFramesTracker.FrameCounts) activityFramesTracker.f51999d.remove(activity);
                    if (frameCounts2 != null && (frameCountsA = activityFramesTracker.a()) != null) {
                        frameCounts = new ActivityFramesTracker.FrameCounts(frameCountsA.f52001a - frameCounts2.f52001a, frameCountsA.f52002b - frameCounts2.f52002b, frameCountsA.f52003c - frameCounts2.f52003c);
                    }
                    if (frameCounts != null && (frameCounts.f52001a != 0 || frameCounts.f52002b != 0 || frameCounts.f52003c != 0)) {
                        MeasurementValue measurementValue = new MeasurementValue(Integer.valueOf(frameCounts.f52001a), "none");
                        MeasurementValue measurementValue2 = new MeasurementValue(Integer.valueOf(frameCounts.f52002b), "none");
                        MeasurementValue measurementValue3 = new MeasurementValue(Integer.valueOf(frameCounts.f52003c), "none");
                        HashMap map = new HashMap();
                        map.put("frames_total", measurementValue);
                        map.put("frames_slow", measurementValue2);
                        map.put("frames_frozen", measurementValue3);
                        activityFramesTracker.f51998c.put(sentryIdE, map);
                    }
                }
            } finally {
            }
        }
    }
}
