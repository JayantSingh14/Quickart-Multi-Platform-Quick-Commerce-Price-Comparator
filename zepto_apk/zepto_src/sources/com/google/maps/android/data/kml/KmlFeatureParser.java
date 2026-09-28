package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import j$.util.DesugarTimeZone;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
class KmlFeatureParser {

    public static class LatLngAlt {

        /* renamed from: a, reason: collision with root package name */
        public final LatLng f45561a;

        /* renamed from: b, reason: collision with root package name */
        public final Double f45562b;

        public LatLngAlt(LatLng latLng, Double d2) {
            this.f45561a = latLng;
            this.f45562b = d2;
        }
    }

    public static LatLngAlt a(String str, String str2) throws NumberFormatException {
        String[] strArrSplit = str.split(str2);
        if (strArrSplit.length < 2) {
            throw new IllegalArgumentException("Wrong coordinate, latitude and longitude must be set");
        }
        return new LatLngAlt(new LatLng(Double.parseDouble(strArrSplit[1]), Double.parseDouble(strArrSplit[0])), strArrSplit.length > 2 ? Double.valueOf(Double.parseDouble(strArrSplit[2])) : null);
    }

    public static ArrayList b(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split("(\\s+)")) {
            arrayList.add(a(str2, ","));
        }
        return arrayList;
    }

    public static Geometry c(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException, NumberFormatException {
        int eventType = xmlPullParser.getEventType();
        while (true) {
            LatLngAlt latLngAltA = null;
            if (eventType == 3 && xmlPullParser.getName().equals(str)) {
                return null;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Point")) {
                    int eventType2 = xmlPullParser.getEventType();
                    while (true) {
                        if (eventType2 == 3 && xmlPullParser.getName().equals("Point")) {
                            return new KmlPoint(latLngAltA.f45561a);
                        }
                        if (eventType2 == 2 && xmlPullParser.getName().equals("coordinates")) {
                            latLngAltA = a(xmlPullParser.nextText(), ",");
                        }
                        eventType2 = xmlPullParser.next();
                    }
                } else if (xmlPullParser.getName().equals("LineString")) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int eventType3 = xmlPullParser.getEventType();
                    while (true) {
                        if (eventType3 == 3 && xmlPullParser.getName().equals("LineString")) {
                            return new KmlLineString(arrayList);
                        }
                        if (eventType3 == 2 && xmlPullParser.getName().equals("coordinates")) {
                            Iterator it = b(xmlPullParser.nextText()).iterator();
                            while (it.hasNext()) {
                                LatLngAlt latLngAlt = (LatLngAlt) it.next();
                                arrayList.add(latLngAlt.f45561a);
                                Double d2 = latLngAlt.f45562b;
                                if (d2 != null) {
                                    arrayList2.add(d2);
                                }
                            }
                        }
                        eventType3 = xmlPullParser.next();
                    }
                } else {
                    if (xmlPullParser.getName().equals("Track")) {
                        return f(xmlPullParser);
                    }
                    if (xmlPullParser.getName().equals("Polygon")) {
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        int eventType4 = xmlPullParser.getEventType();
                        boolean zEquals = false;
                        while (true) {
                            if (eventType4 == 3 && xmlPullParser.getName().equals("Polygon")) {
                                return new KmlPolygon(arrayList3, arrayList4);
                            }
                            if (eventType4 == 2) {
                                if (xmlPullParser.getName().matches("outerBoundaryIs|innerBoundaryIs")) {
                                    zEquals = xmlPullParser.getName().equals("outerBoundaryIs");
                                } else if (xmlPullParser.getName().equals("coordinates")) {
                                    if (zEquals) {
                                        ArrayList arrayListB = b(xmlPullParser.nextText());
                                        ArrayList arrayList5 = new ArrayList();
                                        Iterator it2 = arrayListB.iterator();
                                        while (it2.hasNext()) {
                                            arrayList5.add(((LatLngAlt) it2.next()).f45561a);
                                        }
                                        arrayList3 = arrayList5;
                                    } else {
                                        ArrayList arrayListB2 = b(xmlPullParser.nextText());
                                        ArrayList arrayList6 = new ArrayList();
                                        Iterator it3 = arrayListB2.iterator();
                                        while (it3.hasNext()) {
                                            arrayList6.add(((LatLngAlt) it3.next()).f45561a);
                                        }
                                        arrayList4.add(arrayList6);
                                    }
                                }
                            }
                            eventType4 = xmlPullParser.next();
                        }
                    } else if (xmlPullParser.getName().equals("MultiGeometry")) {
                        ArrayList arrayList7 = new ArrayList();
                        int next = xmlPullParser.next();
                        while (true) {
                            if (next == 3 && xmlPullParser.getName().equals("MultiGeometry")) {
                                return new KmlMultiGeometry(arrayList7);
                            }
                            if (next == 2 && xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry|Track|MultiTrack")) {
                                arrayList7.add(c(xmlPullParser, xmlPullParser.getName()));
                            }
                            next = xmlPullParser.next();
                        }
                    } else if (xmlPullParser.getName().equals("MultiTrack")) {
                        ArrayList arrayList8 = new ArrayList();
                        int next2 = xmlPullParser.next();
                        while (true) {
                            if (next2 == 3 && xmlPullParser.getName().equals("MultiTrack")) {
                                break;
                            }
                            if (next2 == 2 && xmlPullParser.getName().matches("Track")) {
                                arrayList8.add(f(xmlPullParser));
                            }
                            next2 = xmlPullParser.next();
                        }
                        ArrayList arrayList9 = new ArrayList();
                        Iterator it4 = arrayList8.iterator();
                        while (it4.hasNext()) {
                            arrayList9.add((KmlTrack) it4.next());
                        }
                        return new KmlMultiTrack(arrayList9);
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public static KmlGroundOverlay d(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, NumberFormatException {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int eventType = xmlPullParser.getEventType();
        float f2 = 0.0f;
        String strNextText = null;
        int i2 = 1;
        float f3 = 0.0f;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("GroundOverlay")) {
                Double d2 = (Double) map2.get("north");
                return new KmlGroundOverlay(strNextText, new LatLngBounds(new LatLng(((Double) map2.get("south")).doubleValue(), ((Double) map2.get("west")).doubleValue()), new LatLng(d2.doubleValue(), ((Double) map2.get("east")).doubleValue())), f3, i2, map, f2);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Icon")) {
                    int eventType2 = xmlPullParser.getEventType();
                    while (true) {
                        if (eventType2 != 3 || !xmlPullParser.getName().equals("Icon")) {
                            if (eventType2 == 2 && xmlPullParser.getName().equals("href")) {
                                strNextText = xmlPullParser.nextText();
                                break;
                            }
                            eventType2 = xmlPullParser.next();
                        } else {
                            strNextText = null;
                            break;
                        }
                    }
                } else if (xmlPullParser.getName().equals("drawOrder")) {
                    f3 = Float.parseFloat(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("visibility")) {
                    i2 = Integer.parseInt(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    map.putAll(g(xmlPullParser));
                } else if (xmlPullParser.getName().equals("rotation")) {
                    f2 = -Float.parseFloat(xmlPullParser.nextText());
                } else if (xmlPullParser.getName().matches("name|description|drawOrder|visibility|open|address|phoneNumber") || xmlPullParser.getName().equals("color")) {
                    map.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().matches("north|south|east|west")) {
                    map2.put(xmlPullParser.getName(), Double.valueOf(Double.parseDouble(xmlPullParser.nextText())));
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public static KmlPlacemark e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, NumberFormatException {
        HashMap map = new HashMap();
        int eventType = xmlPullParser.getEventType();
        Geometry geometryC = null;
        String strNextText = null;
        KmlStyle kmlStyleA = null;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Placemark")) {
                return new KmlPlacemark(geometryC, strNextText, kmlStyleA, map);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("styleUrl")) {
                    strNextText = xmlPullParser.nextText();
                } else if (xmlPullParser.getName().matches("Point|LineString|Polygon|MultiGeometry|Track|MultiTrack")) {
                    geometryC = c(xmlPullParser, xmlPullParser.getName());
                } else if (xmlPullParser.getName().matches("name|description|drawOrder|visibility|open|address|phoneNumber")) {
                    map.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    map.putAll(g(xmlPullParser));
                } else if (xmlPullParser.getName().equals("Style")) {
                    kmlStyleA = KmlStyleParser.a(xmlPullParser);
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public static KmlTrack f(XmlPullParser xmlPullParser) throws XmlPullParserException, NumberFormatException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap map = new HashMap();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Track")) {
                return new KmlTrack(arrayList);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("coord")) {
                    LatLngAlt latLngAltA = a(xmlPullParser.nextText(), StringUtils.SPACE);
                    arrayList.add(latLngAltA.f45561a);
                    Double d2 = latLngAltA.f45562b;
                    if (d2 != null) {
                        arrayList2.add(d2);
                    }
                } else if (xmlPullParser.getName().equals("when")) {
                    try {
                        arrayList3.add(Long.valueOf(simpleDateFormat.parse(xmlPullParser.nextText()).getTime()));
                    } catch (ParseException e2) {
                        throw new XmlPullParserException("Invalid date", xmlPullParser, e2);
                    }
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    map.putAll(g(xmlPullParser));
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public static HashMap g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        int eventType = xmlPullParser.getEventType();
        String attributeValue = null;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("ExtendedData")) {
                return map;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("Data")) {
                    attributeValue = xmlPullParser.getAttributeValue(null, CLConstants.FIELD_PAY_INFO_NAME);
                } else if (xmlPullParser.getName().equals(CLConstants.FIELD_PAY_INFO_VALUE) && attributeValue != null) {
                    map.put(attributeValue, xmlPullParser.nextText());
                    attributeValue = null;
                }
            }
            eventType = xmlPullParser.next();
        }
    }
}
