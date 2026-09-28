package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.core.DiskCachesStore;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes3.dex */
public class EncodedProbeProducer implements Producer<EncodedImage> {

    public static class ProbeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {

        /* renamed from: c, reason: collision with root package name */
        public final ProducerContext f18161c;

        /* renamed from: d, reason: collision with root package name */
        public final Supplier f18162d;

        /* renamed from: e, reason: collision with root package name */
        public final CacheKeyFactory f18163e;

        /* renamed from: f, reason: collision with root package name */
        public final BoundedLinkedHashSet f18164f;

        /* renamed from: g, reason: collision with root package name */
        public final BoundedLinkedHashSet f18165g;

        public ProbeConsumer(Consumer consumer, ProducerContext producerContext, Supplier supplier, CacheKeyFactory cacheKeyFactory, BoundedLinkedHashSet boundedLinkedHashSet, BoundedLinkedHashSet boundedLinkedHashSet2) {
            super(consumer);
            this.f18161c = producerContext;
            this.f18162d = supplier;
            this.f18163e = cacheKeyFactory;
            this.f18164f = boundedLinkedHashSet;
            this.f18165g = boundedLinkedHashSet2;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public final void h(int i2, Object obj) {
            boolean zContains;
            EncodedImage encodedImage = (EncodedImage) obj;
            ProducerContext producerContext = this.f18161c;
            try {
                FrescoSystrace.a();
                boolean zE = BaseConsumer.e(i2);
                Consumer consumer = this.f18138b;
                if (!zE && encodedImage != null) {
                    if (!((i2 & 10) != 0)) {
                        encodedImage.Z();
                        if (encodedImage.f17957b != ImageFormat.f17694c) {
                            ImageRequest imageRequestD = producerContext.D();
                            SimpleCacheKey key = this.f18163e.d(imageRequestD, producerContext.a());
                            this.f18164f.a(key);
                            boolean zEquals = "memory_encoded".equals(producerContext.T("origin"));
                            BoundedLinkedHashSet boundedLinkedHashSet = this.f18165g;
                            if (zEquals) {
                                synchronized (boundedLinkedHashSet) {
                                    zContains = boundedLinkedHashSet.f17729b.contains(key);
                                }
                                if (!zContains) {
                                    boolean z = imageRequestD.f18347a == ImageRequest.CacheChoice.f18360a;
                                    DiskCachesStore diskCachesStore = (DiskCachesStore) this.f18162d.get();
                                    BufferedDiskCache bufferedDiskCacheA = z ? diskCachesStore.a() : diskCachesStore.b();
                                    bufferedDiskCacheA.getClass();
                                    Intrinsics.checkNotNullParameter(key, "key");
                                    bufferedDiskCacheA.f17730a.b(key);
                                    boundedLinkedHashSet.a(key);
                                }
                            } else if ("disk".equals(producerContext.T("origin"))) {
                                boundedLinkedHashSet.a(key);
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

    /* JADX WARN: Finally extract failed */
    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        try {
            FrescoSystrace.a();
            ProducerListener2 producerListener2S = producerContext.s();
            producerListener2S.c(producerContext, "EncodedProbeProducer");
            new ProbeConsumer(consumer, producerContext, null, null, null, null);
            producerListener2S.i(producerContext, "EncodedProbeProducer", null);
            FrescoSystrace.a();
            throw null;
        } catch (Throwable th) {
            FrescoSystrace.a();
            throw th;
        }
    }
}
