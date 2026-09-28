package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final CrashlyticsController.AnonymousClass1 f43799a;

    /* renamed from: b, reason: collision with root package name */
    public final SettingsController f43800b;

    /* renamed from: c, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f43801c;

    /* renamed from: d, reason: collision with root package name */
    public final CrashlyticsNativeComponentDeferredProxy f43802d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f43803e = new AtomicBoolean(false);

    public interface CrashListener {
    }

    public CrashlyticsUncaughtExceptionHandler(CrashlyticsController.AnonymousClass1 anonymousClass1, SettingsController settingsController, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy) {
        this.f43799a = anonymousClass1;
        this.f43800b = settingsController;
        this.f43801c = uncaughtExceptionHandler;
        this.f43802d = crashlyticsNativeComponentDeferredProxy;
    }

    public final boolean a(Thread thread, Throwable th) {
        Logger logger = Logger.f43705a;
        if (thread == null) {
            logger.c("Crashlytics will not record uncaught exception; null thread", null);
            return false;
        }
        if (th == null) {
            logger.c("Crashlytics will not record uncaught exception; null throwable", null);
            return false;
        }
        if (!this.f43802d.b()) {
            return true;
        }
        logger.b("Crashlytics will not record uncaught exception; native crash exists for session.", null);
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f43801c;
        Logger logger = Logger.f43705a;
        AtomicBoolean atomicBoolean = this.f43803e;
        atomicBoolean.set(true);
        try {
            try {
                if (a(thread, th)) {
                    this.f43799a.a(this.f43800b, thread, th);
                } else {
                    logger.b("Uncaught exception will not be recorded by Crashlytics.", null);
                }
                if (uncaughtExceptionHandler != null) {
                    logger.b("Completed exception processing. Invoking default exception handler.", null);
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } else {
                    logger.b("Completed exception processing, but no default exception handler.", null);
                    System.exit(1);
                }
                atomicBoolean.set(false);
            } catch (Exception e2) {
                logger.c("An error occurred in the uncaught exception handler", e2);
                if (uncaughtExceptionHandler != null) {
                    logger.b("Completed exception processing. Invoking default exception handler.", null);
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } else {
                    logger.b("Completed exception processing, but no default exception handler.", null);
                    System.exit(1);
                }
                atomicBoolean.set(false);
            }
        } catch (Throwable th2) {
            if (uncaughtExceptionHandler != null) {
                logger.b("Completed exception processing. Invoking default exception handler.", null);
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                logger.b("Completed exception processing, but no default exception handler.", null);
                System.exit(1);
            }
            atomicBoolean.set(false);
            throw th2;
        }
    }
}
