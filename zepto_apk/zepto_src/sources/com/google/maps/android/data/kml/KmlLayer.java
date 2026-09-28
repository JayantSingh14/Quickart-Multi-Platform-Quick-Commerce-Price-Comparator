package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.Renderer;
import com.google.maps.android.data.geojson.BiMultiMap;
import com.google.maps.android.data.kml.KmlRenderer.GroundOverlayImageDownload;
import com.google.maps.android.data.kml.KmlRenderer.MarkerIconImageDownload;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes4.dex */
public class KmlLayer extends Layer {
    public KmlLayer(GoogleMap googleMap, InputStream inputStream, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) throws IOException {
        KmlRenderer kmlRenderer = new KmlRenderer(googleMap, context, markerManager, polygonManager, polylineManager, groundOverlayManager);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.mark(1024);
        ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            BiMultiMap biMultiMap = kmlRenderer.f45532b;
            if (nextEntry != null) {
                HashMap map = new HashMap();
                KmlParser kmlParserC = null;
                while (nextEntry != null) {
                    if (kmlParserC == null && nextEntry.getName().toLowerCase().endsWith(".kml")) {
                        kmlParserC = c(zipInputStream);
                    } else {
                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(zipInputStream);
                        if (bitmapDecodeStream != null) {
                            map.put(nextEntry.getName(), bitmapDecodeStream);
                        } else {
                            Log.w("KmlLayer", "Unsupported KMZ contents file type: " + nextEntry.getName());
                        }
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                if (kmlParserC == null) {
                    throw new IllegalArgumentException("KML not found in InputStream");
                }
                HashMap map2 = kmlParserC.f45569c;
                HashMap map3 = kmlParserC.f45570d;
                HashMap map4 = kmlParserC.f45567a;
                ArrayList arrayList = kmlParserC.f45568b;
                HashMap map5 = kmlParserC.f45571e;
                kmlRenderer.f45533c = map2;
                kmlRenderer.f45535e = map3;
                biMultiMap.putAll(map4);
                kmlRenderer.f45543m = arrayList;
                kmlRenderer.f45537g = map5;
                for (Map.Entry entry : map.entrySet()) {
                    kmlRenderer.f45539i.f45547c.put((String) entry.getKey(), (Bitmap) entry.getValue());
                }
            } else {
                bufferedInputStream.reset();
                KmlParser kmlParserC2 = c(bufferedInputStream);
                HashMap map6 = kmlParserC2.f45569c;
                HashMap map7 = kmlParserC2.f45570d;
                HashMap map8 = kmlParserC2.f45567a;
                ArrayList arrayList2 = kmlParserC2.f45568b;
                HashMap map9 = kmlParserC2.f45571e;
                kmlRenderer.f45533c = map6;
                kmlRenderer.f45535e = map7;
                biMultiMap.putAll(map8);
                kmlRenderer.f45543m = arrayList2;
                kmlRenderer.f45537g = map9;
            }
            this.f45527a = kmlRenderer;
            inputStream.close();
            bufferedInputStream.close();
            zipInputStream.close();
        } catch (Throwable th) {
            inputStream.close();
            bufferedInputStream.close();
            zipInputStream.close();
            throw th;
        }
    }

    public static KmlParser c(FilterInputStream filterInputStream) throws XmlPullParserException, IOException, NumberFormatException {
        XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
        xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
        xmlPullParserNewPullParser.setInput(filterInputStream, null);
        KmlParser kmlParser = new KmlParser(xmlPullParserNewPullParser);
        int eventType = xmlPullParserNewPullParser.getEventType();
        while (true) {
            HashMap map = kmlParser.f45569c;
            if (eventType == 1) {
                map.put(null, new KmlStyle());
                return kmlParser;
            }
            if (eventType == 2) {
                if (xmlPullParserNewPullParser.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|NetworkLink|NetworkLinkControl|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                    KmlParser.a(xmlPullParserNewPullParser);
                }
                if (xmlPullParserNewPullParser.getName().matches("Folder|Document")) {
                    kmlParser.f45568b.add(KmlContainerParser.a(xmlPullParserNewPullParser));
                }
                if (xmlPullParserNewPullParser.getName().equals("Style")) {
                    KmlStyle kmlStyleA = KmlStyleParser.a(xmlPullParserNewPullParser);
                    map.put(kmlStyleA.f45586j, kmlStyleA);
                }
                if (xmlPullParserNewPullParser.getName().equals("StyleMap")) {
                    kmlParser.f45570d.putAll(KmlStyleParser.b(xmlPullParserNewPullParser));
                }
                if (xmlPullParserNewPullParser.getName().equals("Placemark")) {
                    kmlParser.f45567a.put(KmlFeatureParser.e(xmlPullParserNewPullParser), null);
                }
                if (xmlPullParserNewPullParser.getName().equals("GroundOverlay")) {
                    kmlParser.f45571e.put(KmlFeatureParser.d(xmlPullParserNewPullParser), null);
                }
            }
            eventType = xmlPullParserNewPullParser.next();
        }
    }

    public final void a() {
        Renderer.ImagesCache imagesCache;
        KmlRenderer kmlRenderer = this.f45527a;
        if (kmlRenderer == null) {
            throw new UnsupportedOperationException("Stored renderer is not a KmlRenderer");
        }
        kmlRenderer.f45541k = true;
        kmlRenderer.v = kmlRenderer.f45543m;
        HashMap map = kmlRenderer.f45534d;
        map.putAll(kmlRenderer.f45533c);
        Renderer.f(kmlRenderer.f45535e, map);
        kmlRenderer.o(kmlRenderer.v, kmlRenderer.f45537g);
        kmlRenderer.l(kmlRenderer.v, true);
        Iterator it = kmlRenderer.f45532b.keySet().iterator();
        while (it.hasNext()) {
            kmlRenderer.a((Feature) it.next());
        }
        if (!kmlRenderer.u) {
            kmlRenderer.u = true;
            Iterator it2 = kmlRenderer.s.iterator();
            while (it2.hasNext()) {
                kmlRenderer.new GroundOverlayImageDownload((String) it2.next()).execute(new String[0]);
                it2.remove();
            }
        }
        if (!kmlRenderer.t) {
            kmlRenderer.t = true;
            Iterator it3 = kmlRenderer.f45538h.iterator();
            while (it3.hasNext()) {
                kmlRenderer.new MarkerIconImageDownload((String) it3.next()).execute(new String[0]);
                it3.remove();
            }
        }
        if (kmlRenderer.f45540j != 0 || (imagesCache = kmlRenderer.f45539i) == null) {
            return;
        }
        HashMap map2 = imagesCache.f45547c;
        if (map2.isEmpty()) {
            return;
        }
        map2.clear();
    }

    public final ArrayList b() {
        KmlRenderer kmlRenderer = this.f45527a;
        if (kmlRenderer != null) {
            return kmlRenderer.v;
        }
        return null;
    }
}
