package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class KmlGroundOverlay {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f45563a;

    /* renamed from: b, reason: collision with root package name */
    public final GroundOverlayOptions f45564b;

    /* renamed from: c, reason: collision with root package name */
    public final String f45565c;

    /* renamed from: d, reason: collision with root package name */
    public final LatLngBounds f45566d;

    public KmlGroundOverlay(String str, LatLngBounds latLngBounds, float f2, int i2, HashMap map, float f3) {
        GroundOverlayOptions groundOverlayOptions = new GroundOverlayOptions();
        this.f45564b = groundOverlayOptions;
        this.f45565c = str;
        this.f45563a = map;
        this.f45566d = latLngBounds;
        groundOverlayOptions.s(latLngBounds);
        groundOverlayOptions.b(f3);
        groundOverlayOptions.f38467g = f2;
        groundOverlayOptions.f38468h = i2 != 0;
    }

    public final String toString() {
        return "GroundOverlay{\n properties=" + this.f45563a + ",\n image url=" + this.f45565c + ",\n LatLngBox=" + this.f45566d + "\n}\n";
    }
}
