package com.google.android.gms.internal.ads;

import java.lang.Thread;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbxs implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Thread.UncaughtExceptionHandler f25671a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbxv f25672b;

    public zzbxs(zzbxv zzbxvVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f25671a = uncaughtExceptionHandler;
        Objects.requireNonNull(zzbxvVar);
        this.f25672b = zzbxvVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f25671a;
        try {
            try {
                this.f25672b.g(th);
            } catch (Throwable th2) {
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
                throw th2;
            }
        } catch (Throwable unused) {
            com.google.android.gms.ads.internal.util.client.zzo.c("AdMob exception reporter failed reporting the exception.");
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
