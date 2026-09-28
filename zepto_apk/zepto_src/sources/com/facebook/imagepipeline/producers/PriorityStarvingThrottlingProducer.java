package com.facebook.imagepipeline.producers;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Comparator;

@Nullsafe
/* loaded from: classes3.dex */
public class PriorityStarvingThrottlingProducer<T> implements Producer<T> {

    /* renamed from: a, reason: collision with root package name */
    public int f18296a;

    public static class Item<T> {
    }

    public static class PriorityComparator<T> implements Comparator<Item<T>> {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            ((Item) obj).getClass();
            throw null;
        }
    }

    public class ThrottlerConsumer extends DelegatingConsumer<T, T> {

        /* renamed from: com.facebook.imagepipeline.producers.PriorityStarvingThrottlingProducer$ThrottlerConsumer$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                throw null;
            }
        }

        public ThrottlerConsumer(Consumer consumer) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void f() {
            this.f18138b.a();
            l();
            throw null;
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void g(Throwable th) {
            this.f18138b.onFailure(th);
            l();
            throw null;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            this.f18138b.b(i2, obj);
            if (BaseConsumer.d(i2)) {
                l();
                throw null;
            }
        }

        public final void l() {
            synchronized (PriorityStarvingThrottlingProducer.this) {
                PriorityStarvingThrottlingProducer.this.getClass();
                throw null;
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        System.nanoTime();
        producerContext.s().c(producerContext, "PriorityStarvingThrottlingProducer");
        synchronized (this) {
            int i2 = this.f18296a;
            if (i2 >= 0) {
                throw null;
            }
            this.f18296a = i2 + 1;
        }
        producerContext.s().i(producerContext, "PriorityStarvingThrottlingProducer", null);
        new ThrottlerConsumer(consumer);
        throw null;
    }
}
