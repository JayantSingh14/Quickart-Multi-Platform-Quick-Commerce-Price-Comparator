package com.google.firebase.inject;

/* loaded from: classes.dex */
public interface Deferred<T> {

    public interface DeferredHandler<T> {
        void f(Provider provider);
    }

    void a(DeferredHandler deferredHandler);
}
