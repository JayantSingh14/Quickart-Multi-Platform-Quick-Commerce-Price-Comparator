package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;

@Nullsafe
/* loaded from: classes3.dex */
public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, EncodedImage> {

    /* renamed from: e, reason: collision with root package name */
    public final CacheKeyFactory f18153e;

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, Producer producer) {
        super(producer, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt");
        this.f18153e = cacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final Closeable c(Closeable closeable) {
        return EncodedImage.a((EncodedImage) closeable);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final Pair d(ProducerContext producerContext) {
        return Pair.create(this.f18153e.d(producerContext.D(), producerContext.a()), producerContext.Z());
    }
}
