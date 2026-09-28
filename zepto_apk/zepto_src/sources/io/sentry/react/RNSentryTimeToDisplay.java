package io.sentry.react;

import android.os.Handler;
import android.os.Looper;
import com.facebook.react.bridge.Promise;
import io.sentry.android.core.SentryAndroidDateProvider;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class RNSentryTimeToDisplay {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f53014a = new AnonymousClass1(51, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    public static String f53015b = null;

    /* renamed from: io.sentry.react.RNSentryTimeToDisplay$1, reason: invalid class name */
    public class AnonymousClass1 extends LinkedHashMap<String, Double> {
        @Override // java.util.LinkedHashMap
        public final boolean removeEldestEntry(Map.Entry<String, Double> entry) {
            return size() > 50;
        }
    }

    public static void a(Promise promise, SentryAndroidDateProvider sentryAndroidDateProvider) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper == null) {
            promise.reject("GetTimeToDisplay is not able to measure the time to display: Main looper not available.");
        } else {
            new Handler(mainLooper).post(new in.juspay.hypernfc.b(27, sentryAndroidDateProvider, promise));
        }
    }

    public static Double b(String str) {
        return (Double) ((HashMap) f53014a).remove(str);
    }

    public static void c(String str, Double d2) {
        ((HashMap) f53014a).put(str, d2);
    }

    public static void d(Double d2) {
        if (f53015b != null) {
            c("ttid-navigation-" + f53015b, d2);
        }
    }

    public static void e(String str) {
        f53015b = str;
    }
}
