package com.google.maps.android.data.kml;

import com.google.maps.android.data.LineString;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class KmlLineString extends LineString {
    @Override // com.google.maps.android.data.LineString, com.google.maps.android.data.Geometry
    public final Object d() {
        return new ArrayList(this.f45528a);
    }

    @Override // com.google.maps.android.data.LineString
    /* renamed from: e */
    public final List d() {
        return new ArrayList(this.f45528a);
    }
}
