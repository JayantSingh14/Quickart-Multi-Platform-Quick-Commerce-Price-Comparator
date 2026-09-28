package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class SessionLifecycleServiceBinderImpl_Factory implements Factory<SessionLifecycleServiceBinderImpl> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f45119a;

    public SessionLifecycleServiceBinderImpl_Factory(InstanceFactory instanceFactory) {
        this.f45119a = instanceFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new SessionLifecycleServiceBinderImpl((Context) this.f45119a.f45145a);
    }
}
