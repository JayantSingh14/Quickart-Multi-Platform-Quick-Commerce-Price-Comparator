package com.google.android.material.shape;

/* loaded from: classes4.dex */
public final class OffsetEdgeTreatment extends EdgeTreatment {

    /* renamed from: a, reason: collision with root package name */
    public final MarkerEdgeTreatment f41002a;

    /* renamed from: b, reason: collision with root package name */
    public final float f41003b;

    public OffsetEdgeTreatment(MarkerEdgeTreatment markerEdgeTreatment, float f2) {
        this.f41002a = markerEdgeTreatment;
        this.f41003b = f2;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public final boolean a() {
        this.f41002a.getClass();
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public final void b(float f2, float f3, float f4, ShapePath shapePath) {
        this.f41002a.b(f2, f3 - this.f41003b, f4, shapePath);
    }
}
