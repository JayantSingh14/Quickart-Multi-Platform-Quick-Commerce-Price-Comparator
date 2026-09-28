package coil3.decode;

import coil3.ImageLoader;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface Decoder {

    @Metadata
    public interface Factory {
        @Nullable
        Decoder create(@NotNull SourceFetchResult sourceFetchResult, @NotNull Options options, @NotNull ImageLoader imageLoader);
    }

    @Nullable
    Object decode(@NotNull Continuation<? super DecodeResult> continuation);
}
