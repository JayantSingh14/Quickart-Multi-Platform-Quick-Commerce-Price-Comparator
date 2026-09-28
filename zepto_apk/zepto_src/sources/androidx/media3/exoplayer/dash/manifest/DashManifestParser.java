package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.exoplayer.dash.manifest.SegmentBase;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

@UnstableApi
/* loaded from: classes3.dex */
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f6802b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f6803c = Pattern.compile("CC([1-4])=.*");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f6804d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f6805e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f6806a;

    public static final class RepresentationInfo {

        /* renamed from: a, reason: collision with root package name */
        public final Format f6807a;

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList f6808b;

        /* renamed from: c, reason: collision with root package name */
        public final SegmentBase f6809c;

        /* renamed from: d, reason: collision with root package name */
        public final String f6810d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList f6811e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f6812f;

        /* renamed from: g, reason: collision with root package name */
        public final ArrayList f6813g;

        /* renamed from: h, reason: collision with root package name */
        public final ArrayList f6814h;

        public RepresentationInfo(Format format, ArrayList arrayList, SegmentBase segmentBase, String str, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
            this.f6807a = format;
            this.f6808b = ImmutableList.o(arrayList);
            this.f6809c = segmentBase;
            this.f6810d = str;
            this.f6811e = arrayList2;
            this.f6812f = arrayList3;
            this.f6813g = arrayList4;
            this.f6814h = arrayList5;
        }
    }

    public DashManifestParser() {
        try {
            this.f6806a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    public static long b(ArrayList arrayList, long j2, long j3, int i2, long j4) {
        int i3;
        if (i2 >= 0) {
            i3 = i2 + 1;
        } else {
            int i4 = Util.f5744a;
            i3 = (int) ((((j4 - j2) + j3) - 1) / j3);
        }
        for (int i5 = 0; i5 < i3; i5++) {
            arrayList.add(new SegmentBase.SegmentTimelineElement(j2, j3));
            j2 += j3;
        }
        return j2;
    }

    public static void c(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == 2) {
            int i2 = 1;
            while (i2 != 0) {
                xmlPullParser.next();
                if (xmlPullParser.getEventType() == 2) {
                    i2++;
                } else if (xmlPullParser.getEventType() == 3) {
                    i2--;
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:200)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(org.xmlpull.v1.XmlPullParser r12) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.d(org.xmlpull.v1.XmlPullParser):int");
    }

    public static long e(XmlPullParser xmlPullParser, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j2;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    public static ArrayList f(XmlPullParser xmlPullParser, ArrayList arrayList, boolean z) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int i2 = attributeValue != null ? Integer.parseInt(attributeValue) : z ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int i3 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String text = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            } else {
                c(xmlPullParser);
            }
        } while (!XmlPullParserUtil.b(xmlPullParser, "BaseURL"));
        if (text != null && UriUtil.b(text)[0] != -1) {
            if (attributeValue3 == null) {
                attributeValue3 = text;
            }
            return Lists.b(new BaseUrl(i2, i3, text, attributeValue3));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            BaseUrl baseUrl = (BaseUrl) arrayList.get(i4);
            String strD = UriUtil.d(baseUrl.f6785a, text);
            String str = attributeValue3 == null ? strD : attributeValue3;
            if (z) {
                i2 = baseUrl.f6787c;
                i3 = baseUrl.f6788d;
                str = baseUrl.f6786b;
            }
            arrayList2.add(new BaseUrl(i2, i3, strD, str));
        }
        return arrayList2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x015d  */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v16, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v26, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.UUID] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v4, types: [byte[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair g(org.xmlpull.v1.XmlPullParser r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.g(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    public static int h(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return "image".equals(attributeValue) ? 4 : -1;
    }

    public static Descriptor i(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue == null) {
            attributeValue = "";
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, CLConstants.FIELD_PAY_INFO_VALUE);
        if (attributeValue2 == null) {
            attributeValue2 = null;
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, CLConstants.SHARED_PREFERENCE_ITEM_ID);
        String str2 = attributeValue3 != null ? attributeValue3 : null;
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.b(xmlPullParser, str));
        return new Descriptor(attributeValue, attributeValue2, str2);
    }

    public static long j(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j2;
        }
        Matcher matcher = Util.f5752i.matcher(attributeValue);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(attributeValue) * 3600.0d * 1000.0d);
        }
        boolean zIsEmpty = TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(3);
        double d2 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
        String strGroup2 = matcher.group(5);
        double d3 = d2 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
        String strGroup3 = matcher.group(7);
        double d4 = d3 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
        String strGroup4 = matcher.group(10);
        double d5 = d4 + (strGroup4 != null ? Double.parseDouble(strGroup4) * 3600.0d : 0.0d);
        String strGroup5 = matcher.group(12);
        double d6 = d5 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
        String strGroup6 = matcher.group(14);
        long j3 = (long) ((d6 + (strGroup6 != null ? Double.parseDouble(strGroup6) : 0.0d)) * 1000.0d);
        return !zIsEmpty ? -j3 : j3;
    }

    public static float k(XmlPullParser xmlPullParser, float f2) throws NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = f6802b.matcher(attributeValue);
            if (matcher.matches()) {
                int i2 = Integer.parseInt(matcher.group(1));
                return !TextUtils.isEmpty(matcher.group(2)) ? i2 / Integer.parseInt(r2) : i2;
            }
        }
        return f2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0973  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0981  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x09c7  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x09ee  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0a1c  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0a26  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0a92  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0b02  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0b0b  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0b10  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x0b19  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0b22  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x0b30  */
    /* JADX WARN: Removed duplicated region for block: B:462:0x0bf4  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0bf7  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0c06  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0c11  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0c29  */
    /* JADX WARN: Removed duplicated region for block: B:482:0x0c58 A[LOOP:11: B:244:0x06bc->B:482:0x0c58, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0f90 A[LOOP:5: B:162:0x0428->B:580:0x0f90, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:705:0x13ab A[LOOP:1: B:44:0x00d5->B:705:0x13ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:713:0x1379 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:717:0x0de9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:727:0x08db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:742:0x0adc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.exoplayer.dash.manifest.DashManifest l(org.xmlpull.v1.XmlPullParser r148, android.net.Uri r149) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 5112
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.l(org.xmlpull.v1.XmlPullParser, android.net.Uri):androidx.media3.exoplayer.dash.manifest.DashManifest");
    }

    public static RangedUri m(XmlPullParser xmlPullParser, String str, String str2) throws NumberFormatException {
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        long j3 = -1;
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j2 = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j3 = (Long.parseLong(strArrSplit[1]) - j2) + 1;
            }
        } else {
            j2 = 0;
        }
        return new RangedUri(j2, j3, attributeValue);
    }

    public static int n(String str) {
        if (str != null) {
            switch (str) {
                case "subtitle":
                case "forced_subtitle":
                case "forced-subtitle":
                    return 128;
                case "description":
                    return 512;
                case "enhanced-audio-intelligibility":
                    return 2048;
                case "alternate":
                    return 2;
                case "dub":
                    return 16;
                case "main":
                    return 1;
                case "sign":
                    return 256;
                case "caption":
                    return 64;
                case "commentary":
                    return 8;
                case "emergency":
                    return 32;
                case "supplementary":
                    return 4;
            }
        }
        return 0;
    }

    public static int o(ArrayList arrayList) {
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (Ascii.a("http://dashif.org/guidelines/trickmode", ((Descriptor) arrayList.get(i3)).f6815a)) {
                i2 = 16384;
            }
        }
        return i2;
    }

    public static SegmentBase.SingleSegmentBase p(XmlPullParser xmlPullParser, SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, NumberFormatException, IOException {
        long j2 = singleSegmentBase != null ? singleSegmentBase.f6844b : 1L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "timescale");
        if (attributeValue != null) {
            j2 = Long.parseLong(attributeValue);
        }
        long j3 = j2;
        long j4 = singleSegmentBase != null ? singleSegmentBase.f6845c : 0L;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "presentationTimeOffset");
        if (attributeValue2 != null) {
            j4 = Long.parseLong(attributeValue2);
        }
        long j5 = j4;
        long j6 = singleSegmentBase != null ? singleSegmentBase.f6858d : 0L;
        long j7 = singleSegmentBase != null ? singleSegmentBase.f6859e : 0L;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue3 != null) {
            String[] strArrSplit = attributeValue3.split("-");
            j6 = Long.parseLong(strArrSplit[0]);
            j7 = (Long.parseLong(strArrSplit[1]) - j6) + 1;
        }
        long j8 = j7;
        long j9 = j6;
        RangedUri rangedUriM = singleSegmentBase != null ? singleSegmentBase.f6843a : null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.c(xmlPullParser, "Initialization")) {
                rangedUriM = m(xmlPullParser, "sourceURL", "range");
            } else {
                c(xmlPullParser);
            }
            RangedUri rangedUri = rangedUriM;
            if (XmlPullParserUtil.b(xmlPullParser, "SegmentBase")) {
                return new SegmentBase.SingleSegmentBase(rangedUri, j3, j5, j9, j8);
            }
            rangedUriM = rangedUri;
        }
    }

    public static SegmentBase.SegmentList q(XmlPullParser xmlPullParser, SegmentBase.SegmentList segmentList, long j2, long j3, long j4, long j5, long j6) throws XmlPullParserException, IOException, NumberFormatException {
        long j7 = segmentList != null ? segmentList.f6844b : 1L;
        List arrayList = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "timescale");
        if (attributeValue != null) {
            j7 = Long.parseLong(attributeValue);
        }
        long j8 = j7;
        long j9 = segmentList != null ? segmentList.f6845c : 0L;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "presentationTimeOffset");
        if (attributeValue2 != null) {
            j9 = Long.parseLong(attributeValue2);
        }
        long j10 = j9;
        long j11 = segmentList != null ? segmentList.f6847e : -9223372036854775807L;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "duration");
        if (attributeValue3 != null) {
            j11 = Long.parseLong(attributeValue3);
        }
        long j12 = j11;
        long j13 = segmentList != null ? segmentList.f6846d : 1L;
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "startNumber");
        if (attributeValue4 != null) {
            j13 = Long.parseLong(attributeValue4);
        }
        long j14 = j13;
        long j15 = j5 == -9223372036854775807L ? j4 : j5;
        long j16 = j15 == Long.MAX_VALUE ? -9223372036854775807L : j15;
        RangedUri rangedUriM = null;
        List listS = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.c(xmlPullParser, "Initialization")) {
                rangedUriM = m(xmlPullParser, "sourceURL", "range");
            } else if (XmlPullParserUtil.c(xmlPullParser, "SegmentTimeline")) {
                listS = s(xmlPullParser, j8, j3);
            } else if (XmlPullParserUtil.c(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m(xmlPullParser, "media", "mediaRange"));
            } else {
                c(xmlPullParser);
            }
        } while (!XmlPullParserUtil.b(xmlPullParser, "SegmentList"));
        if (segmentList != null) {
            if (rangedUriM == null) {
                rangedUriM = segmentList.f6843a;
            }
            if (listS == null) {
                listS = segmentList.f6848f;
            }
            if (arrayList == null) {
                arrayList = segmentList.f6852j;
            }
        }
        return new SegmentBase.SegmentList(rangedUriM, j8, j10, j14, j12, listS, j16, arrayList, Util.T(j6), Util.T(j2));
    }

    public static SegmentBase.SegmentTemplate r(XmlPullParser xmlPullParser, SegmentBase.SegmentTemplate segmentTemplate, List list, long j2, long j3, long j4, long j5, long j6) throws XmlPullParserException, NumberFormatException, IOException {
        long j7;
        long j8 = segmentTemplate != null ? segmentTemplate.f6844b : 1L;
        RangedUri rangedUriM = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "timescale");
        if (attributeValue != null) {
            j8 = Long.parseLong(attributeValue);
        }
        long j9 = j8;
        long j10 = segmentTemplate != null ? segmentTemplate.f6845c : 0L;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "presentationTimeOffset");
        if (attributeValue2 != null) {
            j10 = Long.parseLong(attributeValue2);
        }
        long j11 = j10;
        long j12 = segmentTemplate != null ? segmentTemplate.f6847e : -9223372036854775807L;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "duration");
        if (attributeValue3 != null) {
            j12 = Long.parseLong(attributeValue3);
        }
        long j13 = j12;
        long j14 = segmentTemplate != null ? segmentTemplate.f6846d : 1L;
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "startNumber");
        if (attributeValue4 != null) {
            j14 = Long.parseLong(attributeValue4);
        }
        long j15 = j14;
        int i2 = 0;
        while (true) {
            if (i2 >= list.size()) {
                j7 = -1;
                break;
            }
            Descriptor descriptor = (Descriptor) list.get(i2);
            if (Ascii.a("http://dashif.org/guidelines/last-segment-number", descriptor.f6815a)) {
                j7 = Long.parseLong(descriptor.f6816b);
                break;
            }
            i2++;
        }
        long j16 = j7;
        long j17 = j5 == -9223372036854775807L ? j4 : j5;
        long j18 = j17 == Long.MAX_VALUE ? -9223372036854775807L : j17;
        UrlTemplate urlTemplateT = t(xmlPullParser, "media", segmentTemplate != null ? segmentTemplate.f6854k : null);
        UrlTemplate urlTemplateT2 = t(xmlPullParser, "initialization", segmentTemplate != null ? segmentTemplate.f6853j : null);
        List listS = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.c(xmlPullParser, "Initialization")) {
                rangedUriM = m(xmlPullParser, "sourceURL", "range");
            } else if (XmlPullParserUtil.c(xmlPullParser, "SegmentTimeline")) {
                listS = s(xmlPullParser, j9, j3);
            } else {
                c(xmlPullParser);
            }
        } while (!XmlPullParserUtil.b(xmlPullParser, "SegmentTemplate"));
        if (segmentTemplate != null) {
            if (rangedUriM == null) {
                rangedUriM = segmentTemplate.f6843a;
            }
            if (listS == null) {
                listS = segmentTemplate.f6848f;
            }
        }
        return new SegmentBase.SegmentTemplate(rangedUriM, j9, j11, j15, j16, j13, listS, j18, urlTemplateT2, urlTemplateT, Util.T(j6), Util.T(j2));
    }

    public static ArrayList s(XmlPullParser xmlPullParser, long j2, long j3) throws XmlPullParserException, IOException {
        long j4;
        ArrayList arrayList = new ArrayList();
        long jB = 0;
        long j5 = -9223372036854775807L;
        boolean z = false;
        int i2 = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.c(xmlPullParser, "S")) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "t");
                long j6 = attributeValue == null ? -9223372036854775807L : Long.parseLong(attributeValue);
                if (z) {
                    int i3 = i2;
                    j4 = j6;
                    jB = b(arrayList, jB, j5, i3, j4);
                } else {
                    j4 = j6;
                }
                if (j4 != -9223372036854775807L) {
                    jB = j4;
                }
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "d");
                j5 = attributeValue2 == null ? -9223372036854775807L : Long.parseLong(attributeValue2);
                String attributeValue3 = xmlPullParser.getAttributeValue(null, "r");
                i2 = attributeValue3 == null ? 0 : Integer.parseInt(attributeValue3);
                z = true;
            } else {
                c(xmlPullParser);
            }
        } while (!XmlPullParserUtil.b(xmlPullParser, "SegmentTimeline"));
        if (z) {
            int i4 = Util.f5744a;
            b(arrayList, jB, j5, i2, Util.b0(j3, j2, 1000L, RoundingMode.FLOOR));
        }
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0125 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.exoplayer.dash.manifest.UrlTemplate t(org.xmlpull.v1.XmlPullParser r12, java.lang.String r13, androidx.media3.exoplayer.dash.manifest.UrlTemplate r14) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.t(org.xmlpull.v1.XmlPullParser, java.lang.String, androidx.media3.exoplayer.dash.manifest.UrlTemplate):androidx.media3.exoplayer.dash.manifest.UrlTemplate");
    }

    @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
    public final Object a(Uri uri, DataSourceInputStream dataSourceInputStream) throws XmlPullParserException, ParserException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f6806a.newPullParser();
            xmlPullParserNewPullParser.setInput(dataSourceInputStream, null);
            if (xmlPullParserNewPullParser.next() == 2 && "MPD".equals(xmlPullParserNewPullParser.getName())) {
                return l(xmlPullParserNewPullParser, uri);
            }
            throw ParserException.b("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e2) {
            throw ParserException.b(null, e2);
        }
    }
}
