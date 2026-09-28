package androidx.collection;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {

    /* renamed from: d, reason: collision with root package name */
    public EntrySet f1389d;

    /* renamed from: e, reason: collision with root package name */
    public KeySet f1390e;

    /* renamed from: f, reason: collision with root package name */
    public ValueCollection f1391f;

    /* loaded from: classes3.dex */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new MapIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return ArrayMap.this.f1605c;
        }
    }

    public final class KeyIterator extends IndexBasedArrayIterator<K> {
        public KeyIterator() {
            super(ArrayMap.this.f1605c);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public final Object a(int i2) {
            return ArrayMap.this.f(i2);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public final void b(int i2) {
            ArrayMap.this.h(i2);
        }
    }

    /* loaded from: classes3.dex */
    public final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public int f1395a;

        /* renamed from: b, reason: collision with root package name */
        public int f1396b = -1;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1397c;

        public MapIterator() {
            this.f1395a = ArrayMap.this.f1605c - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.f1397c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            int i2 = this.f1396b;
            ArrayMap arrayMap = ArrayMap.this;
            return Intrinsics.b(key, arrayMap.f(i2)) && Intrinsics.b(entry.getValue(), arrayMap.j(this.f1396b));
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            if (this.f1397c) {
                return ArrayMap.this.f(this.f1396b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            if (this.f1397c) {
                return ArrayMap.this.j(this.f1396b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f1396b < this.f1395a;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.f1397c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            int i2 = this.f1396b;
            ArrayMap arrayMap = ArrayMap.this;
            Object objF = arrayMap.f(i2);
            Object objJ = arrayMap.j(this.f1396b);
            return (objF == null ? 0 : objF.hashCode()) ^ (objJ != null ? objJ.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f1396b++;
            this.f1397c = true;
            return this;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f1397c) {
                throw new IllegalStateException();
            }
            ArrayMap.this.h(this.f1396b);
            this.f1396b--;
            this.f1395a--;
            this.f1397c = false;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (this.f1397c) {
                return ArrayMap.this.i(this.f1396b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: classes3.dex */
    public final class ValueIterator extends IndexBasedArrayIterator<V> {
        public ValueIterator() {
            super(ArrayMap.this.f1605c);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public final Object a(int i2) {
            return ArrayMap.this.j(i2);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public final void b(int i2) {
            ArrayMap.this.h(i2);
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        EntrySet entrySet = this.f1389d;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet();
        this.f1389d = entrySet2;
        return entrySet2;
    }

    public final boolean k(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!super.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public final Set keySet() {
        KeySet keySet = this.f1390e;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.f1390e = keySet2;
        return keySet2;
    }

    public boolean l(Collection collection) {
        int i2 = this.f1605c;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            super.remove(it.next());
        }
        return i2 != this.f1605c;
    }

    public boolean m(Collection collection) {
        int i2 = this.f1605c;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (!collection.contains(f(i3))) {
                h(i3);
            }
        }
        return i2 != this.f1605c;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        b(map.size() + this.f1605c);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        ValueCollection valueCollection = this.f1391f;
        if (valueCollection != null) {
            return valueCollection;
        }
        ValueCollection valueCollection2 = new ValueCollection();
        this.f1391f = valueCollection2;
        return valueCollection2;
    }

    public final class KeySet implements Set<K> {
        public KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            ArrayMap.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return ArrayMap.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection collection) {
            return ArrayMap.this.k(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            ArrayMap arrayMap = ArrayMap.this;
            try {
                if (arrayMap.f1605c == set.size()) {
                    return arrayMap.k(set);
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            ArrayMap arrayMap = ArrayMap.this;
            int iHashCode = 0;
            for (int i2 = arrayMap.f1605c - 1; i2 >= 0; i2--) {
                Object objF = arrayMap.f(i2);
                iHashCode += objF == null ? 0 : objF.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            int iD = arrayMap.d(obj);
            if (iD < 0) {
                return false;
            }
            arrayMap.h(iD);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection collection) {
            return ArrayMap.this.l(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection collection) {
            return ArrayMap.this.m(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return ArrayMap.this.f1605c;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            ArrayMap arrayMap = ArrayMap.this;
            int i2 = arrayMap.f1605c;
            Object[] objArr = new Object[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = arrayMap.f(i3);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            ArrayMap arrayMap = ArrayMap.this;
            int i2 = arrayMap.f1605c;
            if (objArr.length < i2) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
            }
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = arrayMap.f(i3);
            }
            if (objArr.length > i2) {
                objArr[i2] = null;
            }
            return objArr;
        }
    }

    public final class ValueCollection implements Collection<V> {
        public ValueCollection() {
        }

        @Override // java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            ArrayMap.this.clear();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            return ArrayMap.this.a(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            int iA = arrayMap.a(obj);
            if (iA < 0) {
                return false;
            }
            arrayMap.h(iA);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            ArrayMap arrayMap = ArrayMap.this;
            int i2 = arrayMap.f1605c;
            int i3 = 0;
            boolean z = false;
            while (i3 < i2) {
                if (collection.contains(arrayMap.j(i3))) {
                    arrayMap.h(i3);
                    i3--;
                    i2--;
                    z = true;
                }
                i3++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            ArrayMap arrayMap = ArrayMap.this;
            int i2 = arrayMap.f1605c;
            int i3 = 0;
            boolean z = false;
            while (i3 < i2) {
                if (!collection.contains(arrayMap.j(i3))) {
                    arrayMap.h(i3);
                    i3--;
                    i2--;
                    z = true;
                }
                i3++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return ArrayMap.this.f1605c;
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            ArrayMap arrayMap = ArrayMap.this;
            int i2 = arrayMap.f1605c;
            Object[] objArr = new Object[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = arrayMap.j(i3);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            ArrayMap arrayMap = ArrayMap.this;
            int i2 = arrayMap.f1605c;
            if (objArr.length < i2) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i2);
            }
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = arrayMap.j(i3);
            }
            if (objArr.length > i2) {
                objArr[i2] = null;
            }
            return objArr;
        }
    }
}
