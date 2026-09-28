package io.sentry.android.core;

import android.content.Context;
import android.os.SystemClock;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.OptionsContainer;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class SentryAndroid {

    /* renamed from: a, reason: collision with root package name */
    public static final long f52193a = SystemClock.uptimeMillis();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f52194b = 0;

    public static void a(SentryOptions sentryOptions, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Integration integration : sentryOptions.getIntegrations()) {
            if (z && (integration instanceof FragmentLifecycleIntegration)) {
                arrayList2.add(integration);
            }
            if (z2 && (integration instanceof SentryTimberIntegration)) {
                arrayList.add(integration);
            }
        }
        if (arrayList2.size() > 1) {
            for (int i2 = 0; i2 < arrayList2.size() - 1; i2++) {
                sentryOptions.getIntegrations().remove((Integration) arrayList2.get(i2));
            }
        }
        if (arrayList.size() > 1) {
            for (int i3 = 0; i3 < arrayList.size() - 1; i3++) {
                sentryOptions.getIntegrations().remove((Integration) arrayList.get(i3));
            }
        }
    }

    public static synchronized void b(Context context, AndroidLogger androidLogger, Sentry.OptionsConfiguration optionsConfiguration) {
        try {
            try {
                try {
                    try {
                        Sentry.e(new OptionsContainer(), new d(androidLogger, context, optionsConfiguration));
                        IHub iHubD = Sentry.d();
                        if (((Boolean) ContextUtils.f52104b.a()).booleanValue()) {
                            if (iHubD.y().isEnableAutoSessionTracking()) {
                                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                                iHubD.w(new l(atomicBoolean, 3));
                                if (!atomicBoolean.get()) {
                                    iHubD.p();
                                }
                            }
                            iHubD.y().getReplayController().start();
                        }
                    } catch (InvocationTargetException e2) {
                        androidLogger.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e2);
                        throw new RuntimeException("Failed to initialize Sentry's SDK", e2);
                    }
                } catch (InstantiationException e3) {
                    androidLogger.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e3);
                    throw new RuntimeException("Failed to initialize Sentry's SDK", e3);
                }
            } catch (IllegalAccessException e4) {
                androidLogger.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e4);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e4);
            } catch (NoSuchMethodException e5) {
                androidLogger.b(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", e5);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
