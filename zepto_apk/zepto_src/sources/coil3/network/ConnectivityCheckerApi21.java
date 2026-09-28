package coil3.network;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
@SuppressLint({"MissingPermission"})
/* loaded from: classes3.dex */
final class ConnectivityCheckerApi21 implements ConnectivityChecker {

    @NotNull
    private final ConnectivityManager connectivityManager;

    public ConnectivityCheckerApi21(@NotNull ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override // coil3.network.ConnectivityChecker
    public boolean isOnline() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
