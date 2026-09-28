package io.ktor.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public class WebsocketContentConvertException extends ContentConvertException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebsocketContentConvertException(String message) {
        super(message, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
