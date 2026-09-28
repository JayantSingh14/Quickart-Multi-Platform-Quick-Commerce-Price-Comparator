package coil3.fetch;

import coil3.ImageLoader;
import coil3.decode.ByteBufferMetadata;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class ByteBufferFetcher implements Fetcher {

    @NotNull
    private final ByteBuffer data;

    @NotNull
    private final Options options;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<ByteBuffer> {
        @Override // coil3.fetch.Fetcher.Factory
        @NotNull
        public Fetcher create(@NotNull ByteBuffer byteBuffer, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            return new ByteBufferFetcher(byteBuffer, options);
        }
    }

    public ByteBufferFetcher(@NotNull ByteBuffer byteBuffer, @NotNull Options options) {
        this.data = byteBuffer;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) {
        return new SourceFetchResult(ImageSourceKt.ImageSource(Okio.d(ByteBufferFetcherKt.asSource(this.data)), this.options.getFileSystem(), new ByteBufferMetadata(this.data)), null, DataSource.MEMORY);
    }
}
