package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes.dex */
public class Lazy<T> implements Provider<T> {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f43594c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f43595a = f43594c;

    /* renamed from: b, reason: collision with root package name */
    public volatile Provider f43596b;

    public Lazy(Provider provider) {
        this.f43596b = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        Object obj;
        Object obj2 = this.f43595a;
        Object obj3 = f43594c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f43595a;
                if (obj == obj3) {
                    obj = this.f43596b.get();
                    this.f43595a = obj;
                    this.f43596b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
