package io.ktor.client.call;

import coil3.network.internal.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class NoTransformationFoundException extends UnsupportedOperationException {

    /* renamed from: a, reason: collision with root package name */
    public final String f49312a;

    public NoTransformationFoundException(HttpResponse response, ClassReference from, KClass to) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        StringBuilder sb = new StringBuilder("\n        Expected response body of the type '");
        sb.append(to);
        sb.append("' but was '");
        sb.append(from);
        sb.append("'\n        In response from `");
        sb.append(HttpResponseKt.d(response).N());
        sb.append("`\n        Response status `");
        sb.append(response.e());
        sb.append("`\n        Response header `ContentType: ");
        Headers headers = response.getHeaders();
        List list = HttpHeaders.f50204a;
        sb.append(headers.b(UtilsKt.CONTENT_TYPE));
        sb.append("` \n        Request header `Accept: ");
        sb.append(HttpResponseKt.d(response).getHeaders().b("Accept"));
        sb.append("`\n        \n        You can read how to resolve NoTransformationFoundException at FAQ: \n        https://ktor.io/docs/faq.html#no-transformation-found-exception\n    ");
        this.f49312a = StringsKt.e0(sb.toString());
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f49312a;
    }
}
