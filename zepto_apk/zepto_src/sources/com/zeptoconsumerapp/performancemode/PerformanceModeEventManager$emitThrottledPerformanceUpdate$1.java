package com.zeptoconsumerapp.performancemode;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
@DebugMetadata(c = "com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$1", f = "PerformanceModeEventManager.kt", l = {69}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class PerformanceModeEventManager$emitThrottledPerformanceUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47729a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PerformanceModeEventManager f47730b;

    @Metadata
    @DebugMetadata(c = "com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$1$1", f = "PerformanceModeEventManager.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptoconsumerapp.performancemode.PerformanceModeEventManager$emitThrottledPerformanceUpdate$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PerformanceModeEventManager f47731a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PerformanceModeEventManager performanceModeEventManager, Continuation continuation) {
            super(2, continuation);
            this.f47731a = performanceModeEventManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f47731a, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            PerformanceModeEventManager performanceModeEventManager = this.f47731a;
            if (performanceModeEventManager.f47727c) {
                PerformanceModeEventManager.a(performanceModeEventManager);
            }
            return Unit.f53572a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerformanceModeEventManager$emitThrottledPerformanceUpdate$1(PerformanceModeEventManager performanceModeEventManager, Continuation continuation) {
        super(2, continuation);
        this.f47730b = performanceModeEventManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PerformanceModeEventManager$emitThrottledPerformanceUpdate$1(this.f47730b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PerformanceModeEventManager$emitThrottledPerformanceUpdate$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47729a;
        if (i2 == 0) {
            ResultKt.b(obj);
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.f55099a;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f47730b, null);
            this.f47729a = 1;
            if (BuildersKt.e(mainCoroutineDispatcher, anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
