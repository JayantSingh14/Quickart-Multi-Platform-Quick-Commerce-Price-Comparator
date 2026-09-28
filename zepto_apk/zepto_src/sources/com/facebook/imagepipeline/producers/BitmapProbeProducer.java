package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class BitmapProbeProducer implements Producer<CloseableReference<CloseableImage>> {

    public static class ProbeConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* renamed from: c, reason: collision with root package name */
        public final ProducerContext f18110c;

        /* renamed from: d, reason: collision with root package name */
        public final Supplier f18111d;

        /* renamed from: e, reason: collision with root package name */
        public final CacheKeyFactory f18112e;

        public ProbeConsumer(Consumer consumer, ProducerContext producerContext, InstrumentedMemoryCache instrumentedMemoryCache, Supplier supplier, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2) {
            super(consumer);
            this.f18110c = producerContext;
            this.f18111d = supplier;
            this.f18112e = cacheKeyFactory;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            CloseableReference closeableReference = (CloseableReference) obj;
            ProducerContext producerContext = this.f18110c;
            try {
                FrescoSystrace.a();
                boolean zE = BaseConsumer.e(i2);
                Consumer consumer = this.f18138b;
                if (!zE && closeableReference != null) {
                    if (!((i2 & 8) != 0)) {
                        this.f18112e.d(producerContext.D(), producerContext.a());
                        String str = (String) producerContext.T("origin");
                        if (str != null && str.equals("memory_bitmap")) {
                            producerContext.c().b().getClass();
                            producerContext.c().b().getClass();
                        }
                        consumer.b(i2, closeableReference);
                        FrescoSystrace.a();
                        return;
                    }
                }
                consumer.b(i2, closeableReference);
                FrescoSystrace.a();
            } catch (Throwable th) {
                FrescoSystrace.a();
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        try {
            FrescoSystrace.a();
            ProducerListener2 producerListener2S = producerContext.s();
            producerListener2S.c(producerContext, "BitmapProbeProducer");
            new ProbeConsumer(consumer, producerContext, null, null, null, null, null);
            producerListener2S.i(producerContext, "BitmapProbeProducer", null);
            FrescoSystrace.a();
            throw null;
        } catch (Throwable th) {
            FrescoSystrace.a();
            throw th;
        }
    }
}
