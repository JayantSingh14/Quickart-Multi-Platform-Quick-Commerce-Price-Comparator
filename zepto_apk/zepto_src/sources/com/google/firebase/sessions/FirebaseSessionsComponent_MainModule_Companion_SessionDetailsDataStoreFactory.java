package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import java.io.File;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory implements Factory<DataStore<Preferences>> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f45004a;

    public FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(InstanceFactory instanceFactory) {
        this.f45004a = instanceFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        final Context appContext = (Context) this.f45004a.f45145a;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return PreferenceDataStoreFactory.b(new ReplaceFileCorruptionHandler(FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$1.f45000c), new Function0<File>() { // from class: com.google.firebase.sessions.FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PreferenceDataStoreFile.a(appContext, SessionDataStoreConfigs.f45027a);
            }
        });
    }
}
