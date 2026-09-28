package coil3.fetch;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.decode.DataSource;
import coil3.fetch.Fetcher;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.util.DrawableUtils;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DrawableFetcher implements Fetcher {

    @NotNull
    private final Drawable data;

    @NotNull
    private final Options options;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<Drawable> {
        @Override // coil3.fetch.Fetcher.Factory
        @NotNull
        public Fetcher create(@NotNull Drawable drawable, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            return new DrawableFetcher(drawable, options);
        }
    }

    public DrawableFetcher(@NotNull Drawable drawable, @NotNull Options options) {
        this.data = drawable;
        this.options = options;
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) {
        Drawable bitmapDrawable;
        boolean zIsVector = Utils_androidKt.isVector(this.data);
        if (zIsVector) {
            bitmapDrawable = new BitmapDrawable(this.options.getContext().getResources(), DrawableUtils.INSTANCE.convertToBitmap(this.data, ImageRequests_androidKt.getBitmapConfig(this.options), this.options.getSize(), this.options.getScale(), this.options.getPrecision() == Precision.INEXACT));
        } else {
            bitmapDrawable = this.data;
        }
        return new ImageFetchResult(Image_androidKt.asImage(bitmapDrawable), zIsVector, DataSource.MEMORY);
    }
}
