package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzgra extends zzgvs {

    /* renamed from: a, reason: collision with root package name */
    public final int f33094a;

    /* renamed from: b, reason: collision with root package name */
    public int f33095b;

    public zzgra(int i2, int i3) {
        zzgqa.j(i3, i2);
        this.f33094a = i2;
        this.f33095b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f33095b < this.f33094a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f33095b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f33095b;
        this.f33095b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f33095b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f33095b - 1;
        this.f33095b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f33095b - 1;
    }
}
