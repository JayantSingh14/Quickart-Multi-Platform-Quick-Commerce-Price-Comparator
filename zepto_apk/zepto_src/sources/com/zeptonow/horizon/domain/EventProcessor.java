package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.HorizonConfig;
import com.zeptonow.horizon.network.NetworkClient;
import com.zeptonow.horizon.storage.EventStorage;
import com.zeptonow.horizon.utils.DefaultLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final HorizonConfig f48002a;

    /* renamed from: b, reason: collision with root package name */
    public final NetworkClient f48003b;

    /* renamed from: c, reason: collision with root package name */
    public final EventStorage f48004c;

    /* renamed from: d, reason: collision with root package name */
    public final DefaultLogger f48005d;

    /* renamed from: e, reason: collision with root package name */
    public final ContextScope f48006e;

    /* renamed from: f, reason: collision with root package name */
    public final MutexImpl f48007f;

    public EventProcessor(HorizonConfig config, NetworkClient networkClient, EventStorage eventStorage, DefaultLogger logger, ContextScope scope) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(networkClient, "networkClient");
        Intrinsics.checkNotNullParameter(eventStorage, "eventStorage");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f48002a = config;
        this.f48003b = networkClient;
        this.f48004c = eventStorage;
        this.f48005d = logger;
        this.f48006e = scope;
        this.f48007f = MutexKt.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.zeptonow.horizon.entity.EventType r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.zeptonow.horizon.domain.EventProcessor$getBatchSize$1
            if (r0 == 0) goto L13
            r0 = r6
            com.zeptonow.horizon.domain.EventProcessor$getBatchSize$1 r0 = (com.zeptonow.horizon.domain.EventProcessor$getBatchSize$1) r0
            int r1 = r0.f48011d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48011d = r1
            goto L18
        L13:
            com.zeptonow.horizon.domain.EventProcessor$getBatchSize$1 r0 = new com.zeptonow.horizon.domain.EventProcessor$getBatchSize$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f48009b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48011d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            com.zeptonow.horizon.domain.EventProcessor r5 = r0.f48008a
            kotlin.ResultKt.b(r6)
            goto L46
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r6)
            com.zeptonow.horizon.storage.EventStorage r6 = r4.f48004c
            com.zeptonow.horizon.storage.PersistentStorage$getFailedEventCount$$inlined$map$1 r5 = r6.i(r5)
            r0.f48008a = r4
            r0.f48011d = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.i(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            com.zeptonow.horizon.entity.HorizonConfig r5 = r5.f48002a
            int r0 = r5.f48082b
            int r1 = r0 * 6
            if (r6 <= r1) goto L5c
            java.lang.Integer r6 = new java.lang.Integer
            int r5 = r5.f48083c
            r6.<init>(r5)
            return r6
        L5c:
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventProcessor.a(com.zeptonow.horizon.entity.EventType, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009c, code lost:
    
        if (r18.f48004c.d(r19, r3) == r4) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0125 A[Catch: all -> 0x0144, PHI: r0 r2 r7 r8
      0x0125: PHI (r0v10 java.util.List) = (r0v8 java.util.List), (r0v20 java.util.List) binds: [B:51:0x0122, B:23:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x0125: PHI (r2v11 kotlinx.coroutines.sync.MutexImpl) = (r2v9 kotlinx.coroutines.sync.MutexImpl), (r2v13 kotlinx.coroutines.sync.MutexImpl) binds: [B:51:0x0122, B:23:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x0125: PHI (r7v4 java.lang.String) = (r7v3 java.lang.String), (r7v6 java.lang.String) binds: [B:51:0x0122, B:23:0x005a] A[DONT_GENERATE, DONT_INLINE]
      0x0125: PHI (r8v3 com.zeptonow.horizon.domain.EventProcessor) = (r8v2 com.zeptonow.horizon.domain.EventProcessor), (r8v8 com.zeptonow.horizon.domain.EventProcessor) binds: [B:51:0x0122, B:23:0x005a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x0144, blocks: (B:53:0x0125, B:50:0x010c), top: B:65:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v11, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(final java.util.List r19, java.lang.Throwable r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventProcessor.b(java.util.List, java.lang.Throwable, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d8 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:22:0x004b, B:44:0x00c3, B:46:0x00d8, B:49:0x00e7, B:50:0x00fa, B:52:0x0100, B:53:0x010c), top: B:65:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e7 A[Catch: all -> 0x0050, TRY_ENTER, TryCatch #0 {all -> 0x0050, blocks: (B:22:0x004b, B:44:0x00c3, B:46:0x00d8, B:49:0x00e7, B:50:0x00fa, B:52:0x0100, B:53:0x010c), top: B:65:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r13v16, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(com.zeptonow.horizon.entity.EventType r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventProcessor.c(com.zeptonow.horizon.entity.EventType, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x01a8, code lost:
    
        if (r5.b(r2, r12, r0) == r1) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[PHI: r5 r11 r12
      0x0051: PHI (r5v15 com.zeptonow.horizon.domain.EventProcessor) = (r5v12 com.zeptonow.horizon.domain.EventProcessor), (r5v16 com.zeptonow.horizon.domain.EventProcessor) binds: [B:57:0x015f, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0051: PHI (r11v25 java.util.List) = (r11v23 java.util.List), (r11v28 java.util.List) binds: [B:57:0x015f, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0051: PHI (r12v14 java.lang.Object) = (r12v13 java.lang.Object), (r12v24 java.lang.Object) binds: [B:57:0x015f, B:14:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0101 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:17:0x005f, B:55:0x013f, B:22:0x0070, B:42:0x00ec, B:44:0x0101, B:47:0x0107, B:48:0x011a, B:50:0x0120, B:51:0x012c, B:34:0x00b7), top: B:73:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0107 A[Catch: all -> 0x0064, TRY_ENTER, TryCatch #0 {all -> 0x0064, blocks: (B:17:0x005f, B:55:0x013f, B:22:0x0070, B:42:0x00ec, B:44:0x0101, B:47:0x0107, B:48:0x011a, B:50:0x0120, B:51:0x012c, B:34:0x00b7), top: B:73:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r11v6, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.zeptonow.horizon.entity.EventType r11, kotlin.coroutines.jvm.internal.ContinuationImpl r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventProcessor.d(com.zeptonow.horizon.entity.EventType, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
