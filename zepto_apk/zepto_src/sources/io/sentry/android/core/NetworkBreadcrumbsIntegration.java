package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import androidx.annotation.RequiresApi;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SentryDateProvider;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.AndroidConnectionStatusProvider;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class NetworkBreadcrumbsIntegration implements Integration, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52157a;

    /* renamed from: b, reason: collision with root package name */
    public final BuildInfoProvider f52158b;

    /* renamed from: c, reason: collision with root package name */
    public final ILogger f52159c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f52160d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f52161e;

    /* renamed from: f, reason: collision with root package name */
    public SentryOptions f52162f;

    /* renamed from: g, reason: collision with root package name */
    public volatile NetworkBreadcrumbsNetworkCallback f52163g;

    public static class NetworkBreadcrumbConnectionDetail {

        /* renamed from: a, reason: collision with root package name */
        public final int f52166a;

        /* renamed from: b, reason: collision with root package name */
        public final int f52167b;

        /* renamed from: c, reason: collision with root package name */
        public final int f52168c;

        /* renamed from: d, reason: collision with root package name */
        public final long f52169d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f52170e;

        /* renamed from: f, reason: collision with root package name */
        public final String f52171f;

        public NetworkBreadcrumbConnectionDetail(NetworkCapabilities networkCapabilities, BuildInfoProvider buildInfoProvider, long j2) {
            Objects.b(networkCapabilities, "NetworkCapabilities is required");
            Objects.b(buildInfoProvider, "BuildInfoProvider is required");
            this.f52166a = networkCapabilities.getLinkDownstreamBandwidthKbps();
            this.f52167b = networkCapabilities.getLinkUpstreamBandwidthKbps();
            int signalStrength = Build.VERSION.SDK_INT >= 29 ? networkCapabilities.getSignalStrength() : 0;
            this.f52168c = signalStrength <= -100 ? 0 : signalStrength;
            this.f52170e = networkCapabilities.hasTransport(4);
            String str = networkCapabilities.hasTransport(3) ? "ethernet" : networkCapabilities.hasTransport(1) ? "wifi" : networkCapabilities.hasTransport(0) ? "cellular" : null;
            this.f52171f = str == null ? "" : str;
            this.f52169d = j2;
        }
    }

    @RequiresApi
    @SuppressLint({"ObsoleteSdkInt"})
    public static final class NetworkBreadcrumbsNetworkCallback extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        public final HubAdapter f52172a;

        /* renamed from: b, reason: collision with root package name */
        public final BuildInfoProvider f52173b;

        /* renamed from: c, reason: collision with root package name */
        public Network f52174c;

        /* renamed from: d, reason: collision with root package name */
        public NetworkCapabilities f52175d;

        /* renamed from: e, reason: collision with root package name */
        public long f52176e;

        /* renamed from: f, reason: collision with root package name */
        public final SentryDateProvider f52177f;

        public NetworkBreadcrumbsNetworkCallback(BuildInfoProvider buildInfoProvider, SentryDateProvider sentryDateProvider) {
            HubAdapter hubAdapter = HubAdapter.f51658a;
            this.f52174c = null;
            this.f52175d = null;
            this.f52176e = 0L;
            this.f52172a = hubAdapter;
            Objects.b(buildInfoProvider, "BuildInfoProvider is required");
            this.f52173b = buildInfoProvider;
            Objects.b(sentryDateProvider, "SentryDateProvider is required");
            this.f52177f = sentryDateProvider;
        }

        public static Breadcrumb a(String str) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.f51558d = "system";
            breadcrumb.f51560f = "network.event";
            breadcrumb.b(str, "action");
            breadcrumb.f51562h = SentryLevel.INFO;
            return breadcrumb;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            if (network.equals(this.f52174c)) {
                return;
            }
            this.f52172a.a(a("NETWORK_AVAILABLE"));
            this.f52174c = network;
            this.f52175d = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            NetworkBreadcrumbConnectionDetail networkBreadcrumbConnectionDetail;
            if (network.equals(this.f52174c)) {
                long jD = this.f52177f.now().d();
                NetworkCapabilities networkCapabilities2 = this.f52175d;
                long j2 = this.f52176e;
                BuildInfoProvider buildInfoProvider = this.f52173b;
                if (networkCapabilities2 == null) {
                    networkBreadcrumbConnectionDetail = new NetworkBreadcrumbConnectionDetail(networkCapabilities, buildInfoProvider, jD);
                } else {
                    NetworkBreadcrumbConnectionDetail networkBreadcrumbConnectionDetail2 = new NetworkBreadcrumbConnectionDetail(networkCapabilities2, buildInfoProvider, j2);
                    networkBreadcrumbConnectionDetail = new NetworkBreadcrumbConnectionDetail(networkCapabilities, buildInfoProvider, jD);
                    int iAbs = Math.abs(networkBreadcrumbConnectionDetail2.f52168c - networkBreadcrumbConnectionDetail.f52168c);
                    int i2 = networkBreadcrumbConnectionDetail2.f52166a;
                    int iAbs2 = Math.abs(i2 - networkBreadcrumbConnectionDetail.f52166a);
                    int i3 = networkBreadcrumbConnectionDetail2.f52167b;
                    int iAbs3 = Math.abs(i3 - networkBreadcrumbConnectionDetail.f52167b);
                    boolean z = ((double) Math.abs(networkBreadcrumbConnectionDetail2.f52169d - networkBreadcrumbConnectionDetail.f52169d)) / 1000000.0d < 5000.0d;
                    boolean z2 = z || iAbs <= 5;
                    boolean z3 = z || ((double) iAbs2) <= Math.max(1000.0d, ((double) Math.abs(i2)) * 0.1d);
                    boolean z4 = z || ((double) iAbs3) <= Math.max(1000.0d, ((double) Math.abs(i3)) * 0.1d);
                    if (networkBreadcrumbConnectionDetail2.f52170e == networkBreadcrumbConnectionDetail.f52170e && networkBreadcrumbConnectionDetail2.f52171f.equals(networkBreadcrumbConnectionDetail.f52171f) && z2 && z3 && z4) {
                        networkBreadcrumbConnectionDetail = null;
                    }
                }
                if (networkBreadcrumbConnectionDetail == null) {
                    return;
                }
                this.f52175d = networkCapabilities;
                this.f52176e = jD;
                Breadcrumb breadcrumbA = a("NETWORK_CAPABILITIES_CHANGED");
                breadcrumbA.b(Integer.valueOf(networkBreadcrumbConnectionDetail.f52166a), "download_bandwidth");
                breadcrumbA.b(Integer.valueOf(networkBreadcrumbConnectionDetail.f52167b), "upload_bandwidth");
                breadcrumbA.b(Boolean.valueOf(networkBreadcrumbConnectionDetail.f52170e), "vpn_active");
                breadcrumbA.b(networkBreadcrumbConnectionDetail.f52171f, "network_type");
                int i4 = networkBreadcrumbConnectionDetail.f52168c;
                if (i4 != 0) {
                    breadcrumbA.b(Integer.valueOf(i4), "signal_strength");
                }
                Hint hint = new Hint();
                hint.c(networkBreadcrumbConnectionDetail, "android:networkCapabilities");
                this.f52172a.b(breadcrumbA, hint);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            if (network.equals(this.f52174c)) {
                this.f52172a.a(a("NETWORK_LOST"));
                this.f52174c = null;
                this.f52175d = null;
            }
        }
    }

    public NetworkBreadcrumbsIntegration(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        Context applicationContext = context.getApplicationContext();
        this.f52157a = applicationContext != null ? applicationContext : context;
        this.f52158b = buildInfoProvider;
        Objects.b(iLogger, "ILogger is required");
        this.f52159c = iLogger;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f52161e = true;
        try {
            SentryOptions sentryOptions = this.f52162f;
            Objects.b(sentryOptions, "Options is required");
            sentryOptions.getExecutorService().submit(new a(this, 1));
        } catch (Throwable th) {
            this.f52159c.b(SentryLevel.ERROR, "Error submitting NetworkBreadcrumbsIntegration task.", th);
        }
    }

    @Override // io.sentry.Integration
    public final void l(final SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        SentryLevel sentryLevel = SentryLevel.DEBUG;
        Object[] objArr = {Boolean.valueOf(sentryAndroidOptions.isEnableNetworkEventBreadcrumbs())};
        ILogger iLogger = this.f52159c;
        iLogger.c(sentryLevel, "NetworkBreadcrumbsIntegration enabled: %s", objArr);
        this.f52162f = sentryOptions;
        if (sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()) {
            this.f52158b.getClass();
            try {
                sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.NetworkBreadcrumbsIntegration.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (NetworkBreadcrumbsIntegration.this.f52161e) {
                            return;
                        }
                        synchronized (NetworkBreadcrumbsIntegration.this.f52160d) {
                            try {
                                NetworkBreadcrumbsIntegration.this.f52163g = new NetworkBreadcrumbsNetworkCallback(NetworkBreadcrumbsIntegration.this.f52158b, sentryOptions.getDateProvider());
                                NetworkBreadcrumbsIntegration networkBreadcrumbsIntegration = NetworkBreadcrumbsIntegration.this;
                                if (AndroidConnectionStatusProvider.f(networkBreadcrumbsIntegration.f52157a, networkBreadcrumbsIntegration.f52159c, networkBreadcrumbsIntegration.f52158b, networkBreadcrumbsIntegration.f52163g)) {
                                    NetworkBreadcrumbsIntegration.this.f52159c.c(SentryLevel.DEBUG, "NetworkBreadcrumbsIntegration installed.", new Object[0]);
                                    IntegrationUtils.a("NetworkBreadcrumbs");
                                } else {
                                    NetworkBreadcrumbsIntegration.this.f52159c.c(SentryLevel.DEBUG, "NetworkBreadcrumbsIntegration not installed.", new Object[0]);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                iLogger.b(SentryLevel.ERROR, "Error submitting NetworkBreadcrumbsIntegration task.", th);
            }
        }
    }
}
