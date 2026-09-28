package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface PlatformDecoder {
    CloseableReference a(EncodedImage encodedImage, Bitmap.Config config);

    CloseableReference b(EncodedImage encodedImage, Bitmap.Config config, int i2, ColorSpace colorSpace);
}
