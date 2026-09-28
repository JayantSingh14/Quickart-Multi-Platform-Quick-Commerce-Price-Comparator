package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzao extends zzba {

    /* renamed from: a, reason: collision with root package name */
    public final int f36577a;

    /* renamed from: b, reason: collision with root package name */
    public int f36578b;

    public zzao(int i2, int i3) {
        if (i3 < 0 || i3 > i2) {
            throw new IndexOutOfBoundsException(zzam.c(i3, i2, "index"));
        }
        this.f36577a = i2;
        this.f36578b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f36578b < this.f36577a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f36578b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36578b;
        this.f36578b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f36578b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36578b - 1;
        this.f36578b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f36578b - 1;
    }
}
