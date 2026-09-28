package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    public boolean add(Object obj) {
        return t().add(obj);
    }

    public boolean addAll(Collection collection) {
        return t().addAll(collection);
    }

    public void clear() {
        t().clear();
    }

    public boolean contains(Object obj) {
        return t().contains(obj);
    }

    public boolean containsAll(Collection collection) {
        return t().containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return t().isEmpty();
    }

    public Iterator iterator() {
        return t().iterator();
    }

    public boolean remove(Object obj) {
        return t().remove(obj);
    }

    public boolean removeAll(Collection collection) {
        return t().removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return t().retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return t().size();
    }

    public Object[] toArray() {
        return t().toArray();
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public abstract Collection t();

    public final Object[] y() {
        return toArray(new Object[size()]);
    }

    public final String z() {
        int size = size();
        CollectPreconditions.b(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('[');
        boolean z = true;
        for (E e2 : this) {
            if (!z) {
                sb.append(", ");
            }
            if (e2 == this) {
                sb.append("(this Collection)");
            } else {
                sb.append(e2);
            }
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public Object[] toArray(Object[] objArr) {
        return t().toArray(objArr);
    }
}
