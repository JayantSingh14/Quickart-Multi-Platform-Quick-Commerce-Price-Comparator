package coil3.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface NetworkClient {
    @Nullable
    <T> Object executeRequest(@NotNull NetworkRequest networkRequest, @NotNull Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation);
}
