package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import coil3.memory.RealStrongMemoryCache;
import coil3.util.LruCache;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealStrongMemoryCache implements StrongMemoryCache {

    @NotNull
    private final RealStrongMemoryCache$cache$1 cache;

    @NotNull
    private final WeakMemoryCache weakMemoryCache;

    @Metadata
    public static final class InternalValue {

        @NotNull
        private final Map<String, Object> extras;

        @NotNull
        private final Image image;
        private final long size;

        public InternalValue(@NotNull Image image, @NotNull Map<String, ? extends Object> map, long j2) {
            this.image = image;
            this.extras = map;
            this.size = j2;
        }

        @NotNull
        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        public final long getSize() {
            return this.size;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [coil3.memory.RealStrongMemoryCache$cache$1] */
    public RealStrongMemoryCache(final long j2, @NotNull WeakMemoryCache weakMemoryCache) {
        this.weakMemoryCache = weakMemoryCache;
        this.cache = new LruCache<MemoryCache.Key, InternalValue>(j2) { // from class: coil3.memory.RealStrongMemoryCache$cache$1
            @Override // coil3.util.LruCache
            public void entryRemoved(MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue, RealStrongMemoryCache.InternalValue internalValue2) {
                this.weakMemoryCache.set(key, internalValue.getImage(), internalValue.getExtras(), internalValue.getSize());
            }

            @Override // coil3.util.LruCache
            public long sizeOf(MemoryCache.Key key, RealStrongMemoryCache.InternalValue internalValue) {
                return internalValue.getSize();
            }
        };
    }

    @Override // coil3.memory.StrongMemoryCache
    public void clear() {
        clear();
    }

    @Override // coil3.memory.StrongMemoryCache
    @Nullable
    public MemoryCache.Value get(@NotNull MemoryCache.Key key) {
        InternalValue internalValue = get(key);
        if (internalValue != null) {
            return new MemoryCache.Value(internalValue.getImage(), internalValue.getExtras());
        }
        return null;
    }

    @Override // coil3.memory.StrongMemoryCache
    @NotNull
    public Set<MemoryCache.Key> getKeys() {
        return getKeys();
    }

    @Override // coil3.memory.StrongMemoryCache
    public long getMaxSize() {
        return getMaxSize();
    }

    @Override // coil3.memory.StrongMemoryCache
    public long getSize() {
        return getSize();
    }

    @Override // coil3.memory.StrongMemoryCache
    public boolean remove(@NotNull MemoryCache.Key key) {
        return remove(key) != null;
    }

    @Override // coil3.memory.StrongMemoryCache
    public void set(@NotNull MemoryCache.Key key, @NotNull Image image, @NotNull Map<String, ? extends Object> map, long j2) {
        if (j2 <= getMaxSize()) {
            put(key, new InternalValue(image, map, j2));
        } else {
            remove(key);
            this.weakMemoryCache.set(key, image, map, j2);
        }
    }

    @Override // coil3.memory.StrongMemoryCache
    public void trimToSize(long j2) {
        trimToSize(j2);
    }
}
