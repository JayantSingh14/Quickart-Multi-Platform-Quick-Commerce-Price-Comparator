package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes4.dex */
abstract class zzgvp implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f33261a;

    public zzgvp(Iterator it) {
        it.getClass();
        this.f33261a = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33261a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f33261a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f33261a.remove();
    }
}
