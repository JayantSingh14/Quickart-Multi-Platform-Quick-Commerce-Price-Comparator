package com.rnmaps.maps;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.maps.android.collections.PolygonManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MapPolygon extends MapFeature {

    /* renamed from: a, reason: collision with root package name */
    public PolygonOptions f46566a;

    /* renamed from: b, reason: collision with root package name */
    public Polygon f46567b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f46568c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f46569d;

    /* renamed from: e, reason: collision with root package name */
    public int f46570e;

    /* renamed from: f, reason: collision with root package name */
    public int f46571f;

    /* renamed from: g, reason: collision with root package name */
    public float f46572g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f46573h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f46574i;

    /* renamed from: j, reason: collision with root package name */
    public float f46575j;

    /* renamed from: k, reason: collision with root package name */
    public ReadableArray f46576k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f46577l;

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46567b;
    }

    public PolygonOptions getPolygonOptions() {
        if (this.f46566a == null) {
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.b(this.f46568c);
            polygonOptions.s(this.f46571f);
            polygonOptions.N(this.f46570e);
            polygonOptions.l0(this.f46572g);
            polygonOptions.A(this.f46573h);
            polygonOptions.n0(this.f46575j);
            polygonOptions.Z(this.f46577l);
            if (this.f46569d != null) {
                for (int i2 = 0; i2 < this.f46569d.size(); i2++) {
                    polygonOptions.r((Iterable) this.f46569d.get(i2));
                }
            }
            this.f46566a = polygonOptions;
        }
        return this.f46566a;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        ((PolygonManager.Collection) obj).e(this.f46567b);
    }

    public void setCoordinates(ReadableArray readableArray) {
        this.f46568c = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            this.f46568c.add(i2, new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.e(this.f46568c);
        }
    }

    public void setFillColor(int i2) {
        this.f46571f = i2;
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.b(i2);
        }
    }

    public void setGeodesic(boolean z) {
        this.f46573h = z;
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.c(z);
        }
    }

    public void setHoles(ReadableArray readableArray) {
        if (readableArray == null) {
            return;
        }
        this.f46569d = new ArrayList(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableArray array = readableArray.getArray(i2);
            if (array.size() >= 3) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < array.size(); i3++) {
                    ReadableMap map = array.getMap(i3);
                    arrayList.add(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
                }
                if (arrayList.size() == 3) {
                    arrayList.add((LatLng) arrayList.get(0));
                }
                this.f46569d.add(arrayList);
            }
        }
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.d(this.f46569d);
        }
    }

    public void setLineDashPattern(ReadableArray readableArray) {
        this.f46576k = readableArray;
        if (readableArray == null) {
            return;
        }
        this.f46577l = new ArrayList(this.f46576k.size());
        for (int i2 = 0; i2 < this.f46576k.size(); i2++) {
            float f2 = (float) this.f46576k.getDouble(i2);
            if (i2 % 2 != 0) {
                this.f46577l.add(new Gap(f2));
            } else {
                this.f46577l.add(new Dash(f2));
            }
        }
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.g(this.f46577l);
        }
    }

    public void setStrokeColor(int i2) {
        this.f46570e = i2;
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.f(i2);
        }
    }

    public void setStrokeWidth(float f2) {
        this.f46572g = f2;
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.h(f2);
        }
    }

    public void setTappable(boolean z) {
        this.f46574i = z;
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.a(z);
        }
    }

    public void setZIndex(float f2) {
        this.f46575j = f2;
        Polygon polygon = this.f46567b;
        if (polygon != null) {
            polygon.i(f2);
        }
    }
}
