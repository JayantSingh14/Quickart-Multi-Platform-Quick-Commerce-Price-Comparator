package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.DataPolygon;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class KmlPolygon implements DataPolygon<ArrayList<ArrayList<LatLng>>> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f45574a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f45575b;

    public KmlPolygon(ArrayList arrayList, ArrayList arrayList2) {
        this.f45574a = arrayList;
        this.f45575b = arrayList2;
    }

    @Override // com.google.maps.android.data.Geometry
    public final String a() {
        return "Polygon";
    }

    @Override // com.google.maps.android.data.DataPolygon
    public final List b() {
        return this.f45574a;
    }

    @Override // com.google.maps.android.data.DataPolygon
    public final List c() {
        return this.f45575b;
    }

    @Override // com.google.maps.android.data.Geometry
    public final Object d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f45574a);
        arrayList.addAll(this.f45575b);
        return arrayList;
    }

    public final String toString() {
        return "Polygon{\n outer coordinates=" + this.f45574a + ",\n inner coordinates=" + this.f45575b + "\n}\n";
    }
}
