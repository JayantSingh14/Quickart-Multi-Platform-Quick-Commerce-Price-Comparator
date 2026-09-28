package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f43856a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f43857b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f43858c;

    public /* synthetic */ g(CrashlyticsCore crashlyticsCore, long j2, String str) {
        this.f43856a = crashlyticsCore;
        this.f43857b = j2;
        this.f43858c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final CrashlyticsCore crashlyticsCore = this.f43856a;
        CrashlyticsWorker crashlyticsWorker = crashlyticsCore.p.f43875b;
        final long j2 = this.f43857b;
        final String str = this.f43858c;
        crashlyticsWorker.a(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.h
            @Override // java.lang.Runnable
            public final void run() {
                CrashlyticsController crashlyticsController = crashlyticsCore.f43784h;
                CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = crashlyticsController.n;
                if (crashlyticsUncaughtExceptionHandler == null || !crashlyticsUncaughtExceptionHandler.f43803e.get()) {
                    crashlyticsController.f43760i.e(j2, str);
                }
            }
        });
    }
}
