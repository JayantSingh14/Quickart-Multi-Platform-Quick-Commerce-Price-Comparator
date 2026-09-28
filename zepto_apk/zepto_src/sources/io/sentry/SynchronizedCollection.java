package io.sentry;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
class SynchronizedCollection<E> implements Collection<E>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractCollection f51942a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f51943b = this;

    public SynchronizedCollection(AbstractCollection abstractCollection) {
        this.f51942a = abstractCollection;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        boolean zAdd;
        synchronized (this.f51943b) {
            zAdd = b().add(obj);
        }
        return zAdd;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        boolean zAddAll;
        synchronized (this.f51943b) {
            zAddAll = b().addAll(collection);
        }
        return zAddAll;
    }

    public Collection b() {
        return this.f51942a;
    }

    @Override // java.util.Collection
    public final void clear() {
        synchronized (this.f51943b) {
            b().clear();
        }
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        boolean zContains;
        synchronized (this.f51943b) {
            zContains = b().contains(obj);
        }
        return zContains;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        boolean zContainsAll;
        synchronized (this.f51943b) {
            zContainsAll = b().containsAll(collection);
        }
        return zContainsAll;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        synchronized (this.f51943b) {
            boolean z = true;
            try {
                if (obj == this) {
                    return true;
                }
                if (obj != this && !b().equals(obj)) {
                    z = false;
                }
                return z;
            } finally {
            }
        }
    }

    @Override // java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.f51943b) {
            iHashCode = b().hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.f51943b) {
            zIsEmpty = b().isEmpty();
        }
        return zIsEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return b().iterator();
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this.f51943b) {
            zRemove = b().remove(obj);
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        boolean zRemoveAll;
        synchronized (this.f51943b) {
            zRemoveAll = b().removeAll(collection);
        }
        return zRemoveAll;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        boolean zRetainAll;
        synchronized (this.f51943b) {
            zRetainAll = b().retainAll(collection);
        }
        return zRetainAll;
    }

    @Override // java.util.Collection
    public final int size() {
        int size;
        synchronized (this.f51943b) {
            size = b().size();
        }
        return size;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] array;
        synchronized (this.f51943b) {
            array = b().toArray();
        }
        return array;
    }

    public final String toString() {
        String string;
        synchronized (this.f51943b) {
            string = b().toString();
        }
        return string;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.f51943b) {
            array = b().toArray(objArr);
        }
        return array;
    }
}
