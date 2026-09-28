package com.facebook.imagepipeline.nativecode;

import android.graphics.ColorSpace;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
public class NativeJpegTranscoder implements ImageTranscoder {

    /* renamed from: a, reason: collision with root package name */
    public boolean f18065a;

    /* renamed from: b, reason: collision with root package name */
    public int f18066b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f18067c;

    public static void e(InputStream inputStream, PooledByteBufferOutputStream pooledByteBufferOutputStream, int i2, int i3, int i4) throws IOException {
        NativeJpegTranscoderSoLoader.a();
        if (!(i3 >= 1)) {
            throw new IllegalArgumentException();
        }
        if (!(i3 <= 16)) {
            throw new IllegalArgumentException();
        }
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException();
        }
        if (!(i4 <= 100)) {
            throw new IllegalArgumentException();
        }
        ImmutableList immutableList = JpegTranscoderUtils.f18385a;
        if (!(i2 >= 0 && i2 <= 270 && i2 % 90 == 0)) {
            throw new IllegalArgumentException();
        }
        Preconditions.b((i3 == 8 && i2 == 0) ? false : true, "no transformation requested");
        pooledByteBufferOutputStream.getClass();
        nativeTranscodeJpeg(inputStream, pooledByteBufferOutputStream, i2, i3, i4);
    }

    public static void f(InputStream inputStream, PooledByteBufferOutputStream pooledByteBufferOutputStream, int i2, int i3, int i4) throws IOException {
        boolean z;
        NativeJpegTranscoderSoLoader.a();
        if (!(i3 >= 1)) {
            throw new IllegalArgumentException();
        }
        if (!(i3 <= 16)) {
            throw new IllegalArgumentException();
        }
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException();
        }
        if (!(i4 <= 100)) {
            throw new IllegalArgumentException();
        }
        ImmutableList immutableList = JpegTranscoderUtils.f18385a;
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException();
        }
        Preconditions.b((i3 == 8 && i2 == 1) ? false : true, "no transformation requested");
        pooledByteBufferOutputStream.getClass();
        nativeTranscodeJpegWithExifOrientation(inputStream, pooledByteBufferOutputStream, i2, i3, i4);
    }

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @DoNotStrip
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public final String a() {
        return "NativeJpegTranscoder";
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public final ImageTranscodeResult b(EncodedImage encodedImage, PooledByteBufferOutputStream pooledByteBufferOutputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ColorSpace colorSpace) {
        Integer num = 85;
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.f17789c;
        }
        int iA = DownsampleUtil.a(rotationOptions, resizeOptions, encodedImage, this.f18066b);
        try {
            int iC = JpegTranscoderUtils.c(rotationOptions, resizeOptions, encodedImage, this.f18065a);
            int iMax = Math.max(1, 8 / iA);
            if (this.f18067c) {
                iC = iMax;
            }
            InputStream inputStreamS = encodedImage.s();
            ImmutableList immutableList = JpegTranscoderUtils.f18385a;
            encodedImage.Z();
            if (immutableList.contains(Integer.valueOf(encodedImage.f17959d))) {
                int iA2 = JpegTranscoderUtils.a(rotationOptions, encodedImage);
                Preconditions.d(inputStreamS, "Cannot transcode from null input stream!");
                f(inputStreamS, pooledByteBufferOutputStream, iA2, iC, num.intValue());
            } else {
                int iB = JpegTranscoderUtils.b(rotationOptions, encodedImage);
                Preconditions.d(inputStreamS, "Cannot transcode from null input stream!");
                e(inputStreamS, pooledByteBufferOutputStream, iB, iC, num.intValue());
            }
            Closeables.b(inputStreamS);
            return new ImageTranscodeResult(iA != 1 ? 0 : 1);
        } catch (Throwable th) {
            Closeables.b(null);
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public final boolean c(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.f17789c;
        }
        return JpegTranscoderUtils.c(rotationOptions, resizeOptions, encodedImage, this.f18065a) < 8;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public final boolean d(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.f17681a;
    }
}
