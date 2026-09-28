package com.google.android.material.shape;

/* loaded from: classes4.dex */
public class CutCornerTreatment extends CornerTreatment {

    /* renamed from: a, reason: collision with root package name */
    public final float f40972a = -1.0f;

    @Override // com.google.android.material.shape.CornerTreatment
    public final void a(ShapePath shapePath, float f2, float f3) {
        shapePath.f(0.0f, f3 * f2, 180.0f, 90.0f);
        double d2 = f3;
        double d3 = f2;
        shapePath.d((float) (Math.sin(Math.toRadians(90.0f)) * d2 * d3), (float) (Math.sin(Math.toRadians(0.0f)) * d2 * d3));
    }
}
