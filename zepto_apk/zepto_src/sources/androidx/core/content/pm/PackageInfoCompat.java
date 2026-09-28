package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
public final class PackageInfoCompat {

    @RequiresApi
    public static class Api28Impl {
        public static long a(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
    }

    public static long a(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.a(packageInfo) : packageInfo.versionCode;
    }
}
