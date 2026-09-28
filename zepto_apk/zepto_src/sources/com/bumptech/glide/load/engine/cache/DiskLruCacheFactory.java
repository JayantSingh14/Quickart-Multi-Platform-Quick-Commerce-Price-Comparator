package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import java.io.File;

/* loaded from: classes3.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final CacheDirectoryGetter f16092a;

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$1, reason: invalid class name */
    class AnonymousClass1 implements CacheDirectoryGetter {
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$2, reason: invalid class name */
    class AnonymousClass2 implements CacheDirectoryGetter {
    }

    public interface CacheDirectoryGetter {
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter) {
        this.f16092a = cacheDirectoryGetter;
    }

    public final DiskCache a() {
        File cacheDir = ((InternalCacheDiskCacheFactory.AnonymousClass1) this.f16092a).f16098a.getCacheDir();
        File file = cacheDir == null ? null : new File(cacheDir, "image_manager_disk_cache");
        if (file != null && (file.mkdirs() || (file.exists() && file.isDirectory()))) {
            return new DiskLruCacheWrapper(file);
        }
        return null;
    }
}
