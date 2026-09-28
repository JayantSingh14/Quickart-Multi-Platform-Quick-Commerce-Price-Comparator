package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public transient Node f42789e;

    /* renamed from: f, reason: collision with root package name */
    public transient Node f42790f;

    /* renamed from: com.google.common.collect.LinkedListMultimap$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractSequentialList<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f42791a;

        public AnonymousClass1(Object obj) {
            this.f42791a = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public final ListIterator listIterator(int i2) {
            new ValueForKeyIterator();
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            LinkedListMultimap.this.getClass();
            throw null;
        }
    }

    public class DistinctKeyIterator implements Iterator<K> {

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f42797a;

        /* renamed from: b, reason: collision with root package name */
        public Node f42798b;

        /* renamed from: c, reason: collision with root package name */
        public Node f42799c;

        public DistinctKeyIterator() {
            this.f42797a = new HashSet(Maps.c(LinkedListMultimap.this.keySet().size()));
            this.f42798b = LinkedListMultimap.this.f42789e;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            LinkedListMultimap.this.getClass();
            return this.f42798b != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Node node;
            LinkedListMultimap.this.getClass();
            Node node2 = this.f42798b;
            if (node2 == null) {
                throw new NoSuchElementException();
            }
            this.f42799c = node2;
            HashSet hashSet = this.f42797a;
            hashSet.add(node2.f42801a);
            do {
                node = this.f42798b.f42803c;
                this.f42798b = node;
                if (node == null) {
                    break;
                }
            } while (!hashSet.add(node.f42801a));
            return this.f42799c.f42801a;
        }

        @Override // java.util.Iterator
        public final void remove() {
            LinkedListMultimap linkedListMultimap = LinkedListMultimap.this;
            linkedListMultimap.getClass();
            Preconditions.m("no calls to next() since the last call to remove()", this.f42799c != null);
            Object obj = this.f42799c.f42801a;
            linkedListMultimap.getClass();
            new ValueForKeyIterator(obj);
            throw null;
        }
    }

    public static class KeyList<K, V> {
    }

    public static final class Node<K, V> extends AbstractMapEntry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42801a;

        /* renamed from: b, reason: collision with root package name */
        public Object f42802b;

        /* renamed from: c, reason: collision with root package name */
        public Node f42803c;

        /* renamed from: d, reason: collision with root package name */
        public Node f42804d;

        public Node(Object obj, Object obj2) {
            this.f42801a = obj;
            this.f42802b = obj2;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f42801a;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f42802b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object obj2 = this.f42802b;
            this.f42802b = obj;
            return obj2;
        }
    }

    public class NodeIterator implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public int f42805a;

        /* renamed from: b, reason: collision with root package name */
        public Node f42806b;

        /* renamed from: c, reason: collision with root package name */
        public Node f42807c;

        /* renamed from: d, reason: collision with root package name */
        public Node f42808d;

        public NodeIterator(int i2) {
            LinkedListMultimap.this.getClass();
            Preconditions.k(i2, 0);
            if (i2 < 0) {
                this.f42806b = LinkedListMultimap.this.f42789e;
                while (true) {
                    int i3 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    a();
                    Node node = this.f42806b;
                    if (node == null) {
                        throw new NoSuchElementException();
                    }
                    this.f42807c = node;
                    this.f42808d = node;
                    this.f42806b = node.f42803c;
                    this.f42805a++;
                    i2 = i3;
                }
            } else {
                this.f42808d = LinkedListMultimap.this.f42790f;
                this.f42805a = 0;
                while (true) {
                    int i4 = i2 + 1;
                    if (i2 >= 0) {
                        break;
                    }
                    a();
                    Node node2 = this.f42808d;
                    if (node2 == null) {
                        throw new NoSuchElementException();
                    }
                    this.f42807c = node2;
                    this.f42806b = node2;
                    this.f42808d = node2.f42804d;
                    this.f42805a--;
                    i2 = i4;
                }
            }
            this.f42807c = null;
        }

        public final void a() {
            throw null;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            a();
            return this.f42806b != null;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            a();
            return this.f42808d != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            a();
            Node node = this.f42806b;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.f42807c = node;
            this.f42808d = node;
            this.f42806b = node.f42803c;
            this.f42805a++;
            return node;
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return this.f42805a;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            a();
            Node node = this.f42808d;
            if (node == null) {
                throw new NoSuchElementException();
            }
            this.f42807c = node;
            this.f42806b = node;
            this.f42808d = node.f42804d;
            this.f42805a--;
            return node;
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return this.f42805a - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            throw null;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Map a() {
        return new Multimaps.AsMap(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final /* bridge */ /* synthetic */ Collection b(Object obj) {
        b(obj);
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection c() {
        return new AbstractSequentialList<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.LinkedListMultimap.1EntriesImpl
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public final ListIterator listIterator(int i2) {
                return new NodeIterator(i2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                throw null;
            }
        };
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        this.f42789e = null;
        this.f42790f = null;
        throw null;
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean containsValue(Object obj) {
        return ((List) super.values()).contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Collection d() {
        return (List) super.d();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Set e() {
        return new Sets.ImprovedAbstractSet<Object>() { // from class: com.google.common.collect.LinkedListMultimap.1KeySetImpl
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                LinkedListMultimap.this.getClass();
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return new DistinctKeyIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(Object obj) {
                LinkedListMultimap.this.b(obj);
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                LinkedListMultimap.this.getClass();
                throw null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection f() {
        return new AbstractSequentialList<Object>() { // from class: com.google.common.collect.LinkedListMultimap.1ValuesImpl
            @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
            public final ListIterator listIterator(int i2) {
                final NodeIterator nodeIterator = new NodeIterator(i2);
                return new TransformedListIterator<Map.Entry<Object, Object>, Object>(nodeIterator) { // from class: com.google.common.collect.LinkedListMultimap.1ValuesImpl.1
                    @Override // com.google.common.collect.TransformedIterator
                    public final Object a(Object obj) {
                        return ((Map.Entry) obj).getValue();
                    }

                    @Override // com.google.common.collect.TransformedListIterator, java.util.ListIterator
                    public final void set(Object obj) {
                        NodeIterator nodeIterator2 = nodeIterator;
                        Preconditions.n(nodeIterator2.f42807c != null);
                        nodeIterator2.f42807c.f42802b = obj;
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                throw null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Iterator g() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public final Collection l(Object obj) {
        return new AnonymousClass1(obj);
    }

    public final void h(Object obj, Object obj2) {
        Node node = new Node(obj, obj2);
        if (this.f42789e == null) {
            this.f42790f = node;
            this.f42789e = node;
            throw null;
        }
        Node node2 = this.f42790f;
        Objects.requireNonNull(node2);
        node2.f42803c = node;
        node.f42804d = this.f42790f;
        this.f42790f = node;
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean isEmpty() {
        return this.f42789e == null;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean put(Object obj, Object obj2) {
        h(obj, obj2);
        throw null;
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Collection values() {
        return (List) super.values();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public final List b(Object obj) {
        new ValueForKeyIterator(obj);
        throw null;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public final List l(Object obj) {
        return new AnonymousClass1(obj);
    }

    public class ValueForKeyIterator implements ListIterator<V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42810a;

        public ValueForKeyIterator(Object obj) {
            this.f42810a = obj;
            LinkedListMultimap.this.getClass();
            throw null;
        }

        @Override // java.util.ListIterator
        public final void add(Object obj) {
            LinkedListMultimap.this.h(this.f42810a, obj);
            throw null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.ListIterator
        public final boolean hasPrevious() {
            return false;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int nextIndex() {
            return 0;
        }

        @Override // java.util.ListIterator
        public final Object previous() {
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public final int previousIndex() {
            return 0 - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public final void remove() {
            Preconditions.m("no calls to next() since the last call to remove()", false);
            throw null;
        }

        @Override // java.util.ListIterator
        public final void set(Object obj) {
            Preconditions.n(false);
            throw null;
        }

        public ValueForKeyIterator() {
            LinkedListMultimap.this.getClass();
            throw null;
        }
    }
}
