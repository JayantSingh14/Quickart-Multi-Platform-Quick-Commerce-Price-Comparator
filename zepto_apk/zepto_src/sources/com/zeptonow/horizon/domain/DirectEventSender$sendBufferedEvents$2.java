package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.entity.EventType;
import com.zeptonow.horizon.network.NetworkClient;
import com.zeptonow.horizon.utils.LogLevel;
import com.zeptonow.horizon.utils.LoggerHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.DirectEventSender$sendBufferedEvents$2", f = "DirectEventSender.kt", l = {107}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class DirectEventSender$sendBufferedEvents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47894a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DirectEventSender f47895b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f47896c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EventType f47897d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectEventSender$sendBufferedEvents$2(DirectEventSender directEventSender, List list, EventType eventType, Continuation continuation) {
        super(2, continuation);
        this.f47895b = directEventSender;
        this.f47896c = list;
        this.f47897d = eventType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DirectEventSender$sendBufferedEvents$2(this.f47895b, this.f47896c, this.f47897d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DirectEventSender$sendBufferedEvents$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objB;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47894a;
        final List list = this.f47896c;
        DirectEventSender directEventSender = this.f47895b;
        if (i2 == 0) {
            ResultKt.b(obj);
            NetworkClient networkClient = directEventSender.f47867a;
            this.f47894a = 1;
            objB = networkClient.b(list, this);
            if (objB == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            objB = ((Result) obj).f53539a;
        }
        Result.Companion companion = Result.f53538b;
        boolean z = objB instanceof Result.Failure;
        final EventType eventType = this.f47897d;
        if (!z) {
            directEventSender.f47868b.a(LogLevel.f48265c, new Function0<String>() { // from class: com.zeptonow.horizon.domain.DirectEventSender$sendBufferedEvents$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "DirectEventSender:: " + eventType + " batch sent successfully, " + LoggerHelper.a(list);
                }
            });
        }
        final Throwable thA = Result.a(objB);
        if (thA != null) {
            directEventSender.f47868b.a(LogLevel.f48265c, new Function0<String>() { // from class: com.zeptonow.horizon.domain.DirectEventSender$sendBufferedEvents$2$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "DirectEventSender:: " + eventType + " batch failed, " + LoggerHelper.a(list) + ", error: " + thA.getMessage();
                }
            });
        }
        return Unit.f53572a;
    }
}
