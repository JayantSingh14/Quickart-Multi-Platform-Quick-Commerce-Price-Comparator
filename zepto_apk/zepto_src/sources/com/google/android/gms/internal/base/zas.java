package com.google.android.gms.internal.base;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zas implements zaq {
    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService a(NumberedThreadFactory numberedThreadFactory) {
        return b(1, numberedThreadFactory);
    }

    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService b(int i2, ThreadFactory threadFactory) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    @Override // com.google.android.gms.internal.base.zaq
    public final ExecutorService zab() {
        return b(4, Executors.defaultThreadFactory());
    }
}
