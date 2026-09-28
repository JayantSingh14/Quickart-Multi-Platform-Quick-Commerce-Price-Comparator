package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.Event;
import com.zeptonow.horizon.entity.EventStatus;
import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.network.NetworkClient;
import com.zeptonow.horizon.storage.EventEntity;
import com.zeptonow.horizon.utils.DefaultLogger;
import com.zeptonow.horizon.utils.LogLevel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.datetime.Clock;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DirectEventSender {

    /* renamed from: a, reason: collision with root package name */
    public final NetworkClient f47867a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultLogger f47868b;

    /* renamed from: c, reason: collision with root package name */
    public final ContextScope f47869c;

    /* renamed from: d, reason: collision with root package name */
    public final MutexImpl f47870d;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedHashMap f47871e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f47872f;

    public DirectEventSender(NetworkClient networkClient, DefaultLogger logger, ContextScope scope) {
        Intrinsics.checkNotNullParameter(networkClient, "networkClient");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f47867a = networkClient;
        this.f47868b = logger;
        this.f47869c = scope;
        this.f47870d = MutexKt.a();
        this.f47871e = new LinkedHashMap();
        this.f47872f = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(com.zeptonow.horizon.domain.DirectEventSender r6, com.zeptonow.horizon.storage.EventEntity r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r6.getClass()
            boolean r0 = r8 instanceof com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$1
            if (r0 == 0) goto L16
            r0 = r8
            com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$1 r0 = (com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$1) r0
            int r1 = r0.f47878f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f47878f = r1
            goto L1b
        L16:
            com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$1 r0 = new com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$1
            r0.<init>(r6, r8)
        L1b:
            java.lang.Object r8 = r0.f47876d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f47878f
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            kotlinx.coroutines.sync.MutexImpl r6 = r0.f47875c
            com.zeptonow.horizon.storage.EventEntity r7 = r0.f47874b
            com.zeptonow.horizon.domain.DirectEventSender r0 = r0.f47873a
            kotlin.ResultKt.b(r8)
            r8 = r6
            r6 = r0
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.MutexImpl r8 = r6.f47870d
            r0.f47873a = r6
            r0.f47874b = r7
            r0.f47875c = r8
            r0.f47878f = r3
            java.lang.Object r0 = r8.c(r0)
            if (r0 != r1) goto L4e
            return r1
        L4e:
            r0 = 0
            com.zeptonow.horizon.entity.EventType r1 = r7.f48171h     // Catch: java.lang.Throwable -> L62
            java.util.LinkedHashMap r2 = r6.f47871e     // Catch: java.lang.Throwable -> L62
            java.lang.Object r3 = r2.get(r1)     // Catch: java.lang.Throwable -> L62
            if (r3 != 0) goto L64
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L62
            r3.<init>()     // Catch: java.lang.Throwable -> L62
            r2.put(r1, r3)     // Catch: java.lang.Throwable -> L62
            goto L64
        L62:
            r6 = move-exception
            goto Lce
        L64:
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L62
            r3.add(r7)     // Catch: java.lang.Throwable -> L62
            java.util.LinkedHashMap r7 = r6.f47871e     // Catch: java.lang.Throwable -> L62
            java.util.Collection r7 = r7.values()     // Catch: java.lang.Throwable -> L62
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Throwable -> L62
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L62
            r2 = 0
        L76:
            boolean r4 = r7.hasNext()     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L88
            java.lang.Object r4 = r7.next()     // Catch: java.lang.Throwable -> L62
            java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Throwable -> L62
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L62
            int r2 = r2 + r4
            goto L76
        L88:
            com.zeptonow.horizon.utils.DefaultLogger r7 = r6.f47868b     // Catch: java.lang.Throwable -> L62
            com.zeptonow.horizon.utils.LogLevel r4 = com.zeptonow.horizon.utils.LogLevel.f48266d     // Catch: java.lang.Throwable -> L62
            com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$2$1 r5 = new com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$2$1     // Catch: java.lang.Throwable -> L62
            r5.<init>()     // Catch: java.lang.Throwable -> L62
            r7.a(r4, r5)     // Catch: java.lang.Throwable -> L62
            int r7 = r3.size()     // Catch: java.lang.Throwable -> L62
            java.util.LinkedHashMap r2 = r6.f47872f
            r3 = 2
            if (r7 < r3) goto Lac
            java.lang.Object r7 = r2.get(r1)     // Catch: java.lang.Throwable -> L62
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto La8
            r7.e(r0)     // Catch: java.lang.Throwable -> L62
        La8:
            r6.b(r1)     // Catch: java.lang.Throwable -> L62
            goto Lc6
        Lac:
            java.lang.Object r7 = r2.get(r1)     // Catch: java.lang.Throwable -> L62
            kotlinx.coroutines.Job r7 = (kotlinx.coroutines.Job) r7     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto Lb7
            r7.e(r0)     // Catch: java.lang.Throwable -> L62
        Lb7:
            kotlinx.coroutines.internal.ContextScope r7 = r6.f47869c     // Catch: java.lang.Throwable -> L62
            com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$2$2 r3 = new com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$2$2     // Catch: java.lang.Throwable -> L62
            r3.<init>(r6, r1, r0)     // Catch: java.lang.Throwable -> L62
            r6 = 3
            kotlinx.coroutines.Job r6 = kotlinx.coroutines.BuildersKt.c(r7, r0, r3, r6)     // Catch: java.lang.Throwable -> L62
            r2.put(r1, r6)     // Catch: java.lang.Throwable -> L62
        Lc6:
            kotlin.Unit r6 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L62
            r8.b(r0)
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        Lce:
            r8.b(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.DirectEventSender.a(com.zeptonow.horizon.domain.DirectEventSender, com.zeptonow.horizon.storage.EventEntity, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void b(final EventType eventType) {
        LinkedHashMap linkedHashMap = this.f47871e;
        List list = (List) linkedHashMap.get(eventType);
        if (list == null) {
            return;
        }
        final List listE0 = CollectionsKt.e0(list);
        list.clear();
        LinkedHashMap linkedHashMap2 = this.f47872f;
        Job job = (Job) linkedHashMap2.get(eventType);
        if (job != null) {
            job.e(null);
        }
        linkedHashMap2.remove(eventType);
        if (!listE0.isEmpty()) {
            this.f47868b.a(LogLevel.f48265c, new Function0<String>() { // from class: com.zeptonow.horizon.domain.DirectEventSender$sendBufferedEvents$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "DirectEventSender:: sending batch for " + eventType + ", size: " + listE0.size();
                }
            });
            BuildersKt.c(this.f47869c, null, new DirectEventSender$sendBufferedEvents$2(this, listE0, eventType, null), 3);
        }
        if (list.isEmpty()) {
            linkedHashMap.remove(eventType);
        }
    }

    public final void c(final Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.f47868b.a(LogLevel.f48266d, new Function0<String>() { // from class: com.zeptonow.horizon.domain.DirectEventSender$sendEvent$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return "DirectEventSender:: queuing event: " + event.f48063a;
            }
        });
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        BuildersKt.c(this.f47869c, null, new DirectEventSender$sendEvent$2(this, new EventEntity(string, event.f48063a, event.f48064b, Clock.System.a().a(), 0L, EventStatus.f48073c, null, event.f48065c), null), 3);
    }
}
