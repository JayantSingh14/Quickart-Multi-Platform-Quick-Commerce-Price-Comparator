package com.google.android.play.core.splitinstall;

import android.content.res.XmlResourceParser;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
final class zzbg {
    public static final String a(String str, XmlResourceParser xmlResourceParser) {
        for (int i2 = 0; i2 < xmlResourceParser.getAttributeCount(); i2++) {
            if (xmlResourceParser.getAttributeName(i2).equals(str)) {
                return xmlResourceParser.getAttributeValue(i2);
            }
        }
        return null;
    }

    public static final void b(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 != 0) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }
}
