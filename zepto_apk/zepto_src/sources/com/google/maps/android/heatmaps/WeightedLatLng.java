package com.google.maps.android.heatmaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.projection.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;

/* loaded from: classes4.dex */
public class WeightedLatLng implements PointQuadTree.Item {

    /* renamed from: c, reason: collision with root package name */
    public static final SphericalMercatorProjection f45618c = new SphericalMercatorProjection(1.0d);

    /* renamed from: a, reason: collision with root package name */
    public final Point f45619a;

    /* renamed from: b, reason: collision with root package name */
    public final double f45620b;

    public WeightedLatLng(LatLng latLng, double d2) {
        this.f45619a = f45618c.a(latLng);
        if (d2 >= 0.0d) {
            this.f45620b = d2;
        } else {
            this.f45620b = 1.0d;
        }
    }

    @Override // com.google.maps.android.quadtree.PointQuadTree.Item
    public final com.google.maps.android.geometry.Point a() {
        return this.f45619a;
    }

    public WeightedLatLng(LatLng latLng) {
        this(latLng, 1.0d);
    }
}
