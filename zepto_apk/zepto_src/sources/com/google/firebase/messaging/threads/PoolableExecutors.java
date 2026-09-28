package com.google.firebase.messaging.threads;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class PoolableExecutors {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorFactory f44896a = null;

    /* renamed from: b, reason: collision with root package name */
    public static volatile ExecutorFactory f44897b = new DefaultExecutorFactory();

    public static class DefaultExecutorFactory implements ExecutorFactory {
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public final ExecutorService a(NamedThreadFactory namedThreadFactory) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), namedThreadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }
}
