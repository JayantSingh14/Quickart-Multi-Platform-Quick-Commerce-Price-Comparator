package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {

    /* renamed from: i, reason: collision with root package name */
    public final ShapeData f14367i;

    /* renamed from: j, reason: collision with root package name */
    public final Path f14368j;

    /* renamed from: k, reason: collision with root package name */
    public Path f14369k;

    /* renamed from: l, reason: collision with root package name */
    public Path f14370l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f14371m;

    public ShapeKeyframeAnimation(List list) {
        super(list);
        this.f14367i = new ShapeData();
        this.f14368j = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        ShapeData shapeDataC;
        ShapeData shapeData = (ShapeData) keyframe.f14816b;
        ShapeData shapeData2 = (ShapeData) keyframe.f14817c;
        ShapeData shapeData3 = shapeData2 == null ? shapeData : shapeData2;
        ShapeData shapeData4 = this.f14367i;
        if (shapeData4.f14580b == null) {
            shapeData4.f14580b = new PointF();
        }
        boolean z = true;
        shapeData4.f14581c = shapeData.f14581c || shapeData3.f14581c;
        ArrayList arrayList = shapeData.f14579a;
        int size = arrayList.size();
        int size2 = shapeData3.f14579a.size();
        ArrayList arrayList2 = shapeData3.f14579a;
        if (size != size2) {
            Logger.b("Curves must have the same number of control points. Shape 1: " + arrayList.size() + "\tShape 2: " + arrayList2.size());
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        ArrayList arrayList3 = shapeData4.f14579a;
        if (arrayList3.size() < iMin) {
            for (int size3 = arrayList3.size(); size3 < iMin; size3++) {
                arrayList3.add(new CubicCurveData());
            }
        } else if (arrayList3.size() > iMin) {
            for (int size4 = arrayList3.size() - 1; size4 >= iMin; size4--) {
                arrayList3.remove(arrayList3.size() - 1);
            }
        }
        PointF pointF = shapeData.f14580b;
        PointF pointF2 = shapeData3.f14580b;
        shapeData4.a(MiscUtils.e(pointF.x, pointF2.x, f2), MiscUtils.e(pointF.y, pointF2.y, f2));
        int size5 = arrayList3.size() - 1;
        while (size5 >= 0) {
            CubicCurveData cubicCurveData = (CubicCurveData) arrayList.get(size5);
            CubicCurveData cubicCurveData2 = (CubicCurveData) arrayList2.get(size5);
            PointF pointF3 = cubicCurveData.f14439a;
            PointF pointF4 = cubicCurveData2.f14439a;
            boolean z2 = z;
            ShapeData shapeData5 = shapeData4;
            ((CubicCurveData) arrayList3.get(size5)).f14439a.set(MiscUtils.e(pointF3.x, pointF4.x, f2), MiscUtils.e(pointF3.y, pointF4.y, f2));
            CubicCurveData cubicCurveData3 = (CubicCurveData) arrayList3.get(size5);
            PointF pointF5 = cubicCurveData.f14440b;
            float f3 = pointF5.x;
            PointF pointF6 = cubicCurveData2.f14440b;
            cubicCurveData3.f14440b.set(MiscUtils.e(f3, pointF6.x, f2), MiscUtils.e(pointF5.y, pointF6.y, f2));
            CubicCurveData cubicCurveData4 = (CubicCurveData) arrayList3.get(size5);
            PointF pointF7 = cubicCurveData.f14441c;
            float f4 = pointF7.x;
            PointF pointF8 = cubicCurveData2.f14441c;
            cubicCurveData4.f14441c.set(MiscUtils.e(f4, pointF8.x, f2), MiscUtils.e(pointF7.y, pointF8.y, f2));
            size5--;
            z = z2;
            shapeData4 = shapeData5;
        }
        ShapeData shapeData6 = shapeData4;
        ArrayList arrayList4 = this.f14371m;
        if (arrayList4 != null) {
            shapeDataC = shapeData6;
            for (int size6 = arrayList4.size() - 1; size6 >= 0; size6--) {
                shapeDataC = ((ShapeModifierContent) this.f14371m.get(size6)).c(shapeDataC);
            }
        } else {
            shapeDataC = shapeData6;
        }
        Path path = this.f14368j;
        MiscUtils.d(shapeDataC, path);
        if (this.f14333e == null) {
            return path;
        }
        if (this.f14369k == null) {
            this.f14369k = new Path();
            this.f14370l = new Path();
        }
        MiscUtils.d(shapeData, this.f14369k);
        if (shapeData2 != null) {
            MiscUtils.d(shapeData2, this.f14370l);
        }
        LottieValueCallback lottieValueCallback = this.f14333e;
        float fFloatValue = keyframe.f14822h.floatValue();
        Path path2 = this.f14369k;
        return (Path) lottieValueCallback.b(keyframe.f14821g, fFloatValue, path2, shapeData2 == null ? path2 : this.f14370l, f2, e(), this.f14332d);
    }
}
