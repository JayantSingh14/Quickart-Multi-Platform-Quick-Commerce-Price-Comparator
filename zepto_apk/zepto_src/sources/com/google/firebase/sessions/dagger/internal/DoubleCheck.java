package com.google.firebase.sessions.dagger.internal;

import com.google.firebase.sessions.dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f45142c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Provider f45143a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f45144b = f45142c;

    public DoubleCheck(Provider provider) {
        this.f45143a = provider;
    }

    public static Provider a(Factory factory) {
        factory.getClass();
        return factory instanceof DoubleCheck ? factory : new DoubleCheck(factory);
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Object obj;
        Object obj2 = this.f45144b;
        Object obj3 = f45142c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f45144b;
                if (obj == obj3) {
                    obj = this.f45143a.get();
                    Object obj4 = this.f45144b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f45144b = obj;
                    this.f45143a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
