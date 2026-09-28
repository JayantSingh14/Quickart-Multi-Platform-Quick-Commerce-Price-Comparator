package com.google.android.gms.internal.location;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzdo extends zzdv {

    /* renamed from: a, reason: collision with root package name */
    public final int f36694a;

    /* renamed from: b, reason: collision with root package name */
    public int f36695b;

    public zzdo(int i2, int i3) {
        if (i3 < 0 || i3 > i2) {
            throw new IndexOutOfBoundsException(zzdm.c(i3, i2, "index"));
        }
        this.f36694a = i2;
        this.f36695b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f36695b < this.f36694a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f36695b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36695b;
        this.f36695b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f36695b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36695b - 1;
        this.f36695b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f36695b - 1;
    }
}
