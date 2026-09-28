package com.google.maps.android.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.maps.android.R;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.GroundOverlayManager.Collection;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.MarkerManager.Collection;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolygonManager.Collection;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.collections.PolylineManager.Collection;
import com.google.maps.android.data.geojson.BiMultiMap;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonGeometryCollection;
import com.google.maps.android.data.geojson.GeoJsonLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiPoint;
import com.google.maps.android.data.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.data.geojson.GeoJsonPoint;
import com.google.maps.android.data.geojson.GeoJsonPolygon;
import com.google.maps.android.data.kml.KmlMultiGeometry;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPoint;
import com.google.maps.android.data.kml.KmlStyle;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class Renderer {
    public static final DecimalFormat r = new DecimalFormat("#.####");

    /* renamed from: a, reason: collision with root package name */
    public final GoogleMap f45531a;

    /* renamed from: b, reason: collision with root package name */
    public final BiMultiMap f45532b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f45533c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f45534d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f45535e;

    /* renamed from: f, reason: collision with root package name */
    public final BiMultiMap f45536f;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f45537g;

    /* renamed from: h, reason: collision with root package name */
    public final HashSet f45538h;

    /* renamed from: i, reason: collision with root package name */
    public final ImagesCache f45539i;

    /* renamed from: j, reason: collision with root package name */
    public int f45540j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f45541k;

    /* renamed from: l, reason: collision with root package name */
    public final Context f45542l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f45543m;
    public final MarkerManager.Collection n;
    public final PolygonManager.Collection o;
    public final PolylineManager.Collection p;
    public final GroundOverlayManager.Collection q;

    public static final class ImagesCache {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f45545a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f45546b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f45547c = new HashMap();
    }

    public Renderer(GoogleMap googleMap, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        HashSet hashSet = new HashSet();
        BiMultiMap biMultiMap = new BiMultiMap();
        this.f45532b = new BiMultiMap();
        this.f45540j = 0;
        this.f45531a = googleMap;
        this.f45541k = false;
        this.f45538h = hashSet;
        this.f45536f = biMultiMap;
        if (googleMap != null) {
            this.n = (markerManager == null ? new MarkerManager(googleMap) : markerManager).new Collection();
            this.o = (polygonManager == null ? new PolygonManager(googleMap) : polygonManager).new Collection();
            this.p = (polylineManager == null ? new PolylineManager(googleMap) : polylineManager).new Collection();
            this.q = (groundOverlayManager == null ? new GroundOverlayManager(googleMap) : groundOverlayManager).new Collection();
        } else {
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = null;
        }
        this.f45542l = context;
        this.f45534d = new HashMap();
        this.f45539i = new ImagesCache();
    }

    public static void f(HashMap map, HashMap map2) {
        for (String str : map.keySet()) {
            String str2 = (String) map.get(str);
            if (map2.containsKey(str2)) {
                map2.put(str, (KmlStyle) map2.get(str2));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.google.maps.android.data.Feature r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.google.maps.android.data.geojson.GeoJsonFeature
            if (r0 != 0) goto L6d
            boolean r0 = r9.f45541k
            r1 = 0
            com.google.maps.android.data.geojson.BiMultiMap r2 = r9.f45532b
            if (r0 == 0) goto L68
            boolean r0 = r2.containsKey(r10)
            if (r0 == 0) goto L18
            java.lang.Object r0 = r2.get(r10)
            r9.i(r0)
        L18:
            boolean r0 = r10.c()
            if (r0 == 0) goto L68
            boolean r0 = r10 instanceof com.google.maps.android.data.kml.KmlPlacemark
            if (r0 == 0) goto L60
            java.util.HashMap r0 = r10.f45525b
            java.lang.String r3 = "visibility"
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L39
            java.lang.String r0 = r10.b(r3)
            int r0 = java.lang.Integer.parseInt(r0)
            if (r0 != 0) goto L39
            r0 = 0
        L37:
            r8 = r0
            goto L3b
        L39:
            r0 = 1
            goto L37
        L3b:
            java.lang.String r0 = r10.f45524a
            java.util.HashMap r3 = r9.f45534d
            java.lang.Object r1 = r3.get(r1)
            com.google.maps.android.data.kml.KmlStyle r1 = (com.google.maps.android.data.kml.KmlStyle) r1
            java.lang.Object r4 = r3.get(r0)
            if (r4 == 0) goto L52
            java.lang.Object r0 = r3.get(r0)
            r1 = r0
            com.google.maps.android.data.kml.KmlStyle r1 = (com.google.maps.android.data.kml.KmlStyle) r1
        L52:
            r6 = r1
            r4 = r10
            com.google.maps.android.data.kml.KmlPlacemark r4 = (com.google.maps.android.data.kml.KmlPlacemark) r4
            com.google.maps.android.data.Geometry r5 = r10.f45526c
            com.google.maps.android.data.kml.KmlStyle r7 = r4.f45573e
            r3 = r9
            java.lang.Object r1 = r3.c(r4, r5, r6, r7, r8)
            goto L69
        L60:
            r3 = r9
            com.google.maps.android.data.Geometry r0 = r10.f45526c
            java.lang.Object r1 = r9.b(r10, r0)
            goto L69
        L68:
            r3 = r9
        L69:
            r2.put(r10, r1)
            return
        L6d:
            r3 = r9
            com.google.maps.android.data.geojson.GeoJsonFeature r10 = (com.google.maps.android.data.geojson.GeoJsonFeature) r10
            r10.getClass()
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Point style cannot be null"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.Renderer.a(com.google.maps.android.data.Feature):void");
    }

    public final Object b(Feature feature, Geometry geometry) {
        PolygonOptions polygonOptionsF;
        KmlStyle kmlStyle;
        PolylineOptions polylineOptionsG;
        KmlStyle kmlStyle2;
        polylineOptionsG = null;
        polylineOptionsG = null;
        polygonOptionsF = null;
        polygonOptionsF = null;
        switch (geometry.a()) {
            case "MultiPolygon":
                ((GeoJsonFeature) feature).getClass();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = ((GeoJsonMultiPolygon) geometry).f45529a;
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList3.add((GeoJsonPolygon) ((Geometry) it.next()));
                }
                Iterator it2 = arrayList3.iterator();
                if (!it2.hasNext()) {
                    return arrayList;
                }
                throw null;
            case "MultiPoint":
                ((GeoJsonFeature) feature).getClass();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = ((GeoJsonMultiPoint) geometry).f45529a;
                ArrayList arrayList6 = new ArrayList();
                Iterator it3 = arrayList5.iterator();
                while (it3.hasNext()) {
                    arrayList6.add((GeoJsonPoint) ((Geometry) it3.next()));
                }
                Iterator it4 = arrayList6.iterator();
                if (!it4.hasNext()) {
                    return arrayList4;
                }
                throw null;
            case "MultiLineString":
                ((GeoJsonFeature) feature).getClass();
                ArrayList arrayList7 = new ArrayList();
                ArrayList arrayList8 = ((GeoJsonMultiLineString) geometry).f45529a;
                ArrayList arrayList9 = new ArrayList();
                Iterator it5 = arrayList8.iterator();
                while (it5.hasNext()) {
                    arrayList9.add((GeoJsonLineString) ((Geometry) it5.next()));
                }
                Iterator it6 = arrayList9.iterator();
                if (!it6.hasNext()) {
                    return arrayList7;
                }
                throw null;
            case "Point":
                if (feature instanceof GeoJsonFeature) {
                    ((GeoJsonFeature) feature).getClass();
                    throw null;
                }
                MarkerOptions markerOptionsF = feature instanceof KmlPlacemark ? ((KmlPlacemark) feature).f() : null;
                markerOptionsF.a2(((GeoJsonPoint) geometry).f45530a);
                return this.n.h(markerOptionsF);
            case "Polygon":
                if (feature instanceof GeoJsonFeature) {
                    ((GeoJsonFeature) feature).getClass();
                    throw null;
                }
                if ((feature instanceof KmlPlacemark) && (kmlStyle = ((KmlPlacemark) feature).f45573e) != null) {
                    polygonOptionsF = kmlStyle.f();
                }
                return e(polygonOptionsF, (DataPolygon) geometry);
            case "LineString":
                if (feature instanceof GeoJsonFeature) {
                    ((GeoJsonFeature) feature).getClass();
                    throw null;
                }
                if ((feature instanceof KmlPlacemark) && (kmlStyle2 = ((KmlPlacemark) feature).f45573e) != null) {
                    polylineOptionsG = kmlStyle2.g();
                }
                return d(polylineOptionsG, (GeoJsonLineString) geometry);
            case "GeometryCollection":
                GeoJsonFeature geoJsonFeature = (GeoJsonFeature) feature;
                ArrayList arrayList10 = ((GeoJsonGeometryCollection) geometry).f45529a;
                ArrayList arrayList11 = new ArrayList();
                Iterator it7 = arrayList10.iterator();
                while (it7.hasNext()) {
                    arrayList11.add(b(geoJsonFeature, (Geometry) it7.next()));
                }
                return arrayList11;
            default:
                return null;
        }
    }

    public final Object c(KmlPlacemark kmlPlacemark, Geometry geometry, KmlStyle kmlStyle, KmlStyle kmlStyle2, boolean z) {
        KmlStyle kmlStyle3;
        KmlStyle kmlStyle4;
        boolean z2;
        boolean zContainsKey;
        float f2;
        kmlStyle3 = kmlStyle;
        kmlStyle4 = kmlStyle2;
        z2 = z;
        String strA = geometry.a();
        zContainsKey = kmlPlacemark.f45525b.containsKey("drawOrder");
        f2 = 0.0f;
        if (zContainsKey) {
            try {
                f2 = Float.parseFloat(kmlPlacemark.b("drawOrder"));
            } catch (NumberFormatException unused) {
                zContainsKey = false;
            }
        }
        switch (strA) {
            case "Point":
                MarkerOptions markerOptionsE = kmlStyle3.e();
                HashSet hashSet = this.f45538h;
                if (kmlStyle4 != null) {
                    MarkerOptions markerOptionsE2 = kmlStyle4.e();
                    HashSet hashSet2 = kmlStyle4.f45581e;
                    if (hashSet2.contains("heading")) {
                        markerOptionsE.f38495j = markerOptionsE2.f38495j;
                    }
                    if (hashSet2.contains("hotSpot")) {
                        float f3 = markerOptionsE2.f38490e;
                        float f4 = markerOptionsE2.f38491f;
                        markerOptionsE.f38490e = f3;
                        markerOptionsE.f38491f = f4;
                    }
                    if (hashSet2.contains("markerColor")) {
                        markerOptionsE.f38489d = markerOptionsE2.f38489d;
                    }
                    double d2 = hashSet2.contains("iconScale") ? kmlStyle4.f45585i : kmlStyle3.f45581e.contains("iconScale") ? kmlStyle3.f45585i : 1.0d;
                    if (hashSet2.contains("iconUrl")) {
                        String str = kmlStyle4.f45584h;
                        BitmapDescriptor bitmapDescriptorH = h(str, d2);
                        if (bitmapDescriptorH != null) {
                            markerOptionsE.f38489d = bitmapDescriptorH;
                        } else {
                            hashSet.add(str);
                        }
                    } else {
                        String str2 = kmlStyle3.f45584h;
                        if (str2 != null) {
                            BitmapDescriptor bitmapDescriptorH2 = h(str2, d2);
                            if (bitmapDescriptorH2 != null) {
                                markerOptionsE.f38489d = bitmapDescriptorH2;
                            } else {
                                hashSet.add(str2);
                            }
                        }
                    }
                } else {
                    String str3 = kmlStyle3.f45584h;
                    if (str3 != null) {
                        BitmapDescriptor bitmapDescriptorH3 = h(str3, kmlStyle3.f45585i);
                        if (bitmapDescriptorH3 != null) {
                            markerOptionsE.f38489d = bitmapDescriptorH3;
                        } else {
                            hashSet.add(str3);
                        }
                    }
                }
                markerOptionsE.a2(((KmlPoint) geometry).f45530a);
                MarkerManager.Collection collection = this.n;
                Marker markerH = collection.h(markerOptionsE);
                markerH.getClass();
                try {
                    markerH.f38485a.Q1(z2);
                    HashMap map = kmlPlacemark.f45525b;
                    boolean zContainsKey2 = map.containsKey(CLConstants.FIELD_PAY_INFO_NAME);
                    boolean zContainsKey3 = map.containsKey("description");
                    HashMap map2 = kmlStyle3.f45580d;
                    boolean z3 = map2.size() > 0;
                    boolean zContainsKey4 = map2.containsKey("text");
                    if (z3 && zContainsKey4) {
                        String str4 = (String) map2.get("text");
                        StringBuffer stringBuffer = new StringBuffer();
                        Matcher matcher = Pattern.compile("\\$\\[(.+?)]").matcher(str4);
                        while (matcher.find()) {
                            String strB = kmlPlacemark.b(matcher.group(1));
                            if (strB != null) {
                                matcher.appendReplacement(stringBuffer, strB);
                            }
                        }
                        matcher.appendTail(stringBuffer);
                        markerH.m(stringBuffer.toString());
                        collection.f45518f = new GoogleMap.InfoWindowAdapter() { // from class: com.google.maps.android.data.Renderer.1
                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View c(Marker marker) {
                                zzad zzadVar = marker.f38485a;
                                View viewInflate = LayoutInflater.from(Renderer.this.f45542l).inflate(R.layout.amu_info_window, (ViewGroup) null);
                                TextView textView = (TextView) viewInflate.findViewById(R.id.window);
                                try {
                                    if (zzadVar.zzl() == null) {
                                        textView.setText(Html.fromHtml(marker.b()));
                                        return viewInflate;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(marker.b());
                                    sb.append("<br>");
                                    try {
                                        sb.append(zzadVar.zzl());
                                        textView.setText(Html.fromHtml(sb.toString()));
                                        return viewInflate;
                                    } catch (RemoteException e2) {
                                        throw new RuntimeRemoteException(e2);
                                    }
                                } catch (RemoteException e3) {
                                    throw new RuntimeRemoteException(e3);
                                }
                            }

                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View f(Marker marker) {
                                return null;
                            }
                        };
                    } else if (z3 && zContainsKey2) {
                        markerH.m(kmlPlacemark.b(CLConstants.FIELD_PAY_INFO_NAME));
                        collection.f45518f = new GoogleMap.InfoWindowAdapter() { // from class: com.google.maps.android.data.Renderer.1
                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View c(Marker marker) {
                                zzad zzadVar = marker.f38485a;
                                View viewInflate = LayoutInflater.from(Renderer.this.f45542l).inflate(R.layout.amu_info_window, (ViewGroup) null);
                                TextView textView = (TextView) viewInflate.findViewById(R.id.window);
                                try {
                                    if (zzadVar.zzl() == null) {
                                        textView.setText(Html.fromHtml(marker.b()));
                                        return viewInflate;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(marker.b());
                                    sb.append("<br>");
                                    try {
                                        sb.append(zzadVar.zzl());
                                        textView.setText(Html.fromHtml(sb.toString()));
                                        return viewInflate;
                                    } catch (RemoteException e2) {
                                        throw new RuntimeRemoteException(e2);
                                    }
                                } catch (RemoteException e3) {
                                    throw new RuntimeRemoteException(e3);
                                }
                            }

                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View f(Marker marker) {
                                return null;
                            }
                        };
                    } else if (zContainsKey2 && zContainsKey3) {
                        markerH.m(kmlPlacemark.b(CLConstants.FIELD_PAY_INFO_NAME));
                        markerH.l(kmlPlacemark.b("description"));
                        collection.f45518f = new GoogleMap.InfoWindowAdapter() { // from class: com.google.maps.android.data.Renderer.1
                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View c(Marker marker) {
                                zzad zzadVar = marker.f38485a;
                                View viewInflate = LayoutInflater.from(Renderer.this.f45542l).inflate(R.layout.amu_info_window, (ViewGroup) null);
                                TextView textView = (TextView) viewInflate.findViewById(R.id.window);
                                try {
                                    if (zzadVar.zzl() == null) {
                                        textView.setText(Html.fromHtml(marker.b()));
                                        return viewInflate;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(marker.b());
                                    sb.append("<br>");
                                    try {
                                        sb.append(zzadVar.zzl());
                                        textView.setText(Html.fromHtml(sb.toString()));
                                        return viewInflate;
                                    } catch (RemoteException e2) {
                                        throw new RuntimeRemoteException(e2);
                                    }
                                } catch (RemoteException e3) {
                                    throw new RuntimeRemoteException(e3);
                                }
                            }

                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View f(Marker marker) {
                                return null;
                            }
                        };
                    } else if (zContainsKey3) {
                        markerH.m(kmlPlacemark.b("description"));
                        collection.f45518f = new GoogleMap.InfoWindowAdapter() { // from class: com.google.maps.android.data.Renderer.1
                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View c(Marker marker) {
                                zzad zzadVar = marker.f38485a;
                                View viewInflate = LayoutInflater.from(Renderer.this.f45542l).inflate(R.layout.amu_info_window, (ViewGroup) null);
                                TextView textView = (TextView) viewInflate.findViewById(R.id.window);
                                try {
                                    if (zzadVar.zzl() == null) {
                                        textView.setText(Html.fromHtml(marker.b()));
                                        return viewInflate;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(marker.b());
                                    sb.append("<br>");
                                    try {
                                        sb.append(zzadVar.zzl());
                                        textView.setText(Html.fromHtml(sb.toString()));
                                        return viewInflate;
                                    } catch (RemoteException e2) {
                                        throw new RuntimeRemoteException(e2);
                                    }
                                } catch (RemoteException e3) {
                                    throw new RuntimeRemoteException(e3);
                                }
                            }

                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View f(Marker marker) {
                                return null;
                            }
                        };
                    } else if (zContainsKey2) {
                        markerH.m(kmlPlacemark.b(CLConstants.FIELD_PAY_INFO_NAME));
                        collection.f45518f = new GoogleMap.InfoWindowAdapter() { // from class: com.google.maps.android.data.Renderer.1
                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View c(Marker marker) {
                                zzad zzadVar = marker.f38485a;
                                View viewInflate = LayoutInflater.from(Renderer.this.f45542l).inflate(R.layout.amu_info_window, (ViewGroup) null);
                                TextView textView = (TextView) viewInflate.findViewById(R.id.window);
                                try {
                                    if (zzadVar.zzl() == null) {
                                        textView.setText(Html.fromHtml(marker.b()));
                                        return viewInflate;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(marker.b());
                                    sb.append("<br>");
                                    try {
                                        sb.append(zzadVar.zzl());
                                        textView.setText(Html.fromHtml(sb.toString()));
                                        return viewInflate;
                                    } catch (RemoteException e2) {
                                        throw new RuntimeRemoteException(e2);
                                    }
                                } catch (RemoteException e3) {
                                    throw new RuntimeRemoteException(e3);
                                }
                            }

                            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
                            public final View f(Marker marker) {
                                return null;
                            }
                        };
                    }
                    if (zContainsKey) {
                        markerH.n(f2);
                    }
                    return markerH;
                } catch (RemoteException e2) {
                    throw new RuntimeRemoteException(e2);
                }
            case "MultiGeometry":
                ArrayList arrayList = new ArrayList();
                Iterator it = new ArrayList(((KmlMultiGeometry) geometry).f45529a).iterator();
                while (it.hasNext()) {
                    arrayList.add(c(kmlPlacemark, (Geometry) it.next(), kmlStyle3, kmlStyle4, z2));
                    kmlStyle3 = kmlStyle3;
                    kmlStyle4 = kmlStyle4;
                    z2 = z2;
                }
                return arrayList;
            case "Polygon":
                PolygonOptions polygonOptionsF = kmlStyle3.f();
                if (kmlStyle4 != null) {
                    PolygonOptions polygonOptionsF2 = kmlStyle4.f();
                    boolean z4 = kmlStyle4.f45582f;
                    HashSet hashSet3 = kmlStyle4.f45581e;
                    if (z4 && hashSet3.contains("fillColor")) {
                        polygonOptionsF.f38516e = polygonOptionsF2.f38516e;
                    }
                    if (kmlStyle4.f45583g) {
                        if (hashSet3.contains("outlineColor")) {
                            polygonOptionsF.f38515d = polygonOptionsF2.f38515d;
                        }
                        if (hashSet3.contains(Snapshot.WIDTH)) {
                            polygonOptionsF.f38514c = polygonOptionsF2.f38514c;
                        }
                    }
                    if (kmlStyle4.f45589m) {
                        polygonOptionsF.f38516e = KmlStyle.b(polygonOptionsF2.f38516e);
                    }
                } else if (kmlStyle3.f45589m) {
                    polygonOptionsF.f38516e = KmlStyle.b(polygonOptionsF.f38516e);
                }
                Polygon polygonE = e(polygonOptionsF, (DataPolygon) geometry);
                try {
                    polygonE.f38511a.C0(z2);
                    if (zContainsKey) {
                        polygonE.i(f2);
                    }
                    return polygonE;
                } catch (RemoteException e3) {
                    throw new RuntimeRemoteException(e3);
                }
            case "LineString":
                PolylineOptions polylineOptionsG = kmlStyle3.g();
                if (kmlStyle4 != null) {
                    PolylineOptions polylineOptionsG2 = kmlStyle4.g();
                    HashSet hashSet4 = kmlStyle4.f45581e;
                    if (hashSet4.contains("outlineColor")) {
                        polylineOptionsG.f38526c = polylineOptionsG2.f38526c;
                    }
                    if (hashSet4.contains(Snapshot.WIDTH)) {
                        polylineOptionsG.f38525b = polylineOptionsG2.f38525b;
                    }
                    if (kmlStyle4.f45588l) {
                        polylineOptionsG.f38526c = KmlStyle.b(polylineOptionsG2.f38526c);
                    }
                } else if (kmlStyle3.f45588l) {
                    polylineOptionsG.f38526c = KmlStyle.b(polylineOptionsG.f38526c);
                }
                Polyline polylineD = d(polylineOptionsG, (LineString) geometry);
                try {
                    polylineD.f38523a.w0(z2);
                    if (zContainsKey) {
                        polylineD.i(f2);
                    }
                    return polylineD;
                } catch (RemoteException e4) {
                    throw new RuntimeRemoteException(e4);
                }
            default:
                return null;
        }
    }

    public final Polyline d(PolylineOptions polylineOptions, LineString lineString) {
        polylineOptions.b(lineString.d());
        Polyline polylineH = this.p.h(polylineOptions);
        polylineH.a(polylineOptions.f38530g);
        return polylineH;
    }

    public final Polygon e(PolygonOptions polygonOptions, DataPolygon dataPolygon) {
        polygonOptions.b(dataPolygon.b());
        Iterator it = dataPolygon.c().iterator();
        while (it.hasNext()) {
            polygonOptions.r((List) it.next());
        }
        Polygon polygonH = this.o.h(polygonOptions);
        polygonH.a(polygonOptions.f38520i);
        return polygonH;
    }

    public final BitmapDescriptor g(String str) {
        Bitmap bitmap;
        ImagesCache imagesCache = this.f45539i;
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) imagesCache.f45546b.get(str);
        if (bitmapDescriptor != null || (bitmap = (Bitmap) imagesCache.f45547c.get(str)) == null) {
            return bitmapDescriptor;
        }
        BitmapDescriptor bitmapDescriptorC = BitmapDescriptorFactory.c(bitmap);
        imagesCache.f45546b.put(str, bitmapDescriptorC);
        return bitmapDescriptorC;
    }

    public final BitmapDescriptor h(String str, double d2) {
        Bitmap bitmap;
        int i2;
        String str2 = r.format(d2);
        ImagesCache imagesCache = this.f45539i;
        Map map = (Map) imagesCache.f45545a.get(str);
        BitmapDescriptor bitmapDescriptor = map != null ? (BitmapDescriptor) map.get(str2) : null;
        if (bitmapDescriptor != null || (bitmap = (Bitmap) imagesCache.f45547c.get(str)) == null) {
            return bitmapDescriptor;
        }
        int i3 = (int) (this.f45542l.getResources().getDisplayMetrics().density * 32.0f * d2);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < height) {
            i2 = (int) ((height * i3) / width);
        } else if (width > height) {
            int i4 = (int) ((width * i3) / height);
            i2 = i3;
            i3 = i4;
        } else {
            i2 = i3;
        }
        BitmapDescriptor bitmapDescriptorC = BitmapDescriptorFactory.c(Bitmap.createScaledBitmap(bitmap, i3, i2, false));
        HashMap map2 = imagesCache.f45545a;
        Map map3 = (Map) map2.get(str);
        if (map3 == null) {
            map3 = new HashMap();
            map2.put(str, map3);
        }
        map3.put(str2, bitmapDescriptorC);
        return bitmapDescriptorC;
    }

    public final void i(Object obj) {
        if (obj instanceof Marker) {
            this.n.g((Marker) obj);
            return;
        }
        if (obj instanceof Polyline) {
            this.p.g((Polyline) obj);
            return;
        }
        if (obj instanceof Polygon) {
            this.o.g((Polygon) obj);
        } else if (obj instanceof GroundOverlay) {
            this.q.g((GroundOverlay) obj);
        } else if (obj instanceof ArrayList) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                i(it.next());
            }
        }
    }
}
