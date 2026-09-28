package io.sentry.cache;

import io.sentry.IOptionsObserver;
import io.sentry.SentryOptions;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.protocol.SdkVersion;
import java.util.Map;

/* loaded from: classes.dex */
public final class PersistingOptionsObserver implements IOptionsObserver {

    /* renamed from: a, reason: collision with root package name */
    public final SentryAndroidOptions f52679a;

    public PersistingOptionsObserver(SentryAndroidOptions sentryAndroidOptions) {
        this.f52679a = sentryAndroidOptions;
    }

    public static Object i(SentryOptions sentryOptions, String str, Class cls) {
        return CacheUtils.c(sentryOptions, ".options-cache", str, cls);
    }

    @Override // io.sentry.IOptionsObserver
    public final void a(Map map) {
        j(map, "tags.json");
    }

    @Override // io.sentry.IOptionsObserver
    public final void b(String str) {
        if (str == null) {
            h("dist.json");
        } else {
            j(str, "dist.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public final void c(Double d2) {
        if (d2 == null) {
            h("replay-error-sample-rate.json");
        } else {
            j(d2.toString(), "replay-error-sample-rate.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public final void d(String str) {
        if (str == null) {
            h("environment.json");
        } else {
            j(str, "environment.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public final void e(String str) {
        if (str == null) {
            h("proguard-uuid.json");
        } else {
            j(str, "proguard-uuid.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public final void f(SdkVersion sdkVersion) {
        if (sdkVersion == null) {
            h("sdk-version.json");
        } else {
            j(sdkVersion, "sdk-version.json");
        }
    }

    @Override // io.sentry.IOptionsObserver
    public final void g(String str) {
        if (str == null) {
            h("release.json");
        } else {
            j(str, "release.json");
        }
    }

    public final void h(String str) {
        CacheUtils.a(this.f52679a, ".options-cache", str);
    }

    public final void j(Object obj, String str) {
        CacheUtils.d(this.f52679a, obj, ".options-cache", str);
    }
}
