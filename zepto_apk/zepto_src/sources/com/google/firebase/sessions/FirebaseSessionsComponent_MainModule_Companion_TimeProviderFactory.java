package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory implements Factory<TimeProvider> {

    public static final class InstanceHolder {

        /* renamed from: a, reason: collision with root package name */
        public static final FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory f45005a = new FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory();
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return TimeProviderImpl.f45123a;
    }
}
