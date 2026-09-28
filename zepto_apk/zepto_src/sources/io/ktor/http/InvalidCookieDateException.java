package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class InvalidCookieDateException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidCookieDateException(String data, String reason) {
        super("Failed to parse date string: \"" + data + "\". Reason: \"" + reason + '\"');
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(reason, "reason");
    }
}
