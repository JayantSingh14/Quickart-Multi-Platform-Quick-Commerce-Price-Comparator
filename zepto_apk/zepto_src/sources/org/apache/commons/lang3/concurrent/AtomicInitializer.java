package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T t = this.reference.get();
        if (t != null) {
            return t;
        }
        T tInitialize = initialize();
        AtomicReference<T> atomicReference = this.reference;
        while (!atomicReference.compareAndSet(null, tInitialize)) {
            if (atomicReference.get() != null) {
                return this.reference.get();
            }
        }
        return tInitialize;
    }

    public abstract T initialize() throws ConcurrentException;
}
