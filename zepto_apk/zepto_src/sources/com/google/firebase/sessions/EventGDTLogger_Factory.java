package com.google.firebase.sessions;

import com.google.firebase.inject.Provider;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class EventGDTLogger_Factory implements Factory<EventGDTLogger> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f44988a;

    public EventGDTLogger_Factory(InstanceFactory instanceFactory) {
        this.f44988a = instanceFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new EventGDTLogger((Provider) this.f44988a.f45145a);
    }
}
