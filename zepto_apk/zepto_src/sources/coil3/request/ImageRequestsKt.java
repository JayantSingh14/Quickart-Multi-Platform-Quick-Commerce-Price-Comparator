package coil3.request;

import coil3.Extras;
import coil3.ExtrasKt;
import coil3.ImageLoader;
import coil3.request.ImageRequest;
import coil3.size.Size;
import coil3.size.SizeKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ImageRequestsKt {
    public static final int DEFAULT_CROSSFADE_MILLIS = 200;

    @NotNull
    private static final Extras.Key<Size> maxBitmapSizeKey = new Extras.Key<>(SizeKt.Size(4096, 4096));

    @NotNull
    private static final Extras.Key<Boolean> addLastModifiedToFileCacheKeyKey = new Extras.Key<>(Boolean.FALSE);

    @NotNull
    public static final ImageRequest.Builder addLastModifiedToFileCacheKey(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(addLastModifiedToFileCacheKeyKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder crossfade(@NotNull ImageRequest.Builder builder, boolean z) {
        return ImageRequests_androidKt.crossfade(builder, z ? 200 : 0);
    }

    public static final boolean getAddLastModifiedToFileCacheKey(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, addLastModifiedToFileCacheKeyKey)).booleanValue();
    }

    @NotNull
    public static final Size getMaxBitmapSize(@NotNull ImageRequest imageRequest) {
        return (Size) ExtrasKt.getExtra(imageRequest, maxBitmapSizeKey);
    }

    @NotNull
    public static final ImageRequest.Builder maxBitmapSize(@NotNull ImageRequest.Builder builder, @NotNull Size size) {
        builder.getExtras().set(maxBitmapSizeKey, size);
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder addLastModifiedToFileCacheKey(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(addLastModifiedToFileCacheKeyKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder crossfade(@NotNull ImageLoader.Builder builder, boolean z) {
        return ImageRequests_androidKt.crossfade(builder, z ? 200 : 0);
    }

    public static final boolean getAddLastModifiedToFileCacheKey(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, addLastModifiedToFileCacheKeyKey)).booleanValue();
    }

    @NotNull
    public static final Size getMaxBitmapSize(@NotNull Options options) {
        return (Size) ExtrasKt.getExtra(options, maxBitmapSizeKey);
    }

    @NotNull
    public static final ImageLoader.Builder maxBitmapSize(@NotNull ImageLoader.Builder builder, @NotNull Size size) {
        builder.getExtras().set(maxBitmapSizeKey, size);
        return builder;
    }

    @NotNull
    public static final Extras.Key<Boolean> getAddLastModifiedToFileCacheKey(@NotNull Extras.Key.Companion companion) {
        return addLastModifiedToFileCacheKeyKey;
    }

    @NotNull
    public static final Extras.Key<Size> getMaxBitmapSize(@NotNull Extras.Key.Companion companion) {
        return maxBitmapSizeKey;
    }
}
