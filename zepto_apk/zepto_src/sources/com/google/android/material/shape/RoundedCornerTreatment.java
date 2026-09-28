package com.google.android.material.shape;

/* loaded from: classes4.dex */
public class RoundedCornerTreatment extends CornerTreatment {

    /* renamed from: a, reason: collision with root package name */
    public final float f41005a = -1.0f;

    @Override // com.google.android.material.shape.CornerTreatment
    public final void a(ShapePath shapePath, float f2, float f3) {
        shapePath.f(0.0f, f3 * f2, 180.0f, 90.0f);
        float f4 = f3 * 2.0f * f2;
        shapePath.a(0.0f, 0.0f, f4, f4, 180.0f, 90.0f);
    }
}
