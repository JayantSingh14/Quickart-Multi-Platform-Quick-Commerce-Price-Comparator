package coil3.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class LruCache<K, V> {

    @NotNull
    private final Map<K, V> map = Collections_jvmCommonKt.LruMutableMap$default(0, 0.0f, 3, null);
    private final long maxSize;
    private long size;

    public LruCache(long j2) {
        this.maxSize = j2;
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long recomputeSize() {
        Iterator<T> it = this.map.entrySet().iterator();
        long jSafeSizeOf = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jSafeSizeOf += safeSizeOf(entry.getKey(), entry.getValue());
        }
        return jSafeSizeOf;
    }

    private final long safeSizeOf(K k2, V v) throws Exception {
        try {
            long jSizeOf = sizeOf(k2, v);
            if (jSizeOf >= 0) {
                return jSizeOf;
            }
            throw new IllegalStateException(("sizeOf(" + k2 + ", " + v + ") returned a negative value: " + jSizeOf).toString());
        } catch (Exception e2) {
            this.size = -1L;
            throw e2;
        }
    }

    public final void clear() {
        trimToSize(-1L);
    }

    public void entryRemoved(@NotNull K k2, @NotNull V v, @Nullable V v2) {
    }

    @Nullable
    public final V get(@NotNull K k2) {
        return this.map.get(k2);
    }

    @NotNull
    public final Set<K> getKeys() {
        return kotlin.collections.CollectionsKt.h0(this.map.keySet());
    }

    public final long getMaxSize() {
        return this.maxSize;
    }

    public final long getSize() {
        if (this.size == -1) {
            this.size = recomputeSize();
        }
        return this.size;
    }

    @Nullable
    public final V put(@NotNull K k2, @NotNull V v) {
        V vPut = this.map.put(k2, v);
        this.size = getSize() + safeSizeOf(k2, v);
        if (vPut != null) {
            this.size = getSize() - safeSizeOf(k2, vPut);
            entryRemoved(k2, vPut, v);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    @Nullable
    public final V remove(@NotNull K k2) {
        V vRemove = this.map.remove(k2);
        if (vRemove != null) {
            this.size = getSize() - safeSizeOf(k2, vRemove);
            entryRemoved(k2, vRemove, null);
        }
        return vRemove;
    }

    public long sizeOf(@NotNull K k2, @NotNull V v) {
        return 1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void trimToSize(long j2) {
        while (getSize() > j2) {
            if (this.map.isEmpty()) {
                if (getSize() != 0) {
                    throw new IllegalStateException("sizeOf() is returning inconsistent values");
                }
                return;
            }
            Map.Entry entry = (Map.Entry) kotlin.collections.CollectionsKt.y(this.map.entrySet());
            Object key = entry.getKey();
            Object value = entry.getValue();
            this.map.remove(key);
            this.size = getSize() - safeSizeOf(key, value);
            entryRemoved(key, value, null);
        }
    }
}
