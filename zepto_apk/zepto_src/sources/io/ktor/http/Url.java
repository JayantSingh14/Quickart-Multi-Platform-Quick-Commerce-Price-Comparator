package io.ktor.http;

import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Url {

    /* renamed from: a, reason: collision with root package name */
    public final URLProtocol f50260a;

    /* renamed from: b, reason: collision with root package name */
    public final String f50261b;

    /* renamed from: c, reason: collision with root package name */
    public final int f50262c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f50263d;

    /* renamed from: e, reason: collision with root package name */
    public final Parameters f50264e;

    /* renamed from: f, reason: collision with root package name */
    public final String f50265f;

    /* renamed from: g, reason: collision with root package name */
    public final String f50266g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f50267h;

    /* renamed from: i, reason: collision with root package name */
    public final String f50268i;

    /* renamed from: j, reason: collision with root package name */
    public final Lazy f50269j;

    /* renamed from: k, reason: collision with root package name */
    public final Lazy f50270k;

    /* renamed from: l, reason: collision with root package name */
    public final Lazy f50271l;

    /* renamed from: m, reason: collision with root package name */
    public final Lazy f50272m;
    public final Lazy n;
    public final Lazy o;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public Url(URLProtocol protocol, String host, int i2, ArrayList pathSegments, Parameters parameters, String fragment, String str, String str2, boolean z, String urlString) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        this.f50260a = protocol;
        this.f50261b = host;
        this.f50262c = i2;
        this.f50263d = pathSegments;
        this.f50264e = parameters;
        this.f50265f = str;
        this.f50266g = str2;
        this.f50267h = z;
        this.f50268i = urlString;
        if ((i2 < 0 || i2 >= 65536) && i2 != 0) {
            throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set");
        }
        this.f50269j = LazyKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedPath$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Url url = this.f50275c;
                if (url.f50263d.isEmpty()) {
                    return "";
                }
                int length = url.f50260a.f50257a.length() + 3;
                String str3 = url.f50268i;
                int iW = StringsKt.w(str3, '/', length, 4);
                if (iW == -1) {
                    return "";
                }
                int iF = StringsKt__StringsKt.f(str3, new char[]{'?', '#'}, iW, false);
                if (iF == -1) {
                    String strSubstring = str3.substring(iW);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                    return strSubstring;
                }
                String strSubstring2 = str3.substring(iW, iF);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring2;
            }
        });
        this.f50270k = LazyKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedQuery$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Url url = this.f50277c;
                int iW = StringsKt.w(url.f50268i, '?', 0, 6) + 1;
                if (iW == 0) {
                    return "";
                }
                String str3 = url.f50268i;
                int iW2 = StringsKt.w(str3, '#', iW, 4);
                if (iW2 == -1) {
                    String strSubstring = str3.substring(iW);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                    return strSubstring;
                }
                String strSubstring2 = str3.substring(iW, iW2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring2;
            }
        });
        this.f50271l = LazyKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedPathAndQuery$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Url url = this.f50276c;
                int iW = StringsKt.w(url.f50268i, '/', url.f50260a.f50257a.length() + 3, 4);
                if (iW == -1) {
                    return "";
                }
                String str3 = url.f50268i;
                int iW2 = StringsKt.w(str3, '#', iW, 4);
                if (iW2 == -1) {
                    String strSubstring = str3.substring(iW);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                    return strSubstring;
                }
                String strSubstring2 = str3.substring(iW, iW2);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring2;
            }
        });
        this.f50272m = LazyKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedUser$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Url url = this.f50278c;
                String str3 = url.f50265f;
                if (str3 == null) {
                    return null;
                }
                if (str3.length() == 0) {
                    return "";
                }
                int length = url.f50260a.f50257a.length() + 3;
                String str4 = url.f50268i;
                String strSubstring = str4.substring(length, StringsKt__StringsKt.f(str4, new char[]{':', '@'}, length, false));
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring;
            }
        });
        this.n = LazyKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedPassword$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Url url = this.f50274c;
                String str3 = url.f50266g;
                if (str3 == null) {
                    return null;
                }
                if (str3.length() == 0) {
                    return "";
                }
                int length = url.f50260a.f50257a.length() + 3;
                String str4 = url.f50268i;
                String strSubstring = str4.substring(StringsKt.w(str4, ':', length, 4) + 1, StringsKt.w(str4, '@', 0, 6));
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring;
            }
        });
        this.o = LazyKt.b(new Function0<String>() { // from class: io.ktor.http.Url$encodedFragment$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Url url = this.f50273c;
                int iW = StringsKt.w(url.f50268i, '#', 0, 6) + 1;
                if (iW == 0) {
                    return "";
                }
                String strSubstring = url.f50268i.substring(iW);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        });
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Url.class == obj.getClass() && Intrinsics.b(this.f50268i, ((Url) obj).f50268i);
    }

    public final int hashCode() {
        return this.f50268i.hashCode();
    }

    public final String toString() {
        return this.f50268i;
    }
}
