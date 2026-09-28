package com.google.android.gms.internal.atv_ads_framework;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzay extends zzbv {

    /* renamed from: a, reason: collision with root package name */
    public final int f36037a;

    /* renamed from: b, reason: collision with root package name */
    public int f36038b;

    public zzay(int i2, int i3) {
        zzaq.b(i3, i2);
        this.f36037a = i2;
        this.f36038b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f36038b < this.f36037a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f36038b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36038b;
        this.f36038b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f36038b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36038b - 1;
        this.f36038b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f36038b - 1;
    }
}
