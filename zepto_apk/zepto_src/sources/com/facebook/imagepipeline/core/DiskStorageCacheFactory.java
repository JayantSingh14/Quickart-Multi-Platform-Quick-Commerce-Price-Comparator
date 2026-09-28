package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Nullsafe
/* loaded from: classes.dex */
public class DiskStorageCacheFactory implements FileCacheFactory {

    /* renamed from: a, reason: collision with root package name */
    public DynamicDefaultDiskStorageFactory f17815a;

    public final DiskStorageCache a(DiskCacheConfig diskCacheConfig) {
        this.f17815a.getClass();
        DynamicDefaultDiskStorage dynamicDefaultDiskStorage = new DynamicDefaultDiskStorage(diskCacheConfig.f17014a, diskCacheConfig.f17016c, diskCacheConfig.f17015b, diskCacheConfig.f17021h);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        return new DiskStorageCache(dynamicDefaultDiskStorage, diskCacheConfig.f17020g, new DiskStorageCache.Params(diskCacheConfig.f17019f, diskCacheConfig.f17018e, diskCacheConfig.f17017d), diskCacheConfig.f17022i, diskCacheConfig.f17021h, diskCacheConfig.f17023j, executorServiceNewSingleThreadExecutor);
    }
}
