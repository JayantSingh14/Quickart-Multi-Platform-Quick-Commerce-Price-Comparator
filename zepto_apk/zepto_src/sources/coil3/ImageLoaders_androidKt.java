package coil3;

import coil3.Extras;
import coil3.ImageLoader;
import coil3.RealImageLoader;
import coil3.decode.ExifOrientationStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ImageLoaders_androidKt {

    @NotNull
    private static final Extras.Key<Integer> bitmapFactoryMaxParallelismKey = new Extras.Key<>(4);

    @NotNull
    private static final Extras.Key<ExifOrientationStrategy> bitmapFactoryExifOrientationStrategyKey = new Extras.Key<>(ExifOrientationStrategy.RESPECT_PERFORMANCE);

    @NotNull
    public static final ImageLoader.Builder bitmapFactoryExifOrientationStrategy(@NotNull ImageLoader.Builder builder, @NotNull ExifOrientationStrategy exifOrientationStrategy) {
        builder.getExtras().set(bitmapFactoryExifOrientationStrategyKey, exifOrientationStrategy);
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder bitmapFactoryMaxParallelism(@NotNull ImageLoader.Builder builder, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxParallelism must be > 0.");
        }
        builder.getExtras().set(bitmapFactoryMaxParallelismKey, Integer.valueOf(i2));
        return builder;
    }

    @NotNull
    public static final ExifOrientationStrategy getBitmapFactoryExifOrientationStrategy(@NotNull RealImageLoader.Options options) {
        return (ExifOrientationStrategy) ExtrasKt.getOrDefault(options.getDefaults().getExtras(), bitmapFactoryExifOrientationStrategyKey);
    }

    public static final int getBitmapFactoryMaxParallelism(@NotNull RealImageLoader.Options options) {
        return ((Number) ExtrasKt.getOrDefault(options.getDefaults().getExtras(), bitmapFactoryMaxParallelismKey)).intValue();
    }
}
