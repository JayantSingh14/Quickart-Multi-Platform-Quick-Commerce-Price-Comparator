package io.sentry.android.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.SystemClock;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.NetworkBreadcrumbsIntegration;
import io.sentry.android.core.internal.util.AndroidConnectionStatusProvider;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52237a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f52238b;

    public /* synthetic */ a(ANRWatchDog aNRWatchDog, com.google.common.net.a aVar) {
        this.f52237a = 0;
        this.f52238b = aNRWatchDog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f52237a) {
            case 0:
                ANRWatchDog aNRWatchDog = (ANRWatchDog) this.f52238b;
                int i2 = ANRWatchDog.f51981l;
                aNRWatchDog.getClass();
                aNRWatchDog.f51989h = SystemClock.uptimeMillis();
                aNRWatchDog.f51990i.set(false);
                return;
            case 1:
                NetworkBreadcrumbsIntegration networkBreadcrumbsIntegration = (NetworkBreadcrumbsIntegration) this.f52238b;
                synchronized (networkBreadcrumbsIntegration.f52160d) {
                    try {
                        if (networkBreadcrumbsIntegration.f52163g != null) {
                            Context context = networkBreadcrumbsIntegration.f52157a;
                            ILogger iLogger = networkBreadcrumbsIntegration.f52159c;
                            BuildInfoProvider buildInfoProvider = networkBreadcrumbsIntegration.f52158b;
                            NetworkBreadcrumbsIntegration.NetworkBreadcrumbsNetworkCallback networkBreadcrumbsNetworkCallback = networkBreadcrumbsIntegration.f52163g;
                            buildInfoProvider.getClass();
                            ConnectivityManager connectivityManagerE = AndroidConnectionStatusProvider.e(context, iLogger);
                            if (connectivityManagerE != null) {
                                try {
                                    connectivityManagerE.unregisterNetworkCallback(networkBreadcrumbsNetworkCallback);
                                } catch (Throwable th) {
                                    iLogger.b(SentryLevel.WARNING, "unregisterNetworkCallback failed", th);
                                }
                            }
                            networkBreadcrumbsIntegration.f52159c.c(SentryLevel.DEBUG, "NetworkBreadcrumbsIntegration removed.", new Object[0]);
                        }
                        networkBreadcrumbsIntegration.f52163g = null;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
            case 2:
                ((ActivityFramesTracker) this.f52238b).f51996a.e();
                return;
            case 3:
                ((AndroidProfiler) this.f52238b).b(null, true);
                return;
            case 4:
                ((AppLifecycleIntegration) this.f52238b).b();
                return;
            default:
                InternalSentrySdk.c((SentryOptions) this.f52238b);
                return;
        }
    }

    public /* synthetic */ a(Object obj, int i2) {
        this.f52237a = i2;
        this.f52238b = obj;
    }
}
