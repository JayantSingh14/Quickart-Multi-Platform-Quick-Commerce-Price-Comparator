package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.nativecode.NativeImageTranscoderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class MultiImageTranscoderFactory implements ImageTranscoderFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ImageTranscoderFactory f18386a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f18387b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18388c;

    public MultiImageTranscoderFactory(ImageTranscoderFactory imageTranscoderFactory, Integer num, boolean z) {
        this.f18386a = imageTranscoderFactory;
        this.f18387b = num;
        this.f18388c = z;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public final ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        ImageTranscoder imageTranscoderCreateImageTranscoder = null;
        ImageTranscoderFactory imageTranscoderFactory = this.f18386a;
        ImageTranscoder imageTranscoderCreateImageTranscoder2 = imageTranscoderFactory != null ? imageTranscoderFactory.createImageTranscoder(imageFormat, z) : null;
        boolean z2 = this.f18388c;
        if (imageTranscoderCreateImageTranscoder2 == null) {
            Integer num = this.f18387b;
            if (num != null) {
                if (num.intValue() == 0) {
                    imageTranscoderCreateImageTranscoder = NativeImageTranscoderFactory.a(z2).createImageTranscoder(imageFormat, z);
                } else {
                    if (num.intValue() != 1) {
                        throw new IllegalArgumentException("Invalid ImageTranscoderType");
                    }
                    ImageTranscoder imageTranscoderCreateImageTranscoder3 = new SimpleImageTranscoderFactory().createImageTranscoder(imageFormat, z);
                    Intrinsics.checkNotNullExpressionValue(imageTranscoderCreateImageTranscoder3, "createImageTranscoder(...)");
                    imageTranscoderCreateImageTranscoder = (SimpleImageTranscoder) imageTranscoderCreateImageTranscoder3;
                }
            }
            imageTranscoderCreateImageTranscoder2 = imageTranscoderCreateImageTranscoder;
        }
        if (imageTranscoderCreateImageTranscoder2 == null) {
            imageTranscoderCreateImageTranscoder2 = NativeImageTranscoderFactory.a(z2).createImageTranscoder(imageFormat, z);
        }
        if (imageTranscoderCreateImageTranscoder2 != null) {
            return imageTranscoderCreateImageTranscoder2;
        }
        ImageTranscoder imageTranscoderCreateImageTranscoder4 = new SimpleImageTranscoderFactory().createImageTranscoder(imageFormat, z);
        Intrinsics.checkNotNullExpressionValue(imageTranscoderCreateImageTranscoder4, "createImageTranscoder(...)");
        return (SimpleImageTranscoder) imageTranscoderCreateImageTranscoder4;
    }
}
