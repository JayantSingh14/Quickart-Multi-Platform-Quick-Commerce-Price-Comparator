package coil3.map;

import coil3.request.Options;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface Mapper<T, V> {
    @Nullable
    V map(@NotNull T t, @NotNull Options options);
}
