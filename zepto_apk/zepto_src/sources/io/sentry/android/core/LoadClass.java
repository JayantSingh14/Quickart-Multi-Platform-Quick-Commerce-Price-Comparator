package io.sentry.android.core;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;

/* loaded from: classes.dex */
public final class LoadClass {
    public static boolean a(SentryOptions sentryOptions, String str) {
        return b(str, sentryOptions != null ? sentryOptions.getLogger() : null) != null;
    }

    public static Class b(String str, ILogger iLogger) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            if (iLogger == null) {
                return null;
            }
            iLogger.b(SentryLevel.DEBUG, "Class not available:".concat(str), e2);
            return null;
        } catch (UnsatisfiedLinkError e3) {
            if (iLogger == null) {
                return null;
            }
            iLogger.b(SentryLevel.ERROR, "Failed to load (UnsatisfiedLinkError) ".concat(str), e3);
            return null;
        } catch (Throwable th) {
            if (iLogger == null) {
                return null;
            }
            iLogger.b(SentryLevel.ERROR, "Failed to initialize ".concat(str), th);
            return null;
        }
    }
}
