package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class URLProtocolKt {
    public static final boolean a(URLProtocol uRLProtocol) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "<this>");
        return Intrinsics.b(uRLProtocol.f50257a, "https") || Intrinsics.b(uRLProtocol.f50257a, "wss");
    }
}
