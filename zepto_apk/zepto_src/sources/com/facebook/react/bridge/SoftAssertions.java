package com.facebook.react.bridge;

import com.facebook.react.bridge.ReactSoftExceptionLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class SoftAssertions {

    @NotNull
    public static final SoftAssertions INSTANCE = new SoftAssertions();

    private SoftAssertions() {
    }

    @JvmStatic
    public static final void assertCondition(boolean z, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (z) {
            return;
        }
        ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SOFT_ASSERTIONS, new AssertionException(message));
    }

    @JvmStatic
    @Nullable
    public static final <T> T assertNotNull(@Nullable T t) {
        if (t == null) {
            ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SOFT_ASSERTIONS, new AssertionException("Expected object to not be null!"));
        }
        return t;
    }

    @JvmStatic
    public static final void assertUnreachable(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        ReactSoftExceptionLogger.logSoftException(ReactSoftExceptionLogger.Categories.SOFT_ASSERTIONS, new AssertionException(message));
    }
}
