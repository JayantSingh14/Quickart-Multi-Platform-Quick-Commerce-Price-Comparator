package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class SessionGenerator_Factory implements Factory<SessionGenerator> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider f45092a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f45093b;

    public SessionGenerator_Factory(Provider provider, Provider provider2) {
        this.f45092a = provider;
        this.f45093b = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new SessionGenerator((TimeProvider) this.f45092a.get(), (UuidGenerator) this.f45093b.get());
    }
}
