package io.ktor.http;

import android.support.v4.media.b;
import coil3.util.UtilsKt;
import io.ktor.util.CharsetKt;
import io.ktor.util.TextKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class URLParserKt {

    /* renamed from: a, reason: collision with root package name */
    public static final List f50251a = CollectionsKt.H("");

    public static final int a(int i2, int i3, String str) {
        boolean z = false;
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '[') {
                z = true;
            } else if (cCharAt == ']') {
                z = false;
            } else if (cCharAt == ':' && !z) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final URLBuilder b(URLBuilder uRLBuilder, String urlString) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        if (StringsKt.z(urlString)) {
            return uRLBuilder;
        }
        try {
            c(uRLBuilder, urlString);
            return uRLBuilder;
        } catch (Throwable th) {
            throw new URLParserException(urlString, th);
        }
    }

    public static final void c(final URLBuilder uRLBuilder, String urlString) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        List listM;
        int iIntValue;
        char c2;
        int i8 = 1;
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        int length = urlString.length();
        int i9 = 0;
        while (true) {
            if (i9 >= length) {
                i9 = -1;
                break;
            } else if (!CharsKt.b(urlString.charAt(i9))) {
                break;
            } else {
                i9++;
            }
        }
        int length2 = urlString.length() - 1;
        if (length2 >= 0) {
            while (true) {
                int i10 = length2 - 1;
                if (!CharsKt.b(urlString.charAt(length2))) {
                    break;
                } else if (i10 < 0) {
                    break;
                } else {
                    length2 = i10;
                }
            }
            length2 = -1;
        } else {
            length2 = -1;
        }
        int i11 = length2 + 1;
        char cCharAt = urlString.charAt(i9);
        if (('a' > cCharAt || cCharAt >= '{') && ('A' > cCharAt || cCharAt >= '[')) {
            i2 = i9;
            i3 = i2;
        } else {
            i3 = -1;
            i2 = i9;
        }
        while (true) {
            i4 = i8;
            if (i2 >= i11) {
                break;
            }
            char cCharAt2 = urlString.charAt(i2);
            if (cCharAt2 == ':') {
                if (i3 != -1) {
                    throw new IllegalArgumentException(b.f(i3, "Illegal character in scheme at position "));
                }
                i5 = i2 - i9;
            } else {
                if (cCharAt2 == '/' || cCharAt2 == '?' || cCharAt2 == '#') {
                    break;
                }
                if (i3 != -1 || ('a' <= cCharAt2 && cCharAt2 < '{')) {
                    c2 = '[';
                } else {
                    c2 = '[';
                    if (('A' > cCharAt2 || cCharAt2 >= '[') && (('0' > cCharAt2 || cCharAt2 >= ':') && cCharAt2 != '.' && cCharAt2 != '+' && cCharAt2 != '-')) {
                        i3 = i2;
                    }
                }
                i2++;
                i8 = i4;
            }
        }
        i5 = -1;
        if (i5 > 0) {
            String name = urlString.substring(i9, i9 + i5);
            Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String…ing(startIndex, endIndex)");
            URLProtocol uRLProtocol = URLProtocol.f50253c;
            Intrinsics.checkNotNullParameter(name, "name");
            String strB = TextKt.b(name);
            URLProtocol uRLProtocol2 = (URLProtocol) URLProtocol.f50256f.get(strB);
            if (uRLProtocol2 == null) {
                uRLProtocol2 = new URLProtocol(strB, 0);
            }
            uRLBuilder.getClass();
            Intrinsics.checkNotNullParameter(uRLProtocol2, "<set-?>");
            uRLBuilder.f50241a = uRLProtocol2;
            i9 += i5 + 1;
        }
        int i12 = 0;
        while (true) {
            i6 = i9 + i12;
            if (i6 >= i11 || urlString.charAt(i6) != '/') {
                break;
            } else {
                i12++;
            }
        }
        if (Intrinsics.b(uRLBuilder.f50241a.f50257a, UtilsKt.SCHEME_FILE)) {
            if (i12 != 2) {
                if (i12 != 3) {
                    throw new IllegalArgumentException("Invalid file url: ".concat(urlString));
                }
                Intrinsics.checkNotNullParameter("", "<set-?>");
                uRLBuilder.f50242b = "";
                StringBuilder sb = new StringBuilder("/");
                String strSubstring = urlString.substring(i6, i11);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb.append(strSubstring);
                URLBuilderKt.d(uRLBuilder, sb.toString());
                return;
            }
            int iW = StringsKt.w(urlString, '/', i6, 4);
            if (iW == -1 || iW == i11) {
                String strSubstring2 = urlString.substring(i6, i11);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                uRLBuilder.d(strSubstring2);
                return;
            } else {
                String strSubstring3 = urlString.substring(i6, iW);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                uRLBuilder.d(strSubstring3);
                String strSubstring4 = urlString.substring(iW, i11);
                Intrinsics.checkNotNullExpressionValue(strSubstring4, "this as java.lang.String…ing(startIndex, endIndex)");
                URLBuilderKt.d(uRLBuilder, strSubstring4);
                return;
            }
        }
        if (Intrinsics.b(uRLBuilder.f50241a.f50257a, "mailto")) {
            if (i12 != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            int iX = StringsKt.x(urlString, "@", i6, false, 4);
            if (iX == -1) {
                throw new IllegalArgumentException(b.D("Invalid mailto url: ", urlString, ", it should contain '@'."));
            }
            String strSubstring5 = urlString.substring(i6, iX);
            Intrinsics.checkNotNullExpressionValue(strSubstring5, "this as java.lang.String…ing(startIndex, endIndex)");
            String strD = CodecsKt.d(strSubstring5);
            uRLBuilder.f50245e = strD != null ? CodecsKt.f(strD, false) : null;
            String strSubstring6 = urlString.substring(iX + 1, i11);
            Intrinsics.checkNotNullExpressionValue(strSubstring6, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.d(strSubstring6);
            return;
        }
        if (i12 >= 2) {
            while (true) {
                int iF = StringsKt__StringsKt.f(urlString, CharsetKt.a("@/\\?#"), i6, false);
                Integer numValueOf = Integer.valueOf(iF);
                if (iF <= 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : i11;
                if (iIntValue >= i11 || urlString.charAt(iIntValue) != '@') {
                    break;
                }
                int iA = a(i6, iIntValue, urlString);
                if (iA != -1) {
                    String strSubstring7 = urlString.substring(i6, iA);
                    Intrinsics.checkNotNullExpressionValue(strSubstring7, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.f50245e = strSubstring7;
                    String strSubstring8 = urlString.substring(iA + 1, iIntValue);
                    Intrinsics.checkNotNullExpressionValue(strSubstring8, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.f50246f = strSubstring8;
                } else {
                    String strSubstring9 = urlString.substring(i6, iIntValue);
                    Intrinsics.checkNotNullExpressionValue(strSubstring9, "this as java.lang.String…ing(startIndex, endIndex)");
                    uRLBuilder.f50245e = strSubstring9;
                }
                i6 = iIntValue + 1;
            }
            int iA2 = a(i6, iIntValue, urlString);
            Integer numValueOf2 = Integer.valueOf(iA2);
            if (iA2 <= 0) {
                numValueOf2 = null;
            }
            int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : iIntValue;
            String strSubstring10 = urlString.substring(i6, iIntValue2);
            Intrinsics.checkNotNullExpressionValue(strSubstring10, "this as java.lang.String…ing(startIndex, endIndex)");
            uRLBuilder.d(strSubstring10);
            int i13 = iIntValue2 + 1;
            if (i13 < iIntValue) {
                String strSubstring11 = urlString.substring(i13, iIntValue);
                Intrinsics.checkNotNullExpressionValue(strSubstring11, "this as java.lang.String…ing(startIndex, endIndex)");
                uRLBuilder.f50243c = Integer.parseInt(strSubstring11);
            } else {
                uRLBuilder.f50243c = 0;
            }
            i6 = iIntValue;
        }
        List list = f50251a;
        if (i6 >= i11) {
            if (urlString.charAt(length2) != '/') {
                list = EmptyList.f53609a;
            }
            uRLBuilder.c(list);
            return;
        }
        uRLBuilder.c(i12 == 0 ? CollectionsKt.w(i4, uRLBuilder.f50248h) : EmptyList.f53609a);
        int iF2 = StringsKt__StringsKt.f(urlString, CharsetKt.a("?#"), i6, false);
        Integer numValueOf3 = Integer.valueOf(iF2);
        if (iF2 <= 0) {
            numValueOf3 = null;
        }
        int iIntValue3 = numValueOf3 != null ? numValueOf3.intValue() : i11;
        if (iIntValue3 > i6) {
            String strSubstring12 = urlString.substring(i6, iIntValue3);
            Intrinsics.checkNotNullExpressionValue(strSubstring12, "this as java.lang.String…ing(startIndex, endIndex)");
            Collection collection = (uRLBuilder.f50248h.size() == 1 && ((CharSequence) CollectionsKt.z(uRLBuilder.f50248h)).length() == 0) ? EmptyList.f53609a : uRLBuilder.f50248h;
            if (Intrinsics.b(strSubstring12, "/")) {
                listM = list;
                i7 = 1;
            } else {
                i7 = 1;
                listM = StringsKt.M(strSubstring12, new char[]{'/'});
            }
            if (i12 != i7) {
                list = EmptyList.f53609a;
            }
            ArrayList arrayListL = CollectionsKt.L(collection, CollectionsKt.L(list, listM));
            Intrinsics.checkNotNullParameter(arrayListL, "<set-?>");
            uRLBuilder.f50248h = arrayListL;
            i6 = iIntValue3;
        }
        if (i6 < i11 && urlString.charAt(i6) == '?') {
            int i14 = i6 + 1;
            if (i14 == i11) {
                uRLBuilder.f50244d = true;
                i6 = i11;
            } else {
                int iW2 = StringsKt.w(urlString, '#', i14, 4);
                Integer numValueOf4 = iW2 > 0 ? Integer.valueOf(iW2) : null;
                int iIntValue4 = numValueOf4 != null ? numValueOf4.intValue() : i11;
                String strSubstring13 = urlString.substring(i14, iIntValue4);
                Intrinsics.checkNotNullExpressionValue(strSubstring13, "this as java.lang.String…ing(startIndex, endIndex)");
                QueryKt.b(strSubstring13).c(new Function2<String, List<? extends String>, Unit>() { // from class: io.ktor.http.URLParserKt$parseQuery$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        String key = (String) obj;
                        List values = (List) obj2;
                        Intrinsics.checkNotNullParameter(key, "key");
                        Intrinsics.checkNotNullParameter(values, "values");
                        uRLBuilder.f50249i.b(values, key);
                        return Unit.f53572a;
                    }
                });
                i6 = iIntValue4;
            }
        }
        if (i6 >= i11 || urlString.charAt(i6) != '#') {
            return;
        }
        String strSubstring14 = urlString.substring(i6 + 1, i11);
        Intrinsics.checkNotNullExpressionValue(strSubstring14, "this as java.lang.String…ing(startIndex, endIndex)");
        Intrinsics.checkNotNullParameter(strSubstring14, "<set-?>");
        uRLBuilder.f50247g = strSubstring14;
    }
}
