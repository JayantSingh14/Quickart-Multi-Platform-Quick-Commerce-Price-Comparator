package com.rnmaps.maps;

import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class MapWMSTile extends MapUrlTile {
    public static final double[] r = {-2.003750834789244E7d, 2.003750834789244E7d};

    /* loaded from: classes4.dex */
    public class AIRMapGSUrlTileProvider extends MapTileProvider {

        public class AIRMapWMSTileProvider extends UrlTileProvider {

            /* renamed from: d, reason: collision with root package name */
            public final String f46660d;

            /* renamed from: e, reason: collision with root package name */
            public final int f46661e;

            public AIRMapWMSTileProvider(int i2, int i3, String str) {
                super(i2, i3);
                this.f46660d = str;
                this.f46661e = i2;
            }

            @Override // com.google.android.gms.maps.model.UrlTileProvider
            public final URL b(int i2, int i3, int i4) {
                AIRMapGSUrlTileProvider aIRMapGSUrlTileProvider = AIRMapGSUrlTileProvider.this;
                MapWMSTile mapWMSTile = MapWMSTile.this;
                if (mapWMSTile.f46612f > 0.0f && i4 > aIRMapGSUrlTileProvider.f46593f) {
                    return null;
                }
                if (mapWMSTile.f46614h > 0.0f && i4 < aIRMapGSUrlTileProvider.f46595h) {
                    return null;
                }
                double dPow = 4.007501669578488E7d / Math.pow(2.0d, i4);
                double[] dArr = MapWMSTile.r;
                double d2 = dArr[0];
                double d3 = dArr[1];
                double[] dArr2 = {(i2 * dPow) + d2, d3 - ((i3 + 1) * dPow), ((i2 + 1) * dPow) + d2, d3 - (i3 * dPow)};
                String strReplace = this.f46660d.replace("{minX}", Double.toString(dArr2[0])).replace("{minY}", Double.toString(dArr2[1])).replace("{maxX}", Double.toString(dArr2[2])).replace("{maxY}", Double.toString(dArr2[3]));
                int i5 = this.f46661e;
                try {
                    return new URL(strReplace.replace("{width}", Integer.toString(i5)).replace("{height}", Integer.toString(i5)));
                } catch (MalformedURLException e2) {
                    throw new AssertionError(e2);
                }
            }
        }

        public AIRMapGSUrlTileProvider(int i2, String str, int i3, int i4, int i5, String str2, int i6, boolean z, ThemedReactContext themedReactContext, boolean z2) {
            super(i2, false, str, i3, i4, i5, false, str2, i6, z, themedReactContext, z2);
            this.f46589b = new AIRMapWMSTileProvider(i2, i2, str);
        }
    }

    @Override // com.rnmaps.maps.MapUrlTile
    public final TileOverlayOptions k() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.s(this.f46611e);
        tileOverlayOptions.r(1.0f - this.o);
        tileOverlayOptions.b(new AIRMapGSUrlTileProvider((int) this.f46616j, this.f46610d, (int) this.f46612f, (int) this.f46613g, (int) this.f46614h, this.f46618l, (int) this.f46619m, this.n, this.p, this.q));
        return tileOverlayOptions;
    }
}
