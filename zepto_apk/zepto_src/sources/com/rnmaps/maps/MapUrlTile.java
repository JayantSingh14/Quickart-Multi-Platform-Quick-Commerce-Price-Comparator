package com.rnmaps.maps;

import android.util.Log;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class MapUrlTile extends MapFeature {

    /* renamed from: a, reason: collision with root package name */
    public TileOverlayOptions f46607a;

    /* renamed from: b, reason: collision with root package name */
    public TileOverlay f46608b;

    /* renamed from: c, reason: collision with root package name */
    public MapTileProvider f46609c;

    /* renamed from: d, reason: collision with root package name */
    public String f46610d;

    /* renamed from: e, reason: collision with root package name */
    public float f46611e;

    /* renamed from: f, reason: collision with root package name */
    public float f46612f;

    /* renamed from: g, reason: collision with root package name */
    public float f46613g;

    /* renamed from: h, reason: collision with root package name */
    public float f46614h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f46615i;

    /* renamed from: j, reason: collision with root package name */
    public float f46616j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f46617k;

    /* renamed from: l, reason: collision with root package name */
    public String f46618l;

    /* renamed from: m, reason: collision with root package name */
    public float f46619m;
    public boolean n;
    public float o;
    public final ThemedReactContext p;
    public boolean q;

    public MapUrlTile(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f46613g = 100.0f;
        this.f46615i = false;
        this.f46616j = 256.0f;
        this.f46617k = false;
        this.n = false;
        this.o = 1.0f;
        this.q = false;
        this.p = themedReactContext;
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46608b;
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.f46607a == null) {
            this.f46607a = k();
        }
        return this.f46607a;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        this.f46608b.b();
    }

    public TileOverlayOptions k() {
        Log.d("urlTile ", "creating TileProvider");
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.s(this.f46611e);
        tileOverlayOptions.r(1.0f - this.o);
        MapTileProvider mapTileProvider = new MapTileProvider((int) this.f46616j, this.f46617k, this.f46610d, (int) this.f46612f, (int) this.f46613g, (int) this.f46614h, this.f46615i, this.f46618l, (int) this.f46619m, this.n, this.p, this.q);
        this.f46609c = mapTileProvider;
        tileOverlayOptions.b(mapTileProvider);
        return tileOverlayOptions;
    }

    public final void l() {
        Log.d("urlTile ", "creating new mode TileProvider");
        this.q = true;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.getClass();
        }
    }

    public void setDoubleTileSize(boolean z) {
        this.f46617k = z;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.f(z);
        }
        l();
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setFlipY(boolean z) {
        this.f46615i = z;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.g(z);
        }
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setMaximumNativeZ(float f2) {
        this.f46613g = f2;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.h((int) f2);
        }
        l();
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setMaximumZ(float f2) {
        this.f46612f = f2;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.i((int) f2);
        }
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setMinimumZ(float f2) {
        this.f46614h = f2;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.j((int) f2);
        }
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setOfflineMode(boolean z) {
        this.n = z;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.k(z);
        }
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setOpacity(float f2) {
        this.o = f2;
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.c(1.0f - f2);
        }
    }

    public void setTileCacheMaxAge(float f2) {
        this.f46619m = f2;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.l((int) f2);
        }
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setTileCachePath(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            this.f46618l = new URL(str).getPath();
        } catch (MalformedURLException unused) {
            this.f46618l = str;
        } catch (Exception unused2) {
            return;
        }
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.m(str);
        }
        l();
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setTileSize(float f2) {
        this.f46616j = f2;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.n((int) f2);
        }
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setUrlTemplate(String str) {
        this.f46610d = str;
        MapTileProvider mapTileProvider = this.f46609c;
        if (mapTileProvider != null) {
            mapTileProvider.o(str);
        }
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.a();
        }
    }

    public void setZIndex(float f2) {
        this.f46611e = f2;
        TileOverlay tileOverlay = this.f46608b;
        if (tileOverlay != null) {
            tileOverlay.d(f2);
        }
    }
}
