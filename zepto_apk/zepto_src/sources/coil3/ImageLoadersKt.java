package coil3;

import android.content.Context;
import coil3.Extras;
import coil3.ImageLoader;
import coil3.RealImageLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class ImageLoadersKt {

    @NotNull
    private static final Extras.Key<Boolean> serviceLoaderEnabledKey = new Extras.Key<>(Boolean.TRUE);

    @NotNull
    public static final ImageLoader ImageLoader(@NotNull Context context) {
        return new ImageLoader.Builder(context).build();
    }

    public static final boolean getServiceLoaderEnabled(@NotNull RealImageLoader.Options options) {
        return ((Boolean) ExtrasKt.getOrDefault(options.getDefaults().getExtras(), serviceLoaderEnabledKey)).booleanValue();
    }

    @NotNull
    public static final ImageLoader.Builder serviceLoaderEnabled(@NotNull ImageLoader.Builder builder, boolean z) {
        builder.getExtras().set(serviceLoaderEnabledKey, Boolean.valueOf(z));
        return builder;
    }
}
