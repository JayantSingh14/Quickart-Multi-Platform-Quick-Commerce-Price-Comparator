package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    /* renamed from: a, reason: collision with root package name */
    public Object f42517a;

    public AbstractSequentialIterator(Object obj) {
        this.f42517a = obj;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f42517a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        Object obj = this.f42517a;
        if (obj == null) {
            throw new NoSuchElementException();
        }
        this.f42517a = a(obj);
        return obj;
    }
}
