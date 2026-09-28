package com.google.android.material.shape;

/* loaded from: classes4.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {

    /* renamed from: a, reason: collision with root package name */
    public final float f40973a;

    public MarkerEdgeTreatment(float f2) {
        this.f40973a = f2 - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public final void b(float f2, float f3, float f4, ShapePath shapePath) {
        double d2 = this.f40973a;
        float fSqrt = (float) ((Math.sqrt(2.0d) * d2) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(d2, 2.0d) - Math.pow(fSqrt, 2.0d));
        shapePath.f(f3 - fSqrt, ((float) (-((Math.sqrt(2.0d) * d2) - d2))) + fSqrt2, 270.0f, 0.0f);
        shapePath.d(f3, (float) (-((Math.sqrt(2.0d) * d2) - d2)));
        shapePath.d(f3 + fSqrt, ((float) (-((Math.sqrt(2.0d) * d2) - d2))) + fSqrt2);
    }
}
