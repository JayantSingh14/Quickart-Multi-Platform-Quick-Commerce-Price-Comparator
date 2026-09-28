package androidx.databinding;

import androidx.collection.ArrayMap;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ObservableArrayMap<K, V> extends ArrayMap<K, V> implements ObservableMap<K, V> {
    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final void clear() {
        if (isEmpty()) {
            return;
        }
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object h(int i2) {
        f(i2);
        return super.h(i2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object i(int i2, Object obj) {
        f(i2);
        return super.i(i2, obj);
    }

    @Override // androidx.collection.ArrayMap
    public final boolean l(Collection collection) {
        Iterator it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            int iD = d(it.next());
            if (iD >= 0) {
                h(iD);
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.collection.ArrayMap
    public final boolean m(Collection collection) {
        boolean z = false;
        for (int i2 = this.f1605c - 1; i2 >= 0; i2--) {
            if (!collection.contains(f(i2))) {
                h(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        super.put(obj, obj2);
        return obj2;
    }
}
