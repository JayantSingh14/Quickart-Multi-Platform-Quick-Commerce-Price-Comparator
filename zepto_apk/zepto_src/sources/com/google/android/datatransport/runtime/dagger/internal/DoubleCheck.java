package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f20797c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Factory f20798a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f20799b;

    public static Provider a(Factory factory) {
        factory.getClass();
        if (factory instanceof DoubleCheck) {
            return factory;
        }
        DoubleCheck doubleCheck = new DoubleCheck();
        doubleCheck.f20799b = f20797c;
        doubleCheck.f20798a = factory;
        return doubleCheck;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Object obj;
        Object obj2 = this.f20799b;
        Object obj3 = f20797c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f20799b;
                if (obj == obj3) {
                    obj = this.f20798a.get();
                    Object obj4 = this.f20799b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f20799b = obj;
                    this.f20798a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
