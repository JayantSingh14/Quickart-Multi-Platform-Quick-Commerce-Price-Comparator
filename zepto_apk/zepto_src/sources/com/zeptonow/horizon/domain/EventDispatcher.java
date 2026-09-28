package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.HorizonConfig;
import com.zeptonow.horizon.storage.EventStorage;
import com.zeptonow.horizon.utils.DefaultLogger;
import com.zeptonow.horizon.utils.NetworkMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ContextScope;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EventDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final HorizonConfig f47907a;

    /* renamed from: b, reason: collision with root package name */
    public final EventProcessor f47908b;

    /* renamed from: c, reason: collision with root package name */
    public final EventStorage f47909c;

    /* renamed from: d, reason: collision with root package name */
    public final ContextScope f47910d;

    /* renamed from: e, reason: collision with root package name */
    public final NetworkMonitor f47911e;

    /* renamed from: f, reason: collision with root package name */
    public final DefaultLogger f47912f;

    /* renamed from: g, reason: collision with root package name */
    public final EventTypesChannel f47913g;

    /* renamed from: h, reason: collision with root package name */
    public final EventTypesChannel f47914h;

    public EventDispatcher(HorizonConfig config, EventProcessor eventProcessor, EventStorage eventStorage, ContextScope scope, NetworkMonitor networkMonitor, DefaultLogger logger) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(eventProcessor, "eventProcessor");
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f47907a = config;
        this.f47908b = eventProcessor;
        this.f47909c = eventStorage;
        this.f47910d = scope;
        this.f47911e = networkMonitor;
        this.f47912f = logger;
        this.f47913g = new EventTypesChannel(logger);
        this.f47914h = new EventTypesChannel(logger);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
    
        if (r2.a(r8, r0) == r1) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0090 A[PHI: r2 r8 r9
      0x0090: PHI (r2v4 com.zeptonow.horizon.domain.EventDispatcher) = (r2v3 com.zeptonow.horizon.domain.EventDispatcher), (r2v7 com.zeptonow.horizon.domain.EventDispatcher) binds: [B:30:0x008d, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0090: PHI (r8v3 com.zeptonow.horizon.entity.EventType) = (r8v2 com.zeptonow.horizon.entity.EventType), (r8v9 com.zeptonow.horizon.entity.EventType) binds: [B:30:0x008d, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x0090: PHI (r9v12 java.lang.Object) = (r9v11 java.lang.Object), (r9v1 java.lang.Object) binds: [B:30:0x008d, B:17:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.zeptonow.horizon.entity.EventType r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.zeptonow.horizon.domain.EventDispatcher$retryFailedEvents$1
            if (r0 == 0) goto L13
            r0 = r9
            com.zeptonow.horizon.domain.EventDispatcher$retryFailedEvents$1 r0 = (com.zeptonow.horizon.domain.EventDispatcher$retryFailedEvents$1) r0
            int r1 = r0.f47959e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f47959e = r1
            goto L18
        L13:
            com.zeptonow.horizon.domain.EventDispatcher$retryFailedEvents$1 r0 = new com.zeptonow.horizon.domain.EventDispatcher$retryFailedEvents$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f47957c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f47959e
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L51
            if (r2 == r6) goto L49
            if (r2 == r5) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.b(r9)
            goto Lb8
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            com.zeptonow.horizon.entity.EventType r8 = r0.f47956b
            com.zeptonow.horizon.domain.EventDispatcher r2 = r0.f47955a
            kotlin.ResultKt.b(r9)
            goto L90
        L41:
            com.zeptonow.horizon.entity.EventType r8 = r0.f47956b
            com.zeptonow.horizon.domain.EventDispatcher r2 = r0.f47955a
            kotlin.ResultKt.b(r9)
            goto L7d
        L49:
            com.zeptonow.horizon.entity.EventType r8 = r0.f47956b
            com.zeptonow.horizon.domain.EventDispatcher r2 = r0.f47955a
            kotlin.ResultKt.b(r9)
            goto L64
        L51:
            kotlin.ResultKt.b(r9)
            r0.f47955a = r7
            r0.f47956b = r8
            r0.f47959e = r6
            com.zeptonow.horizon.domain.EventProcessor r9 = r7.f47908b
            java.lang.Object r9 = r9.d(r8, r0)
            if (r9 != r1) goto L63
            goto Lb7
        L63:
            r2 = r7
        L64:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L7d
            com.zeptonow.horizon.entity.HorizonConfig r9 = r2.f47907a
            r0.f47955a = r2
            r0.f47956b = r8
            r0.f47959e = r5
            long r5 = r9.f48085e
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.a(r5, r0)
            if (r9 != r1) goto L7d
            goto Lb7
        L7d:
            com.zeptonow.horizon.storage.EventStorage r9 = r2.f47909c
            com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1 r9 = r9.a(r8)
            r0.f47955a = r2
            r0.f47956b = r8
            r0.f47959e = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.i(r9, r0)
            if (r9 != r1) goto L90
            goto Lb7
        L90:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            com.zeptonow.horizon.utils.NetworkMonitor r4 = r2.f47911e
            kotlinx.coroutines.flow.StateFlow r4 = r4.isConnected()
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r9 == 0) goto Lbb
            if (r4 == 0) goto Lbb
            r9 = 0
            r0.f47955a = r9
            r0.f47956b = r9
            r0.f47959e = r3
            java.lang.Object r8 = r2.a(r8, r0)
            if (r8 != r1) goto Lb8
        Lb7:
            return r1
        Lb8:
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        Lbb:
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventDispatcher.a(com.zeptonow.horizon.entity.EventType, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
