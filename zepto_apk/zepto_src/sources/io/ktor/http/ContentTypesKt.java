package io.ktor.http;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ContentTypesKt {
    public static final Charset a(ContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, "<this>");
        String strA = contentType.a("charset");
        if (strA == null) {
            return null;
        }
        try {
            return Charset.forName(strA);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final ContentType b(ContentType contentType, Charset charset) {
        Intrinsics.checkNotNullParameter(contentType, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return contentType.c(CharsetJVMKt.d(charset));
    }

    public static final ContentType c(ContentType contentType, Charset charset) {
        Intrinsics.checkNotNullParameter(contentType, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String lowerCase = contentType.f50127c.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return !Intrinsics.b(lowerCase, "text") ? contentType : contentType.c(CharsetJVMKt.d(charset));
    }
}
