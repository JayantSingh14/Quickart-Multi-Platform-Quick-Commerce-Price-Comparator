package coil3;

import android.content.Context;
import coil3.Extras;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SingletonImageLoaderKt {

    @NotNull
    private static final SingletonImageLoader.Factory DefaultSingletonImageLoaderFactory = new f();

    @NotNull
    private static final Extras.Key<Unit> DefaultSingletonImageLoaderKey = new Extras.Key<>(Unit.f53572a);

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageLoader DefaultSingletonImageLoaderFactory$lambda$1(Context context) {
        ImageLoader.Builder builder = new ImageLoader.Builder(context);
        builder.getExtras().set(DefaultSingletonImageLoaderKey, Unit.f53572a);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDefault(ImageLoader imageLoader) {
        return imageLoader.getDefaults().getExtras().get(DefaultSingletonImageLoaderKey) != null;
    }
}
