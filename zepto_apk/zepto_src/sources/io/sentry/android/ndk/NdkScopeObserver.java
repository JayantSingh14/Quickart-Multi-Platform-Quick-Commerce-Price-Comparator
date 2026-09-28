package io.sentry.android.ndk;

import io.sentry.Breadcrumb;
import io.sentry.DateUtils;
import io.sentry.ScopeObserverAdapter;
import io.sentry.SentryLevel;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.protocol.User;
import io.sentry.util.Objects;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class NdkScopeObserver extends ScopeObserverAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final SentryAndroidOptions f52389a;

    /* renamed from: b, reason: collision with root package name */
    public final NativeScope f52390b;

    public NdkScopeObserver(SentryAndroidOptions sentryAndroidOptions) {
        NativeScope nativeScope = new NativeScope();
        Objects.b(sentryAndroidOptions, "The SentryOptions object is required.");
        this.f52389a = sentryAndroidOptions;
        this.f52390b = nativeScope;
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void c(final User user) {
        SentryAndroidOptions sentryAndroidOptions = this.f52389a;
        try {
            sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.b
                @Override // java.lang.Runnable
                public final void run() {
                    NativeScope nativeScope = this.f52393a.f52390b;
                    User user2 = user;
                    if (user2 == null) {
                        nativeScope.getClass();
                        NativeScope.nativeRemoveUser();
                        return;
                    }
                    String str = user2.f52960b;
                    String str2 = user2.f52959a;
                    String str3 = user2.f52963e;
                    String str4 = user2.f52961c;
                    nativeScope.getClass();
                    NativeScope.nativeSetUser(str, str2, str3, str4);
                }
            });
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().a(SentryLevel.ERROR, th, "Scope sync setUser has an error.", new Object[0]);
        }
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void d(final Breadcrumb breadcrumb) {
        SentryAndroidOptions sentryAndroidOptions = this.f52389a;
        try {
            sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.a
                @Override // java.lang.Runnable
                public final void run() {
                    NdkScopeObserver ndkScopeObserver = this.f52391a;
                    SentryAndroidOptions sentryAndroidOptions2 = ndkScopeObserver.f52389a;
                    Breadcrumb breadcrumb2 = breadcrumb;
                    SentryLevel sentryLevel = breadcrumb2.f51562h;
                    String strA = null;
                    String lowerCase = sentryLevel != null ? sentryLevel.name().toLowerCase(Locale.ROOT) : null;
                    String strE = DateUtils.e(breadcrumb2.a());
                    try {
                        ConcurrentHashMap concurrentHashMap = breadcrumb2.f51559e;
                        if (!concurrentHashMap.isEmpty()) {
                            strA = sentryAndroidOptions2.getSerializer().a(concurrentHashMap);
                        }
                    } catch (Throwable th) {
                        sentryAndroidOptions2.getLogger().a(SentryLevel.ERROR, th, "Breadcrumb data is not serializable.", new Object[0]);
                    }
                    String str = strA;
                    String str2 = breadcrumb2.f51557c;
                    String str3 = breadcrumb2.f51560f;
                    String str4 = breadcrumb2.f51558d;
                    ndkScopeObserver.f52390b.getClass();
                    NativeScope.nativeAddBreadcrumb(lowerCase, str2, str3, str4, strE, str);
                }
            });
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().a(SentryLevel.ERROR, th, "Scope sync addBreadcrumb has an error.", new Object[0]);
        }
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void e(final String str, final String str2) {
        SentryAndroidOptions sentryAndroidOptions = this.f52389a;
        try {
            sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f52398a.f52390b.getClass();
                    NativeScope.nativeSetTag(str, str2);
                }
            });
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().a(SentryLevel.ERROR, th, "Scope sync setTag(%s) has an error.", str);
        }
    }

    @Override // io.sentry.ScopeObserverAdapter, io.sentry.IScopeObserver
    public final void f(final String str, final String str2) {
        SentryAndroidOptions sentryAndroidOptions = this.f52389a;
        try {
            sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.c
                @Override // java.lang.Runnable
                public final void run() {
                    NativeScope nativeScope = this.f52395a.f52390b;
                    String str3 = str;
                    String str4 = str2;
                    nativeScope.getClass();
                    NativeScope.nativeSetExtra(str3, str4);
                }
            });
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().a(SentryLevel.ERROR, th, "Scope sync setExtra(%s) has an error.", str);
        }
    }
}
