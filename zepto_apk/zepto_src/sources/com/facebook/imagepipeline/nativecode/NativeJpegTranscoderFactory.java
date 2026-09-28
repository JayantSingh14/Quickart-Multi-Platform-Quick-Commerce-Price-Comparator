package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.Nullable;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public class NativeJpegTranscoderFactory implements ImageTranscoderFactory {

    /* renamed from: a, reason: collision with root package name */
    public final int f18068a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18069b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f18070c;

    @DoNotStrip
    public NativeJpegTranscoderFactory(int i2, boolean z, boolean z2) {
        this.f18068a = i2;
        this.f18069b = z;
        this.f18070c = z2;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    @DoNotStrip
    @Nullable
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        if (imageFormat != DefaultImageFormats.f17681a) {
            return null;
        }
        NativeJpegTranscoder nativeJpegTranscoder = new NativeJpegTranscoder();
        nativeJpegTranscoder.f18065a = z;
        nativeJpegTranscoder.f18066b = this.f18068a;
        nativeJpegTranscoder.f18067c = this.f18069b;
        if (this.f18070c) {
            NativeJpegTranscoderSoLoader.a();
        }
        return nativeJpegTranscoder;
    }
}
