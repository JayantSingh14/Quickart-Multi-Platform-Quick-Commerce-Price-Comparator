package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.storage.EventStorage;
import com.zeptonow.horizon.storage.PersistentStorage$hasFailedEvents$$inlined$map$1;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1", f = "EventDispatcher.kt", l = {49}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class EventDispatcher$setupRetryProcessing$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47966a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventDispatcher f47967b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventType f47968c;

    @Metadata
    @DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$1", f = "EventDispatcher.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ boolean f47969a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ boolean f47970b;

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            boolean zBooleanValue2 = ((Boolean) obj2).booleanValue();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(3, (Continuation) obj3);
            anonymousClass1.f47969a = zBooleanValue;
            anonymousClass1.f47970b = zBooleanValue2;
            return anonymousClass1.invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            ResultKt.b(obj);
            return Boolean.valueOf(this.f47969a && this.f47970b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDispatcher$setupRetryProcessing$1$1(EventDispatcher eventDispatcher, EventType eventType, Continuation continuation) {
        super(2, continuation);
        this.f47967b = eventDispatcher;
        this.f47968c = eventType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventDispatcher$setupRetryProcessing$1$1(this.f47967b, this.f47968c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventDispatcher$setupRetryProcessing$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47966a;
        if (i2 == 0) {
            ResultKt.b(obj);
            final EventDispatcher eventDispatcher = this.f47967b;
            EventStorage eventStorage = eventDispatcher.f47909c;
            final EventType eventType = this.f47968c;
            final PersistentStorage$hasFailedEvents$$inlined$map$1 persistentStorage$hasFailedEvents$$inlined$map$1A = eventStorage.a(eventType);
            final StateFlow stateFlowIsConnected = eventDispatcher.f47911e.isConnected();
            final AnonymousClass1 anonymousClass1 = new AnonymousClass1(3, null);
            final Flow flowE = FlowKt.e(new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1
                @Override // kotlinx.coroutines.flow.Flow
                public final Object c(FlowCollector flowCollector, Continuation continuation) {
                    Object objA = CombineKt.a(continuation, FlowKt__ZipKt$nullArrayFactory$1.f54876a, new FlowKt__ZipKt$combine$1$1(anonymousClass1, null), flowCollector, new Flow[]{persistentStorage$hasFailedEvents$$inlined$map$1A, stateFlowIsConnected});
                    return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
                }
            });
            Flow flowD = FlowKt.d(new Flow<Boolean>() { // from class: com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1

                @Metadata
                @SourceDebugExtension
                /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                public final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ FlowCollector f47928a;

                    @Metadata
                    @DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1$2", f = "EventDispatcher.kt", l = {219}, m = "emit")
                    @SourceDebugExtension
                    /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    public final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: a, reason: collision with root package name */
                        public /* synthetic */ Object f47929a;

                        /* renamed from: b, reason: collision with root package name */
                        public int f47930b;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f47929a = obj;
                            this.f47930b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.a(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.f47928a = flowCollector;
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
                            boolean r0 = r6 instanceof com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r6
                            com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f47930b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f47930b = r1
                            goto L18
                        L13:
                            com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r6)
                        L18:
                            java.lang.Object r6 = r0.f47929a
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                            int r2 = r0.f47930b
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
                            java.lang.Boolean r6 = (java.lang.Boolean) r6
                            boolean r6 = r6.booleanValue()
                            if (r6 == 0) goto L46
                            r0.f47930b = r3
                            kotlinx.coroutines.flow.FlowCollector r6 = r4.f47928a
                            java.lang.Object r5 = r6.a(r5, r0)
                            if (r5 != r1) goto L46
                            return r1
                        L46:
                            kotlin.Unit r5 = kotlin.Unit.f53572a
                            return r5
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public final Object c(FlowCollector flowCollector, Continuation continuation) {
                    Object objC = flowE.c(new AnonymousClass2(flowCollector), continuation);
                    return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
                }
            }, eventDispatcher.f47907a.f48085e);
            FlowCollector flowCollector = new FlowCollector() { // from class: com.zeptonow.horizon.domain.EventDispatcher$setupRetryProcessing$1$1.3
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object a(Object obj2, Continuation continuation) {
                    final boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                    EventDispatcher eventDispatcher2 = eventDispatcher;
                    eventDispatcher2.f47912f.a(LogLevel.f48265c, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventDispatcher.setupRetryProcessing.1.1.3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return "EventDispatcher:: Process req via failed events, type = " + zBooleanValue;
                        }
                    });
                    Object objA = eventDispatcher2.f47914h.a(eventType, continuation);
                    return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
                }
            };
            this.f47966a = 1;
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
