package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.support.v4.media.b;
import com.facebook.common.internal.Objects;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.api.Api;
import javax.annotation.concurrent.Immutable;

@Nullsafe
@Immutable
/* loaded from: classes3.dex */
public class ImageDecodeOptions {

    /* renamed from: c, reason: collision with root package name */
    public static final ImageDecodeOptions f17776c = new ImageDecodeOptions(new ImageDecodeOptionsBuilder());

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap.Config f17777a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f17778b;

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.f17777a = imageDecodeOptionsBuilder.f17779a;
        this.f17778b = imageDecodeOptionsBuilder.f17780b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
        return this.f17777a == imageDecodeOptions.f17777a && this.f17778b == imageDecodeOptions.f17778b;
    }

    public final int hashCode() {
        int iOrdinal = (this.f17777a.ordinal() - 552645669) * 31;
        Bitmap.Config config = this.f17778b;
        return (iOrdinal + (config != null ? config.ordinal() : 0)) * 29791;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ImageDecodeOptions{");
        Objects.ToStringHelper toStringHelperB = Objects.b(this);
        toStringHelperB.c(String.valueOf(100), "minDecodeIntervalMs");
        toStringHelperB.c(String.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER), "maxDimensionPx");
        toStringHelperB.b("decodePreviewFrame", false);
        toStringHelperB.b("useLastFrameForPreview", false);
        toStringHelperB.b("useEncodedImageForPreview", false);
        toStringHelperB.b("decodeAllFrames", false);
        toStringHelperB.b("forceStaticImage", false);
        toStringHelperB.c(this.f17777a.name(), "bitmapConfigName");
        toStringHelperB.c(this.f17778b.name(), "animatedBitmapConfigName");
        toStringHelperB.c(null, "customImageDecoder");
        toStringHelperB.c(null, "bitmapTransformation");
        toStringHelperB.c(null, "colorSpace");
        return b.r(sb, toStringHelperB.toString(), "}");
    }
}
