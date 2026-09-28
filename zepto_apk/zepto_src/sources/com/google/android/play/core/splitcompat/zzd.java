package com.google.android.play.core.splitcompat;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzd {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadPoolExecutor f41907a;

    public static ThreadPoolExecutor a() {
        if (f41907a == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzc());
            f41907a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f41907a;
    }
}
