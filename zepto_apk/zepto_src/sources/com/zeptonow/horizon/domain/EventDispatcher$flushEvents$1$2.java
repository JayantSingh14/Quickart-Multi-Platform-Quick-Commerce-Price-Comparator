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
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$flushEvents$1$2", f = "EventDispatcher.kt", l = {WKSRecord.Service.LOCUS_CON}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventDispatcher$flushEvents$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47940a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventDispatcher f47941b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventType f47942c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDispatcher$flushEvents$1$2(EventDispatcher eventDispatcher, EventType eventType, Continuation continuation) {
        super(2, continuation);
        this.f47941b = eventDispatcher;
        this.f47942c = eventType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventDispatcher$flushEvents$1$2(this.f47941b, this.f47942c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventDispatcher$flushEvents$1$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47940a;
        if (i2 == 0) {
            ResultKt.b(obj);
            EventTypesChannel eventTypesChannel = this.f47941b.f47914h;
            this.f47940a = 1;
            if (eventTypesChannel.a(this.f47942c, this) == coroutineSingletons) {
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
