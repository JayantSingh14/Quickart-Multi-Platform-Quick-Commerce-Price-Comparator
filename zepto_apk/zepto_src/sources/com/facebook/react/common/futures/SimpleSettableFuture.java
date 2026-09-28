package com.facebook.react.common.futures;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SimpleSettableFuture<T> implements Future<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f18717a = new CountDownLatch(1);

    /* renamed from: b, reason: collision with root package name */
    public Object f18718b;

    /* renamed from: c, reason: collision with root package name */
    public Exception f18719c;

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        this.f18717a.await();
        if (this.f18719c == null) {
            return this.f18718b;
        }
        throw new ExecutionException(this.f18719c);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f18717a.getCount() == 0;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (this.f18717a.await(j2, unit)) {
            if (this.f18719c == null) {
                return this.f18718b;
            }
            throw new ExecutionException(this.f18719c);
        }
        throw new TimeoutException("Timed out waiting for result");
    }
}
