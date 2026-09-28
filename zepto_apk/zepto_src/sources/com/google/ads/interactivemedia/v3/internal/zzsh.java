package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
enum zzsh implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
