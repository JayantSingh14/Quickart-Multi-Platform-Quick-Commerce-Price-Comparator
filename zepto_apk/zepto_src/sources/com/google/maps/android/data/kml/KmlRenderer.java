package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import com.google.maps.android.data.Renderer;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class KmlRenderer extends Renderer {
    public static final /* synthetic */ int w = 0;
    public final HashSet s;
    public boolean t;
    public boolean u;
    public ArrayList v;

    public class GroundOverlayImageDownload extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final String f45576a;

        public GroundOverlayImageDownload(String str) {
            this.f45576a = str;
            int i2 = KmlRenderer.w;
            KmlRenderer.this.f45540j++;
        }

        @Override // android.os.AsyncTask
        public final Bitmap doInBackground(String[] strArr) {
            String str = this.f45576a;
            try {
                return KmlRenderer.j(KmlRenderer.this, str);
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(str);
            } catch (IOException e2) {
                Log.e("KmlRenderer", "Image [" + str + "] download issue", e2);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Bitmap bitmap) {
            Renderer.ImagesCache imagesCache;
            Bitmap bitmap2 = bitmap;
            KmlRenderer kmlRenderer = KmlRenderer.this;
            String str = this.f45576a;
            if (bitmap2 == null) {
                Log.e("KmlRenderer", "Image at this URL could not be found " + str);
            } else {
                int i2 = KmlRenderer.w;
                kmlRenderer.f45539i.f45547c.put(str, bitmap2);
                if (kmlRenderer.f45541k) {
                    kmlRenderer.n(str, kmlRenderer.f45537g, true);
                    kmlRenderer.m(str, kmlRenderer.v, true);
                }
            }
            int i3 = KmlRenderer.w;
            int i4 = kmlRenderer.f45540j - 1;
            kmlRenderer.f45540j = i4;
            if (i4 != 0 || (imagesCache = kmlRenderer.f45539i) == null) {
                return;
            }
            HashMap map = imagesCache.f45547c;
            if (map.isEmpty()) {
                return;
            }
            map.clear();
        }
    }

    public class MarkerIconImageDownload extends AsyncTask<String, Void, Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final String f45578a;

        public MarkerIconImageDownload(String str) {
            this.f45578a = str;
            int i2 = KmlRenderer.w;
            KmlRenderer.this.f45540j++;
        }

        @Override // android.os.AsyncTask
        public final Bitmap doInBackground(String[] strArr) {
            String str = this.f45578a;
            try {
                return KmlRenderer.j(KmlRenderer.this, str);
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(str);
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Bitmap bitmap) {
            Renderer.ImagesCache imagesCache;
            Bitmap bitmap2 = bitmap;
            KmlRenderer kmlRenderer = KmlRenderer.this;
            String str = this.f45578a;
            if (bitmap2 == null) {
                Log.e("KmlRenderer", "Image at this URL could not be found " + str);
            } else {
                int i2 = KmlRenderer.w;
                kmlRenderer.f45539i.f45547c.put(str, bitmap2);
                if (kmlRenderer.f45541k) {
                    kmlRenderer.q(str, kmlRenderer.f45532b);
                    kmlRenderer.k(str, kmlRenderer.v);
                }
            }
            int i3 = KmlRenderer.w;
            int i4 = kmlRenderer.f45540j - 1;
            kmlRenderer.f45540j = i4;
            if (i4 != 0 || (imagesCache = kmlRenderer.f45539i) == null) {
                return;
            }
            HashMap map = imagesCache.f45547c;
            if (map.isEmpty()) {
                return;
            }
            map.clear();
        }
    }

    public KmlRenderer(GoogleMap googleMap, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        super(googleMap, context, markerManager, polygonManager, polylineManager, groundOverlayManager);
        this.s = new HashSet();
        this.t = false;
        this.u = false;
    }

    public static Bitmap j(KmlRenderer kmlRenderer, String str) throws IOException {
        InputStream inputStream;
        boolean z;
        HttpURLConnection httpURLConnection;
        int responseCode;
        kmlRenderer.getClass();
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        int i2 = 0;
        do {
            if (uRLConnectionOpenConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) uRLConnectionOpenConnection).setInstanceFollowRedirects(false);
            }
            inputStream = uRLConnectionOpenConnection.getInputStream();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection) || (responseCode = (httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection).getResponseCode()) < 300 || responseCode > 307 || responseCode == 306 || responseCode == 304) {
                z = false;
            } else {
                URL url = httpURLConnection.getURL();
                String headerField = httpURLConnection.getHeaderField("Location");
                URL url2 = headerField != null ? new URL(url, headerField) : null;
                httpURLConnection.disconnect();
                if (url2 == null || (!(url2.getProtocol().equals("http") || url2.getProtocol().equals("https")) || i2 >= 5)) {
                    throw new SecurityException("illegal URL redirect");
                }
                uRLConnectionOpenConnection = url2.openConnection();
                i2++;
                z = true;
            }
        } while (z);
        return BitmapFactory.decodeStream(inputStream);
    }

    public static boolean r(KmlContainer kmlContainer, boolean z) {
        return z && (!kmlContainer.f45555a.containsKey("visibility") || Integer.parseInt((String) kmlContainer.f45555a.get("visibility")) != 0);
    }

    public final void k(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            q(str, kmlContainer.f45556b);
            ArrayList arrayList2 = kmlContainer.f45557c;
            if (arrayList2.size() > 0) {
                k(str, arrayList2);
            }
        }
    }

    public final void l(ArrayList arrayList, boolean z) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            boolean zR = r(kmlContainer, z);
            HashMap map = this.f45534d;
            map.putAll(kmlContainer.f45560f);
            Renderer.f(kmlContainer.f45559e, map);
            HashMap map2 = kmlContainer.f45556b;
            for (Feature feature : map2.keySet()) {
                boolean z2 = zR && (!feature.f45525b.containsKey("visibility") || Integer.parseInt(feature.b("visibility")) != 0);
                Geometry geometry = feature.f45526c;
                if (geometry != null) {
                    String str = feature.f45524a;
                    HashMap map3 = this.f45534d;
                    KmlStyle kmlStyle = (KmlStyle) map3.get(null);
                    if (map3.get(str) != null) {
                        kmlStyle = (KmlStyle) map3.get(str);
                    }
                    KmlPlacemark kmlPlacemark = (KmlPlacemark) feature;
                    Object objC = c(kmlPlacemark, geometry, kmlStyle, kmlPlacemark.f45573e, z2);
                    map2.put(kmlPlacemark, objC);
                    this.f45536f.put(feature, objC);
                }
            }
            ArrayList arrayList2 = kmlContainer.f45557c;
            if (arrayList2.size() > 0) {
                l(arrayList2, zR);
            }
        }
    }

    public final void m(String str, ArrayList arrayList, boolean z) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            boolean zR = r(kmlContainer, z);
            n(str, kmlContainer.f45558d, zR);
            ArrayList arrayList2 = kmlContainer.f45557c;
            if (arrayList2.size() > 0) {
                m(str, arrayList2, zR);
            }
        }
    }

    public final void n(String str, HashMap map, boolean z) {
        BitmapDescriptor bitmapDescriptorG = g(str);
        for (KmlGroundOverlay kmlGroundOverlay : map.keySet()) {
            if (kmlGroundOverlay.f45565c.equals(str)) {
                GroundOverlayOptions groundOverlayOptions = kmlGroundOverlay.f45564b;
                groundOverlayOptions.r(bitmapDescriptorG);
                GroundOverlay groundOverlayH = this.q.h(groundOverlayOptions);
                if (!z) {
                    groundOverlayH.f(false);
                }
                map.put(kmlGroundOverlay, groundOverlayH);
            }
        }
    }

    public final void o(ArrayList arrayList, HashMap map) {
        for (KmlGroundOverlay kmlGroundOverlay : map.keySet()) {
            String str = kmlGroundOverlay.f45565c;
            if (str != null && kmlGroundOverlay.f45566d != null) {
                if (g(str) != null) {
                    n(str, map, true);
                } else {
                    this.s.add(str);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            KmlContainer kmlContainer = (KmlContainer) it.next();
            o(kmlContainer.f45557c, kmlContainer.f45558d);
        }
    }

    public final void p(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, Geometry geometry, Object obj) {
        if (geometry == null) {
            return;
        }
        if (!"Point".equals(geometry.a())) {
            if ("MultiGeometry".equals(geometry.a())) {
                Iterator it = ((ArrayList) ((MultiGeometry) geometry).d()).iterator();
                Iterator it2 = ((List) obj).iterator();
                while (it.hasNext() && it2.hasNext()) {
                    p(str, kmlStyle, kmlStyle2, (Geometry) it.next(), it2.next());
                }
                return;
            }
            return;
        }
        Marker marker = (Marker) obj;
        boolean z = false;
        boolean z2 = kmlStyle2 != null && str.equals(kmlStyle2.f45584h);
        if (kmlStyle != null && str.equals(kmlStyle.f45584h)) {
            z = true;
        }
        if (z2) {
            marker.h(h(kmlStyle2.f45584h, kmlStyle2.f45585i));
        } else if (z) {
            marker.h(h(kmlStyle.f45584h, kmlStyle.f45585i));
        }
    }

    public final void q(String str, HashMap map) {
        for (Feature feature : map.keySet()) {
            p(str, (KmlStyle) this.f45534d.get(feature.f45524a), ((KmlPlacemark) feature).f45573e, feature.f45526c, map.get(feature));
        }
    }
}
