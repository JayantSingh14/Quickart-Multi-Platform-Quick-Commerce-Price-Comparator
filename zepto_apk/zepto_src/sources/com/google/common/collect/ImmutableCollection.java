package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@GwtCompatible
@DoNotMock
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final Object[] f42656a = new Object[0];

    public static abstract class ArrayBasedBuilder<E> extends Builder<E> {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f42657a;

        /* renamed from: b, reason: collision with root package name */
        public int f42658b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f42659c;

        public ArrayBasedBuilder(int i2) {
            CollectPreconditions.b(i2, "initialCapacity");
            this.f42657a = new Object[i2];
            this.f42658b = 0;
        }

        @Override // 
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArrayBasedBuilder c(Object obj) {
            obj.getClass();
            g(this.f42658b + 1);
            Object[] objArr = this.f42657a;
            int i2 = this.f42658b;
            this.f42658b = i2 + 1;
            objArr[i2] = obj;
            return this;
        }

        public final void d(int i2, Object[] objArr) {
            ObjectArrays.a(i2, objArr);
            g(this.f42658b + i2);
            System.arraycopy(objArr, 0, this.f42657a, this.f42658b, i2);
            this.f42658b += i2;
        }

        public final void e(Iterable iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                g(collection.size() + this.f42658b);
                if (collection instanceof ImmutableCollection) {
                    this.f42658b = ((ImmutableCollection) collection).d(this.f42658b, this.f42657a);
                    return;
                }
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
        }

        public void f(List list) {
            e(list);
        }

        public final void g(int i2) {
            Object[] objArr = this.f42657a;
            if (objArr.length < i2) {
                this.f42657a = Arrays.copyOf(objArr, Builder.a(objArr.length, i2));
                this.f42659c = false;
            } else if (this.f42659c) {
                this.f42657a = (Object[]) objArr.clone();
                this.f42659c = false;
            }
        }
    }

    @DoNotMock
    public static abstract class Builder<E> {
        public static int a(int i2, int i3) {
            if (i3 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i2 + (i2 >> 1) + 1;
            if (iHighestOneBit < i3) {
                iHighestOneBit = Integer.highestOneBit(i3 - 1) << 1;
            }
            return iHighestOneBit < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iHighestOneBit;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList b() {
        if (isEmpty()) {
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            return RegularImmutableList.f43010e;
        }
        Object[] array = toArray(f42656a);
        UnmodifiableListIterator unmodifiableListIterator2 = ImmutableList.f42665b;
        return ImmutableList.m(array.length, array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    public int d(int i2, Object[] objArr) {
        UnmodifiableIterator it = iterator();
        while (it.hasNext()) {
            objArr[i2] = it.next();
            i2++;
        }
        return i2;
    }

    public Object[] f() {
        return null;
    }

    public int g() {
        throw new UnsupportedOperationException();
    }

    public int i() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean j();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public abstract UnmodifiableIterator iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f42656a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int size = size();
        if (objArr.length < size) {
            Object[] objArrF = f();
            if (objArrF != null) {
                return Platform.a(objArrF, i(), g(), objArr);
            }
            objArr = Platform.b(size, objArr);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        d(0, objArr);
        return objArr;
    }
}
