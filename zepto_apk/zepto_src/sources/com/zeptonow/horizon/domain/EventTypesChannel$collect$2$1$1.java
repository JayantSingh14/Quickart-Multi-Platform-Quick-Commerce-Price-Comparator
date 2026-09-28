package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.utils.LogLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventTypesChannel$collect$2$1$1", f = "EventTypesChannel.kt", l = {46}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventTypesChannel$collect$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f48054a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Channel f48055b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventTypesChannel f48056c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SuspendLambda f48057d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EventTypesChannel$collect$2$1$1(Channel channel, EventTypesChannel eventTypesChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f48055b = channel;
        this.f48056c = eventTypesChannel;
        this.f48057d = (SuspendLambda) function2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventTypesChannel$collect$2$1$1(this.f48055b, this.f48056c, this.f48057d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventTypesChannel$collect$2$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f48054a;
        if (i2 == 0) {
            ResultKt.b(obj);
            Flow flowM = FlowKt.m(this.f48055b);
            FlowCollector flowCollector = new FlowCollector(this.f48057d) { // from class: com.zeptonow.horizon.domain.EventTypesChannel$collect$2$1$1.1

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ SuspendLambda f48059b;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f48059b = (SuspendLambda) function2;
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object a(Object obj2, Continuation continuation) {
                    final EventType eventType = (EventType) obj2;
                    this.f48058a.f48049a.a(LogLevel.f48265c, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventTypesChannel.collect.2.1.1.1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return "EventTypesChannel:: Receive, type = " + eventType;
                        }
                    });
                    Object objInvoke = this.f48059b.invoke(eventType, continuation);
                    return objInvoke == CoroutineSingletons.f53689a ? objInvoke : Unit.f53572a;
                }
            };
            this.f48054a = 1;
            if (flowM.c(flowCollector, this) == coroutineSingletons) {
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
