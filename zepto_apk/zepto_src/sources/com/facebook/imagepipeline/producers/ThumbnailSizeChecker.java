package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ThumbnailSizeChecker {
    public static final boolean a(int i2, int i3, ResizeOptions resizeOptions) {
        return resizeOptions == null ? ((float) ((int) (((float) i2) * 1.3333334f))) >= 2048.0f && ((int) (((float) i3) * 1.3333334f)) >= 2048 : ((int) (((float) i2) * 1.3333334f)) >= resizeOptions.f17787a && ((int) (((float) i3) * 1.3333334f)) >= resizeOptions.f17788b;
    }

    public static final boolean b(EncodedImage encodedImage, ResizeOptions resizeOptions) throws IOException {
        if (encodedImage == null) {
            return false;
        }
        encodedImage.Z();
        int i2 = encodedImage.f17958c;
        if (i2 == 90 || i2 == 270) {
            encodedImage.Z();
            int i3 = encodedImage.f17961f;
            encodedImage.Z();
            return a(i3, encodedImage.f17960e, resizeOptions);
        }
        encodedImage.Z();
        int i4 = encodedImage.f17960e;
        encodedImage.Z();
        return a(i4, encodedImage.f17961f, resizeOptions);
    }
}
