package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class SimpleImageTranscoder implements ImageTranscoder {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f18389a;

    @Metadata
    public static final class Companion {
    }

    public SimpleImageTranscoder(boolean z) {
        this.f18389a = z;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public final String a() {
        return "SimpleImageTranscoder";
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.facebook.imagepipeline.transcoder.ImageTranscodeResult b(com.facebook.imagepipeline.image.EncodedImage r22, com.facebook.common.memory.PooledByteBufferOutputStream r23, com.facebook.imagepipeline.common.RotationOptions r24, com.facebook.imagepipeline.common.ResizeOptions r25, android.graphics.ColorSpace r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.transcoder.SimpleImageTranscoder.b(com.facebook.imagepipeline.image.EncodedImage, com.facebook.common.memory.PooledByteBufferOutputStream, com.facebook.imagepipeline.common.RotationOptions, com.facebook.imagepipeline.common.ResizeOptions, android.graphics.ColorSpace):com.facebook.imagepipeline.transcoder.ImageTranscodeResult");
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public final boolean c(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.f17789c;
        }
        return this.f18389a && DownsampleUtil.a(rotationOptions, resizeOptions, encodedImage, 2048) > 1;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public final boolean d(ImageFormat imageFormat) {
        Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        return imageFormat == DefaultImageFormats.f17691k || imageFormat == DefaultImageFormats.f17681a;
    }
}
