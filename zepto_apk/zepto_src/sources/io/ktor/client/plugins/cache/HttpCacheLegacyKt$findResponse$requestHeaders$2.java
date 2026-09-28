package io.ktor.client.plugins.cache;

import io.ktor.http.Headers;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class HttpCacheLegacyKt$findResponse$requestHeaders$2 extends FunctionReferenceImpl implements Function1<String, List<? extends String>> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String p0 = (String) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((Headers) this.receiver).a(p0);
    }
}
