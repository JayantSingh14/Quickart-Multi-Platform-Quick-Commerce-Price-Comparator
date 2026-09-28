package com.google.maps.android.data.kml;

import android.graphics.Color;
import android.util.Log;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
class KmlStyleParser {
    public static KmlStyle a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException, NumberFormatException {
        KmlStyle kmlStyle = new KmlStyle();
        String attributeValue = xmlPullParser.getAttributeValue(null, CLConstants.SHARED_PREFERENCE_ITEM_ID);
        if (attributeValue != null) {
            kmlStyle.f45586j = "#".concat(attributeValue);
        }
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("Style")) {
                return kmlStyle;
            }
            if (eventType == 2) {
                boolean zEquals = xmlPullParser.getName().equals("IconStyle");
                HashSet hashSet = kmlStyle.f45581e;
                if (zEquals) {
                    int eventType2 = xmlPullParser.getEventType();
                    while (true) {
                        if (eventType2 != 3 || !xmlPullParser.getName().equals("IconStyle")) {
                            if (eventType2 == 2) {
                                if (xmlPullParser.getName().equals("heading")) {
                                    kmlStyle.f45548a.f38495j = Float.parseFloat(xmlPullParser.nextText());
                                    hashSet.add("heading");
                                } else if (xmlPullParser.getName().equals("Icon")) {
                                    int eventType3 = xmlPullParser.getEventType();
                                    while (true) {
                                        if (eventType3 == 3 && xmlPullParser.getName().equals("Icon")) {
                                            break;
                                        }
                                        if (eventType3 == 2 && xmlPullParser.getName().equals("href")) {
                                            kmlStyle.f45584h = xmlPullParser.nextText();
                                            hashSet.add("iconUrl");
                                        }
                                        eventType3 = xmlPullParser.next();
                                    }
                                } else if (xmlPullParser.getName().equals("hotSpot")) {
                                    try {
                                        try {
                                            kmlStyle.h(Float.parseFloat(xmlPullParser.getAttributeValue(null, "x")), Float.parseFloat(xmlPullParser.getAttributeValue(null, "y")), xmlPullParser.getAttributeValue(null, "xunits"), xmlPullParser.getAttributeValue(null, "yunits"));
                                        } catch (NullPointerException unused) {
                                            Log.w("KmlStyleParser", "Missing 'x' or 'y' attributes in hotSpot for style with id: " + kmlStyle.f45586j);
                                            eventType2 = xmlPullParser.next();
                                        } catch (NumberFormatException unused2) {
                                            Log.w("KmlStyleParser", "Invalid number in 'x' or 'y' attributes in hotSpot for style with id: " + kmlStyle.f45586j);
                                            eventType2 = xmlPullParser.next();
                                        }
                                    } catch (NullPointerException unused3) {
                                    } catch (NumberFormatException unused4) {
                                    }
                                } else if (xmlPullParser.getName().equals("scale")) {
                                    kmlStyle.f45585i = Double.parseDouble(xmlPullParser.nextText());
                                    hashSet.add("iconScale");
                                } else if (xmlPullParser.getName().equals("color")) {
                                    float[] fArr = new float[3];
                                    Color.colorToHSV(Color.parseColor("#" + KmlStyle.c(xmlPullParser.nextText())), fArr);
                                    float f2 = fArr[0];
                                    kmlStyle.n = f2;
                                    kmlStyle.f45548a.f38489d = BitmapDescriptorFactory.b(f2);
                                    hashSet.add("markerColor");
                                } else if (xmlPullParser.getName().equals("colorMode")) {
                                    kmlStyle.f45587k = xmlPullParser.nextText().equals("random");
                                    hashSet.add("iconColorMode");
                                }
                            }
                            eventType2 = xmlPullParser.next();
                        }
                    }
                } else if (xmlPullParser.getName().equals("LineStyle")) {
                    int eventType4 = xmlPullParser.getEventType();
                    while (true) {
                        if (eventType4 != 3 || !xmlPullParser.getName().equals("LineStyle")) {
                            if (eventType4 == 2) {
                                if (xmlPullParser.getName().equals("color")) {
                                    String strNextText = xmlPullParser.nextText();
                                    kmlStyle.f45549b.f38526c = Color.parseColor("#" + KmlStyle.c(strNextText));
                                    kmlStyle.f45550c.f38515d = Color.parseColor("#" + KmlStyle.c(strNextText));
                                    hashSet.add("outlineColor");
                                } else if (xmlPullParser.getName().equals(Snapshot.WIDTH)) {
                                    Float fValueOf = Float.valueOf(xmlPullParser.nextText());
                                    kmlStyle.f45549b.f38525b = fValueOf.floatValue();
                                    kmlStyle.f45550c.f38514c = fValueOf.floatValue();
                                    hashSet.add(Snapshot.WIDTH);
                                } else if (xmlPullParser.getName().equals("colorMode")) {
                                    kmlStyle.f45588l = xmlPullParser.nextText().equals("random");
                                    hashSet.add("lineColorMode");
                                }
                            }
                            eventType4 = xmlPullParser.next();
                        }
                    }
                } else if (xmlPullParser.getName().equals("PolyStyle")) {
                    int eventType5 = xmlPullParser.getEventType();
                    while (true) {
                        if (eventType5 != 3 || !xmlPullParser.getName().equals("PolyStyle")) {
                            if (eventType5 == 2) {
                                if (xmlPullParser.getName().equals("color")) {
                                    kmlStyle.f45550c.f38516e = Color.parseColor("#" + KmlStyle.c(xmlPullParser.nextText()));
                                    hashSet.add("fillColor");
                                } else {
                                    boolean z = true;
                                    if (xmlPullParser.getName().equals("outline")) {
                                        String strNextText2 = xmlPullParser.nextText();
                                        if (!"1".equals(strNextText2) && !"true".equals(strNextText2)) {
                                            z = false;
                                        }
                                        kmlStyle.f45583g = z;
                                        hashSet.add("outline");
                                    } else if (xmlPullParser.getName().equals("fill")) {
                                        String strNextText3 = xmlPullParser.nextText();
                                        if (!"1".equals(strNextText3) && !"true".equals(strNextText3)) {
                                            z = false;
                                        }
                                        kmlStyle.f45582f = z;
                                    } else if (xmlPullParser.getName().equals("colorMode")) {
                                        kmlStyle.f45589m = xmlPullParser.nextText().equals("random");
                                        hashSet.add("polyColorMode");
                                    }
                                }
                            }
                            eventType5 = xmlPullParser.next();
                        }
                    }
                } else if (xmlPullParser.getName().equals("BalloonStyle")) {
                    int eventType6 = xmlPullParser.getEventType();
                    while (true) {
                        if (eventType6 != 3 || !xmlPullParser.getName().equals("BalloonStyle")) {
                            if (eventType6 == 2 && xmlPullParser.getName().equals("text")) {
                                kmlStyle.f45580d.put("text", xmlPullParser.nextText());
                            }
                            eventType6 = xmlPullParser.next();
                        }
                    }
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public static HashMap b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        HashMap map = new HashMap();
        String str = "#" + xmlPullParser.getAttributeValue(null, CLConstants.SHARED_PREFERENCE_ITEM_ID);
        int eventType = xmlPullParser.getEventType();
        boolean z = false;
        while (true) {
            if (eventType == 3 && xmlPullParser.getName().equals("StyleMap")) {
                return map;
            }
            if (eventType == 2) {
                if (xmlPullParser.getName().equals("key") && xmlPullParser.nextText().equals("normal")) {
                    z = true;
                } else if (xmlPullParser.getName().equals("styleUrl") && z) {
                    map.put(str, xmlPullParser.nextText());
                    z = false;
                }
            }
            eventType = xmlPullParser.next();
        }
    }
}
