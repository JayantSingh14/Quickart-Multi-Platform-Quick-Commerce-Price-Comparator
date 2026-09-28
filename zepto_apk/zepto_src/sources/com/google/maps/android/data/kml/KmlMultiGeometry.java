package com.google.maps.android.data.kml;

import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class KmlMultiGeometry extends MultiGeometry {
    public KmlMultiGeometry(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((Geometry) it.next());
        }
        this.f45529a = arrayList2;
    }

    @Override // com.google.maps.android.data.MultiGeometry, com.google.maps.android.data.Geometry
    public final Object d() {
        return new ArrayList(this.f45529a);
    }

    @Override // com.google.maps.android.data.MultiGeometry
    /* renamed from: e */
    public final List d() {
        return new ArrayList(this.f45529a);
    }

    @Override // com.google.maps.android.data.MultiGeometry
    public final String toString() {
        return "MultiGeometry{\n geometries=" + new ArrayList(this.f45529a) + "\n}\n";
    }
}
