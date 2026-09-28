package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class SessionFirelogPublisherImpl_Factory implements Factory<SessionFirelogPublisherImpl> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f45082a;

    /* renamed from: b, reason: collision with root package name */
    public final InstanceFactory f45083b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider f45084c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider f45085d;

    /* renamed from: e, reason: collision with root package name */
    public final InstanceFactory f45086e;

    public SessionFirelogPublisherImpl_Factory(InstanceFactory instanceFactory, InstanceFactory instanceFactory2, Provider provider, Provider provider2, InstanceFactory instanceFactory3) {
        this.f45082a = instanceFactory;
        this.f45083b = instanceFactory2;
        this.f45084c = provider;
        this.f45085d = provider2;
        this.f45086e = instanceFactory3;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new SessionFirelogPublisherImpl((FirebaseApp) this.f45082a.f45145a, (FirebaseInstallationsApi) this.f45083b.f45145a, (SessionsSettings) this.f45084c.get(), (EventGDTLoggerInterface) this.f45085d.get(), (CoroutineContext) this.f45086e.f45145a);
    }
}
