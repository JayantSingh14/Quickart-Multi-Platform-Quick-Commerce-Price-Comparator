package com.google.android.gms.internal.consent_sdk;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzcz extends zzdl {

    /* renamed from: a, reason: collision with root package name */
    public final int f36543a;

    /* renamed from: b, reason: collision with root package name */
    public int f36544b;

    public zzcz(int i2, int i3) {
        if (i3 < 0 || i3 > i2) {
            throw new IndexOutOfBoundsException(zzcx.c(i3, i2, "index"));
        }
        this.f36543a = i2;
        this.f36544b = i3;
    }

    public abstract Object a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f36544b < this.f36543a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f36544b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36544b;
        this.f36544b = i2 + 1;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f36544b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f36544b - 1;
        this.f36544b = i2;
        return a(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f36544b - 1;
    }
}
