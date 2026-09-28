package com.facebook.imagepipeline.transcoder;

import android.graphics.ColorSpace;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface ImageTranscoder {
    String a();

    ImageTranscodeResult b(EncodedImage encodedImage, PooledByteBufferOutputStream pooledByteBufferOutputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ColorSpace colorSpace);

    boolean c(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions);

    boolean d(ImageFormat imageFormat);
}
