package com.zeptonow.horizon;

import com.horizon.HorizonModule;
import com.zeptonow.horizon.di.DependencyContainer;
import com.zeptonow.horizon.domain.EventManager;
import com.zeptonow.horizon.entity.Event;
import com.zeptonow.horizon.entity.HorizonConfig;
import com.zeptonow.horizon.utils.AndroidDispatchersProvider;
import com.zeptonow.horizon.utils.DefaultLogger;
import com.zeptonow.horizon.utils.EventQueue;
import com.zeptonow.horizon.utils.LogLevel;
import com.zeptonow.horizon.utils.PlatformContext;
import com.zeptonow.horizon.utils.SerializationUtilsKt;
import defpackage.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.json.Json;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class HorizonSDK {

    /* renamed from: a, reason: collision with root package name */
    public static volatile DependencyContainer f47830a;

    /* renamed from: b, reason: collision with root package name */
    public static final AndroidDispatchersProvider f47831b;

    /* renamed from: c, reason: collision with root package name */
    public static final ContextScope f47832c;

    /* renamed from: d, reason: collision with root package name */
    public static final EventQueue f47833d;

    static {
        AndroidDispatchersProvider androidDispatchersProvider = new AndroidDispatchersProvider();
        f47831b = androidDispatchersProvider;
        f47832c = CoroutineScopeKt.a(androidDispatchersProvider.f48228b);
        f47833d = new EventQueue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r4) {
        /*
            boolean r0 = r4 instanceof com.zeptonow.horizon.HorizonSDK$flushQueuedEvents$1
            if (r0 == 0) goto L13
            r0 = r4
            com.zeptonow.horizon.HorizonSDK$flushQueuedEvents$1 r0 = (com.zeptonow.horizon.HorizonSDK$flushQueuedEvents$1) r0
            int r1 = r0.f47835b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47835b = r1
            goto L18
        L13:
            com.zeptonow.horizon.HorizonSDK$flushQueuedEvents$1 r0 = new com.zeptonow.horizon.HorizonSDK$flushQueuedEvents$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.f47834a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f47835b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r4)
            goto L3d
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2f:
            kotlin.ResultKt.b(r4)
            com.zeptonow.horizon.utils.EventQueue r4 = com.zeptonow.horizon.HorizonSDK.f47833d
            r0.f47835b = r3
            java.lang.Object r4 = r4.b(r0)
            if (r4 != r1) goto L3d
            return r1
        L3d:
            java.util.List r4 = (java.util.List) r4
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L80
            com.zeptonow.horizon.di.DependencyContainer r0 = com.zeptonow.horizon.HorizonSDK.f47830a
            if (r0 == 0) goto L5c
            com.zeptonow.horizon.utils.DefaultLogger r0 = r0.a()
            if (r0 == 0) goto L5c
            com.zeptonow.horizon.utils.LogLevel r1 = com.zeptonow.horizon.utils.LogLevel.f48264b
            com.zeptonow.horizon.HorizonSDK$flushQueuedEvents$2 r2 = new com.zeptonow.horizon.HorizonSDK$flushQueuedEvents$2
            r2.<init>()
            r0.a(r1, r2)
        L5c:
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L62:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L80
            java.lang.Object r0 = r4.next()
            com.zeptonow.horizon.entity.Event r0 = (com.zeptonow.horizon.entity.Event) r0
            com.zeptonow.horizon.di.DependencyContainer r1 = com.zeptonow.horizon.HorizonSDK.f47830a
            if (r1 == 0) goto L62
            kotlin.Lazy r1 = r1.o
            java.lang.Object r1 = r1.getValue()
            com.zeptonow.horizon.domain.EventManager r1 = (com.zeptonow.horizon.domain.EventManager) r1
            if (r1 == 0) goto L62
            r1.d(r0)
            goto L62
        L80:
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.HorizonSDK.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static void b(PlatformContext context, String configJson, HorizonModule bridge, b onInitialised) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configJson, "configJson");
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(onInitialised, "onInitialised");
        if (f47830a != null) {
            return;
        }
        Json json = SerializationUtilsKt.f48279b;
        json.getClass();
        HorizonConfig horizonConfig = (HorizonConfig) json.b(configJson, HorizonConfig.Companion.serializer());
        AndroidDispatchersProvider androidDispatchersProvider = f47831b;
        int i2 = horizonConfig.f48081a;
        androidDispatchersProvider.getClass();
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        DefaultIoScheduler.f55150b.s1(i2);
        f47830a = new DependencyContainer(context, horizonConfig, bridge, androidDispatchersProvider);
        BuildersKt.c(f47832c, null, new HorizonSDK$init$1(onInitialised, null), 3);
    }

    public static void c(String headersJson) {
        DefaultLogger defaultLoggerA;
        ContextScope contextScope;
        Intrinsics.checkNotNullParameter(headersJson, "headersJson");
        try {
            DependencyContainer dependencyContainer = f47830a;
            if (dependencyContainer == null || (contextScope = dependencyContainer.f47849f) == null) {
                return;
            }
            BuildersKt.c(contextScope, null, new HorizonSDK$setHeaders$1(headersJson, null), 3);
        } catch (IllegalArgumentException e2) {
            DependencyContainer dependencyContainer2 = f47830a;
            if (dependencyContainer2 == null || (defaultLoggerA = dependencyContainer2.a()) == null) {
                return;
            }
            defaultLoggerA.a(LogLevel.f48264b, new Function0<String>() { // from class: com.zeptonow.horizon.HorizonSDK$setHeaders$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "Invalid headers: " + e2.getMessage();
                }
            });
        }
    }

    public static void d() {
        EventManager eventManager;
        DependencyContainer dependencyContainer = f47830a;
        if (dependencyContainer != null && (eventManager = (EventManager) dependencyContainer.o.getValue()) != null) {
            eventManager.c();
        }
        f47830a = null;
        BuildersKt.c(f47832c, null, new HorizonSDK$shutdown$1(2, null), 3);
    }

    public static void e(Event event) {
        EventManager eventManager;
        Intrinsics.checkNotNullParameter(event, "event");
        DependencyContainer dependencyContainer = f47830a;
        if (dependencyContainer == null || (eventManager = (EventManager) dependencyContainer.o.getValue()) == null) {
            BuildersKt.c(f47832c, null, new HorizonSDK$track$1(event, null), 3);
        } else {
            eventManager.d(event);
        }
    }
}
