package androidx.databinding;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public class ObservableArrayList<T> extends ArrayList<T> implements ObservableList<T> {

    /* renamed from: a, reason: collision with root package name */
    public final transient ListChangeRegistry f3365a = new ListChangeRegistry();

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        super.add(obj);
        b(size() - 1, 1);
        return true;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        int size = size();
        boolean zAddAll = super.addAll(collection);
        if (zAddAll) {
            b(size, size() - size);
        }
        return zAddAll;
    }

    public final void b(int i2, int i3) {
        ListChangeRegistry listChangeRegistry = this.f3365a;
        if (listChangeRegistry != null) {
            listChangeRegistry.f(this, 2, ListChangeRegistry.e(i2, i3));
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        ListChangeRegistry listChangeRegistry;
        int size = size();
        super.clear();
        if (size == 0 || (listChangeRegistry = this.f3365a) == null) {
            return;
        }
        listChangeRegistry.f(this, 4, ListChangeRegistry.e(0, size));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final Object remove(int i2) {
        Object objRemove = super.remove(i2);
        ListChangeRegistry listChangeRegistry = this.f3365a;
        if (listChangeRegistry != null) {
            listChangeRegistry.f(this, 4, ListChangeRegistry.e(i2, 1));
        }
        return objRemove;
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        super.removeRange(i2, i3);
        int i4 = i3 - i2;
        ListChangeRegistry listChangeRegistry = this.f3365a;
        if (listChangeRegistry != null) {
            listChangeRegistry.f(this, 4, ListChangeRegistry.e(i2, i4));
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        Object obj2 = super.set(i2, obj);
        ListChangeRegistry listChangeRegistry = this.f3365a;
        if (listChangeRegistry != null) {
            listChangeRegistry.f(this, 1, ListChangeRegistry.e(i2, 1));
        }
        return obj2;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        super.add(i2, obj);
        b(i2, 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection collection) {
        boolean zAddAll = super.addAll(i2, collection);
        if (zAddAll) {
            b(i2, collection.size());
        }
        return zAddAll;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }
}
