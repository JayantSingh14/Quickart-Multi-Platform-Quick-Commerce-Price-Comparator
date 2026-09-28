package com.google.maps.android.data;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class LineString implements Geometry<List<LatLng>> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f45528a;

    public LineString(ArrayList arrayList) {
        this.f45528a = arrayList;
    }

    @Override // com.google.maps.android.data.Geometry
    public final String a() {
        return "LineString";
    }

    @Override // com.google.maps.android.data.Geometry
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public List d() {
        return this.f45528a;
    }

    public final String toString() {
        return "LineString{\n coordinates=" + this.f45528a + "\n}\n";
    }
}
