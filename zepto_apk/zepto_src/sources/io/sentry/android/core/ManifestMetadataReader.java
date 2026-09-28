package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
final class ManifestMetadataReader {
    public static Bundle a(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider == null) {
            new BuildInfoProvider(iLogger);
        }
        ApplicationInfo applicationInfo = Build.VERSION.SDK_INT >= 33 ? (ApplicationInfo) ContextUtils.f52108f.a(context) : (ApplicationInfo) ContextUtils.f52109g.a(context);
        if (applicationInfo != null) {
            return applicationInfo.metaData;
        }
        return null;
    }

    public static boolean b(Bundle bundle, ILogger iLogger, String str, boolean z) {
        boolean z2 = bundle.getBoolean(str, z);
        iLogger.c(SentryLevel.DEBUG, str + " read: " + z2, new Object[0]);
        return z2;
    }

    public static Boolean c(Bundle bundle, ILogger iLogger) {
        if (bundle.getSerializable("io.sentry.traces.enable") == null) {
            iLogger.c(SentryLevel.DEBUG, "io.sentry.traces.enable used default null", new Object[0]);
            return null;
        }
        boolean z = bundle.getBoolean("io.sentry.traces.enable", false);
        iLogger.c(SentryLevel.DEBUG, "io.sentry.traces.enable read: " + z, new Object[0]);
        return Boolean.valueOf(z);
    }

    public static Double d(Bundle bundle, ILogger iLogger, String str) {
        double dDoubleValue = Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue();
        if (dDoubleValue == -1.0d) {
            dDoubleValue = Integer.valueOf(bundle.getInt(str, -1)).doubleValue();
        }
        iLogger.c(SentryLevel.DEBUG, str + " read: " + dDoubleValue, new Object[0]);
        return Double.valueOf(dDoubleValue);
    }

    public static List e(Bundle bundle, ILogger iLogger, String str) {
        String string = bundle.getString(str);
        iLogger.c(SentryLevel.DEBUG, android.support.v4.media.b.l(str, " read: ", string), new Object[0]);
        if (string != null) {
            return Arrays.asList(string.split(",", -1));
        }
        return null;
    }

    public static long f(Bundle bundle, ILogger iLogger, String str, long j2) {
        long j3 = bundle.getInt(str, (int) j2);
        iLogger.c(SentryLevel.DEBUG, str + " read: " + j3, new Object[0]);
        return j3;
    }

    public static String g(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.c(SentryLevel.DEBUG, android.support.v4.media.b.l(str, " read: ", string), new Object[0]);
        return string;
    }

    public static String h(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.c(SentryLevel.DEBUG, android.support.v4.media.b.l(str, " read: ", string), new Object[0]);
        return string;
    }
}
