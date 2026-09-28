package in.juspay.hyper.core;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public interface CallbackInvoker {
    void invokeCallbackInDUIWebview(@Nullable String str, @Nullable String str2);

    void invokeFnInDUIWebview(@NotNull String str);
}
