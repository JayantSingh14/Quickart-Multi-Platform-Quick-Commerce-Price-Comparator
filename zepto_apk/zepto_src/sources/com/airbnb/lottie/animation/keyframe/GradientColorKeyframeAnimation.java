package com.airbnb.lottie.animation.keyframe;

import android.support.v4.media.b;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes3.dex */
public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {

    /* renamed from: i, reason: collision with root package name */
    public final GradientColor f14356i;

    public GradientColorKeyframeAnimation(List list) {
        super(list);
        int iMax = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            GradientColor gradientColor = (GradientColor) ((Keyframe) list.get(i2)).f14816b;
            if (gradientColor != null) {
                iMax = Math.max(iMax, gradientColor.f14508b.length);
            }
        }
        this.f14356i = new GradientColor(new float[iMax], new int[iMax]);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        int[] iArr;
        float[] fArr;
        GradientColor gradientColor = (GradientColor) keyframe.f14816b;
        GradientColor gradientColor2 = (GradientColor) keyframe.f14817c;
        GradientColor gradientColor3 = this.f14356i;
        gradientColor3.getClass();
        if (gradientColor.equals(gradientColor2)) {
            gradientColor3.a(gradientColor);
            return gradientColor3;
        }
        if (f2 <= 0.0f) {
            gradientColor3.a(gradientColor);
            return gradientColor3;
        }
        if (f2 >= 1.0f) {
            gradientColor3.a(gradientColor2);
            return gradientColor3;
        }
        int[] iArr2 = gradientColor.f14508b;
        int length = iArr2.length;
        int[] iArr3 = gradientColor2.f14508b;
        if (length != iArr3.length) {
            StringBuilder sb = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
            sb.append(iArr2.length);
            sb.append(" vs ");
            throw new IllegalArgumentException(b.o(sb, iArr3.length, ")"));
        }
        int i2 = 0;
        while (true) {
            int length2 = iArr2.length;
            iArr = gradientColor3.f14508b;
            fArr = gradientColor3.f14507a;
            if (i2 >= length2) {
                break;
            }
            fArr[i2] = MiscUtils.e(gradientColor.f14507a[i2], gradientColor2.f14507a[i2], f2);
            iArr[i2] = GammaEvaluator.c(f2, iArr2[i2], iArr3[i2]);
            i2++;
        }
        for (int length3 = iArr2.length; length3 < fArr.length; length3++) {
            fArr[length3] = fArr[iArr2.length - 1];
            iArr[length3] = iArr[iArr2.length - 1];
        }
        return gradientColor3;
    }
}
