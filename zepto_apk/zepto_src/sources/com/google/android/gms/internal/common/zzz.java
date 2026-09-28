package com.google.android.gms.internal.common;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzz extends zzal {

    /* renamed from: a, reason: collision with root package name */
    public final int f36510a;

    /* renamed from: b, reason: collision with root package name */
    public int f36511b;

    public zzz(int i2, int i3) {
        zzr.b(i3, i2);
        this.f36510a = i2;
        this.f36511b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f36511b < this.f36510a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f36511b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36511b;
        this.f36511b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f36511b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36511b - 1;
        this.f36511b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f36511b - 1;
    }
}
