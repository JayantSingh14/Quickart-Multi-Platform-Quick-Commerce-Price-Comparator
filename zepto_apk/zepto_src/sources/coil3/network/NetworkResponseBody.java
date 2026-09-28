package coil3.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okio.BufferedSink;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface NetworkResponseBody extends AutoCloseable {
    @Nullable
    Object writeTo(@NotNull BufferedSink bufferedSink, @NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object writeTo(@NotNull FileSystem fileSystem, @NotNull Path path, @NotNull Continuation<? super Unit> continuation);
}
