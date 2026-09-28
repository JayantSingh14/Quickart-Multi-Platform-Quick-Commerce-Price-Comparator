package coil3.fetch;

import coil3.ImageLoader;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ByteArrayFetcher implements Fetcher {

    @NotNull
    private final byte[] byteArray;

    @NotNull
    private final Options options;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<byte[]> {
        @Override // coil3.fetch.Fetcher.Factory
        @NotNull
        public Fetcher create(@NotNull byte[] bArr, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            return new ByteArrayFetcher(bArr, options);
        }
    }

    public ByteArrayFetcher(@NotNull byte[] bArr, @NotNull Options options) {
        this.byteArray = bArr;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) {
        Buffer buffer = new Buffer();
        buffer.w1(this.byteArray);
        return new SourceFetchResult(ImageSourceKt.ImageSource$default(buffer, this.options.getFileSystem(), null, 4, null), null, DataSource.MEMORY);
    }
}
