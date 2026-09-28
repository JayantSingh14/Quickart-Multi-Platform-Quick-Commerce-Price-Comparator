package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class KmlPlacemark extends Feature {

    /* renamed from: d, reason: collision with root package name */
    public final String f45572d;

    /* renamed from: e, reason: collision with root package name */
    public final KmlStyle f45573e;

    public KmlPlacemark(Geometry geometry, String str, KmlStyle kmlStyle, HashMap map) {
        super(geometry, str, map);
        this.f45572d = str;
        this.f45573e = kmlStyle;
    }

    public final KmlStyle e() {
        return this.f45573e;
    }

    public final MarkerOptions f() {
        KmlStyle kmlStyle = this.f45573e;
        if (kmlStyle == null) {
            return null;
        }
        return kmlStyle.e();
    }

    public final String g() {
        return this.f45524a;
    }

    public final String toString() {
        return "Placemark{\n style id=" + this.f45572d + ",\n inline style=" + this.f45573e + "\n}\n";
    }
}
