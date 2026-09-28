package coil3.fetch;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.decode.DataSource;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BitmapFetcher implements Fetcher {

    @NotNull
    private final Bitmap data;

    @NotNull
    private final Options options;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<Bitmap> {
        @Override // coil3.fetch.Fetcher.Factory
        @NotNull
        public Fetcher create(@NotNull Bitmap bitmap, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            return new BitmapFetcher(bitmap, options);
        }
    }

    public BitmapFetcher(@NotNull Bitmap bitmap, @NotNull Options options) {
        this.data = bitmap;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) {
        return new ImageFetchResult(Image_androidKt.asImage(new BitmapDrawable(this.options.getContext().getResources(), this.data)), false, DataSource.MEMORY);
    }
}
