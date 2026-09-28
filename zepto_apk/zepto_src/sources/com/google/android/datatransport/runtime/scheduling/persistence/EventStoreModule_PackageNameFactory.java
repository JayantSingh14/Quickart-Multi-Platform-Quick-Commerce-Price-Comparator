package com.google.android.datatransport.runtime.scheduling.persistence;

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
public final class EventStoreModule_PackageNameFactory implements Factory<String> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f20934a;

    public EventStoreModule_PackageNameFactory(InstanceFactory instanceFactory) {
        this.f20934a = instanceFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        String packageName = ((Context) this.f20934a.f20800a).getPackageName();
        if (packageName != null) {
            return packageName;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
