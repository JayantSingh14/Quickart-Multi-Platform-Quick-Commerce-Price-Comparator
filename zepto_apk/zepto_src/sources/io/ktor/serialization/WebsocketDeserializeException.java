package io.ktor.serialization;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class WebsocketDeserializeException extends WebsocketContentConvertException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebsocketDeserializeException(String message, Frame frame) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(frame, "frame");
    }
}
