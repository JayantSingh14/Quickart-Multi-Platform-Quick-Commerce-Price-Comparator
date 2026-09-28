package com.google.android.gms.internal.pal;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzit extends zzjm {

    /* renamed from: a, reason: collision with root package name */
    public final int f37814a;

    /* renamed from: b, reason: collision with root package name */
    public int f37815b;

    public zzit(int i2, int i3) {
        zzip.b(i3, i2);
        this.f37814a = i2;
        this.f37815b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f37815b < this.f37814a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f37815b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f37815b;
        this.f37815b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f37815b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f37815b - 1;
        this.f37815b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f37815b - 1;
    }
}
