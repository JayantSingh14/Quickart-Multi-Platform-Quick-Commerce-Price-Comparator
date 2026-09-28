package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* loaded from: classes3.dex */
class BenchmarkOperation {

    @RequiresApi
    public static class Api21ContextHelper {
    }

    @RequiresApi
    public static class Api24ContextHelper {
    }

    public static boolean a(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = a(file2) && z;
        }
        return z;
    }

    public static void b(Context context, ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        if (a(Build.VERSION.SDK_INT >= 34 ? context.createDeviceProtectedStorageContext().getCacheDir() : context.createDeviceProtectedStorageContext().getCodeCacheDir())) {
            resultDiagnostics.a(14, null);
        } else {
            resultDiagnostics.a(15, null);
        }
    }
}
