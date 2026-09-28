package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.storage.EventEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.DirectEventSender$sendEvent$2", f = "DirectEventSender.kt", l = {Type.TALINK}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class DirectEventSender$sendEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47904a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DirectEventSender f47905b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventEntity f47906c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectEventSender$sendEvent$2(DirectEventSender directEventSender, EventEntity eventEntity, Continuation continuation) {
        super(2, continuation);
        this.f47905b = directEventSender;
        this.f47906c = eventEntity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DirectEventSender$sendEvent$2(this.f47905b, this.f47906c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DirectEventSender$sendEvent$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47904a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f47904a = 1;
            if (DirectEventSender.a(this.f47905b, this.f47906c, this) == coroutineSingletons) {
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
