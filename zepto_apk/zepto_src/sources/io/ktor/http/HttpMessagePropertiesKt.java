package io.ktor.http;

import coil3.network.internal.UtilsKt;
import io.ktor.http.ContentType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HttpMessagePropertiesKt {
    public static final List a(HttpMessage httpMessage) {
        List listA;
        Intrinsics.checkNotNullParameter(httpMessage, "<this>");
        Headers headers = httpMessage.getHeaders();
        List list = HttpHeaders.f50204a;
        String strB = headers.b(UtilsKt.CACHE_CONTROL);
        return (strB == null || (listA = HttpHeaderValueParserKt.a(strB)) == null) ? EmptyList.f53609a : listA;
    }

    public static final ContentType b(HttpMessageBuilder httpMessageBuilder) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        HeadersBuilder headers = httpMessageBuilder.getHeaders();
        List list = HttpHeaders.f50204a;
        String strH = headers.h(UtilsKt.CONTENT_TYPE);
        if (strH == null) {
            return null;
        }
        ContentType contentType = ContentType.f50126e;
        return ContentType.Companion.a(strH);
    }
}
