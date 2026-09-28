package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class SettingsCache_Factory implements Factory<SettingsCache> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider f45214a;

    public SettingsCache_Factory(Provider provider) {
        this.f45214a = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new SettingsCache((DataStore) this.f45214a.get());
    }
}
