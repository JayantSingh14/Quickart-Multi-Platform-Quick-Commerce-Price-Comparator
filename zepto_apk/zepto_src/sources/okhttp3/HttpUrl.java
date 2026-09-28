package okhttp3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.Buffer;
import org.xbill.DNS.Type;

@Metadata
/* loaded from: classes.dex */
public final class HttpUrl {

    /* renamed from: k, reason: collision with root package name */
    public static final char[] f56258k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public final String f56259a;

    /* renamed from: b, reason: collision with root package name */
    public final String f56260b;

    /* renamed from: c, reason: collision with root package name */
    public final String f56261c;

    /* renamed from: d, reason: collision with root package name */
    public final String f56262d;

    /* renamed from: e, reason: collision with root package name */
    public final int f56263e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f56264f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f56265g;

    /* renamed from: h, reason: collision with root package name */
    public final String f56266h;

    /* renamed from: i, reason: collision with root package name */
    public final String f56267i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f56268j;

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f56269a;

        /* renamed from: d, reason: collision with root package name */
        public String f56272d;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f56274f;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList f56275g;

        /* renamed from: h, reason: collision with root package name */
        public String f56276h;

        /* renamed from: b, reason: collision with root package name */
        public String f56270b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f56271c = "";

        /* renamed from: e, reason: collision with root package name */
        public int f56273e = -1;

        @Metadata
        public static final class Companion {
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f56274f = arrayList;
            arrayList.add("");
        }

        public final HttpUrl a() {
            ArrayList arrayList;
            String str = this.f56269a;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String strE = Companion.e(0, 0, 7, this.f56270b);
            String strE2 = Companion.e(0, 0, 7, this.f56271c);
            String str2 = this.f56272d;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iB = this.f56273e;
            if (iB == -1) {
                String str3 = this.f56269a;
                Intrinsics.c(str3);
                iB = Companion.b(str3);
            }
            ArrayList arrayList2 = this.f56274f;
            int i2 = iB;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.r(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(Companion.e(0, 0, 7, (String) it.next()));
            }
            ArrayList<String> arrayList4 = this.f56275g;
            if (arrayList4 != null) {
                ArrayList arrayList5 = new ArrayList(CollectionsKt.r(arrayList4, 10));
                for (String str4 : arrayList4) {
                    arrayList5.add(str4 != null ? Companion.e(0, 0, 3, str4) : null);
                }
                arrayList = arrayList5;
            } else {
                arrayList = null;
            }
            String str5 = this.f56276h;
            return new HttpUrl(str, strE, strE2, str2, i2, arrayList3, arrayList, str5 != null ? Companion.e(0, 0, 7, str5) : null, toString());
        }

        public final void b(String str) {
            String strA;
            this.f56275g = (str == null || (strA = Companion.a(0, 0, 211, str, " \"'<>#")) == null) ? null : Companion.f(strA);
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0124  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void c(okhttp3.HttpUrl r18, java.lang.String r19) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 882
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.c(okhttp3.HttpUrl, java.lang.String):void");
        }

