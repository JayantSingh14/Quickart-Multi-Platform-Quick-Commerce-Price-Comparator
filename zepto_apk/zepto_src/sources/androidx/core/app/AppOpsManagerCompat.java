package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* loaded from: classes3.dex */
public final class AppOpsManagerCompat {

    @RequiresApi
    public static class Api23Impl {
    }

    @RequiresApi
    public static class Api29Impl {
        public static String a(Context context) {
            return context.getOpPackageName();
        }
    }

    public static int a(int i2, Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        int iCheckOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(str, Binder.getCallingUid(), str2);
        if (iCheckOpNoThrow != 0) {
            return iCheckOpNoThrow;
        }
        String strA = Api29Impl.a(context);
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, i2, strA);
    }
}
