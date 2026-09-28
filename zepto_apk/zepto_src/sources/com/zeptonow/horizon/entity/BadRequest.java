package com.zeptonow.horizon.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class BadRequest extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadRequest(String message, Exception cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
