package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate;
import androidx.datastore.preferences.core.Preferences;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.sessions.DaggerFirebaseSessionsComponent;
import com.google.firebase.sessions.FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory;
import com.google.firebase.sessions.FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.settings.LocalOverrideSettings_Factory;
import com.google.firebase.sessions.settings.RemoteSettingsFetcher_Factory;
import com.google.firebase.sessions.settings.RemoteSettings_Factory;
import com.google.firebase.sessions.settings.SessionsSettings_Factory;
import com.google.firebase.sessions.settings.SettingsCache_Factory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata
/* loaded from: classes.dex */
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {

    @NotNull
    private static final Companion Companion = new Companion();

    @Deprecated
    @NotNull
    public static final String LIBRARY_NAME = "fire-sessions";

    @Deprecated
    @NotNull
    public static final String TAG = "FirebaseSessions";

    @NotNull
    private static final Qualified<Context> appContext;

    @NotNull
    private static final Qualified<CoroutineDispatcher> backgroundDispatcher;

    @NotNull
    private static final Qualified<CoroutineDispatcher> blockingDispatcher;

    @NotNull
    private static final Qualified<FirebaseApp> firebaseApp;

    @NotNull
    private static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi;

    @NotNull
    private static final Qualified<FirebaseSessionsComponent> firebaseSessionsComponent;

    @NotNull
    private static final Qualified<TransportFactory> transportFactory;

    @Metadata
    public static final class Companion {

        @Metadata
        /* renamed from: com.google.firebase.sessions.FirebaseSessionsRegistrar$Companion$1, reason: invalid class name */
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function4<String, ReplaceFileCorruptionHandler<Preferences>, Function1<? super Context, ? extends List<? extends DataMigration<Preferences>>>, CoroutineScope, ReadOnlyProperty<? super Context, ? extends DataStore<Preferences>>> {

            /* renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int f45008b = 0;

            @Override // kotlin.jvm.functions.Function4
            public final Object d(Object obj, Object obj2, Object obj3, Object obj4) {
                String name = (String) obj;
                Function1 produceMigrations = (Function1) obj3;
                CoroutineScope scope = (CoroutineScope) obj4;
                Intrinsics.checkNotNullParameter(name, "p0");
                Intrinsics.checkNotNullParameter(produceMigrations, "p2");
                Intrinsics.checkNotNullParameter(scope, "p3");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(produceMigrations, "produceMigrations");
                Intrinsics.checkNotNullParameter(scope, "scope");
                return new PreferenceDataStoreSingletonDelegate(name, (ReplaceFileCorruptionHandler) obj2, produceMigrations, scope);
            }
        }
    }

    static {
        Qualified<Context> qualifiedA = Qualified.a(Context.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedA, "unqualified(Context::class.java)");
        appContext = qualifiedA;
        Qualified<FirebaseApp> qualifiedA2 = Qualified.a(FirebaseApp.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedA2, "unqualified(FirebaseApp::class.java)");
        firebaseApp = qualifiedA2;
        Qualified<FirebaseInstallationsApi> qualifiedA3 = Qualified.a(FirebaseInstallationsApi.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedA3, "unqualified(FirebaseInstallationsApi::class.java)");
        firebaseInstallationsApi = qualifiedA3;
        Qualified<CoroutineDispatcher> qualified = new Qualified<>(Background.class, CoroutineDispatcher.class);
        Intrinsics.checkNotNullExpressionValue(qualified, "qualified(Background::cl…neDispatcher::class.java)");
        backgroundDispatcher = qualified;
        Qualified<CoroutineDispatcher> qualified2 = new Qualified<>(Blocking.class, CoroutineDispatcher.class);
        Intrinsics.checkNotNullExpressionValue(qualified2, "qualified(Blocking::clas…neDispatcher::class.java)");
        blockingDispatcher = qualified2;
        Qualified<TransportFactory> qualifiedA4 = Qualified.a(TransportFactory.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedA4, "unqualified(TransportFactory::class.java)");
        transportFactory = qualifiedA4;
        Qualified<FirebaseSessionsComponent> qualifiedA5 = Qualified.a(FirebaseSessionsComponent.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedA5, "unqualified(FirebaseSessionsComponent::class.java)");
        firebaseSessionsComponent = qualifiedA5;
        try {
            int i2 = Companion.AnonymousClass1.f45008b;
        } catch (NoClassDefFoundError unused) {
            Log.w(TAG, "Your app is experiencing a known issue in the Android Gradle plugin, see https://issuetracker.google.com/328687152\n\nIt affects Java-only apps using AGP version 8.3.2 and under. To avoid the issue, either:\n\n1. Upgrade Android Gradle plugin to 8.4.0+\n   Follow the guide at https://developer.android.com/build/agp-upgrade-assistant\n\n2. Or, add the Kotlin plugin to your app\n   Follow the guide at https://developer.android.com/kotlin/add-kotlin\n\n3. Or, do the technical workaround described in https://issuetracker.google.com/issues/328687152#comment3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessions getComponents$lambda$0(ComponentContainer componentContainer) {
        return ((FirebaseSessionsComponent) componentContainer.e(firebaseSessionsComponent)).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessionsComponent getComponents$lambda$1(ComponentContainer componentContainer) {
        DaggerFirebaseSessionsComponent.Builder builder = new DaggerFirebaseSessionsComponent.Builder();
        Object objE = componentContainer.e(appContext);
        Intrinsics.checkNotNullExpressionValue(objE, "container[appContext]");
        Context context = (Context) objE;
        context.getClass();
        builder.f44960a = context;
        Object objE2 = componentContainer.e(backgroundDispatcher);
        Intrinsics.checkNotNullExpressionValue(objE2, "container[backgroundDispatcher]");
        CoroutineContext coroutineContext = (CoroutineContext) objE2;
        coroutineContext.getClass();
        builder.f44961b = coroutineContext;
        Object objE3 = componentContainer.e(blockingDispatcher);
        Intrinsics.checkNotNullExpressionValue(objE3, "container[blockingDispatcher]");
        CoroutineContext coroutineContext2 = (CoroutineContext) objE3;
        coroutineContext2.getClass();
        builder.f44962c = coroutineContext2;
        Object objE4 = componentContainer.e(firebaseApp);
        Intrinsics.checkNotNullExpressionValue(objE4, "container[firebaseApp]");
        FirebaseApp firebaseApp2 = (FirebaseApp) objE4;
        firebaseApp2.getClass();
        builder.f44963d = firebaseApp2;
        Object objE5 = componentContainer.e(firebaseInstallationsApi);
        Intrinsics.checkNotNullExpressionValue(objE5, "container[firebaseInstallationsApi]");
        FirebaseInstallationsApi firebaseInstallationsApi2 = (FirebaseInstallationsApi) objE5;
        firebaseInstallationsApi2.getClass();
        builder.f44964e = firebaseInstallationsApi2;
        Provider providerB = componentContainer.b(transportFactory);
        Intrinsics.checkNotNullExpressionValue(providerB, "container.getProvider(transportFactory)");
        providerB.getClass();
        builder.f44965f = providerB;
        Preconditions.a(Context.class, builder.f44960a);
        Preconditions.a(CoroutineContext.class, builder.f44961b);
        Preconditions.a(CoroutineContext.class, builder.f44962c);
        Preconditions.a(FirebaseApp.class, builder.f44963d);
        Preconditions.a(FirebaseInstallationsApi.class, builder.f44964e);
        Preconditions.a(Provider.class, builder.f44965f);
        Context context2 = builder.f44960a;
        CoroutineContext coroutineContext3 = builder.f44961b;
        FirebaseApp firebaseApp3 = builder.f44963d;
        FirebaseInstallationsApi firebaseInstallationsApi3 = builder.f44964e;
        Provider provider = builder.f44965f;
        DaggerFirebaseSessionsComponent.FirebaseSessionsComponentImpl firebaseSessionsComponentImpl = new DaggerFirebaseSessionsComponent.FirebaseSessionsComponentImpl();
        firebaseSessionsComponentImpl.f44966a = InstanceFactory.a(firebaseApp3);
        InstanceFactory instanceFactoryA = InstanceFactory.a(context2);
        firebaseSessionsComponentImpl.f44967b = instanceFactoryA;
        firebaseSessionsComponentImpl.f44968c = DoubleCheck.a(new LocalOverrideSettings_Factory(instanceFactoryA));
        firebaseSessionsComponentImpl.f44969d = InstanceFactory.a(coroutineContext3);
        firebaseSessionsComponentImpl.f44970e = InstanceFactory.a(firebaseInstallationsApi3);
        javax.inject.Provider providerA = DoubleCheck.a(new FirebaseSessionsComponent_MainModule_Companion_ApplicationInfoFactory(firebaseSessionsComponentImpl.f44966a));
        firebaseSessionsComponentImpl.f44971f = providerA;
        firebaseSessionsComponentImpl.f44972g = DoubleCheck.a(new RemoteSettingsFetcher_Factory(firebaseSessionsComponentImpl.f44969d, providerA));
        javax.inject.Provider providerA2 = DoubleCheck.a(new FirebaseSessionsComponent_MainModule_Companion_SessionConfigsDataStoreFactory(firebaseSessionsComponentImpl.f44967b));
        firebaseSessionsComponentImpl.f44973h = providerA2;
        javax.inject.Provider providerA3 = DoubleCheck.a(new SettingsCache_Factory(providerA2));
        firebaseSessionsComponentImpl.f44974i = providerA3;
        javax.inject.Provider providerA4 = DoubleCheck.a(new RemoteSettings_Factory(firebaseSessionsComponentImpl.f44969d, firebaseSessionsComponentImpl.f44970e, firebaseSessionsComponentImpl.f44971f, firebaseSessionsComponentImpl.f44972g, providerA3));
        firebaseSessionsComponentImpl.f44975j = providerA4;
        firebaseSessionsComponentImpl.f44976k = DoubleCheck.a(new SessionsSettings_Factory(firebaseSessionsComponentImpl.f44968c, providerA4));
        javax.inject.Provider providerA5 = DoubleCheck.a(new SessionLifecycleServiceBinderImpl_Factory(firebaseSessionsComponentImpl.f44967b));
        firebaseSessionsComponentImpl.f44977l = providerA5;
        firebaseSessionsComponentImpl.f44978m = DoubleCheck.a(new FirebaseSessions_Factory(firebaseSessionsComponentImpl.f44966a, firebaseSessionsComponentImpl.f44976k, firebaseSessionsComponentImpl.f44969d, providerA5));
        javax.inject.Provider providerA6 = DoubleCheck.a(new FirebaseSessionsComponent_MainModule_Companion_SessionDetailsDataStoreFactory(firebaseSessionsComponentImpl.f44967b));
        firebaseSessionsComponentImpl.n = providerA6;
        firebaseSessionsComponentImpl.o = DoubleCheck.a(new SessionDatastoreImpl_Factory(firebaseSessionsComponentImpl.f44969d, providerA6));
        javax.inject.Provider providerA7 = DoubleCheck.a(new EventGDTLogger_Factory(InstanceFactory.a(provider)));
        firebaseSessionsComponentImpl.p = providerA7;
        firebaseSessionsComponentImpl.q = DoubleCheck.a(new SessionFirelogPublisherImpl_Factory(firebaseSessionsComponentImpl.f44966a, firebaseSessionsComponentImpl.f44970e, firebaseSessionsComponentImpl.f44976k, providerA7, firebaseSessionsComponentImpl.f44969d));
        firebaseSessionsComponentImpl.r = DoubleCheck.a(FirebaseSessionsComponent_MainModule_Companion_TimeProviderFactory.InstanceHolder.f45005a);
        javax.inject.Provider providerA8 = DoubleCheck.a(FirebaseSessionsComponent_MainModule_Companion_UuidGeneratorFactory.InstanceHolder.f45006a);
        firebaseSessionsComponentImpl.s = providerA8;
        firebaseSessionsComponentImpl.t = DoubleCheck.a(new SessionGenerator_Factory(firebaseSessionsComponentImpl.r, providerA8));
        return firebaseSessionsComponentImpl;
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List<Component<? extends Object>> getComponents() {
        Component.Builder builderB = Component.b(FirebaseSessions.class);
        builderB.f43563a = LIBRARY_NAME;
        builderB.a(Dependency.a(firebaseSessionsComponent));
        builderB.f43568f = new androidx.work.impl.model.a(16);
        builderB.d(2);
        Component componentB = builderB.b();
        Component.Builder builderB2 = Component.b(FirebaseSessionsComponent.class);
        builderB2.f43563a = "fire-sessions-component";
        builderB2.a(Dependency.a(appContext));
        builderB2.a(Dependency.a(backgroundDispatcher));
        builderB2.a(Dependency.a(blockingDispatcher));
        builderB2.a(Dependency.a(firebaseApp));
        builderB2.a(Dependency.a(firebaseInstallationsApi));
        builderB2.a(new Dependency(transportFactory, 1, 1));
        builderB2.f43568f = new androidx.work.impl.model.a(17);
        return CollectionsKt.I(componentB, builderB2.b(), LibraryVersionComponent.a(LIBRARY_NAME, "2.1.2"));
    }
}
