package com.google.maps.android.projection;

import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
public class SphericalMercatorProjection {

    /* renamed from: a, reason: collision with root package name */
    public final double f45621a;

    public SphericalMercatorProjection(double d2) {
        this.f45621a = d2;
    }

    public final Point a(LatLng latLng) {
        double d2 = (latLng.f38476b / 360.0d) + 0.5d;
        double dSin = Math.sin(Math.toRadians(latLng.f38475a));
        double dLog = ((Math.log((dSin + 1.0d) / (1.0d - dSin)) * 0.5d) / (-6.283185307179586d)) + 0.5d;
        double d3 = this.f45621a;
        return new Point(d2 * d3, dLog * d3);
    }
}
