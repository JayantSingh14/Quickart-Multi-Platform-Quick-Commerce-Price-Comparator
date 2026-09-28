package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import in.juspay.airborne.ota.Constants;
import in.juspay.hyper.constants.LogSubCategory;
import io.sentry.DateUtils;
import io.sentry.EventProcessor;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryLevel;
import io.sentry.SentryReplayEvent;
import io.sentry.android.core.ContextUtils;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.android.core.util.AndroidLazyEvaluator;
import io.sentry.protocol.App;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Device;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
final class DefaultAndroidEventProcessor implements EventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52115a;

    /* renamed from: b, reason: collision with root package name */
    public final BuildInfoProvider f52116b;

    /* renamed from: c, reason: collision with root package name */
    public final SentryAndroidOptions f52117c;

    /* renamed from: d, reason: collision with root package name */
    public final Future f52118d;

    public DefaultAndroidEventProcessor(Context context, BuildInfoProvider buildInfoProvider, final SentryAndroidOptions sentryAndroidOptions) {
        Context applicationContext = context.getApplicationContext();
        this.f52115a = applicationContext != null ? applicationContext : context;
        this.f52116b = buildInfoProvider;
        Objects.b(sentryAndroidOptions, "The options object is required.");
        this.f52117c = sentryAndroidOptions;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f52118d = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: io.sentry.android.core.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DeviceInfoUtil.c(this.f52258a.f52115a, sentryAndroidOptions);
            }
        });
        executorServiceNewSingleThreadExecutor.shutdown();
    }

    @Override // io.sentry.EventProcessor
    public final SentryReplayEvent a(SentryReplayEvent sentryReplayEvent, Hint hint) {
        boolean zF = f(sentryReplayEvent, hint);
        if (zF) {
            d(sentryReplayEvent, hint);
        }
        e(sentryReplayEvent, false, zF);
        return sentryReplayEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    @Override // io.sentry.EventProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.SentryEvent b(io.sentry.SentryEvent r9, io.sentry.Hint r10) {
        /*
            r8 = this;
            boolean r0 = r8.f(r9, r10)
            r1 = 1
            if (r0 == 0) goto L5a
            r8.d(r9, r10)
            java.util.ArrayList r2 = r9.d()
            if (r2 == 0) goto L5a
            boolean r10 = io.sentry.util.HintUtils.d(r10)
            java.util.ArrayList r2 = r9.d()
            java.util.Iterator r2 = r2.iterator()
        L1c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L5a
            java.lang.Object r3 = r2.next()
            io.sentry.protocol.SentryThread r3 = (io.sentry.protocol.SentryThread) r3
            java.lang.Long r4 = r3.f52946a
            if (r4 == 0) goto L42
            long r4 = r4.longValue()
            android.os.Looper r6 = android.os.Looper.getMainLooper()
            java.lang.Thread r6 = r6.getThread()
            long r6 = r6.getId()
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 != 0) goto L42
            r4 = r1
            goto L43
        L42:
            r4 = 0
        L43:
            java.lang.Boolean r5 = r3.f52951f
            if (r5 != 0) goto L4d
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r3.f52951f = r5
        L4d:
            if (r10 != 0) goto L1c
            java.lang.Boolean r5 = r3.f52953h
            if (r5 != 0) goto L1c
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r3.f52953h = r4
            goto L1c
        L5a:
            r8.e(r9, r1, r0)
            java.util.ArrayList r10 = r9.c()
            if (r10 == 0) goto L9e
            int r0 = r10.size()
            if (r0 <= r1) goto L9e
            java.lang.Object r0 = android.support.v4.media.b.c(r1, r10)
            io.sentry.protocol.SentryException r0 = (io.sentry.protocol.SentryException) r0
            java.lang.String r1 = r0.f52902c
            java.lang.String r2 = "java.lang"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L9e
            io.sentry.protocol.SentryStackTrace r0 = r0.f52904e
            if (r0 == 0) goto L9e
            java.util.List r0 = r0.f52942a
            if (r0 == 0) goto L9e
            java.util.Iterator r0 = r0.iterator()
        L85:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L9e
            java.lang.Object r1 = r0.next()
            io.sentry.protocol.SentryStackFrame r1 = (io.sentry.protocol.SentryStackFrame) r1
            java.lang.String r1 = r1.f52931c
            java.lang.String r2 = "com.android.internal.os.RuntimeInit$MethodAndArgsCaller"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L85
            java.util.Collections.reverse(r10)
        L9e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.DefaultAndroidEventProcessor.b(io.sentry.SentryEvent, io.sentry.Hint):io.sentry.SentryEvent");
    }

    @Override // io.sentry.EventProcessor
    public final SentryTransaction c(SentryTransaction sentryTransaction, Hint hint) {
        boolean zF = f(sentryTransaction, hint);
        if (zF) {
            d(sentryTransaction, hint);
        }
        e(sentryTransaction, false, zF);
        return sentryTransaction;
    }

    public final void d(SentryBaseEvent sentryBaseEvent, Hint hint) {
        Boolean bool;
        Contexts contexts = sentryBaseEvent.f51792b;
        App app2 = (App) contexts.d(App.class, Constants.APP_DIR);
        if (app2 == null) {
            app2 = new App();
        }
        AndroidLazyEvaluator androidLazyEvaluator = ContextUtils.f52107e;
        Context context = this.f52115a;
        app2.f52803e = (String) androidLazyEvaluator.a(context);
        AppStartMetrics appStartMetricsB = AppStartMetrics.b();
        SentryAndroidOptions sentryAndroidOptions = this.f52117c;
        TimeSpan timeSpanA = appStartMetricsB.a(sentryAndroidOptions);
        if (timeSpanA.c()) {
            app2.f52800b = timeSpanA.b() == null ? null : DateUtils.b(Double.valueOf(r1.d() / 1000000.0d).longValue());
        }
        if (!HintUtils.d(hint) && app2.f52809k == null && (bool = AppState.f52099b.f52100a) != null) {
            app2.f52809k = Boolean.valueOf(!bool.booleanValue());
        }
        ILogger logger = sentryAndroidOptions.getLogger();
        BuildInfoProvider buildInfoProvider = this.f52116b;
        PackageInfo packageInfoC = ContextUtils.c(context, logger, buildInfoProvider);
        if (packageInfoC != null) {
            String strE = ContextUtils.e(packageInfoC, buildInfoProvider);
            if (sentryBaseEvent.f51802l == null) {
                sentryBaseEvent.f51802l = strE;
            }
            ContextUtils.f(packageInfoC, buildInfoProvider, app2);
        }
        contexts.b(app2);
    }

    public final void e(SentryBaseEvent sentryBaseEvent, boolean z, boolean z2) {
        User user = sentryBaseEvent.f51799i;
        if (user == null) {
            user = new User();
            sentryBaseEvent.f51799i = user;
        }
        if (user.f52960b == null) {
            user.f52960b = Installation.a(this.f52115a);
        }
        String str = user.f52963e;
        SentryAndroidOptions sentryAndroidOptions = this.f52117c;
        if (str == null && sentryAndroidOptions.isSendDefaultPii()) {
            user.f52963e = "{{auto}}";
        }
        Contexts contexts = sentryBaseEvent.f51792b;
        Device device = (Device) contexts.d(Device.class, LogSubCategory.Context.DEVICE);
        Future future = this.f52118d;
        if (device == null) {
            try {
                contexts.put(LogSubCategory.Context.DEVICE, ((DeviceInfoUtil) future.get()).a(z, z2));
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to retrieve device info", th);
            }
            OperatingSystem operatingSystem = (OperatingSystem) contexts.d(OperatingSystem.class, "os");
            try {
                contexts.put("os", ((DeviceInfoUtil) future.get()).f52125f);
            } catch (Throwable th2) {
                sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to retrieve os system", th2);
            }
            if (operatingSystem != null) {
                String str2 = operatingSystem.f52865a;
                contexts.put((str2 == null || str2.isEmpty()) ? "os_1" : "os_" + str2.trim().toLowerCase(Locale.ROOT), operatingSystem);
            }
        }
        try {
            ContextUtils.SideLoadedInfo sideLoadedInfo = ((DeviceInfoUtil) future.get()).f52124e;
            if (sideLoadedInfo != null) {
                HashMap map = new HashMap();
                map.put("isSideLoaded", String.valueOf(sideLoadedInfo.f52110a));
                String str3 = sideLoadedInfo.f52111b;
                if (str3 != null) {
                    map.put("installerStore", str3);
                }
                for (Map.Entry entry : map.entrySet()) {
                    sentryBaseEvent.b((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Throwable th3) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Error getting side loaded info.", th3);
        }
    }

    public final boolean f(SentryBaseEvent sentryBaseEvent, Hint hint) {
        if (HintUtils.e(hint)) {
            return true;
        }
        this.f52117c.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", sentryBaseEvent.f51791a);
        return false;
    }
}
