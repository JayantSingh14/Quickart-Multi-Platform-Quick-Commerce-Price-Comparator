package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final Object d() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final String e() {
            throw null;
        }
    }

    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final Object d() {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final String e() {
            throw null;
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void a(Throwable th) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void b(Object obj) {
            throw null;
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean c() {
            throw null;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void j() {
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public final void r() {
    }
}
