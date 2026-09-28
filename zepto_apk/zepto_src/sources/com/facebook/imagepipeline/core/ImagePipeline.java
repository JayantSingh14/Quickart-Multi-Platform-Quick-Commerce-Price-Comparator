package com.facebook.imagepipeline.core;

import android.net.Uri;
import android.os.StrictMode;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.fresco.urimod.NopUriModifier;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@ThreadSafe
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ImagePipeline {
    public static final CancellationException n = new CancellationException("Prefetching is not enabled");

    /* renamed from: a, reason: collision with root package name */
    public final ProducerSequenceFactory f17821a;

    /* renamed from: b, reason: collision with root package name */
    public final Supplier f17822b;

    /* renamed from: c, reason: collision with root package name */
    public final Supplier f17823c;

    /* renamed from: d, reason: collision with root package name */
    public final ForwardingRequestListener f17824d;

    /* renamed from: e, reason: collision with root package name */
    public final ForwardingRequestListener2 f17825e;

    /* renamed from: f, reason: collision with root package name */
    public final InstrumentedMemoryCache f17826f;

    /* renamed from: g, reason: collision with root package name */
    public final InstrumentedMemoryCache f17827g;

    /* renamed from: h, reason: collision with root package name */
    public final CacheKeyFactory f17828h;

    /* renamed from: i, reason: collision with root package name */
    public final Supplier f17829i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicLong f17830j;

    /* renamed from: k, reason: collision with root package name */
    public final Supplier f17831k;

    /* renamed from: l, reason: collision with root package name */
    public final CallerContextVerifier f17832l;

    /* renamed from: m, reason: collision with root package name */
    public final ImagePipelineConfig f17833m;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ImageRequest.CacheChoice.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        new CancellationException("ImageRequest is null");
        new CancellationException("Modified URL is null");
    }

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set requestListeners, Set requestListener2s, Supplier isPrefetchEnabledSupplier, InstrumentedMemoryCache bitmapMemoryCache, InstrumentedMemoryCache encodedMemoryCache, Supplier diskCachesStoreSupplier, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueueImpl threadHandoffProducerQueue, Supplier suppressBitmapPrefetchingSupplier, Supplier lazyDataSource, CallerContextVerifier callerContextVerifier, ImagePipelineConfig config) {
        Intrinsics.checkNotNullParameter(producerSequenceFactory, "producerSequenceFactory");
        Intrinsics.checkNotNullParameter(requestListeners, "requestListeners");
        Intrinsics.checkNotNullParameter(requestListener2s, "requestListener2s");
        Intrinsics.checkNotNullParameter(isPrefetchEnabledSupplier, "isPrefetchEnabledSupplier");
        Intrinsics.checkNotNullParameter(bitmapMemoryCache, "bitmapMemoryCache");
        Intrinsics.checkNotNullParameter(encodedMemoryCache, "encodedMemoryCache");
        Intrinsics.checkNotNullParameter(diskCachesStoreSupplier, "diskCachesStoreSupplier");
        Intrinsics.checkNotNullParameter(cacheKeyFactory, "cacheKeyFactory");
        Intrinsics.checkNotNullParameter(threadHandoffProducerQueue, "threadHandoffProducerQueue");
        Intrinsics.checkNotNullParameter(suppressBitmapPrefetchingSupplier, "suppressBitmapPrefetchingSupplier");
        Intrinsics.checkNotNullParameter(lazyDataSource, "lazyDataSource");
        Intrinsics.checkNotNullParameter(config, "config");
        this.f17821a = producerSequenceFactory;
        this.f17822b = isPrefetchEnabledSupplier;
        this.f17823c = diskCachesStoreSupplier;
        this.f17824d = new ForwardingRequestListener(requestListeners);
        this.f17825e = new ForwardingRequestListener2(requestListener2s);
        this.f17830j = new AtomicLong();
        this.f17826f = bitmapMemoryCache;
        this.f17827g = encodedMemoryCache;
        this.f17828h = cacheKeyFactory;
        this.f17829i = suppressBitmapPrefetchingSupplier;
        this.f17831k = lazyDataSource;
        this.f17832l = callerContextVerifier;
        this.f17833m = config;
    }

    public final void a() {
        androidx.work.impl.model.a aVar = new androidx.work.impl.model.a(2);
        this.f17826f.c(aVar);
        this.f17827g.c(aVar);
    }

    public final AbstractDataSource b(ImageRequest imageRequest, Object obj, ImageRequest.RequestLevel requestLevel, RequestListener requestListener, String str) {
        if (imageRequest == null) {
            SimpleDataSource simpleDataSourceB = DataSources.b(new NullPointerException());
            Intrinsics.checkNotNullExpressionValue(simpleDataSourceB, "immediateFailedDataSource(...)");
            return simpleDataSourceB;
        }
        try {
            ProducerSequenceFactory producerSequenceFactory = this.f17821a;
            producerSequenceFactory.getClass();
            Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
            FrescoSystrace.a();
            Producer producerC = producerSequenceFactory.c(imageRequest);
            if (imageRequest.f() != null) {
                producerC = producerSequenceFactory.f(producerC);
            }
            Producer producer = producerC;
            if (requestLevel == null) {
                requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
            }
            return f(producer, imageRequest, requestLevel, obj, requestListener, str);
        } catch (Exception e2) {
            return DataSources.b(e2);
        }
    }

    public final boolean d(Uri uri, ImageRequest.CacheChoice cacheChoice) throws NumberFormatException {
        boolean zB;
        ImageRequestBuilder imageRequestBuilderD = ImageRequestBuilder.d(uri);
        imageRequestBuilderD.f(cacheChoice);
        ImageRequest imageRequest = imageRequestBuilderD.a();
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        Object obj = this.f17823c.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        DiskCachesStore diskCachesStore = (DiskCachesStore) obj;
        SimpleCacheKey simpleCacheKeyD = this.f17828h.d(imageRequest, null);
        ImageRequest.CacheChoice cacheChoiceB = imageRequest.b();
        Intrinsics.checkNotNullExpressionValue(cacheChoiceB, "getCacheChoice(...)");
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            int iOrdinal = cacheChoiceB.ordinal();
            if (iOrdinal == 0) {
                zB = diskCachesStore.a().b(simpleCacheKeyD);
            } else if (iOrdinal == 1) {
                zB = diskCachesStore.b().b(simpleCacheKeyD);
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                zB = e(imageRequest);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return zB;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public final boolean e(ImageRequest imageRequest) {
        Object obj = this.f17823c.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        SimpleCacheKey simpleCacheKeyD = this.f17828h.d(imageRequest, null);
        Iterator it = ((DiskCachesStore) obj).c().entrySet().iterator();
        while (it.hasNext()) {
            if (((BufferedDiskCache) ((Map.Entry) it.next()).getValue()).b(simpleCacheKeyD)) {
                return true;
            }
        }
        return false;
    }

    public final AbstractDataSource f(Producer producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, RequestListener requestListener, String str) {
        FrescoSystrace.a();
        if (imageRequest == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ForwardingRequestListener forwardingRequestListener = this.f17824d;
        if (requestListener != null) {
            forwardingRequestListener = new ForwardingRequestListener(forwardingRequestListener, requestListener);
        }
        InternalRequestListener internalRequestListener = new InternalRequestListener(forwardingRequestListener, this.f17825e);
        CallerContextVerifier callerContextVerifier = this.f17832l;
        if (callerContextVerifier != null) {
            callerContextVerifier.a();
        }
        try {
            ImageRequest.RequestLevel requestLevelA = ImageRequest.RequestLevel.a(imageRequest.e(), requestLevel);
            Intrinsics.checkNotNullExpressionValue(requestLevelA, "getMax(...)");
            return CloseableProducerToDataSourceAdapter.p(producer, new SettableProducerContext(imageRequest, String.valueOf(this.f17830j.getAndIncrement()), str, internalRequestListener, obj, requestLevelA, imageRequest.h() || !UriUtil.f(imageRequest.l()), imageRequest.g(), this.f17833m), internalRequestListener);
        } catch (Exception e2) {
            return DataSources.b(e2);
        }
    }

    public final AbstractDataSource g(Producer producer, ImageRequest imageRequest, Object obj) throws NumberFormatException {
        ImageRequest.RequestLevel requestLevel = ImageRequest.RequestLevel.FULL_FETCH;
        Priority.Companion companion = Priority.f17781a;
        InternalRequestListener internalRequestListener = new InternalRequestListener(this.f17824d, this.f17825e);
        CallerContextVerifier callerContextVerifier = this.f17832l;
        if (callerContextVerifier != null) {
            callerContextVerifier.a();
        }
        Uri uriL = imageRequest.l();
        Intrinsics.checkNotNullExpressionValue(uriL, "getSourceUri(...)");
        NopUriModifier.f17491a.a(uriL);
        if (!uriL.equals(uriL)) {
            ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(imageRequest);
            imageRequestBuilderB.l(uriL);
            imageRequest = imageRequestBuilderB.a();
        }
        ImageRequest imageRequest2 = imageRequest;
        try {
            ImageRequest.RequestLevel requestLevelA = ImageRequest.RequestLevel.a(imageRequest2.e(), requestLevel);
            Intrinsics.checkNotNullExpressionValue(requestLevelA, "getMax(...)");
            String strValueOf = String.valueOf(this.f17830j.getAndIncrement());
            this.f17833m.getClass();
            return ProducerToDataSourceAdapter.Companion.a(producer, new SettableProducerContext(imageRequest2, strValueOf, internalRequestListener, obj, requestLevelA, this.f17833m), internalRequestListener);
        } catch (Exception e2) {
            return DataSources.b(e2);
        }
    }
}
