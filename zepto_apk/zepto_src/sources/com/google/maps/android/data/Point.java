package com.google.maps.android.data;

import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
public class Point implements Geometry {

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f45530a;

    public Point(LatLng latLng) {
        this.f45530a = latLng;
    }

    @Override // com.google.maps.android.data.Geometry
    public final String a() {
        return "Point";
    }

    @Override // com.google.maps.android.data.Geometry
    public final Object d() {
        return this.f45530a;
    }

    public final String toString() {
        return "Point{\n coordinates=" + this.f45530a + "\n}\n";
    }
}
