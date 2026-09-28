package coil3.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface NetworkRequestBody {
    @Nullable
    Object writeTo(@NotNull BufferedSink bufferedSink, @NotNull Continuation<? super Unit> continuation);
}
