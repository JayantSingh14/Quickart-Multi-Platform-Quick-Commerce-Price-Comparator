package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
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
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$flushEvents$1$1", f = "EventDispatcher.kt", l = {126}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventDispatcher$flushEvents$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47937a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventDispatcher f47938b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventType f47939c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDispatcher$flushEvents$1$1(EventDispatcher eventDispatcher, EventType eventType, Continuation continuation) {
        super(2, continuation);
        this.f47938b = eventDispatcher;
        this.f47939c = eventType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventDispatcher$flushEvents$1$1(this.f47938b, this.f47939c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventDispatcher$flushEvents$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47937a;
        if (i2 == 0) {
            ResultKt.b(obj);
            EventTypesChannel eventTypesChannel = this.f47938b.f47913g;
            this.f47937a = 1;
            if (eventTypesChannel.a(this.f47939c, this) == coroutineSingletons) {
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
