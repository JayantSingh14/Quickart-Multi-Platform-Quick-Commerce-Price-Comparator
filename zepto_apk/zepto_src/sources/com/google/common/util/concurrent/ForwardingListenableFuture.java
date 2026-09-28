package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {

        /* renamed from: a, reason: collision with root package name */
        public final AbstractFuture f43448a;

        public SimpleForwardingListenableFuture(AbstractFuture abstractFuture) {
            this.f43448a = abstractFuture;
        }

        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public final Object t() {
            return this.f43448a;
        }

        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture
        /* renamed from: u */
        public final Future t() {
            return this.f43448a;
        }

        @Override // com.google.common.util.concurrent.ForwardingListenableFuture
        /* renamed from: y */
        public final ListenableFuture t() {
            return this.f43448a;
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        t().q(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.ForwardingFuture
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public abstract ListenableFuture t();
}
