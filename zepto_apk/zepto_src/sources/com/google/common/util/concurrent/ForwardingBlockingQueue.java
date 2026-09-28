package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public abstract BlockingQueue t();

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection collection, int i2) {
        return t().drainTo(collection, i2);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final boolean offer(Object obj, long j2, TimeUnit timeUnit) {
        return t().offer(obj, j2, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final Object poll(long j2, TimeUnit timeUnit) {
        return t().poll(j2, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final void put(Object obj) throws InterruptedException {
        t().put(obj);
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int remainingCapacity() {
        return t().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final Object take() {
        return t().take();
    }

    @Override // java.util.concurrent.BlockingQueue
    public final int drainTo(Collection collection) {
        return t().drainTo(collection);
    }
}
