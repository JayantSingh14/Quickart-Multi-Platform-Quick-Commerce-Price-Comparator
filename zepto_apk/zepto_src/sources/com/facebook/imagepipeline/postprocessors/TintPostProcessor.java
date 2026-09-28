package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata
/* loaded from: classes3.dex */
public final class TintPostProcessor extends BasePostprocessor {
    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        return null;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void d(Bitmap sourceBitmap) {
        Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
        new Canvas(sourceBitmap).drawColor(0);
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final String getName() {
        return Reflection.a(TintPostProcessor.class).toString();
    }
}
