package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import in.juspay.airborne.ota.Constants;
import in.juspay.hyper.constants.LogSubCategory;
import io.sentry.DateUtils;
import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.IScope;
import io.sentry.ISerializer;
import io.sentry.ScopeCallback;
import io.sentry.Sentry;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.android.core.performance.ActivityLifecycleTimeSpan;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.cache.EnvelopeCache;
import io.sentry.protocol.App;
import io.sentry.protocol.User;
import io.sentry.util.MapObjectWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class InternalSentrySdk {
    public static void a(TimeSpan timeSpan, ArrayList arrayList) {
        boolean z = timeSpan.f52382c == 0;
        HubAdapter hubAdapter = HubAdapter.f51658a;
        if (z) {
            hubAdapter.y().getLogger().c(SentryLevel.WARNING, "Can not convert not-started TimeSpan to Map for Hybrid SDKs.", new Object[0]);
            return;
        }
        if (timeSpan.f52383d == 0) {
            hubAdapter.y().getLogger().c(SentryLevel.WARNING, "Can not convert not-stopped TimeSpan to Map for Hybrid SDKs.", new Object[0]);
            return;
        }
        HashMap map = new HashMap();
        map.put("description", timeSpan.f52380a);
        map.put("start_timestamp_ms", Long.valueOf(timeSpan.f52381b));
        map.put("end_timestamp_ms", Long.valueOf(timeSpan.c() ? timeSpan.a() + timeSpan.f52381b : 0L));
        arrayList.add(map);
    }

    public static void b(byte[] bArr, boolean z) {
        HubAdapter hubAdapter = HubAdapter.f51658a;
        final SentryOptions sentryOptionsY = hubAdapter.y();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ISerializer serializer = sentryOptionsY.getSerializer();
                SentryEnvelope sentryEnvelopeA = sentryOptionsY.getEnvelopeReader().a(byteArrayInputStream);
                if (sentryEnvelopeA == null) {
                    byteArrayInputStream.close();
                    return;
                }
                ArrayList arrayList = new ArrayList();
                final Session.State state = null;
                final boolean z2 = false;
                for (SentryEnvelopeItem sentryEnvelopeItem : sentryEnvelopeA.f51813b) {
                    arrayList.add(sentryEnvelopeItem);
                    SentryEvent sentryEventE = sentryEnvelopeItem.e(serializer);
                    if (sentryEventE != null) {
                        if (sentryEventE.e() != null) {
                            state = Session.State.Crashed;
                        }
                        if ((sentryEventE.e() != null) || sentryEventE.f()) {
                            z2 = true;
                        }
                    }
                }
                final AtomicReference atomicReference = new AtomicReference();
                Sentry.c(new ScopeCallback() { // from class: io.sentry.android.core.k
                    @Override // io.sentry.ScopeCallback
                    public final void h(IScope iScope) {
                        Session sessionY = iScope.y();
                        if (sessionY == null) {
                            sentryOptionsY.getLogger().c(SentryLevel.INFO, "Session is null on updateSession", new Object[0]);
                        } else if (sessionY.c(state, null, z2, null)) {
                            if (sessionY.f51900g == Session.State.Crashed) {
                                sessionY.b(DateUtils.a());
                                iScope.D();
                            }
                            atomicReference.set(sessionY);
                        }
                    }
                });
                Session session = (Session) atomicReference.get();
                if (session != null) {
                    arrayList.add(SentryEnvelopeItem.b(serializer, session));
                    if (z && hubAdapter.y().getMainThreadChecker().a()) {
                        try {
                            sentryOptionsY.getExecutorService().submit(new a(sentryOptionsY, 5));
                        } catch (Throwable th) {
                            sentryOptionsY.getLogger().b(SentryLevel.WARNING, "Submission of deletion of the current session file rejected.", th);
                        }
                    } else {
                        c(sentryOptionsY);
                    }
                    if (z) {
                        hubAdapter.p();
                    }
                }
                hubAdapter.z(new SentryEnvelope(sentryEnvelopeA.f51812a, arrayList));
                byteArrayInputStream.close();
            } finally {
            }
        } catch (Throwable th2) {
            sentryOptionsY.getLogger().b(SentryLevel.ERROR, "Failed to capture envelope", th2);
        }
    }

    public static void c(SentryOptions sentryOptions) {
        String cacheDirPath = sentryOptions.getCacheDirPath();
        if (cacheDirPath == null) {
            sentryOptions.getLogger().c(SentryLevel.INFO, "Cache dir is not set, not deleting the current session.", new Object[0]);
            return;
        }
        if (!sentryOptions.isEnableAutoSessionTracking()) {
            sentryOptions.getLogger().c(SentryLevel.DEBUG, "Session tracking is disabled, bailing from deleting current session file.", new Object[0]);
            return;
        }
        int i2 = EnvelopeCache.f52676h;
        if (new File(cacheDirPath, "session.json").delete()) {
            return;
        }
        sentryOptions.getLogger().c(SentryLevel.WARNING, "Failed to delete the current session file.", new Object[0]);
    }

    public static HashMap d() {
        AppStartMetrics appStartMetricsB = AppStartMetrics.b();
        ArrayList arrayList = new ArrayList();
        TimeSpan timeSpan = new TimeSpan();
        timeSpan.e(appStartMetricsB.f52369c.f52382c);
        TimeSpan timeSpan2 = appStartMetricsB.f52369c;
        timeSpan.f52381b = timeSpan2.f52381b;
        timeSpan.f52383d = AppStartMetrics.n;
        timeSpan.f52380a = "Process Initialization";
        a(timeSpan, arrayList);
        a(appStartMetricsB.f52371e, arrayList);
        ArrayList arrayList2 = new ArrayList(appStartMetricsB.f52372f.values());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            a((TimeSpan) it.next(), arrayList);
        }
        ArrayList arrayList3 = new ArrayList(appStartMetricsB.f52373g);
        Collections.sort(arrayList3);
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            ActivityLifecycleTimeSpan activityLifecycleTimeSpan = (ActivityLifecycleTimeSpan) it2.next();
            a(activityLifecycleTimeSpan.f52365a, arrayList);
            a(activityLifecycleTimeSpan.f52366b, arrayList);
        }
        HashMap map = new HashMap();
        map.put("spans", arrayList);
        map.put("type", appStartMetricsB.f52367a.toString().toLowerCase(Locale.ROOT));
        if (timeSpan2.c()) {
            map.put("app_start_timestamp_ms", Long.valueOf(timeSpan2.f52381b));
        }
        return map;
    }

    public static IScope e() {
        final AtomicReference atomicReference = new AtomicReference();
        Sentry.c(new ScopeCallback() { // from class: io.sentry.android.core.j
            @Override // io.sentry.ScopeCallback
            public final void h(IScope iScope) {
                atomicReference.set(iScope.clone());
            }
        });
        return (IScope) atomicReference.get();
    }

    public static HashMap f(Context context, SentryAndroidOptions sentryAndroidOptions, IScope iScope) {
        HashMap map = new HashMap();
        if (iScope != null) {
            try {
                ILogger logger = sentryAndroidOptions.getLogger();
                MapObjectWriter mapObjectWriter = new MapObjectWriter(map);
                ArrayDeque arrayDeque = mapObjectWriter.f53128a;
                DeviceInfoUtil deviceInfoUtilC = DeviceInfoUtil.c(context, sentryAndroidOptions);
                iScope.q().put(LogSubCategory.Context.DEVICE, deviceInfoUtilC.a(true, true));
                iScope.q().put("os", deviceInfoUtilC.f52125f);
                User userT = iScope.t();
                if (userT == null) {
                    userT = new User();
                    iScope.c(userT);
                }
                if (userT.f52960b == null) {
                    try {
                        userT.f52960b = Installation.a(context);
                    } catch (RuntimeException e2) {
                        logger.b(SentryLevel.ERROR, "Could not retrieve installation ID", e2);
                    }
                }
                App app2 = (App) iScope.q().d(App.class, Constants.APP_DIR);
                if (app2 == null) {
                    app2 = new App();
                }
                app2.f52803e = (String) ContextUtils.f52107e.a(context);
                TimeSpan timeSpanA = AppStartMetrics.b().a(sentryAndroidOptions);
                if (timeSpanA.c()) {
                    app2.f52800b = timeSpanA.b() == null ? null : DateUtils.b(Double.valueOf(r5.d() / 1000000.0d).longValue());
                }
                BuildInfoProvider buildInfoProvider = new BuildInfoProvider(sentryAndroidOptions.getLogger());
                PackageInfo packageInfoC = ContextUtils.c(context, sentryAndroidOptions.getLogger(), buildInfoProvider);
                if (packageInfoC != null) {
                    ContextUtils.f(packageInfoC, buildInfoProvider, app2);
                }
                iScope.q().b(app2);
                arrayDeque.add(LogSubCategory.Action.USER);
                mapObjectWriter.n(logger, iScope.t());
                arrayDeque.add("contexts");
                mapObjectWriter.n(logger, iScope.q());
                arrayDeque.add("tags");
                mapObjectWriter.n(logger, iScope.n());
                arrayDeque.add("extras");
                mapObjectWriter.n(logger, iScope.getExtras());
                arrayDeque.add("fingerprint");
                mapObjectWriter.n(logger, iScope.s());
                arrayDeque.add("level");
                mapObjectWriter.n(logger, iScope.a());
                arrayDeque.add("breadcrumbs");
                mapObjectWriter.n(logger, iScope.i());
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Could not serialize scope.", th);
                return new HashMap();
            }
        }
        return map;
    }
}
