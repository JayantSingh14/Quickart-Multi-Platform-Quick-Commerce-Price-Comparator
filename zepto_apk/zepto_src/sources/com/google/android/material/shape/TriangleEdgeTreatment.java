package com.google.android.material.shape;

/* loaded from: classes4.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    @Override // com.google.android.material.shape.EdgeTreatment
    public final void b(float f2, float f3, float f4, ShapePath shapePath) {
        float f5 = 0.0f * f4;
        shapePath.e(f3 - f5, f3, (-0.0f) * f4);
        shapePath.e(f3 + f5, f2, 0.0f);
    }
}
