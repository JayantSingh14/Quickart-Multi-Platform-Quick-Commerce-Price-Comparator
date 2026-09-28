package androidx.work.impl.constraints.trackers;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi21;
import androidx.work.impl.utils.NetworkApi23;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class NetworkStateTrackerKt {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12845a;

    static {
        String strG = Logger.g("NetworkStateTracker");
        Intrinsics.checkNotNullExpressionValue(strG, "tagWithPrefix(\"NetworkStateTracker\")");
        f12845a = strG;
    }

    public static final NetworkState a(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilitiesA;
        Intrinsics.checkNotNullParameter(connectivityManager, "<this>");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        Intrinsics.checkNotNullParameter(connectivityManager, "<this>");
        try {
            networkCapabilitiesA = NetworkApi21.a(connectivityManager, NetworkApi23.a(connectivityManager));
        } catch (SecurityException e2) {
            Logger.e().d(f12845a, "Unable to validate active network", e2);
        }
        boolean zB = networkCapabilitiesA != null ? NetworkApi21.b(networkCapabilitiesA, 16) : false;
        return new NetworkState(z, zB, ConnectivityManagerCompat.a(connectivityManager), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }
}
