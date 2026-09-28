package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.systrace.FrescoSystrace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ThreadHandoffProducer<T> implements Producer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Producer f18319a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadHandoffProducerQueue f18320b;

    @Metadata
    public static final class Companion {
    }

    public ThreadHandoffProducer(Producer inputProducer, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        Intrinsics.checkNotNullParameter(inputProducer, "inputProducer");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        this.f18319a = inputProducer;
        this.f18320b = threadHandoffProducerQueue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$statefulRunnable$1] */
    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(final Consumer consumer, final ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        FrescoSystrace.a();
        final ProducerListener2 producerListener2S = context.s();
        context.c().b().getClass();
        final ?? r1 = new StatefulProducerRunnable<Object>(producerListener2S, context, this) { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$statefulRunnable$1

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ ProducerListener2 f18324g;

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ ProducerContext f18325h;

            /* renamed from: i, reason: collision with root package name */
            public final /* synthetic */ ThreadHandoffProducer f18326i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.f18323f, producerListener2S, context, "BackgroundThreadHandoffProducer");
                this.f18324g = producerListener2S;
                this.f18325h = context;
                this.f18326i = this;
            }

            @Override // com.facebook.common.executors.StatefulRunnable
            public final void b(Object obj) {
            }

            @Override // com.facebook.common.executors.StatefulRunnable
            public final Object c() {
                return null;
            }

            @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
            public final void f(Object obj) {
                ProducerListener2 producerListener2 = this.f18324g;
                ProducerContext producerContext = this.f18325h;
                producerListener2.i(producerContext, "BackgroundThreadHandoffProducer", null);
                this.f18326i.f18319a.b(this.f18323f, producerContext);
            }
        };
        context.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.ThreadHandoffProducer$produceResults$1$1
            @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
            public final void b() {
                ThreadHandoffProducer$produceResults$1$statefulRunnable$1 threadHandoffProducer$produceResults$1$statefulRunnable$1 = r1;
                threadHandoffProducer$produceResults$1$statefulRunnable$1.a();
                this.f18320b.b(threadHandoffProducer$produceResults$1$statefulRunnable$1);
            }
        });
        this.f18320b.a(r1);
    }
}
