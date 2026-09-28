package io.ktor.http;

import io.ktor.util.StringValuesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class URLUtilsKt {
    public static final Url a(String urlString) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        return URLParserKt.b(new URLBuilder(0), urlString).b();
    }

    public static final void b(URLBuilder uRLBuilder, URLBuilder url) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        uRLBuilder.e(url.f50241a);
        uRLBuilder.d(url.f50242b);
        uRLBuilder.f50243c = url.f50243c;
        uRLBuilder.c(url.f50248h);
        uRLBuilder.f50245e = url.f50245e;
        uRLBuilder.f50246f = url.f50246f;
        ParametersBuilderImpl value = ParametersKt.a();
        StringValuesKt.a(value, url.f50249i);
        Intrinsics.checkNotNullParameter(value, "value");
        uRLBuilder.f50249i = value;
        uRLBuilder.f50250j = new UrlDecodedParametersBuilder(value);
        String str = url.f50247g;
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        uRLBuilder.f50247g = str;
        uRLBuilder.f50244d = url.f50244d;
    }
}
