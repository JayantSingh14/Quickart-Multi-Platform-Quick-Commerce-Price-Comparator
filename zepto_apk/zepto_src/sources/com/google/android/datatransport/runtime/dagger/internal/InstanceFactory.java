package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

/* loaded from: classes.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Object f20800a;

    public InstanceFactory(Object obj) {
        this.f20800a = obj;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return this.f20800a;
    }
}
