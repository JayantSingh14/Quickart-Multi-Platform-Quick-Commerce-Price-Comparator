package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public interface StrongMemoryCache {
    void clear();

    @Nullable
    MemoryCache.Value get(@NotNull MemoryCache.Key key);

    @NotNull
    Set<MemoryCache.Key> getKeys();

    long getMaxSize();

    long getSize();

    boolean remove(@NotNull MemoryCache.Key key);

    void set(@NotNull MemoryCache.Key key, @NotNull Image image, @NotNull Map<String, ? extends Object> map, long j2);

    void trimToSize(long j2);
}
