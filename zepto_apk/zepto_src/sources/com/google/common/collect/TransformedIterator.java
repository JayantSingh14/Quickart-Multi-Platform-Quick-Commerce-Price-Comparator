package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class TransformedIterator<F, T> implements Iterator<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f43133a;

    public TransformedIterator(Iterator it) {
        it.getClass();
        this.f43133a = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f43133a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f43133a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f43133a.remove();
    }
}