        public final String toString() {
            StringBuilder out = new StringBuilder();
            String str = this.f56269a;
            if (str != null) {
                out.append(str);
                out.append("://");
            } else {
                out.append("//");
            }
            if (this.f56270b.length() > 0 || this.f56271c.length() > 0) {
                out.append(this.f56270b);
                if (this.f56271c.length() > 0) {
                    out.append(':');
                    out.append(this.f56271c);
                }
                out.append('@');
            }
            String str2 = this.f56272d;
            if (str2 != null) {
                if (StringsKt.o(str2, ':')) {
                    out.append('[');
                    out.append(this.f56272d);
                    out.append(']');
                } else {
                    out.append(this.f56272d);
                }
            }
            int iB = this.f56273e;
            if (iB != -1 || this.f56269a != null) {
                if (iB == -1) {
                    String str3 = this.f56269a;
                    Intrinsics.c(str3);
                    iB = Companion.b(str3);
                }
                String str4 = this.f56269a;
                if (str4 == null || iB != Companion.b(str4)) {
                    out.append(':');
                    out.append(iB);
                }
            }
            ArrayList arrayList = this.f56274f;
            Intrinsics.checkNotNullParameter(arrayList, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                out.append('/');
                out.append((String) arrayList.get(i2));
            }
            if (this.f56275g != null) {
                out.append('?');
                ArrayList arrayList2 = this.f56275g;
                Intrinsics.c(arrayList2);
                Companion.g(arrayList2, out);
            }
            if (this.f56276h != null) {
                out.append('#');
                out.append(this.f56276h);
            }
            String string = out.toString();
            Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    @Metadata
    public static final class Companion {
        public static String a(int i2, int i3, int i4, String str, String encodeSet) {
            int i5 = (i4 & 1) != 0 ? 0 : i2;
            int length = (i4 & 2) != 0 ? str.length() : i3;
            boolean z = (i4 & 8) == 0;
            boolean z2 = (i4 & 16) == 0;
            boolean z3 = (i4 & 32) == 0;
            boolean z4 = (i4 & 64) == 0;
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int iCharCount = i5;
            while (iCharCount < length) {
                int iCodePointAt = str.codePointAt(iCharCount);
                int i6 = 32;
                int i7 = 128;
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z4) || StringsKt.o(encodeSet, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z || (z2 && !d(iCharCount, length, str)))) || (iCodePointAt == 43 && z3)))) {
                    Buffer buffer = new Buffer();
                    buffer.W1(i5, iCharCount, str);
                    Buffer buffer2 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = str.codePointAt(iCharCount);
                        if (!z || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 == 43 && z3) {
                                buffer.X1(z ? "+" : "%2B");
                            } else if (iCodePointAt2 < i6 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i7 && !z4) || StringsKt.o(encodeSet, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z || (z2 && !d(iCharCount, length, str)))))) {
                                if (buffer2 == null) {
                                    buffer2 = new Buffer();
                                }
                                buffer2.Y1(iCodePointAt2);
                                while (!buffer2.l()) {
                                    byte bK0 = buffer2.k0();
                                    buffer.O1(37);
                                    char[] cArr = HttpUrl.f56258k;
                                    buffer.O1(cArr[((bK0 & 255) >> 4) & 15]);
                                    buffer.O1(cArr[bK0 & 15]);
                                }
                            } else {
                                buffer.Y1(iCodePointAt2);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i6 = 32;
                        i7 = 128;
                    }
                    return buffer.A1();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring = str.substring(i5, length);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public static int b(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.b(scheme, "http")) {
                return 80;
            }
            return Intrinsics.b(scheme, "https") ? 443 : -1;
        }

        public static HttpUrl c(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Builder builder = new Builder();
            builder.c(null, str);
            return builder.a();
        }

        public static boolean d(int i2, int i3, String str) {
            int i4 = i2 + 2;
            return i4 < i3 && str.charAt(i2) == '%' && Util.r(str.charAt(i2 + 1)) != -1 && Util.r(str.charAt(i4)) != -1;
        }

        public static String e(int i2, int i3, int i4, String str) {
            int i5;
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = str.length();
            }
            boolean z = (i4 & 4) == 0;
            Intrinsics.checkNotNullParameter(str, "<this>");
            int iCharCount = i2;
            while (iCharCount < i3) {
                char cCharAt = str.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z)) {
                    Buffer buffer = new Buffer();
                    buffer.W1(i2, iCharCount, str);
                    while (iCharCount < i3) {
                        int iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i5 = iCharCount + 2) < i3) {
                            int iR = Util.r(str.charAt(iCharCount + 1));
                            int iR2 = Util.r(str.charAt(i5));
                            if (iR == -1 || iR2 == -1) {
                                buffer.Y1(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            } else {
                                buffer.O1((iR << 4) + iR2);
                                iCharCount = Character.charCount(iCodePointAt) + i5;
                            }
                        } else if (iCodePointAt == 43 && z) {
                            buffer.O1(32);
                            iCharCount++;
                        } else {
                            buffer.Y1(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return buffer.A1();
                }
                iCharCount++;
            }
            String strSubstring = str.substring(i2, i3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public static ArrayList f(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 <= str.length()) {
                int iW = StringsKt.w(str, '&', i2, 4);
                if (iW == -1) {
                    iW = str.length();
                }
                int iW2 = StringsKt.w(str, '=', i2, 4);
                if (iW2 == -1 || iW2 > iW) {
                    String strSubstring = str.substring(i2, iW);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i2, iW2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iW2 + 1, iW);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i2 = iW + 1;
            }
            return arrayList;
        }

        public static void g(ArrayList arrayList, StringBuilder out) {
            Intrinsics.checkNotNullParameter(arrayList, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression intProgressionD = RangesKt.d(RangesKt.f(0, arrayList.size()), 2);
            int i2 = intProgressionD.f53838a;
            int i3 = intProgressionD.f53839b;
            int i4 = intProgressionD.f53840c;
            if ((i4 <= 0 || i2 > i3) && (i4 >= 0 || i3 > i2)) {
                return;
            }
            while (true) {
                String str = (String) arrayList.get(i2);
                String str2 = (String) arrayList.get(i2 + 1);
                if (i2 > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (i2 == i3) {
                    return;
                } else {
                    i2 += i4;
                }
            }
        }
    }

    public HttpUrl(String scheme, String username, String password, String host, int i2, ArrayList pathSegments, ArrayList arrayList, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f56259a = scheme;
        this.f56260b = username;
        this.f56261c = password;
        this.f56262d = host;
        this.f56263e = i2;
        this.f56264f = pathSegments;
        this.f56265g = arrayList;
        this.f56266h = str;
        this.f56267i = url;
        this.f56268j = Intrinsics.b(scheme, "https");
    }

    public final String a() {
        if (this.f56261c.length() == 0) {
            return "";
        }
        int length = this.f56259a.length() + 3;
        String str = this.f56267i;
        String strSubstring = str.substring(StringsKt.w(str, ':', length, 4) + 1, StringsKt.w(str, '@', 0, 6));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f56259a.length() + 3;
        String str = this.f56267i;
        int iW = StringsKt.w(str, '/', length, 4);
        String strSubstring = str.substring(iW, Util.e(iW, str.length(), str, "?#"));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f56259a.length() + 3;
        String str = this.f56267i;
        int iW = StringsKt.w(str, '/', length, 4);
        int iE = Util.e(iW, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iW < iE) {
            int i2 = iW + 1;
            int iF = Util.f(str, '/', i2, iE);
            String strSubstring = str.substring(i2, iF);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iW = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f56265g == null) {
            return null;
        }
        String str = this.f56267i;
        int iW = StringsKt.w(str, '?', 0, 6) + 1;
        String strSubstring = str.substring(iW, Util.f(str, '#', iW, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.f56260b.length() == 0) {
            return "";
        }
        int length = this.f56259a.length() + 3;
        String str = this.f56267i;
        String strSubstring = str.substring(length, Util.e(length, str.length(), str, ":@"));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics.b(((HttpUrl) obj).f56267i, this.f56267i);
    }

    public final Builder f(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            Builder builder = new Builder();
            builder.c(this, link);
            return builder;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String g() {
        Builder builderF = f("/...");
        Intrinsics.c(builderF);
        Intrinsics.checkNotNullParameter("", "username");
        builderF.f56270b = Companion.a(0, 0, Type.IXFR, "", " \"':;<=>@[]^`{}|/\\?#");
        Intrinsics.checkNotNullParameter("", "password");
        builderF.f56271c = Companion.a(0, 0, Type.IXFR, "", " \"':;<=>@[]^`{}|/\\?#");
        return builderF.a().f56267i;
    }

    public final HttpUrl h(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Builder builderF = f(link);
        if (builderF != null) {
            return builderF.a();
        }
        return null;
    }

    public final int hashCode() {
        return this.f56267i.hashCode();
    }

    public final URI i() {
        String strSubstring;
        Builder builder = new Builder();
        String str = this.f56259a;
        builder.f56269a = str;
        String strE = e();
        Intrinsics.checkNotNullParameter(strE, "<set-?>");
        builder.f56270b = strE;
        String strA = a();
        Intrinsics.checkNotNullParameter(strA, "<set-?>");
        builder.f56271c = strA;
        builder.f56272d = this.f56262d;
        int iB = Companion.b(str);
        int i2 = this.f56263e;
        if (i2 == iB) {
            i2 = -1;
        }
        builder.f56273e = i2;
        ArrayList arrayList = builder.f56274f;
        arrayList.clear();
        arrayList.addAll(c());
        builder.b(d());
        if (this.f56266h == null) {
            strSubstring = null;
        } else {
            String str2 = this.f56267i;
            strSubstring = str2.substring(StringsKt.w(str2, '#', 0, 6) + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        }
        builder.f56276h = strSubstring;
        String str3 = builder.f56272d;
        builder.f56272d = str3 != null ? new Regex("[\"<>^`{|}]").replace(str3, "") : null;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.set(i3, Companion.a(0, 0, 227, (String) arrayList.get(i3), "[]"));
        }
        ArrayList arrayList2 = builder.f56275g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                String str4 = (String) arrayList2.get(i4);
                arrayList2.set(i4, str4 != null ? Companion.a(0, 0, 195, str4, "\\^`{|}") : null);
            }
        }
        String str5 = builder.f56276h;
        builder.f56276h = str5 != null ? Companion.a(0, 0, 163, str5, " \"#<>\\^`{|}") : null;
        String string = builder.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics.checkNotNullExpressionValue(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public final URL j() {
        try {
            return new URL(this.f56267i);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final String toString() {
        return this.f56267i;
    }
}
