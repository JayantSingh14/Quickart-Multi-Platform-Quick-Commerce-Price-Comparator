package com.google.firebase.sessions;

import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory implements Factory<UuidGenerator> {

    public static final class InstanceHolder {

        /* renamed from: a, reason: collision with root package name */
        public static final FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory f45006a = new FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory();
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return UuidGeneratorImpl.f45124a;
    }
}
