package coil3.request;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface RequestDelegate {
    static /* synthetic */ Object awaitStarted$suspendImpl(RequestDelegate requestDelegate, Continuation<? super Unit> continuation) {
        return Unit.f53572a;
    }

    default void assertActive() {
    }

    @Nullable
    default Object awaitStarted(@NotNull Continuation<? super Unit> continuation) {
        return awaitStarted$suspendImpl(this, continuation);
    }

    default void complete() {
    }

    default void dispose() {
    }

    default void start() {
    }
}
