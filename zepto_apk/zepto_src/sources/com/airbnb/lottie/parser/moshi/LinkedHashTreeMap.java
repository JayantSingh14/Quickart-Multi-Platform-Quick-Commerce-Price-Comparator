package com.airbnb.lottie.parser.moshi;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes3.dex */
final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Comparator f14772c = null;

    /* renamed from: a, reason: collision with root package name */
    public int f14773a;

    /* renamed from: b, reason: collision with root package name */
    public int f14774b;

    /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$1, reason: invalid class name */
    public class AnonymousClass1 implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public final int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public static final class AvlBuilder<K, V> {
    }

    public static class AvlIterator<K, V> {
    }

    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$EntrySet$1, reason: invalid class name */
        class AnonymousClass1 extends LinkedHashTreeMap<Object, Object>.LinkedTreeMapIterator<Map.Entry<Object, Object>> {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Object key;
            if (!(obj instanceof Map.Entry) || (key = ((Map.Entry) obj).getKey()) == null) {
                return false;
            }
            try {
                key.hashCode();
                throw null;
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            new AnonymousClass1();
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Object key;
            if (!(obj instanceof Map.Entry) || (key = ((Map.Entry) obj).getKey()) == null) {
                return false;
            }
            try {
                key.hashCode();
                throw null;
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            throw null;
        }
    }

    public final class KeySet extends AbstractSet<K> {

        /* renamed from: com.airbnb.lottie.parser.moshi.LinkedHashTreeMap$KeySet$1, reason: invalid class name */
        class AnonymousClass1 extends LinkedHashTreeMap<Object, Object>.LinkedTreeMapIterator<Object> {
            @Override // com.airbnb.lottie.parser.moshi.LinkedHashTreeMap.LinkedTreeMapIterator, java.util.Iterator
            public final Object next() {
                a();
                throw null;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            new AnonymousClass1();
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                obj.hashCode();
                throw null;
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            throw null;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public Node f14775a;

        /* renamed from: b, reason: collision with root package name */
        public Node f14776b;

        /* renamed from: c, reason: collision with root package name */
        public int f14777c;

        public LinkedTreeMapIterator() {
            throw null;
        }

        public final Node a() {
            Node node = this.f14775a;
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            linkedHashTreeMap.getClass();
            if (node == null) {
                throw new NoSuchElementException();
            }
            if (linkedHashTreeMap.f14774b != this.f14777c) {
                throw new ConcurrentModificationException();
            }
            this.f14775a = node.f14782d;
            this.f14776b = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Node node = this.f14775a;
            LinkedHashTreeMap.this.getClass();
            return node != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node node = this.f14776b;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap linkedHashTreeMap = LinkedHashTreeMap.this;
            linkedHashTreeMap.a(node, true);
            this.f14776b = null;
            this.f14777c = linkedHashTreeMap.f14774b;
        }
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Node f14779a;

        /* renamed from: b, reason: collision with root package name */
        public Node f14780b;

        /* renamed from: c, reason: collision with root package name */
        public Node f14781c;

        /* renamed from: d, reason: collision with root package name */
        public Node f14782d;

        /* renamed from: e, reason: collision with root package name */
        public Node f14783e;

        /* renamed from: f, reason: collision with root package name */
        public Object f14784f;

        /* renamed from: g, reason: collision with root package name */
        public int f14785g;

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            throw null;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            throw null;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f14784f;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            throw null;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object obj2 = this.f14784f;
            this.f14784f = obj;
            return obj2;
        }

        public final String toString() {
            throw null;
        }
    }

    public final void a(Node node, boolean z) {
        Node node2;
        Node node3;
        int i2;
        if (z) {
            Node node4 = node.f14783e;
            node4.f14782d = node.f14782d;
            node.f14782d.f14783e = node4;
            node.f14783e = null;
            node.f14782d = null;
        }
        Node node5 = node.f14780b;
        Node node6 = node.f14781c;
        Node node7 = node.f14779a;
        int i3 = 0;
        if (node5 != null && node6 != null) {
            if (node5.f14785g > node6.f14785g) {
                Node node8 = node5.f14781c;
                while (true) {
                    Node node9 = node8;
                    node3 = node5;
                    node5 = node9;
                    if (node5 == null) {
                        break;
                    } else {
                        node8 = node5.f14781c;
                    }
                }
            } else {
                Node node10 = node6.f14780b;
                while (true) {
                    node2 = node6;
                    node6 = node10;
                    if (node6 == null) {
                        break;
                    } else {
                        node10 = node6.f14780b;
                    }
                }
                node3 = node2;
            }
            a(node3, false);
            Node node11 = node.f14780b;
            if (node11 != null) {
                i2 = node11.f14785g;
                node3.f14780b = node11;
                node11.f14779a = node3;
                node.f14780b = null;
            } else {
                i2 = 0;
            }
            Node node12 = node.f14781c;
            if (node12 != null) {
                i3 = node12.f14785g;
                node3.f14781c = node12;
                node12.f14779a = node3;
                node.f14781c = null;
            }
            node3.f14785g = Math.max(i2, i3) + 1;
            b(node, node3);
            return;
        }
        if (node5 != null) {
            b(node, node5);
            node.f14780b = null;
        } else if (node6 != null) {
            b(node, node6);
            node.f14781c = null;
        } else {
            b(node, null);
        }
        while (true) {
            if (node7 == null) {
                break;
            }
            Node node13 = node7.f14780b;
            Node node14 = node7.f14781c;
            int i4 = node13 != null ? node13.f14785g : 0;
            int i5 = node14 != null ? node14.f14785g : 0;
            int i6 = i4 - i5;
            if (i6 != -2) {
                if (i6 != 2) {
                    if (i6 != 0) {
                        node7.f14785g = Math.max(i4, i5) + 1;
                        break;
                    }
                    node7.f14785g = i4 + 1;
                } else {
                    Node node15 = node13.f14780b;
                    Node node16 = node13.f14781c;
                    int i7 = (node15 != null ? node15.f14785g : 0) - (node16 != null ? node16.f14785g : 0);
                    if (i7 == 1 || i7 == 0) {
                        d(node7);
                    } else {
                        c(node13);
                        d(node7);
                    }
                }
            } else {
                Node node17 = node14.f14780b;
                Node node18 = node14.f14781c;
                int i8 = (node17 != null ? node17.f14785g : 0) - (node18 != null ? node18.f14785g : 0);
                if (i8 == -1 || i8 == 0) {
                    c(node7);
                } else {
                    d(node14);
                    c(node7);
                }
            }
            node7 = node7.f14779a;
        }
        this.f14773a--;
        this.f14774b++;
    }

    public final void b(Node node, Node node2) {
        Node node3 = node.f14779a;
        node.f14779a = null;
        if (node2 != null) {
            node2.f14779a = node3;
        }
        node3.getClass();
        if (node3.f14780b == node) {
            node3.f14780b = node2;
        } else {
            node3.f14781c = node2;
        }
    }

    public final void c(Node node) {
        Node node2 = node.f14780b;
        Node node3 = node.f14781c;
        Node node4 = node3.f14780b;
        Node node5 = node3.f14781c;
        node.f14781c = node4;
        if (node4 != null) {
            node4.f14779a = node;
        }
        b(node, node3);
        node3.f14780b = node;
        node.f14779a = node3;
        int iMax = Math.max(node2 != null ? node2.f14785g : 0, node4 != null ? node4.f14785g : 0) + 1;
        node.f14785g = iMax;
        node3.f14785g = Math.max(iMax, node5 != null ? node5.f14785g : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Arrays.fill((Object[]) null, (Object) null);
        this.f14773a = 0;
        this.f14774b++;
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            obj.hashCode();
            throw null;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final void d(Node node) {
        Node node2 = node.f14780b;
        Node node3 = node.f14781c;
        Node node4 = node2.f14780b;
        Node node5 = node2.f14781c;
        node.f14780b = node5;
        if (node5 != null) {
            node5.f14779a = node;
        }
        b(node, node2);
        node2.f14781c = node;
        node.f14779a = node2;
        int iMax = Math.max(node3 != null ? node3.f14785g : 0, node5 != null ? node5.f14785g : 0) + 1;
        node.f14785g = iMax;
        node2.f14785g = Math.max(iMax, node4 != null ? node4.f14785g : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        if (obj != null) {
            try {
                obj.hashCode();
                throw null;
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        obj.hashCode();
        throw null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        if (obj != null) {
            try {
                obj.hashCode();
                throw null;
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f14773a;
    }
}
