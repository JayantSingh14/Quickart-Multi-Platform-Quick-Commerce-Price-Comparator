package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
class SmallSortedMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f4141g = 0;

    /* renamed from: a, reason: collision with root package name */
    public List f4142a;

    /* renamed from: b, reason: collision with root package name */
    public Map f4143b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4144c;

    /* renamed from: d, reason: collision with root package name */
    public volatile EntrySet f4145d;

    /* renamed from: e, reason: collision with root package name */
    public Map f4146e;

    /* renamed from: f, reason: collision with root package name */
    public volatile DescendingEntrySet f4147f;

    /* renamed from: androidx.datastore.preferences.protobuf.SmallSortedMap$1, reason: invalid class name */
    class AnonymousClass1 extends SmallSortedMap<FieldSet.FieldDescriptorLite<Object>, Object> {
        @Override // androidx.datastore.preferences.protobuf.SmallSortedMap
        public final void f() {
            if (!this.f4144c) {
                for (int i2 = 0; i2 < this.f4142a.size(); i2++) {
                    Map.Entry entryC = c(i2);
                    if (((FieldSet.FieldDescriptorLite) entryC.getKey()).m()) {
                        entryC.setValue(Collections.unmodifiableList((List) entryC.getValue()));
                    }
                }
                for (Map.Entry entry : d()) {
                    if (((FieldSet.FieldDescriptorLite) entry.getKey()).m()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.f();
        }

        @Override // androidx.datastore.preferences.protobuf.SmallSortedMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return put((Comparable) obj, obj2);
        }
    }

    public class DescendingEntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public int f4148a;

        /* renamed from: b, reason: collision with root package name */
        public Iterator f4149b;

        public DescendingEntryIterator() {
            this.f4148a = SmallSortedMap.this.f4142a.size();
        }

        public final Iterator a() {
            if (this.f4149b == null) {
                this.f4149b = SmallSortedMap.this.f4146e.entrySet().iterator();
            }
            return this.f4149b;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i2 = this.f4148a;
            return (i2 > 0 && i2 <= SmallSortedMap.this.f4142a.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (a().hasNext()) {
                return (Map.Entry) a().next();
            }
            List list = SmallSortedMap.this.f4142a;
            int i2 = this.f4148a - 1;
            this.f4148a = i2;
            return (Map.Entry) list.get(i2);
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class DescendingEntrySet extends SmallSortedMap<K, V>.EntrySet {
        public DescendingEntrySet() {
            super();
        }

        @Override // androidx.datastore.preferences.protobuf.SmallSortedMap.EntrySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new DescendingEntryIterator();
        }
    }

    public class Entry implements Map.Entry<K, V>, Comparable<SmallSortedMap<K, V>.Entry> {

        /* renamed from: a, reason: collision with root package name */
        public final Comparable f4152a;

        /* renamed from: b, reason: collision with root package name */
        public Object f4153b;

        public Entry(Comparable comparable, Object obj) {
            this.f4152a = comparable;
            this.f4153b = obj;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f4152a.compareTo(((Entry) obj).f4152a);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj != this) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Comparable comparable = this.f4152a;
                    if (comparable == null ? key == null : comparable.equals(key)) {
                        Object obj2 = this.f4153b;
                        Object value = entry.getValue();
                        if (obj2 == null ? value == null : obj2.equals(value)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f4152a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f4153b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Comparable comparable = this.f4152a;
            int iHashCode = comparable == null ? 0 : comparable.hashCode();
            Object obj = this.f4153b;
            return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            int i2 = SmallSortedMap.f4141g;
            SmallSortedMap.this.b();
            Object obj2 = this.f4153b;
            this.f4153b = obj;
            return obj2;
        }

        public final String toString() {
            return this.f4152a + "=" + this.f4153b;
        }
    }

    public class EntryIterator implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public int f4155a = -1;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4156b;

        /* renamed from: c, reason: collision with root package name */
        public Iterator f4157c;

        public EntryIterator() {
        }

        public final Iterator a() {
            if (this.f4157c == null) {
                this.f4157c = SmallSortedMap.this.f4143b.entrySet().iterator();
            }
            return this.f4157c;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i2 = this.f4155a + 1;
            SmallSortedMap smallSortedMap = SmallSortedMap.this;
            return i2 < smallSortedMap.f4142a.size() || (!smallSortedMap.f4143b.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public final Object next() {
            this.f4156b = true;
            int i2 = this.f4155a + 1;
            this.f4155a = i2;
            SmallSortedMap smallSortedMap = SmallSortedMap.this;
            return i2 < smallSortedMap.f4142a.size() ? (Map.Entry) smallSortedMap.f4142a.get(this.f4155a) : (Map.Entry) a().next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.f4156b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f4156b = false;
            int i2 = SmallSortedMap.f4141g;
            SmallSortedMap smallSortedMap = SmallSortedMap.this;
            smallSortedMap.b();
            if (this.f4155a >= smallSortedMap.f4142a.size()) {
                a().remove();
                return;
            }
            int i3 = this.f4155a;
            this.f4155a = i3 - 1;
            smallSortedMap.i(i3);
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            SmallSortedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return SmallSortedMap.this.size();
        }
    }

    public static AnonymousClass1 g() {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.f4142a = Collections.EMPTY_LIST;
        Map map = Collections.EMPTY_MAP;
        anonymousClass1.f4143b = map;
        anonymousClass1.f4146e = map;
        return anonymousClass1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Comparable r5) {
        /*
            r4 = this;
            java.util.List r0 = r4.f4142a
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L21
            java.util.List r2 = r4.f4142a
            java.lang.Object r2 = r2.get(r1)
            androidx.datastore.preferences.protobuf.SmallSortedMap$Entry r2 = (androidx.datastore.preferences.protobuf.SmallSortedMap.Entry) r2
            java.lang.Comparable r2 = r2.f4152a
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1e
            int r0 = r0 + 1
        L1c:
            int r5 = -r0
            return r5
        L1e:
            if (r2 != 0) goto L21
            return r1
        L21:
            r0 = 0
        L22:
            if (r0 > r1) goto L43
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List r3 = r4.f4142a
            java.lang.Object r3 = r3.get(r2)
            androidx.datastore.preferences.protobuf.SmallSortedMap$Entry r3 = (androidx.datastore.preferences.protobuf.SmallSortedMap.Entry) r3
            java.lang.Comparable r3 = r3.f4152a
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3c
            int r2 = r2 + (-1)
            r1 = r2
            goto L22
        L3c:
            if (r3 <= 0) goto L42
            int r2 = r2 + 1
            r0 = r2
            goto L22
        L42:
            return r2
        L43:
            int r0 = r0 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.SmallSortedMap.a(java.lang.Comparable):int");
    }

    public final void b() {
        if (this.f4144c) {
            throw new UnsupportedOperationException();
        }
    }

    public final Map.Entry c(int i2) {
        return (Map.Entry) this.f4142a.get(i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        b();
        if (!this.f4142a.isEmpty()) {
            this.f4142a.clear();
        }
        if (this.f4143b.isEmpty()) {
            return;
        }
        this.f4143b.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f4143b.containsKey(comparable);
    }

    public final Set d() {
        return this.f4143b.isEmpty() ? Collections.EMPTY_SET : this.f4143b.entrySet();
    }

    public final SortedMap e() {
        b();
        if (this.f4143b.isEmpty() && !(this.f4143b instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f4143b = treeMap;
            this.f4146e = treeMap.descendingMap();
        }
        return (SortedMap) this.f4143b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f4145d == null) {
            this.f4145d = new EntrySet();
        }
        return this.f4145d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmallSortedMap)) {
            return super.equals(obj);
        }
        SmallSortedMap smallSortedMap = (SmallSortedMap) obj;
        int size = size();
        if (size == smallSortedMap.size()) {
            int size2 = this.f4142a.size();
            if (size2 != smallSortedMap.f4142a.size()) {
                return ((AbstractSet) entrySet()).equals(smallSortedMap.entrySet());
            }
            for (int i2 = 0; i2 < size2; i2++) {
                if (c(i2).equals(smallSortedMap.c(i2))) {
                }
            }
            if (size2 != size) {
                return this.f4143b.equals(smallSortedMap.f4143b);
            }
            return true;
        }
        return false;
    }

    public void f() {
        if (this.f4144c) {
            return;
        }
        this.f4143b = this.f4143b.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f4143b);
        this.f4146e = this.f4146e.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.f4146e);
        this.f4144c = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? ((Entry) this.f4142a.get(iA)).f4153b : this.f4143b.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        b();
        int iA = a(comparable);
        if (iA >= 0) {
            return ((Entry) this.f4142a.get(iA)).setValue(obj);
        }
        b();
        if (this.f4142a.isEmpty() && !(this.f4142a instanceof ArrayList)) {
            this.f4142a = new ArrayList(16);
        }
        int i2 = -(iA + 1);
        if (i2 >= 16) {
            return e().put(comparable, obj);
        }
        if (this.f4142a.size() == 16) {
            Entry entry = (Entry) this.f4142a.remove(15);
            e().put(entry.f4152a, entry.f4153b);
        }
        this.f4142a.add(i2, new Entry(comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f4142a.size();
        int iHashCode = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iHashCode += ((Entry) this.f4142a.get(i2)).hashCode();
        }
        return this.f4143b.size() > 0 ? this.f4143b.hashCode() + iHashCode : iHashCode;
    }

    public final Object i(int i2) {
        b();
        Object obj = ((Entry) this.f4142a.remove(i2)).f4153b;
        if (!this.f4143b.isEmpty()) {
            Iterator it = e().entrySet().iterator();
            List list = this.f4142a;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new Entry((Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return i(iA);
        }
        if (this.f4143b.isEmpty()) {
            return null;
        }
        return this.f4143b.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f4143b.size() + this.f4142a.size();
    }
}
