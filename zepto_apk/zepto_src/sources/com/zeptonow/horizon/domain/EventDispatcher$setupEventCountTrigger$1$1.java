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

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1", f = "EventDispatcher.kt", l = {99}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes.dex */
final class EventDispatcher$setupEventCountTrigger$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47960a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventDispatcher f47961b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventType f47962c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDispatcher$setupEventCountTrigger$1$1(EventDispatcher eventDispatcher, EventType eventType, Continuation continuation) {
        super(2, continuation);
        this.f47961b = eventDispatcher;
        this.f47962c = eventType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventDispatcher$setupEventCountTrigger$1$1(this.f47961b, this.f47962c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventDispatcher$setupEventCountTrigger$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47960a;
        if (i2 == 0) {
            ResultKt.b(obj);
            final EventDispatcher eventDispatcher = this.f47961b;
            EventStorage eventStorage = eventDispatcher.f47909c;
            final EventType eventType = this.f47962c;
            final PersistentStorage$getPendingCount$$inlined$map$1 persistentStorage$getPendingCount$$inlined$map$1F = eventStorage.f(eventType);
            Flow<Integer> flow = new Flow<Integer>() { // from class: com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1

                @Metadata
                @SourceDebugExtension
                /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                public final class AnonymousClass2<T> implements FlowCollector {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ FlowCollector f47918a;

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ EventDispatcher f47919b;

                    /* renamed from: c, reason: collision with root package name */
                    public final /* synthetic */ EventType f47920c;

                    @Metadata
                    @DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1$2", f = "EventDispatcher.kt", l = {220, 219}, m = "emit")
                    @SourceDebugExtension
                    /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    public final class AnonymousClass1 extends ContinuationImpl {

                        /* renamed from: a, reason: collision with root package name */
                        public /* synthetic */ Object f47921a;

                        /* renamed from: b, reason: collision with root package name */
                        public int f47922b;

                        /* renamed from: c, reason: collision with root package name */
                        public Object f47923c;

                        /* renamed from: d, reason: collision with root package name */
                        public FlowCollector f47924d;

                        /* renamed from: f, reason: collision with root package name */
                        public int f47926f;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f47921a = obj;
                            this.f47922b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.a(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, EventDispatcher eventDispatcher, EventType eventType) {
                        this.f47918a = flowCollector;
                        this.f47919b = eventDispatcher;
                        this.f47920c = eventType;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
                    
                        if (r2.a(r4, r0) == r1) goto L24;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object a(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                        /*
                            r6 = this;
                            boolean r0 = r8 instanceof com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r8
                            com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f47922b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f47922b = r1
                            goto L18
                        L13:
                            com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1$2$1
                            r0.<init>(r8)
                        L18:
                            java.lang.Object r8 = r0.f47921a
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
                            int r2 = r0.f47922b
                            r3 = 2
                            r4 = 1
                            if (r2 == 0) goto L3c
                            if (r2 == r4) goto L32
                            if (r2 != r3) goto L2a
                            kotlin.ResultKt.b(r8)
                            goto L77
                        L2a:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r8)
                            throw r7
                        L32:
                            int r7 = r0.f47926f
                            kotlinx.coroutines.flow.FlowCollector r2 = r0.f47924d
                            java.lang.Object r4 = r0.f47923c
                            kotlin.ResultKt.b(r8)
                            goto L61
                        L3c:
                            kotlin.ResultKt.b(r8)
                            r8 = r7
                            java.lang.Number r8 = (java.lang.Number) r8
                            int r8 = r8.intValue()
                            com.zeptonow.horizon.domain.EventDispatcher r2 = r6.f47919b
                            com.zeptonow.horizon.domain.EventProcessor r2 = r2.f47908b
                            r0.f47923c = r7
                            kotlinx.coroutines.flow.FlowCollector r5 = r6.f47918a
                            r0.f47924d = r5
                            r0.f47926f = r8
                            r0.f47922b = r4
                            com.zeptonow.horizon.entity.EventType r4 = r6.f47920c
                            java.lang.Object r2 = r2.a(r4, r0)
                            if (r2 != r1) goto L5d
                            goto L76
                        L5d:
                            r4 = r7
                            r7 = r8
                            r8 = r2
                            r2 = r5
                        L61:
                            java.lang.Number r8 = (java.lang.Number) r8
                            int r8 = r8.intValue()
                            if (r7 < r8) goto L77
                            r7 = 0
                            r0.f47923c = r7
                            r0.f47924d = r7
                            r0.f47922b = r3
                            java.lang.Object r7 = r2.a(r4, r0)
                            if (r7 != r1) goto L77
                        L76:
                            return r1
                        L77:
                            kotlin.Unit r7 = kotlin.Unit.f53572a
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.a(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public final Object c(FlowCollector flowCollector, Continuation continuation) {
                    Object objC = persistentStorage$getPendingCount$$inlined$map$1F.c(new AnonymousClass2(flowCollector, eventDispatcher, eventType), continuation);
                    return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
                }
            };
            FlowCollector flowCollector = new FlowCollector() { // from class: com.zeptonow.horizon.domain.EventDispatcher$setupEventCountTrigger$1$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object a(Object obj2, Continuation continuation) {
                    ((Number) obj2).intValue();
                    EventDispatcher eventDispatcher2 = eventDispatcher;
                    DefaultLogger defaultLogger = eventDispatcher2.f47912f;
                    LogLevel logLevel = LogLevel.f48265c;
                    final EventType eventType2 = eventType;
                    defaultLogger.a(logLevel, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventDispatcher.setupEventCountTrigger.1.1.2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return "EventDispatcher:: Process req via count, type = " + eventType2;
                        }
                    });
                    Object objA = eventDispatcher2.f47913g.a(eventType2, continuation);
                    return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
                }
            };
            this.f47960a = 1;
            if (flow.c(flowCollector, this) == coroutineSingletons) {
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
