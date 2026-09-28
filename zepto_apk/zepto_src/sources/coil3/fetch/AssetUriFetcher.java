package coil3.fetch;

import coil3.ImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.AssetMetadata;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class AssetUriFetcher implements Fetcher {

    @NotNull
    private final Uri data;

    @NotNull
    private final Options options;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        @Override // coil3.fetch.Fetcher.Factory
        @Nullable
        public Fetcher create(@NotNull Uri uri, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            if (Utils_androidKt.isAssetUri(uri)) {
                return new AssetUriFetcher(uri, options);
            }
            return null;
        }
    }

    public AssetUriFetcher(@NotNull Uri uri, @NotNull Options options) {
        this.data = uri;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) {
        String strE = CollectionsKt.E(CollectionsKt.v(UriKt.getPathSegments(this.data)), "/", null, null, null, 62);
        return new SourceFetchResult(ImageSourceKt.ImageSource(Okio.d(Okio.m(this.options.getContext().getAssets().open(strE))), this.options.getFileSystem(), new AssetMetadata(strE)), MimeTypeMap.INSTANCE.getMimeTypeFromUrl(strE), DataSource.DISK);
    }
}
