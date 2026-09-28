package coil3.util;

import coil3.annotation.InternalCoilApi;
import coil3.fetch.Fetcher;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.Nullable;

@Metadata
@InternalCoilApi
/* loaded from: classes.dex */
public interface FetcherServiceLoaderTarget<T> {
    @Nullable
    Fetcher.Factory<T> factory();

    default int priority() {
        return 0;
    }

    @Nullable
    KClass<T> type();
}
