package io.ktor.http;

import io.ktor.http.Parameters;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class QueryKt {
    public static final void a(ParametersBuilderImpl parametersBuilderImpl, String str, int i2, int i3, int i4) {
        if (i3 == -1) {
            int iD = d(i2, i4, str);
            int iC = c(iD, i4, str);
            if (iC > iD) {
                String strSubstring = str.substring(iD, iC);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                parametersBuilderImpl.b(EmptyList.f53609a, strSubstring);
                return;
            }
            return;
        }
        int iD2 = d(i2, i3, str);
        int iC2 = c(iD2, i3, str);
        if (iC2 > iD2) {
            String strSubstring2 = str.substring(iD2, iC2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
            int iD3 = d(i3 + 1, i4, str);
            String strSubstring3 = str.substring(iD3, c(iD3, i4, str));
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
            parametersBuilderImpl.c(strSubstring2, strSubstring3);
        }
    }

    public static Parameters b(String query) {
        int i2;
        Intrinsics.checkNotNullParameter(query, "query");
        if (StringsKt.v(query) < 0) {
            Parameters.f50235b.getClass();
            return EmptyParameters.f50186d;
        }
        Parameters.Companion companion = Parameters.f50235b;
        ParametersBuilderImpl parametersBuilderImplA = ParametersKt.a();
        int iV = StringsKt.v(query);
        int i3 = 0;
        int i4 = -1;
        if (iV >= 0) {
            int i5 = 0;
            i2 = 0;
            int i6 = -1;
            while (i3 != 1000) {
                char cCharAt = query.charAt(i5);
                if (cCharAt == '&') {
                    a(parametersBuilderImplA, query, i2, i6, i5);
                    i2 = i5 + 1;
                    i3++;
                    i6 = -1;
                } else if (cCharAt == '=' && i6 == -1) {
                    i6 = i5;
                }
                if (i5 != iV) {
                    i5++;
                } else {
                    i4 = i6;
                }
            }
            return new ParametersImpl(parametersBuilderImplA.f50508b);
        }
        i2 = 0;
        if (i3 != 1000) {
            a(parametersBuilderImplA, query, i2, i4, query.length());
        }
        return new ParametersImpl(parametersBuilderImplA.f50508b);
    }

    public static final int c(int i2, int i3, String str) {
        while (i3 > i2 && CharsKt.b(str.charAt(i3 - 1))) {
            i3--;
        }
        return i3;
    }

    public static final int d(int i2, int i3, String str) {
        while (i2 < i3 && CharsKt.b(str.charAt(i2))) {
            i2++;
        }
        return i2;
    }
}
