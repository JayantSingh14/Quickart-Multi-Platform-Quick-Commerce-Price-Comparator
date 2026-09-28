package com.facebook.imagepipeline.decoder;

import android.graphics.ColorSpace;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.BaseCloseableImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.xml.XmlFormatDecoder;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe
/* loaded from: classes.dex */
public class DefaultImageDecoder implements ImageDecoder {

    /* renamed from: a, reason: collision with root package name */
    public final ImageDecoder f17929a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageDecoder f17930b;

    /* renamed from: c, reason: collision with root package name */
    public final XmlFormatDecoder f17931c;

    /* renamed from: d, reason: collision with root package name */
    public final PlatformDecoder f17932d;

    /* renamed from: e, reason: collision with root package name */
    public final Supplier f17933e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageDecoder f17934f;

    /* renamed from: com.facebook.imagepipeline.decoder.DefaultImageDecoder$1, reason: invalid class name */
    public class AnonymousClass1 implements ImageDecoder {
        public AnonymousClass1() {
        }

        @Override // com.facebook.imagepipeline.decoder.ImageDecoder
        public final CloseableImage a(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) throws IOException {
            ColorSpace colorSpaceE;
            ImageFormat imageFormatR = encodedImage.r();
            DefaultImageDecoder defaultImageDecoder = DefaultImageDecoder.this;
            defaultImageDecoder.getClass();
            if (((Boolean) Suppliers.f17085b.get()).booleanValue()) {
                imageDecodeOptions.getClass();
                colorSpaceE = encodedImage.e();
            } else {
                imageDecodeOptions.getClass();
                colorSpaceE = null;
            }
            if (imageFormatR == DefaultImageFormats.f17681a) {
                CloseableReference closeableReferenceB = defaultImageDecoder.f17932d.b(encodedImage, imageDecodeOptions.f17777a, i2, colorSpaceE);
                try {
                    closeableReferenceB.getClass();
                    CloseableImage closeableImageQ = CloseableStaticBitmap.Q(closeableReferenceB, qualityInfo, encodedImage.X0(), encodedImage.H0());
                    ((BaseCloseableImage) closeableImageQ).V(Boolean.FALSE, "is_rounded");
                    return closeableImageQ;
                } finally {
                    CloseableReference.e(closeableReferenceB);
                }
            }
            if (imageFormatR == DefaultImageFormats.f17683c) {
                if (encodedImage.getWidth() == -1 || encodedImage.getHeight() == -1) {
                    throw new DecodeException("image width or height is incorrect", encodedImage);
                }
                imageDecodeOptions.getClass();
                ImageDecoder imageDecoder = defaultImageDecoder.f17929a;
                return imageDecoder != null ? imageDecoder.a(encodedImage, i2, qualityInfo, imageDecodeOptions) : defaultImageDecoder.b(encodedImage, imageDecodeOptions);
            }
            if (imageFormatR == DefaultImageFormats.f17690j) {
                imageDecodeOptions.getClass();
                ImageDecoder imageDecoder2 = defaultImageDecoder.f17930b;
                return imageDecoder2 != null ? imageDecoder2.a(encodedImage, i2, qualityInfo, imageDecodeOptions) : defaultImageDecoder.b(encodedImage, imageDecodeOptions);
            }
            if (imageFormatR != DefaultImageFormats.f17693m) {
                if (imageFormatR != ImageFormat.f17694c) {
                    return defaultImageDecoder.b(encodedImage, imageDecodeOptions);
                }
                throw new DecodeException("unknown image format", encodedImage);
            }
            XmlFormatDecoder xmlFormatDecoder = defaultImageDecoder.f17931c;
            if (xmlFormatDecoder != null) {
                return xmlFormatDecoder.a(encodedImage, i2, qualityInfo, imageDecodeOptions);
            }
            return null;
        }
    }

    public DefaultImageDecoder(ImageDecoder imageDecoder, ImageDecoder imageDecoder2, XmlFormatDecoder xmlFormatDecoder, PlatformDecoder platformDecoder) {
        Supplier supplier = Suppliers.f17085b;
        this.f17934f = new AnonymousClass1();
        this.f17929a = imageDecoder;
        this.f17930b = imageDecoder2;
        this.f17931c = xmlFormatDecoder;
        this.f17932d = platformDecoder;
        this.f17933e = supplier;
    }

    @Override // com.facebook.imagepipeline.decoder.ImageDecoder
    public final CloseableImage a(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) throws IOException {
        InputStream inputStreamS;
        imageDecodeOptions.getClass();
        ImageFormat imageFormatR = encodedImage.r();
        if ((imageFormatR == null || imageFormatR == ImageFormat.f17694c) && (inputStreamS = encodedImage.s()) != null) {
            encodedImage.j0(ImageFormatChecker.a(inputStreamS));
        }
        return ((AnonymousClass1) this.f17934f).a(encodedImage, i2, qualityInfo, imageDecodeOptions);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CloseableStaticBitmap b(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        CloseableReference closeableReferenceA = this.f17932d.a(encodedImage, imageDecodeOptions.f17777a);
        try {
            closeableReferenceA.getClass();
            CloseableStaticBitmap closeableStaticBitmapQ = CloseableStaticBitmap.Q(closeableReferenceA, ImmutableQualityInfo.f17971d, encodedImage.X0(), encodedImage.H0());
            ((BaseCloseableImage) closeableStaticBitmapQ).V(Boolean.FALSE, "is_rounded");
            return closeableStaticBitmapQ;
        } finally {
            CloseableReference.e(closeableReferenceA);
        }
    }
}
