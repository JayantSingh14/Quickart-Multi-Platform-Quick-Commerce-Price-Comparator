package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class RetryableMountingLayerException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryableMountingLayerException(@NotNull String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryableMountingLayerException(@NotNull Throwable e2) {
        super(e2);
        Intrinsics.checkNotNullParameter(e2, "e");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryableMountingLayerException(@NotNull String msg, @Nullable Throwable th) {
        super(msg, th);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }
}
