package coil3.key;

import coil3.request.Options;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface Keyer<T> {
    @Nullable
    String key(@NotNull T t, @NotNull Options options);
}
