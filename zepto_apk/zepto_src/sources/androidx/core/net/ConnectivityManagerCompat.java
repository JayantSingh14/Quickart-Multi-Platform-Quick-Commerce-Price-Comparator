package androidx.core.net;

import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class ConnectivityManagerCompat {

    @RequiresApi
    public static class Api24Impl {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface RestrictBackgroundStatus {
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        return connectivityManager.isActiveNetworkMetered();
    }
}
