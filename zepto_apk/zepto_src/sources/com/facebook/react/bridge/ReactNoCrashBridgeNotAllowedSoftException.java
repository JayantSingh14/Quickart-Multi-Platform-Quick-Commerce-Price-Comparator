package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class ReactNoCrashBridgeNotAllowedSoftException extends ReactNoCrashSoftException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNoCrashBridgeNotAllowedSoftException(@NotNull String m2) {
        super(m2);
        Intrinsics.checkNotNullParameter(m2, "m");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNoCrashBridgeNotAllowedSoftException(@NotNull Throwable e2) {
        super(e2);
        Intrinsics.checkNotNullParameter(e2, "e");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNoCrashBridgeNotAllowedSoftException(@NotNull String m2, @NotNull Throwable e2) {
        super(m2, e2);
        Intrinsics.checkNotNullParameter(m2, "m");
        Intrinsics.checkNotNullParameter(e2, "e");
    }
}
