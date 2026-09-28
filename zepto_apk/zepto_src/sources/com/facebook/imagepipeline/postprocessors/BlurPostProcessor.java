package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;
import in.juspay.hyper.constants.LogCategory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BlurPostProcessor extends BasePostprocessor {

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        return null;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void d(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (!bitmap.isMutable()) {
            throw new IllegalArgumentException();
        }
        if (!(((float) bitmap.getHeight()) <= 2048.0f)) {
            throw new IllegalArgumentException();
        }
        if (!(((float) bitmap.getWidth()) <= 2048.0f)) {
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void e(Bitmap dest, Bitmap src) {
        Intrinsics.checkNotNullParameter(dest, "destBitmap");
        Intrinsics.checkNotNullParameter(src, "sourceBitmap");
        Intrinsics.checkNotNullParameter(dest, "dest");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(null, LogCategory.CONTEXT);
        throw new IllegalArgumentException();
    }
}
