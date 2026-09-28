package com.google.android.gms.maps.model;

/* loaded from: classes4.dex */
public final class Dash extends PatternItem {

    /* renamed from: c, reason: collision with root package name */
    public final float f38458c;

    public Dash(float f2) {
        super(0, Float.valueOf(Math.max(f2, 0.0f)));
        this.f38458c = Math.max(f2, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        return "[Dash: length=" + this.f38458c + "]";
    }
}
