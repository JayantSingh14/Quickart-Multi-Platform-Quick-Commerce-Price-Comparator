package com.google.maps.android.data.kml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
class KmlContainerParser {
    public static KmlContainer a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, NumberFormatException {
        String name = xmlPullParser.getName();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashMap map4 = new HashMap();
        HashMap map5 = new HashMap();
        if (xmlPullParser.getAttributeValue(null, CLConstants.SHARED_PREFERENCE_ITEM_ID) != null) {
            xmlPullParser.getAttributeValue(null, CLConstants.SHARED_PREFERENCE_ITEM_ID);
        }
        xmlPullParser.next();
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals(name)) {
                return new KmlContainer(map, map2, map3, map4, arrayList, map5);
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                    KmlParser.a(xmlPullParser);
                } else if (xmlPullParser.getName().matches("Folder|Document")) {
                    arrayList.add(a(xmlPullParser));
                } else if (xmlPullParser.getName().matches("name|description|visibility|open|address|phoneNumber")) {
                    map.put(xmlPullParser.getName(), xmlPullParser.nextText());
                } else if (xmlPullParser.getName().equals("StyleMap")) {
                    map4.putAll(KmlStyleParser.b(xmlPullParser));
                } else if (xmlPullParser.getName().equals("Style")) {
                    if (xmlPullParser.getAttributeValue(null, CLConstants.SHARED_PREFERENCE_ITEM_ID) != null) {
                        KmlStyle kmlStyleA = KmlStyleParser.a(xmlPullParser);
                        map2.put(kmlStyleA.f45586j, kmlStyleA);
                    }
                } else if (xmlPullParser.getName().equals("Placemark")) {
                    map3.put(KmlFeatureParser.e(xmlPullParser), null);
                } else if (xmlPullParser.getName().equals("ExtendedData")) {
                    int eventType2 = xmlPullParser.getEventType();
                    String attributeValue = null;
                    while (true) {
                        if (eventType2 != 3 || !xmlPullParser.getName().equals("ExtendedData")) {
                            if (eventType2 == 2) {
                                if (xmlPullParser.getName().equals("Data")) {
                                    attributeValue = xmlPullParser.getAttributeValue(null, CLConstants.FIELD_PAY_INFO_NAME);
                                } else if (xmlPullParser.getName().equals(CLConstants.FIELD_PAY_INFO_VALUE) && attributeValue != null) {
                                    map.put(attributeValue, xmlPullParser.nextText());
                                    attributeValue = null;
                                }
                            }
                            eventType2 = xmlPullParser.next();
                        }
                    }
                } else if (xmlPullParser.getName().equals("GroundOverlay")) {
                    map5.put(KmlFeatureParser.d(xmlPullParser), null);
                }
            }
            eventType = xmlPullParser.next();
        }
    }
}
