package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class SessionsSettings_Factory implements Factory<SessionsSettings> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider f45190a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f45191b;

    public SessionsSettings_Factory(Provider provider, Provider provider2) {
        this.f45190a = provider;
        this.f45191b = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new SessionsSettings((SettingsProvider) this.f45190a.get(), (SettingsProvider) this.f45191b.get());
    }
}
