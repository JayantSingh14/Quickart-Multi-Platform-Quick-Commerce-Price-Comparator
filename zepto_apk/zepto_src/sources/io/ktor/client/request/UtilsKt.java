package io.ktor.client.request;

import io.ktor.http.HttpMessageBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class UtilsKt {
    public static final void a(HttpMessageBuilder httpMessageBuilder, String key, Object obj) {
        Intrinsics.checkNotNullParameter(httpMessageBuilder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (obj != null) {
            httpMessageBuilder.getHeaders().c(key, obj.toString());
            Unit unit = Unit.f53572a;
        }
    }
}
