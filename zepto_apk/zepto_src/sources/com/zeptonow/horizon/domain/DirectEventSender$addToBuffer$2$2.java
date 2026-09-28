package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.sync.MutexImpl;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.DirectEventSender$addToBuffer$2$2", f = "DirectEventSender.kt", l = {WKSRecord.Service.HOSTS2_NS, 156}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes4.dex */
final class DirectEventSender$addToBuffer$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public MutexImpl f47882a;

    /* renamed from: b, reason: collision with root package name */
    public DirectEventSender f47883b;

    /* renamed from: c, reason: collision with root package name */
    public EventType f47884c;

    /* renamed from: d, reason: collision with root package name */
    public int f47885d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ DirectEventSender f47886e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ EventType f47887f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectEventSender$addToBuffer$2$2(DirectEventSender directEventSender, EventType eventType, Continuation continuation) {
        super(2, continuation);
        this.f47886e = directEventSender;
        this.f47887f = eventType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DirectEventSender$addToBuffer$2$2(this.f47886e, this.f47887f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DirectEventSender$addToBuffer$2$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutexImpl mutexImpl;
        EventType eventType;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47885d;
        DirectEventSender directEventSender = this.f47886e;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f47885d = 1;
            if (DelayKt.a(250L, this) != coroutineSingletons) {
            }
            return coroutineSingletons;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eventType = this.f47884c;
            directEventSender = this.f47883b;
            mutexImpl = this.f47882a;
            ResultKt.b(obj);
            try {
                if (((List) directEventSender.f47871e.get(eventType)) != null && (!r3.isEmpty())) {
                    directEventSender.b(eventType);
                }
                Unit unit = Unit.f53572a;
                mutexImpl.b(null);
                return Unit.f53572a;
            } catch (Throwable th) {
                mutexImpl.b(null);
                throw th;
            }
        }
        ResultKt.b(obj);
        mutexImpl = directEventSender.f47870d;
        this.f47882a = mutexImpl;
        this.f47883b = directEventSender;
        EventType eventType2 = this.f47887f;
        this.f47884c = eventType2;
        this.f47885d = 2;
        if (mutexImpl.c(this) != coroutineSingletons) {
            eventType = eventType2;
            if (((List) directEventSender.f47871e.get(eventType)) != null) {
                directEventSender.b(eventType);
            }
            Unit unit2 = Unit.f53572a;
            mutexImpl.b(null);
            return Unit.f53572a;
        }
        return coroutineSingletons;
    }
}
