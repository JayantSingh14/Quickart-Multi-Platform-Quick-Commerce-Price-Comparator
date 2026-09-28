package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multimaps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractMultimap<K, V> implements Multimap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public transient Collection f42506a;

    /* renamed from: b, reason: collision with root package name */
    public transient Set f42507b;

    /* renamed from: c, reason: collision with root package name */
    public transient Collection f42508c;

    /* renamed from: d, reason: collision with root package name */
    public transient Map f42509d;

    public class Entries extends Multimaps.Entries<K, V> {
        public Entries() {
        }

        @Override // com.google.common.collect.Multimaps.Entries
        public final Multimap b() {
            return AbstractMultimap.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return AbstractMultimap.this.g();
        }
    }

    public class EntrySet extends AbstractMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            return Sets.b(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Sets.e(this);
        }
    }

    public class Values extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractMapBasedMultimap f42511a;

        public Values(AbstractMapBasedMultimap abstractMapBasedMultimap) {
            this.f42511a = abstractMapBasedMultimap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f42511a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return this.f42511a.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return this.f42511a.o();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f42511a.size();
        }
    }

    public abstract Map a();

    @Override // com.google.common.collect.Multimap
    public Map asMap() {
        Map map = this.f42509d;
        if (map != null) {
            return map;
        }
        Map mapA = a();
        this.f42509d = mapA;
        return mapA;
    }

    public abstract Collection c();

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(Object obj) {
        Iterator<V> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.Multimap
    public Collection d() {
        Collection collection = this.f42506a;
        if (collection != null) {
            return collection;
        }
        Collection collectionC = c();
        this.f42506a = collectionC;
        return collectionC;
    }

    public abstract Set e();

    @Override // com.google.common.collect.Multimap
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Multimap) {
            return asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }

    public abstract Collection f();

    public abstract Iterator g();

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.Multimap
    public Set keySet() {
        Set set = this.f42507b;
        if (set != null) {
            return set;
        }
        Set setE = e();
        this.f42507b = setE;
        return setE;
    }

    @Override // com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        return get(obj).add(obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean remove(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean s(Object obj, Object obj2) {
        Collection collection = (Collection) asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public String toString() {
        return asMap().toString();
    }

    @Override // com.google.common.collect.Multimap
    public Collection values() {
        Collection collection = this.f42508c;
        if (collection != null) {
            return collection;
        }
        Collection collectionF = f();
        this.f42508c = collectionF;
        return collectionF;
    }
}
