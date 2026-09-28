package io.ktor.client.plugins.cache;

import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

@Metadata
/* loaded from: classes3.dex */
public final class HttpCacheKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f49732a = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.HttpCache");

    public static final Function1 a(OutgoingContent content, Function1 headerExtractor, Function1 allHeadersExtractor) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(headerExtractor, "headerExtractor");
        Intrinsics.checkNotNullParameter(allHeadersExtractor, "allHeadersExtractor");
        return new HttpCacheKt$mergedHeadersLookup$1(content, headerExtractor, allHeadersExtractor);
    }
}
