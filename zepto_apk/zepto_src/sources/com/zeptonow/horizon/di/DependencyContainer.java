package com.zeptonow.horizon.di;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import app.cash.sqldelight.db.AfterVersion;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.driver.android.AndroidSqliteDriver;
import com.horizon.HorizonModule;
import com.zeptonow.horizon.domain.DirectEventSender;
import com.zeptonow.horizon.domain.EventDispatcher;
import com.zeptonow.horizon.domain.EventManager;
import com.zeptonow.horizon.domain.EventProcessor;
import com.zeptonow.horizon.entity.HorizonConfig;
import com.zeptonow.horizon.network.HttpClientFactory;
import com.zeptonow.horizon.network.KtorNetworkClient;
import com.zeptonow.horizon.network.NetworkClient;
import com.zeptonow.horizon.storage.EventDatabase;
import com.zeptonow.horizon.storage.EventStorage;
import com.zeptonow.horizon.storage.PersistentStorage;
import com.zeptonow.horizon.storage.shared.EventDatabaseImpl;
import com.zeptonow.horizon.utils.AndroidDispatchersProvider;
import com.zeptonow.horizon.utils.Compressor;
import com.zeptonow.horizon.utils.DefaultLogger;
import com.zeptonow.horizon.utils.NetworkMonitor;
import com.zeptonow.horizon.utils.NetworkMonitorImpl;
import com.zeptonow.horizon.utils.PlatformContext;
import io.ktor.client.HttpClient;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;

@Metadata
/* loaded from: classes.dex */
public final class DependencyContainer {

    /* renamed from: a, reason: collision with root package name */
    public final PlatformContext f47844a;

    /* renamed from: b, reason: collision with root package name */
    public final HorizonConfig f47845b;

    /* renamed from: c, reason: collision with root package name */
    public final HorizonModule f47846c;

    /* renamed from: d, reason: collision with root package name */
    public final AndroidDispatchersProvider f47847d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f47848e;

    /* renamed from: f, reason: collision with root package name */
    public final ContextScope f47849f;

    /* renamed from: g, reason: collision with root package name */
    public final Lazy f47850g;

    /* renamed from: h, reason: collision with root package name */
    public final Lazy f47851h;

    /* renamed from: i, reason: collision with root package name */
    public final Lazy f47852i;

    /* renamed from: j, reason: collision with root package name */
    public final Lazy f47853j;

    /* renamed from: k, reason: collision with root package name */
    public final Lazy f47854k;

    /* renamed from: l, reason: collision with root package name */
    public final Lazy f47855l;

    /* renamed from: m, reason: collision with root package name */
    public final Lazy f47856m;
    public final Lazy n;
    public final Lazy o;

