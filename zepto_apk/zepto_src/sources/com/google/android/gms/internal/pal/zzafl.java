package com.google.android.gms.internal.pal;

import java.util.ListIterator;

/* loaded from: classes4.dex */
final class zzafl implements ListIterator {

    /* renamed from: a, reason: collision with root package name */
    public final ListIterator f37494a;

    public zzafl(zzafn zzafnVar, int i2) {
        this.f37494a = zzafnVar.f37496a.listIterator(i2);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f37494a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f37494a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f37494a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f37494a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object previous() {
        return (String) this.f37494a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f37494a.previousIndex();
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
