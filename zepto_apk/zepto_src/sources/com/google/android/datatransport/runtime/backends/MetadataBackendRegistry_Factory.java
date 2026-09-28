package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.DaggerGenerated;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.QualifierMetadata;
import com.google.android.datatransport.runtime.dagger.internal.ScopeMetadata;

@QualifierMetadata
@ScopeMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f20795a;

    /* renamed from: b, reason: collision with root package name */
    public final CreationContextFactory_Factory f20796b;

    public MetadataBackendRegistry_Factory(InstanceFactory instanceFactory, CreationContextFactory_Factory creationContextFactory_Factory) {
        this.f20795a = instanceFactory;
        this.f20796b = creationContextFactory_Factory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new MetadataBackendRegistry((Context) this.f20795a.f20800a, (CreationContextFactory) this.f20796b.get());
    }
}
