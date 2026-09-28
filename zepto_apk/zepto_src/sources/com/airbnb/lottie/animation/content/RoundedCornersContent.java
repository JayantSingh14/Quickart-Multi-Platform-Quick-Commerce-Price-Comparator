package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import android.support.v4.media.a;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final LottieDrawable f14313a;

    /* renamed from: b, reason: collision with root package name */
    public final BaseKeyframeAnimation f14314b;

    /* renamed from: c, reason: collision with root package name */
    public ShapeData f14315c;

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.f14313a = lottieDrawable;
        roundedCorners.getClass();
        FloatKeyframeAnimation floatKeyframeAnimationA = roundedCorners.f14578a.a();
        this.f14314b = floatKeyframeAnimationA;
        baseLayer.g(floatKeyframeAnimationA);
        floatKeyframeAnimationA.a(this);
    }

    public static int d(int i2, int i3) {
        int i4 = i2 / i3;
        if ((i2 ^ i3) < 0 && i4 * i3 != i2) {
            i4--;
        }
        return i2 - (i4 * i3);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14313a.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public final ShapeData c(ShapeData shapeData) {
        ArrayList arrayList;
        boolean z;
        int i2;
        ShapeData shapeData2 = shapeData;
        ArrayList arrayList2 = shapeData2.f14579a;
        if (arrayList2.size() > 2) {
            float fFloatValue = ((Float) this.f14314b.f()).floatValue();
            if (fFloatValue != 0.0f) {
                ArrayList arrayList3 = shapeData2.f14579a;
                boolean z2 = shapeData2.f14581c;
                boolean z3 = true;
                int size = arrayList3.size() - 1;
                int i3 = 0;
                while (size >= 0) {
                    CubicCurveData cubicCurveData = (CubicCurveData) arrayList3.get(size);
                    CubicCurveData cubicCurveData2 = (CubicCurveData) arrayList3.get(d(size - 1, arrayList3.size()));
                    PointF pointF = (size != 0 || z2) ? cubicCurveData2.f14441c : shapeData2.f14580b;
                    i3 = (((size != 0 || z2) ? cubicCurveData2.f14440b : pointF).equals(pointF) && cubicCurveData.f14439a.equals(pointF) && !(!shapeData2.f14581c && (size == 0 || size == arrayList3.size() - 1))) ? i3 + 2 : i3 + 1;
                    size--;
                }
                ShapeData shapeData3 = this.f14315c;
                if (shapeData3 == null || shapeData3.f14579a.size() != i3) {
                    ArrayList arrayList4 = new ArrayList(i3);
                    for (int i4 = 0; i4 < i3; i4++) {
                        arrayList4.add(new CubicCurveData());
                    }
                    this.f14315c = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList4);
                }
                ShapeData shapeData4 = this.f14315c;
                shapeData4.f14581c = z2;
                PointF pointF2 = shapeData2.f14580b;
                shapeData4.a(pointF2.x, pointF2.y);
                ArrayList arrayList5 = shapeData4.f14579a;
                boolean z4 = shapeData2.f14581c;
                int i5 = 0;
                int i6 = 0;
                while (i5 < arrayList2.size()) {
                    CubicCurveData cubicCurveData3 = (CubicCurveData) arrayList2.get(i5);
                    CubicCurveData cubicCurveData4 = (CubicCurveData) arrayList2.get(d(i5 - 1, arrayList2.size()));
                    CubicCurveData cubicCurveData5 = (CubicCurveData) arrayList2.get(d(i5 - 2, arrayList2.size()));
                    PointF pointF3 = (i5 != 0 || z4) ? cubicCurveData4.f14441c : shapeData2.f14580b;
                    PointF pointF4 = (i5 != 0 || z4) ? cubicCurveData4.f14440b : pointF3;
                    boolean z5 = z3;
                    PointF pointF5 = cubicCurveData3.f14439a;
                    PointF pointF6 = cubicCurveData5.f14441c;
                    boolean z6 = (shapeData2.f14581c || !(i5 == 0 || i5 == arrayList2.size() + (-1))) ? false : z5;
                    if (pointF4.equals(pointF3) && pointF5.equals(pointF3) && !z6) {
                        float f2 = pointF3.x;
                        float f3 = f2 - pointF6.x;
                        float f4 = pointF3.y;
                        float f5 = f4 - pointF6.y;
                        PointF pointF7 = cubicCurveData3.f14441c;
                        float f6 = pointF7.x - f2;
                        float f7 = pointF7.y - f4;
                        arrayList = arrayList2;
                        double d2 = f3;
                        z = z4;
                        i2 = i5;
                        float fHypot = (float) Math.hypot(d2, f5);
                        float fHypot2 = (float) Math.hypot(f6, f7);
                        float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                        float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                        float f8 = pointF3.x;
                        float fA = a.a(pointF6.x, f8, fMin, f8);
                        float f9 = pointF3.y;
                        float fA2 = a.a(pointF6.y, f9, fMin, f9);
                        float fA3 = a.a(pointF7.x, f8, fMin2, f8);
                        float fA4 = a.a(pointF7.y, f9, fMin2, f9);
                        float f10 = fA - ((fA - f8) * 0.5519f);
                        float f11 = fA2 - ((fA2 - f9) * 0.5519f);
                        float f12 = fA3 - ((fA3 - f8) * 0.5519f);
                        float f13 = fA4 - ((fA4 - f9) * 0.5519f);
                        CubicCurveData cubicCurveData6 = (CubicCurveData) arrayList5.get(d(i6 - 1, arrayList5.size()));
                        CubicCurveData cubicCurveData7 = (CubicCurveData) arrayList5.get(i6);
                        cubicCurveData6.f14440b.set(fA, fA2);
                        cubicCurveData6.f14441c.set(fA, fA2);
                        if (i2 == 0) {
                            shapeData4.a(fA, fA2);
                        }
                        cubicCurveData7.f14439a.set(f10, f11);
                        CubicCurveData cubicCurveData8 = (CubicCurveData) arrayList5.get(i6 + 1);
                        cubicCurveData7.f14440b.set(f12, f13);
                        cubicCurveData7.f14441c.set(fA3, fA4);
                        cubicCurveData8.f14439a.set(fA3, fA4);
                        i6 += 2;
                    } else {
                        arrayList = arrayList2;
                        z = z4;
                        i2 = i5;
                        CubicCurveData cubicCurveData9 = (CubicCurveData) arrayList5.get(d(i6 - 1, arrayList5.size()));
                        CubicCurveData cubicCurveData10 = (CubicCurveData) arrayList5.get(i6);
                        PointF pointF8 = cubicCurveData4.f14440b;
                        cubicCurveData9.f14440b.set(pointF8.x, pointF8.y);
                        PointF pointF9 = cubicCurveData4.f14441c;
                        cubicCurveData9.f14441c.set(pointF9.x, pointF9.y);
                        PointF pointF10 = cubicCurveData3.f14439a;
                        cubicCurveData10.f14439a.set(pointF10.x, pointF10.y);
                        i6++;
                    }
                    i5 = i2 + 1;
                    shapeData2 = shapeData;
                    z4 = z;
                    z3 = z5;
                    arrayList2 = arrayList;
                }
                return shapeData4;
            }
        }
        return shapeData2;
    }
}
