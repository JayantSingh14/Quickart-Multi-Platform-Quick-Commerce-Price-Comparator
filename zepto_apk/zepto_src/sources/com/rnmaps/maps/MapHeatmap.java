package com.rnmaps.maps;

import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.google.maps.android.heatmaps.WeightedLatLng;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class MapHeatmap extends MapFeature {

    /* renamed from: a, reason: collision with root package name */
    public TileOverlayOptions f46511a;

    /* renamed from: b, reason: collision with root package name */
    public TileOverlay f46512b;

    /* renamed from: c, reason: collision with root package name */
    public HeatmapTileProvider f46513c;

    /* renamed from: d, reason: collision with root package name */
    public List f46514d;

    /* renamed from: e, reason: collision with root package name */
    public Gradient f46515e;

    /* renamed from: f, reason: collision with root package name */
    public Double f46516f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f46517g;

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46512b;
    }

    public TileOverlayOptions getHeatmapOptions() {
        if (this.f46511a == null) {
            TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
            if (this.f46513c == null) {
                HeatmapTileProvider.Builder builder = new HeatmapTileProvider.Builder();
                builder.e(this.f46514d);
                Integer num = this.f46517g;
                if (num != null) {
                    builder.d(num.intValue());
                }
                Double d2 = this.f46516f;
                if (d2 != null) {
                    builder.c(d2.doubleValue());
                }
                Gradient gradient = this.f46515e;
                if (gradient != null) {
                    builder.b(gradient);
                }
                this.f46513c = builder.a();
            }
            tileOverlayOptions.b(this.f46513c);
            this.f46511a = tileOverlayOptions;
        }
        return this.f46511a;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        this.f46512b.b();
    }

    public void setGradient(Gradient gradient) {
        this.f46515e = gradient;
        HeatmapTileProvider heatmapTileProvider = this.f46513c;
        if (heatmapTileProvider != null) {
            heatmapTileProvider.d(gradient);
        }
        TileOverlay tileOverlay = this.f46512b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setOpacity(double d2) {
        this.f46516f = Double.valueOf(d2);
        HeatmapTileProvider heatmapTileProvider = this.f46513c;
        if (heatmapTileProvider != null) {
            heatmapTileProvider.e(d2);
        }
        TileOverlay tileOverlay = this.f46512b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setPoints(WeightedLatLng[] weightedLatLngArr) {
        List listAsList = Arrays.asList(weightedLatLngArr);
        this.f46514d = listAsList;
        HeatmapTileProvider heatmapTileProvider = this.f46513c;
        if (heatmapTileProvider != null) {
            heatmapTileProvider.g(listAsList);
        }
        TileOverlay tileOverlay = this.f46512b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setRadius(int i2) {
        this.f46517g = Integer.valueOf(i2);
        HeatmapTileProvider heatmapTileProvider = this.f46513c;
        if (heatmapTileProvider != null) {
            heatmapTileProvider.f(i2);
        }
        TileOverlay tileOverlay = this.f46512b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }
}
