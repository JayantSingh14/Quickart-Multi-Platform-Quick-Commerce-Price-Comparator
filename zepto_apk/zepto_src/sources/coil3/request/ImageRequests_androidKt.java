package coil3.request;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.b;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.Extras;
import coil3.ExtrasKt;
import coil3.Image;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.request.ImageRequest;
import coil3.target.ImageViewTarget;
import coil3.transform.Transformation;
import coil3.transition.CrossfadeTransition;
import coil3.transition.Transition;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.ContextsKt;
import coil3.util.Utils_androidKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ImageRequests_androidKt {

    @NotNull
    private static final Extras.Key<Boolean> allowConversionToBitmapKey;

    @NotNull
    private static final Extras.Key<Boolean> allowHardwareKey;

    @NotNull
    private static final Extras.Key<Boolean> allowRgb565Key;

    @NotNull
    private static final Extras.Key<Lifecycle> lifecycleKey;

    @NotNull
    private static final Extras.Key<Boolean> premultipliedAlphaKey;

    @NotNull
    private static final Extras.Key<List<Transformation>> transformationsKey = new Extras.Key<>(EmptyList.f53609a);

    @NotNull
    private static final Extras.Key<Transition.Factory> transitionFactoryKey = new Extras.Key<>(Transition.Factory.NONE);

    @NotNull
    private static final Extras.Key<Bitmap.Config> bitmapConfigKey = new Extras.Key<>(Utils_androidKt.getDEFAULT_BITMAP_CONFIG());

    @NotNull
    private static final Extras.Key<ColorSpace> colorSpaceKey = new Extras.Key<>(Utils_androidKt.getNULL_COLOR_SPACE());

    static {
        Boolean bool = Boolean.TRUE;
        premultipliedAlphaKey = new Extras.Key<>(bool);
        lifecycleKey = new Extras.Key<>(null);
        allowConversionToBitmapKey = new Extras.Key<>(bool);
        allowHardwareKey = new Extras.Key<>(bool);
        allowRgb565Key = new Extras.Key<>(Boolean.FALSE);
    }

    @NotNull
    public static final ImageRequest.Builder allowConversionToBitmap(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowConversionToBitmapKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder allowHardware(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowHardwareKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder allowRgb565(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(allowRgb565Key, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder bitmapConfig(@NotNull ImageRequest.Builder builder, @NotNull Bitmap.Config config) {
        builder.getExtras().set(bitmapConfigKey, config);
        return builder;
    }

    @RequiresApi
    @NotNull
    public static final ImageRequest.Builder colorSpace(@NotNull ImageRequest.Builder builder, @NotNull ColorSpace colorSpace) {
        builder.getExtras().set(colorSpaceKey, colorSpace);
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder crossfade(@NotNull ImageRequest.Builder builder, int i2) {
        return transitionFactory(builder, newCrossfadeTransitionFactory(i2));
    }

    @NotNull
    public static final ImageRequest.Builder error(@NotNull ImageRequest.Builder builder, @DrawableRes int i2) {
        return builder.error(new a(i2, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Image error$lambda$1(int i2, ImageRequest imageRequest) {
        return Image_androidKt.asImage(ContextsKt.getDrawableCompat(imageRequest.getContext(), i2));
    }

    @NotNull
    public static final ImageRequest.Builder fallback(@NotNull ImageRequest.Builder builder, @DrawableRes int i2) {
        return builder.fallback(new a(i2, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Image fallback$lambda$2(int i2, ImageRequest imageRequest) {
        return Image_androidKt.asImage(ContextsKt.getDrawableCompat(imageRequest.getContext(), i2));
    }

    public static final boolean getAllowConversionToBitmap(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowConversionToBitmapKey)).booleanValue();
    }

    public static final boolean getAllowHardware(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowHardwareKey)).booleanValue();
    }

    public static final boolean getAllowRgb565(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, allowRgb565Key)).booleanValue();
    }

    @NotNull
    public static final Bitmap.Config getBitmapConfig(@NotNull ImageRequest imageRequest) {
        return (Bitmap.Config) ExtrasKt.getExtra(imageRequest, bitmapConfigKey);
    }

    @RequiresApi
    @Nullable
    public static final ColorSpace getColorSpace(@NotNull ImageRequest imageRequest) {
        return b.k(ExtrasKt.getExtra(imageRequest, colorSpaceKey));
    }

    public static final int getCrossfadeMillis(@NotNull ImageRequest imageRequest) {
        Transition.Factory transitionFactory = getTransitionFactory(imageRequest);
        CrossfadeTransition.Factory factory = transitionFactory instanceof CrossfadeTransition.Factory ? (CrossfadeTransition.Factory) transitionFactory : null;
        if (factory != null) {
            return factory.getDurationMillis();
        }
        return 0;
    }

    @Nullable
    public static final Lifecycle getLifecycle(@NotNull ImageRequest imageRequest) {
        return (Lifecycle) ExtrasKt.getExtra(imageRequest, lifecycleKey);
    }

    public static final boolean getPremultipliedAlpha(@NotNull ImageRequest imageRequest) {
        return ((Boolean) ExtrasKt.getExtra(imageRequest, premultipliedAlphaKey)).booleanValue();
    }

    @NotNull
    public static final List<Transformation> getTransformations(@NotNull ImageRequest imageRequest) {
        return (List) ExtrasKt.getExtra(imageRequest, transformationsKey);
    }

    @NotNull
    public static final Transition.Factory getTransitionFactory(@NotNull ImageRequest imageRequest) {
        return (Transition.Factory) ExtrasKt.getExtra(imageRequest, transitionFactoryKey);
    }

    @NotNull
    public static final ImageRequest.Builder lifecycle(@NotNull ImageRequest.Builder builder, @Nullable LifecycleOwner lifecycleOwner) {
        return lifecycle(builder, lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null);
    }

    private static final Transition.Factory newCrossfadeTransitionFactory(int i2) {
        if (i2 <= 0) {
            return Transition.Factory.NONE;
        }
        return new CrossfadeTransition.Factory(i2, false, 2, null);
    }

    @NotNull
    public static final ImageRequest.Builder placeholder(@NotNull ImageRequest.Builder builder, @DrawableRes int i2) {
        return builder.placeholder(new a(i2, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Image placeholder$lambda$0(int i2, ImageRequest imageRequest) {
        return Image_androidKt.asImage(ContextsKt.getDrawableCompat(imageRequest.getContext(), i2));
    }

    @NotNull
    public static final ImageRequest.Builder premultipliedAlpha(@NotNull ImageRequest.Builder builder, boolean z) {
        builder.getExtras().set(premultipliedAlphaKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder target(@NotNull ImageRequest.Builder builder, @NotNull ImageView imageView) {
        return builder.target(new ImageViewTarget(imageView));
    }

    @NotNull
    public static final ImageRequest.Builder transformations(@NotNull ImageRequest.Builder builder, @NotNull Transformation... transformationArr) {
        return transformations(builder, (List<? extends Transformation>) ArraysKt.F(transformationArr));
    }

    @NotNull
    public static final ImageRequest.Builder transitionFactory(@NotNull ImageRequest.Builder builder, @NotNull Transition.Factory factory) {
        builder.getExtras().set(transitionFactoryKey, factory);
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder allowConversionToBitmap(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowConversionToBitmapKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder allowHardware(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowHardwareKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder allowRgb565(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(allowRgb565Key, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder bitmapConfig(@NotNull ImageLoader.Builder builder, @NotNull Bitmap.Config config) {
        builder.getExtras().set(bitmapConfigKey, config);
        return builder;
    }

    @RequiresApi
    @NotNull
    public static final ImageLoader.Builder colorSpace(@NotNull ImageLoader.Builder builder, @NotNull ColorSpace colorSpace) {
        builder.getExtras().set(colorSpaceKey, colorSpace);
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder crossfade(@NotNull ImageLoader.Builder builder, int i2) {
        return transitionFactory(builder, newCrossfadeTransitionFactory(i2));
    }

    @NotNull
    public static final ImageRequest.Builder error(@NotNull ImageRequest.Builder builder, @Nullable Drawable drawable) {
        return builder.error(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    @NotNull
    public static final ImageRequest.Builder fallback(@NotNull ImageRequest.Builder builder, @Nullable Drawable drawable) {
        return builder.fallback(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    public static final boolean getAllowConversionToBitmap(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowConversionToBitmapKey)).booleanValue();
    }

    public static final boolean getAllowHardware(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowHardwareKey)).booleanValue();
    }

    public static final boolean getAllowRgb565(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, allowRgb565Key)).booleanValue();
    }

    @NotNull
    public static final Bitmap.Config getBitmapConfig(@NotNull Options options) {
        return (Bitmap.Config) ExtrasKt.getExtra(options, bitmapConfigKey);
    }

    @RequiresApi
    @Nullable
    public static final ColorSpace getColorSpace(@NotNull Options options) {
        return b.k(ExtrasKt.getExtra(options, colorSpaceKey));
    }

    @Nullable
    public static final Lifecycle getLifecycle(@NotNull Options options) {
        return (Lifecycle) ExtrasKt.getExtra(options, lifecycleKey);
    }

    public static final boolean getPremultipliedAlpha(@NotNull Options options) {
        return ((Boolean) ExtrasKt.getExtra(options, premultipliedAlphaKey)).booleanValue();
    }

    @NotNull
    public static final List<Transformation> getTransformations(@NotNull Options options) {
        return (List) ExtrasKt.getExtra(options, transformationsKey);
    }

    @NotNull
    public static final Extras.Key<Transition.Factory> getTransitionFactory(@NotNull Extras.Key.Companion companion) {
        return transitionFactoryKey;
    }

    @NotNull
    public static final ImageRequest.Builder lifecycle(@NotNull ImageRequest.Builder builder, @Nullable Lifecycle lifecycle) {
        builder.getExtras().set(lifecycleKey, lifecycle);
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder placeholder(@NotNull ImageRequest.Builder builder, @Nullable Drawable drawable) {
        return builder.placeholder(drawable != null ? Image_androidKt.asImage(drawable) : null);
    }

    @NotNull
    public static final ImageLoader.Builder premultipliedAlpha(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(premultipliedAlphaKey, Boolean.valueOf(z));
        return builder;
    }

    @NotNull
    public static final ImageRequest.Builder transformations(@NotNull ImageRequest.Builder builder, @NotNull List<? extends Transformation> list) {
        builder.getExtras().set(transformationsKey, Collections_jvmCommonKt.toImmutableList(list));
        return builder;
    }

    @NotNull
    public static final ImageLoader.Builder transitionFactory(@NotNull ImageLoader.Builder builder, @NotNull Transition.Factory factory) {
        builder.getExtras().set(transitionFactoryKey, factory);
        return builder;
    }

    @NotNull
    public static final Extras.Key<Boolean> getAllowConversionToBitmap(@NotNull Extras.Key.Companion companion) {
        return allowConversionToBitmapKey;
    }

    @NotNull
    public static final Extras.Key<Boolean> getAllowHardware(@NotNull Extras.Key.Companion companion) {
        return allowHardwareKey;
    }

    @NotNull
    public static final Extras.Key<Boolean> getAllowRgb565(@NotNull Extras.Key.Companion companion) {
        return allowRgb565Key;
    }

    @NotNull
    public static final Extras.Key<Bitmap.Config> getBitmapConfig(@NotNull Extras.Key.Companion companion) {
        return bitmapConfigKey;
    }

    @RequiresApi
    @NotNull
    public static final Extras.Key<ColorSpace> getColorSpace(@NotNull Extras.Key.Companion companion) {
        return colorSpaceKey;
    }

    @NotNull
    public static final Extras.Key<Lifecycle> getLifecycle(@NotNull Extras.Key.Companion companion) {
        return lifecycleKey;
    }

    @NotNull
    public static final Extras.Key<Boolean> getPremultipliedAlpha(@NotNull Extras.Key.Companion companion) {
        return premultipliedAlphaKey;
    }

    @NotNull
    public static final Extras.Key<List<Transformation>> getTransformations(@NotNull Extras.Key.Companion companion) {
        return transformationsKey;
    }
}
