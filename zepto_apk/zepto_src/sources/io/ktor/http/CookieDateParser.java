package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CookieDateParser {
    public static void a(String str, String str2, Object obj) {
        if (obj == null) {
            throw new InvalidCookieDateException(str, "Could not find ".concat(str2));
        }
    }

    public static void b(String str, boolean z, Function0 function0) {
        if (!z) {
            throw new InvalidCookieDateException(str, (String) function0.invoke());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static io.ktor.util.date.GMTDate c(java.lang.String r11) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CookieDateParser.c(java.lang.String):io.ktor.util.date.GMTDate");
    }
}
