package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public class ReactNoCrashSoftException extends RuntimeException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNoCrashSoftException(@NotNull String m2) {
        super(m2);
        Intrinsics.checkNotNullParameter(m2, "m");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNoCrashSoftException(@NotNull Throwable e2) {
        super(e2);
        Intrinsics.checkNotNullParameter(e2, "e");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNoCrashSoftException(@NotNull String m2, @Nullable Throwable th) {
        super(m2, th);
        Intrinsics.checkNotNullParameter(m2, "m");
    }
}
