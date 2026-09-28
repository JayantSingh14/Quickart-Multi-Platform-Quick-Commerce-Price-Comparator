package io.invertase.firebase.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.invertase.firebase.app.ReactNativeFirebaseApp;

/* loaded from: classes.dex */
public class ReactNativeFirebaseMeta {

    /* renamed from: a, reason: collision with root package name */
    public static final ReactNativeFirebaseMeta f49239a = new ReactNativeFirebaseMeta();

    public static boolean a(String str) {
        Bundle bundleB = b();
        if (bundleB == null) {
            return true;
        }
        return bundleB.getBoolean("rnfirebase_".concat(str), true);
    }

    public static Bundle b() {
        ApplicationInfo applicationInfo;
        try {
            Context context = ReactNativeFirebaseApp.f49227a;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null) {
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
