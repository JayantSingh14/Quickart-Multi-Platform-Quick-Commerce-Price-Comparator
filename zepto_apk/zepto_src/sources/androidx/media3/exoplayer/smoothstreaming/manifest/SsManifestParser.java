package androidx.media3.exoplayer.smoothstreaming.manifest;

import android.net.Uri;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.util.Base64;
import android.util.Pair;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import androidx.media3.extractor.mp4.TrackEncryptionBox;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

@UnstableApi
/* loaded from: classes3.dex */
public class SsManifestParser implements ParsingLoadable.Parser<SsManifest> {

    /* renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f7468a;

    public static abstract class ElementParser {

        /* renamed from: a, reason: collision with root package name */
        public final String f7469a;

        /* renamed from: b, reason: collision with root package name */
        public final String f7470b;

        /* renamed from: c, reason: collision with root package name */
        public final ElementParser f7471c;

        /* renamed from: d, reason: collision with root package name */
        public final LinkedList f7472d = new LinkedList();

        public ElementParser(ElementParser elementParser, String str, String str2) {
            this.f7471c = elementParser;
            this.f7469a = str;
            this.f7470b = str2;
        }

        public static int g(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return -1;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.b(null, e2);
            }
        }

        public static long h(XmlPullParser xmlPullParser, String str, long j2) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j2;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.b(null, e2);
            }
        }

        public static int i(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.b(null, e2);
            }
        }

        public void a(Object obj) {
        }

        public abstract Object b();

        public final Object c(String str) {
            int i2 = 0;
            while (true) {
                LinkedList linkedList = this.f7472d;
                if (i2 >= linkedList.size()) {
                    ElementParser elementParser = this.f7471c;
                    if (elementParser == null) {
                        return null;
                    }
                    return elementParser.c(str);
                }
                Pair pair = (Pair) linkedList.get(i2);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
                i2++;
            }
        }

        public boolean d(String str) {
            return false;
        }

        public final Object e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z = false;
            int i2 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                ElementParser streamIndexParser = null;
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f7470b.equals(name)) {
                        j(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i2 > 0) {
                            i2++;
                        } else if (d(name)) {
                            j(xmlPullParser);
                        } else {
                            boolean zEquals = "QualityLevel".equals(name);
                            String str = this.f7469a;
                            if (zEquals) {
                                streamIndexParser = new QualityLevelParser(this, str, "QualityLevel");
                            } else if ("Protection".equals(name)) {
                                streamIndexParser = new ProtectionParser(this, str, "Protection");
                            } else if ("StreamIndex".equals(name)) {
                                streamIndexParser = new StreamIndexParser(this, str);
                            }
                            if (streamIndexParser == null) {
                                i2 = 1;
                            } else {
                                a(streamIndexParser.e(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i2 == 0) {
                        k(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i2 > 0) {
                    i2--;
                } else {
                    String name2 = xmlPullParser.getName();
                    f(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        public void f(XmlPullParser xmlPullParser) {
        }

        public void j(XmlPullParser xmlPullParser) {
        }

        public void k(XmlPullParser xmlPullParser) {
        }

        public final void l(Object obj, String str) {
            this.f7472d.add(Pair.create(str, obj));
        }
    }

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: ".concat(str), null, true, 4);
        }
    }

    public static class ProtectionParser extends ElementParser {

        /* renamed from: e, reason: collision with root package name */
        public boolean f7473e;

        /* renamed from: f, reason: collision with root package name */
        public UUID f7474f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f7475g;

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final Object b() {
            UUID uuid = this.f7474f;
            byte[] bArrA = PsshAtomUtil.a(uuid, null, this.f7475g);
            byte[] bArr = this.f7475g;
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2 += 2) {
                sb.append((char) bArr[i2]);
            }
            String string = sb.toString();
            byte[] bArrDecode = Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
            byte b2 = bArrDecode[0];
            bArrDecode[0] = bArrDecode[3];
            bArrDecode[3] = b2;
            byte b3 = bArrDecode[1];
            bArrDecode[1] = bArrDecode[2];
            bArrDecode[2] = b3;
            byte b4 = bArrDecode[4];
            bArrDecode[4] = bArrDecode[5];
            bArrDecode[5] = b4;
            byte b5 = bArrDecode[6];
            bArrDecode[6] = bArrDecode[7];
            bArrDecode[7] = b5;
            return new SsManifest.ProtectionElement(uuid, bArrA, new TrackEncryptionBox[]{new TrackEncryptionBox(true, null, 8, bArrDecode, 0, 0, null)});
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final void f(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f7473e = false;
            }
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final void j(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f7473e = true;
                String attributeValue = xmlPullParser.getAttributeValue(null, "SystemID");
                if (attributeValue.charAt(0) == '{' && attributeValue.charAt(attributeValue.length() - 1) == '}') {
                    attributeValue = a.k(1, 1, attributeValue);
                }
                this.f7474f = UUID.fromString(attributeValue);
            }
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final void k(XmlPullParser xmlPullParser) {
            if (this.f7473e) {
                this.f7475g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public static class QualityLevelParser extends ElementParser {

        /* renamed from: e, reason: collision with root package name */
        public Format f7476e;

        /* JADX WARN: Removed duplicated region for block: B:41:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00b7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.util.ArrayList m(java.lang.String r12) {
            /*
                r0 = 4
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                boolean r2 = android.text.TextUtils.isEmpty(r12)
                if (r2 != 0) goto Lba
                int r2 = androidx.media3.common.util.Util.f5744a
                int r2 = r12.length()
                int r2 = r2 / 2
                byte[] r3 = new byte[r2]
                r4 = 0
                r5 = r4
            L18:
                if (r5 >= r2) goto L38
                int r6 = r5 * 2
                char r7 = r12.charAt(r6)
                r8 = 16
                int r7 = java.lang.Character.digit(r7, r8)
                int r7 = r7 << r0
                int r6 = r6 + 1
                char r6 = r12.charAt(r6)
                int r6 = java.lang.Character.digit(r6, r8)
                int r6 = r6 + r7
                byte r6 = (byte) r6
                r3[r5] = r6
                int r5 = r5 + 1
                goto L18
            L38:
                if (r2 > r0) goto L3b
                goto L46
            L3b:
                r12 = r4
            L3c:
                byte[] r5 = androidx.media3.common.util.CodecSpecificDataUtil.f5663a
                if (r12 >= r0) goto L4c
                r6 = r3[r12]
                r5 = r5[r12]
                if (r6 == r5) goto L49
            L46:
                r12 = 0
                goto Lb1
            L49:
                int r12 = r12 + 1
                goto L3c
            L4c:
                java.util.ArrayList r12 = new java.util.ArrayList
                r12.<init>()
                r6 = r4
            L52:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
                r12.add(r7)
                int r6 = r6 + r0
                int r7 = r2 + (-4)
            L5c:
                r8 = -1
                if (r6 > r7) goto L75
                int r9 = r2 - r6
                if (r9 > r0) goto L64
                goto L6f
            L64:
                r9 = r4
            L65:
                if (r9 >= r0) goto L76
                int r10 = r6 + r9
                r10 = r3[r10]
                r11 = r5[r9]
                if (r10 == r11) goto L72
            L6f:
                int r6 = r6 + 1
                goto L5c
            L72:
                int r9 = r9 + 1
                goto L65
            L75:
                r6 = r8
            L76:
                if (r6 != r8) goto L52
                int r0 = r12.size()
                byte[][] r0 = new byte[r0][]
                r5 = r4
            L7f:
                int r6 = r12.size()
                if (r5 >= r6) goto Lb0
                java.lang.Object r6 = r12.get(r5)
                java.lang.Integer r6 = (java.lang.Integer) r6
                int r6 = r6.intValue()
                int r7 = r12.size()
                int r7 = r7 + (-1)
                if (r5 >= r7) goto La4
                int r7 = r5 + 1
                java.lang.Object r7 = r12.get(r7)
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r7 = r7.intValue()
                goto La5
            La4:
                r7 = r2
            La5:
                int r7 = r7 - r6
                byte[] r8 = new byte[r7]
                java.lang.System.arraycopy(r3, r6, r8, r4, r7)
                r0[r5] = r8
                int r5 = r5 + 1
                goto L7f
            Lb0:
                r12 = r0
            Lb1:
                if (r12 != 0) goto Lb7
                r1.add(r3)
                return r1
            Lb7:
                java.util.Collections.addAll(r1, r12)
            Lba:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.QualityLevelParser.m(java.lang.String):java.util.ArrayList");
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final Object b() {
            return this.f7476e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List] */
        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final void j(XmlPullParser xmlPullParser) throws ParserException {
            Format.Builder builder = new Format.Builder();
            String attributeValue = xmlPullParser.getAttributeValue(null, "FourCC");
            if (attributeValue == null) {
                throw new MissingFieldException("FourCC");
            }
            String str = (attributeValue.equalsIgnoreCase("H264") || attributeValue.equalsIgnoreCase("X264") || attributeValue.equalsIgnoreCase("AVC1") || attributeValue.equalsIgnoreCase("DAVC")) ? "video/avc" : (attributeValue.equalsIgnoreCase("AAC") || attributeValue.equalsIgnoreCase("AACL") || attributeValue.equalsIgnoreCase("AACH") || attributeValue.equalsIgnoreCase("AACP")) ? "audio/mp4a-latm" : (attributeValue.equalsIgnoreCase("TTML") || attributeValue.equalsIgnoreCase("DFXP")) ? "application/ttml+xml" : (attributeValue.equalsIgnoreCase("ac-3") || attributeValue.equalsIgnoreCase("dac3")) ? "audio/ac3" : (attributeValue.equalsIgnoreCase("ec-3") || attributeValue.equalsIgnoreCase("dec3")) ? "audio/eac3" : attributeValue.equalsIgnoreCase("dtsc") ? "audio/vnd.dts" : (attributeValue.equalsIgnoreCase("dtsh") || attributeValue.equalsIgnoreCase("dtsl")) ? "audio/vnd.dts.hd" : attributeValue.equalsIgnoreCase("dtse") ? "audio/vnd.dts.hd;profile=lbr" : attributeValue.equalsIgnoreCase("opus") ? "audio/opus" : null;
            int iIntValue = ((Integer) c("Type")).intValue();
            if (iIntValue == 2) {
                ArrayList arrayListM = m(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                builder.f5236k = MimeTypes.p("video/mp4");
                builder.r = ElementParser.i(xmlPullParser, "MaxWidth");
                builder.s = ElementParser.i(xmlPullParser, "MaxHeight");
                builder.o = arrayListM;
            } else {
                int i2 = 0;
                if (iIntValue == 1) {
                    if (str == null) {
                        str = "audio/mp4a-latm";
                    }
                    int i3 = ElementParser.i(xmlPullParser, "Channels");
                    int i4 = ElementParser.i(xmlPullParser, "SamplingRate");
                    ArrayList arrayListM2 = m(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                    boolean zIsEmpty = arrayListM2.isEmpty();
                    ArrayList arrayListSingletonList = arrayListM2;
                    if (zIsEmpty) {
                        arrayListSingletonList = arrayListM2;
                        if ("audio/mp4a-latm".equals(str)) {
                            int i5 = -1;
                            for (int i6 = 0; i6 < 13; i6++) {
                                if (i4 == AacUtil.f8454a[i6]) {
                                    i5 = i6;
                                }
                            }
                            int i7 = -1;
                            while (i2 < 16) {
                                if (i3 == AacUtil.f8455b[i2]) {
                                    i7 = i2;
                                }
                                i2++;
                            }
                            if (i4 == -1 || i7 == -1) {
                                throw new IllegalArgumentException(b.d(i4, i3, "Invalid sample rate or number of channels: ", ", "));
                            }
                            arrayListSingletonList = Collections.singletonList(AacUtil.a(2, i5, i7));
                        }
                    }
                    builder.f5236k = MimeTypes.p("audio/mp4");
                    builder.z = i3;
                    builder.A = i4;
                    builder.o = arrayListSingletonList;
                } else if (iIntValue == 3) {
                    String str2 = (String) c("Subtype");
                    if (str2 != null) {
                        if (str2.equals("CAPT")) {
                            i2 = 64;
                        } else if (str2.equals("DESC")) {
                            i2 = 1024;
                        }
                    }
                    builder.f5236k = MimeTypes.p("application/mp4");
                    builder.f5231f = i2;
                } else {
                    builder.f5236k = MimeTypes.p("application/mp4");
                }
            }
            builder.f5226a = xmlPullParser.getAttributeValue(null, "Index");
            builder.f5227b = (String) c("Name");
            builder.f5237l = MimeTypes.p(str);
            builder.f5232g = ElementParser.i(xmlPullParser, "Bitrate");
            builder.f5229d = (String) c("Language");
            this.f7476e = new Format(builder);
        }
    }

    public static class SmoothStreamingMediaParser extends ElementParser {

        /* renamed from: e, reason: collision with root package name */
        public final LinkedList f7477e;

        /* renamed from: f, reason: collision with root package name */
        public int f7478f;

        /* renamed from: g, reason: collision with root package name */
        public int f7479g;

        /* renamed from: h, reason: collision with root package name */
        public long f7480h;

        /* renamed from: i, reason: collision with root package name */
        public long f7481i;

        /* renamed from: j, reason: collision with root package name */
        public long f7482j;

        /* renamed from: k, reason: collision with root package name */
        public int f7483k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f7484l;

        /* renamed from: m, reason: collision with root package name */
        public SsManifest.ProtectionElement f7485m;

        public SmoothStreamingMediaParser(String str) {
            super(null, str, "SmoothStreamingMedia");
            this.f7483k = -1;
            this.f7485m = null;
            this.f7477e = new LinkedList();
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final void a(Object obj) {
            if (obj instanceof SsManifest.StreamElement) {
                this.f7477e.add((SsManifest.StreamElement) obj);
            } else if (obj instanceof SsManifest.ProtectionElement) {
                Assertions.g(this.f7485m == null);
                this.f7485m = (SsManifest.ProtectionElement) obj;
            }
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final Object b() {
            SsManifest.ProtectionElement protectionElement;
            long jB0;
            LinkedList linkedList = this.f7477e;
            int size = linkedList.size();
            SsManifest.StreamElement[] streamElementArr = new SsManifest.StreamElement[size];
            linkedList.toArray(streamElementArr);
            SsManifest.ProtectionElement protectionElement2 = this.f7485m;
            if (protectionElement2 != null) {
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(protectionElement2.f7452a, null, "video/mp4", protectionElement2.f7453b));
                for (int i2 = 0; i2 < size; i2++) {
                    SsManifest.StreamElement streamElement = streamElementArr[i2];
                    int i3 = streamElement.f7455a;
                    if (i3 == 2 || i3 == 1) {
                        int i4 = 0;
                        while (true) {
                            Format[] formatArr = streamElement.f7464j;
                            if (i4 < formatArr.length) {
                                Format.Builder builderA = formatArr[i4].a();
                                builderA.p = drmInitData;
                                formatArr[i4] = new Format(builderA);
                                i4++;
                            }
                        }
                    }
                }
            }
            int i5 = this.f7478f;
            int i6 = this.f7479g;
            long j2 = this.f7480h;
            long j3 = this.f7481i;
            long j4 = this.f7482j;
            int i7 = this.f7483k;
            boolean z = this.f7484l;
            SsManifest.ProtectionElement protectionElement3 = this.f7485m;
            long jB02 = -9223372036854775807L;
            if (j3 == 0) {
                protectionElement = protectionElement3;
                jB0 = -9223372036854775807L;
            } else {
                int i8 = Util.f5744a;
                protectionElement = protectionElement3;
                jB0 = Util.b0(j3, 1000000L, j2, RoundingMode.FLOOR);
            }
            if (j4 != 0) {
                int i9 = Util.f5744a;
                jB02 = Util.b0(j4, 1000000L, j2, RoundingMode.FLOOR);
            }
            return new SsManifest(i5, i6, jB0, jB02, i7, z, protectionElement, streamElementArr);
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final void j(XmlPullParser xmlPullParser) throws ParserException {
            this.f7478f = ElementParser.i(xmlPullParser, "MajorVersion");
            this.f7479g = ElementParser.i(xmlPullParser, "MinorVersion");
            this.f7480h = ElementParser.h(xmlPullParser, "TimeScale", 10000000L);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Duration");
            if (attributeValue == null) {
                throw new MissingFieldException("Duration");
            }
            try {
                this.f7481i = Long.parseLong(attributeValue);
                this.f7482j = ElementParser.h(xmlPullParser, "DVRWindowLength", 0L);
                this.f7483k = ElementParser.g(xmlPullParser, "LookaheadCount");
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "IsLive");
                this.f7484l = attributeValue2 != null ? Boolean.parseBoolean(attributeValue2) : false;
                l(Long.valueOf(this.f7480h), "TimeScale");
            } catch (NumberFormatException e2) {
                throw ParserException.b(null, e2);
            }
        }
    }

    public static class StreamIndexParser extends ElementParser {

        /* renamed from: e, reason: collision with root package name */
        public final String f7486e;

        /* renamed from: f, reason: collision with root package name */
        public final LinkedList f7487f;

        /* renamed from: g, reason: collision with root package name */
        public int f7488g;

        /* renamed from: h, reason: collision with root package name */
        public String f7489h;

        /* renamed from: i, reason: collision with root package name */
        public long f7490i;

        /* renamed from: j, reason: collision with root package name */
        public String f7491j;

        /* renamed from: k, reason: collision with root package name */
        public String f7492k;

        /* renamed from: l, reason: collision with root package name */
        public int f7493l;

        /* renamed from: m, reason: collision with root package name */
        public int f7494m;
        public int n;
        public int o;
        public String p;
        public ArrayList q;
        public long r;

        public StreamIndexParser(ElementParser elementParser, String str) {
            super(elementParser, str, "StreamIndex");
            this.f7486e = str;
            this.f7487f = new LinkedList();
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final void a(Object obj) {
            if (obj instanceof Format) {
                this.f7487f.add((Format) obj);
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v0 androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest$StreamElement, still in use, count: 2, list:
              (r3v0 androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest$StreamElement) from 0x0082: MOVE (r26v0 androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest$StreamElement) = (r3v0 androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest$StreamElement) (LINE:131)
              (r3v0 androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest$StreamElement) from 0x004e: MOVE (r26v4 androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest$StreamElement) = (r3v0 androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest$StreamElement) (LINE:79)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
            	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
            	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
            */
        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final java.lang.Object b() {
            /*
                Method dump skipped, instructions count: 372
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.StreamIndexParser.b():java.lang.Object");
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final boolean d(String str) {
            return "c".equals(str);
        }

        @Override // androidx.media3.exoplayer.smoothstreaming.manifest.SsManifestParser.ElementParser
        public final void j(XmlPullParser xmlPullParser) throws ParserException {
            int i2 = 1;
            if (!"c".equals(xmlPullParser.getName())) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
                if (attributeValue == null) {
                    throw new MissingFieldException("Type");
                }
                if (!"audio".equalsIgnoreCase(attributeValue)) {
                    if ("video".equalsIgnoreCase(attributeValue)) {
                        i2 = 2;
                    } else {
                        if (!"text".equalsIgnoreCase(attributeValue)) {
                            throw ParserException.b("Invalid key value[" + attributeValue + "]", null);
                        }
                        i2 = 3;
                    }
                }
                this.f7488g = i2;
                l(Integer.valueOf(i2), "Type");
                if (this.f7488g == 3) {
                    String attributeValue2 = xmlPullParser.getAttributeValue(null, "Subtype");
                    if (attributeValue2 == null) {
                        throw new MissingFieldException("Subtype");
                    }
                    this.f7489h = attributeValue2;
                } else {
                    this.f7489h = xmlPullParser.getAttributeValue(null, "Subtype");
                }
                l(this.f7489h, "Subtype");
                String attributeValue3 = xmlPullParser.getAttributeValue(null, "Name");
                this.f7491j = attributeValue3;
                l(attributeValue3, "Name");
                String attributeValue4 = xmlPullParser.getAttributeValue(null, "Url");
                if (attributeValue4 == null) {
                    throw new MissingFieldException("Url");
                }
                this.f7492k = attributeValue4;
                this.f7493l = ElementParser.g(xmlPullParser, "MaxWidth");
                this.f7494m = ElementParser.g(xmlPullParser, "MaxHeight");
                this.n = ElementParser.g(xmlPullParser, "DisplayWidth");
                this.o = ElementParser.g(xmlPullParser, "DisplayHeight");
                String attributeValue5 = xmlPullParser.getAttributeValue(null, "Language");
                this.p = attributeValue5;
                l(attributeValue5, "Language");
                long jG = ElementParser.g(xmlPullParser, "TimeScale");
                this.f7490i = jG;
                if (jG == -1) {
                    this.f7490i = ((Long) c("TimeScale")).longValue();
                }
                this.q = new ArrayList();
                return;
            }
            int size = this.q.size();
            long jH = ElementParser.h(xmlPullParser, "t", -9223372036854775807L);
            if (jH == -9223372036854775807L) {
                if (size == 0) {
                    jH = 0;
                } else {
                    if (this.r == -1) {
                        throw ParserException.b("Unable to infer start time", null);
                    }
                    jH = this.r + ((Long) this.q.get(size - 1)).longValue();
                }
            }
            this.q.add(Long.valueOf(jH));
            this.r = ElementParser.h(xmlPullParser, "d", -9223372036854775807L);
            long jH2 = ElementParser.h(xmlPullParser, "r", 1L);
            if (jH2 > 1 && this.r == -9223372036854775807L) {
                throw ParserException.b("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j2 = i2;
                if (j2 >= jH2) {
                    return;
                }
                this.q.add(Long.valueOf((this.r * j2) + jH));
                i2++;
            }
        }
    }

    public SsManifestParser() {
        try {
            this.f7468a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.ParsingLoadable.Parser
    public final Object a(Uri uri, DataSourceInputStream dataSourceInputStream) throws XmlPullParserException, ParserException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f7468a.newPullParser();
            xmlPullParserNewPullParser.setInput(dataSourceInputStream, null);
            return (SsManifest) new SmoothStreamingMediaParser(uri.toString()).e(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e2) {
            throw ParserException.b(null, e2);
        }
    }
}
