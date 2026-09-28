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
public final class SchemaManager_Factory implements Factory<SchemaManager> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f20955a;

    /* renamed from: b, reason: collision with root package name */
    public final EventStoreModule_DbNameFactory f20956b;

    /* renamed from: c, reason: collision with root package name */
    public final EventStoreModule_SchemaVersionFactory f20957c;

    public SchemaManager_Factory(InstanceFactory instanceFactory, EventStoreModule_DbNameFactory eventStoreModule_DbNameFactory, EventStoreModule_SchemaVersionFactory eventStoreModule_SchemaVersionFactory) {
        this.f20955a = instanceFactory;
        this.f20956b = eventStoreModule_DbNameFactory;
        this.f20957c = eventStoreModule_SchemaVersionFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        Context context = (Context) this.f20955a.f20800a;
        this.f20956b.getClass();
        this.f20957c.getClass();
        return new SchemaManager(context, Integer.valueOf(SchemaManager.f20951d).intValue(), "com.google.android.datatransport.events");
    }
}
