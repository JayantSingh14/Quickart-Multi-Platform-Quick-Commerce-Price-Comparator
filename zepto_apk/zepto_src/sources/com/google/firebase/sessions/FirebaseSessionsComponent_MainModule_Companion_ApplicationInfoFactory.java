package com.google.firebase.sessions;

import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import kotlin.jvm.internal.Intrinsics;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory implements Factory<ApplicationInfo> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f45002a;

    public FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(InstanceFactory instanceFactory) {
        this.f45002a = instanceFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        FirebaseApp firebaseApp = (FirebaseApp) this.f45002a.f45145a;
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        SessionEvents sessionEvents = SessionEvents.f45060a;
        return SessionEvents.a(firebaseApp);
    }
}
