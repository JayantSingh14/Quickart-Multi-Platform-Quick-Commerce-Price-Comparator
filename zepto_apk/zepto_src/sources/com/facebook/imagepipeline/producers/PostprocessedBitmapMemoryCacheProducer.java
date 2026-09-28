package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {

    /* renamed from: a, reason: collision with root package name */
    public final InstrumentedMemoryCache f18272a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f18273b;

    /* renamed from: c, reason: collision with root package name */
    public final PostprocessorProducer f18274c;

    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {

        /* renamed from: c, reason: collision with root package name */
        public final CacheKey f18275c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f18276d;

        /* renamed from: e, reason: collision with root package name */
        public final InstrumentedMemoryCache f18277e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f18278f;

        public CachedPostprocessorConsumer(CacheKey cacheKey, InstrumentedMemoryCache instrumentedMemoryCache, Consumer consumer, boolean z, boolean z2) {
            super(consumer);
            this.f18275c = cacheKey;
            this.f18276d = z;
            this.f18277e = instrumentedMemoryCache;
            this.f18278f = z2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            CloseableReference closeableReference = (CloseableReference) obj;
            Consumer consumer = this.f18138b;
            if (closeableReference == null) {
                if (BaseConsumer.d(i2)) {
                    consumer.b(i2, null);
                }
            } else if (!BaseConsumer.e(i2) || this.f18276d) {
                CloseableReference closeableReferenceB = this.f18278f ? this.f18277e.b(this.f18275c, closeableReference) : null;
                try {
                    consumer.c(1.0f);
                    if (closeableReferenceB != null) {
                        closeableReference = closeableReferenceB;
                    }
                    consumer.b(i2, closeableReference);
                } finally {
                    CloseableReference.e(closeableReferenceB);
                }
            }
        }
    }

    public PostprocessedBitmapMemoryCacheProducer(InstrumentedMemoryCache instrumentedMemoryCache, CacheKeyFactory cacheKeyFactory, PostprocessorProducer postprocessorProducer) {
        this.f18272a = instrumentedMemoryCache;
        this.f18273b = cacheKeyFactory;
        this.f18274c = postprocessorProducer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        ProducerListener2 producerListener2S = producerContext.s();
        ImageRequest imageRequestD = producerContext.D();
        Object objA = producerContext.a();
        Postprocessor postprocessor = imageRequestD.p;
        PostprocessorProducer postprocessorProducer = this.f18274c;
        if (postprocessor == null || postprocessor.a() == null) {
            postprocessorProducer.b(consumer, producerContext);
            return;
        }
        producerListener2S.c(producerContext, "PostprocessedBitmapMemoryCacheProducer");
        BitmapMemoryCacheKey bitmapMemoryCacheKeyB = this.f18273b.b(imageRequestD, objA);
        CloseableReference closeableReference = producerContext.D().n(1) ? this.f18272a.get(bitmapMemoryCacheKeyB) : null;
        if (closeableReference == null) {
            CachedPostprocessorConsumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(bitmapMemoryCacheKeyB, this.f18272a, consumer, postprocessor instanceof RepeatedPostprocessor, producerContext.D().n(2));
            producerListener2S.i(producerContext, "PostprocessedBitmapMemoryCacheProducer", producerListener2S.e(producerContext, "PostprocessedBitmapMemoryCacheProducer") ? ImmutableMap.a("cached_value_found", "false") : null);
            postprocessorProducer.b(cachedPostprocessorConsumer, producerContext);
        } else {
            producerListener2S.i(producerContext, "PostprocessedBitmapMemoryCacheProducer", producerListener2S.e(producerContext, "PostprocessedBitmapMemoryCacheProducer") ? ImmutableMap.a("cached_value_found", "true") : null);
            producerListener2S.b(producerContext, "PostprocessedBitmapMemoryCacheProducer", true);
            producerContext.e("memory_bitmap", "postprocessed");
            consumer.c(1.0f);
            consumer.b(1, closeableReference);
            closeableReference.close();
        }
    }
}
