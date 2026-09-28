package io.sentry.android.core;

import android.os.Looper;
import in.juspay.airborne.ota.Constants;
import io.sentry.EventProcessor;
import io.sentry.Hint;
import io.sentry.MeasurementUnit;
import io.sentry.SentryEvent;
import io.sentry.SpanContext;
import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.android.core.performance.ActivityLifecycleTimeSpan;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.protocol.App;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
final class PerformanceAndroidEventProcessor implements EventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final ActivityFramesTracker f52179a;

    /* renamed from: b, reason: collision with root package name */
    public final SentryAndroidOptions f52180b;

    public PerformanceAndroidEventProcessor(SentryAndroidOptions sentryAndroidOptions, ActivityFramesTracker activityFramesTracker) {
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52180b = sentryAndroidOptions;
        this.f52179a = activityFramesTracker;
    }

    public static void d(AppStartMetrics appStartMetrics, SentryTransaction sentryTransaction) {
        SpanContext spanContextA;
        SpanId spanId;
        if (appStartMetrics.f52367a == AppStartMetrics.AppStartType.UNKNOWN || (spanContextA = sentryTransaction.f51792b.a()) == null) {
            return;
        }
        ArrayList arrayList = sentryTransaction.s;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SentrySpan sentrySpan = (SentrySpan) it.next();
            if (sentrySpan.f52921f.contentEquals("app.start.cold") || sentrySpan.f52921f.contentEquals("app.start.warm")) {
                spanId = sentrySpan.f52919d;
                break;
            }
        }
        spanId = null;
        AppStartMetrics.AppStartType appStartType = appStartMetrics.f52367a;
        AppStartMetrics.AppStartType appStartType2 = AppStartMetrics.AppStartType.COLD;
        SentryId sentryId = spanContextA.f51921a;
        if (appStartType == appStartType2) {
            long j2 = AppStartMetrics.n;
            TimeSpan timeSpan = appStartMetrics.f52369c;
            if (timeSpan.c() && Math.abs(j2 - timeSpan.f52382c) <= 10000) {
                TimeSpan timeSpan2 = new TimeSpan();
                timeSpan2.e(timeSpan.f52382c);
                timeSpan2.f52381b = timeSpan.f52381b;
                timeSpan2.f52383d = j2;
                timeSpan2.f52380a = "Process Initialization";
                arrayList.add(g(timeSpan2, spanId, sentryId, "process.load"));
            }
            ArrayList arrayList2 = new ArrayList(appStartMetrics.f52372f.values());
            Collections.sort(arrayList2);
            if (!arrayList2.isEmpty()) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(g((TimeSpan) it2.next(), spanId, sentryId, "contentprovider.load"));
                }
            }
            TimeSpan timeSpan3 = appStartMetrics.f52371e;
            if (timeSpan3.d()) {
                arrayList.add(g(timeSpan3, spanId, sentryId, "application.load"));
            }
        }
        ArrayList arrayList3 = new ArrayList(appStartMetrics.f52373g);
        Collections.sort(arrayList3);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            ActivityLifecycleTimeSpan activityLifecycleTimeSpan = (ActivityLifecycleTimeSpan) it3.next();
            if (activityLifecycleTimeSpan.f52365a.c()) {
                TimeSpan timeSpan4 = activityLifecycleTimeSpan.f52365a;
                if (timeSpan4.d()) {
                    arrayList.add(g(timeSpan4, spanId, sentryId, "activity.load"));
                }
            }
            TimeSpan timeSpan5 = activityLifecycleTimeSpan.f52366b;
            if (timeSpan5.c() && timeSpan5.d()) {
                arrayList.add(g(timeSpan5, spanId, sentryId, "activity.load"));
            }
        }
    }

    public static boolean e(SentryTransaction sentryTransaction) {
        Iterator it = sentryTransaction.s.iterator();
        while (it.hasNext()) {
            SentrySpan sentrySpan = (SentrySpan) it.next();
            if (sentrySpan.f52921f.contentEquals("app.start.cold") || sentrySpan.f52921f.contentEquals("app.start.warm")) {
                return true;
            }
        }
        SpanContext spanContextA = sentryTransaction.f51792b.a();
        if (spanContextA == null) {
            return false;
        }
        String str = spanContextA.f51925e;
        return str.equals("app.start.cold") || str.equals("app.start.warm");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(io.sentry.protocol.SentryTransaction r11) {
        /*
            java.util.ArrayList r11 = r11.s
            java.util.Iterator r0 = r11.iterator()
            r1 = 0
            r2 = r1
        L8:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L2f
            java.lang.Object r3 = r0.next()
            io.sentry.protocol.SentrySpan r3 = (io.sentry.protocol.SentrySpan) r3
            java.lang.String r4 = r3.f52921f
            java.lang.String r5 = "ui.load.initial_display"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L20
            r1 = r3
            goto L2b
        L20:
            java.lang.String r4 = "ui.load.full_display"
            java.lang.String r5 = r3.f52921f
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L2b
            r2 = r3
        L2b:
            if (r1 == 0) goto L8
            if (r2 == 0) goto L8
        L2f:
            if (r1 != 0) goto L35
            if (r2 != 0) goto L35
            goto Lc7
        L35:
            java.util.Iterator r11 = r11.iterator()
        L39:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto Lc7
            java.lang.Object r0 = r11.next()
            io.sentry.protocol.SentrySpan r0 = (io.sentry.protocol.SentrySpan) r0
            if (r0 == r1) goto L39
            if (r0 != r2) goto L4a
            goto L39
        L4a:
            java.util.Map r3 = r0.f52926k
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L63
            java.lang.String r6 = "thread.name"
            java.lang.Object r3 = r3.get(r6)
            if (r3 == 0) goto L63
            java.lang.String r6 = "main"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L61
            goto L63
        L61:
            r3 = r4
            goto L64
        L63:
            r3 = r5
        L64:
            java.lang.Double r6 = r0.f52916a
            if (r1 == 0) goto L86
            double r7 = r6.doubleValue()
            java.lang.Double r9 = r1.f52916a
            double r9 = r9.doubleValue()
            int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r9 < 0) goto L86
            java.lang.Double r9 = r1.f52917b
            if (r9 == 0) goto L82
            double r9 = r9.doubleValue()
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 > 0) goto L86
        L82:
            if (r3 == 0) goto L86
            r3 = r5
            goto L87
        L86:
            r3 = r4
        L87:
            if (r2 == 0) goto La4
            double r6 = r6.doubleValue()
            java.lang.Double r8 = r2.f52916a
            double r8 = r8.doubleValue()
            int r8 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r8 < 0) goto La4
            java.lang.Double r8 = r2.f52917b
            if (r8 == 0) goto La3
            double r8 = r8.doubleValue()
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 > 0) goto La4
        La3:
            r4 = r5
        La4:
            if (r3 != 0) goto La8
            if (r4 == 0) goto L39
        La8:
            java.util.Map r5 = r0.f52926k
            if (r5 != 0) goto Lb3
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap
            r5.<init>()
            r0.f52926k = r5
        Lb3:
            if (r3 == 0) goto Lbc
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r3 = "ui.contributes_to_ttid"
            r5.put(r3, r0)
        Lbc:
            if (r4 == 0) goto L39
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            java.lang.String r3 = "ui.contributes_to_ttfd"
            r5.put(r3, r0)
            goto L39
        Lc7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.PerformanceAndroidEventProcessor.f(io.sentry.protocol.SentryTransaction):void");
    }

    public static SentrySpan g(TimeSpan timeSpan, SpanId spanId, SentryId sentryId, String str) {
        long jA;
        HashMap map = new HashMap(2);
        map.put("thread.id", Long.valueOf(Looper.getMainLooper().getThread().getId()));
        map.put("thread.name", "main");
        Boolean bool = Boolean.TRUE;
        map.put("ui.contributes_to_ttid", bool);
        map.put("ui.contributes_to_ttfd", bool);
        Double dValueOf = Double.valueOf(timeSpan.f52381b / 1000.0d);
        if (timeSpan.c()) {
            jA = timeSpan.a() + timeSpan.f52381b;
        } else {
            jA = 0;
        }
        return new SentrySpan(dValueOf, Double.valueOf(jA / 1000.0d), sentryId, new SpanId(), spanId, str, timeSpan.f52380a, SpanStatus.OK, "auto.ui", new ConcurrentHashMap(), new ConcurrentHashMap(), null, map);
    }

    @Override // io.sentry.EventProcessor
    public final SentryEvent b(SentryEvent sentryEvent, Hint hint) {
        return sentryEvent;
    }

    @Override // io.sentry.EventProcessor
    public final synchronized SentryTransaction c(SentryTransaction sentryTransaction, Hint hint) {
        Map map;
        try {
            if (!this.f52180b.isTracingEnabled()) {
                return sentryTransaction;
            }
            AppStartMetrics appStartMetricsB = AppStartMetrics.b();
            if (e(sentryTransaction)) {
                if (appStartMetricsB.f52377k && appStartMetricsB.f52368b) {
                    long jA = appStartMetricsB.a(this.f52180b).a();
                    if (jA != 0) {
                        sentryTransaction.t.put(appStartMetricsB.f52367a == AppStartMetrics.AppStartType.COLD ? "app_start_cold" : "app_start_warm", new MeasurementValue(Float.valueOf(jA), MeasurementUnit.Duration.MILLISECOND.apiName()));
                        d(appStartMetricsB, sentryTransaction);
                        appStartMetricsB.f52377k = false;
                        appStartMetricsB.f52372f.clear();
                        appStartMetricsB.f52373g.clear();
                    }
                }
                App app2 = (App) sentryTransaction.f51792b.d(App.class, Constants.APP_DIR);
                if (app2 == null) {
                    app2 = new App();
                    sentryTransaction.f51792b.b(app2);
                }
                app2.f52808j = appStartMetricsB.f52367a == AppStartMetrics.AppStartType.COLD ? "cold" : "warm";
            }
            f(sentryTransaction);
            SentryId sentryId = sentryTransaction.f51791a;
            SpanContext spanContextA = sentryTransaction.f51792b.a();
            if (sentryId != null && spanContextA != null && spanContextA.f51925e.contentEquals("ui.load")) {
                ActivityFramesTracker activityFramesTracker = this.f52179a;
                synchronized (activityFramesTracker) {
                    if (activityFramesTracker.b()) {
                        Map map2 = (Map) activityFramesTracker.f51998c.get(sentryId);
                        activityFramesTracker.f51998c.remove(sentryId);
                        map = map2;
                    } else {
                        map = null;
                    }
                }
                if (map != null) {
                    sentryTransaction.t.putAll(map);
                }
            }
            return sentryTransaction;
        } catch (Throwable th) {
            throw th;
        }
    }
}
