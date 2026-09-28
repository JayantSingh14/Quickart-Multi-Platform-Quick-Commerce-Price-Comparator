package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class IterativeBoxBlurPostProcessor extends BasePostprocessor {

    /* renamed from: c, reason: collision with root package name */
    public final int f18080c;

    /* renamed from: d, reason: collision with root package name */
    public final int f18081d;

    /* renamed from: e, reason: collision with root package name */
    public SimpleCacheKey f18082e;

    public IterativeBoxBlurPostProcessor(int i2) {
        if (!(i2 > 0)) {
            throw new IllegalArgumentException();
        }
        this.f18080c = 2;
        this.f18081d = i2;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor, com.facebook.imagepipeline.request.Postprocessor
    public final CacheKey a() {
        if (this.f18082e == null) {
            this.f18082e = new SimpleCacheKey("i" + this.f18080c + "r" + this.f18081d);
        }
        return this.f18082e;
    }

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void d(Bitmap bitmap) {
        NativeBlurFilter.a(bitmap, this.f18080c, this.f18081d);
    }
}
