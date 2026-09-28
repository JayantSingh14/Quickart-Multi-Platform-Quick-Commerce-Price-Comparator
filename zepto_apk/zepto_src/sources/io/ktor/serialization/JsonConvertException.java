package io.ktor.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class JsonConvertException extends ContentConvertException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonConvertException(String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
