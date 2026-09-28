package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Charsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
/* loaded from: classes3.dex */
public final class WebvttCueParser {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f9453a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f9454b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c, reason: collision with root package name */
    public static final Map f9455c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f9456d;

    public static class Element {

        /* renamed from: c, reason: collision with root package name */
        public static final a f9457c = new a(0);

        /* renamed from: a, reason: collision with root package name */
        public final StartTag f9458a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9459b;

        public Element(StartTag startTag, int i2) {
            this.f9458a = startTag;
            this.f9459b = i2;
        }
    }

    public static final class StartTag {

        /* renamed from: a, reason: collision with root package name */
        public final String f9460a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9461b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9462c;

        /* renamed from: d, reason: collision with root package name */
        public final Set f9463d;

        public StartTag(String str, int i2, String str2, Set set) {
            this.f9461b = i2;
            this.f9460a = str;
            this.f9462c = str2;
            this.f9463d = set;
        }
    }

    public static final class StyleMatch implements Comparable<StyleMatch> {

        /* renamed from: a, reason: collision with root package name */
        public final int f9464a;

        /* renamed from: b, reason: collision with root package name */
        public final WebvttCssStyle f9465b;

        public StyleMatch(int i2, WebvttCssStyle webvttCssStyle) {
            this.f9464a = i2;
            this.f9465b = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        public final int compareTo(StyleMatch styleMatch) {
            return Integer.compare(this.f9464a, styleMatch.f9464a);
        }
    }

    public static final class WebvttCueInfoBuilder {

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f9468c;

        /* renamed from: a, reason: collision with root package name */
        public long f9466a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f9467b = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f9469d = 2;

        /* renamed from: e, reason: collision with root package name */
        public float f9470e = -3.4028235E38f;

        /* renamed from: f, reason: collision with root package name */
        public int f9471f = 1;

        /* renamed from: g, reason: collision with root package name */
        public int f9472g = 0;

        /* renamed from: h, reason: collision with root package name */
        public float f9473h = -3.4028235E38f;

        /* renamed from: i, reason: collision with root package name */
        public int f9474i = Integer.MIN_VALUE;

        /* renamed from: j, reason: collision with root package name */
        public float f9475j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        public int f9476k = Integer.MIN_VALUE;

