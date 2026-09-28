package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes4.dex */
final class zzahn {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f23133a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f23134b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f23135c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static zzgtd a(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        zzgvs zzgvsVar = zzgtd.f33183b;
        zzgta zzgtaVar = new zzgta();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzfq.b(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strC = zzfq.c(xmlPullParser, strConcat2);
                String strC2 = zzfq.c(xmlPullParser, strConcat3);
                String strC3 = zzfq.c(xmlPullParser, strConcat4);
                String strC4 = zzfq.c(xmlPullParser, strConcat5);
                if (strC == null || strC2 == null) {
                    return zzguy.f33232e;
                }
                zzgtaVar.c(new zzahl(strC3 != null ? Long.parseLong(strC3) : 0L, strC4 != null ? Long.parseLong(strC4) : 0L, strC));
            }
        } while (!zzfq.a(xmlPullParser, str.concat(":Directory")));
        return zzgtaVar.f();
    }
}
