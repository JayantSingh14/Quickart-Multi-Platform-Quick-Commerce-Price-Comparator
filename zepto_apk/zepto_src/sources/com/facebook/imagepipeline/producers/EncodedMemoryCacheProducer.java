package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final InstrumentedMemoryCache f18154a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f18155b;

    /* renamed from: c, reason: collision with root package name */
    public final Producer f18156c;

    public static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* renamed from: c, reason: collision with root package name */
        public final InstrumentedMemoryCache f18157c;

        /* renamed from: d, reason: collision with root package name */
        public final CacheKey f18158d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f18159e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f18160f;

        public EncodedMemoryCacheConsumer(CacheKey cacheKey, InstrumentedMemoryCache instrumentedMemoryCache, Consumer consumer, boolean z, boolean z2) {
            super(consumer);
            this.f18157c = instrumentedMemoryCache;
            this.f18158d = cacheKey;
            this.f18159e = z;
            this.f18160f = z2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            EncodedImage encodedImage = (EncodedImage) obj;
            try {
                FrescoSystrace.a();
                boolean zE = BaseConsumer.e(i2);
                Consumer consumer = this.f18138b;
                if (!zE && encodedImage != null) {
                    if (!((i2 & 10) != 0)) {
                        encodedImage.Z();
                        if (encodedImage.f17957b != ImageFormat.f17694c) {
                            CloseableReference closeableReferenceC = CloseableReference.c(encodedImage.f17956a);
                            if (closeableReferenceC != null) {
                                try {
                                    CloseableReference closeableReferenceB = (this.f18160f && this.f18159e) ? this.f18157c.b(this.f18158d, closeableReferenceC) : null;
                                    if (closeableReferenceB != null) {
                                        try {
                                            EncodedImage encodedImage2 = new EncodedImage(closeableReferenceB);
                                            encodedImage2.c(encodedImage);
                                            try {
                                                consumer.c(1.0f);
                                                consumer.b(i2, encodedImage2);
                                                FrescoSystrace.a();
                                                return;
                                            } finally {
                                                encodedImage2.close();
                                            }
                                        } finally {
                                            closeableReferenceB.close();
                                        }
                                    }
                                } finally {
                                    closeableReferenceC.close();
                                }
                            }
                            consumer.b(i2, encodedImage);
                            FrescoSystrace.a();
                            return;
                        }
                    }
                }
                consumer.b(i2, encodedImage);
                FrescoSystrace.a();
            } catch (Throwable th) {
                FrescoSystrace.a();
                throw th;
            }
        }
    }

    public EncodedMemoryCacheProducer(InstrumentedMemoryCache instrumentedMemoryCache, CacheKeyFactory cacheKeyFactory, Producer producer) {
        this.f18154a = instrumentedMemoryCache;
        this.f18155b = cacheKeyFactory;
        this.f18156c = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        try {
            FrescoSystrace.a();
            ProducerListener2 producerListener2S = producerContext.s();
            producerListener2S.c(producerContext, "EncodedMemoryCacheProducer");
            SimpleCacheKey simpleCacheKeyD = this.f18155b.d(producerContext.D(), producerContext.a());
            CloseableReference closeableReference = producerContext.D().n(4) ? this.f18154a.get(simpleCacheKeyD) : null;
            try {
                if (closeableReference != null) {
                    EncodedImage encodedImage = new EncodedImage(closeableReference);
                    try {
                        producerListener2S.i(producerContext, "EncodedMemoryCacheProducer", producerListener2S.e(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.a("cached_value_found", "true") : null);
                        producerListener2S.b(producerContext, "EncodedMemoryCacheProducer", true);
                        producerContext.r("memory_encoded");
                        consumer.c(1.0f);
                        consumer.b(1, encodedImage);
                        encodedImage.close();
                        closeableReference.close();
                        FrescoSystrace.a();
                        return;
                    } catch (Throwable th) {
                        encodedImage.close();
                        throw th;
                    }
                }
                if (producerContext.Z().f18369a < 3) {
                    EncodedMemoryCacheConsumer encodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(simpleCacheKeyD, this.f18154a, consumer, producerContext.D().n(8), producerContext.c().b().f17862d);
                    producerListener2S.i(producerContext, "EncodedMemoryCacheProducer", producerListener2S.e(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.a("cached_value_found", "false") : null);
                    this.f18156c.b(encodedMemoryCacheConsumer, producerContext);
                    CloseableReference.e(closeableReference);
                    FrescoSystrace.a();
                    return;
                }
                producerListener2S.i(producerContext, "EncodedMemoryCacheProducer", producerListener2S.e(producerContext, "EncodedMemoryCacheProducer") ? ImmutableMap.a("cached_value_found", "false") : null);
                producerListener2S.b(producerContext, "EncodedMemoryCacheProducer", false);
                producerContext.e("memory_encoded", "nil-result");
                consumer.b(1, null);
                CloseableReference.e(closeableReference);
                FrescoSystrace.a();
            } catch (Throwable th2) {
                CloseableReference.e(closeableReference);
                throw th2;
            }
        } catch (Throwable th3) {
            FrescoSystrace.a();
            throw th3;
        }
    }
}
