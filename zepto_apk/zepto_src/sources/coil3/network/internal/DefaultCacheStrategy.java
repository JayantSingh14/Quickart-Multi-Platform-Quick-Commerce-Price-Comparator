package coil3.network.internal;

import coil3.network.CacheStrategy;
import coil3.network.NetworkRequest;
import coil3.network.NetworkResponse;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class DefaultCacheStrategy implements CacheStrategy {
    @Override // coil3.network.CacheStrategy
    @Nullable
    public Object read(@NotNull NetworkResponse networkResponse, @NotNull NetworkRequest networkRequest, @NotNull Options options, @NotNull Continuation<? super CacheStrategy.ReadResult> continuation) {
        return new CacheStrategy.ReadResult(networkResponse);
    }

    @Override // coil3.network.CacheStrategy
    @Nullable
    public Object write(@Nullable NetworkResponse networkResponse, @NotNull NetworkRequest networkRequest, @NotNull NetworkResponse networkResponse2, @NotNull Options options, @NotNull Continuation<? super CacheStrategy.WriteResult> continuation) {
        return (networkResponse2.getCode() != 304 || networkResponse == null) ? new CacheStrategy.WriteResult(networkResponse2) : new CacheStrategy.WriteResult(NetworkResponse.copy$default(networkResponse2, 0, 0L, 0L, UtilsKt.plus(networkResponse.getHeaders(), networkResponse2.getHeaders()), null, null, 39, null));
    }
}
