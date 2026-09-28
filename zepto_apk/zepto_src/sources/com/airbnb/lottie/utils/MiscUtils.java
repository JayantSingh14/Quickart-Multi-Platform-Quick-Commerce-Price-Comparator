package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.v4.media.a;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class MiscUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final PointF f14809a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f2, float f3, float f4) {
        return Math.max(f3, Math.min(f4, f2));
    }

    public static int c(float f2, float f3) {
        int i2 = (int) f2;
        int i3 = (int) f3;
        int i4 = i2 / i3;
        int i5 = i2 % i3;
        if (!((i2 ^ i3) >= 0) && i5 != 0) {
            i4--;
        }
        return i2 - (i3 * i4);
    }

    public static void d(ShapeData shapeData, Path path) {
        Path path2;
        path.reset();
        PointF pointF = shapeData.f14580b;
        path.moveTo(pointF.x, pointF.y);
        PointF pointF2 = f14809a;
        pointF2.set(pointF.x, pointF.y);
        int i2 = 0;
        while (true) {
            ArrayList arrayList = shapeData.f14579a;
            if (i2 >= arrayList.size()) {
                break;
            }
            CubicCurveData cubicCurveData = (CubicCurveData) arrayList.get(i2);
            PointF pointF3 = cubicCurveData.f14439a;
            boolean zEquals = pointF3.equals(pointF2);
            PointF pointF4 = cubicCurveData.f14440b;
            PointF pointF5 = cubicCurveData.f14441c;
            if (zEquals && pointF4.equals(pointF5)) {
                path.lineTo(pointF5.x, pointF5.y);
                path2 = path;
            } else {
                path2 = path;
                path2.cubicTo(pointF3.x, pointF3.y, pointF4.x, pointF4.y, pointF5.x, pointF5.y);
            }
            pointF2.set(pointF5.x, pointF5.y);
            i2++;
            path = path2;
        }
        Path path3 = path;
        if (shapeData.f14581c) {
            path3.close();
        }
    }

    public static float e(float f2, float f3, float f4) {
        return a.a(f3, f2, f4, f2);
    }

    public static void f(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.a(i2, keyPathElementContent.getName())) {
            String name = keyPathElementContent.getName();
            KeyPath keyPath3 = new KeyPath(keyPath2);
            keyPath3.f14467a.add(name);
            KeyPath keyPath4 = new KeyPath(keyPath3);
            keyPath4.f14468b = keyPathElementContent;
            arrayList.add(keyPath4);
        }
    }
}
