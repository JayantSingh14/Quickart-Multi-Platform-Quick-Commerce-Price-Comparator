package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class zzflc implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f31359a = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f31359a.getAndIncrement();
        return new Thread(runnable, androidx.fragment.app.e.r(new StringBuilder(String.valueOf(andIncrement).length() + 14), andIncrement, "AdWorker(NG) #"));
    }
}
