package io.sentry.android.core.internal.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import io.sentry.IConnectionStatusProvider;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.BuildInfoProvider;
import java.util.HashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AndroidConnectionStatusProvider implements IConnectionStatusProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Context f52300a;

    /* renamed from: b, reason: collision with root package name */
    public final ILogger f52301b;

    /* renamed from: c, reason: collision with root package name */
    public final BuildInfoProvider f52302c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f52303d;

    public AndroidConnectionStatusProvider(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        Context applicationContext = context.getApplicationContext();
        this.f52300a = applicationContext != null ? applicationContext : context;
        this.f52301b = iLogger;
        this.f52302c = buildInfoProvider;
        this.f52303d = new HashMap();
    }

    public static ConnectivityManager e(Context context, ILogger iLogger) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            iLogger.c(SentryLevel.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
        }
        return connectivityManager;
    }

    public static boolean f(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider, ConnectivityManager.NetworkCallback networkCallback) {
        buildInfoProvider.getClass();
        ConnectivityManager connectivityManagerE = e(context, iLogger);
        if (connectivityManagerE == null) {
            return false;
        }
        if (!Permissions.a(context)) {
            iLogger.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        try {
            connectivityManagerE.registerDefaultNetworkCallback(networkCallback);
            return true;
        } catch (Throwable th) {
            iLogger.b(SentryLevel.WARNING, "registerDefaultNetworkCallback failed", th);
            return false;
        }
    }

    @Override // io.sentry.IConnectionStatusProvider
    public final String a() {
        BuildInfoProvider buildInfoProvider = this.f52302c;
        Context context = this.f52300a;
        ILogger iLogger = this.f52301b;
        ConnectivityManager connectivityManagerE = e(context, iLogger);
        if (connectivityManagerE != null) {
            if (!Permissions.a(context)) {
                iLogger.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
                return null;
            }
            try {
                buildInfoProvider.getClass();
                Network activeNetwork = connectivityManagerE.getActiveNetwork();
                if (activeNetwork == null) {
                    iLogger.c(SentryLevel.INFO, "Network is null and cannot check network status", new Object[0]);
                    return null;
                }
                NetworkCapabilities networkCapabilities = connectivityManagerE.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null) {
                    iLogger.c(SentryLevel.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                    return null;
                }
                boolean zHasTransport = networkCapabilities.hasTransport(3);
                boolean zHasTransport2 = networkCapabilities.hasTransport(1);
                boolean zHasTransport3 = networkCapabilities.hasTransport(0);
                if (zHasTransport) {
                    return "ethernet";
                }
                if (zHasTransport2) {
                    return "wifi";
                }
                if (zHasTransport3) {
                    return "cellular";
                }
            } catch (Throwable th) {
                iLogger.b(SentryLevel.ERROR, "Failed to retrieve network info", th);
            }
        }
        return null;
    }

    @Override // io.sentry.IConnectionStatusProvider
    public final IConnectionStatusProvider.ConnectionStatus b() {
        Context context = this.f52300a;
        ILogger iLogger = this.f52301b;
        ConnectivityManager connectivityManagerE = e(context, iLogger);
        if (connectivityManagerE == null) {
            return IConnectionStatusProvider.ConnectionStatus.UNKNOWN;
        }
        if (!Permissions.a(context)) {
            iLogger.c(SentryLevel.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return IConnectionStatusProvider.ConnectionStatus.NO_PERMISSION;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManagerE.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected() ? IConnectionStatusProvider.ConnectionStatus.CONNECTED : IConnectionStatusProvider.ConnectionStatus.DISCONNECTED;
            }
            iLogger.c(SentryLevel.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
            return IConnectionStatusProvider.ConnectionStatus.DISCONNECTED;
        } catch (Throwable th) {
            iLogger.b(SentryLevel.WARNING, "Could not retrieve Connection Status", th);
            return IConnectionStatusProvider.ConnectionStatus.UNKNOWN;
        }
    }

    @Override // io.sentry.IConnectionStatusProvider
    public final boolean c(final IConnectionStatusProvider.IConnectionStatusObserver iConnectionStatusObserver) {
        BuildInfoProvider buildInfoProvider = this.f52302c;
        buildInfoProvider.getClass();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: io.sentry.android.core.internal.util.AndroidConnectionStatusProvider.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                iConnectionStatusObserver.a(AndroidConnectionStatusProvider.this.b());
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLosing(Network network, int i2) {
                iConnectionStatusObserver.a(AndroidConnectionStatusProvider.this.b());
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                iConnectionStatusObserver.a(AndroidConnectionStatusProvider.this.b());
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onUnavailable() {
                iConnectionStatusObserver.a(AndroidConnectionStatusProvider.this.b());
            }
        };
        this.f52303d.put(iConnectionStatusObserver, networkCallback);
        return f(this.f52300a, this.f52301b, buildInfoProvider, networkCallback);
    }

    @Override // io.sentry.IConnectionStatusProvider
    public final void d(IConnectionStatusProvider.IConnectionStatusObserver iConnectionStatusObserver) {
        ConnectivityManager.NetworkCallback networkCallback = (ConnectivityManager.NetworkCallback) this.f52303d.remove(iConnectionStatusObserver);
        if (networkCallback != null) {
            this.f52302c.getClass();
            Context context = this.f52300a;
            ILogger iLogger = this.f52301b;
            ConnectivityManager connectivityManagerE = e(context, iLogger);
            if (connectivityManagerE == null) {
                return;
            }
            try {
                connectivityManagerE.unregisterNetworkCallback(networkCallback);
            } catch (Throwable th) {
                iLogger.b(SentryLevel.WARNING, "unregisterNetworkCallback failed", th);
            }
        }
    }
}
