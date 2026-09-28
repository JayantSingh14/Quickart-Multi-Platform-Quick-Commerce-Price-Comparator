package coil3.fetch;

import coil3.ImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.util.FileSystemsKt;
import coil3.util.MimeTypeMap;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FileUriFetcher implements Fetcher {

    @NotNull
    private final Options options;

    @NotNull
    private final Uri uri;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        @Override // coil3.fetch.Fetcher.Factory
        @Nullable
        public Fetcher create(@NotNull Uri uri, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            if (UtilsKt.isFileUri(uri)) {
                return new FileUriFetcher(uri, options);
            }
            return null;
        }
    }

    public FileUriFetcher(@NotNull Uri uri, @NotNull Options options) {
        this.uri = uri;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) {
        String str = Path.f56972b;
        String filePath = UriKt.getFilePath(this.uri);
        if (filePath == null) {
            throw new IllegalStateException("filePath == null");
        }
        Path pathA = Path.Companion.a(filePath, false);
        return new SourceFetchResult(ImageSourceKt.ImageSource$default(pathA, this.options.getFileSystem(), null, null, null, 28, null), MimeTypeMap.INSTANCE.getMimeTypeFromExtension(FileSystemsKt.getExtension(pathA)), DataSource.DISK);
    }
}
