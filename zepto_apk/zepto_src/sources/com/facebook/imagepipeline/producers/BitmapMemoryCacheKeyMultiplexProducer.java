package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;

@Nullsafe
/* loaded from: classes3.dex */
public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, CloseableReference<CloseableImage>> {

    /* renamed from: e, reason: collision with root package name */
    public final CacheKeyFactory f18103e;

    public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory cacheKeyFactory, BitmapMemoryCacheProducer bitmapMemoryCacheProducer) {
        super(bitmapMemoryCacheProducer, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
        this.f18103e = cacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final Closeable c(Closeable closeable) {
        return CloseableReference.c((CloseableReference) closeable);
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public final Pair d(ProducerContext producerContext) {
        return Pair.create(this.f18103e.a(producerContext.D(), producerContext.a()), producerContext.Z());
    }
}
