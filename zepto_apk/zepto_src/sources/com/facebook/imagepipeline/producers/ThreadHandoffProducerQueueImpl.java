package com.facebook.imagepipeline.producers;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18327a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f18328b;

    public ThreadHandoffProducerQueueImpl(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f18327a = executor;
        this.f18328b = new ArrayDeque();
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public final synchronized void a(ThreadHandoffProducer$produceResults$1$statefulRunnable$1 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f18327a.execute(runnable);
    }

    @Override // com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue
    public final synchronized void b(ThreadHandoffProducer$produceResults$1$statefulRunnable$1 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        this.f18328b.remove(runnable);
    }
}
