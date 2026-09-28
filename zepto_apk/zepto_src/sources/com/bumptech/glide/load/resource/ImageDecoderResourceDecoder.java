package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.graphics.ImageDecoder$OnPartialImageListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.RequiresApi;
import androidx.webkit.internal.b;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;

@RequiresApi
/* loaded from: classes3.dex */
public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {

    /* renamed from: a, reason: collision with root package name */
    public final HardwareConfigState f16237a = HardwareConfigState.a();

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ boolean a(Object obj, Options options) {
        b.s(obj);
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* bridge */ /* synthetic */ Resource b(Object obj, int i2, int i3, Options options) {
        return c(b.h(obj), i2, i3, options);
    }

    public final Resource c(ImageDecoder.Source source, final int i2, final int i3, Options options) {
        final DecodeFormat decodeFormat = (DecodeFormat) options.c(Downsampler.f16275f);
        final DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f16270d);
        Option option = Downsampler.f16278i;
        final boolean z = options.c(option) != null && ((Boolean) options.c(option)).booleanValue();
        final PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.c(Downsampler.f16276g);
        return d(source, i2, i3, new ImageDecoder$OnHeaderDecodedListener() { // from class: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder.1

            /* renamed from: com.bumptech.glide.load.resource.ImageDecoderResourceDecoder$1$1, reason: invalid class name and collision with other inner class name */
            class C00201 implements ImageDecoder$OnPartialImageListener {
                public final boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                    return false;
                }
            }

            public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source2) {
                if (ImageDecoderResourceDecoder.this.f16237a.b(i2, i3, z, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.f15795b) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new C00201());
                Size size = imageInfo.getSize();
                int width = i2;
                if (width == Integer.MIN_VALUE) {
                    width = size.getWidth();
                }
                int height = i3;
                if (height == Integer.MIN_VALUE) {
                    height = size.getHeight();
                }
                float fB = downsampleStrategy.b(size.getWidth(), size.getHeight(), width, height);
                int iRound = Math.round(size.getWidth() * fB);
                int iRound2 = Math.round(size.getHeight() * fB);
                if (Log.isLoggable("ImageDecoder", 2)) {
                    Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
                }
                imageDecoder.setTargetSize(iRound, iRound2);
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 28) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get((preferredColorSpace == PreferredColorSpace.f15819b && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
                } else if (i4 >= 26) {
                    ColorSpace.Named unused = ColorSpace.Named.SRGB;
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            }
        });
    }

    public abstract BitmapResource d(ImageDecoder.Source source, int i2, int i3, ImageDecoder$OnHeaderDecodedListener imageDecoder$OnHeaderDecodedListener);
}
