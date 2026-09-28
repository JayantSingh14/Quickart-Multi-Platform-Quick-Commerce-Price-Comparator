package coil3.request;

import coil3.ImageLoader;
import coil3.util.Logger;
import coil3.util.SystemCallbacks;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class RequestService_androidKt {
    @NotNull
    public static final RequestService RequestService(@NotNull ImageLoader imageLoader, @NotNull SystemCallbacks systemCallbacks, @Nullable Logger logger) {
        return new AndroidRequestService(imageLoader, systemCallbacks, logger);
    }
}
