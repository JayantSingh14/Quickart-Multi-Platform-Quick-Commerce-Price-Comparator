package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.CountingLruBitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.cache.DefaultEncodedMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.debug.NoOpCloseableReferenceLeakTracker;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoderOptions;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.zeptoconsumerapp.customisations.CustomBitmapMemoryCacheParamsSupplier;
import com.zeptoconsumerapp.modules.image.FrescoCacheKeyFactory;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ImagePipelineConfig implements ImagePipelineConfigInterface {
    public static final DefaultImageRequestConfig A = new DefaultImageRequestConfig();

    /* renamed from: a, reason: collision with root package name */
    public final Supplier f17834a;

    /* renamed from: b, reason: collision with root package name */
    public final BitmapMemoryCacheTrimStrategy f17835b;

    /* renamed from: c, reason: collision with root package name */
    public final NativeMemoryCacheTrimStrategy f17836c;

    /* renamed from: d, reason: collision with root package name */
    public final CacheKeyFactory f17837d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f17838e;

    /* renamed from: f, reason: collision with root package name */
    public final DownsampleMode f17839f;

    /* renamed from: g, reason: collision with root package name */
    public final DiskCachesStoreFactory f17840g;

    /* renamed from: h, reason: collision with root package name */
    public final DefaultEncodedMemoryCacheParamsSupplier f17841h;

    /* renamed from: i, reason: collision with root package name */
    public final DefaultExecutorSupplier f17842i;

    /* renamed from: j, reason: collision with root package name */
    public final NoOpImageCacheStatsTracker f17843j;

    /* renamed from: k, reason: collision with root package name */
    public final Supplier f17844k;

    /* renamed from: l, reason: collision with root package name */
    public final Supplier f17845l;

    /* renamed from: m, reason: collision with root package name */
    public final DiskCacheConfig f17846m;
    public final NoOpMemoryTrimmableRegistry n;
    public final NetworkFetcher o;
    public final PoolFactory p;
    public final SimpleProgressiveJpegConfig q;
    public final Set r;
    public final EmptySet s;
    public final EmptySet t;
    public final boolean u;
    public final DiskCacheConfig v;
    public final ImagePipelineExperiments w;
    public final boolean x;
    public final NoOpCloseableReferenceLeakTracker y;
    public final CountingLruBitmapMemoryCacheFactory z;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public CustomBitmapMemoryCacheParamsSupplier f17847a;

        /* renamed from: b, reason: collision with root package name */
        public FrescoCacheKeyFactory f17848b;

        /* renamed from: c, reason: collision with root package name */
        public final Context f17849c;

        /* renamed from: d, reason: collision with root package name */
        public DownsampleMode f17850d;

        /* renamed from: e, reason: collision with root package name */
        public DiskCacheConfig f17851e;

        /* renamed from: f, reason: collision with root package name */
        public OkHttpNetworkFetcher f17852f;

        /* renamed from: g, reason: collision with root package name */
        public HashSet f17853g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f17854h;

        /* renamed from: i, reason: collision with root package name */
        public final int f17855i;

        /* renamed from: j, reason: collision with root package name */
        public final ImagePipelineExperiments.Builder f17856j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f17857k;

        /* renamed from: l, reason: collision with root package name */
        public final NoOpCloseableReferenceLeakTracker f17858l;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f17850d = DownsampleMode.f17817b;
            this.f17854h = true;
            this.f17855i = -1;
            Intrinsics.checkNotNullParameter(this, "configBuilder");
            ImagePipelineExperiments.Builder builder = new ImagePipelineExperiments.Builder();
            Supplier supplierA = Suppliers.a();
            Intrinsics.checkNotNullExpressionValue(supplierA, "of(...)");
            builder.f17868a = supplierA;
            builder.f17869b = true;
            builder.f17870c = true;
            builder.f17871d = 20;
            builder.f17872e = 30;
            builder.f17873f = new PlatformDecoderOptions();
            this.f17856j = builder;
            this.f17857k = true;
            this.f17858l = new NoOpCloseableReferenceLeakTracker();
            this.f17849c = context;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    @Metadata
    public static final class DefaultImageRequestConfig {
    }

    public ImagePipelineConfig(Builder builder) {
        NoOpImageCacheStatsTracker noOpImageCacheStatsTracker;
        FrescoSystrace.a();
        ImagePipelineExperiments.Builder builder2 = builder.f17856j;
        builder2.getClass();
        this.w = new ImagePipelineExperiments(builder2);
        Supplier defaultBitmapMemoryCacheParamsSupplier = builder.f17847a;
        if (defaultBitmapMemoryCacheParamsSupplier == null) {
            Object systemService = builder.f17849c.getSystemService("activity");
            if (systemService == null) {
                throw new IllegalStateException("Required value was null.");
            }
            defaultBitmapMemoryCacheParamsSupplier = new DefaultBitmapMemoryCacheParamsSupplier((ActivityManager) systemService);
        }
        this.f17834a = defaultBitmapMemoryCacheParamsSupplier;
        this.f17835b = new BitmapMemoryCacheTrimStrategy();
        this.f17836c = new NativeMemoryCacheTrimStrategy();
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        CacheKeyFactory cacheKeyFactory = builder.f17848b;
        if (cacheKeyFactory == null) {
            synchronized (DefaultCacheKeyFactory.class) {
                try {
                    if (DefaultCacheKeyFactory.f17747a == null) {
                        DefaultCacheKeyFactory.f17747a = new DefaultCacheKeyFactory();
                    }
                    cacheKeyFactory = DefaultCacheKeyFactory.f17747a;
                } finally {
                }
            }
            Intrinsics.checkNotNullExpressionValue(cacheKeyFactory, "getInstance(...)");
        }
        this.f17837d = cacheKeyFactory;
        Context context = builder.f17849c;
        if (context == null) {
            throw new IllegalStateException("Required value was null.");
        }
        this.f17838e = context;
        this.f17839f = builder.f17850d;
        this.f17841h = new DefaultEncodedMemoryCacheParamsSupplier();
        synchronized (NoOpImageCacheStatsTracker.class) {
            try {
                if (NoOpImageCacheStatsTracker.f17771a == null) {
                    NoOpImageCacheStatsTracker.f17771a = new NoOpImageCacheStatsTracker();
                }
                noOpImageCacheStatsTracker = NoOpImageCacheStatsTracker.f17771a;
            } finally {
            }
        }
        Intrinsics.checkNotNullExpressionValue(noOpImageCacheStatsTracker, "getInstance(...)");
        this.f17843j = noOpImageCacheStatsTracker;
        Supplier BOOLEAN_FALSE = Suppliers.f17085b;
        Intrinsics.checkNotNullExpressionValue(BOOLEAN_FALSE, "BOOLEAN_FALSE");
        this.f17844k = BOOLEAN_FALSE;
        Supplier BOOLEAN_TRUE = Suppliers.f17084a;
        Intrinsics.checkNotNullExpressionValue(BOOLEAN_TRUE, "BOOLEAN_TRUE");
        this.f17845l = BOOLEAN_TRUE;
        DiskCacheConfig diskCacheConfig = builder.f17851e;
        if (diskCacheConfig == null) {
            Context context2 = builder.f17849c;
            FrescoSystrace.a();
            diskCacheConfig = new DiskCacheConfig(new DiskCacheConfig.Builder(context2));
            Intrinsics.checkNotNullExpressionValue(diskCacheConfig, "traceSection(...)");
        }
        this.f17846m = diskCacheConfig;
        NoOpMemoryTrimmableRegistry noOpMemoryTrimmableRegistryA = NoOpMemoryTrimmableRegistry.a();
        Intrinsics.checkNotNullExpressionValue(noOpMemoryTrimmableRegistryA, "getInstance(...)");
        this.n = noOpMemoryTrimmableRegistryA;
        int i2 = builder.f17855i;
        i2 = i2 < 0 ? 30000 : i2;
        FrescoSystrace.a();
        NetworkFetcher networkFetcher = builder.f17852f;
        this.o = networkFetcher == null ? new HttpUrlConnectionNetworkFetcher(i2) : networkFetcher;
        PoolConfig poolConfig = new PoolConfig(new PoolConfig.Builder());
        this.p = new PoolFactory(poolConfig);
        this.q = new SimpleProgressiveJpegConfig();
        Set set = builder.f17853g;
        this.r = set == null ? EmptySet.f53611a : set;
        EmptySet emptySet = EmptySet.f53611a;
        this.s = emptySet;
        this.t = emptySet;
        this.u = builder.f17854h;
        this.v = diskCacheConfig;
        this.f17842i = new DefaultExecutorSupplier(poolConfig.f18041c.f18060d);
        this.x = builder.f17857k;
        this.y = builder.f17858l;
        this.z = new CountingLruBitmapMemoryCacheFactory();
        DynamicDefaultDiskStorageFactory dynamicDefaultDiskStorageFactory = new DynamicDefaultDiskStorageFactory();
        DiskStorageCacheFactory diskStorageCacheFactory = new DiskStorageCacheFactory();
        diskStorageCacheFactory.f17815a = dynamicDefaultDiskStorageFactory;
        this.f17840g = new DiskCachesStoreFactory(diskStorageCacheFactory, this);
        FrescoSystrace.a();
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public final SimpleProgressiveJpegConfig a() {
        return this.q;
    }

    @Override // com.facebook.imagepipeline.core.ImagePipelineConfigInterface
    public final ImagePipelineExperiments b() {
        return this.w;
    }
}
