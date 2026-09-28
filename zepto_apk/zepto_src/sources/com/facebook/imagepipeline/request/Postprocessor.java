package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public interface Postprocessor {
    CacheKey a();

    CloseableReference c(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory);

    String getName();
}
