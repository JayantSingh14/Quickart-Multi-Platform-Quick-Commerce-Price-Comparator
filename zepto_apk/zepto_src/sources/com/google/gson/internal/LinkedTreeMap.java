package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public static final Comparator f45308i = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f45309a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f45310b;

    /* renamed from: c, reason: collision with root package name */
    public Node f45311c;

    /* renamed from: d, reason: collision with root package name */
    public int f45312d;

    /* renamed from: e, reason: collision with root package name */
    public int f45313e;

    /* renamed from: f, reason: collision with root package name */
    public final Node f45314f;

    /* renamed from: g, reason: collision with root package name */
    public EntrySet f45315g;

    /* renamed from: h, reason: collision with root package name */
    public KeySet f45316h;

    /* renamed from: com.google.gson.internal.LinkedTreeMap$1, reason: invalid class name */
    public class AnonymousClass1 implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public final int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        /* renamed from: com.google.gson.internal.LinkedTreeMap$EntrySet$1, reason: invalid class name */
        class AnonymousClass1 extends LinkedTreeMap<Object, Object>.LinkedTreeMapIterator<Map.Entry<Object, Object>> {
        }

        public EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedTreeMap.this.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[RETURN] */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean contains(java.lang.Object r5) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L29
                com.google.gson.internal.LinkedTreeMap r0 = com.google.gson.internal.LinkedTreeMap.this
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r2 = r5.getKey()
                r3 = 0
                if (r2 == 0) goto L15
                com.google.gson.internal.LinkedTreeMap$Node r0 = r0.a(r2, r1)     // Catch: java.lang.ClassCastException -> L15
                goto L16
            L15:
                r0 = r3
            L16:
                if (r0 == 0) goto L25
                java.lang.Object r2 = r0.f45330h
                java.lang.Object r5 = r5.getValue()
                boolean r5 = java.util.Objects.equals(r2, r5)
                if (r5 == 0) goto L25
                r3 = r0
            L25:
                if (r3 == 0) goto L29
                r5 = 1
                return r5
            L29:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.EntrySet.contains(java.lang.Object):boolean");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new AnonymousClass1();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean remove(java.lang.Object r6) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L6
                goto L28
            L6:
                java.util.Map$Entry r6 = (java.util.Map.Entry) r6
                com.google.gson.internal.LinkedTreeMap r0 = com.google.gson.internal.LinkedTreeMap.this
                java.lang.Object r2 = r6.getKey()
                r3 = 0
                if (r2 == 0) goto L16
                com.google.gson.internal.LinkedTreeMap$Node r2 = r0.a(r2, r1)     // Catch: java.lang.ClassCastException -> L16
                goto L17
            L16:
                r2 = r3
            L17:
                if (r2 == 0) goto L26
                java.lang.Object r4 = r2.f45330h
                java.lang.Object r6 = r6.getValue()
                boolean r6 = java.util.Objects.equals(r4, r6)
                if (r6 == 0) goto L26
                r3 = r2
            L26:
                if (r3 != 0) goto L29
            L28:
                return r1
            L29:
                r6 = 1
                r0.c(r3, r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.EntrySet.remove(java.lang.Object):boolean");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedTreeMap.this.f45312d;
        }
    }

    public final class KeySet extends AbstractSet<K> {

        /* renamed from: com.google.gson.internal.LinkedTreeMap$KeySet$1, reason: invalid class name */
        class AnonymousClass1 extends LinkedTreeMap<Object, Object>.LinkedTreeMapIterator<Object> {
            @Override // com.google.gson.internal.LinkedTreeMap.LinkedTreeMapIterator, java.util.Iterator
            public final Object next() {
                return a().f45328f;
            }
        }

        public KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new AnonymousClass1();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            Node nodeA = null;
            if (obj != null) {
                try {
                    nodeA = linkedTreeMap.a(obj, false);
                } catch (ClassCastException unused) {
                }
            }
            if (nodeA != null) {
                linkedTreeMap.c(nodeA, true);
            }
            return nodeA != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return LinkedTreeMap.this.f45312d;
        }
    }

    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public Node f45319a;

        /* renamed from: b, reason: collision with root package name */
        public Node f45320b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f45321c;

        public LinkedTreeMapIterator() {
            this.f45319a = LinkedTreeMap.this.f45314f.f45326d;
            this.f45321c = LinkedTreeMap.this.f45313e;
        }

        public final Node a() {
            Node node = this.f45319a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node == linkedTreeMap.f45314f) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.f45313e != this.f45321c) {
                throw new ConcurrentModificationException();
            }
            this.f45319a = node.f45326d;
            this.f45320b = node;
            return node;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f45319a != LinkedTreeMap.this.f45314f;
        }

        @Override // java.util.Iterator
        public Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node node = this.f45320b;
            if (node == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            linkedTreeMap.c(node, true);
            this.f45320b = null;
            this.f45321c = linkedTreeMap.f45313e;
        }
    }

    public LinkedTreeMap() {
        this(true);
    }

    public final Node a(Object obj, boolean z) {
        int iCompareTo;
        Node node;
        Node node2 = this.f45311c;
        Comparator comparator = f45308i;
        Comparator comparator2 = this.f45309a;
        if (node2 != null) {
            Comparable comparable = comparator2 == comparator ? (Comparable) obj : null;
            while (true) {
                Object obj2 = node2.f45328f;
                iCompareTo = comparable != null ? comparable.compareTo(obj2) : comparator2.compare(obj, obj2);
                if (iCompareTo == 0) {
                    return node2;
                }
                Node node3 = iCompareTo < 0 ? node2.f45324b : node2.f45325c;
                if (node3 == null) {
                    break;
                }
                node2 = node3;
            }
        } else {
            iCompareTo = 0;
        }
        Node node4 = node2;
        if (!z) {
            return null;
        }
        Node node5 = this.f45314f;
        if (node4 != null) {
            node = new Node(this.f45310b, node4, obj, node5, node5.f45327e);
            if (iCompareTo < 0) {
                node4.f45324b = node;
            } else {
                node4.f45325c = node;
            }
            b(node4, true);
        } else {
            if (comparator2 == comparator && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            node = new Node(this.f45310b, node4, obj, node5, node5.f45327e);
            this.f45311c = node;
        }
        this.f45312d++;
        this.f45313e++;
        return node;
    }

    public final void b(Node node, boolean z) {
        while (node != null) {
            Node node2 = node.f45324b;
            Node node3 = node.f45325c;
            int i2 = node2 != null ? node2.f45331i : 0;
            int i3 = node3 != null ? node3.f45331i : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                Node node4 = node3.f45324b;
                Node node5 = node3.f45325c;
                int i5 = (node4 != null ? node4.f45331i : 0) - (node5 != null ? node5.f45331i : 0);
                if (i5 == -1 || (i5 == 0 && !z)) {
                    e(node);
                } else {
                    f(node3);
                    e(node);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                Node node6 = node2.f45324b;
                Node node7 = node2.f45325c;
                int i6 = (node6 != null ? node6.f45331i : 0) - (node7 != null ? node7.f45331i : 0);
                if (i6 == 1 || (i6 == 0 && !z)) {
                    f(node);
                } else {
                    e(node2);
                    f(node);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                node.f45331i = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                node.f45331i = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            node = node.f45323a;
        }
    }

    public final void c(Node node, boolean z) {
        Node node2;
        Node node3;
        int i2;
        if (z) {
            Node node4 = node.f45327e;
            node4.f45326d = node.f45326d;
            node.f45326d.f45327e = node4;
        }
        Node node5 = node.f45324b;
        Node node6 = node.f45325c;
        Node node7 = node.f45323a;
        int i3 = 0;
        if (node5 == null || node6 == null) {
            if (node5 != null) {
                d(node, node5);
                node.f45324b = null;
            } else if (node6 != null) {
                d(node, node6);
                node.f45325c = null;
            } else {
                d(node, null);
            }
            b(node7, false);
            this.f45312d--;
            this.f45313e++;
            return;
        }
        if (node5.f45331i > node6.f45331i) {
            Node node8 = node5.f45325c;
            while (true) {
                Node node9 = node8;
                node3 = node5;
                node5 = node9;
                if (node5 == null) {
                    break;
                } else {
                    node8 = node5.f45325c;
                }
            }
        } else {
            Node node10 = node6.f45324b;
            while (true) {
                node2 = node6;
                node6 = node10;
                if (node6 == null) {
                    break;
                } else {
                    node10 = node6.f45324b;
                }
            }
            node3 = node2;
        }
        c(node3, false);
        Node node11 = node.f45324b;
        if (node11 != null) {
            i2 = node11.f45331i;
            node3.f45324b = node11;
            node11.f45323a = node3;
            node.f45324b = null;
        } else {
            i2 = 0;
        }
        Node node12 = node.f45325c;
        if (node12 != null) {
            i3 = node12.f45331i;
            node3.f45325c = node12;
            node12.f45323a = node3;
            node.f45325c = null;
        }
        node3.f45331i = Math.max(i2, i3) + 1;
        d(node, node3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f45311c = null;
        this.f45312d = 0;
        this.f45313e++;
        Node node = this.f45314f;
        node.f45327e = node;
        node.f45326d = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Node nodeA = null;
        if (obj != null) {
            try {
                nodeA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return nodeA != null;
    }

    public final void d(Node node, Node node2) {
        Node node3 = node.f45323a;
        node.f45323a = null;
        if (node2 != null) {
            node2.f45323a = node3;
        }
        if (node3 == null) {
            this.f45311c = node2;
        } else if (node3.f45324b == node) {
            node3.f45324b = node2;
        } else {
            node3.f45325c = node2;
        }
    }

    public final void e(Node node) {
        Node node2 = node.f45324b;
        Node node3 = node.f45325c;
        Node node4 = node3.f45324b;
        Node node5 = node3.f45325c;
        node.f45325c = node4;
        if (node4 != null) {
            node4.f45323a = node;
        }
        d(node, node3);
        node3.f45324b = node;
        node.f45323a = node3;
        int iMax = Math.max(node2 != null ? node2.f45331i : 0, node4 != null ? node4.f45331i : 0) + 1;
        node.f45331i = iMax;
        node3.f45331i = Math.max(iMax, node5 != null ? node5.f45331i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        EntrySet entrySet = this.f45315g;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet();
        this.f45315g = entrySet2;
        return entrySet2;
    }

    public final void f(Node node) {
        Node node2 = node.f45324b;
        Node node3 = node.f45325c;
        Node node4 = node2.f45324b;
        Node node5 = node2.f45325c;
        node.f45324b = node5;
        if (node5 != null) {
            node5.f45323a = node;
        }
        d(node, node2);
        node2.f45325c = node;
        node.f45323a = node2;
        int iMax = Math.max(node3 != null ? node3.f45331i : 0, node5 != null ? node5.f45331i : 0) + 1;
        node.f45331i = iMax;
        node2.f45331i = Math.max(iMax, node4 != null ? node4.f45331i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Node nodeA;
        if (obj != null) {
            try {
                nodeA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            nodeA = null;
        }
        if (nodeA != null) {
            return nodeA.f45330h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        KeySet keySet = this.f45316h;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.f45316h = keySet2;
        return keySet2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.f45310b) {
            throw new NullPointerException("value == null");
        }
        Node nodeA = a(obj, true);
        Object obj3 = nodeA.f45330h;
        nodeA.f45330h = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Node nodeA;
        if (obj != null) {
            try {
                nodeA = a(obj, false);
            } catch (ClassCastException unused) {
            }
        } else {
            nodeA = null;
        }
        if (nodeA != null) {
            c(nodeA, true);
        }
        if (nodeA != null) {
            return nodeA.f45330h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f45312d;
    }

    public LinkedTreeMap(boolean z) {
        Comparator comparator = f45308i;
        this.f45312d = 0;
        this.f45313e = 0;
        this.f45309a = comparator;
        this.f45310b = z;
        this.f45314f = new Node(z);
    }

    public static final class Node<K, V> implements Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public Node f45323a;

        /* renamed from: b, reason: collision with root package name */
        public Node f45324b;

        /* renamed from: c, reason: collision with root package name */
        public Node f45325c;

        /* renamed from: d, reason: collision with root package name */
        public Node f45326d;

        /* renamed from: e, reason: collision with root package name */
        public Node f45327e;

        /* renamed from: f, reason: collision with root package name */
        public final Object f45328f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f45329g;

        /* renamed from: h, reason: collision with root package name */
        public Object f45330h;

        /* renamed from: i, reason: collision with root package name */
        public int f45331i;

        public Node(boolean z) {
            this.f45328f = null;
            this.f45329g = z;
            this.f45327e = this;
            this.f45326d = this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = this.f45328f;
                if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                    Object obj3 = this.f45330h;
                    if (obj3 == null) {
                        if (entry.getValue() == null) {
                            return true;
                        }
                    } else if (obj3.equals(entry.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f45328f;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f45330h;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            Object obj = this.f45328f;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.f45330h;
            return (obj2 != null ? obj2.hashCode() : 0) ^ iHashCode;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (obj == null && !this.f45329g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f45330h;
            this.f45330h = obj;
            return obj2;
        }

        public final String toString() {
            return this.f45328f + "=" + this.f45330h;
        }

        public Node(boolean z, Node node, Object obj, Node node2, Node node3) {
            this.f45323a = node;
            this.f45328f = obj;
            this.f45329g = z;
            this.f45331i = 1;
            this.f45326d = node2;
            this.f45327e = node3;
            node3.f45326d = this;
            node2.f45327e = this;
        }
    }
}
