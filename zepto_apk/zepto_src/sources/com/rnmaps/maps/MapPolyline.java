package com.rnmaps.maps;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.google.maps.android.collections.PolylineManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MapPolyline extends MapFeature {

    /* renamed from: a, reason: collision with root package name */
    public PolylineOptions f46578a;

    /* renamed from: b, reason: collision with root package name */
    public Polyline f46579b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f46580c;

    /* renamed from: d, reason: collision with root package name */
    public int f46581d;

    /* renamed from: e, reason: collision with root package name */
    public float f46582e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f46583f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f46584g;

    /* renamed from: h, reason: collision with root package name */
    public float f46585h;

    /* renamed from: i, reason: collision with root package name */
    public Cap f46586i;

    /* renamed from: j, reason: collision with root package name */
    public ReadableArray f46587j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f46588k;

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46579b;
    }

    public PolylineOptions getPolylineOptions() {
        if (this.f46578a == null) {
            PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.b(this.f46580c);
            polylineOptions.r(this.f46581d);
            polylineOptions.l0(this.f46582e);
            polylineOptions.A(this.f46584g);
            polylineOptions.n0(this.f46585h);
            polylineOptions.Z(this.f46586i);
            polylineOptions.s(this.f46586i);
            polylineOptions.N(this.f46588k);
            this.f46578a = polylineOptions;
        }
        return this.f46578a;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        ((PolylineManager.Collection) obj).f(this.f46579b);
    }

    public final void k() {
        if (this.f46587j == null) {
            return;
        }
        this.f46588k = new ArrayList(this.f46587j.size());
        for (int i2 = 0; i2 < this.f46587j.size(); i2++) {
            float f2 = (float) this.f46587j.getDouble(i2);
            if (i2 % 2 != 0) {
                this.f46588k.add(new Gap(f2));
            } else {
                this.f46588k.add(this.f46586i instanceof RoundCap ? new Dot() : new Dash(f2));
            }
        }
        Polyline polyline = this.f46579b;
        if (polyline != null) {
            polyline.e(this.f46588k);
        }
    }

    public void setColor(int i2) {
        this.f46581d = i2;
        Polyline polyline = this.f46579b;
        if (polyline != null) {
            polyline.b(i2);
        }
    }

    public void setCoordinates(ReadableArray readableArray) {
        this.f46580c = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            this.f46580c.add(i2, new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        Polyline polyline = this.f46579b;
        if (polyline != null) {
            polyline.f(this.f46580c);
        }
    }

    public void setGeodesic(boolean z) {
        this.f46584g = z;
        Polyline polyline = this.f46579b;
        if (polyline != null) {
            polyline.d(z);
        }
    }

    public void setLineCap(Cap cap) {
        this.f46586i = cap;
        Polyline polyline = this.f46579b;
        if (polyline != null) {
            polyline.g(cap);
            this.f46579b.c(cap);
        }
        k();
    }

    public void setLineDashPattern(ReadableArray readableArray) {
        this.f46587j = readableArray;
        k();
    }

    public void setTappable(boolean z) {
        this.f46583f = z;
        Polyline polyline = this.f46579b;
        if (polyline != null) {
            polyline.a(z);
        }
    }

    public void setWidth(float f2) {
        this.f46582e = f2;
        Polyline polyline = this.f46579b;
        if (polyline != null) {
            polyline.h(f2);
        }
    }

    public void setZIndex(float f2) {
        this.f46585h = f2;
        Polyline polyline = this.f46579b;
        if (polyline != null) {
            polyline.i(f2);
        }
    }
}
