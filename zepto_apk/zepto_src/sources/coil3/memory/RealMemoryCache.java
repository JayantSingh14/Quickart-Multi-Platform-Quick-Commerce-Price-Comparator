package coil3.memory;

import coil3.memory.MemoryCache;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealMemoryCache implements MemoryCache {

    @NotNull
    private final Object lock = new Object();

    @NotNull
    private final StrongMemoryCache strongMemoryCache;

    @NotNull
    private final WeakMemoryCache weakMemoryCache;

    public RealMemoryCache(@NotNull StrongMemoryCache strongMemoryCache, @NotNull WeakMemoryCache weakMemoryCache) {
        this.strongMemoryCache = strongMemoryCache;
        this.weakMemoryCache = weakMemoryCache;
    }

    @Override // coil3.memory.MemoryCache
    public void clear() {
        synchronized (this.lock) {
            this.strongMemoryCache.clear();
            this.weakMemoryCache.clear();
            Unit unit = Unit.f53572a;
        }
    }

    @Override // coil3.memory.MemoryCache
    @Nullable
    public MemoryCache.Value get(@NotNull MemoryCache.Key key) {
        MemoryCache.Value value;
        synchronized (this.lock) {
            try {
                value = this.strongMemoryCache.get(key);
                if (value == null) {
                    value = this.weakMemoryCache.get(key);
                }
                if (value != null && !value.getImage().getShareable()) {
                    remove(key);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return value;
    }

    @Override // coil3.memory.MemoryCache
    @NotNull
    public Set<MemoryCache.Key> getKeys() {
        LinkedHashSet linkedHashSetD;
        synchronized (this.lock) {
            linkedHashSetD = SetsKt.d(this.strongMemoryCache.getKeys(), this.weakMemoryCache.getKeys());
        }
        return linkedHashSetD;
    }

    @Override // coil3.memory.MemoryCache
    public long getMaxSize() {
        long maxSize;
        synchronized (this.lock) {
            maxSize = this.strongMemoryCache.getMaxSize();
        }
        return maxSize;
    }

    @Override // coil3.memory.MemoryCache
    public long getSize() {
        long size;
        synchronized (this.lock) {
            size = this.strongMemoryCache.getSize();
        }
        return size;
    }

    @Override // coil3.memory.MemoryCache
    public boolean remove(@NotNull MemoryCache.Key key) {
        boolean z;
        synchronized (this.lock) {
            z = this.strongMemoryCache.remove(key) || this.weakMemoryCache.remove(key);
        }
        return z;
    }

    @Override // coil3.memory.MemoryCache
    public void set(@NotNull MemoryCache.Key key, @NotNull MemoryCache.Value value) {
        synchronized (this.lock) {
            long size = value.getImage().getSize();
            if (size < 0) {
                throw new IllegalStateException(("Image size must be non-negative: " + size).toString());
            }
            this.strongMemoryCache.set(key, value.getImage(), value.getExtras(), size);
            Unit unit = Unit.f53572a;
        }
    }

    @Override // coil3.memory.MemoryCache
    public void trimToSize(long j2) {
        synchronized (this.lock) {
            this.strongMemoryCache.trimToSize(j2);
            Unit unit = Unit.f53572a;
        }
    }
}
