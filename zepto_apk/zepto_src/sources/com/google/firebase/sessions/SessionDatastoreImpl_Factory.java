package com.google.firebase.sessions;

import androidx.datastore.core.DataStore;
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
public final class SessionDatastoreImpl_Factory implements Factory<SessionDatastoreImpl> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f45052a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f45053b;

    public SessionDatastoreImpl_Factory(InstanceFactory instanceFactory, Provider provider) {
        this.f45052a = instanceFactory;
        this.f45053b = provider;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new SessionDatastoreImpl((CoroutineContext) this.f45052a.f45145a, (DataStore) this.f45053b.get());
    }
}
