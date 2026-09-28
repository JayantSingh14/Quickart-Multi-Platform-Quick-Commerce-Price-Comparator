package androidx.media3.extractor.text.ttml;

import android.support.v4.media.b;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

@UnstableApi
/* loaded from: classes3.dex */
public final class TtmlParser implements SubtitleParser {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f9383b = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f9384c = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f9385d = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f9386e = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f9387f = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f9388g = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f9389h = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: i, reason: collision with root package name */
    public static final FrameAndTickRate f9390i = new FrameAndTickRate(30.0f, 1, 1);

    /* renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f9391a;

    public static final class FrameAndTickRate {

        /* renamed from: a, reason: collision with root package name */
        public final float f9392a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9393b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9394c;

        public FrameAndTickRate(float f2, int i2, int i3) {
            this.f9392a = f2;
            this.f9393b = i2;
            this.f9394c = i3;
        }
    }

    public static final class TtsExtent {

        /* renamed from: a, reason: collision with root package name */
        public final int f9395a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9396b;

        public TtsExtent(int i2, int i3) {
            this.f9395a = i2;
            this.f9396b = i3;
        }
    }

    public TtmlParser() throws XmlPullParserException {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f9391a = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    public static TtmlStyle d(TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    public static boolean e(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    public static int f(XmlPullParser xmlPullParser) throws NumberFormatException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return 15;
        }
        Matcher matcher = f9389h.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.h("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return 15;
        }
        boolean z = true;
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i2 = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            int i3 = Integer.parseInt(strGroup2);
            if (i2 == 0 || i3 == 0) {
                z = false;
            }
            Assertions.b(z, "Invalid cell resolution " + i2 + StringUtils.SPACE + i3);
            return i3;
        } catch (NumberFormatException unused) {
            Log.h("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return 15;
        }
    }

    public static void g(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String strGroup;
        int i2 = Util.f5744a;
        String[] strArrSplit = str.split("\\s+", -1);
        int length = strArrSplit.length;
        Pattern pattern = f9385d;
        if (length == 1) {
            matcher = pattern.matcher(str);
        } else {
            if (strArrSplit.length != 2) {
                throw new SubtitleDecoderException(b.o(new StringBuilder("Invalid number of entries for fontSize: "), strArrSplit.length, CLConstants.DOT_SALT_DELIMETER));
            }
            matcher = pattern.matcher(strArrSplit[1]);
            Log.h("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException(b.D("Invalid expression for fontSize: '", str, "'."));
        }
        strGroup = matcher.group(3);
        strGroup.getClass();
        switch (strGroup) {
            case "%":
                ttmlStyle.f9416j = 3;
                break;
            case "em":
                ttmlStyle.f9416j = 2;
                break;
            case "px":
                ttmlStyle.f9416j = 1;
                break;
            default:
                throw new SubtitleDecoderException(b.D("Invalid unit for fontSize: '", strGroup, "'."));
        }
        String strGroup2 = matcher.group(1);
        strGroup2.getClass();
        ttmlStyle.f9417k = Float.parseFloat(strGroup2);
    }

    public static FrameAndTickRate h(XmlPullParser xmlPullParser) throws NumberFormatException {
        float f2;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i2 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            int i3 = Util.f5744a;
            Assertions.b(attributeValue2.split(StringUtils.SPACE, -1).length == 2, "frameRateMultiplier doesn't have 2 parts");
            f2 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f2 = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = f9390i;
        int i4 = frameAndTickRate.f9393b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i4 = Integer.parseInt(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        return new FrameAndTickRate(i2 * f2, i4, attributeValue4 != null ? Integer.parseInt(attributeValue4) : frameAndTickRate.f9394c);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0254 A[LOOP:0: B:3:0x000a->B:105:0x0254, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(org.xmlpull.v1.XmlPullParser r20, java.util.HashMap r21, int r22, androidx.media3.extractor.text.ttml.TtmlParser.TtsExtent r23, java.util.HashMap r24, java.util.HashMap r25) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.i(org.xmlpull.v1.XmlPullParser, java.util.HashMap, int, androidx.media3.extractor.text.ttml.TtmlParser$TtsExtent, java.util.HashMap, java.util.HashMap):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.extractor.text.ttml.TtmlNode j(org.xmlpull.v1.XmlPullParser r23, androidx.media3.extractor.text.ttml.TtmlNode r24, java.util.HashMap r25, androidx.media3.extractor.text.ttml.TtmlParser.FrameAndTickRate r26) throws androidx.media3.extractor.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.j(org.xmlpull.v1.XmlPullParser, androidx.media3.extractor.text.ttml.TtmlNode, java.util.HashMap, androidx.media3.extractor.text.ttml.TtmlParser$FrameAndTickRate):androidx.media3.extractor.text.ttml.TtmlNode");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:200)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:124)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.extractor.text.ttml.TtmlStyle k(org.xmlpull.v1.XmlPullParser r21, androidx.media3.extractor.text.ttml.TtmlStyle r22) {
        /*
            Method dump skipped, instructions count: 1570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.k(org.xmlpull.v1.XmlPullParser, androidx.media3.extractor.text.ttml.TtmlStyle):androidx.media3.extractor.text.ttml.TtmlStyle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long l(java.lang.String r13, androidx.media3.extractor.text.ttml.TtmlParser.FrameAndTickRate r14) throws androidx.media3.extractor.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.l(java.lang.String, androidx.media3.extractor.text.ttml.TtmlParser$FrameAndTickRate):long");
    }

    public static TtsExtent m(XmlPullParser xmlPullParser) throws NumberFormatException {
        String strA = XmlPullParserUtil.a(xmlPullParser, "extent");
        if (strA == null) {
            return null;
        }
        Matcher matcher = f9388g.matcher(strA);
        if (!matcher.matches()) {
            Log.h("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strA));
            return null;
        }
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i2 = Integer.parseInt(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            return new TtsExtent(i2, Integer.parseInt(strGroup2));
        } catch (NumberFormatException unused) {
            Log.h("TtmlParser", "Ignoring malformed tts extent: ".concat(strA));
            return null;
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final Subtitle a(int i2, byte[] bArr, int i3) throws XmlPullParserException, NumberFormatException, IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f9391a.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new TtmlRegion("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            TtsExtent ttsExtentM = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i2, i3), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRateH = f9390i;
            int i4 = 0;
            int iF = 15;
            TtmlSubtitle ttmlSubtitle = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i4 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRateH = h(xmlPullParserNewPullParser);
                            iF = f(xmlPullParserNewPullParser);
                            ttsExtentM = m(xmlPullParserNewPullParser);
                        }
                        FrameAndTickRate frameAndTickRate = frameAndTickRateH;
                        TtsExtent ttsExtent = ttsExtentM;
                        int i5 = iF;
                        if (e(name)) {
                            if ("head".equals(name)) {
                                i(xmlPullParserNewPullParser, map, i5, ttsExtent, map2, map3);
                            } else {
                                try {
                                    TtmlNode ttmlNodeJ = j(xmlPullParserNewPullParser, ttmlNode, map2, frameAndTickRate);
                                    arrayDeque.push(ttmlNodeJ);
                                    if (ttmlNode != null) {
                                        if (ttmlNode.f9382m == null) {
                                            ttmlNode.f9382m = new ArrayList();
                                        }
                                        ttmlNode.f9382m.add(ttmlNodeJ);
                                    }
                                } catch (SubtitleDecoderException e2) {
                                    Log.i("TtmlParser", "Suppressing parser error", e2);
                                }
                            }
                            iF = i5;
                            ttsExtentM = ttsExtent;
                            frameAndTickRateH = frameAndTickRate;
                        } else {
                            Log.g("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                        }
                        i4++;
                        iF = i5;
                        ttsExtentM = ttsExtent;
                        frameAndTickRateH = frameAndTickRate;
                    } else if (eventType == 4) {
                        ttmlNode.getClass();
                        TtmlNode ttmlNodeA = TtmlNode.a(xmlPullParserNewPullParser.getText());
                        if (ttmlNode.f9382m == null) {
                            ttmlNode.f9382m = new ArrayList();
                        }
                        ttmlNode.f9382m.add(ttmlNodeA);
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals("tt")) {
                            TtmlNode ttmlNode2 = (TtmlNode) arrayDeque.peek();
                            ttmlNode2.getClass();
                            ttmlSubtitle = new TtmlSubtitle(ttmlNode2, map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i4++;
                } else if (eventType == 3) {
                    i4--;
                }
                xmlPullParserNewPullParser.next();
            }
            ttmlSubtitle.getClass();
            return ttmlSubtitle;
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        } catch (XmlPullParserException e4) {
            throw new IllegalStateException("Unable to decode source", e4);
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void b(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        LegacySubtitleUtil.b(a(i2, bArr, i3), outputOptions, consumer);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final int c() {
        return 1;
    }
}
