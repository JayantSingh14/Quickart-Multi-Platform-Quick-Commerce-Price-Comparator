package ch.qos.logback.core.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class COWArrayList<E> implements List<E> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f13796a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f13797b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    public Object[] f13798c;

    /* renamed from: d, reason: collision with root package name */
    public final Object[] f13799d;

    public COWArrayList(Object[] objArr) {
        this.f13799d = objArr;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        boolean zAdd = this.f13797b.add(obj);
        b();
        return zAdd;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        boolean zAddAll = this.f13797b.addAll(collection);
        b();
        return zAddAll;
    }

    public final void b() {
        this.f13796a.set(false);
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f13797b.clear();
        b();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f13797b.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return this.f13797b.containsAll(collection);
    }

    public final void d() {
        AtomicBoolean atomicBoolean = this.f13796a;
        if (atomicBoolean.get()) {
            return;
        }
        this.f13798c = this.f13797b.toArray(this.f13799d);
        atomicBoolean.set(true);
    }

    @Override // java.util.List
    public final Object get(int i2) {
        d();
        return this.f13798c[i2];
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f13797b.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return this.f13797b.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f13797b.iterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f13797b.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return this.f13797b.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        boolean zRemove = this.f13797b.remove(obj);
        b();
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        boolean zRemoveAll = this.f13797b.removeAll(collection);
        b();
        return zRemoveAll;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        boolean zRetainAll = this.f13797b.retainAll(collection);
        b();
        return zRetainAll;
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        Object obj2 = this.f13797b.set(i2, obj);
        b();
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f13797b.size();
    }

    @Override // java.util.List
    public final List subList(int i2, int i3) {
        return this.f13797b.subList(i2, i3);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        d();
        return this.f13798c;
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        return this.f13797b.listIterator(i2);
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        this.f13797b.add(i2, obj);
        b();
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        boolean zAddAll = this.f13797b.addAll(i2, collection);
        b();
        return zAddAll;
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        Object objRemove = this.f13797b.remove(i2);
        b();
        return objRemove;
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        d();
        return this.f13798c;
    }
}
