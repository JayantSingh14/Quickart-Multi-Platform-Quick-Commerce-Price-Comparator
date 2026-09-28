package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {

    /* renamed from: a, reason: collision with root package name */
    public static DefaultCacheKeyFactory f17747a;

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public final BitmapMemoryCacheKey a(ImageRequest imageRequest, Object obj) {
        BitmapMemoryCacheKey bitmapMemoryCacheKey = new BitmapMemoryCacheKey(e(imageRequest.l()).toString(), imageRequest.i(), imageRequest.j(), imageRequest.c(), null, null);
        bitmapMemoryCacheKey.d(obj);
        return bitmapMemoryCacheKey;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public final BitmapMemoryCacheKey b(ImageRequest imageRequest, Object obj) {
        CacheKey cacheKey;
        String name;
        Postprocessor postprocessorF = imageRequest.f();
        if (postprocessorF != null) {
            CacheKey cacheKeyA = postprocessorF.a();
            name = postprocessorF.getClass().getName();
            cacheKey = cacheKeyA;
        } else {
            cacheKey = null;
            name = null;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = new BitmapMemoryCacheKey(e(imageRequest.l()).toString(), imageRequest.i(), imageRequest.j(), imageRequest.c(), cacheKey, name);
        bitmapMemoryCacheKey.d(obj);
        return bitmapMemoryCacheKey;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public final SimpleCacheKey c(Uri uri) {
        return new SimpleCacheKey(e(uri).toString());
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public final SimpleCacheKey d(ImageRequest imageRequest, Object obj) {
        return c(imageRequest.l());
    }

    public Uri e(Uri uri) {
        return uri;
    }
}
