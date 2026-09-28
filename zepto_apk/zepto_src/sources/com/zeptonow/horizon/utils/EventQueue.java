package com.zeptonow.horizon.utils;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EventQueue {

    /* renamed from: a, reason: collision with root package name */
    public final MutexImpl f48240a = MutexKt.a();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f48241b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final int f48242c = 1000;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.zeptonow.horizon.utils.EventQueue$clear$1
            if (r0 == 0) goto L13
            r0 = r5
            com.zeptonow.horizon.utils.EventQueue$clear$1 r0 = (com.zeptonow.horizon.utils.EventQueue$clear$1) r0
            int r1 = r0.f48247e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48247e = r1
            goto L18
        L13:
            com.zeptonow.horizon.utils.EventQueue$clear$1 r0 = new com.zeptonow.horizon.utils.EventQueue$clear$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f48245c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48247e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlinx.coroutines.sync.MutexImpl r1 = r0.f48244b
            com.zeptonow.horizon.utils.EventQueue r0 = r0.f48243a
            kotlin.ResultKt.b(r5)
            goto L47
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.MutexImpl r5 = r4.f48240a
            r0.f48243a = r4
            r0.f48244b = r5
            r0.f48247e = r3
            java.lang.Object r0 = r5.c(r0)
            if (r0 != r1) goto L45
            return r1
        L45:
            r0 = r4
            r1 = r5
        L47:
            r5 = 0
            java.util.ArrayList r0 = r0.f48241b     // Catch: java.lang.Throwable -> L55
            r0.clear()     // Catch: java.lang.Throwable -> L55
            kotlin.Unit r0 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L55
            r1.b(r5)
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L55:
            r0 = move-exception
            r1.b(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.utils.EventQueue.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.zeptonow.horizon.utils.EventQueue$dequeueAll$1
            if (r0 == 0) goto L13
            r0 = r5
            com.zeptonow.horizon.utils.EventQueue$dequeueAll$1 r0 = (com.zeptonow.horizon.utils.EventQueue$dequeueAll$1) r0
            int r1 = r0.f48252e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48252e = r1
            goto L18
        L13:
            com.zeptonow.horizon.utils.EventQueue$dequeueAll$1 r0 = new com.zeptonow.horizon.utils.EventQueue$dequeueAll$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f48250c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48252e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlinx.coroutines.sync.MutexImpl r1 = r0.f48249b
            com.zeptonow.horizon.utils.EventQueue r0 = r0.f48248a
            kotlin.ResultKt.b(r5)
            goto L47
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.sync.MutexImpl r5 = r4.f48240a
            r0.f48248a = r4
            r0.f48249b = r5
            r0.f48252e = r3
            java.lang.Object r0 = r5.c(r0)
            if (r0 != r1) goto L45
            return r1
        L45:
            r0 = r4
            r1 = r5
        L47:
            r5 = 0
            java.util.ArrayList r2 = r0.f48241b     // Catch: java.lang.Throwable -> L57
            java.util.List r2 = kotlin.collections.CollectionsKt.e0(r2)     // Catch: java.lang.Throwable -> L57
            java.util.ArrayList r0 = r0.f48241b     // Catch: java.lang.Throwable -> L57
            r0.clear()     // Catch: java.lang.Throwable -> L57
            r1.b(r5)
            return r2
        L57:
            r0 = move-exception
            r1.b(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.utils.EventQueue.b(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(com.zeptonow.horizon.entity.Event r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.zeptonow.horizon.utils.EventQueue$enqueue$1
            if (r0 == 0) goto L13
            r0 = r6
            com.zeptonow.horizon.utils.EventQueue$enqueue$1 r0 = (com.zeptonow.horizon.utils.EventQueue$enqueue$1) r0
            int r1 = r0.f48258f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48258f = r1
            goto L18
        L13:
            com.zeptonow.horizon.utils.EventQueue$enqueue$1 r0 = new com.zeptonow.horizon.utils.EventQueue$enqueue$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f48256d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48258f
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlinx.coroutines.sync.MutexImpl r5 = r0.f48255c
            com.zeptonow.horizon.entity.Event r1 = r0.f48254b
            com.zeptonow.horizon.utils.EventQueue r0 = r0.f48253a
            kotlin.ResultKt.b(r6)
            r6 = r5
            r5 = r1
            goto L4c
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.sync.MutexImpl r6 = r4.f48240a
            r0.f48253a = r4
            r0.f48254b = r5
            r0.f48255c = r6
            r0.f48258f = r3
            java.lang.Object r0 = r6.c(r0)
            if (r0 != r1) goto L4b
            return r1
        L4b:
            r0 = r4
        L4c:
            r1 = 0
            java.util.ArrayList r2 = r0.f48241b     // Catch: java.lang.Throwable -> L69
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L69
            int r3 = r0.f48242c     // Catch: java.lang.Throwable -> L69
            java.util.ArrayList r0 = r0.f48241b
            if (r2 >= r3) goto L5d
            r0.add(r5)     // Catch: java.lang.Throwable -> L69
            goto L63
        L5d:
            kotlin.collections.CollectionsKt.O(r0)     // Catch: java.lang.Throwable -> L69
            r0.add(r5)     // Catch: java.lang.Throwable -> L69
        L63:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L69
            r6.b(r1)
            return r5
        L69:
            r5 = move-exception
            r6.b(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.utils.EventQueue.c(com.zeptonow.horizon.entity.Event, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
