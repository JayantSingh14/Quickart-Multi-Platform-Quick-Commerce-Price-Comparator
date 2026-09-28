package coil3.fetch;

import coil3.ImageLoader;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface Fetcher {

    @Metadata
    public interface Factory<T> {
        @Nullable
        Fetcher create(@NotNull T t, @NotNull Options options, @NotNull ImageLoader imageLoader);
    }

    @Nullable
    Object fetch(@NotNull Continuation<? super FetchResult> continuation);
}
