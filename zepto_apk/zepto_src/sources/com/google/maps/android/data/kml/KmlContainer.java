package com.google.maps.android.data.kml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes4.dex */
public class KmlContainer {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f45555a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f45556b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f45557c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f45558d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f45559e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f45560f;

    public KmlContainer(HashMap map, HashMap map2, HashMap map3, HashMap map4, ArrayList arrayList, HashMap map5) {
        this.f45555a = map;
        this.f45556b = map3;
        this.f45560f = map2;
        this.f45559e = map4;
        this.f45557c = arrayList;
        this.f45558d = map5;
    }

    public final ArrayList a() {
        return this.f45557c;
    }

    public final Set b() {
        return this.f45556b.keySet();
    }

    public final KmlStyle c(String str) {
        return (KmlStyle) this.f45560f.get(str);
    }

    public final String toString() {
        return "Container{\n properties=" + this.f45555a + ",\n placemarks=" + this.f45556b + ",\n containers=" + this.f45557c + ",\n ground overlays=" + this.f45558d + ",\n style maps=" + this.f45559e + ",\n styles=" + this.f45560f + "\n}\n";
    }
}
