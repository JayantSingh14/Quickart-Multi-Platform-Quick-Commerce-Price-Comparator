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
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$observeBatchTrigger$2", f = "EventDispatcher.kt", l = {WKSRecord.Protocol.RVD}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventDispatcher$observeBatchTrigger$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47949a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventDispatcher f47950b;

    @Metadata
    @DebugMetadata(c = "com.zeptonow.horizon.domain.EventDispatcher$observeBatchTrigger$2$1", f = "EventDispatcher.kt", l = {WKSRecord.Service.BOOTPC}, m = "invokeSuspend")
    /* renamed from: com.zeptonow.horizon.domain.EventDispatcher$observeBatchTrigger$2$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<EventType, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f47951a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f47952b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ EventDispatcher f47953c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EventDispatcher eventDispatcher, Continuation continuation) {
            super(2, continuation);
            this.f47953c = eventDispatcher;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f47953c, continuation);
            anonymousClass1.f47952b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((EventType) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f47951a;
            if (i2 == 0) {
                ResultKt.b(obj);
                final EventType eventType = (EventType) this.f47952b;
                EventDispatcher eventDispatcher = this.f47953c;
                eventDispatcher.f47912f.a(LogLevel.f48265c, new Function0<String>() { // from class: com.zeptonow.horizon.domain.EventDispatcher.observeBatchTrigger.2.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return "EventDispatcher:: Process failed, type= " + eventType;
                    }
                });
                this.f47951a = 1;
                if (eventDispatcher.a(eventType, this) == coroutineSingletons) {
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
    public EventDispatcher$observeBatchTrigger$2(EventDispatcher eventDispatcher, Continuation continuation) {
        super(2, continuation);
        this.f47950b = eventDispatcher;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventDispatcher$observeBatchTrigger$2(this.f47950b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventDispatcher$observeBatchTrigger$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2 = CoroutineSingletons.f53689a;
        int i2 = this.f47949a;
        if (i2 == 0) {
            ResultKt.b(obj);
            EventDispatcher eventDispatcher = this.f47950b;
            EventTypesChannel eventTypesChannel = eventDispatcher.f47914h;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(eventDispatcher, null);
            this.f47949a = 1;
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
