package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
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
public final class FirebaseSessions_Factory implements Factory<FirebaseSessions> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f45009a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f45010b;

    /* renamed from: c, reason: collision with root package name */
    public final InstanceFactory f45011c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider f45012d;

    public FirebaseSessions_Factory(InstanceFactory instanceFactory, Provider provider, InstanceFactory instanceFactory2, Provider provider2) {
        this.f45009a = instanceFactory;
        this.f45010b = provider;
        this.f45011c = instanceFactory2;
        this.f45012d = provider2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new FirebaseSessions((FirebaseApp) this.f45009a.f45145a, (SessionsSettings) this.f45010b.get(), (CoroutineContext) this.f45011c.f45145a, (SessionLifecycleServiceBinder) this.f45012d.get());
    }
}
