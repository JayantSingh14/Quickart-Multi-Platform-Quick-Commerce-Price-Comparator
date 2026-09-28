package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

/* loaded from: classes.dex */
public interface CacheKeyFactory {
    BitmapMemoryCacheKey a(ImageRequest imageRequest, Object obj);

    BitmapMemoryCacheKey b(ImageRequest imageRequest, Object obj);

    SimpleCacheKey c(Uri uri);

    SimpleCacheKey d(ImageRequest imageRequest, Object obj);
}
