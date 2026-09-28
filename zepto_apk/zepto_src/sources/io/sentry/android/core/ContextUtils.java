package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.util.AndroidLazyEvaluator;
import io.sentry.protocol.App;
import io.sentry.util.LazyEvaluator;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class ContextUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final AndroidLazyEvaluator f52103a = new AndroidLazyEvaluator(new androidx.work.impl.model.a(21));

    /* renamed from: b, reason: collision with root package name */
    public static final LazyEvaluator f52104b = new LazyEvaluator(new androidx.work.impl.model.a(22));

    /* renamed from: c, reason: collision with root package name */
    public static final AndroidLazyEvaluator f52105c = new AndroidLazyEvaluator(new androidx.work.impl.model.a(23));

    /* renamed from: d, reason: collision with root package name */
    public static final AndroidLazyEvaluator f52106d = new AndroidLazyEvaluator(new androidx.work.impl.model.a(24));

    /* renamed from: e, reason: collision with root package name */
    public static final AndroidLazyEvaluator f52107e = new AndroidLazyEvaluator(new androidx.work.impl.model.a(25));

    /* renamed from: f, reason: collision with root package name */
    public static final AndroidLazyEvaluator f52108f = new AndroidLazyEvaluator(new androidx.work.impl.model.a(26));

    /* renamed from: g, reason: collision with root package name */
    public static final AndroidLazyEvaluator f52109g = new AndroidLazyEvaluator(new androidx.work.impl.model.a(20));

    public static class SideLoadedInfo {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f52110a;

        /* renamed from: b, reason: collision with root package name */
        public final String f52111b;

        public SideLoadedInfo(String str, boolean z) {
            this.f52110a = z;
            this.f52111b = str;
        }
    }

    public static String a(ILogger iLogger) {
        try {
            return Build.MODEL.split(StringUtils.SPACE, -1)[0];
        } catch (Throwable th) {
            iLogger.b(SentryLevel.ERROR, "Error getting device family.", th);
            return null;
        }
    }

    public static ActivityManager.MemoryInfo b(Context context, ILogger iLogger) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            iLogger.c(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th) {
            iLogger.b(SentryLevel.ERROR, "Error getting MemoryInfo.", th);
            return null;
        }
    }

    public static PackageInfo c(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        try {
            buildInfoProvider.getClass();
            return Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(4096)) : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        } catch (Throwable th) {
            iLogger.b(SentryLevel.ERROR, "Error getting package info.", th);
            return null;
        }
    }

    public static PackageInfo d(Context context, BuildInfoProvider buildInfoProvider) {
        buildInfoProvider.getClass();
        return Build.VERSION.SDK_INT >= 33 ? (PackageInfo) f52105c.a(context) : (PackageInfo) f52106d.a(context);
    }

    public static String e(PackageInfo packageInfo, BuildInfoProvider buildInfoProvider) {
        buildInfoProvider.getClass();
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
    }

    public static void f(PackageInfo packageInfo, BuildInfoProvider buildInfoProvider, App app2) {
        app2.f52799a = packageInfo.packageName;
        app2.f52804f = packageInfo.versionName;
        app2.f52805g = e(packageInfo, buildInfoProvider);
        HashMap map = new HashMap();
        String[] strArr = packageInfo.requestedPermissions;
        int[] iArr = packageInfo.requestedPermissionsFlags;
        if (strArr != null && strArr.length > 0 && iArr != null && iArr.length > 0) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                map.put(str.substring(str.lastIndexOf(46) + 1), (iArr[i2] & 2) == 2 ? "granted" : "not_granted");
            }
        }
        app2.f52806h = map;
    }
}
