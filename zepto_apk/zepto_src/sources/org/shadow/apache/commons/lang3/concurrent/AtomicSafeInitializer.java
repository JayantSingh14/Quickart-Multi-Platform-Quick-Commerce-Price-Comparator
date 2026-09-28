package org.shadow.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {
    public AtomicSafeInitializer() {
        new AtomicReference();
        new AtomicReference();
    }
}
