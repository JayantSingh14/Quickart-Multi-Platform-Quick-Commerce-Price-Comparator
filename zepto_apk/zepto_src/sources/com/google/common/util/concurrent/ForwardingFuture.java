package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {

    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {
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

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return t().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return t().get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return t().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return t().isDone();
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public abstract Future t();

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        return t().get(j2, timeUnit);
    }
}
