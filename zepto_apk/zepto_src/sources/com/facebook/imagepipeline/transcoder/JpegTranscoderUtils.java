package com.facebook.imagepipeline.transcoder;

import com.facebook.common.internal.ImmutableList;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class JpegTranscoderUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ImmutableList f18385a;

    static {
        ImmutableList immutableList = new ImmutableList(4);
        Collections.addAll(immutableList, 2, 7, 4, 5);
        Intrinsics.checkNotNullExpressionValue(immutableList, "of(...)");
        f18385a = immutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int a(RotationOptions rotationOptions, EncodedImage encodedImage) throws IOException {
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        encodedImage.Z();
        int i2 = encodedImage.f17959d;
        ImmutableList immutableList = f18385a;
        int iIndexOf = immutableList.indexOf(Integer.valueOf(i2));
        if (iIndexOf < 0) {
            throw new IllegalArgumentException("Only accepts inverted exif orientations");
        }
        int i3 = rotationOptions.f17791a;
        if (i3 == -1) {
            i3 = 0;
        } else if (i3 == -1) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        E e2 = immutableList.get(((i3 / 90) + iIndexOf) % immutableList.size());
        Intrinsics.checkNotNullExpressionValue(e2, "get(...)");
        return ((Number) e2).intValue();
    }

    public static final int b(RotationOptions rotationOptions, EncodedImage encodedImage) throws IOException {
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        int i2 = 0;
        if (!(rotationOptions.f17791a != -2)) {
            return 0;
        }
        encodedImage.Z();
        int i3 = encodedImage.f17958c;
        if (i3 == 90 || i3 == 180 || i3 == 270) {
            encodedImage.Z();
            i2 = encodedImage.f17958c;
        }
        int i4 = rotationOptions.f17791a;
        if (i4 == -1) {
            return i2;
        }
        if (i4 != -1) {
            return (i4 + i2) % 360;
        }
        throw new IllegalStateException("Rotation is set to use EXIF");
    }

    public static final int c(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z) throws IOException {
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(rotationOptions, "rotationOptions");
        Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
        if (z && resizeOptions != null) {
            int iB = b(rotationOptions, encodedImage);
            ImmutableList immutableList = f18385a;
            encodedImage.Z();
            int iA = immutableList.contains(Integer.valueOf(encodedImage.f17959d)) ? a(rotationOptions, encodedImage) : 0;
            boolean z2 = iB == 90 || iB == 270 || iA == 5 || iA == 7;
            if (z2) {
                encodedImage.Z();
                i2 = encodedImage.f17961f;
            } else {
                encodedImage.Z();
                i2 = encodedImage.f17960e;
            }
            if (z2) {
                encodedImage.Z();
                i3 = encodedImage.f17960e;
            } else {
                encodedImage.Z();
                i3 = encodedImage.f17961f;
            }
            float f2 = i2;
            float f3 = i3;
            float fMax = Math.max(resizeOptions.f17787a / f2, resizeOptions.f17788b / f3);
            if (f2 * fMax > 2048.0f) {
                fMax = 2048.0f / f2;
            }
            if (f3 * fMax > 2048.0f) {
                fMax = 2048.0f / f3;
            }
            int i4 = (int) ((fMax * 8) + 0.6666667f);
            if (i4 <= 8) {
                if (i4 < 1) {
                    return 1;
                }
                return i4;
            }
        }
        return 8;
    }
}
