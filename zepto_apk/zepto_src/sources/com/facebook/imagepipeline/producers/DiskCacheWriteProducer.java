package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.core.DiskCachesStore;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.DiskCacheDecision;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;

@Nullsafe
/* loaded from: classes3.dex */
public class DiskCacheWriteProducer implements Producer<EncodedImage> {

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f18147a;

    /* renamed from: b, reason: collision with root package name */
    public final CacheKeyFactory f18148b;

    /* renamed from: c, reason: collision with root package name */
    public final Producer f18149c;

    public static class DiskCacheWriteConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* renamed from: c, reason: collision with root package name */
        public final ProducerContext f18150c;

        /* renamed from: d, reason: collision with root package name */
        public final Supplier f18151d;

        /* renamed from: e, reason: collision with root package name */
        public final CacheKeyFactory f18152e;

        public DiskCacheWriteConsumer(Consumer consumer, ProducerContext producerContext, Supplier supplier, CacheKeyFactory cacheKeyFactory) {
            super(consumer);
            this.f18150c = producerContext;
            this.f18151d = supplier;
            this.f18152e = cacheKeyFactory;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) throws IOException {
            EncodedImage encodedImage = (EncodedImage) obj;
            ProducerContext producerContext = this.f18150c;
            producerContext.s().c(producerContext, "DiskCacheWriteProducer");
            boolean zE = BaseConsumer.e(i2);
            Consumer consumer = this.f18138b;
            if (!zE && encodedImage != null && (i2 & 10) == 0) {
                encodedImage.Z();
                if (encodedImage.f17957b != ImageFormat.f17694c) {
                    ImageRequest imageRequestD = producerContext.D();
                    SimpleCacheKey simpleCacheKeyD = this.f18152e.d(imageRequestD, producerContext.a());
                    DiskCachesStore diskCachesStore = (DiskCachesStore) this.f18151d.get();
                    BufferedDiskCache bufferedDiskCacheA = DiskCacheDecision.a(imageRequestD, diskCachesStore.a(), diskCachesStore.b(), diskCachesStore.c());
                    if (bufferedDiskCacheA != null) {
                        bufferedDiskCacheA.c(simpleCacheKeyD, encodedImage);
                        producerContext.s().i(producerContext, "DiskCacheWriteProducer", null);
                        consumer.b(i2, encodedImage);
                        return;
                    } else {
                        producerContext.s().k(producerContext, "DiskCacheWriteProducer", new DiskCacheDecision.DiskCacheDecisionNoDiskCacheChosenException("Got no disk cache for CacheChoice: " + Integer.valueOf(imageRequestD.f18347a.ordinal()).toString()), null);
                        consumer.b(i2, encodedImage);
                        return;
                    }
                }
            }
            producerContext.s().i(producerContext, "DiskCacheWriteProducer", null);
            consumer.b(i2, encodedImage);
        }
    }

    public DiskCacheWriteProducer(Supplier supplier, CacheKeyFactory cacheKeyFactory, Producer producer) {
        this.f18147a = supplier;
        this.f18148b = cacheKeyFactory;
        this.f18149c = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        if (producerContext.Z().f18369a >= 2) {
            producerContext.e("disk", "nil-result_write");
            consumer.b(1, null);
        } else {
            if (producerContext.D().n(32)) {
                consumer = new DiskCacheWriteConsumer(consumer, producerContext, this.f18147a, this.f18148b);
            }
            this.f18149c.b(consumer, producerContext);
        }
    }
}
