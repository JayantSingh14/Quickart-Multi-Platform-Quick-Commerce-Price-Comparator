package com.facebook.react.modules.fresco;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ReactNetworkImageRequest extends ImageRequest {
    public final ReadableMap s;
    public final ImageCacheControl t;

    @Metadata
    public static final class Companion {
        public static ReactNetworkImageRequest a(ImageRequestBuilder builder, ReadableMap readableMap, ImageCacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            return new ReactNetworkImageRequest(builder, readableMap, cacheControl);
        }
    }

    public ReactNetworkImageRequest(ImageRequestBuilder imageRequestBuilder, ReadableMap readableMap, ImageCacheControl imageCacheControl) {
        super(imageRequestBuilder);
        this.s = readableMap;
        this.t = imageCacheControl;
    }
}
