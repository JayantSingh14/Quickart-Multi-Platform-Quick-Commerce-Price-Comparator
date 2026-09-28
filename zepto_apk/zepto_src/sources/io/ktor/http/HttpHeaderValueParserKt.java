package io.ktor.http;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HttpHeaderValueParserKt {
    public static final List a(String str) {
        int i2;
        Pair pair;
        Pair pair2;
        if (str == null) {
            return EmptyList.f53609a;
        }
        Lazy lazyA = LazyKt.a(LazyThreadSafetyMode.f53530c, HttpHeaderValueParserKt$parseHeaderValue$items$1.f50202c);
        for (int i3 = 0; i3 <= StringsKt.v(str); i3 = i2) {
            Lazy lazyA2 = LazyKt.a(LazyThreadSafetyMode.f53530c, HttpHeaderValueParserKt$parseHeaderValueItem$parameters$1.f50203c);
            Integer numValueOf = null;
            i2 = i3;
            while (true) {
                if (i2 <= StringsKt.v(str)) {
                    char cCharAt = str.charAt(i2);
                    if (cCharAt == ',') {
                        ((ArrayList) lazyA.getValue()).add(new HeaderValue(c(i3, numValueOf != null ? numValueOf.intValue() : i2, str), lazyA2.d() ? (List) lazyA2.getValue() : EmptyList.f53609a));
                        i2++;
                    } else if (cCharAt == ';') {
                        if (numValueOf == null) {
                            numValueOf = Integer.valueOf(i2);
                        }
                        int i4 = i2 + 1;
                        int i5 = i4;
                        while (i5 <= StringsKt.v(str)) {
                            char cCharAt2 = str.charAt(i5);
                            if (cCharAt2 != '=') {
                                if (cCharAt2 == ';' || cCharAt2 == ',') {
                                    b(lazyA2, str, i4, i5, "");
                                    break;
                                }
                                i5++;
                            } else {
                                int i6 = i5 + 1;
                                if (str.length() == i6) {
                                    pair2 = new Pair(Integer.valueOf(i6), "");
                                } else {
                                    char c2 = '\"';
                                    if (str.charAt(i6) == '\"') {
                                        int i7 = i5 + 2;
                                        StringBuilder sb = new StringBuilder();
                                        while (i7 <= StringsKt.v(str)) {
                                            char cCharAt3 = str.charAt(i7);
                                            if (cCharAt3 == c2) {
                                                int i8 = i7 + 1;
                                                int i9 = i8;
                                                while (i9 < str.length() && str.charAt(i9) == ' ') {
                                                    i9++;
                                                }
                                                if (i9 == str.length() || str.charAt(i9) == ';') {
                                                    Integer numValueOf2 = Integer.valueOf(i8);
                                                    String string = sb.toString();
                                                    Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
                                                    pair = new Pair(numValueOf2, string);
                                                    break;
                                                }
                                            }
                                            if (cCharAt3 != '\\' || i7 >= StringsKt.v(str) - 2) {
                                                sb.append(cCharAt3);
                                                i7++;
                                            } else {
                                                sb.append(str.charAt(i7 + 1));
                                                i7 += 2;
                                            }
                                            c2 = '\"';
                                        }
                                        Integer numValueOf3 = Integer.valueOf(i7);
                                        String string2 = sb.toString();
                                        Intrinsics.checkNotNullExpressionValue(string2, "builder.toString()");
                                        pair = new Pair(numValueOf3, "\"" + string2);
                                    } else {
                                        int i10 = i6;
                                        while (i10 <= StringsKt.v(str)) {
                                            char cCharAt4 = str.charAt(i10);
                                            if (cCharAt4 == ';' || cCharAt4 == ',') {
                                                pair = new Pair(Integer.valueOf(i10), c(i6, i10, str));
                                                break;
                                            }
                                            i10++;
                                        }
                                        pair = new Pair(Integer.valueOf(i10), c(i6, i10, str));
                                    }
                                    pair2 = pair;
                                }
                                int iIntValue = ((Number) pair2.f53533a).intValue();
                                b(lazyA2, str, i4, i5, (String) pair2.f53534b);
                                i2 = iIntValue;
                            }
                        }
                        b(lazyA2, str, i4, i5, "");
                        i2 = i5;
                    } else {
                        i2++;
                    }
                } else {
                    ((ArrayList) lazyA.getValue()).add(new HeaderValue(c(i3, numValueOf != null ? numValueOf.intValue() : i2, str), lazyA2.d() ? (List) lazyA2.getValue() : EmptyList.f53609a));
                }
            }
        }
        return lazyA.d() ? (List) lazyA.getValue() : EmptyList.f53609a;
    }

    public static final void b(Lazy lazy, String str, int i2, int i3, String str2) {
        String strC = c(i2, i3, str);
        if (strC.length() == 0) {
            return;
        }
        ((ArrayList) lazy.getValue()).add(new HeaderValueParam(strC, str2));
    }

    public static final String c(int i2, int i3, String str) {
        String strSubstring = str.substring(i2, i3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringsKt.b0(strSubstring).toString();
    }
}
