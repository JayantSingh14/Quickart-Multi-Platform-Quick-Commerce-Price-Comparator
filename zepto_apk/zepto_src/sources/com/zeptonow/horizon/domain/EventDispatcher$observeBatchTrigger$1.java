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
import kotlinx.coroutines.CoroutineScopeKt;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$observeBatchTrigger$1", f = "EventDispatcher.kt", l = {Type.CDS}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventDispatcher$observeBatchTrigger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47943a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventDispatcher f47944b;

    @Metadata
    @DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$observeBatchTrigger$1$1", f = "EventDispatcher.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$observeBatchTrigger$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<EventType, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f47945a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f47946b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EventDispatcher f47947c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EventDispatcher eventDispatcher, Continuation continuation) {
            super(2, continuation);
            this.f47947c = eventDispatcher;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f47947c, continuation);
            anonymousClass1.f47946b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((EventType) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f47945a;
            if (i2 == 0) {
                ResultKt.b(obj);
                final EventType eventType = (EventType) this.f47946b;
                EventDispatcher eventDispatcher = this.f47947c;
                eventDispatcher.f47912f.a(LogLevel.f48265c, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventDispatcher.observeBatchTrigger.1.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return "EventDispatcher:: Process, type= " + eventType;
                    }
                });
                this.f47945a = 1;
                if (eventDispatcher.f47908b.c(eventType, this) == coroutineSingletons) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventDispatcher$observeBatchTrigger$1(EventDispatcher eventDispatcher, Continuation continuation) {
        super(2, continuation);
        this.f47944b = eventDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventDispatcher$observeBatchTrigger$1(this.f47944b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventDispatcher$observeBatchTrigger$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2 = CoroutineSingletons.f53689a;
        int i2 = this.f47943a;
        if (i2 == 0) {
            ResultKt.b(obj);
            EventDispatcher eventDispatcher = this.f47944b;
            EventTypesChannel eventTypesChannel = eventDispatcher.f47913g;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(eventDispatcher, null);
            this.f47943a = 1;
            eventTypesChannel.getClass();
            Object objC = CoroutineScopeKt.c(new EventTypesChannel$collect$2(eventTypesChannel, anonymousClass1, null), this);
            if (objC != obj2) {
                objC = Unit.f53572a;
            }
            if (objC == obj2) {
                return obj2;
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
