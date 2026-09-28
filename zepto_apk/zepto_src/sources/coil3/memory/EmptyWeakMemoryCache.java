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
public final class EmptyWeakMemoryCache implements WeakMemoryCache {
    @Override // coil3.memory.WeakMemoryCache
    public void clear() {
    }

    @Override // coil3.memory.WeakMemoryCache
    @Nullable
    public MemoryCache.Value get(@NotNull MemoryCache.Key key) {
        return null;
    }

    @Override // coil3.memory.WeakMemoryCache
    @NotNull
    public Set<MemoryCache.Key> getKeys() {
        return EmptySet.f53611a;
    }

    @Override // coil3.memory.WeakMemoryCache
    public boolean remove(@NotNull MemoryCache.Key key) {
        return false;
    }

    @Override // coil3.memory.WeakMemoryCache
    public void set(@NotNull MemoryCache.Key key, @NotNull Image image, @NotNull Map<String, ? extends Object> map, long j2) {
    }
}
