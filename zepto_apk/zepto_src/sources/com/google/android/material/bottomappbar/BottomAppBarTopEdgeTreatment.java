package com.google.android.material.bottomappbar;

import android.support.v4.media.a;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* loaded from: classes4.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public float f40001a;

    /* renamed from: b, reason: collision with root package name */
    public float f40002b;

    /* renamed from: c, reason: collision with root package name */
    public float f40003c;

    /* renamed from: d, reason: collision with root package name */
    public float f40004d;

    /* renamed from: e, reason: collision with root package name */
    public float f40005e;

    /* renamed from: f, reason: collision with root package name */
    public float f40006f;

    @Override // com.google.android.material.shape.EdgeTreatment
    public final void b(float f2, float f3, float f4, ShapePath shapePath) {
        float f5;
        float f6;
        float f7 = this.f40003c;
        if (f7 == 0.0f) {
            shapePath.d(f2, 0.0f);
            return;
        }
        float f8 = ((this.f40002b * 2.0f) + f7) / 2.0f;
        float f9 = f4 * this.f40001a;
        float f10 = f3 + this.f40005e;
        float fA = a.a(1.0f, f4, f8, this.f40004d * f4);
        if (fA / f8 >= 1.0f) {
            shapePath.d(f2, 0.0f);
            return;
        }
        float f11 = this.f40006f;
        float f12 = f11 * f4;
        boolean z = f11 == -1.0f || Math.abs((f11 * 2.0f) - f7) < 0.1f;
        if (z) {
            f5 = fA;
            f6 = 0.0f;
        } else {
            f6 = 1.75f;
            f5 = 0.0f;
        }
        float f13 = f8 + f9;
        float f14 = f5 + f9;
        float fSqrt = (float) Math.sqrt((f13 * f13) - (f14 * f14));
        float f15 = f10 - fSqrt;
        float f16 = f10 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f14));
        float f17 = (90.0f - degrees) + f6;
        shapePath.d(f15, 0.0f);
        float f18 = f15 - f9;
        float f19 = f15 + f9;
        float f20 = f9 * 2.0f;
        shapePath.a(f18, 0.0f, f19, f20, 270.0f, degrees);
        if (z) {
            shapePath.a(f10 - f8, (-f8) - f5, f10 + f8, f8 - f5, 180.0f - f17, (f17 * 2.0f) - 180.0f);
        } else {
            float f21 = this.f40002b;
            float f22 = f12 * 2.0f;
            float f23 = f21 + f22;
            float f24 = f10 - f8;
            shapePath.a(f24, -(f12 + f21), f23 + f24, f21 + f12, 180.0f - f17, ((f17 * 2.0f) - 180.0f) / 2.0f);
            float f25 = f10 + f8;
            float f26 = this.f40002b;
            shapePath.d(f25 - ((f26 / 2.0f) + f12), f26 + f12);
            float f27 = this.f40002b;
            shapePath.a(f25 - (f22 + f27), -(f12 + f27), f25, f27 + f12, 90.0f, f17 - 90.0f);
        }
        shapePath.a(f16 - f9, 0.0f, f16 + f9, f20, 270.0f - degrees, degrees);
        shapePath.d(f2, 0.0f);
    }

    public final void c(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f40004d = f2;
    }
}
