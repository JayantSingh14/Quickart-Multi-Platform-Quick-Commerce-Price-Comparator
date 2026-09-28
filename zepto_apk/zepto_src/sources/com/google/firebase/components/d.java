package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f43619a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Provider f43620b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Provider f43621c;

    public /* synthetic */ d(Provider provider, Provider provider2, int i2) {
        this.f43619a = i2;
        this.f43621c = provider;
        this.f43620b = provider2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Deferred.DeferredHandler deferredHandler;
        switch (this.f43619a) {
            case 0:
                OptionalProvider optionalProvider = (OptionalProvider) this.f43621c;
                Provider provider = this.f43620b;
                if (optionalProvider.f43602b != OptionalProvider.f43600d) {
                    throw new IllegalStateException("provide() can be called only once.");
                }
                synchronized (optionalProvider) {
                    deferredHandler = optionalProvider.f43601a;
                    optionalProvider.f43601a = null;
                    optionalProvider.f43602b = provider;
                }
                deferredHandler.f(provider);
                return;
            default:
                LazySet lazySet = (LazySet) this.f43621c;
                Provider provider2 = this.f43620b;
                synchronized (lazySet) {
                    try {
                        if (lazySet.f43598b == null) {
                            lazySet.f43597a.add(provider2);
                        } else {
                            lazySet.f43598b.add(provider2.get());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }
}
