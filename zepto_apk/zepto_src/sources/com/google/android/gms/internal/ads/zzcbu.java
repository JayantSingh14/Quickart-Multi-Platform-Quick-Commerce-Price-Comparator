package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class zzcbu implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f25860a;

    public zzcbu(zzcbw zzcbwVar) {
        Objects.requireNonNull(zzcbwVar);
        this.f25860a = new AtomicInteger(1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f25860a.getAndIncrement();
        return new Thread(runnable, androidx.fragment.app.e.r(new StringBuilder(String.valueOf(andIncrement).length() + 31), andIncrement, "AdWorker(SCION_TASK_EXECUTOR) #"));
    }
}
