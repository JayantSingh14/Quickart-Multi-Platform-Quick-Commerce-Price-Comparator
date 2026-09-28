package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.NoOpImageCacheStatsTracker;
import com.facebook.imagepipeline.memory.PoolFactory;
import java.util.Map;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class DiskCachesStoreFactory implements Supplier<DiskCachesStore> {

    /* renamed from: a, reason: collision with root package name */
    public final DiskStorageCacheFactory f17800a;

    /* renamed from: b, reason: collision with root package name */
    public final PoolFactory f17801b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutorSupplier f17802c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageCacheStatsTracker f17803d;

    /* renamed from: e, reason: collision with root package name */
    public final int f17804e;

    /* renamed from: f, reason: collision with root package name */
    public final DiskCacheConfig f17805f;

    /* renamed from: g, reason: collision with root package name */
    public final DiskCacheConfig f17806g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f17807h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f17808i;

    public DiskCachesStoreFactory(DiskStorageCacheFactory fileCacheFactory, ImagePipelineConfig config) {
        Intrinsics.checkNotNullParameter(fileCacheFactory, "fileCacheFactory");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(fileCacheFactory, "fileCacheFactory");
        PoolFactory poolFactory = config.p;
        Intrinsics.checkNotNullParameter(poolFactory, "poolFactory");
        DefaultExecutorSupplier executorSupplier = config.f17842i;
        Intrinsics.checkNotNullParameter(executorSupplier, "executorSupplier");
        NoOpImageCacheStatsTracker imageCacheStatsTracker = config.f17843j;
        Intrinsics.checkNotNullParameter(imageCacheStatsTracker, "imageCacheStatsTracker");
        DiskCacheConfig mainDiskCacheConfig = config.f17846m;
        Intrinsics.checkNotNullParameter(mainDiskCacheConfig, "mainDiskCacheConfig");
        DiskCacheConfig smallImageDiskCacheConfig = config.v;
        Intrinsics.checkNotNullParameter(smallImageDiskCacheConfig, "smallImageDiskCacheConfig");
        this.f17800a = fileCacheFactory;
        this.f17801b = poolFactory;
        this.f17802c = executorSupplier;
        this.f17803d = imageCacheStatsTracker;
        this.f17804e = 0;
        this.f17805f = mainDiskCacheConfig;
        this.f17806g = smallImageDiskCacheConfig;
        this.f17807h = null;
        this.f17808i = LazyKt.a(LazyThreadSafetyMode.f53528a, new defpackage.b(this, 6));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // com.facebook.common.internal.Supplier
    public final Object get() {
        return (DiskCachesStore) this.f17808i.getValue();
    }
}
