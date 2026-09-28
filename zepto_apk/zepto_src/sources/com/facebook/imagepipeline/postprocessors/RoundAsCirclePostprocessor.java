package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class RoundAsCirclePostprocessor extends BasePostprocessor {

    /* renamed from: c, reason: collision with root package name */
    public SimpleCacheKey f18083c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18084d = true;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        if (this.f18083c == null) {
            if (this.f18084d) {
                this.f18083c = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.f18083c = new SimpleCacheKey("RoundAsCirclePostprocessor");
            }
        }
        return this.f18083c;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void d(Bitmap bitmap) {
        NativeRoundingFilter.toCircleFast(bitmap, this.f18084d);
    }
}
