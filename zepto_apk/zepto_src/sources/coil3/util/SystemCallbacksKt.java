package coil3.util;

import coil3.RealImageLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class SystemCallbacksKt {
    @NotNull
    public static final SystemCallbacks SystemCallbacks(@NotNull RealImageLoader realImageLoader) {
        return new AndroidSystemCallbacks(realImageLoader);
    }
}
