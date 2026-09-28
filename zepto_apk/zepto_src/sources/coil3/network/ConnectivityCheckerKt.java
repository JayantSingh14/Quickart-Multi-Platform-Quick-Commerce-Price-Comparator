package coil3.network;

import android.content.Context;
import android.net.ConnectivityManager;
import coil3.network.internal.Utils_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ConnectivityCheckerKt {
    @NotNull
    public static final ConnectivityChecker ConnectivityChecker(@NotNull Context context) {
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(ConnectivityManager.class);
        if (connectivityManager == null || !Utils_androidKt.isPermissionGranted(applicationContext, "android.permission.ACCESS_NETWORK_STATE")) {
            return ConnectivityChecker.ONLINE;
        }
        try {
            return new ConnectivityCheckerApi23(connectivityManager);
        } catch (Exception unused) {
            return ConnectivityChecker.ONLINE;
        }
    }
}
