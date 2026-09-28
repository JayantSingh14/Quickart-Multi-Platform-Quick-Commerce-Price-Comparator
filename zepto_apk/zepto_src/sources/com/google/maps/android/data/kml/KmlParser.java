package com.google.maps.android.data.kml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
class KmlParser {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f45567a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f45568b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f45569c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f45570d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f45571e = new HashMap();

    public KmlParser(XmlPullParser xmlPullParser) {
    }

    public static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i2 = 1;
        while (i2 != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }
}
