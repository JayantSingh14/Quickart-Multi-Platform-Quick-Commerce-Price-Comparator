package com.google.firebase.sessions.settings;

import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class RemoteSettingsFetcher_Factory implements Factory<RemoteSettingsFetcher> {

    /* renamed from: a, reason: collision with root package name */
    public final Provider f45172a;

    /* renamed from: b, reason: collision with root package name */
    public final InstanceFactory f45173b;

    public RemoteSettingsFetcher_Factory(InstanceFactory instanceFactory, Provider provider) {
        this.f45172a = provider;
        this.f45173b = instanceFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new RemoteSettingsFetcher((ApplicationInfo) this.f45172a.get(), (CoroutineContext) this.f45173b.f45145a);
    }
}
