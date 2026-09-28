package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class GradientColor {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f14507a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f14508b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f14507a = fArr;
        this.f14508b = iArr;
    }

    public final void a(GradientColor gradientColor) {
        int i2 = 0;
        while (true) {
            int[] iArr = gradientColor.f14508b;
            if (i2 >= iArr.length) {
                return;
            }
            this.f14507a[i2] = gradientColor.f14507a[i2];
            this.f14508b[i2] = iArr[i2];
            i2++;
        }
    }

    public final GradientColor b(float[] fArr) {
        int iC;
        int[] iArr = new int[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            float f2 = fArr[i2];
            float[] fArr2 = this.f14507a;
            int iBinarySearch = Arrays.binarySearch(fArr2, f2);
            int[] iArr2 = this.f14508b;
            if (iBinarySearch >= 0) {
                iC = iArr2[iBinarySearch];
            } else {
                int i3 = -(iBinarySearch + 1);
                if (i3 == 0) {
                    iC = iArr2[0];
                } else if (i3 == iArr2.length - 1) {
                    iC = iArr2[iArr2.length - 1];
                } else {
                    int i4 = i3 - 1;
                    float f3 = fArr2[i4];
                    iC = GammaEvaluator.c((f2 - f3) / (fArr2[i3] - f3), iArr2[i4], iArr2[i3]);
                }
            }
            iArr[i2] = iC;
        }
        return new GradientColor(fArr, iArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GradientColor gradientColor = (GradientColor) obj;
            if (Arrays.equals(this.f14507a, gradientColor.f14507a) && Arrays.equals(this.f14508b, gradientColor.f14508b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f14508b) + (Arrays.hashCode(this.f14507a) * 31);
    }
}
