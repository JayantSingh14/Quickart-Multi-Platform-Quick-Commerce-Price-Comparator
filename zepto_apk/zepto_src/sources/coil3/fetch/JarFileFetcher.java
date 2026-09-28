package coil3.fetch;

import coil3.ImageLoader;
import coil3.Uri;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.util.FileSystemsKt;
import coil3.util.MimeTypeMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Okio;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class JarFileFetcher implements Fetcher {

    @NotNull
    private final Options options;

    @NotNull
    private final Uri uri;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final boolean isApplicable(Uri uri) {
            return Intrinsics.b(uri.getScheme(), "jar:file");
        }

        @Override // coil3.fetch.Fetcher.Factory
        @Nullable
        public Fetcher create(@NotNull Uri uri, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            if (isApplicable(uri)) {
                return new JarFileFetcher(uri, options);
            }
            return null;
        }
    }

    public JarFileFetcher(@NotNull Uri uri, @NotNull Options options) {
        this.uri = uri;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) {
        String path = this.uri.getPath();
        if (path == null) {
            path = "";
        }
        int iW = StringsKt.w(path, '!', 0, 6);
        if (iW == -1) {
            throw new IllegalStateException(("Invalid jar:file URI: " + this.uri).toString());
        }
        String str = Path.f56972b;
        String strSubstring = path.substring(0, iW);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Path pathA = Path.Companion.a(strSubstring, false);
        String strSubstring2 = path.substring(iW + 1, path.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        Path pathA2 = Path.Companion.a(strSubstring2, false);
        return new SourceFetchResult(ImageSourceKt.ImageSource$default(pathA2, Okio.f(this.options.getFileSystem(), pathA), null, null, null, 28, null), MimeTypeMap.INSTANCE.getMimeTypeFromExtension(FileSystemsKt.getExtension(pathA2)), DataSource.DISK);
    }
}
