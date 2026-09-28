package androidx.coordinatorlayout.widget;

import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;

@RestrictTo
/* loaded from: classes3.dex */
public final class DirectedAcyclicGraph<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Pools.SimplePool f2575a = new Pools.SimplePool(10);

    /* renamed from: b, reason: collision with root package name */
    public final SimpleArrayMap f2576b = new SimpleArrayMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2577c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f2578d = new HashSet();

    public final void a(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f2576b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                a(arrayList2.get(i2), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }
}
