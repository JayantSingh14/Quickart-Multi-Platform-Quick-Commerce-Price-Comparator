package com.google.android.gms.internal.atv_ads_framework;

import java.util.ListIterator;

/* loaded from: classes4.dex */
final class zzfs implements ListIterator {

    /* renamed from: a, reason: collision with root package name */
    public final ListIterator f36206a;

    public zzfs(zzfu zzfuVar, int i2) {
        this.f36206a = zzfuVar.f36208a.listIterator(i2);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f36206a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f36206a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f36206a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f36206a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f36206a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f36206a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
