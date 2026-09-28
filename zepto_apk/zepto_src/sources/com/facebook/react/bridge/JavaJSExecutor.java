package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public interface JavaJSExecutor {

    @Metadata
    public interface Factory {
        @Nullable
        JavaJSExecutor create() throws Exception;
    }

    @Metadata
    public static final class ProxyExecutorException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProxyExecutorException(@NotNull Throwable cause) {
            super(cause);
            Intrinsics.checkNotNullParameter(cause, "cause");
        }
    }

    void close();

    @DoNotStrip
    @Nullable
    String executeJSCall(@NotNull String str, @Nullable String str2) throws ProxyExecutorException;

    @DoNotStrip
    void loadBundle(@NotNull String str) throws ProxyExecutorException;

    @DoNotStrip
    void setGlobalVariable(@NotNull String str, @NotNull String str2);
}
