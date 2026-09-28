package coil3.network;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@RequiresApi
@Metadata
@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
final class ConnectivityCheckerApi23 implements ConnectivityChecker {

    @NotNull
    private final ConnectivityManager connectivityManager;

    public ConnectivityCheckerApi23(@NotNull ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    @Override // coil3.network.ConnectivityChecker
    public boolean isOnline() {
        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(this.connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(12);
    }
}
