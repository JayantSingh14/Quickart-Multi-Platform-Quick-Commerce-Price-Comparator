package coil3.intercept;

import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface Interceptor {

    @Metadata
    public interface Chain {
        @NotNull
        ImageRequest getRequest();

        @NotNull
        Size getSize();

        @Nullable
        Object proceed(@NotNull Continuation<? super ImageResult> continuation);

        @NotNull
        Chain withRequest(@NotNull ImageRequest imageRequest);

        @NotNull
        Chain withSize(@NotNull Size size);
    }

    @Nullable
    Object intercept(@NotNull Chain chain, @NotNull Continuation<? super ImageResult> continuation);
}
