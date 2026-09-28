package com.horcrux.svg;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public class CustomFilter {
    public static Bitmap apply(Bitmap bitmap, Bitmap bitmap2, CustomFilterFunction customFilterFunction) {
        int[] iArr;
        int[] iArr2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        float[] fArr2 = {0.0f, 0.0f, 0.0f, 0.0f};
        try {
            bitmap.getPixels(iArr3, 0, width, 0, 0, width, height);
            iArr = iArr3;
            iArr2 = iArr4;
            try {
                bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused) {
            }
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException unused2) {
            iArr = iArr3;
            iArr2 = iArr4;
        }
        for (int i3 = 0; i3 < height; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                int i5 = (i3 * width) + i4;
                int i6 = iArr[i5];
                fArr[0] = ((i6 >> 24) & 255) / 255.0f;
                fArr[1] = ((i6 >> 16) & 255) / 255.0f;
                fArr[2] = ((i6 >> 8) & 255) / 255.0f;
                fArr[3] = (i6 & 255) / 255.0f;
                int i7 = iArr2[i5];
                fArr2[0] = ((i7 >> 24) & 255) / 255.0f;
                fArr2[1] = ((i7 >> 16) & 255) / 255.0f;
                fArr2[2] = ((i7 >> 8) & 255) / 255.0f;
                fArr2[3] = (i7 & 255) / 255.0f;
                iArr5[i5] = normalizeFromFloats(customFilterFunction.a(fArr, fArr2));
            }
        }
        return Bitmap.createBitmap(iArr5, width, height, Bitmap.Config.ARGB_8888);
    }

    public static int normalizeFromFloat(float f2) {
        return Math.min(255, Math.max(0, Math.round(f2 * 255.0f)));
    }

    public static int normalizeFromFloats(float[] fArr) {
        if (fArr.length < 4 || normalizeFromFloat(fArr[0]) <= 0) {
            return 0;
        }
        return normalizeFromFloat(fArr[3] / fArr[0]) | (normalizeFromFloat(fArr[0]) << 24) | (normalizeFromFloat(fArr[1] / fArr[0]) << 16) | (normalizeFromFloat(fArr[2] / fArr[0]) << 8);
    }
}
