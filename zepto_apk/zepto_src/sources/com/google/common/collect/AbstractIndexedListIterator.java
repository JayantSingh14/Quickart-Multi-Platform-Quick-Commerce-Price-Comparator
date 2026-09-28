package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {

    /* renamed from: a, reason: collision with root package name */
    public final int f42454a;

    /* renamed from: b, reason: collision with root package name */
    public int f42455b;

    public AbstractIndexedListIterator(int i2, int i3) {
        Preconditions.k(i3, i2);
        this.f42454a = i2;
        this.f42455b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f42455b < this.f42454a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f42455b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f42455b;
        this.f42455b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f42455b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f42455b - 1;
        this.f42455b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f42455b - 1;
    }
}
