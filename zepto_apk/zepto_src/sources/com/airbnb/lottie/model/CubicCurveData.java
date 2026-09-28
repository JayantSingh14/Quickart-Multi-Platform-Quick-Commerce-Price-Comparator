package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes3.dex */
public class CubicCurveData {

    /* renamed from: a, reason: collision with root package name */
    public final PointF f14439a;

    /* renamed from: b, reason: collision with root package name */
    public final PointF f14440b;

    /* renamed from: c, reason: collision with root package name */
    public final PointF f14441c;

    public CubicCurveData() {
        this.f14439a = new PointF();
        this.f14440b = new PointF();
        this.f14441c = new PointF();
    }

    public final String toString() {
        PointF pointF = this.f14441c;
        Float fValueOf = Float.valueOf(pointF.x);
        Float fValueOf2 = Float.valueOf(pointF.y);
        PointF pointF2 = this.f14439a;
        Float fValueOf3 = Float.valueOf(pointF2.x);
        Float fValueOf4 = Float.valueOf(pointF2.y);
        PointF pointF3 = this.f14440b;
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", fValueOf, fValueOf2, fValueOf3, fValueOf4, Float.valueOf(pointF3.x), Float.valueOf(pointF3.y));
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f14439a = pointF;
        this.f14440b = pointF2;
        this.f14441c = pointF3;
    }
}
