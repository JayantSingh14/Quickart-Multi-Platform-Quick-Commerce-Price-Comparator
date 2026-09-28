package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class SimpleImageTranscoderFactory implements ImageTranscoderFactory {
    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public final ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        return new SimpleImageTranscoder(z);
    }
}
