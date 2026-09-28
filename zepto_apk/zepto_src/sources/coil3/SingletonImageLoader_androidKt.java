package coil3;

import android.content.Context;
import coil3.SingletonImageLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class SingletonImageLoader_androidKt {
    @Nullable
    public static final SingletonImageLoader.Factory applicationImageLoaderFactory(@NotNull Context context) {
        Object applicationContext = context.getApplicationContext();
        if (applicationContext instanceof SingletonImageLoader.Factory) {
            return (SingletonImageLoader.Factory) applicationContext;
        }
        return null;
    }
}
