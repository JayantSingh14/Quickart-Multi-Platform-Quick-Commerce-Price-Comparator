package io.ktor.client.plugins.cache;

import io.ktor.http.Headers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class HttpCache$findResponse$requestHeaders$1 extends FunctionReferenceImpl implements Function1<String, String> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String p0 = (String) obj;
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((Headers) this.receiver).b(p0);
    }
}
