package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ImageTranscoderFactory {
    ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z);
}
