package com.google.android.gms.maps.model;

/* loaded from: classes4.dex */
public final class Gap extends PatternItem {

    /* renamed from: c, reason: collision with root package name */
    public final float f38459c;

    public Gap(float f2) {
        super(2, Float.valueOf(Math.max(f2, 0.0f)));
        this.f38459c = Math.max(f2, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        return "[Gap: length=" + this.f38459c + "]";
    }
}