        /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.media3.common.text.Cue.Builder a() {
            /*
                Method dump skipped, instructions count: 178
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder.a():androidx.media3.common.text.Cue$Builder");
        }
    }

    static {
        HashMap map = new HashMap();
        android.support.v4.media.a.p(255, 255, 255, map, "white");
        android.support.v4.media.a.p(0, 255, 0, map, "lime");
        android.support.v4.media.a.p(0, 255, 255, map, "cyan");
        android.support.v4.media.a.p(255, 0, 0, map, "red");
        android.support.v4.media.a.p(255, 255, 0, map, "yellow");
        android.support.v4.media.a.p(255, 0, 255, map, "magenta");
        android.support.v4.media.a.p(0, 0, 255, map, "blue");
        android.support.v4.media.a.p(0, 0, 0, map, "black");
        f9455c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        android.support.v4.media.a.p(255, 255, 255, map2, "bg_white");
        android.support.v4.media.a.p(0, 255, 0, map2, "bg_lime");
        android.support.v4.media.a.p(0, 255, 255, map2, "bg_cyan");
        android.support.v4.media.a.p(255, 0, 0, map2, "bg_red");
        android.support.v4.media.a.p(255, 255, 0, map2, "bg_yellow");
        android.support.v4.media.a.p(255, 0, 255, map2, "bg_magenta");
        android.support.v4.media.a.p(0, 0, 255, map2, "bg_blue");
        android.support.v4.media.a.p(0, 0, 0, map2, "bg_black");
        f9456d = Collections.unmodifiableMap(map2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:4:0x001e  */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.lang.String r19, androidx.media3.extractor.text.webvtt.WebvttCueParser.StartTag r20, java.util.List r21, android.text.SpannableStringBuilder r22, java.util.List r23) {
        /*
            Method dump skipped, instructions count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.webvtt.WebvttCueParser.a(java.lang.String, androidx.media3.extractor.text.webvtt.WebvttCueParser$StartTag, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList b(java.util.List r8, java.lang.String r9, androidx.media3.extractor.text.webvtt.WebvttCueParser.StartTag r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
        L7:
            int r3 = r8.size()
            if (r2 >= r3) goto L77
            java.lang.Object r3 = r8.get(r2)
            androidx.media3.extractor.text.webvtt.WebvttCssStyle r3 = (androidx.media3.extractor.text.webvtt.WebvttCssStyle) r3
            java.lang.String r4 = r10.f9460a
            java.lang.String r5 = r3.f9437a
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L3a
            java.lang.String r5 = r3.f9438b
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L3a
            java.util.Set r5 = r3.f9439c
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L3a
            java.lang.String r5 = r3.f9440d
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L3a
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            goto L6a
        L3a:
            java.lang.String r5 = r3.f9437a
            r6 = 1073741824(0x40000000, float:2.0)
            int r5 = androidx.media3.extractor.text.webvtt.WebvttCssStyle.a(r1, r6, r5, r9)
            java.lang.String r6 = r3.f9438b
            r7 = 2
            int r4 = androidx.media3.extractor.text.webvtt.WebvttCssStyle.a(r5, r7, r6, r4)
            java.lang.String r5 = r3.f9440d
            java.lang.String r6 = r10.f9462c
            r7 = 4
            int r4 = androidx.media3.extractor.text.webvtt.WebvttCssStyle.a(r4, r7, r5, r6)
            r5 = -1
            if (r4 == r5) goto L69
            java.util.Set r5 = r3.f9439c
            java.util.Set r6 = r10.f9463d
            boolean r5 = r6.containsAll(r5)
            if (r5 != 0) goto L60
            goto L69
        L60:
            java.util.Set r5 = r3.f9439c
            int r5 = r5.size()
            int r5 = r5 * r7
            int r4 = r4 + r5
            goto L6a
        L69:
            r4 = r1
        L6a:
            if (r4 <= 0) goto L74
            androidx.media3.extractor.text.webvtt.WebvttCueParser$StyleMatch r5 = new androidx.media3.extractor.text.webvtt.WebvttCueParser$StyleMatch
            r5.<init>(r4, r3)
            r0.add(r5)
        L74:
            int r2 = r2 + 1
            goto L7
        L77:
            java.util.Collections.sort(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.webvtt.WebvttCueParser.b(java.util.List, java.lang.String, androidx.media3.extractor.text.webvtt.WebvttCueParser$StartTag):java.util.ArrayList");
    }

    public static int c(List list, String str, StartTag startTag) {
        ArrayList arrayListB = b(list, str, startTag);
        for (int i2 = 0; i2 < arrayListB.size(); i2++) {
            int i3 = ((StyleMatch) arrayListB.get(i2)).f9465b.p;
            if (i3 != -1) {
                return i3;
            }
        }
        return -1;
    }

    public static WebvttCueInfo d(String str, Matcher matcher, ParsableByteArray parsableByteArray, ArrayList arrayList) {
        WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueInfoBuilder();
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            webvttCueInfoBuilder.f9466a = WebvttParserUtil.c(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            webvttCueInfoBuilder.f9467b = WebvttParserUtil.c(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            e(strGroup3, webvttCueInfoBuilder);
            StringBuilder sb = new StringBuilder();
            parsableByteArray.getClass();
            String strK = parsableByteArray.k(Charsets.f42260c);
            while (!TextUtils.isEmpty(strK)) {
                if (sb.length() > 0) {
                    sb.append(StringUtils.LF);
                }
                sb.append(strK.trim());
                strK = parsableByteArray.k(Charsets.f42260c);
            }
            webvttCueInfoBuilder.f9468c = f(str, sb.toString(), arrayList);
            return new WebvttCueInfo(webvttCueInfoBuilder.a().a(), webvttCueInfoBuilder.f9466a, webvttCueInfoBuilder.f9467b);
        } catch (NumberFormatException unused) {
            Log.h("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(java.lang.String r18, androidx.media3.extractor.text.webvtt.WebvttCueParser.WebvttCueInfoBuilder r19) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.webvtt.WebvttCueParser.e(java.lang.String, androidx.media3.extractor.text.webvtt.WebvttCueParser$WebvttCueInfoBuilder):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:69:0x0105. Please report as an issue. */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.text.SpannedString f(java.lang.String r18, java.lang.String r19, java.util.List r20) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.webvtt.WebvttCueParser.f(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    public static void g(String str, WebvttCueInfoBuilder webvttCueInfoBuilder) {
        String strSubstring;
        int i2 = 2;
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            strSubstring = str.substring(iIndexOf + 1);
            strSubstring.getClass();
            switch (strSubstring) {
                case "center":
                case "middle":
                    i2 = 1;
                    break;
                case "end":
                    break;
                case "start":
                    i2 = 0;
                    break;
                default:
                    Log.h("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                    i2 = Integer.MIN_VALUE;
                    break;
            }
            webvttCueInfoBuilder.f9472g = i2;
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            webvttCueInfoBuilder.f9470e = WebvttParserUtil.b(str);
            webvttCueInfoBuilder.f9471f = 0;
        } else {
            webvttCueInfoBuilder.f9470e = Integer.parseInt(str);
            webvttCueInfoBuilder.f9471f = 1;
        }
    }
}
