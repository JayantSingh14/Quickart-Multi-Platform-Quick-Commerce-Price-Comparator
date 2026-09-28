package androidx.arch.core.internal;

import androidx.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    public Entry f1283a;

    /* renamed from: b, reason: collision with root package name */
    public Entry f1284b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap f1285c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    public int f1286d = 0;

    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public final Entry b(Entry entry) {
            return entry.f1290d;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public final Entry c(Entry entry) {
            return entry.f1289c;
        }
    }

    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public final Entry b(Entry entry) {
            return entry.f1289c;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public final Entry c(Entry entry) {
            return entry.f1290d;
        }
    }

    public static class Entry<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f1287a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f1288b;

        /* renamed from: c, reason: collision with root package name */
        public Entry f1289c;

        /* renamed from: d, reason: collision with root package name */
        public Entry f1290d;

        public Entry(Object obj, Object obj2) {
            this.f1287a = obj;
            this.f1288b = obj2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.f1287a.equals(entry.f1287a) && this.f1288b.equals(entry.f1288b);
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f1287a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f1288b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return this.f1287a.hashCode() ^ this.f1288b.hashCode();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return this.f1287a + "=" + this.f1288b;
        }
    }

    @RestrictTo
    public class IteratorWithAdditions extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public Entry f1291a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1292b = true;

        public IteratorWithAdditions() {
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void a(Entry entry) {
            Entry entry2 = this.f1291a;
            if (entry == entry2) {
                Entry entry3 = entry2.f1290d;
                this.f1291a = entry3;
                this.f1292b = entry3 == null;
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f1292b) {
                return SafeIterableMap.this.f1283a != null;
            }
            Entry entry = this.f1291a;
            return (entry == null || entry.f1289c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.f1292b) {
                this.f1292b = false;
                this.f1291a = SafeIterableMap.this.f1283a;
            } else {
                Entry entry = this.f1291a;
                this.f1291a = entry != null ? entry.f1289c : null;
            }
            return this.f1291a;
        }
    }

    public static abstract class ListIterator<K, V> extends SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public Entry f1294a;

        /* renamed from: b, reason: collision with root package name */
        public Entry f1295b;

        public ListIterator(Entry entry, Entry entry2) {
            this.f1294a = entry2;
            this.f1295b = entry;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public final void a(Entry entry) {
            Entry entryC = null;
            if (this.f1294a == entry && entry == this.f1295b) {
                this.f1295b = null;
                this.f1294a = null;
            }
            Entry entry2 = this.f1294a;
            if (entry2 == entry) {
                this.f1294a = b(entry2);
            }
            Entry entry3 = this.f1295b;
            if (entry3 == entry) {
                Entry entry4 = this.f1294a;
                if (entry3 != entry4 && entry4 != null) {
                    entryC = c(entry3);
                }
                this.f1295b = entryC;
            }
        }

        public abstract Entry b(Entry entry);

        public abstract Entry c(Entry entry);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f1295b != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Entry entry = this.f1295b;
            Entry entry2 = this.f1294a;
            this.f1295b = (entry == entry2 || entry2 == null) ? null : c(entry);
            return entry;
        }
    }

    @RestrictTo
    public static abstract class SupportRemove<K, V> {
        public abstract void a(Entry entry);
    }

    public Entry b(Object obj) {
        Entry entry = this.f1283a;
        while (entry != null && !entry.f1287a.equals(obj)) {
            entry = entry.f1289c;
        }
        return entry;
    }

    public Object d(Object obj, Object obj2) {
        Entry entryB = b(obj);
        if (entryB != null) {
            return entryB.f1288b;
        }
        Entry entry = new Entry(obj, obj2);
        this.f1286d++;
        Entry entry2 = this.f1284b;
        if (entry2 == null) {
            this.f1283a = entry;
            this.f1284b = entry;
            return null;
        }
        entry2.f1289c = entry;
        entry.f1290d = entry2;
        this.f1284b = entry;
        return null;
    }

    public final Iterator descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.f1284b, this.f1283a);
        this.f1285c.put(descendingIterator, Boolean.FALSE);
        return descendingIterator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((androidx.arch.core.internal.SafeIterableMap.ListIterator) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof androidx.arch.core.internal.SafeIterableMap
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            androidx.arch.core.internal.SafeIterableMap r7 = (androidx.arch.core.internal.SafeIterableMap) r7
            int r1 = r6.f1286d
            int r3 = r7.f1286d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            androidx.arch.core.internal.SafeIterableMap$ListIterator r3 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            androidx.arch.core.internal.SafeIterableMap$ListIterator r4 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            androidx.arch.core.internal.SafeIterableMap$ListIterator r7 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.arch.core.internal.SafeIterableMap.equals(java.lang.Object):boolean");
    }

    public Object f(Object obj) {
        Entry entryB = b(obj);
        if (entryB == null) {
            return null;
        }
        this.f1286d--;
        WeakHashMap weakHashMap = this.f1285c;
        if (!weakHashMap.isEmpty()) {
            Iterator<K> it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((SupportRemove) it.next()).a(entryB);
            }
        }
        Entry entry = entryB.f1290d;
        if (entry != null) {
            entry.f1289c = entryB.f1289c;
        } else {
            this.f1283a = entryB.f1289c;
        }
        Entry entry2 = entryB.f1289c;
        if (entry2 != null) {
            entry2.f1290d = entry;
        } else {
            this.f1284b = entry;
        }
        entryB.f1289c = null;
        entryB.f1290d = null;
        return entryB.f1288b;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (!listIterator.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) listIterator.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.f1283a, this.f1284b);
        this.f1285c.put(ascendingIterator, Boolean.FALSE);
        return ascendingIterator;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            ListIterator listIterator = (ListIterator) it;
            if (!listIterator.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) listIterator.next()).toString());
            if (listIterator.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
