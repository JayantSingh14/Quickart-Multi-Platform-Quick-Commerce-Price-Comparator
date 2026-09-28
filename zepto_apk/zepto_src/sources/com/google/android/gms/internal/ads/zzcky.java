package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class zzcky implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f26480a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    public final int f26481b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f26480a.getAndIncrement();
        return new zzckx(this, runnable, androidx.fragment.app.e.r(new StringBuilder(String.valueOf(andIncrement).length() + 26), andIncrement, "AdWorker(WebViewStartup) #"), runnable);
    }
}
