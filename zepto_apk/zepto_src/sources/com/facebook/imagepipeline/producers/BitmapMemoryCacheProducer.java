package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.HasImageMetadata;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {

    /* renamed from: a, reason: collision with root package name */
    public final InstrumentedMemoryCache f18104a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f18105b;

    /* renamed from: c, reason: collision with root package name */
    public final Producer f18106c;

    public BitmapMemoryCacheProducer(InstrumentedMemoryCache instrumentedMemoryCache, CacheKeyFactory cacheKeyFactory, Producer producer) {
        this.f18104a = instrumentedMemoryCache;
        this.f18105b = cacheKeyFactory;
        this.f18106c = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        try {
            FrescoSystrace.a();
            ProducerListener2 producerListener2S = producerContext.s();
            producerListener2S.c(producerContext, d());
            BitmapMemoryCacheKey bitmapMemoryCacheKeyA = this.f18105b.a(producerContext.D(), producerContext.a());
            CloseableReference closeableReference = producerContext.D().n(1) ? this.f18104a.get(bitmapMemoryCacheKeyA) : null;
            if (closeableReference != null) {
                producerContext.N(((HasImageMetadata) closeableReference.l()).getExtras());
                boolean zA = ((CloseableImage) closeableReference.l()).q1().a();
                if (zA) {
                    producerListener2S.i(producerContext, d(), producerListener2S.e(producerContext, d()) ? ImmutableMap.a("cached_value_found", "true") : null);
                    producerListener2S.b(producerContext, d(), true);
                    producerContext.e("memory_bitmap", c());
                    consumer.c(1.0f);
                }
                consumer.b(zA ? 1 : 0, closeableReference);
                closeableReference.close();
                if (zA) {
                    return;
                }
            }
            if (producerContext.Z().f18369a >= 4) {
                producerListener2S.i(producerContext, d(), producerListener2S.e(producerContext, d()) ? ImmutableMap.a("cached_value_found", "false") : null);
                producerListener2S.b(producerContext, d(), false);
                producerContext.e("memory_bitmap", c());
                consumer.b(1, null);
                return;
            }
            Consumer consumerE = e(consumer, bitmapMemoryCacheKeyA, producerContext.D().n(2));
            producerListener2S.i(producerContext, d(), producerListener2S.e(producerContext, d()) ? ImmutableMap.a("cached_value_found", "false") : null);
            FrescoSystrace.a();
            this.f18106c.b(consumerE, producerContext);
            FrescoSystrace.a();
        } finally {
            FrescoSystrace.a();
        }
    }

    public String c() {
        return "pipe_bg";
    }

    public String d() {
        return "BitmapMemoryCacheProducer";
    }

    public Consumer e(Consumer consumer, final CacheKey cacheKey, final boolean z) {
        return new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(consumer) { // from class: com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer.1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void h(int i2, Object obj) {
                CloseableReference closeableReference;
                CloseableReference closeableReference2 = (CloseableReference) obj;
                try {
                    FrescoSystrace.a();
                    boolean zD = BaseConsumer.d(i2);
                    Consumer consumer2 = this.f18138b;
                    if (closeableReference2 == null) {
                        if (zD) {
                            consumer2.b(i2, null);
                        }
                        return;
                    }
                    if (BaseConsumer.k(i2, 8)) {
                        consumer2.b(i2, closeableReference2);
                        return;
                    }
                    CacheKey cacheKey2 = cacheKey;
                    BitmapMemoryCacheProducer bitmapMemoryCacheProducer = BitmapMemoryCacheProducer.this;
                    if (!zD && (closeableReference = bitmapMemoryCacheProducer.f18104a.get(cacheKey2)) != null) {
                        try {
                            QualityInfo qualityInfoQ1 = ((CloseableImage) closeableReference2.l()).q1();
                            QualityInfo qualityInfoQ12 = ((CloseableImage) closeableReference.l()).q1();
                            if (qualityInfoQ12.a() || qualityInfoQ12.c() >= qualityInfoQ1.c()) {
                                consumer2.b(i2, closeableReference);
                                return;
                            }
                        } finally {
                            closeableReference.close();
                        }
                    }
                    CloseableReference closeableReferenceB = z ? bitmapMemoryCacheProducer.f18104a.b(cacheKey2, closeableReference2) : null;
                    if (zD) {
                        try {
                            consumer2.c(1.0f);
                        } catch (Throwable th) {
                            CloseableReference.e(closeableReferenceB);
                            throw th;
                        }
                    }
                    if (closeableReferenceB != null) {
                        closeableReference2 = closeableReferenceB;
                    }
                    consumer2.b(i2, closeableReference2);
                    CloseableReference.e(closeableReferenceB);
                } finally {
                    FrescoSystrace.a();
                }
            }
        };
    }
}
