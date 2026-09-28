package androidx.arch.core.internal;

import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LifecycleObserver;
import java.util.HashMap;
import java.util.Map;

@RestrictTo
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f1282e = new HashMap();

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final SafeIterableMap.Entry b(Object obj) {
        return (SafeIterableMap.Entry) this.f1282e.get(obj);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final Object d(Object obj, Object obj2) {
        SafeIterableMap.Entry entryB = b(obj);
        if (entryB != null) {
            return entryB.f1288b;
        }
        HashMap map = this.f1282e;
        SafeIterableMap.Entry entry = new SafeIterableMap.Entry(obj, obj2);
        this.f1286d++;
        SafeIterableMap.Entry entry2 = this.f1284b;
        if (entry2 == null) {
            this.f1283a = entry;
            this.f1284b = entry;
        } else {
            entry2.f1289c = entry;
            entry.f1290d = entry2;
            this.f1284b = entry;
        }
        map.put(obj, entry);
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public final Object f(Object obj) {
        Object objF = super.f(obj);
        this.f1282e.remove(obj);
        return objF;
    }

    public final Map.Entry g(LifecycleObserver lifecycleObserver) {
        HashMap map = this.f1282e;
        if (map.containsKey(lifecycleObserver)) {
            return ((SafeIterableMap.Entry) map.get(lifecycleObserver)).f1290d;
        }
        return null;
    }
}
