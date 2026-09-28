package com.rnmaps.maps;

import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.collections.CircleManager;

/* loaded from: classes.dex */
public class MapCircle extends MapFeature {

    /* renamed from: a, reason: collision with root package name */
    public CircleOptions f46485a;

    /* renamed from: b, reason: collision with root package name */
    public Circle f46486b;

    /* renamed from: c, reason: collision with root package name */
    public LatLng f46487c;

    /* renamed from: d, reason: collision with root package name */
    public double f46488d;

    /* renamed from: e, reason: collision with root package name */
    public int f46489e;

    /* renamed from: f, reason: collision with root package name */
    public int f46490f;

    /* renamed from: g, reason: collision with root package name */
    public float f46491g;

    /* renamed from: h, reason: collision with root package name */
    public float f46492h;

    public CircleOptions getCircleOptions() {
        if (this.f46485a == null) {
            CircleOptions circleOptions = new CircleOptions();
            circleOptions.b(this.f46487c);
            circleOptions.s(this.f46488d);
            circleOptions.r(this.f46490f);
            circleOptions.A(this.f46489e);
            circleOptions.N(this.f46491g);
            circleOptions.Z(this.f46492h);
            this.f46485a = circleOptions;
        }
        return this.f46485a;
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46486b;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        ((CircleManager.Collection) obj).b(this.f46486b);
    }

    public void setCenter(LatLng latLng) {
        this.f46487c = latLng;
        Circle circle = this.f46486b;
        if (circle != null) {
            circle.a(latLng);
        }
    }

    public void setFillColor(int i2) {
        this.f46490f = i2;
        Circle circle = this.f46486b;
        if (circle != null) {
            circle.b(i2);
        }
    }

    public void setRadius(double d2) {
        this.f46488d = d2;
        Circle circle = this.f46486b;
        if (circle != null) {
            circle.c(d2);
        }
    }

    public void setStrokeColor(int i2) {
        this.f46489e = i2;
        Circle circle = this.f46486b;
        if (circle != null) {
            circle.d(i2);
        }
    }

    public void setStrokeWidth(float f2) {
        this.f46491g = f2;
        Circle circle = this.f46486b;
        if (circle != null) {
            circle.e(f2);
        }
    }

    public void setZIndex(float f2) {
        this.f46492h = f2;
        Circle circle = this.f46486b;
        if (circle != null) {
            circle.f(f2);
        }
    }
}
