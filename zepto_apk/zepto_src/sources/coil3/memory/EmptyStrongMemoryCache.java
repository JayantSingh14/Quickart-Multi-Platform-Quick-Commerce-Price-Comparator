package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class EmptyStrongMemoryCache implements StrongMemoryCache {

    @NotNull
    private final WeakMemoryCache weakMemoryCache;

    public EmptyStrongMemoryCache(@NotNull WeakMemoryCache weakMemoryCache) {
        this.weakMemoryCache = weakMemoryCache;
    }

    @Override // coil3.memory.StrongMemoryCache
    public void clear() {
    }

    @Override // coil3.memory.StrongMemoryCache
    @Nullable
    public MemoryCache.Value get(@NotNull MemoryCache.Key key) {
        return null;
    }

    @Override // coil3.memory.StrongMemoryCache
    @NotNull
    public Set<MemoryCache.Key> getKeys() {
        return EmptySet.f53611a;
    }

    @Override // coil3.memory.StrongMemoryCache
    public long getMaxSize() {
        return 0L;
    }

    @Override // coil3.memory.StrongMemoryCache
    public long getSize() {
        return 0L;
    }

    @Override // coil3.memory.StrongMemoryCache
    public boolean remove(@NotNull MemoryCache.Key key) {
        return false;
    }

    @Override // coil3.memory.StrongMemoryCache
    public void set(@NotNull MemoryCache.Key key, @NotNull Image image, @NotNull Map<String, ? extends Object> map, long j2) {
        this.weakMemoryCache.set(key, image, map, j2);
    }

    @Override // coil3.memory.StrongMemoryCache
    public void trimToSize(long j2) {
    }
}
