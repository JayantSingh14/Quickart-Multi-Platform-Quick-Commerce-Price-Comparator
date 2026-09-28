package coil3.util;

import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class CoroutinesKt {
    @Nullable
    public static final <T> T getCompletedOrNull(@NotNull Deferred<? extends T> deferred) {
        try {
            return (T) deferred.x();
        } catch (Throwable unused) {
            return null;
        }
    }
}
