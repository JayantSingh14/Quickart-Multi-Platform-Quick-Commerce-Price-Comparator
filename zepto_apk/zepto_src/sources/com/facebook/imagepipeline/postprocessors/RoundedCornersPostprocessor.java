package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class RoundedCornersPostprocessor extends BasePostprocessor {

    /* renamed from: c, reason: collision with root package name */
    public SimpleCacheKey f18087c;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        if (this.f18087c == null) {
            this.f18087c = new SimpleCacheKey("RoundedCornersPostprocessor");
        }
        return this.f18087c;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void d(Bitmap bitmap) {
        int iMin = Math.min(bitmap.getHeight(), bitmap.getWidth());
        NativeRoundingFilter.a(bitmap, iMin / 2, iMin / 3, iMin / 4, iMin / 5);
    }
}
