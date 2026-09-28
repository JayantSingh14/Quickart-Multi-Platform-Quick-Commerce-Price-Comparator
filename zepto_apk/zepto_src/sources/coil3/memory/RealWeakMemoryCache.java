package coil3.memory;

import coil3.Image;
import coil3.memory.MemoryCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> cache = new LinkedHashMap<>();
    private int operationsSinceCleanUp;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata
    public static final class InternalValue {

        @NotNull
        private final Map<String, Object> extras;

        @NotNull
        private final WeakReference<Image> image;
        private final long size;

        public InternalValue(@NotNull WeakReference<Image> weakReference, @NotNull Map<String, ? extends Object> map, long j2) {
            this.image = weakReference;
            this.extras = map;
            this.size = j2;
        }

        @NotNull
        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        @NotNull
        public final WeakReference<Image> getImage() {
            return this.image;
        }

        public final long getSize() {
            return this.size;
        }
    }

    private final void cleanUpIfNecessary() {
        int i2 = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i2 + 1;
        if (i2 >= 10) {
            cleanUp$coil_core_release();
        }
    }

    public final void cleanUp$coil_core_release() {
        WeakReference<Image> image;
        this.operationsSinceCleanUp = 0;
        Iterator<ArrayList<InternalValue>> it = this.cache.values().iterator();
        while (it.hasNext()) {
            ArrayList<InternalValue> next = it.next();
            if (next.size() <= 1) {
                InternalValue internalValue = (InternalValue) CollectionsKt.firstOrNull(next);
                if (((internalValue == null || (image = internalValue.getImage()) == null) ? null : image.get()) == null) {
                    it.remove();
                }
            } else {
                int size = next.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    int i4 = i3 - i2;
                    if (next.get(i4).getImage().get() == null) {
                        next.remove(i4);
                        i2++;
                    }
                }
                if (next.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    @Override // coil3.memory.WeakMemoryCache
    public void clear() {
        this.operationsSinceCleanUp = 0;
        this.cache.clear();
    }

    @Override // coil3.memory.WeakMemoryCache
    @Nullable
    public MemoryCache.Value get(@NotNull MemoryCache.Key key) {
        ArrayList<InternalValue> arrayList = this.cache.get(key);
        MemoryCache.Value value = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            InternalValue internalValue = arrayList.get(i2);
            Image image = internalValue.getImage().get();
            MemoryCache.Value value2 = image != null ? new MemoryCache.Value(image, internalValue.getExtras()) : null;
            if (value2 != null) {
                value = value2;
                break;
            }
            i2++;
        }
        cleanUpIfNecessary();
        return value;
    }

    @NotNull
    public final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> getCache$coil_core_release() {
        return this.cache;
    }

    @Override // coil3.memory.WeakMemoryCache
    @NotNull
    public Set<MemoryCache.Key> getKeys() {
        return CollectionsKt.h0(this.cache.keySet());
    }

    @Override // coil3.memory.WeakMemoryCache
    public boolean remove(@NotNull MemoryCache.Key key) {
        return this.cache.remove(key) != null;
    }

    @Override // coil3.memory.WeakMemoryCache
    public void set(@NotNull MemoryCache.Key key, @NotNull Image image, @NotNull Map<String, ? extends Object> map, long j2) {
        LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> linkedHashMap = this.cache;
        ArrayList<InternalValue> arrayList = linkedHashMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            linkedHashMap.put(key, arrayList);
        }
        ArrayList<InternalValue> arrayList2 = arrayList;
        InternalValue internalValue = new InternalValue(new WeakReference(image), map, j2);
        if (!arrayList2.isEmpty()) {
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                InternalValue internalValue2 = arrayList2.get(i2);
                if (j2 < internalValue2.getSize()) {
                    i2++;
                } else if (internalValue2.getImage().get() == image) {
                    arrayList2.set(i2, internalValue);
                } else {
                    arrayList2.add(i2, internalValue);
                }
            }
        } else {
            arrayList2.add(internalValue);
        }
        cleanUpIfNecessary();
    }
}
