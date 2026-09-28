package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DiskCacheDecision {

    @Metadata
    public static final class DiskCacheDecisionNoDiskCacheChosenException extends Exception {
    }

    public static final BufferedDiskCache a(ImageRequest imageRequest, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, ImmutableMap immutableMap) {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        ImageRequest.CacheChoice cacheChoice = imageRequest.f18347a;
        if (cacheChoice == ImageRequest.CacheChoice.f18360a) {
            return bufferedDiskCache;
        }
        if (cacheChoice == ImageRequest.CacheChoice.f18361b) {
            return bufferedDiskCache2;
        }
        return null;
    }
}
