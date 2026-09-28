package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
class OptionalProvider<T> implements Provider<T>, Deferred<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.work.impl.model.a f43599c = new androidx.work.impl.model.a(8);

    /* renamed from: d, reason: collision with root package name */
    public static final b f43600d = new b(1);

    /* renamed from: a, reason: collision with root package name */
    public Deferred.DeferredHandler f43601a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Provider f43602b;

    public OptionalProvider(androidx.work.impl.model.a aVar, Provider provider) {
        this.f43601a = aVar;
        this.f43602b = provider;
    }

    @Override // com.google.firebase.inject.Deferred
    public final void a(final Deferred.DeferredHandler deferredHandler) {
        Provider provider;
        Provider provider2;
        Provider provider3 = this.f43602b;
        b bVar = f43600d;
        if (provider3 != bVar) {
            deferredHandler.f(provider3);
            return;
        }
        synchronized (this) {
            provider = this.f43602b;
            if (provider != bVar) {
                provider2 = provider;
            } else {
                final Deferred.DeferredHandler deferredHandler2 = this.f43601a;
                this.f43601a = new Deferred.DeferredHandler() { // from class: com.google.firebase.components.e
                    @Override // com.google.firebase.inject.Deferred.DeferredHandler
                    public final void f(Provider provider4) {
                        deferredHandler2.f(provider4);
                        deferredHandler.f(provider4);
                    }
                };
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.f(provider);
        }
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.f43602b.get();
    }
}
