package io.ktor.http.auth;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes3.dex */
public final class HttpAuthHeaderKt {
    static {
        Character chValueOf = Character.valueOf(Soundex.SILENT_MARKER);
        Character chValueOf2 = Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        Character[] elements = {'!', '#', '$', '%', '&', '\'', '*', '+', chValueOf, chValueOf2, '^', '_', '`', '|', '~'};
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArraysKt.H(elements);
        Character[] elements2 = {chValueOf, chValueOf2, '_', '~', '+', '/'};
        Intrinsics.checkNotNullParameter(elements2, "elements");
        ArraysKt.H(elements2);
        new Regex("[a-zA-Z0-9\\-._~+/]+=*");
        new Regex("\\\\.");
    }
}