    public DependencyContainer(PlatformContext platformContext, HorizonConfig config, HorizonModule bridge, AndroidDispatchersProvider dispatchers) {
        Intrinsics.checkNotNullParameter(platformContext, "platformContext");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.f47844a = platformContext;
        this.f47845b = config;
        this.f47846c = bridge;
        this.f47847d = dispatchers;
        this.f47848e = LazyKt.b(new Function0<DefaultLogger>() { // from class: com.zeptonow.horizon.di.DependencyContainer$logger$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return new DefaultLogger(this.f47863c.f47846c);
            }
        });
        this.f47849f = CoroutineScopeKt.a(dispatchers.f48227a.plus(SupervisorKt.b()));
        this.f47850g = LazyKt.b(new Function0<SqlDriver>() { // from class: com.zeptonow.horizon.di.DependencyContainer$sqlDriver$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DependencyContainer dependencyContainer = this.f47866c;
                Intrinsics.checkNotNullParameter(dependencyContainer, "<this>");
                Context context = dependencyContainer.f47844a.f48274a;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(Reflection.a(EventDatabase.class), "<this>");
                EventDatabaseImpl.Schema schema = EventDatabaseImpl.Schema.f48226a;
                FrameworkSQLiteOpenHelperFactory factory = new FrameworkSQLiteOpenHelperFactory();
                AndroidSqliteDriver.Callback callback = new AndroidSqliteDriver.Callback(new AfterVersion[0]);
                Intrinsics.checkNotNullParameter(schema, "schema");
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(factory, "factory");
                Intrinsics.checkNotNullParameter(callback, "callback");
                SupportSQLiteOpenHelper.Configuration.Builder builderA = SupportSQLiteOpenHelper.Configuration.Companion.a(context);
                Intrinsics.checkNotNullParameter(callback, "callback");
                builderA.f11903c = callback;
                builderA.f11902b = "events.db";
                builderA.f11904d = false;
                return new AndroidSqliteDriver(factory.g(builderA.a()), null, 20);
            }
        });
        this.f47851h = LazyKt.b(new Function0<PersistentStorage>() { // from class: com.zeptonow.horizon.di.DependencyContainer$eventStorage$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DependencyContainer dependencyContainer = this.f47861c;
                return new PersistentStorage((SqlDriver) dependencyContainer.f47850g.getValue(), dependencyContainer.f47847d);
            }
        });
        this.f47852i = LazyKt.b(new Function0<NetworkMonitor>() { // from class: com.zeptonow.horizon.di.DependencyContainer$networkMonitor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DependencyContainer dependencyContainer = this.f47865c;
                Intrinsics.checkNotNullParameter(dependencyContainer, "<this>");
                return new NetworkMonitorImpl(dependencyContainer.f47844a.f48274a);
            }
        });
        this.f47853j = LazyKt.b(new Function0<HttpClient>() { // from class: com.zeptonow.horizon.di.DependencyContainer$httpClient$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DependencyContainer dependencyContainer = this.f47862c;
                Intrinsics.checkNotNullParameter(dependencyContainer, "<this>");
                return new HttpClientFactory(dependencyContainer.f47844a.f48274a).a();
            }
        });
        this.f47854k = LazyKt.b(new Function0<KtorNetworkClient>() { // from class: com.zeptonow.horizon.di.DependencyContainer$networkClient$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Compressor compressor = new Compressor();
                DependencyContainer dependencyContainer = this.f47864c;
                return new KtorNetworkClient((HttpClient) dependencyContainer.f47853j.getValue(), dependencyContainer.f47845b, compressor, dependencyContainer.f47847d);
            }
        });
        this.f47855l = LazyKt.b(new Function0<EventProcessor>() { // from class: com.zeptonow.horizon.di.DependencyContainer$eventProcessor$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DependencyContainer dependencyContainer = this.f47860c;
                return new EventProcessor(dependencyContainer.f47845b, (NetworkClient) dependencyContainer.f47854k.getValue(), (EventStorage) dependencyContainer.f47851h.getValue(), dependencyContainer.a(), dependencyContainer.f47849f);
            }
        });
        this.f47856m = LazyKt.b(new Function0<DirectEventSender>() { // from class: com.zeptonow.horizon.di.DependencyContainer$directEventSender$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DependencyContainer dependencyContainer = this.f47857c;
                return new DirectEventSender((NetworkClient) dependencyContainer.f47854k.getValue(), dependencyContainer.a(), dependencyContainer.f47849f);
            }
        });
        this.n = LazyKt.b(new Function0<EventDispatcher>() { // from class: com.zeptonow.horizon.di.DependencyContainer$eventDispatcher$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DependencyContainer dependencyContainer = this.f47858c;
                return new EventDispatcher(dependencyContainer.f47845b, (EventProcessor) dependencyContainer.f47855l.getValue(), (EventStorage) dependencyContainer.f47851h.getValue(), dependencyContainer.f47849f, (NetworkMonitor) dependencyContainer.f47852i.getValue(), dependencyContainer.a());
            }
        });
        this.o = LazyKt.b(new Function0<EventManager>() { // from class: com.zeptonow.horizon.di.DependencyContainer$eventManager$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DependencyContainer dependencyContainer = this.f47859c;
                return new EventManager(dependencyContainer.f47849f, (EventStorage) dependencyContainer.f47851h.getValue(), (EventDispatcher) dependencyContainer.n.getValue(), dependencyContainer.f47845b, dependencyContainer.a(), (DirectEventSender) dependencyContainer.f47856m.getValue());
            }
        });
    }

    public final DefaultLogger a() {
        return (DefaultLogger) this.f47848e.getValue();
    }
}
