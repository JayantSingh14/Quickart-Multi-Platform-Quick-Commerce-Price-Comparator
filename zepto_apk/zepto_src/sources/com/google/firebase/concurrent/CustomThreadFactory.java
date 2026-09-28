package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
class CustomThreadFactory implements ThreadFactory {

    /* renamed from: e, reason: collision with root package name */
    public static final ThreadFactory f43624e = Executors.defaultThreadFactory();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f43625a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    public final String f43626b;

    /* renamed from: c, reason: collision with root package name */
    public final int f43627c;

    /* renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f43628d;

    public CustomThreadFactory(String str, int i2, StrictMode.ThreadPolicy threadPolicy) {
        this.f43626b = str;
        this.f43627c = i2;
        this.f43628d = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f43624e.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                CustomThreadFactory customThreadFactory = this.f43656a;
                Process.setThreadPriority(customThreadFactory.f43627c);
                StrictMode.ThreadPolicy threadPolicy = customThreadFactory.f43628d;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                runnable.run();
            }
        });
        Locale locale = Locale.ROOT;
        threadNewThread.setName(this.f43626b + " Thread #" + this.f43625a.getAndIncrement());
        return threadNewThread;
    }
}
