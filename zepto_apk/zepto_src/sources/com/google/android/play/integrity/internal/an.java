package com.google.android.play.integrity.internal;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class an extends aw {

    /* renamed from: a, reason: collision with root package name */
    public final int f42170a;

    /* renamed from: b, reason: collision with root package name */
    public int f42171b;

    public an(int i2, int i3) {
        if (i3 < 0 || i3 > i2) {
            throw new IndexOutOfBoundsException(al.c(i3, i2, "index"));
        }
        this.f42170a = i2;
        this.f42171b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f42171b < this.f42170a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f42171b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f42171b;
        this.f42171b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f42171b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f42171b - 1;
        this.f42171b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f42171b - 1;
    }
}
