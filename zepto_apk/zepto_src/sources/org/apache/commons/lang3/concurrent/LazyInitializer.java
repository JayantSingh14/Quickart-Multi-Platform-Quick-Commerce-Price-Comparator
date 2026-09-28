package org.apache.commons.lang3.concurrent;

/* loaded from: classes5.dex */
public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {
    private static final Object NO_INIT = new Object();
    private volatile T object = (T) NO_INIT;

    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        T tInitialize;
        T t = this.object;
        Object obj = NO_INIT;
        if (t != obj) {
            return t;
        }
        synchronized (this) {
            try {
                tInitialize = this.object;
                if (tInitialize == obj) {
                    tInitialize = initialize();
                    this.object = tInitialize;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tInitialize;
    }

    public abstract T initialize() throws ConcurrentException;
}
