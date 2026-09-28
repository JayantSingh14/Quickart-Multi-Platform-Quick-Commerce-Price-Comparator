package io.sentry.cache.tape;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class EmptyObjectQueue<T> extends ObjectQueue<T> {

    public static final class EmptyIterator<T> implements Iterator<T> {
        @Override // java.util.Iterator
        public final boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            throw new NoSuchElementException("No elements in EmptyIterator!");
        }
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public final void A(int i2) {
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public final void b(Object obj) {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new EmptyIterator();
    }

    @Override // io.sentry.cache.tape.ObjectQueue
    public final int size() {
        return 0;
    }
}
