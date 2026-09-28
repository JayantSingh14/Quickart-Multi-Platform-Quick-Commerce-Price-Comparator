package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

@Nullsafe
/* loaded from: classes3.dex */
public class ThrottlingProducer<T> implements Producer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ResizeAndRotateProducer f18329a;

    /* renamed from: b, reason: collision with root package name */
    public int f18330b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f18331c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f18332d;

    public class ThrottlerConsumer extends DelegatingConsumer<T, T> {
        public ThrottlerConsumer(Consumer consumer) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void f() {
            this.f18138b.a();
            l();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public final void g(Throwable th) {
            this.f18138b.onFailure(th);
            l();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            this.f18138b.b(i2, obj);
            if (BaseConsumer.d(i2)) {
                l();
            }
        }

        public final void l() {
            final Pair pair;
            synchronized (ThrottlingProducer.this) {
                try {
                    pair = (Pair) ThrottlingProducer.this.f18331c.poll();
                    if (pair == null) {
                        ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                        throttlingProducer.f18330b--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (pair != null) {
                ThrottlingProducer.this.f18332d.execute(new Runnable() { // from class: com.facebook.imagepipeline.producers.ThrottlingProducer.ThrottlerConsumer.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ThrottlingProducer throttlingProducer2 = ThrottlingProducer.this;
                        Pair pair2 = pair;
                        Consumer consumer = (Consumer) pair2.first;
                        ProducerContext producerContext = (ProducerContext) pair2.second;
                        throttlingProducer2.getClass();
                        producerContext.s().i(producerContext, "ThrottlingProducer", null);
                        throttlingProducer2.f18329a.b(new ThrottlerConsumer(consumer), producerContext);
                    }
                });
            }
        }
    }

    public ThrottlingProducer(Executor executor, ResizeAndRotateProducer resizeAndRotateProducer) {
        executor.getClass();
        this.f18332d = executor;
        this.f18329a = resizeAndRotateProducer;
        this.f18331c = new ConcurrentLinkedQueue();
        this.f18330b = 0;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        boolean z;
        producerContext.s().c(producerContext, "ThrottlingProducer");
        synchronized (this) {
            try {
                int i2 = this.f18330b;
                z = true;
                if (i2 >= 5) {
                    this.f18331c.add(Pair.create(consumer, producerContext));
                } else {
                    this.f18330b = i2 + 1;
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            return;
        }
        producerContext.s().i(producerContext, "ThrottlingProducer", null);
        this.f18329a.b(new ThrottlerConsumer(consumer), producerContext);
    }
}
