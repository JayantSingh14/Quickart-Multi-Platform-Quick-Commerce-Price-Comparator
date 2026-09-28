package com.google.android.gms.internal.measurement;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
final class zzed implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadFactory f36896a;

    public zzed(zzfb zzfbVar) {
        Objects.requireNonNull(zzfbVar);
        this.f36896a = Executors.defaultThreadFactory();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f36896a.newThread(runnable);
        threadNewThread.setName("ScionFrontendApi");
        return threadNewThread;
    }
}
