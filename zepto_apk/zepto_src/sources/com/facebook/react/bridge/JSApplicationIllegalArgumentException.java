package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class JSApplicationIllegalArgumentException extends JSApplicationCausedNativeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSApplicationIllegalArgumentException(@NotNull String detailMessage) {
        super(detailMessage);
        Intrinsics.checkNotNullParameter(detailMessage, "detailMessage");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JSApplicationIllegalArgumentException(@NotNull String detailMessage, @NotNull Throwable t) {
        super(detailMessage, t);
        Intrinsics.checkNotNullParameter(detailMessage, "detailMessage");
        Intrinsics.checkNotNullParameter(t, "t");
    }
}
