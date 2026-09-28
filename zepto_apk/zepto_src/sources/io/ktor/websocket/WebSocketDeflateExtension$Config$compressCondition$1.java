package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class WebSocketDeflateExtension$Config$compressCondition$1 extends Lambda implements Function1<Frame, Boolean> {

    /* renamed from: c, reason: collision with root package name */
    public static final WebSocketDeflateExtension$Config$compressCondition$1 f51512c = new WebSocketDeflateExtension$Config$compressCondition$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Frame it = (Frame) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return Boolean.TRUE;
    }
}
