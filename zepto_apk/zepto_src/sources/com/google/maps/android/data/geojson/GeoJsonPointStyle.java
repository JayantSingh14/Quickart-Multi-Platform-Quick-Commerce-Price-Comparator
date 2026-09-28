package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.Style;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class GeoJsonPointStyle extends Style implements GeoJsonStyle {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f45553d = {"Point", "MultiPoint", "GeometryCollection"};

    public GeoJsonPointStyle() {
        this.f45548a = new MarkerOptions();
    }

    @Override // com.google.maps.android.data.geojson.GeoJsonStyle
    public final String[] a() {
        return f45553d;
    }

    public final String toString() {
        return "PointStyle{\n geometry type=" + Arrays.toString(f45553d) + ",\n alpha=" + this.f45548a.f38498m + ",\n anchor U=" + this.f45548a.f38490e + ",\n anchor V=" + this.f45548a.f38491f + ",\n draggable=" + this.f45548a.f38492g + ",\n flat=" + this.f45548a.f38494i + ",\n info window anchor U=" + this.f45548a.f38496k + ",\n info window anchor V=" + this.f45548a.f38497l + ",\n rotation=" + this.f45548a.f38495j + ",\n snippet=" + this.f45548a.f38488c + ",\n title=" + this.f45548a.f38487b + ",\n visible=" + this.f45548a.f38493h + ",\n z index=" + this.f45548a.n + "\n}\n";
    }
}
