package com.amazon.apay.hardened.activity;

import java.lang.Thread;
import java.util.Arrays;
import timber.log.Timber;

/* loaded from: classes3.dex */
public class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public APayBrowserActivity f14972a;

    /* renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f14973b;

    /* renamed from: c, reason: collision with root package name */
    public APayBrowserActivity f14974c;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Timber.c("ActivityExceptionHandler uncaughtException called", new Object[0]);
        try {
            if (th.toString().contains("com.amazon.apay.hardened") || th.toString().contains("com.amazon.identity.auth") || Arrays.toString(th.getStackTrace()).contains("com.amazon.apay.hardened") || Arrays.toString(th.getStackTrace()).contains("com.amazon.identity.auth")) {
                Timber.b(th, "ExceptionHandler:uncaughtException invoked", new Object[0]);
                com.amazon.apay.hardened.manager.b.f15005b.logCrashEvent(th);
                com.amazon.apay.hardened.manager.b.a("CrashOccurred", "KUBER_HARDENED_SDK.BUSINESS_METRICS");
                Timber.a("crash metric emitted successfully", new Object[0]);
            }
            if (this.f14974c != null) {
                Timber.a("finishing activity", new Object[0]);
                this.f14972a.finish();
            }
            Thread.setDefaultUncaughtExceptionHandler(this.f14973b);
            Timber.a("defaultExceptionHandler reset to previous one", new Object[0]);
            uncaughtExceptionHandler = this.f14973b;
            if (uncaughtExceptionHandler == null) {
                return;
            }
        } catch (Exception unused) {
            Thread.setDefaultUncaughtExceptionHandler(this.f14973b);
            Timber.a("defaultExceptionHandler reset to previous one", new Object[0]);
            uncaughtExceptionHandler = this.f14973b;
            if (uncaughtExceptionHandler == null) {
                return;
            }
        } catch (Throwable th2) {
            Thread.setDefaultUncaughtExceptionHandler(this.f14973b);
            Timber.a("defaultExceptionHandler reset to previous one", new Object[0]);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f14973b;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }
}
