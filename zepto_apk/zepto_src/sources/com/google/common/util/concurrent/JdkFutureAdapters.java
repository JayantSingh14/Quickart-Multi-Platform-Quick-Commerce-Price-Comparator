package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public final class JdkFutureAdapters {

    public static class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

        /* renamed from: a, reason: collision with root package name */
        public static final ExecutorService f43459a;

        static {
            ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
            threadFactoryBuilder.f43471a = Boolean.TRUE;
            Locale locale = Locale.ROOT;
            f43459a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.google.common.util.concurrent.ThreadFactoryBuilder.1

                /* renamed from: a */
                public final /* synthetic */ ThreadFactory f43472a;

                /* renamed from: b */
                public final /* synthetic */ AtomicLong f43473b;

                /* renamed from: c */
                public final /* synthetic */ Boolean f43474c;

                public AnonymousClass1(ThreadFactory threadFactory, AtomicLong atomicLong, Boolean bool) {
                    threadFactory = threadFactory;
                    atomicLong = atomicLong;
                    bool = bool;
                }

                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread threadNewThread = threadFactory.newThread(runnable);
                    Objects.requireNonNull(threadNewThread);
                    AtomicLong atomicLong = atomicLong;
                    Objects.requireNonNull(atomicLong);
                    long andIncrement = atomicLong.getAndIncrement();
                    Locale locale2 = Locale.ROOT;
                    threadNewThread.setName("ListenableFutureAdapter-thread-" + andIncrement);
                    Boolean bool = bool;
                    if (bool != null) {
                        threadNewThread.setDaemon(bool.booleanValue());
                    }
                    return threadNewThread;
                }
            });
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public final void q(Runnable runnable, Executor executor) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture
        /* renamed from: u */
        public final Future t() {
            return null;
        }
    }
}
