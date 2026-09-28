package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.storage.EventStorage;
import com.zeptonow.horizon.storage.PersistentStorage$getPendingCount$$inlined$map$1;
import com.zeptonow.horizon.utils.DefaultLogger;
import com.zeptonow.horizon.utils.LogLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1", f = "EventDispatcher.kt", l = {116}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class EventDispatcher$setupTimerTrigger$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47974a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventDispatcher f47975b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventType f47976c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDispatcher$setupTimerTrigger$1$1(EventDispatcher eventDispatcher, EventType eventType, Continuation continuation) {
        super(2, continuation);
        this.f47975b = eventDispatcher;
        this.f47976c = eventType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventDispatcher$setupTimerTrigger$1$1(this.f47975b, this.f47976c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventDispatcher$setupTimerTrigger$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47974a;
        if (i2 == 0) {
            ResultKt.b(obj);
            final EventDispatcher eventDispatcher = this.f47975b;
            EventStorage eventStorage = eventDispatcher.f47909c;
            final EventType eventType = this.f47976c;
            final PersistentStorage$getPendingCount$$inlined$map$1 persistentStorage$getPendingCount$$inlined$map$1F = eventStorage.f(eventType);
            Flow flowD = FlowKt.d(new Flow<Integer>() { // from class: com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1

                @Metadata
                @SourceDebugExtension
                /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                public final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ FlowCollector f47933a;

                    @Metadata
                    @DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1$2", f = "EventDispatcher.kt", l = {219}, m = "emit")
                    @SourceDebugExtension
                    /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    public final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: a, reason: collision with root package name */
                        public /* synthetic */ Object f47934a;

                        /* renamed from: b, reason: collision with root package name */
                        public int f47935b;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f47934a = obj;
                            this.f47935b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.a(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.f47933a = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                        /*
                            r4 = this;
                            boolean r0 = r6 instanceof com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f47935b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f47935b = r1
                            goto L18
                        L13:
                            com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.f47934a
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                            int r2 = r0.f47935b
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            kotlin.ResultKt.b(r6)
                            goto L46
                        L27:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L2f:
                            kotlin.ResultKt.b(r6)
                            r6 = r5
                            java.lang.Number r6 = (java.lang.Number) r6
                            int r6 = r6.intValue()
                            if (r6 <= 0) goto L46
                            r0.f47935b = r3
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.f47933a
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L46
                            return r1
                        L46:
                            kotlin.Unit r5 = kotlin.Unit.f53572a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public final Object c(FlowCollector flowCollector, Continuation continuation) {
                    Object objC = persistentStorage$getPendingCount$$inlined$map$1F.c(new AnonymousClass2(flowCollector), continuation);
                    return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
                }
            }, eventDispatcher.f47907a.f48084d);
            FlowCollector flowCollector = new FlowCollector() { // from class: com.zeptonow.horizon.domain.EventDispatcher$setupTimerTrigger$1$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object a(Object obj2, Continuation continuation) {
                    ((Number) obj2).intValue();
                    EventDispatcher eventDispatcher2 = eventDispatcher;
                    DefaultLogger defaultLogger = eventDispatcher2.f47912f;
                    LogLevel logLevel = LogLevel.f48265c;
                    final EventType eventType2 = eventType;
                    defaultLogger.a(logLevel, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventDispatcher.setupTimerTrigger.1.1.2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return "EventDispatcher:: Process req via time, type = " + eventType2;
                        }
                    });
                    Object objA = eventDispatcher2.f47913g.a(eventType2, continuation);
                    return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
                }
            };
            this.f47974a = 1;
            if (flowD.c(flowCollector, this) == coroutineSingletons) {
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
