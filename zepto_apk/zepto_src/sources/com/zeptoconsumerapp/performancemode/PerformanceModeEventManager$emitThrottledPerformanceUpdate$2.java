package com.zeptoconsumerapp.performancemode;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$2", f = "PerformanceModeEventManager.kt", l = {79, 80}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class PerformanceModeEventManager$emitThrottledPerformanceUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47732a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f47733b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PerformanceModeEventManager f47734c;

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$2$1", f = "PerformanceModeEventManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PerformanceModeEventManager f47735a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PerformanceModeEventManager performanceModeEventManager, Continuation continuation) {
            super(2, continuation);
            this.f47735a = performanceModeEventManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f47735a, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            PerformanceModeEventManager performanceModeEventManager = this.f47735a;
            if (performanceModeEventManager.f47727c) {
                performanceModeEventManager.f47728d = System.currentTimeMillis();
                PerformanceModeEventManager.a(performanceModeEventManager);
                performanceModeEventManager.f47726b = null;
            }
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerformanceModeEventManager$emitThrottledPerformanceUpdate$2(long j2, PerformanceModeEventManager performanceModeEventManager, Continuation continuation) {
        super(2, continuation);
        this.f47733b = j2;
        this.f47734c = performanceModeEventManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PerformanceModeEventManager$emitThrottledPerformanceUpdate$2(this.f47733b, this.f47734c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PerformanceModeEventManager$emitThrottledPerformanceUpdate$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.e(r6, r1, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r5.f47732a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.ResultKt.b(r6)
            goto L3f
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            kotlin.ResultKt.b(r6)
            goto L2a
        L1c:
            kotlin.ResultKt.b(r6)
            r5.f47732a = r3
            long r3 = r5.f47733b
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.a(r3, r5)
            if (r6 != r0) goto L2a
            goto L3e
        L2a:
            kotlinx.coroutines.scheduling.DefaultScheduler r6 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.internal.MainDispatcherLoader.f55099a
            com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$2$1 r1 = new com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$2$1
            com.zeptoconsumerapp.performancemode.PerformanceModeEventManager r3 = r5.f47734c
            r4 = 0
            r1.<init>(r3, r4)
            r5.f47732a = r2
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.e(r6, r1, r5)
            if (r6 != r0) goto L3f
        L3e:
            return r0
        L3f:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
