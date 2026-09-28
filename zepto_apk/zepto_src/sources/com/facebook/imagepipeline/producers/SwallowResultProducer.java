package com.facebook.imagepipeline.producers;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class SwallowResultProducer<T> implements Producer<Void> {

    /* renamed from: a, reason: collision with root package name */
    public final Producer f18318a;

    /* renamed from: com.facebook.imagepipeline.producers.SwallowResultProducer$1, reason: invalid class name */
    class AnonymousClass1 extends DelegatingConsumer<Object, Void> {
        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            if (BaseConsumer.d(i2)) {
                this.f18138b.b(i2, null);
            }
        }
    }

    public SwallowResultProducer(Producer producer) {
        this.f18318a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        this.f18318a.b(new AnonymousClass1(consumer), producerContext);
    }
}
