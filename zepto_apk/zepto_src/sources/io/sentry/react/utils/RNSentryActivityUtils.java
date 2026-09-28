package io.sentry.react.utils;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import io.sentry.SentryLevel;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.CurrentActivityHolder;
import io.sentry.react.RNSentryOnDrawReporterManager;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class RNSentryActivityUtils {
    public static Activity a(ReactApplicationContext reactApplicationContext) {
        AndroidLogger androidLogger = RNSentryOnDrawReporterManager.RNSentryOnDrawReporterView.f52999h;
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        androidLogger.c(SentryLevel.DEBUG, "[RNSentryActivityUtils] Given ReactApplicationContext has no activity attached, using CurrentActivityHolder as a fallback.", new Object[0]);
        WeakReference weakReference = CurrentActivityHolder.f52112b.f52113a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }
}
