package org.shadow.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    public AtomicInitializer() {
        new AtomicReference();
    }
}
