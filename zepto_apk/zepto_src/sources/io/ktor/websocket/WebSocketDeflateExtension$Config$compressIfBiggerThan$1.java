package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class WebSocketDeflateExtension$Config$compressIfBiggerThan$1 extends Lambda implements Function1<Frame, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Frame frame = (Frame) obj;
        Intrinsics.checkNotNullParameter(frame, "frame");
        return Boolean.valueOf(frame.f51442c.length > 0);
    }
}
